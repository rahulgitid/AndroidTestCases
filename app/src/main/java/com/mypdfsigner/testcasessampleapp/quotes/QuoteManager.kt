package com.mypdfsigner.testcasessampleapp.quotes

import android.content.Context
import com.google.gson.Gson

class QuoteManager {

lateinit var quoteList: Array<Quote>
var index: Int =0;
    fun populateQuotesFromAssets(context: Context, fileName: String)  {
        val inputStream = context.assets.open(fileName)
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        quoteList = Gson().fromJson(json, Array<Quote>::class.java)
    }

    fun populateQuotes(quotes: Array<Quote>) {
        quoteList = quotes
    }

    fun getPreviousQuote(): Quote {
        if (index == 0) return quoteList[index]
        return quoteList[--index]

    }

    fun getNextQuote(): Quote {
        if (index == quoteList.size - 1) return quoteList[index]
        return quoteList[++index]
    }
}