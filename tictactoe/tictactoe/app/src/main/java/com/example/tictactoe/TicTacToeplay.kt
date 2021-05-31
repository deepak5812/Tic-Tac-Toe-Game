package com.example.tictactoe

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tictactoe.databinding.FragmentTicTacToeplayBinding

class TicTacToeplay : Fragment(),View.OnClickListener {


    lateinit var binding: FragmentTicTacToeplayBinding


    var playerO=0
    var playerX=1
    var activePlayer=playerO
    var filledPosition= arrayOf<Int>(-1,-1,-1,-1,-1,-1,-1,-1,-1)
    var isgameActive=true
    var count=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tic_tac_toeplay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentTicTacToeplayBinding.bind(view)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)



    }

    override fun onClick(p0: View?) {
        count++;
        if(!isgameActive) return

       var clickbutton= p0 as Button
        var clicktag: Int = (p0.tag as String).toInt()
        clickbutton.isEnabled=false
        clickbutton.setTextColor(Color.parseColor("#FFFFFF"))
        filledPosition[clicktag]=activePlayer
        if(activePlayer==playerO){
            clickbutton.setBackgroundColor(Color.parseColor("#FFC400"))
            clickbutton.text="O"
            activePlayer=playerX
            binding.tv4.setTextColor(Color.parseColor("#FFC400"))
            binding.tv4.text="X Turn"
        }else{
            clickbutton.setBackgroundColor(Color.parseColor("#FF6200EA"))

            clickbutton.text="X"
            activePlayer=playerO
            binding.tv4.setTextColor(Color.parseColor("#FF6200EA"))
            binding.tv4.text="O Turn"
        }
        checkingTheWinner()
    }

private fun checkingTheWinner() {
    if (count==9){
        binding.tv2.text="DRAW MATCH BETWEEEN PLAYERS"
        showdialog("DRAW MATCH")
    }
    var arr= arrayOf(arrayOf<Int>(0,1,2),arrayOf<Int>(3,4,5),arrayOf<Int>(6,7,8),arrayOf<Int>(1,4,7),arrayOf<Int>(2,5,8),arrayOf<Int>(0,4,8),arrayOf<Int>(2,4,6),arrayOf<Int>(0,3,6))
    for(i in 0..7){
        var v1=arr[i][0]
        var v2=arr[i][1]
        var v3=arr[i][2]
        if(filledPosition[v1]==filledPosition[v2] && filledPosition[v2]==filledPosition[v3]){
            if(filledPosition[v1]!=-1) {
                isgameActive=false
                if (filledPosition[v1] ==playerO) {
                    binding.tv2.setTextColor(Color.parseColor("#FFC400"))
                    binding.tv2.text ="O IS WINNER"
                    showdialog("O IS WINNER")
                } else if(filledPosition[v1]==playerX) {
                    binding.tv2.setTextColor(Color.parseColor("#FF6200EA"))
                    binding.tv2.text= "X IS WINNER"
                    showdialog("X IS WINNER")
                }
            }
        }
    }

}


    private  fun showdialog(txt:String){
       var alertDialog=AlertDialog.Builder(context).setTitle(txt).setPositiveButton("RESTART",DialogInterface.OnClickListener({
           dialogInterface, i ->  restart() })).show()

    }

    private fun restart() {
         count=0
         playerO=0
         playerX=1
         activePlayer=playerO
         filledPosition= arrayOf<Int>(-1,-1,-1,-1,-1,-1,-1,-1,-1)
         isgameActive=true
        binding.tv2.text="TIC TAC TOE"
        binding.tv4.text=""
        binding.apply {
            button1.text=""
            button1.isEnabled=true
            button1.setBackgroundColor(Color.parseColor("#C3C3C3"))

            button2.text=""
            button2.isEnabled=true
            button2.setBackgroundColor(Color.parseColor("#C3C3C3"))

            button3.text=""
            button3.isEnabled=true
            button3.setBackgroundColor(Color.parseColor("#C3C3C3"))

            button4.text=""
            button4.isEnabled=true
            button4.setBackgroundColor(Color.parseColor("#C3C3C3"))

            button5.text=""
            button5.isEnabled=true
            button5.setBackgroundColor(Color.parseColor("#C3C3C3"))

            button6.text=""
            button6.isEnabled=true
            button6.setBackgroundColor(Color.parseColor("#C3C3C3"))

            button7.text=""
            button7.isEnabled=true
            button7.setBackgroundColor(Color.parseColor("#C3C3C3"))

            button8.text=""
            button8.isEnabled=true
            button8.setBackgroundColor(Color.parseColor("#C3C3C3"))

            button9.text=""
            button9.isEnabled=true
            button9.setBackgroundColor(Color.parseColor("#C3C3C3"))

        }



    }

}