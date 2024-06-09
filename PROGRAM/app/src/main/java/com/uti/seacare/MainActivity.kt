package com.uti.seacare

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    interface ActivityMainBinding {

    }

    private lateinit var ListAdapter: ListAdapter
    private lateinit var ListData: ListData
    var dataArray = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nameList = arrayOf("Dugong", "Penyu", "Pari", "paus", "Hiu", "Lumba")
        val timelist = arrayOf("Dugong1", "Penyu1", "Pari1", "paus1", "Hiu1", "Lumba1")

        val imageList = intArrayOf(
            R.drawable.paus,
            R.drawable.dugong,
            R.drawable.lumba,
            R.drawable.penyu,
            R.drawable.pauss,
            R.drawable.lumba
        )

        val ingredientList = intArrayOf(
            R.string.pausdetail,
            R.string.Dugongdetail,
            R.string.Lumbadetail,
            R.string.penyudetail,
            R.string.Hiugdetail,
            R.string.parimantadetail
        )

        val descList = intArrayOf(
            R.string.pausgdesc,
            R.string.Dugongdesc,
            R.string.Lumbadesc,
            R.string.penyudesc,
            R.string.Hiudesc,
            R.string.parimantadesc
        )


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}