package com.example.din_login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


// viewmodel de la aplicacion, si fuera funcional se le pasaria algun controller o service por el constructor
class ViewModel() {

    private var _canLogIn = mutableStateOf(false)
    var canLogIn = _canLogIn

    private var _user = mutableStateOf("")
    val user = _user

    private val _pass = mutableStateOf("")
    val pass = _pass

    fun changeUser(newValue: String){
        _user.value = newValue
    }

    fun changePass(newValue: String){
        _pass.value = newValue
    }

    fun resetUserAndPass(){
        _pass.value = ""
        _user.value = ""
        _canLogIn.value = false
    }

    fun comporbarLogin(){
        _canLogIn.value = validateMail() && validatePass()
    }

    private fun validateMail():Boolean{


        if (!_user.value.contains("@") || !_user.value.contains(".")) return false

        val dividedMail = _user.value.split("@")

        dividedMail.forEach {
            if (it.isEmpty()) return false
            val dividedByDot = it.split(".")
            dividedByDot.forEach { if (it.isEmpty()) return false }
        }

        return true

    }


    private fun validatePass():Boolean{
        return _pass.value.length > 6
    }

}