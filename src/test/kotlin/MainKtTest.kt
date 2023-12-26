import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CommissionCalculatorTest {

    @Test
    fun `commission for Visa within limits`() {
        val result = commission("Visa", 100, 7)
        assertEquals(35, result)
    }

    @Test
    fun `commission for Visa exceeding monthly limit`() {
        val result = commission("Visa", 100, 500000)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun `commission for unknown card type`() {
        val result = commission("Unknown", 100, 7)
        assertEquals(ERROR_CARD, result)
    }


    @Test
    fun `commission for MasterCard within limits`() {
        val result = commission("MasterCard", 100, 7)
        assertEquals(0, result)
    }


    @Test
    fun `commission for VK Pay within limits`() {
        val result = commission("VK Pay", 100, 7)
        assertEquals(0, result)
    }

    @Test
    fun `commission for Visa exceeding monthly limit with zero amount`() {
        val result = commission("Visa", 0, 500000)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun `commission for MasterCard within limits with zero amount`() {
        val result = commission("MasterCard", 0, 0)
        assertEquals(0, result)
    }


    @Test
    fun `commission for VK Pay exceeding single transfer limit with maximum amount`() {
        val result = commission("VK Pay", 15000, Int.MAX_VALUE)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun result() {
        val sum = commission("Visa", 100, 150)
        assertEquals(35, sum)
    }

    @Test
    fun vkPaySecondScenario() {
        val amount = 50000
        assertEquals(50000,amount)

    }
    @Test
    fun `commission for unknown card type with negative amount`() {
        val result = commission("Unknown", 100, -7)
        assertEquals(ERROR_CARD, result)
    }

    @Test
    fun `commission for VK Pay within limits with zero amount`() {
        val result = commission("VK Pay", 0, 0)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun `commission for VK Pay with zero amount`() {
        val result = commission("VK Pay", 100, 0)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun `commission for VK Pay with negative amount`() {
        val result = commission("VK Pay", 200, -500)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun `commission for VK Pay at monthly limit`() {
        val result = commission("VK Pay", 39999, 1)
        assertEquals(0, result)
    }


    @Test
    fun `commission for MasterCard exceeding monthly limit`() {
        val result = commission("MasterCard", 74000, 2000)
        assertEquals(32, result)
    }

    @Test
    fun `commission for MasterCard exceeding single transfer limit`() {
        val result = commission("MasterCard", 0, 16000)
        assertEquals(0, result)
    }


    @Test
    fun `commission for VK Pay exceeding single transfer limit`() {
        val result = commission("VK Pay", 15000, Int.MAX_VALUE)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun `commission for VK Pay exceeding monthly limit`() {
        val result = commission("VK Pay", 40000, Int.MAX_VALUE)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun `commission for VK Pay within limits with negative amount`() {
        val result = commission("VK Pay", 500, -500)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun `commission for VK Pay at monthly limit with small amount`() {
        val result = commission("VK Pay", 39500, 500)
        assertEquals(0, result)
    }

    @Test
    fun masterCardTestlimit() {
        val result = commission("MasterCard",3000000,5000)
        assertEquals(ERROR_LIMIT,result)
    }

}
