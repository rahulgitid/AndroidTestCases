package com.mypdfsigner.testcasessampleapp.mocklogin

class UserServices(private val userRepository: UserRepository) {

    fun loginUser(email: String, password: String): String {
        val status = userRepository.checkUser(email, password)
        return when (status) {
            LOGIN_STATUS.INVALID_USER -> "User does not exist"
            LOGIN_STATUS.INVALID_PASSWORD -> "Invalid Password"
            LOGIN_STATUS.SUCCES -> "Success"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown Error"

        }

    }
}