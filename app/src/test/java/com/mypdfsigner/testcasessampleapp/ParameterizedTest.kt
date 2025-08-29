package com.mypdfsigner.testcasessampleapp


import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ParameterizedTest(val input:String, val expectedValue: Boolean) {

    @Test
    fun checkValidePassword(){
        val util = Util()
        assertEquals(expectedValue, util.checkValidPassword(input))

    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: checkValidPassword({0})={1}")
        fun data(): List<Array<Any>> = listOf(
            arrayOf("", false),
            arrayOf("12345", false),
            arrayOf("1234567890123456", false),
            arrayOf("123456", true)
        )
    }


}