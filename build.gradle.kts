plugins {
    id("com.android.application") version "8.7.3" apply false
    id("com.android.library") version "8.7.3" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.28" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("com.google.firebase.crashlytics") version "3.0.2" apply false
}
tasks.register("verifyNoWebFiles") {
    doLast {
        val forbidden = listOf("web-portal", "index.html", ".html", ".css", ".js", ".jsx", ".tsx")
        val root = project.rootDir
        root.walkTopDown().forEach { f ->
            if (f.isFile && forbidden.any { f.name.endsWith(it) || f.name.contains(it) }) {
                throw GradleException("FORBIDDEN WEB FILE FOUND: ${f.relativeTo(root)}")
            }
        }
        println("verifyNoWebFiles: PASS (zero web files)")
    }
}