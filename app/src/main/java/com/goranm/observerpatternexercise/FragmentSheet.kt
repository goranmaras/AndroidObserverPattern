package com.goranm.observerpatternexercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet.*

class FragmentSheet: BottomSheetDialogFragment(), Observer {

    var message : TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.bottom_sheet, container, false) as View

        message = view.findViewById(R.id.tvSheetDialogQuestion)

        return view
    }

    override fun update(post: String) {
        if (post!=null){
            message?.text = post
        }else{
            message?.text = "STIGLO PRAZNO"
        }
    }


}