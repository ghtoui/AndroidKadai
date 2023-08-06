package com.example.smarthome.src

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice (val name: String, val category: String) {
    open protected val deviceType = ""
    protected var deviceStatus = "off"

    fun getDeviceStatus(): Boolean {
        return when(deviceStatus) {
            "on" -> true
            else -> false
        }
    }
    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }

    fun turnOn() {
        deviceStatus = "on"
        println("$name : online")
    }
    fun turnOff() {
        deviceStatus = "off"
        println("$name : offline")
    }
}
class RangeRegulator(
    initialValue: Int,
    private val maxValue: Int,
    private val minValue: Int
) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            println("$fieldData から$value へ変更しました")
            fieldData = value
        }
    }
}