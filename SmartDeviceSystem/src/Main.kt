fun main() {
    val home: SmartHome = SmartHome()

    val tv = SmartTvDevice("aap", "woonkamer")
    val light01 = SmartLightDevice("Lamp1", "woonkamer")
    val light02 = SmartLightDevice("Lamp2", "woonkamer")

    home.addDevice(tv);
    home.addDevice(light01);
    home.addDevice(light02);

    home.decreaseBrightness()
    home.decreaseTvVolume()
    home.printSmartTvInfo()
    home.printSmartLightInfo()
    home.activeLights()
}

abstract class SmartDevice(val name: String, val category: String, val deviceType: deviceType) {
    private var deviceStatus: Boolean = false;

    fun updateDeviceStatus() {
        deviceStatus = !deviceStatus;
    }

    fun printDeviceStatus() {
        printDeviceInfo();
        print(deviceStatus);
        println()
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

enum class deviceType {
    TV, LIGHT
}

class SmartTvDevice(name: String, category: String) : SmartDevice(name, category, deviceType.TV) {
    var volume: Double = 1.0;

    fun decreaseVolume() {
        volume -= 0.2;
    }

    fun previousChannel() {
        println("navigate to previous channel")
    }
}

class SmartLightDevice(name: String, category: String) : SmartDevice(name, category, deviceType.LIGHT) {
    fun decreaseBrightness() {
        println("Decreasing Brightness")
    }
}

class SmartHome() {

    private val devices: MutableList<SmartDevice> = mutableListOf();

    fun addDevice(device: SmartDevice) {
        devices.add(device);
    }

    fun decreaseBrightness() {
        println("Decreasing Brightness")
    }

    fun decreaseTvVolume() {
        devices.filterIsInstance<SmartTvDevice>().forEach { it.decreaseVolume() }
    }

    fun changeTvChannelToPrevious() {
        devices.filterIsInstance<SmartTvDevice>().forEach { it.previousChannel() }
    }

    fun printSmartTvInfo() {
        devices.filterIsInstance<SmartTvDevice>().forEach { it.printDeviceInfo() }
    }

    fun printSmartLightInfo() {
        devices.filterIsInstance<SmartLightDevice>().forEach { it.printDeviceInfo() }
    }

    fun decreaseLightBrightness() {
        devices.filterIsInstance<SmartLightDevice>().forEach { it.decreaseBrightness() }
    }

    fun activeLights() {
        devices.forEach {
            if (it.deviceType == deviceType.LIGHT) {
                it.updateDeviceStatus()
            }; it.printDeviceStatus()
        }
    }

}