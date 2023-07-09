package com.example.androidwidgetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidwidgetexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.largeButtonWater.setOnClickListener {
            binding.lottieAnimationView.playAnimation()
            binding.totalResult.text = getString(R.string.total_result, QUANTITY_LARGE_WATER)
        }
    }

    companion object {
        private const val QUANTITY_SMALL_WATER = 200
        private const val QUANTITY_MEDIUM_WATER = 400
        private const val QUANTITY_LARGE_WATER = 600
    }
}