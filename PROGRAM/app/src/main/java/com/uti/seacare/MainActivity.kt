package com.uti.seacare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList:Array<Int>
    lateinit var titleList:Array<String>
    lateinit var descList: Array<String>
    lateinit var detailImageList: Array<Int>
    private lateinit var myAdapter: AdapterClass
    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<DataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageList = arrayOf(
            R.drawable.dugong,
            R.drawable.lumba,
            R.drawable.paus,
            R.drawable.penyu,
            R.drawable.pauss,
            R.drawable.parimanta,
            R.drawable.penguin,
            R.drawable.gurita,
            R.drawable.ikankarang,
            R.drawable.hiu
        )

        titleList = arrayOf(
            "Tentang Dugong",
            "Tentang Lumba-Lumba",
            "Tentang Paus",
            "Tentang Penyu",
            "Tentang Hiu Paus",
            "Tentang Pari manta",
            "Tentang Penguin",
            "Tentang Gurita",
            "Tentang Ikan Karang",
            "Tentang Hiu"
        )

        descList = arrayOf(
            getString(R.string.Dugong),
            getString(R.string.Lumba),
            getString(R.string.Paus),
            getString(R.string.Penyu),
            getString(R.string.HiuPaus),
            getString(R.string.PariManta),
            getString(R.string.Penguin),
            getString(R.string.Gurita),
            getString(R.string.IkanKarang),
            getString(R.string.Hiu))

        detailImageList = arrayOf(
            R.drawable.dugongframe,
            R.drawable.lumbaframe,
            R.drawable.pausframe,
            R.drawable.penyuframe,
            R.drawable.hiupausframe,
            R.drawable.parimantaframe,
            R.drawable.penguinframe,
            R.drawable.guritaframe,
            R.drawable.karangframe,
            R.drawable.hiuframe
        )

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.search)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        searchList = arrayListOf<DataClass>()
        getData()

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    dataList.forEach{
                        if (it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    searchList.clear()
                    searchList.addAll(dataList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

        })

        myAdapter = AdapterClass(searchList)
        recyclerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }

    }

    private fun getData(){
        for (i in imageList.indices){
            val dataClass = DataClass(imageList[i], titleList[i], descList[i], detailImageList[i])
            dataList.add(dataClass)
        }
        searchList.addAll(dataList)
        recyclerView.adapter = AdapterClass(searchList)
    }
}