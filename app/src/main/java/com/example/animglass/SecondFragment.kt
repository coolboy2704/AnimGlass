package com.example.animglass

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.animglass.databinding.FragmentSecondBinding
import kotlin.math.truncate
import kotlin.random.Random

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
    private var timer: CountDownTimer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)

        view()

       binding.apply {
           buttonClick.setOnClickListener {
               ballOne.isVisible = false
               ballTwo.isVisible = false
               ballThere.isVisible = false
               startCountDownTimer(3000)
           }
       }
    }

    private fun startCountDownTimer(timeMillis: Long){
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 300){
            override fun onTick(millis: Long) {
                val animation: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.combo_one)
                val animtwo: Animation = AnimationUtils.loadAnimation(context, R.anim.combo_two)

                binding.apply {
                    glassOne.startAnimation(animation)
                    glassTwo.startAnimation(animtwo)
                    glassThere.startAnimation(animtwo)
                }
            }

            override fun onFinish() {
                ball()
            }
        }.start()
    }

    private fun ball(){
        val random = Random.nextInt(1, 4)
        binding.apply {
            glassOne.setOnClickListener {
                val animation: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.trans_anim)
                glassOne.startAnimation(animation)
                if (random == 1){
                    ballOne.isVisible = true
                }
            }
            glassTwo.setOnClickListener {
                val animation: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.trans_anim)
                glassTwo.startAnimation(animation)
                if (random == 2){
                    ballTwo.isVisible = true
                }
            }
            glassThere.setOnClickListener {
                val animation: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.trans_anim)
                glassThere.startAnimation(animation)
                if (random == 3){
                    ballThere.isVisible = true
                }
            }
        }
    }

    private fun view(){
        val random = Random.nextInt(1, 4)
        val animation: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.trans_anim)
        binding.apply {
            glassOne.startAnimation(animation)
            glassTwo.startAnimation(animation)
            glassThere.startAnimation(animation)

            when (random) {
                1 -> {
                    ballOne.isVisible = true
                }
                2 -> {
                    ballTwo.isVisible = true
                }
                3 -> {
                    ballThere.isVisible = true
                }
            }
        }
    }
}
