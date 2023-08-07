package src

class Quiz: ProgressPrintable {
    // swiftとは違って、overrideをつける必要がある
    override val progressTest: String
        get() = "${answered} of ${total} answered"

    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressTest)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    // これちょっと使い道があまりわからない
    // 使い道: 複数のオブジェクトを生成してもこのオブジェクトにある変数は全て共通する
    // testでその例を示す
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun test() {
    // クラス内のオブジェクトを参照するにはこうする
    val q = Quiz
    // 生成したtotalを表示
    println(q.total)
    // Quiz自体のtotalを変更
    Quiz.total = 20
    // 同一の値に書き換えられる
    println(Quiz.total)
    // 同一の値に書き換えられる
    println(q.total)

    // 関係のないこれも書き換えられる
    // 全て共通のものを持つイメージ
    val quiz = Quiz()
    quiz.printProgressBar()
}

fun main() {
    val quiz = Quiz()
    quiz.printProgressBar()
    quiz.printQuiz()
//     applyを使うとこういう書き方もできる
    Quiz().apply {
        printQuiz()
    }
    test()
}