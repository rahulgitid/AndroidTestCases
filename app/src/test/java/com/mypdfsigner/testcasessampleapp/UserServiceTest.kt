package com.mypdfsigner.testcasessampleapp

import com.mypdfsigner.testcasessampleapp.mocklogin.LOGIN_STATUS
import com.mypdfsigner.testcasessampleapp.mocklogin.UserRepository
import com.mypdfsigner.testcasessampleapp.mocklogin.UserServices
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository : UserRepository


    @Before
    fun befor(){
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.checkUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.SUCCES)
    }

    @After
    fun after(){
    }

    @Test
    fun testUserLogin(){
        val userServices = UserServices(userRepository)
        val result = userServices.loginUser("123@gmail.com", "123456")
        assert(result == "Success")

    }

}