package com.example.myvkapp.presentation.converter

interface Converter<T, K> {

    fun convert(t: T): K
}