package com.medicalrep.doctorrep.view.mainactivity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import com.medicalrep.doctorrep.R
import com.medicalrep.doctorrep.service.SlideTimer
import com.medicalrep.doctorrep.view.home.SliderAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
