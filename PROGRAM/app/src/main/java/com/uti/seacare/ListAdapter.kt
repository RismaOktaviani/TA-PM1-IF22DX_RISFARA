package com.uti.seacare

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.LayoutInflaterCompat

class ListAdapter(context: Context, dataArrayList: ArrayList<ListData?>? ):
    ArrayAdapter<ListData>(context, R.layout.list_item, dataArrayList!!){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        val ListData = getItem(position)

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item)
        }

        val listImage = view!!.findViewById<ImageView>(R.id.listImage)
        val listName = view.findViewById<TextView>(R.id.listName)
        val listTime = view.findViewById<TextView>(R.id.listTime)

        listImage.setImageResource(ListData!!.image)
        listName.text = ListData.name
        listTime.text = ListData.time

        return view
    }
}

private fun Any.inflate(listItem: Int): View? {
    TODO("Not yet implemented")
}
