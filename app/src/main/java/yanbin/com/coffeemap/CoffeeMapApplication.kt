package yanbin.com.coffeemap

import android.app.Application

class CoffeeMapApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        ServiceManager.init(this)
    }
}