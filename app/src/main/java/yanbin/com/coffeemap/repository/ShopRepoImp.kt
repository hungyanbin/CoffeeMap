package yanbin.com.coffeemap.repository

import android.location.Location as AndroidLocation
import org.greenrobot.eventbus.EventBus
import yanbin.com.coffeemap.*
import yanbin.com.coffeemap.common.Location
import yanbin.com.coffeemap.common.NetworkService
import yanbin.com.coffeemap.common.ServiceManager
import yanbin.com.coffeemap.common.ShopResponse
import yanbin.com.coffeemap.db.Shop
import yanbin.com.coffeemap.db.ShopDao

class ShopRepoImp(val networkService: NetworkService = ServiceManager.networkService,
                  val eventBus: EventBus = EventBus.getDefault(),
                  val shopDao: ShopDao? = ServiceManager.dbService?.shopDao) : ShopRepo {


    override fun loadShops() {
        checkDBAndLoad { getFromLocal() }
    }


    override fun loadNearShops(location: Location) {
        checkDBAndLoad { getNearFromLocal(location) }
    }

    private fun checkDBAndLoad(loader: () -> Unit){
        if(hasLocalData()){
            loader()
        }else{
            getFromNetwork { loader() }
        }
    }

    private fun getNearFromLocal(location: Location) {
        val shops = shopDao?.loadAll() as List<Shop>
        val nearShops = shops.filter { isNear(it, longitude = location.longitude, latitude = location.latitude) }
        eventBus.postSticky(LoadNearShopEvent(nearShops))
    }

    private fun isNear(shop: Shop, latitude: Double, longitude: Double): Boolean {
        val shopLatitude = shop.latitude.toDouble()
        val shopLongitude = shop.longitude.toDouble()
        val userLatitude = latitude
        val userLongitude = longitude

        val distance: FloatArray = floatArrayOf(0.0f)
        AndroidLocation.distanceBetween(shopLatitude, shopLongitude, userLatitude, userLongitude, distance)

        return distance[0] < 2000
    }

    private fun hasLocalData(): Boolean {
        return shopDao?.count() != 0L
    }

    private fun getFromLocal() {
        val shops = shopDao?.loadAll() as List<Shop>
        eventBus.post(LoadShopEvent(shops))
    }

    private fun getFromNetwork(onSaveComplete: () -> Unit) {
        networkService.getCoffeeShops(object : ShopResponse {
            override fun onResponse(shops: List<Shop>) {
                shopDao?.insertInTx(shops)
                onSaveComplete()
            }

            override fun onError(message: String) {
                //TODO
            }
        })
    }

    override fun getShopById(id: Long, callback: (shop: Shop) -> Unit) {
        callback.invoke(shopDao!!.loadAll()[0])
    }
}
