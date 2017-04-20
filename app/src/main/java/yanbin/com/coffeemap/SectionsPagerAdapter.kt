package yanbin.com.coffeemap

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import yanbin.com.coffeemap.shop.NearShopFragment
import yanbin.com.coffeemap.shop.NearShopGridFragment
import yanbin.com.coffeemap.shop.ShopFragment

class SectionsPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return NearShopFragment.newInstance()
            1 -> return ShopFragment.newInstance()
            2 -> return NearShopGridFragment.newInstance()
            else -> return ShopFragment.newInstance()
        }
    }
}
