package com.mypdfsigner.testcasessampleapp

import android.content.Context
import android.content.res.AssetManager
import com.mypdfsigner.testcasessampleapp.quotes.QuoteManager
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations

class QuoteManagerTest {

    @Mock
    lateinit var context: Context
    @Mock
    lateinit var assetsManager: AssetManager

    @Before
    fun before(){
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun after(){

    }

    @Test
    fun quoteTest(){
        val testStream = QuoteManagerTest::class.java.getResourceAsStream("/quotes.json")
        doReturn(assetsManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        val quoteManager = QuoteManager()
        quoteManager.populateQuotesFromAssets(context, "")
        assert(quoteManager.quoteList.size == 3)

    }
}