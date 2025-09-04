package com.mypdfsigner.testcasessampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mypdfsigner.testcasessampleapp.databinding.QuoteDetialActivityBinding

class QuoteDetail: AppCompatActivity() {
    private lateinit var quoteDetailBinding : QuoteDetialActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quoteDetailBinding = QuoteDetialActivityBinding.inflate(layoutInflater)
        setContentView(quoteDetailBinding?.root)
        val quote = intent.getStringExtra("quote")
        quoteDetailBinding?.txtQuoteDetail?.text = quote

    }
}