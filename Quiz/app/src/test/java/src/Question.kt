package src


// <>をつけることで汎用型のプロパティを使える
// クラスオブジェクトの生成する時に型を選ぶかんじ
// classの前にdataをつけるとデータクラスになる
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
) {
    fun showQuestion() {
        println("$questionText, $answer, $difficulty")
    }
}

// 列挙型クラス
// これ以外は使えないようにする
enum class Difficulty {
    EASY, MEDIUM, HARD
}

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    question1.showQuestion()
    question2.showQuestion()
    question3.showQuestion()

    println(question1.toString())
}