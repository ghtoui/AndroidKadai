package com.example.lambda.src

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name \nAge: $age")
        println(detailShow())
    }
    private val detailShow: () -> String = {
        if (referrer != null) {
            "${showHobby()} Has a referrer named ${referrer.name}. who ${referrer.showHobby()}"
        } else {
            "${showHobby()} Doesn't have a referrer"
        }

    }

    fun showHobby(): String {
        return when(hobby) {
            null -> "doesn't like hobby."
            else -> "likes to $hobby."
        }
    }
}

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, null, amanda)
    val aaaa = Person("Atiqah", 28, null, atiqah)

    amanda.showProfile()
    atiqah.showProfile()
    aaaa.showProfile()
}