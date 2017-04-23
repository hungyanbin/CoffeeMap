package yanbin.com.coffeemap.common

import android.content.Context
import yanbin.com.coffeemap.db.DaoMaster
import yanbin.com.coffeemap.db.DaoSession
import yanbin.com.coffeemap.db.ShopDao

class DbService(context: Context) {

    companion object {
        private val DB_NAME = "coffee_map.db"
    }

    private val daoSession: DaoSession

    init {
        val dbHelper = DaoMaster.DevOpenHelper(context, DB_NAME)
        val daoMaster = DaoMaster(dbHelper.writableDb)
        daoSession = daoMaster.newSession()
    }

    val shopDao: ShopDao? = daoSession.shopDao

}