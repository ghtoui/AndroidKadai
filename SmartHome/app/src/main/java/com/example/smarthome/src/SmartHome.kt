package com.example.smarthome.src

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SmartHome(val smartTv: SmartTvDevice, val smartLight: SmartLightDevice) {
    private var deviceTurnOnCount: Int = 0

    fun smartTvTurnOn() {
        if (!smartTv.getDeviceStatus()) {
            smartTv.turnOn()
            deviceTurnOnCount ++
        }
    }

    fun smartLightTurnOn() {
        if (!smartLight.getDeviceStatus()) {
            smartLight.turnOn()
            deviceTurnOnCount ++
        }
    }

    fun smartTvTurnOff() {
        if (smartTv.getDeviceStatus()) {
            smartTv.turnOff()
            deviceTurnOnCount --
        }
    }

    fun smartLightTurnOff() {
        if (smartLight.getDeviceStatus()) {
            smartLight.turnOff()
            deviceTurnOnCount--
        }
    }

    fun decreaseTvVolume() {
        if (!smartTv.getDeviceStatus()) {
            return
        }
        smartTv.decreaseVolume()
    }

    fun decreaseTvChannnelToPrevious() {
        if (!smartTv.getDeviceStatus()) {
            return
        }
        smartTv.previousChannel()
    }

    fun printSmartTvInfo() {
        if (!smartTv.getDeviceStatus()) {
            return
        }
        smartTv.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        if (!smartLight.getDeviceStatus()) {
            return
        }
        smartLight.printDeviceInfo()
    }

    fun decreaseLightBrightness() {
        if (!smartLight.getDeviceStatus()) {
            return
        }
        smartLight.decreaseBrightness()
    }
}