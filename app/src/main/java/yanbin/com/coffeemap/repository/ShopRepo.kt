package yanbin.com.coffeemap.repository

interface ShopRepo{
    fun loadShops()
    fun loadNearShops(latitude: String, longitude: String)
}


