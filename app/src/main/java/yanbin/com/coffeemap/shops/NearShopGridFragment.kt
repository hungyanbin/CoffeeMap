package yanbin.com.coffeemap.shops

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import yanbin.com.coffeemap.*
import yanbin.com.coffeemap.common.ServiceManager
import yanbin.com.coffeemap.framework.BaseFragment
import yanbin.com.coffeemap.repository.ShopRepoImp

class NearShopGridFragment : BaseFragment() {

    companion object {

        fun newInstance(): NearShopGridFragment {
            val baseFragment = NearShopGridFragment()
            return baseFragment
        }
    }

    private lateinit var shopAdapter: ShopGridAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        eventBus.register(this)
        val rootView = inflater.inflate(R.layout.fragment_shops, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycleShop = view.findViewById(R.id.recycleShop) as RecyclerView
        shopAdapter = ShopGridAdapter(context)
        recycleShop.adapter = shopAdapter
        recycleShop.layoutManager = GridLayoutManager(context, 2)
        recycleShop.addItemDecoration(GridItemDecoration(2))
        checkPermissionAndGetShop()
    }

    private fun checkPermissionAndGetShop(){
        requestLocationPermission(onAccept = {getShops()}, onDenied = {})
    }


    private fun getShops() {
        val shopRepo = ShopRepoImp()
        val locationService = ServiceManager.locationService
        locationService.onLocated { shopRepo.loadNearShops(it)}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        eventBus.unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(nearShopEvent: LoadNearShopEvent){
        shopAdapter.shops = nearShopEvent.shops
        shopAdapter.notifyDataSetChanged()
    }
}