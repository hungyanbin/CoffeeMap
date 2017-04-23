package yanbin.com.coffeemap

import android.content.Context

object ServiceManager {

    var dbService: DbService? = null
    val networkService: NetworkService = NetworkServiceImp()
    val locationService: LocationService = LocationServiceImp()

    fun init(context: Context) {
        dbService = DbService(context)
        locationService.init(context)
    }

}
