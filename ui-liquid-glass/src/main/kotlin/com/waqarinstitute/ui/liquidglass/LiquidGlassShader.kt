package com.waqarinstitute.ui.liquidglass

import android.graphics.RuntimeShader
import android.os.Build
import androidx.compose.ui.graphics.ShaderBrush

object LiquidGlassShader {
    private const val AGSL = """
        uniform float2 resolution;
        uniform float time;
        half4 main(float2 fragCoord) {
            float2 uv = fragCoord / resolution;
            float refract = sin(uv.x * 12.0 + time) * 0.02;
            half3 color = half3(0.15, 0.35, 0.85) + refract;
            float rim = smoothstep(0.9, 1.0, length(uv - 0.5));
            color += rim * 0.4;
            return half4(color, 0.75);
        }
    """

    fun brush(time: Float, width: Float, height: Float): ShaderBrush? {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return null
        val shader = RuntimeShader(AGSL)
        shader.setFloatUniform("resolution", width, height)
        shader.setFloatUniform("time", time)
        return ShaderBrush(shader)
    }
}