package com.rafaellemos.gas_track;

//import FuelPriceAdapter
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rafaellemos.gas_track.api.FuelPriceApiClient
import com.rafaellemos.gas_track.api.FuelPricesResponse

class MainViewModel : ViewModel() {
    private val fuelPrices = mutableListOf<List<FuelPricesResponse>>()

    fun getFuelPrices(): MutableList<List<FuelPricesResponse>> {
        FuelPriceApiClient.getFuelPrices(region = "RJ",
            success = { fuelPricesResponse ->

                fuelPrices.add(fuelPricesResponse)
                // Aqui você atualiza a lista na sua interface com os preços obtidos da API
                // Aqui você atualiza a lista na sua interface com os preços obtidos da API
                //listView.adapter = FuelPriceAdapter(this, fuelPrices)
            },
            error = { errorMessage ->
                //progressBar.visibility = View.GONE
                // Aqui você trata o erro da requisição à API
                //Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        )
        return fuelPrices
    }
}