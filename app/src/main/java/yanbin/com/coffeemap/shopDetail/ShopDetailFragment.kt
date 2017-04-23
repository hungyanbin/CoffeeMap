package yanbin.com.coffeemap.shopDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.framework.BaseFragment

class ShopDetailFragment : BaseFragment(){

    companion object{
        fun newInstance() : ShopDetailFragment{
            return ShopDetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_shop_detail, container, false)
    }
}