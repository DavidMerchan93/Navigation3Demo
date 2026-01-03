# Navigation3Demo

Demo de Android con Kotlin y Jetpack Compose que muestra varios enfoques de navegacion usando Navigation 3 (basico, medio y avanzado).

## Requisitos
- Android Studio (compatible con AGP 8.13+)
- JDK 17
- Android SDK configurado en `local.properties`

## Comandos principales
Desde la raiz del repo:
```bash
./gradlew assembleDebug      # Compila el APK debug
./gradlew installDebug       # Instala en un dispositivo/emulador
./gradlew test               # Tests unitarios
./gradlew connectedAndroidTest # Tests instrumentados
./gradlew lint               # Analisis estatico
```

## Estructura del proyecto
- `app/src/main/java/com/davidmerchan/navigation3demo/`
  - `basicNavigation/`, `mediumNavigation/`, `advanceNavigation/`: ejemplos de navegacion.
  - `screens/`: pantallas UI (Compose).
  - `ui/theme/`: tema de Compose.
  - `utils/`: utilidades.
- `app/src/main/res/`: recursos (icons, strings, themes).
- `app/src/test/`: tests unitarios (JUnit4).
- `app/src/androidTest/`: tests instrumentados (AndroidX, Espresso/Compose).

## Notas
- El flujo principal se inicia en `MainActivity` y actualmente apunta a `AdvanceNavigationWrapper`.
- No comites `local.properties`.
