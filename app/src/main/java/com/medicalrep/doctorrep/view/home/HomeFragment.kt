package com.medicalrep.doctorrep.view.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*
import com.medicalrep.doctorrep.R
import com.medicalrep.doctorrep.service.SlideTimer
import com.medicalrep.doctorrep.model.Medicine
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"
    val medicinesImgs = ArrayList<String>()
    private var mDatabase: DatabaseReference? = null
    private var mMedicineReference: DatabaseReference? = null
    private var mMedicineListener: ValueEventListener? = null

    var images: Array<Int> = arrayOf(R.drawable.pp, R.drawable.doctor_rep_icon, R.drawable.dsd)
    lateinit var viewPager: ViewPager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        //init firebase
        mDatabase = FirebaseDatabase.getInstance().reference
        mMedicineReference = FirebaseDatabase.getInstance().getReference("medicine")

        //view pager
        viewPager = view.findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = SliderAdapter(context, medicinesImgs)
        var sliderTimer = SlideTimer(activity, viewPager)
        sliderTimer.playSlider()

        return view

    }

    override fun onStart() {
        super.onStart()

        //listen on any change in medicines
        val medicineListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                if (dataSnapshot.exists()) {


                    for (ds in dataSnapshot.children) {
                        val imgURL: String = ds.child("imgURL").getValue(String::class.java)!!
                        medicinesImgs.add(imgURL)
                    }
                    viewPager.adapter!!.notifyDataSetChanged()


                }
            }

            override fun onCancelled(dataSnapshot: DatabaseError) {

            }
        }
        mMedicineReference!!.addValueEventListener(medicineListener)

        // copy for removing at onStop()
        mMedicineListener = medicineListener
    }


    override fun onStop() {
        super.onStop()
        if (mMedicineListener != null) {
            mMedicineReference!!.removeEventListener(mMedicineListener!!)
        }
    }
}