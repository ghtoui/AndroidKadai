package src

import kotlinx.coroutines.processNextEventInCurrentThread

// コレクションセクションのまとめテスト
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

fun main() {
    task3()
    task5()
    task6()
    task7()
}

fun task1() {
    println("task1")
    val event = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = Daypart.EVENING,
        durationInMinutes = 15
    )
    println("$event")
}

val eventList = mutableListOf<Event>(
    Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
    Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
    Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
    Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
    Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
    Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
)

fun task3() {
    val shortEvent = eventList.filter {
        it.durationInMinutes < 60
    }.fold(0) { total, event ->
        total + 1
    }
    println("短いイベントが$shortEvent 件あります")
}

fun task5() {
    val eventGroup = eventList.groupBy {
        it.daypart
    }
//    println("Morning: ${eventGroup[Daypart.MORNING]?.size} events")
//    println("Afternoon: ${eventGroup[Daypart.AFTERNOON]?.size} events")
//    println("Evening: ${eventGroup[Daypart.EVENING]?.size} events")

    // 解答例でこんな書き方もしていた
    // 辞書(Map)なら、こうやってkeyとvalueを取り出せる
    // daypart: key, events: value
    eventGroup.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
}

// last()で最後, first()で最初
fun task6() {
    println("Last event of the day: ${eventList[eventList.size - 1].title}")
    println("Last event of the day: ${eventList.last().title}")
}

val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun task7() {
    for (i in 0 until eventList.size) {
        println("Duration of first event of the day: ${eventList[i].durationOfEvent}")
    }
}
