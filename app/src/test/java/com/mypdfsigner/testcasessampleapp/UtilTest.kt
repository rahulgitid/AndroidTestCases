package com.mypdfsigner.testcasessampleapp

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class UtilTest {

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
    fun isPalindrom() {
        util = Util()
        assertEquals(true, util.isPalindrom("madam"))
    }

    @Test
    fun isPalindrom_enterHello_return_false() {
        util = Util()
        assertEquals(false, util.isPalindrom("hello"))

    }

}