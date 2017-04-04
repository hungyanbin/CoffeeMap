package yanbin.com.coffeemap

interface NetworkService{
    fun getCoffeeShops(shopResponse: ShopResponse)
}

interface ShopResponse{
    fun onResponse(shops: List<Shop>)
    fun onError(message: String)
}