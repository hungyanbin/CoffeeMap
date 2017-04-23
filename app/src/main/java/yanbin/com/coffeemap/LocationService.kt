package yanbin.com.coffeemap

import android.content.Context
import android.os.Bundle
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices

interface LocationService {

    fun onStart()
    fun onStop()
    fun init(context: Context)
    fun onLocated(listener: (location:Location) -> Unit)
}

class LocationServiceImp : LocationService {

    companion object {
        private val DEFAULT_LATITUDE = 25.059195
        private val DEFAULT_LONGITUDE = 121.490563
    }

    private var googleApiClient: GoogleApiClient? = null
    private var connected = false
    private var location: Location = Location(latitude = DEFAULT_LATITUDE, longitude = DEFAULT_LONGITUDE)
    private var locationCallback: ((location: Location) -> Unit)? = null

    override fun onLocated(listener: (location: Location) -> Unit) {
        if(connected){
            listener.invoke(location)
        }
        locationCallback = listener
    }


    override fun onStart() {
        googleApiClient?.connect()
    }

    override fun onStop() {
        googleApiClient?.disconnect()
        connected = false
    }

    override fun init(context: Context) {
        if (googleApiClient == null) {
            googleApiClient = GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(getConnectionCallBack())
                    .addOnConnectionFailedListener { connected = false }
                    .addApi(LocationServices.API)
                    .build()
        }
    }

    private fun getConnectionCallBack(): GoogleApiClient.ConnectionCallbacks {
        return object : GoogleApiClient.ConnectionCallbacks {
            override fun onConnected(p0: Bundle?) {
                connected = true
                val googleLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient)
                location = Location(latitude = googleLocation.latitude, longitude = googleLocation.longitude)
                locationCallback?.invoke(location)
            }

            override fun onConnectionSuspended(p0: Int) {
                connected = false
            }
        }
    }

}
