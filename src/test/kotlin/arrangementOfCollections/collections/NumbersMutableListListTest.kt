package arrangementOfCollections.collections

import org.example.arrangementOfCollections.collections.NumbersArrayList
import org.example.arrangementOfCollections.collections.NumbersMutableList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumbersMutableListListTest {
    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 1 element Then size is 1`(list: NumbersMutableList){
        list.add(0)
        assertEquals(1, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 10 element Then size is 10`(list: NumbersMutableList){
        repeat(10){
            list.add(it)
        }

        assertEquals(10, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 5th element Then result is correct`(list: NumbersMutableList){
        repeat(10){
            list.add(it)
        }

        assertEquals(5, list.get(5))
    }

    companion object {
        @JvmStatic
        fun mutableListSource() = listOf(NumbersArrayList())
    }
}