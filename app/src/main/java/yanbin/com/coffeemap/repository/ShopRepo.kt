package yanbin.com.coffeemap.repository

import yanbin.com.coffeemap.common.Location
import yanbin.com.coffeemap.db.Shop

interface ShopRepo {
    fun loadShops()
    fun loadNearShops(location: Location)
    fun getShopById(id: Long, callback: (shop : Shop) -> Unit)
}


