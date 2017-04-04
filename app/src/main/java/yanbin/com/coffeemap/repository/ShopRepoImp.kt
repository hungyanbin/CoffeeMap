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
