package com.goranm.observerpatternexercise

import javax.security.auth.Subject

interface Observer {
    fun update(post: String)
}