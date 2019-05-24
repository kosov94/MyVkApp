package com.example.myvkapp.data.converter

interface Converter<T, K> {

    fun convertTo(t: T): K

}