package com.rafaellemos.gas_track.api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Em seguida, precisamos definir o endpoint da API e o modelo de dados que esperamos receber da API
interface FuelPriceApi {
    @GET("api/fuel-prices")
    fun getFuelPrices(region: String): Call<List<FuelPricesResponse>>
}

data class FuelPricesResponse(
    val fuelType: String,
    val price: Double,
    val region: String
)

// Agora, vamos criar uma instância do Retrofit e definir a URL base da API
val retrofit = Retrofit.Builder()
    .baseUrl("https://api.petrobras.com.br/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val fuelPriceApi = retrofit.create(FuelPriceApi::class.java)

// Por fim, podemos chamar a API e obter a lista de preços de combustíveis
class FuelPriceApiClient {
    companion object {
        fun getFuelPrices(region: String, success: (List<FuelPricesResponse>) -> Unit, error: (String) -> Unit) {
            fuelPriceApi.getFuelPrices(region).enqueue(object : Callback<List<FuelPricesResponse>> {
                override fun onResponse(call: Call<List<FuelPricesResponse>>, response: Response<List<FuelPricesResponse>>) {
                    if (response.isSuccessful) {
                        val fuelPricesResponse = response.body()
                        success(fuelPricesResponse!!)
                    } else {
                        error("Erro ao obter preços de combustíveis.")
                    }
                }

                override fun onFailure(call: Call<List<FuelPricesResponse>>, t: Throwable) {
                    error("Erro ao obter preços de combustíveis.")
                }
            })
        }
    }
}

