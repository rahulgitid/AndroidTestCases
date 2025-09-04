package com.mypdfsigner.testcasessampleapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String,
    val quote: String
)