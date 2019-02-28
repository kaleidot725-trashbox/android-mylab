package service

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api")
    fun apiDemo(): Call<User>
}
