package com.example.loginregisterrelative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.loginregisterrelative.adapter
import com.example.loginregisterrelative.R
import com.example.loginregisterrelative.databinding.ActivityCustomlistviewBinding
import com.example.loginregisterrelative.databinding.ActivityMainBinding


class customlistview : AppCompatActivity() {

    private lateinit var binding: ActivityCustomlistviewBinding
    private lateinit var userArrayList : ArrayList<datauy>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomlistviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.photoprofil,
            R.drawable.markes,
            R.drawable.maingitar,
            R.drawable.mainkucing,
            R.drawable.cari_duit,

        )

        val name = arrayOf(
            "Uhuy",
            "Ihiy",
            "Ehey",
            "Ohoy",
            "Ahay",

        )

        val type = arrayOf(
            "WORKSHOP SERVICE",
            "VISIT SERVICE",
            "WORKSHOP SERVICE",
            "VISIT SERVICE",
            "VISIT SERVICE",


        )

        val country = arrayOf(
            "Bandung",
            "Jakarta",
            "Bali",
            "Bogor",
            "Depok",
        )

        val rekening = arrayOf(
            "843770912",
            "892017233",
            "444582901",
            "110983678",
            "200252618",
        )

        userArrayList = ArrayList()

        for (i in name.indices){

            val user = datauy(name[i], type[i], country[i], rekening[i], imageId[i])
            userArrayList.add(user)
        }
        binding.Listview.isClickable = true
        binding.Listview.adapter = adapter(this, userArrayList)
        binding.Listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val country = country[position]
            val rekening = rekening[position]
            val imageId = imageId[position]

            val i = Intent(this, serviceman::class.java)
            i.putExtra("name",name)
            i.putExtra("country",country)
            i.putExtra("rekening",rekening)
            i.putExtra("imageId",imageId)
            startActivity(i)

            }
        }
}