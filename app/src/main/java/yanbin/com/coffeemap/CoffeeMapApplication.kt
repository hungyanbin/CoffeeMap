package yanbin.com.coffeemap

import android.app.Application

class CoffeeMapApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        val inject = Injection()
        inject.init(this)
    }
}