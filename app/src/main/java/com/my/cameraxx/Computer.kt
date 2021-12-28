package com.my.cameraxx

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*


// The Code is not Complete You only now player with other player not computer

class Computer : AppCompatActivity(), View.OnClickListener {
    lateinit var b0: Button
    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var b4: Button
    lateinit var b5: Button
    lateinit var b6: Button
    lateinit var b7: Button
    lateinit var b8: Button

    lateinit var tv: TextView
    var gameActive=true
    var player1=0
    var player2=1
    var activePlayer=player1
    lateinit var filledPos:IntArray
    lateinit var newArray: IntArray
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer)
        supportActionBar!!.hide()
        filledPos= intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)



        tv=findViewById(R.id.textView2)
        b0=findViewById(R.id.b0)
        b1=findViewById(R.id.b1)
        b2=findViewById(R.id.b2)
        b3=findViewById(R.id.b3)
        b4=findViewById(R.id.b4)
        b5=findViewById(R.id.b5)
        b6=findViewById(R.id.b6)
        b7=findViewById(R.id.b7)
        b8=findViewById(R.id.b8)

        b0.setOnClickListener(this)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)
        b8.setOnClickListener(this)



    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(p0: View?) {
        newArray= intArrayOf(b0.id,b1.id,b2.id,b3.id,b4.id,b5.id,b6.id,b7.id,b8.id)
        var btnClicked=findViewById<Button>(p0!!.id)
        var clickedTag=Integer.parseInt(btnClicked.tag.toString())

        if (activePlayer==player1){
            btnClicked.text="0"
            tv.text="Computer Turn"
            activePlayer=player2
            btnClicked.setTextColor(Color.BLACK)
            btnClicked.backgroundTintList=getColorStateList(R.color.yellow)
        }

        if (activePlayer==player2){

            tv.text="Player Turn"
            activePlayer=player1
            btnClicked.setTextColor(Color.BLACK)
            btnClicked.backgroundTintList=getColorStateList(R.color.green)
        }
    }
}