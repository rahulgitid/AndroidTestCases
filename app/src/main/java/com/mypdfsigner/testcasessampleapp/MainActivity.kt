package com.mypdfsigner.testcasessampleapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mypdfsigner.testcasessampleapp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

     lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel  = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.initializeQuoteManager(this)
        setPreQuote()
        binding.buttonPrevious.setOnClickListener {setPreQuote()}
        binding.buttonNext.setOnClickListener {setNextQuote()}
        binding.btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getCurrentQuote().quote)
            startActivity(intent)
        }
        binding.btnAddquote.setOnClickListener {
            val intent = Intent(this, AddQuote::class.java)
            startActivity(intent)

        }
    }

    fun setPreQuote(){
        val quote = mainViewModel.getPreviousQuote()
        binding.textViewOnCard.text = quote.quote
    }
    fun setNextQuote(){
        val quote = mainViewModel.getNextQuote()
        binding.textViewOnCard.text = quote.quote

    }
}