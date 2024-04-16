plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("maven-publish")
    id("com.android.lint")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly("com.android.tools.lint:lint-api:31.2.2")
}

afterEvaluate {
    with(publishing) {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.github.cdcountrydelight"
                artifactId = "CDNamingConventions"
                version = "1.0.0"
                from(components["java"])
            }
        }
    }
}


