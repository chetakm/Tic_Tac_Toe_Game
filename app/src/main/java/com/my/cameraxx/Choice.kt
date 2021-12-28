package com.my.cameraxx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Choice : AppCompatActivity(), View.OnClickListener {
    lateinit var btn1:Button
    lateinit var btn2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)
        supportActionBar?.hide()
        btn1=findViewById(R.id.button)
        btn2=findViewById(R.id.button2)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        var btnClicked= p0?.let { findViewById<Button>(it.id) }
        if (btnClicked==btn1){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }else{
            val intent=Intent(this,Computer::class.java)
            startActivity(intent)
        }
    }
}