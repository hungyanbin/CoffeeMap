package yanbin.com.coffeemap

import yanbin.com.coffeemap.db.Shop

interface NetworkService{
    fun getCoffeeShops(shopResponse: ShopResponse)
}

interface ShopResponse{
    fun onResponse(shops: List<Shop>)
    fun onError(message: String)
}