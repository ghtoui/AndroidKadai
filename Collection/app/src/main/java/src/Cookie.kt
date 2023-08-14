package src

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
) {

}
val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snicker doodle",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.39
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    cookies.forEach() {
        println("${it.name}")
    }
    // listにmapを使って、全ての要素に適応できる
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
    fullMenu.forEach {
        println("$it")
    }

    // 繋げることもできる。これはメソッドチェーンで書ける
//    val softBakedMenu = cookies.filter {
//        it.softBaked
//    }.map {
//        "${it.name} - $${it.price}"
//    }
//    println("softBaked")
//    softBakedMenu.forEach {
//        println("$it")
//    }

    val groupedMenu = cookies.groupBy {
        it.softBaked
    }
    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()
    println("softBaked")
    softBakedMenu.forEach {
        println("${it.name} - ${it.price}")
    }
    println("crunchy")
    crunchyMenu.forEach {
        println("${it.name} - ${it.price}")
    }

    println("total price")
    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println("Total price: $${totalPrice}")

    println("sort")
    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    alphabeticalMenu.forEach {
        println("${it.name}")
    }
}