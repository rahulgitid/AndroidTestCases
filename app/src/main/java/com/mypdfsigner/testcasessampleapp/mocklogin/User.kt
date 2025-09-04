package com.mypdfsigner.testcasessampleapp.mocklogin

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)

enum class LOGIN_STATUS{
    INVALID_USER,
    INVALID_PASSWORD,
    SUCCES,
    UNKNOWN_ERROR
}
