package com.medicalrep.doctorrep.view.start

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.medicalrep.doctorrep.R
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_start, container, false)
        val btnAdd=view.findViewById<Button>(R.id.btn_add_doctor)

        btnAdd.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_startFragment_to_mainFragment)
        }


        return view
    }

}
