package com.mypdfsigner.testcasessampleapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuoteDAO {
    @Insert
    fun insertQuote(quote: QuoteEntity)

    @Query("SELECT * FROM quotes")
    fun getQuotes(): LiveData<List<QuoteEntity>>

    @Query("SELECT * FROM quotes WHERE id = :quoteId")
    fun getQuoteById(quoteId: Int): QuoteEntity

    @Query("DELETE FROM quotes WHERE id = :quoteId")
    fun deleteQuoteById(quoteId: Int)

    @Query("DELETE FROM quotes")
    fun deleteAllQuotes()

    @Update
    fun updateQuote(quote: QuoteEntity)

    @Query("SELECT * FROM quotes ORDER BY RANDOM() LIMIT 1")
    fun getRandomQuote(): QuoteEntity

    @Query("SELECT * FROM quotes ORDER BY id DESC LIMIT 1")
    fun getLastQuote(): QuoteEntity

    @Query("SELECT * FROM quotes ORDER BY id ASC LIMIT 1")
    fun getFirstQuote(): QuoteEntity

    @Query("SELECT COUNT(*) FROM quotes")
    fun getQuoteCount(): Int

    @Query("SELECT * FROM quotes WHERE author LIKE :author")
    fun getQuotesByAuthor(author: String): List<QuoteEntity>

}