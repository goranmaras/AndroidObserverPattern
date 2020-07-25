package com.goranm.observerpatternexercise

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_a.*
import javax.security.auth.Subject

class FragmentA: Fragment(R.layout.fragment_a), BaseSubject{

    private val observers : ArrayList<Observer> = ArrayList()

    var et : EditText? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       et = view.findViewById(R.id.etFragmentA)

        btnFragmentA.setOnClickListener {
           notifyObserver()
        }



    }

    override fun registerObserver(observer: Observer) {
        if (!observers.contains(observer)){
            observers.add(observer)
        }
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObserver() {
        for (observer in observers){
            observer.update(et.toString())
        }
    }


}