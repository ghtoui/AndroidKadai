package com.example.smarthome.src

class SmartTvDevice(name: String, category: String): SmartDevice(name = name, category = category) {
    override val deviceType = "smartTvDevice"
    private var volume by RangeRegulator(initialValue = 10, maxValue = 100, minValue = 0)
    private var channel by RangeRegulator(initialValue = 10, maxValue = 100, minValue = 0)

    fun decreaseVolume() {
        volume --
    }
    fun previousChannel() {
        channel --
    }
}