# CDNamingConventions

CDNamingConventions is a lint rule library for enforcing coding patterns in Android projects. It provides custom lint rules that aim to improve code consistency and maintainability by enforcing specific naming conventions and patterns.

![Platform](https://img.shields.io/badge/Platform-Android-darkcyan) &nbsp;
[![](https://jitpack.io/v/cdcountrydelight/CDNamingConventions.svg)](https://jitpack.io/#cdcountrydelight/CDNamingConventions) &nbsp;
![Language](https://img.shields.io/badge/Language-Kotlin-blue)


## Naming Rules

CDNamingConventions enforces the following coding patterns:

- Activity names must end with **`Activity`**.
  
- Fragment names must end with **`Fragment`**.
  
- Interface names must start with **`I`**.
  
- ViewModel class names must end with **`ViewModel`**.
  
- State variable names must end with **`State`**.
  
- StateFlow variable names must end with **`StateFlow`**.
  
- ArrayList/MutableList variables must end with **`List`**.
  
- Enum class names must end with **`Enum`**.
  
- Application class names must end with **`Application`**.
  
- BroadcastReceiver class names must end with **`Receiver`**.
  
- Interface implementations must end with **`Impl`**.
  
- Package names must be in **`snake case`**.
  
- Room database class names must end with **`Database`**.
  
- Dao class names must end with **`Dao`**.
  
- Entity class names must end with **`Entity`**.
  
- Map variable names must end with **`Map`**.
  
- Service class names must end with **`Service`**.
  
- Worker class names must end with **`Worker`**.
  

## Installation


### Step 1: Add the JitPack repository to your build file

Add it in your `settings.gradle` file at the end of repositories:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
```

### Step 2: Add the dependency

Add it in your `build.gradle` (module level) file:

```kotlin
dependencies {
    lintChecks ("com.github.cdcountrydelight:CDNamingConventions:<latest-version>")
}
```
