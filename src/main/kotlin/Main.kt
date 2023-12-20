import kotlin.math.max

const val ERROR_CARD = -1
const val ERROR_LIMIT = -2

fun main() {
    val sum = commission("Visa", 100,7)
    println(sum)
}

fun commission(cardType: String = "VK Pay", previous: Int = 0, amount: Int): Int {
    val totalAmount = amount + previous

    return when (cardType) {
        "Visa", "Mir" -> {
            if (amount > 0) {
                max(35, (amount * 0.0075).toInt())
            } else {
                ERROR_CARD
            }
        }
        "MasterCard", "Maestro" -> {
            val monthlyLimit = 75000
            if (totalAmount <= monthlyLimit) {
                0 // Нет комиссии до превышения лимита
            } else {
                max(20, (amount * 0.006).toInt() + 20)
            }
        }
        "VK Pay" -> {
            0 // Всегда бесплатно для VK Pay
        }
        else -> ERROR_CARD
    }
}