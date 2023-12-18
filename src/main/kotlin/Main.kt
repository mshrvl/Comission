import kotlin.math.max

const val ERROR_CARD = -1
const val ERROR_LIMIT = -2

fun main() {
    val sum = commission("VK Pay", 100, 75110)
    println(sum)
}

fun commission(cardType: String, amount: Int = 0, previous: Int): Int {
    return when (cardType) {
        "Visa", "Mir" -> {
            val totalAmount = amount + previous
            if (amount <= 150000 && totalAmount <= 600000) {
                max(35, (amount * 0.0075).toInt())
            } else {
                ERROR_LIMIT
            }
        }
        "MasterCard", "Maestro" -> {
            val totalAmount = amount + previous
            if (totalAmount <= 75000) {
                amount
            } else {
                (amount + (amount * 0.006) + 20).toInt()
            }
        }
        "VK Pay" -> {
            val dailyLimit = 15000
            val monthlyLimit = 40000
            val totalAmount = amount + previous
            if (totalAmount <= dailyLimit && totalAmount <= monthlyLimit) {
                amount
            } else {
                ERROR_LIMIT
            }
        }
        else -> ERROR_CARD
    }
}
