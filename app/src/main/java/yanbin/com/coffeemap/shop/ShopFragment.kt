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
import yanbin.com.coffeemap.LoadShopEvent
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.repository.ShopRepoImp

class ShopFragment : BaseFragment() {

    companion object {

        fun newInstance(): ShopFragment {
            val baseFragment = ShopFragment()
            return baseFragment
        }
    }

    private var rootView: View? = null
    private var shopAdapter: ShopAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_shops, container, false)
        eventBus.register(this)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rootView = view
        val recycleShop = view.findViewById(R.id.recycleShop) as RecyclerView
        shopAdapter = ShopAdapter()
        recycleShop.adapter = shopAdapter
        recycleShop.layoutManager = LinearLayoutManager(context)
        recycleShop.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        getShopsFormUrl()
    }

    private fun getShopsFormUrl() {
        val shopRepo = ShopRepoImp()
        shopRepo.loadShops()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        eventBus.unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(loadShopEvent: LoadShopEvent){
        shopAdapter?.shops = loadShopEvent.shops
        shopAdapter?.notifyDataSetChanged()
    }
}