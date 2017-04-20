package yanbin.com.coffeemap

import android.content.Context

object ServiceManager {

    var dbService: DbService? = null
    val networkService: NetworkService = NetworkServiceImp()

    fun init(context: Context) {
        dbService = DbService(context)
    }

}
