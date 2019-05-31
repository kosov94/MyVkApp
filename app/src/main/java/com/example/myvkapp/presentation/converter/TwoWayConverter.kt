package com.example.myvkapp.presentation.converter

interface TwoWayConverter<T, K> {

    fun convertTo(t: T): K

    fun convertFrom(k: K): T
}