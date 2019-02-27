import okhttp3.OkHttpClient
import okhttp3.Request

fun main(args: Array<String>) {
    val request : Request = Request.Builder().url("https://google.co.jp").get().build()
    try {
        val okHttpClient = OkHttpClient()
        val response = okHttpClient.newCall(request).execute()
        println(response.body()?.string())
    }
    catch (e : Exception) {
        println(e.message)
    }
}