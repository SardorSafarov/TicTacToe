package com.example.tictactoe.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.tictactoe.MainActivity
import com.example.tictactoe.R
import com.example.tictactoe.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var anim: Animation
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        anim = AnimationUtils.loadAnimation(this, R.anim.ainm)
        anim.duration = 1000
        binding.text.animation =anim
        Handler(Looper.getMainLooper()).postDelayed(
            {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
            },
            1300 // value in milliseconds
        )
    }
}