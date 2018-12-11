package com.medicalrep.doctorrep.utils

import android.support.v4.app.FragmentActivity
import android.view.View
import android.view.WindowManager
import android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION


fun enableFullScreen(activity: FragmentActivity?) {
    //show system UI
    activity!!.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

    //show navigation bar
    activity!!.window!!.getDecorView()!!.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

}

fun disableFullScreen(activity: FragmentActivity?) {
    //hide system UI
    activity!!.window!!.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

    //hide navigation bar
    activity!!.window!!.getDecorView()!!.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)


}
