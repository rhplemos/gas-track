package com.rafaellemos.gas_track

import com.rafaellemos.gas_track.api.FuelPriceApiClient

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.gas_track.R
import com.example.gas_track.databinding.ActivityMainBinding
import com.rafaellemos.gas_track.api.FuelPriceApi
import com.rafaellemos.gas_track.api.FuelPricesResponse


class MainActivity : AppCompatActivity() {
    // Aqui você declara as views que serão usadas na sua interface
    private lateinit var listView: ListView
    private lateinit var progressBar: ProgressBar
    private lateinit var fuelPrices: ArrayList<FuelPricesResponse>
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        progressBar.visibility = View.VISIBLE

    }
}