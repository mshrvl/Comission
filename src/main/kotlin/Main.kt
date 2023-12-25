import kotlin.math.max

const val ERROR_CARD = -1
const val ERROR_LIMIT = -2

fun main() {
    val sum = commission("Visa", 100, 7)
    println(sum)
}

fun commission(cardType: String = "VK Pay", previous: Int = 0, amount: Int): Int {
    val totalAmount = amount + previous

    when (cardType) {
        "Visa", "Mir" -> {
            if (amount > 0 && totalAmount <= 600000 && amount <= 150000) {
                return max(35, (amount * 0.0075).toInt())
            } else {
                return ERROR_LIMIT
            }
        }
        "MasterCard", "Maestro" -> {
            val monthlyLimit = 75000
            if (totalAmount <= 600000 && amount <= 150000) {
                return if(totalAmount <= monthlyLimit) 0 else ((amount * 0.006).toInt() + 20)
            } else {
                return ERROR_LIMIT
            }
        }
        "VK Pay" -> {
            val singleTransferLimit = 15000
            val monthlyLimit = 40000
            if (amount > 0 && totalAmount <= monthlyLimit && amount <= singleTransferLimit) {
                return 0 // Всегда бесплатно для VK Pay
            } else {
                return ERROR_LIMIT
            }
        }
        else -> return ERROR_CARD
    }
}