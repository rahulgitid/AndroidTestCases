package com.mypdfsigner.testcasessampleapp

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PasswordTest {

    lateinit var util: Util
    @Before
    fun doBefore(){
        println("Before")
        util = Util()
    }
    @After
    fun doAfter(){
        println("After")
    }

    @Test
    fun checkValidPassword_empty_retrun_false() {
        assertEquals(false, util.checkValidPassword(""))

    }
    @Test
    fun checkValidPassword_lenth_less_than_6_retrun_false() {
        assertEquals(false, util.checkValidPassword("12345"))
    }

    @Test
    fun checkValidPassword_lenth_greater_than_15_retrun_false() {
        assertEquals(false, util.checkValidPassword("1234567890123456"))

    }

    @Test
    fun checkValidPassword_return_true() {
        assertEquals(true, util.checkValidPassword("123456"))

    }

}