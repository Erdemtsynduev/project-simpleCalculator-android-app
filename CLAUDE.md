# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Run unit tests (JVM)
./gradlew test

# Run a single unit test class
./gradlew test --tests "com.erdemtsynduev.simplecalculator.ExampleUnitTest"

# Run instrumented tests (requires connected device/emulator)
./gradlew connectedAndroidTest

# Clean build
./gradlew clean

# Install debug build on connected device
./gradlew installDebug
```

## Architecture

Single-module Android app (`:app`) using Jetpack Compose with Material3.

- **`MainActivity.kt`** — Entry point; sets up the Compose content tree.
- **`ui/theme/`** — Theme, color palette, and typography definitions.

**Known issue**: The theme files (`Theme.kt`, `Color.kt`, `Type.kt`) use the package `com.erdemtsynduev.waterreminder.ui.theme` and expose `WaterReminderTheme` — this is a copy-paste artifact from another project and should eventually be renamed to `com.erdemtsynduev.simplecalculator.ui.theme` with `SimpleCalculatorTheme`.

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose + Material3
- **Min SDK**: 24 / Target SDK: 34
- **Build**: Gradle Kotlin DSL (`build.gradle.kts`)
- **Compose BOM**: `2023.08.00`, compiler extension `1.5.3`
- **Application ID**: `com.erdemtsynduev.simplecalculator`

## Design Reference

UI design: https://dribbble.com/shots/13632144-Daily-UI-004-Calculator
