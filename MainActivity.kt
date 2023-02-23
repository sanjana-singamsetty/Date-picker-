package com.example.ageapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
     var tvdate: TextView? =null
    var tvmin : TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn : Button = findViewById(R.id.btn)
        tvdate=findViewById(R.id.indat)
        tvmin=findViewById(R.id.inmin)
        btn.setOnClickListener{

            clickdatepicker()
        }
    }
    fun clickdatepicker(){

        val mycalender = Calendar.getInstance()
        val year = mycalender.get(Calendar.YEAR)
        val month = mycalender.get(Calendar.MONTH)
        val day = mycalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            {view, selectedyear, selectedmonth, selecteddayOfMonth ->
                val selecteddate = "$selecteddayOfMonth.${selectedmonth+1}.${selectedyear}"
                tvdate?.setText(selecteddate)
                val sdf= SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
                val theDate=sdf.parse(selecteddate)
                val selecteddateinminutes= theDate.time/60000
                val currentdate =sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentdateinminutes =currentdate.time/60000
                val diff=currentdateinminutes-selecteddateinminutes
                tvmin?.text=diff.toString()
            },

            year,
            month,
            day
        ).show()

    }
}