package com.mypdfsigner.testcasessampleapp

class Util {
    //palindrom code to check reverse string
    fun isPalindrom(input: String): Boolean{
        var i = 0;
        var j = input.length -1;
        var result = true
        while (i<j){
            if(input[i] != input[j]) {
                result = false
                break
            };
            i++
            j--
        }
        return result
    }


    fun checkValidPassword(password: String): Boolean{
        if(password.isEmpty() || password.length < 6 || password.length > 15) return false
        else return true
    }
}