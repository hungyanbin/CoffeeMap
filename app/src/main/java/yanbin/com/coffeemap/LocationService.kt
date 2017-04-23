package yanbin.com.coffeemap

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices

interface LocationService{

    fun onStart()
    fun onStop()
    fun init(context: Context)
    fun getLastLocation(): Location
}

class LocationServiceImp : LocationService{

    private var googleApiClient: GoogleApiClient? = null
    private var connected = false

    private val DEFAULT_LATITUDE = 25.059195
    private val DEFAULT_LONGITUDE = 121.490563

    override fun onStart() {
        googleApiClient?.connect()
    }

    override fun onStop() {
        googleApiClient?.disconnect()
        connected = false
    }

    override fun init(context: Context) {
        if(googleApiClient == null){
            googleApiClient = GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(getConnectionCallBack())
                    .addOnConnectionFailedListener { connected = false }
                    .addApi(LocationServices.API)
                    .build()
        }
    }

    private fun getConnectionCallBack(): GoogleApiClient.ConnectionCallbacks{
        return object: GoogleApiClient.ConnectionCallbacks{
            override fun onConnected(p0: Bundle?) {
                connected = true
            }

            override fun onConnectionSuspended(p0: Int) {
                connected = false
            }
        }
    }

    override fun getLastLocation(): Location {
        Log.i("test", "connected: ${connected}")

        if(connected){
            val location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient)
            return Location(latitude = location.latitude, longitude = location.longitude)
        }else{
            return Location(latitude = DEFAULT_LATITUDE, longitude = DEFAULT_LONGITUDE)
        }
    }
}
