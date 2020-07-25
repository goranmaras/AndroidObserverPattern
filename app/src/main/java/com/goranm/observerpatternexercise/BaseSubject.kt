package com.goranm.observerpatternexercise

interface BaseSubject {

    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObserver()

}