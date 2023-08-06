package com.example.smarthome.src

fun main() {
    val smartTv = SmartTvDevice(name = "smartTv", category = "tv")
    val smartLight = SmartLightDevice(name = "smartLight", category = "light")
    val sh = SmartHome(smartTv = smartTv, smartLight = smartLight)
    // まだオンにしていないので、何も表示されない
    sh.printSmartTvInfo()
    sh.printSmartLightInfo()

    // オンにする
    sh.smartTvTurnOn()
    sh.smartLightTurnOn()
    // オンにしたので、表示される
    sh.printSmartTvInfo()
    sh.printSmartLightInfo()
}