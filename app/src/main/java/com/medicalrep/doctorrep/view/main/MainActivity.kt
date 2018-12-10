package com.medicalrep.doctorrep.view.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import com.medicalrep.doctorrep.R
import com.medicalrep.doctorrep.service.SlideTimer
import com.medicalrep.doctorrep.view.home.SliderAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var images: Array<Int> = arrayOf(R.drawable.pp,R.drawable.doctor_rep_icon,R.drawable.dsd)
    var adapter: PagerAdapter = SliderAdapter(this,images)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager.adapter=adapter

        var sliderTimer=SlideTimer(this,view_pager)
        sliderTimer.playSlider()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
