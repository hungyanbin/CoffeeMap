package yanbin.com.coffeemap.shop

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import yanbin.com.coffeemap.framework.BaseFragment
import yanbin.com.coffeemap.LoadNearShopEvent
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.repository.ShopRepoImp
import yanbin.com.coffeemap.shop.ShopAdapter

class NearShopFragment : BaseFragment() {

    companion object {

        val latitude = "25.059195"
        val longitude = "121.490563"

        fun newInstance(): NearShopFragment {
            val baseFragment = NearShopFragment()
            return baseFragment
        }
    }

    private var rootView: View? = null
    private var shopAdapter: ShopAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_shops, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rootView = view
        val recycleShop = view.findViewById(R.id.recycleShop) as RecyclerView
        shopAdapter = ShopAdapter()
        recycleShop.adapter = shopAdapter
        recycleShop.layoutManager = LinearLayoutManager(context)
        recycleShop.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        getShops()
    }

    private fun getShops() {
        val shopRepo = ShopRepoImp()
        shopRepo.loadNearShops(latitude, longitude)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventBus.register(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        eventBus.unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(nearShopEvent: LoadNearShopEvent){
        shopAdapter?.shops = nearShopEvent.shops
        shopAdapter?.notifyDataSetChanged()
    }
}