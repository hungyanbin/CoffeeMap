package yanbin.com.coffeemap.repository

import org.greenrobot.eventbus.EventBus
import yanbin.com.coffeemap.*
import yanbin.com.coffeemap.db.Shop
import yanbin.com.coffeemap.db.ShopDao

class ShopRepoImp(val networkService: NetworkService = NetworkServiceImp(),
                  val eventBus: EventBus = EventBus.getDefault(),
                  val shopDao: ShopDao? = Injection.dbService?.shopDao) : ShopRepo{


    override fun loadShops() {
        if(hasLocalData()){
            getFromLocal()
        }else{
            getFromNetwork()
        }
    }

    override fun loadNearShops(latitude: String, longitude: String) {
        val shops = shopDao?.loadAll() as List<Shop>
        val nearShops = shops.filter { isNear(it, latitude, longitude) }
        eventBus.post(LoadNearShopEvent(nearShops))
    }

    fun isNear(shop: Shop, latitude: String, longitude: String) : Boolean{
        val shopLatitude = shop.latitude.toDouble()
        val shopLongitude = shop.longitude.toDouble()
        val userLatitude = latitude.toDouble()
        val userLongitude = longitude.toDouble()

        val distance = Math.pow(shopLatitude - userLatitude, 2.0) + Math.pow(shopLongitude - userLongitude, 2.0)

        return distance < 0.0001
    }

    fun hasLocalData() : Boolean{
        return shopDao?.count() != 0L
    }

    fun getFromLocal(){
        val shops = shopDao?.loadAll() as List<Shop>
        eventBus.post(LoadShopEvent(shops))
    }

    fun getFromNetwork(){
        networkService.getCoffeeShops(object : ShopResponse {
            override fun onResponse(shops: List<Shop>) {
                eventBus.post(LoadShopEvent(shops))
                shopDao?.insertInTx(shops)
            }

            override fun onError(message: String) {
                //TODO
            }
        })
    }
}
