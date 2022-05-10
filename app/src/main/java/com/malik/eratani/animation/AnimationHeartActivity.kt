package com.malik.eratani.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.malik.eratani.R
import com.malik.eratani.databinding.ActivityAnimationHeartBinding
import java.util.*
import android.animation.ObjectAnimator

import android.animation.PropertyValuesHolder
import android.widget.ImageView


class AnimationHeartActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnimationHeartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationHeartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("Animasi")
        val r = Random()
        val randomNumber: Int = r.nextInt(100)
        val handler = Handler()
        val runnable = object: Runnable {
            override fun run() {
                binding.textBpm.text =  "BPM " + ((0 until 100).random())
                handler.postDelayed(this, 1000)
            }
        }
        handler.postDelayed(runnable, 1000)

        pulseAnimation(binding.imgHeart)

    }


    fun pulseAnimation(target: ImageView?): ObjectAnimator? {
        val scaleDown: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            target,
            PropertyValuesHolder.ofFloat("scaleX", 1.1f),
            PropertyValuesHolder.ofFloat("scaleY", 1.1f)
        )
        scaleDown.duration = 310
        scaleDown.repeatCount = ObjectAnimator.INFINITE
        scaleDown.repeatMode = ObjectAnimator.REVERSE
        return scaleDown
    }
}