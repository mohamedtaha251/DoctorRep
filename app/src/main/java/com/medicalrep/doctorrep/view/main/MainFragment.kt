package com.medicalrep.doctorrep.view.main


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.medicalrep.doctorrep.R
import com.medicalrep.doctorrep.view.about.AboutFragment
import com.medicalrep.doctorrep.view.home.HomeFragment
import com.medicalrep.doctorrep.view.search.SearchFragment

class MainFragment : Fragment() {
    lateinit var bottomNavigationView: BottomNavigationView


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fragmentManager!!.beginTransaction().replace(R.id.Home_cointainer, HomeFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fragmentManager!!.beginTransaction().replace(R.id.Home_cointainer, SearchFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fragmentManager!!.beginTransaction().replace(R.id.Home_cointainer, AboutFragment()).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_main, container, false)
        bottomNavigationView = view.findViewById(R.id.navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //open home fragment as default fragment
        fragmentManager!!.beginTransaction().replace(R.id.Home_cointainer, HomeFragment()).commit()



        return view
    }


}
