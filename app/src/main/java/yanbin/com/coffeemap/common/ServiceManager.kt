package yanbin.com.coffeemap.common

import android.content.Context
import yanbin.com.coffeemap.*

object ServiceManager {

    var dbService: DbService? = null
    val networkService: NetworkService = NetworkServiceImp()
    val locationService: LocationService = LocationServiceImp()

    fun init(context: Context) {
        dbService = DbService(context)
        locationService.init(context)
    }

}
