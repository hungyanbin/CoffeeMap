package yanbin.com.coffeemap.common

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import yanbin.com.coffeemap.framework.BaseFragment

class PermissionService {

    companion object {
        val CODE_LOCATION = 1
    }

    private var onDenied: () -> Unit = {}
    private var onAccept: () -> Unit = {}

    fun requestLocation(baseFragment: BaseFragment, onAccept: () -> Unit, onDenied: () -> Unit) {
        this.onAccept = onAccept
        this.onDenied = onDenied

        val context = baseFragment.context
        val hasPermission = hasLocationPermission(context)

        if (!hasPermission) {
            baseFragment.requestPermissions(Array(1, { Manifest.permission.ACCESS_COARSE_LOCATION }), CODE_LOCATION)
        } else {
            onAccept()
        }
    }

    fun onRequestPermissionResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            CODE_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    onAccept()
                } else {
                    onDenied
                }
            }
        }
    }

    fun hasLocationPermission(context: Context): Boolean {
        val permissionState = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
        return permissionState == PackageManager.PERMISSION_GRANTED
    }
}