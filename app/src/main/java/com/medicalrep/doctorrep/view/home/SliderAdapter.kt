package com.medicalrep.doctorrep.view.home

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.medicalrep.doctorrep.R

class SliderAdapter:PagerAdapter{
    var context:Context
    var images:Array<Int>
    lateinit var inflater:LayoutInflater

    constructor(context: Context?, images: Array<Int>) : super() {
        this.context = context!!
        this.images = images
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view== `object` as ConstraintLayout

    override fun getCount(): Int =images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any{
        var image:ImageView
        inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view:View=inflater.inflate(R.layout.slider_image_item,container,false)
        image=view.findViewById(R.id.slider_image)
        image.setBackgroundResource(images[position])
        container!!.addView(view)
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}