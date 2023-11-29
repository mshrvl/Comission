import kotlin.math.max
const val ERROR_CARD = -1
const val ERROR_LIMIT = -2
fun main() {
    val sum = comission("Visa", 100, 300)
    println(sum)

}

fun comission(cardType: String, amount: Int = 0, previous: Int): Int {
    return when (cardType) {
        "Visa", "Mir" -> if (amount <= 150000 && amount + previous <= 600000) max(35, (amount * 0.0075).toInt()) else ERROR_LIMIT
        "MasterCard", "Maestro" -> if (amount + previous <= 75000) amount else (amount + (amount * 0.006) + 20).toInt()
        else -> ERROR_CARD
    }
}

