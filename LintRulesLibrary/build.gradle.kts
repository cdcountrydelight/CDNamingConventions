plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("maven-publish")
    id("com.android.lint")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly("com.android.tools.lint:lint-api:31.5.1")
}

afterEvaluate {
    with(publishing) {
        publications {
            create<MavenPublication>("mavenJava") {
                pom {
                    name = "CdNamingRules"
                }
                groupId = "com.github.cdcountrydelight"
                artifactId = "CDNamingConventions"
                version = "1.0.5"
                from(components["java"])
            }
        }
    }
}


