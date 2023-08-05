package com.example.lambda.src

class Song(val title: String, val artist: String, val release: String, val views: Int) {
    // 再生回数が1000未満の場合は人気がない
    private val isPopular: (Int) -> String = {
        if (it < 1000) {
            "人気なし"
        } else {
            "人気あり"
        }
    }

    fun describe() {
        println("$title, performed by $artist, was released in $release.")
        println("${isPopular(views)}")
    }

}

fun main() {
    val song = Song("aiueo", "boku", "2020-08-09", 1000)
    song.describe()
}