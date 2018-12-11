package com.medicalrep.doctorrep.view.splash

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.medicalrep.doctorrep.R
import com.medicalrep.doctorrep.utils.disableFullScreen
import com.medicalrep.doctorrep.utils.enableFullScreen


class SplashFragment : Fragment() {
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //3 seconds


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         enableFullScreen(activity)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initialize the Handler
        mDelayHandler = Handler()

        //Task to navigate to next fragment
            val mRunnable: Runnable = Runnable {
                Navigation.findNavController(view)
                    .navigate(
                        R.id.action_splashFragment_to_startFragment3,
                        null,
                        NavOptions.Builder()
                            .setPopUpTo(
                                R.id.splashFragment,
                                true
                            ).build()
                    )
            }


            //Navigate with delay
            mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)


    }


    override fun onDestroy() {
        super.onDestroy()
           disableFullScreen(activity)
    }
}
