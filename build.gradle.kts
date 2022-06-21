// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application) version PluginVersions.gradle apply false
    id(Plugins.gradle) version PluginVersions.gradle apply false
    id(Plugins.kotlinAndroid) version PluginVersions.kotlin apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}