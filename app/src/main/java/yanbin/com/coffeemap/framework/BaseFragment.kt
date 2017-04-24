package yanbin.com.coffeemap.framework

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.EventBus
import yanbin.com.coffeemap.R
import yanbin.com.coffeemap.common.PermissionService

open class BaseFragment : Fragment() {

    protected val eventBus: EventBus = EventBus.getDefault()
    private val permissionService = PermissionService()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        return rootView
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        permissionService.onRequestPermissionResult(requestCode, permissions, grantResults)
    }

    fun requestLocationPermission(onAccept: () -> Unit, onDenied: () -> Unit) {
        permissionService.requestLocation(this, onAccept, onDenied)
    }
}