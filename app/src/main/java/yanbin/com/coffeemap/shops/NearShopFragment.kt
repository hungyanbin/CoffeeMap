package yanbin.com.coffeemap.shops

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_shops.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import yanbin.com.coffeemap.framework.BaseFragment
import yanbin.com.coffeemap.LoadNearShopEvent
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.common.ServiceManager
import yanbin.com.coffeemap.repository.ShopRepoImp

class NearShopFragment : BaseFragment() {

    companion object {

        fun newInstance(): NearShopFragment {
            val baseFragment = NearShopFragment()
            return baseFragment
        }
    }

    private lateinit var shopAdapter: ShopAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        eventBus.register(this)
        val rootView = inflater.inflate(R.layout.fragment_shops, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shopAdapter = ShopAdapter()
        recycleShop.adapter = shopAdapter
        recycleShop.layoutManager = LinearLayoutManager(context)
        recycleShop.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        getShops()
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