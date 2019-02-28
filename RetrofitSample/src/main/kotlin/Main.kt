
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import service.ApiService
import java.lang.Exception

fun main(args: Array<String>) {
    val baseUrl = "https://randomuser.me/"
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(ApiService::class.java)

    try {
        val response = apiService.apiDemo().execute()
        if (response.isSuccessful) {
            val user = response.body()
            println("[success] info.seed: ${user?.info?.seed}")
            println("[success] info.results: ${user?.info?.results}")
            println("[success] info.page: ${user?.info?.page}")
            println("[success] info.version: ${user?.info?.version}")
        }
        else {
            println("[error]" + response.errorBody())
        }

    }
    catch (e : Exception) {
        println("[error] ${e.toString()}")
    }
}