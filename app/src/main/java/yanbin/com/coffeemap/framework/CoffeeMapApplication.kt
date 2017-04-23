package yanbin.com.coffeemap.framework

import android.app.Application
import yanbin.com.coffeemap.ServiceManager

class CoffeeMapApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        ServiceManager.init(this)
    }
}