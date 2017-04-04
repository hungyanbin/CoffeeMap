package yanbin.com.coffeemap

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import yanbin.com.coffeemap.db.Shop
import java.io.IOException

class NetworkServiceImp : NetworkService{

    companion object{
        private val SHOPS_URL = "https://cafenomad.tw/api/v1.2/cafes"
    }

    private val client = OkHttpClient()
    private val call: Call

    init {
        val request = Request.Builder()
                .url(SHOPS_URL)
                .build()
        call = client.newCall(request)
    }

    override fun getCoffeeShops(shopResponse: ShopResponse) {
        call.enqueue(object: Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                shopResponse.onError(e.toString())
            }

            override fun onResponse(call: Call?, response: Response?) {
                val json = response?.body()?.string()
                val listType = object : TypeToken<List<Shop>>() {}.type

                val shops = Gson().fromJson<List<Shop>>(json, listType)
                shopResponse.onResponse(shops)
            }
        }
        )
    }

}
