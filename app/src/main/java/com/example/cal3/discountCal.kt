package com.example.cal3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


lateinit var amount: EditText
lateinit var seekBar: SeekBar
lateinit var percent: TextView
lateinit var result: TextView
lateinit var submit: Button

var Amount:Int=0
var discountPercent:Int=0

class discountCal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discount_cal)

        amount=findViewById(R.id.amount)
        seekBar=findViewById(R.id.seekBar)
        percent=findViewById(R.id.percent)
        result=findViewById(R.id.result)
        submit=findViewById(R.id.submit)

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                percent.text=progress.toString()+"%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        }
        )
        submit.setOnClickListener {
            Amount= amount.text.toString().toInt()
            discountPercent= seekBar.progress
            var discountAmount=( Amount* discountPercent)/100
            var finalPrice=(Amount-discountAmount)
            result.text="Price After Discount = "+finalPrice.toString()
        }
    }
}