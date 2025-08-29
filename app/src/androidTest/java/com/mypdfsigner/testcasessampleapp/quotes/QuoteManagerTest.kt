package com.mypdfsigner.testcasessampleapp.quotes

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Test(expected = FileNotFoundException::class)
    fun populateQuotesFromAssets_invalidFileName_expected_FileNotFoundException() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuotesFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun populateQuotesFromAssets_invalidformat_expected_JsonSyntaxException() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuotesFromAssets(context, "malformat.json")
    }

    @Test
    fun populateQuotes_element_11_FromAssets() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuotesFromAssets(context, "quote.json")
        assertEquals(11, quoteManager.quoteList.size)

    }

    @Test
    fun populateQuotes_expected_correctQuote() {
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is first quote", "1"),
                Quote("This is second quote", "2"),
                Quote("This is third quote", "3")
            ))
        assertEquals("1", quoteManager.getPreviousQuote().author)
        assertEquals("2", quoteManager.getNextQuote().author)

    }

}