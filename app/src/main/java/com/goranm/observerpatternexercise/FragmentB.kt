package com.goranm.observerpatternexercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.fragment_b.*

class FragmentB: Fragment(R.layout.fragment_b) {

    private val bottomSheet = FragmentSheet()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvFragmentB.setOnClickListener {
            fragmentManager.let { it ->
                if (it != null) {
                    bottomSheet.show(it, "BottomSheetDialog")
                }
            }
        }


    }



}