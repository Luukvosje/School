# Kotlin SmartHome Application

Een console-gebaseerde **SmartHome applicatie** geschreven in **Kotlin**.  
Het project laat zien hoe **objectgeoriënteerd programmeren (OO)** en **functioneel programmeren (FP)** gecombineerd kunnen worden in één applicatie.

---

## Functies

- Beheer van verschillende smart devices:
    - **Smart TV**: volume verlagen, naar vorige kanaal navigeren.
    - **Smart Light**: helderheid verlagen.
- Console commands via de `SmartHome` class:
    - `decreaseTvVolume()`
    - `changeTvChannelToPrevious()`
    - `printSmartTvInfo()`
    - `printSmartLightInfo()`
    - `decreaseLightBrightness()`
- Meerdere devices toevoegen aan het SmartHome.
- Automatische filtering en type-specifieke acties voor devices.

---

## Objectgeoriënteerd programmeren (OO)

Het project gebruikt OO-concepten op de volgende manier:

- **Abstracte basisclass (`SmartDevice`)**:
    - Bevat gemeenschappelijke eigenschappen en methodes voor alle devices (`name`, `category`, `deviceType`, `printDeviceInfo()`).
- **Overerving**:
    - `SmartTvDevice` en `SmartLightDevice` erven van `SmartDevice`.
    - Zo kunnen beide device-types hun eigen specifieke methodes hebben, terwijl ze toch gedeelde functionaliteit gebruiken.
- **Encapsulation**:
    - Device-specific properties zoals `volume` of `brightness` zitten in hun eigen klasse.
    - Methoden zoals `decreaseVolume()` en `decreaseBrightness()` zorgen dat interne state veilig aangepast wordt.
- **Enum (`deviceType`)**:
    - Type-safe manier om verschillende device types te onderscheiden.

---

## Functioneel programmeren (FP)

Het project gebruikt FP-concepten op de volgende manier:

- **`filterIsInstance<T>()`**:
    - Alle devices in SmartHome kunnen gefilterd worden op type (TV of Light).
- **`forEach`**:
    - Acties zoals volume verlagen of helderheid aanpassen worden functioneel op de gefilterde lijst uitgevoerd.
- **Immutable operations (waar mogelijk)**:
    - Print- en filteracties gebruiken tijdelijke resultaten zonder de originele lijst te wijzigen.
- **Combinatie van FP-methodes**:
    - `devices.filterIsInstance<SmartTvDevice>().forEach { it.decreaseVolume() }`  
      → compacte, leesbare manier om type-specifieke acties uit te voeren.

---

## Installatie & Gebruik

1. Zorg dat je **Kotlin** en **JDK 8+** geïnstalleerd hebt.
2. Clone dit project of kopieer de `SmartHome.kt` code.
3. Compileer en run in de console:

```bash
kotlinc SmartHome.kt -include-runtime -d SmartHome.jar
java -jar SmartHome.jar
