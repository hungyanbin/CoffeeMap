package yanbin.com.coffeemap.shop

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import yanbin.com.coffeemap.framework.BaseFragment
import yanbin.com.coffeemap.GridItemDecoration
import yanbin.com.coffeemap.LoadNearShopEvent
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.ServiceManager
import yanbin.com.coffeemap.repository.ShopRepoImp

class NearShopGridFragment : BaseFragment() {

    companion object {

        fun newInstance(): NearShopGridFragment {
            val baseFragment = NearShopGridFragment()
            return baseFragment
        }
    }

    private var rootView: View? = null
    private var shopAdapter: ShopGridAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_shops, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rootView = view
        val recycleShop = view.findViewById(R.id.recycleShop) as RecyclerView
        shopAdapter = ShopGridAdapter(context)
        recycleShop.adapter = shopAdapter
        recycleShop.layoutManager = GridLayoutManager(context, 2)
        recycleShop.addItemDecoration(GridItemDecoration(2))
        getShops()
    }


    private fun getShops() {
        val shopRepo = ShopRepoImp()
        val locationService = ServiceManager.locationService
        shopRepo.loadNearShops(locationService.getLastLocation())
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