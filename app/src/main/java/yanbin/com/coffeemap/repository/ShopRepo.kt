package yanbin.com.coffeemap.repository

import yanbin.com.coffeemap.Location

interface ShopRepo {
    fun loadShops()
    fun loadNearShops(location: Location)
}


