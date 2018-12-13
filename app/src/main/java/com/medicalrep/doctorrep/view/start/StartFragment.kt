package com.medicalrep.doctorrep.view.start

import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.Navigation
import com.medicalrep.doctorrep.R
import kotlinx.android.synthetic.main.fragment_start.*
import java.util.*


class StartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_start, container, false)
        val btnAdd = view.findViewById<Button>(R.id.btn_add_doctor)
        val btnSpeciality = view.findViewById<Button>(R.id.btn_select_speciality)
        val spinnerArea = view.findViewById<Spinner>(R.id.spinner_area)

        val areas = ArrayList<String>()
        Collections.addAll(areas, "Ain Shams", "Giza", "El Zayton")
        val areasAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, areas)
        spinnerArea.adapter = areasAdapter

        //actions
        btnAdd.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_startFragment_to_mainFragment)
        }

        btnSpeciality.setOnClickListener {
            AlertDialog
                .Builder(this!!.context!!).setTitle("select speciality")
                .setAdapter(areasAdapter, DialogInterface.OnClickListener { dialog, which ->

                })
                .create().show()
        }



        return view
    }

}
