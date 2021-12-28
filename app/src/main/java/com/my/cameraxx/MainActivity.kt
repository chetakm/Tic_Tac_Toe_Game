package com.my.cameraxx

import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.common.util.concurrent.ListenableFuture
import java.io.File
import java.util.concurrent.ExecutorService

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var b0:Button
    lateinit var b1:Button
    lateinit var b2:Button
    lateinit var b3:Button
    lateinit var b4:Button
    lateinit var b5:Button
    lateinit var b6:Button
    lateinit var b7:Button
    lateinit var b8:Button

    lateinit var tv:TextView
    var gameActive=true
    var player1=0
    var player2=1
    var activePlayer=player1
    lateinit var filledPos:IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(p0: View?) {

        if (!gameActive)
            return

        var btnClicked=findViewById<Button>(p0!!.id)
        var clickedTag=Integer.parseInt(btnClicked.tag.toString())

        if (filledPos[clickedTag]!=-1) {
            return
        }

       filledPos[clickedTag]=activePlayer


        if (activePlayer==player1) {
            btnClicked.text = "0"
            tv.text="Player 2 Turn"
            activePlayer=player2
            btnClicked.setTextColor(Color.BLACK)
            btnClicked.backgroundTintList=getColorStateList(R.color.yellow)
        }else{
            btnClicked.text="X"
            activePlayer=player1
            tv.text="Player 1 Turn"
            btnClicked.setTextColor(Color.BLACK)
            btnClicked.backgroundTintList=getColorStateList(R.color.green)
        }
        checkForWin()


    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkForWin() {
        var winPos= arrayOf(intArrayOf(0,1,2), intArrayOf(3,4,5), intArrayOf(6,7,8),
            intArrayOf(0,3,6), intArrayOf(1,4,7), intArrayOf(2,5,8), intArrayOf(0,4,8), intArrayOf(2,4,6)

        )
        for(i in 0 until winPos.size){
            var val0=winPos[i][0]
            var val1=winPos[i][1]
            var val2=winPos[i][2]
           if(filledPos[val0]!=-1) {
               if (filledPos[val0] == filledPos[val1] && filledPos[val1] == filledPos[val2]) {
                   gameActive=false
                   if (filledPos[val0] == player1) {
                       showMessage("Player 1 is Winner")
                      // tv.text = "Player 1 is Winner"
                   } else {
                      // tv.text = "Player 2 is Winner"
                       showMessage("Player 2 is Winner")
                   }
                   return
               }
           }

        }
        var count=0
        for (i in 0 until filledPos.size){
            if(filledPos[i]==-1){
                 count+=1
            }
        }
        if(count==0){
            showMessage("It's Draw")
            return
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun showMessage(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("Tic Tac Toe ")
            .setPositiveButton("Restart Game", DialogInterface.OnClickListener { dialogInterface, i ->
                restartGame()
            })
            .show()

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun restartGame() {
        filledPos= intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)
        activePlayer=player1
        gameActive=true
        tv.text="Player 1 Turn"
        b0.text=""
        b1.text=""
        b2.text=""
        b3.text=""
        b4.text=""
        b5.text=""
        b6.text=""
        b7.text=""
        b8.text=""

        b0.backgroundTintList=getColorStateList(R.color.purple_700)
        b1.backgroundTintList=getColorStateList(R.color.purple_700)
        b2.backgroundTintList=getColorStateList(R.color.purple_700)
        b3.backgroundTintList=getColorStateList(R.color.purple_700)
        b4.backgroundTintList=getColorStateList(R.color.purple_700)
        b5.backgroundTintList=getColorStateList(R.color.purple_700)
        b6.backgroundTintList=getColorStateList(R.color.purple_700)
        b7.backgroundTintList=getColorStateList(R.color.purple_700)
        b8.backgroundTintList=getColorStateList(R.color.purple_700)

    }
}
