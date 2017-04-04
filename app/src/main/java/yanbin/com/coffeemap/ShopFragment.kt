package yanbin.com.coffeemap

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

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
        val networkService = NetworkServiceImp()
        networkService.getCoffeeShops(object : ShopResponse {
            override fun onResponse(shops: List<Shop>) {
                shopAdapter?.shops = shops
                notifyDataSetChanged()
            }

            override fun onError(message: String) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun notifyDataSetChanged(){
        rootView?.post {
            shopAdapter?.notifyDataSetChanged()
        }
    }
}