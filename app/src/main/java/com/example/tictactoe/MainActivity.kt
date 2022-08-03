package com.example.tictactoe

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.tictactoe.databinding.ActivityMainBinding
import com.example.tictactoe.databinding.DialogBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var isXTurn = true
    val array = Array(3) { CharArray(3) { '*' } }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        setContentView(binding.root)
        setBtnClicListener()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setBtnClicListener() {
        binding.apply {
            btn1.setOnClickListener {
                setX(btn1, 1)
            }
            btn2.setOnClickListener {
                setX(btn2, 2)
            }
            btn3.setOnClickListener {
                setX(btn3, 3)
            }
            btn4.setOnClickListener {
                setX(btn4, 4)
            }
            btn5.setOnClickListener {
                setX(btn5, 5)
            }
            btn6.setOnClickListener {
                setX(btn6, 6)
            }
            btn7.setOnClickListener {
                setX(btn7, 7)
            }
            btn8.setOnClickListener {
                setX(btn8, 8)
            }
            btn9.setOnClickListener {
                setX(btn9, 9)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setX(btn: Button, n: Int) {
        if (btn.text.isNotEmpty()) return

        btn.text = if (isXTurn) {
            btn.setTextColor(getColor(R.color.x_color))
            array[(n - 1) / 3][(n - 1) % 3] = 'X'
            getString(R.string.x)
        } else {
            btn.setTextColor(getColor(R.color.o_color))
            array[(n - 1) / 3][(n - 1) % 3] = '0'
            getString(R.string.o)
        }
        binding.textView.text =
            if (isXTurn) getString(R.string.o_navbati) else getString(R.string.x_navbati)
        isXTurn = !isXTurn
        checkWin()


    }

    private fun checkWin() {
        if (array[0][0] != '*' && array[0][0] == array[1][1] && array[1][1] == array[2][2]) {
            showWinDiaolg(array[1][1].toString())
            return
        }

        if (array[0][2] != '*' && array[0][2] == array[1][1] && array[1][1] == array[2][0]) {
            showWinDiaolg(array[1][1].toString())
            return
        }

        for (char in array) {
            if (char[0] != '*' && char[0] == char[1] && char[1] == char[2]) {
                showWinDiaolg(char[0].toString())
                return
            }
        }
        for (i in 0 until 3) {
            if (array[0][i] != '*' && array[0][i] == array[1][i] && array[1][i] == array[2][i]) {
                showWinDiaolg(array[0][i].toString())
                return
            }
        }
        var stop = 0
        for (i in 0 until 3)
            for (j in 0 until 3) {
                if (array[i][j] != '*')
                    stop++
            }
        if (stop == 9)
            showWinDiaolg("Durrang!!")

    }

    private fun showWinDiaolg(c: String) {
        val dialogBinding = DialogBinding.inflate(LayoutInflater.from(this))
        when (c) {
            "Durrang!!" -> {
                dialogBinding.textDialog.setText("Durrang bo`ldi!!")
                binding.apply {
                    stop.text = (stop.text.toString().toInt() + 1).toString()
                }
            }
            "X" -> {
                dialogBinding.textDialog.setText("X Yutdi!!")
                binding.winX.text = (binding.winX.text.toString().toInt() + 1).toString()

            }
            "0" -> {
                dialogBinding.textDialog.setText("0 Yutdi!!")
                binding.win0.text = (binding.win0.text.toString().toInt() + 1).toString()
            }
        }

        val alertDialog = AlertDialog.Builder(this, R.style.DialogCustomer)
            .setView(dialogBinding.root)
            .setCancelable(false)
            .create()

        dialogBinding.btnDialog.setOnClickListener {
            clearBtn()
            alertDialog.dismiss()
        }
        alertDialog.show()
    }

    private fun clearBtn() {

        binding.apply {
            btn1.text = ""
            btn2.text = ""
            btn3.text = ""
            btn4.text = ""
            btn5.text = ""
            btn6.text = ""
            btn7.text = ""
            btn8.text = ""
            btn9.text = ""
        }

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                array[i][j] = '*'
            }
        }
    }

}