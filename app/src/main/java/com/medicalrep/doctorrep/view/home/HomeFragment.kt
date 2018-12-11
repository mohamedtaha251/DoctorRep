package com.medicalrep.doctorrep.view.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.medicalrep.doctorrep.R
import com.medicalrep.doctorrep.service.SlideTimer
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    var images: Array<Int> = arrayOf(R.drawable.pp, R.drawable.doctor_rep_icon, R.drawable.dsd)
    lateinit var adapter: PagerAdapter
    lateinit var viewPager: ViewPager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager=view.findViewById(R.id.view_pager)
        adapter = SliderAdapter(context, images)
        viewPager.adapter = adapter
        var sliderTimer = SlideTimer(activity, viewPager)
        sliderTimer.playSlider()

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}