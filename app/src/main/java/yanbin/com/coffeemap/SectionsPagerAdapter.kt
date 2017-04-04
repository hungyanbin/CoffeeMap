package yanbin.com.coffeemap

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class SectionsPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return NearShopFragment.newInstance()
            1 -> return ShopFragment.newInstance()
            else -> return BaseFragment.newInstance(position)
        }
    }
}
