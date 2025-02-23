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
    fun `When add 100 element Then size is 100`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        assertEquals(100, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 5th element Then result is correct`(list: NumbersMutableList){
        repeat(10){
            list.add(it)
        }
        assertEquals(5, list.get(5))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 50th element Then result is correct`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }

        assertEquals(50, list.get(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element removed then size decreased`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(99, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When removed 50th element next value at this position`(list: NumbersMutableList){
        repeat(100){
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(51, list.get(50))
    }

    companion object {
        @JvmStatic
        fun mutableListSource() = listOf(NumbersArrayList())
    }
}