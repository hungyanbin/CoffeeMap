package yanbin.com.coffeemap.common

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer
import com.google.android.gms.location.places.PlacePhotoResult
import com.google.android.gms.location.places.Places
import yanbin.com.coffeemap.shopDetail.Constants

interface LocationService {

    fun onStart()
    fun onStop()
    fun init(context: Context)
    fun onLocated(listener: (location: Location) -> Unit)

    fun loadImage(id: Long, image: ImageView)
}

class LocationServiceImp(val permissionService: PermissionService = PermissionService()) : LocationService {

    companion object {
        private val DEFAULT_LATITUDE = 25.059195
        private val DEFAULT_LONGITUDE = 121.490563
    }

    private var googleApiClient: GoogleApiClient? = null
    private var connected = false
    private var location: Location = Location(latitude = DEFAULT_LATITUDE, longitude = DEFAULT_LONGITUDE)
    private var locationCallback: ((location: Location) -> Unit)? = null
    private var context: Context? = null

    override fun onLocated(listener: (location: Location) -> Unit) {
        locationCallback = listener
        if(connected){
            listener(location)
        }
    }


    override fun onStart() {
        googleApiClient?.connect()
    }

    override fun onStop() {
        googleApiClient?.disconnect()
        connected = false
    }

    override fun init(context: Context) {
        this.context = context
        if (googleApiClient == null) {
            googleApiClient = GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(getConnectionCallBack(context))
                    .addOnConnectionFailedListener { connected = false }
                    .addApi(Places.GEO_DATA_API)
                    .addApi(Places.PLACE_DETECTION_API)
                    .addApi(LocationServices.API)
                    .build()
        }
    }

    private fun getConnectionCallBack(context: Context): GoogleApiClient.ConnectionCallbacks {
        return object : GoogleApiClient.ConnectionCallbacks {
            override fun onConnected(p0: Bundle?) {
                connected = true

                val hasPermission = permissionService.hasLocationPermission(context)
                if(hasPermission) {
                    val googleLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient)
                    location = Location(latitude = googleLocation.latitude, longitude = googleLocation.longitude)
                    locationCallback?.invoke(location)
                }
            }

            override fun onConnectionSuspended(p0: Int) {
                connected = false
            }
        }
    }

    override fun loadImage(id: Long, image: ImageView) {
        Places.GeoDataApi.getPlacePhotos(googleApiClient, Constants.PLACE_ID)
                .setResultCallback {
                    if(!it.status.isSuccess){
                        return@setResultCallback
                    }

                    val photoBuffer :PlacePhotoMetadataBuffer = it.photoMetadata

                    if(photoBuffer.count > 0){
                        photoBuffer[0].getScaledPhoto(googleApiClient, image.width, image.height)
                                .setResultCallback {
                                    handleResult(image, it)
                                }
                    }
                    photoBuffer.release()
                }
    }

    private fun handleResult(image: ImageView, placePhotoResult: PlacePhotoResult) {
        if (placePhotoResult.status.isSuccess) {
            image.setImageBitmap(placePhotoResult.bitmap)
        }
    }


}
