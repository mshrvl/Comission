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
        assertEquals(1, result)
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
}