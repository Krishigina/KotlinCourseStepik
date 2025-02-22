package arrangementOfCollections.calculator

import org.example.arrangementOfCollections.calculator.Calculator
import org.example.arrangementOfCollections.calculator.LoggingCalculator
import org.example.arrangementOfCollections.calculator.SimpleCalculator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 Add To 10 Then Result 15`(calculator: Calculator) {
        val result = calculator.sum(10, 5)
        val expected = 15
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 100 Add To 50 Then Result 150`(calculator: Calculator) {
        val result = calculator.sum(100, 50)
        val expected = 150
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 Multiplication To 5 Then Result 50`(calculator: Calculator) {
        val result = calculator.multiplication(10, 5)
        val expected = 50
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 100 Multiplication To 50 Then Result 5000`(calculator: Calculator) {
        val result = calculator.multiplication(100, 50)
        val expected = 5000
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 Division To 2 Then Result 5`(calculator: Calculator) {
        val result = calculator.division(10, 2)
        val expected = 5.0
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 50 Division To 5 Then Result 10`(calculator: Calculator) {
        val result = calculator.division(50, 5)
        val expected = 10.0
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 Subtraction To 8 Then Result 2`(calculator: Calculator) {
        val result = calculator.subtraction(10, 8)
        val expected = 2
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 16 Subtraction To 8 Then Result 8`(calculator: Calculator) {
        val result = calculator.subtraction(16, 8)
        val expected = 8
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun calculatorsSource() = listOf(SimpleCalculator(), LoggingCalculator())
    }


}
