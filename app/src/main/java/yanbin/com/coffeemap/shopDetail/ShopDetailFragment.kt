package yanbin.com.coffeemap.shopDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.common.ServiceManager
import yanbin.com.coffeemap.framework.BaseFragment
import yanbin.com.coffeemap.repository.ShopRepoImp

class ShopDetailFragment : BaseFragment() {

    companion object {
        fun newInstance(): ShopDetailFragment {
            return ShopDetailFragment()
        }
    }

    private var textName: TextView? = null
    private var imageShop: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_shop_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textName = view.findViewById(R.id.textName) as TextView
        imageShop = view.findViewById(R.id.imageShop) as ImageView
        getShopDetail()
        loadPhoto()
    }

    fun getShopDetail(){
        val shopRepo = ShopRepoImp()
        shopRepo.getShopById(0, {shop -> textName?.text = shop.name})
    }

    private fun loadPhoto(){
        val locationService = ServiceManager.locationService
        locationService.loadImage(0, imageShop!!)
    }

}