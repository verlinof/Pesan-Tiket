package com.example.pesantiket

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pesantiket.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val jenisTiket = arrayOf(
        "Ekonomi",
        "Bisnis",
        "Eksekutif",
        "First-Class"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val adapterJenisTiket = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, jenisTiket)

            adapterJenisTiket.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinnerJenis.adapter = adapterJenisTiket
            btnPesan.setOnClickListener(){
                val jenisTiketData:String = spinnerJenis.selectedItem.toString()

                //set tahun bulan hari
                val tahun:Int = dpBerangkat.year
                val bulan:Int = dpBerangkat.month
                val hari:Int = dpBerangkat.dayOfMonth

                //set jam dan menit
                val jam:Int = tpWaktuKeberangkatan.hour
                val menit:Int = tpWaktuKeberangkatan.minute

                //set calendar
                val calendar = Calendar.getInstance()
                calendar.set(tahun,bulan,hari,jam,menit)

                //mengatur Toast
                val message:String = "Jenis Tiket = " + jenisTiketData + "\n" +
                        "Waktu Keberangkatan = " + "$tahun/$bulan/$hari $jam:$menit"

                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()

            }
        }
    }
}