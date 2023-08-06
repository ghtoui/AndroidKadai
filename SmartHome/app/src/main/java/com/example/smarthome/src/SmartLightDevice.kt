package com.example.smarthome.src


class SmartLightDevice(name: String, category: String): SmartDevice(name = name, category = category) {
    override val deviceType = "smartLightDevice"
    private var brightness by RangeRegulator(initialValue = 10, maxValue = 100, minValue = 0)

    fun decreaseBrightness() {
    brightness --
    }
}