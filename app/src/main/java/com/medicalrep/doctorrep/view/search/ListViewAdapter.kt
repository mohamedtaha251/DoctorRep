package com.medicalrep.doctorrep.view.search

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.medicalrep.doctorrep.R
import com.medicalrep.doctorrep.model.Medicine

class ListViewAdapter(private val context: Context,private val dataSource: ArrayList<Medicine>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_medicine  , parent, false)

        val imageView:ImageView=rowView.findViewById(R.id.iv_medicine_item)
        Glide.with(context).load(dataSource[position].imgURL).into(imageView)


        return rowView

    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size

    }

}