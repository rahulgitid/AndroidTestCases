package com.mypdfsigner.testcasessampleapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mypdfsigner.testcasessampleapp.databinding.AddDesciptionActivityBinding

class AddQuote : AppCompatActivity() {

    private var addDesciptionActivityBinding: AddDesciptionActivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addDesciptionActivityBinding = AddDesciptionActivityBinding.inflate(layoutInflater)
        setContentView(addDesciptionActivityBinding?.root)

        addDesciptionActivityBinding?.buttonSubmit?.setOnClickListener {
            val intent = Intent(this, QuoteDetail::class.java)
            val title = addDesciptionActivityBinding?.editTextTitle?.text.toString()
            val description = addDesciptionActivityBinding?.editTextDescription?.text.toString()
            intent.putExtra("quote ", "Quote:- ${title}-${description}")
            startActivity(intent)

//check
        }

    }
}