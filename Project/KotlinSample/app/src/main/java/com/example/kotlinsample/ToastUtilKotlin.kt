@file:JvmName("ToastUtil")
package com.example.kotlinsample

import android.widget.Toast

fun toastShort(message:String){
    Toast.makeText(MainApplication.getAppContext(),message,Toast.LENGTH_SHORT).show()
}
fun toastLong(message:String){
    Toast.makeText(MainApplication.getAppContext(),message,Toast.LENGTH_LONG).show()
}
fun toast(message:String,length:Int=Toast.LENGTH_LONG){
    Toast.makeText(MainApplication.getAppContext(),message,length).show()
}