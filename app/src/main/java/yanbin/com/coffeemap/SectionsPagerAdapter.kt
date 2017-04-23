package yanbin.com.coffeemap

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import yanbin.com.coffeemap.shopDetail.ShopDetailFragment
import yanbin.com.coffeemap.shops.NearShopFragment
import yanbin.com.coffeemap.shops.NearShopGridFragment
import yanbin.com.coffeemap.shops.ShopFragment

class SectionsPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            2 -> return NearShopFragment.newInstance()
            1 -> return ShopDetailFragment.newInstance()
            0 -> return NearShopGridFragment.newInstance()
            else -> return ShopFragment.newInstance()
        }
    }
}
