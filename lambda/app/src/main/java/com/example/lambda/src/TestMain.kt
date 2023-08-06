package com.example.lambda.src

import android.location.GnssMeasurement

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)

    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")

    printFinalTemperature(27.0, "Celsius", "Fahrenheit") {
        it * 9.0 / 5.0 + 32
    }

    printFinalTemperature(350.0, "Kelvin", "Celsius") {
        it - 273.15
    }

    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") {
        5.0 / 9.0 * (it - 32) + 273.15
    }
}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications")
    }
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when {
        (age <= 12) -> 15
        (age in 13.. 68 && isMonday) -> 25
        (age in 13..60) -> 30
        (age in 61..100) -> 20
        else -> -1
    }
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
