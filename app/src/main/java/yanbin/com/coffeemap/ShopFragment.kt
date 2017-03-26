package yanbin.com.coffeemap

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ShopFragment : BaseFragment() {

    companion object {

        fun newInstance() : ShopFragment{
            val baseFragment = ShopFragment()
            return baseFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_shops, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycleShop = view.findViewById(R.id.recycleShop) as RecyclerView
        val shopAdapter = ShopAdapter()
        shopAdapter.shops = generateShops()
        recycleShop.adapter = shopAdapter
        recycleShop.layoutManager = LinearLayoutManager(context)
    }

    private fun generateShops(): ArrayList<Shop>{
        val shops = ArrayList<Shop>()
        shops.add(Shop(name = "榭爾咖啡", location = "新北市三重區文化南路2巷15號", time = "1100~2200 週日~1100~1800 週二休"))
        shops.add(Shop(name = "豐鼎咖啡商號", location = "新北市板橋區永豐街215號", time = "10:00-22:00"))
        shops.add(Shop(name = "COFFEE FLAIR", location = "台北市雙城街13巷11-1號", time = "12:30-21:30"))
        shops.add(Shop(name = "Lu Cafe", location = "蘆洲區中正路185巷68弄3號", time = "11:00 - 22:00"))
        return shops
    }
}