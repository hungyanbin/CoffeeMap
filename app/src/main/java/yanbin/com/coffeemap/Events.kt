package yanbin.com.coffeemap

import yanbin.com.coffeemap.db.Shop

data class LoadShopEvent(val shops: List<Shop>)
data class LoadNearShopEvent(val shops: List<Shop>)
