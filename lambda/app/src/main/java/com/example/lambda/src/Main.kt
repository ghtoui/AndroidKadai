package com.example.lambda.src

fun main() {
    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
    repeat(5) {
        println("itを使って数えることができる: $it")
    }
//    trick()
//    treat()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("no treats!")
}

val treat: () -> Unit = {
    println("Have a treat")
}