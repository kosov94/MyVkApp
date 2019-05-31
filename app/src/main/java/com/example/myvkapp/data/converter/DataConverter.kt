package com.example.myvkapp.data.converter

interface DataConverter<T, K> {

    fun convert(t: T): K

}
