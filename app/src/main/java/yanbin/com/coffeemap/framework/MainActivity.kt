package yanbin.com.coffeemap.framework

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.Menu
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.SectionsPagerAdapter
import yanbin.com.coffeemap.ServiceManager

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    private var mViewPager: ViewPager? = null
    private val locationService = ServiceManager.locationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        mViewPager = findViewById(R.id.container) as ViewPager
        mViewPager!!.adapter = mSectionsPagerAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onStart() {
        super.onStart()
        locationService.onStart()
    }

    override fun onStop() {
        super.onStop()
        locationService.onStop()
    }
}

