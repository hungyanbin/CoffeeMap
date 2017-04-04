package yanbin.com.coffeemap

import android.content.Context

class Injection{

    companion object{
        var dbService:DbService? = null
    }

    fun init(context: Context){
        dbService = DbService(context)
    }

}
