package com.example.lambda.src

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if(isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(isScreenLightOn: Boolean = false, var isFoldable: Boolean = true): Phone(isScreenLightOn = isScreenLightOn) {
    fun foldable() {
        isFoldable = true
    }

    fun open() {
        isFoldable = false
    }

    override fun switchOn() {
        if (!isFoldable) {
            isScreenLightOn = true
        }
    }
}

fun main() {
    val foldablePhone = FoldablePhone()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
    foldablePhone.open()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
}