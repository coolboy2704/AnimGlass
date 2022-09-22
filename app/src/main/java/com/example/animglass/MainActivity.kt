package com.example.animglass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animglass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, SecondFragment())
            .commit()
    }
}