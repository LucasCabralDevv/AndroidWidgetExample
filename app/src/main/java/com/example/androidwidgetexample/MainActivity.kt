package com.example.androidwidgetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidwidgetexample.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var waterConsumedToday: Int = 0

    private val prefs: GlassPreferences by lazy {
        GlassPreferences(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            smallButtonWater.setOnClickListener {
                binding.lottieAnimationView.playAnimation()
                saveGlass(QUANTITY_SMALL_WATER)
            }

            mediumButtonWater.setOnClickListener {
                binding.lottieAnimationView.playAnimation()
                saveGlass(QUANTITY_MEDIUM_WATER)
            }

            largeButtonWater.setOnClickListener {
                binding.lottieAnimationView.playAnimation()
                saveGlass(QUANTITY_LARGE_WATER)
            }
        }
        refresh()
    }

    private fun saveGlass(glassLarge: Int) {
        prefs.save(waterConsumedToday + glassLarge)

        Snackbar.make(binding.mainContainer, "Desfazer", Snackbar.LENGTH_SHORT)
            .setAction(android.R.string.ok) {
                prefs.save(waterConsumedToday - glassLarge)
                refresh()
            }.show()
        refresh()
    }

    private fun refresh() {
        val value = prefs.fetch()
        waterConsumedToday = value
        binding.totalResult.text = getString(R.string.total_result, waterConsumedToday)
    }

    companion object {
        private const val QUANTITY_SMALL_WATER = 200
        private const val QUANTITY_MEDIUM_WATER = 400
        private const val QUANTITY_LARGE_WATER = 600
    }
}