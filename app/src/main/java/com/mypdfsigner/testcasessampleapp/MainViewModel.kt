package com.mypdfsigner.testcasessampleapp

import android.content.Context
import androidx.lifecycle.ViewModel
import com.mypdfsigner.testcasessampleapp.quotes.Quote
import com.mypdfsigner.testcasessampleapp.quotes.QuoteManager

class MainViewModel: ViewModel() {

    private val quoteManager = QuoteManager()

    fun initializeQuoteManager(applicationContext: Context) {
        quoteManager.populateQuotesFromAssets(applicationContext, "quote.json")
    }

    fun getPreviousQuote(): Quote {
        return quoteManager.getPreviousQuote()

    }

    fun getNextQuote(): Quote {
        return quoteManager.getNextQuote()

    }

    fun getCurrentQuote(): Quote {
        return quoteManager.getCurrentQuote()

    }
}