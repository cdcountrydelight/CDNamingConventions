# CDNamingConventions

CDNamingConventions is a lint rule library for enforcing coding patterns in Android projects. It provides custom lint rules that aim to improve code consistency and maintainability by enforcing specific naming conventions and patterns.

## Features

CDNamingConventions enforces the following coding patterns:

- Activity names must end with "Activity".
- Fragment names must end with "Fragment".
- Interface names must start with "I".
- ViewModel class names must end with "ViewModel".
- State variable names must end with "State".
- StateFlow variable names must end with "StateFlow".
- ArrayList/MutableList variables must end with "List".
- Enum class names must end with "Enum".
- Application class names must end with "Application".
- BroadcastReceiver class names must end with "Receiver".
- Interface implementations must end with "Impl".
- Package names must be in "snake case".
- Room database class names must end with "Database".
- Dao class names must end with "Dao".
- Entity class names must end with "Entity".
- Map variable names must end with "Map".
- Service class names must end with "Service".
- Worker class names must end with "Worker".

## Installation

To install CDNamingConventions in your Android project :- , 

- Add the library in the project ( by simply downloading and copying it to project root level).
- Add the following dependency to your modules `build.gradle` file:

```gradle
dependencies {
    lintChecks(project( ":LintRulesLibrary"))
}