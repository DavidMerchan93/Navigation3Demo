# Repository Guidelines

## Project Structure & Module Organization
This is a single-module Android app using Kotlin and Jetpack Compose.
- `app/src/main/java/com/davidmerchan/navigation3demo/`: Kotlin source.
  - `basicNavigation/`, `mediumNavigation/`, `advanceNavigation/`: navigation examples.
  - `screens/`: UI screens (e.g., `HomeScreen.kt`, `DetailScreen.kt`).
  - `ui/theme/`: Compose theme setup.
  - `utils/`: helpers and extensions.
- `app/src/main/res/`: resources (icons, themes, strings).
- `app/src/test/`: local unit tests (JUnit4).
- `app/src/androidTest/`: instrumented tests (AndroidX + Espresso/Compose).

## Build, Test, and Development Commands
Use the Gradle wrapper from the repo root:
- `./gradlew assembleDebug`: build a debug APK.
- `./gradlew installDebug`: install the debug build on a connected device/emulator.
- `./gradlew test`: run local unit tests.
- `./gradlew connectedAndroidTest`: run instrumented tests on a device/emulator.
- `./gradlew lint`: run Android lint checks.

## Coding Style & Naming Conventions
- Kotlin defaults: 4-space indentation, trailing commas where appropriate.
- Naming:
  - Composables and classes: `PascalCase` (e.g., `HomeScreen`).
  - Functions/vars: `camelCase`.
  - Navigation wrappers: `*NavigationWrapper` (see `basicNavigation/`).
- Keep Compose UI in `screens/` and theme in `ui/theme/`.

## Testing Guidelines
- Unit tests use JUnit4 under `app/src/test/`.
- Instrumented/UI tests use AndroidX test, Espresso, and Compose UI tests under `app/src/androidTest/`.
- No explicit coverage targets are defined; add tests for new navigation flows and UI behavior.

## Commit & Pull Request Guidelines
- Commit history follows Conventional Commits (e.g., `feat: add ...`). Use the same format.
- PRs should include: a concise summary, testing notes (`./gradlew test`, `connectedAndroidTest`), and screenshots or screen recordings for UI changes.

## Configuration Tips
- `local.properties` is expected to contain your Android SDK path; do not commit it.
