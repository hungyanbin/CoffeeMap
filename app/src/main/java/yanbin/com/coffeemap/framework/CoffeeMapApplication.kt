package yanbin.com.coffeemap.framework

import android.app.Application
import yanbin.com.coffeemap.common.LocationService
import yanbin.com.coffeemap.common.ServiceManager

class CoffeeMapApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        ServiceManager.init(this)
    }


}