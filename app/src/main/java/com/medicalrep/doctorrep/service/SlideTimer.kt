package com.medicalrep.doctorrep.service

import android.app.Activity
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import java.util.*

class SlideTimer : TimerTask {
    var activity: Activity
    var viewPager: ViewPager
    var currentPage: Int
    val DELAY_MS: Long = 500//delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 3000 // time in milliseconds between successive task
    val IMAGES_SIZE: Int = 3 // number of images


    constructor(activity: FragmentActivity?, viewPager: ViewPager) : super() {
        this.activity = activity!!
        this.viewPager = viewPager
        this.currentPage = 0

    }


    override fun run() {
        activity.runOnUiThread(object : Runnable {
            override fun run() {

                if (currentPage == IMAGES_SIZE) currentPage = 0
                viewPager.setCurrentItem(currentPage++, true)

            }
        })
    }

    fun playSlider() {
        var timer: Timer = Timer()
        timer.schedule(this, DELAY_MS, PERIOD_MS)
    }
}