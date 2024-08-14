# CDNamingConventions

CDNamingConventions is a lint rule library for enforcing coding patterns in Android projects. It
provides custom lint rules that aim to improve code consistency and maintainability by enforcing
specific naming conventions and patterns.

![Platform](https://img.shields.io/badge/Platform-Android-darkcyan) &nbsp;
[![](https://jitpack.io/v/cdcountrydelight/CDNamingConventions.svg)](https://jitpack.io/#cdcountrydelight/CDNamingConventions)
&nbsp;
![Language](https://img.shields.io/badge/Language-Kotlin-blue)

## Naming Rules

CDNamingConventions enforces the following coding patterns:

- **Java + Kotlin**

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

  - MutableLiveData/LiveData variables must end with **`LiveData`**.

  - Use of nested loops should be avoided, instead use kotlin extension functions.

  - Every Function must specify the comment.
  
  - Use **`DataBinding/ViewBinding`** instead of findVIewById().

  - Function length should be at max **`100`** lines, try to break larger functions into smaller sub functions.

  - A Function must properly handle exception throwing functions either in try catch or must specify the exception in their method signature.

  - Use of hardcoded literals must be avoided.

  - Global variable used inside single functions must be declared as local variable inside function.

  - Use **`@Upsert`** instead of **`@Insert(onConflict = OnConflictStrategy.REPLACE)`** for better performance.

  - Variables names must adhere the actual use case.

  - Boolean variables/Function must start with any of the following predefined words: **`is`**, **`has`**, **`should`**, **`can`**, **`whether`**, **`was`**, **`need`**, **`are`**

  - Use of Experimental compose api's is discouraged.

- **XML**

  - Element Id must end with underscore followed by capital letters in element , eg for
    LinearLayout , the provided id  must end with _ll .

    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/parent_ll"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
    </LinearLayout>
    ``` 

  - Layout file's name must start with  **`activity_`** for activity layout, **`fragment_`** for fragment layout, **`item_`** for recycler view's item, **`layout_`**  for any other layout.

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
  lintChecks("com.github.cdcountrydelight:CDNamingConventions:<latest-version>")
}
```
