package com.mypdfsigner.testcasessampleapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.mypdfsigner.testcasessampleapp.db.QuoteDAO
import com.mypdfsigner.testcasessampleapp.db.QuoteDatabase
import com.mypdfsigner.testcasessampleapp.db.QuoteEntity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuoteDBTest {

    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quoteDAO: QuoteDAO

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
        quoteDAO = quoteDatabase.getQuoteDao()
    }

    @After
    fun teardown() {
        quoteDatabase.close()
    }

    @Test
    fun testInsertQuote() {
        val quote = QuoteEntity(1, "John Doe", "This is a quote")
        val quote1 = QuoteEntity(2, "John Doe", "This is a quote")
        quoteDAO.insertQuote(quote)
        quoteDAO.insertQuote(quote1)
        val quotes = quoteDAO.getQuotes().getOrAwaitValue()
        assertEquals(2, quotes.size)
    }
     @Test
    fun deleteQuote_expectedNoResult(){
      quoteDAO.deleteAllQuotes()
      assertEquals(0, quoteDAO.getQuoteCount())

    }
}