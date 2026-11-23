pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "WaqarComputerInstitute"
include(":app", ":ui-liquid-glass", ":core-crypto", ":native-cpp20", ":exam-engine", ":sandbox-runtime")