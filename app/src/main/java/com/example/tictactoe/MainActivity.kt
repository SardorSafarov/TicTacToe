package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var isXTurn = true
    val array = Array(3){CharArray(3){'*'} }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBtnClicListener()
    }

    private fun setBtnClicListener() {
        binding.apply {
            btn1.setOnClickListener {
                setX(btn1,1)
            }
            btn2.setOnClickListener {
                setX(btn2,2)
            }
            btn3.setOnClickListener {
                setX(btn3,3)
            }
            btn4.setOnClickListener {
                setX(btn4,4)
            }
            btn5.setOnClickListener {
                setX(btn5,5)
            }
            btn6.setOnClickListener {
                setX(btn6,6)
            }
            btn7.setOnClickListener {
                setX(btn7,7)
            }
            btn8.setOnClickListener {
                setX(btn8,8)
            }
            btn9.setOnClickListener {
                setX(btn9,9)
            }
        }
    }

   private fun setX(btn: Button,n:Int) {
        if (btn.text.isNotEmpty()) return
        btn.text = if (isXTurn) {
            btn.setTextColor(Color.RED)
            array[(n-1)/3][(n-1)%3] = 'X'
            "X"
        } else {
            btn.setTextColor(Color.GREEN)
            array[(n-1)/3][(n-1)%3] = '0'
            "O"
        }
        binding.textView.text =
            if (isXTurn) getString(R.string.o_navbati) else getString(R.string.x_navbati)
        isXTurn = !isXTurn
        checkWin()
    }
    private fun checkWin()
    {
        if(array[0][0]!='*' && array[0][0]==array[1][1] && array[1][1] == array[2][2])
        {
            showWinDiaolg(array[0][0])
        }

        array.forEach { char->
            if(char[0]!='*' && char[0]==char[1] && char[1]==char[2])
            {
                showWinDiaolg(char[0])
            }
        }
        for(i in 0 until 3){
            if(array[0][i]!='*' && array[0][i]==array[1][i] && array[1][i]==array[2][i])
            {
                showWinDiaolg(array[0][i])
            }
        }

    }

    private fun showWinDiaolg(c: Char) {

    }

}