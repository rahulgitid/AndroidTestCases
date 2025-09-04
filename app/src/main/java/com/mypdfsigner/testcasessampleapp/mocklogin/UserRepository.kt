package com.mypdfsigner.testcasessampleapp.mocklogin

class UserRepository() {

    val users = listOf<User>(
        User(1,"ABC","abc@gmail.com", "123456"),
        User(2,"XYZ","xyz@gmail.com", "123456"),
        User(3,"PQR","pqr@gmail.com", "123456")
    )

    fun checkUser(email: String, password: String):  LOGIN_STATUS {
        val user =  users.find { it.email == email && it.password == password }
        return when {
            user == null -> LOGIN_STATUS.INVALID_USER
            password != user.password -> LOGIN_STATUS.INVALID_PASSWORD
            else -> LOGIN_STATUS.SUCCES
        }
    }
}