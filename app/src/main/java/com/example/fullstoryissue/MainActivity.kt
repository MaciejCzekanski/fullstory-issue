package com.example.fullstoryissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.example.fullstoryissue.ui.theme.FullstoryIssueTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FullstoryIssueTheme {
                Box(modifier = Modifier.fillMaxWidth()) {
                    val mapUiSettings = MapUiSettings(
                        compassEnabled = false,
                        mapToolbarEnabled = false,
                        rotationGesturesEnabled = false,
                        zoomControlsEnabled = false,
                    )

                    val cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(LatLng(50.06, 19.95), 10f)
                    }
                    GoogleMap(
                        modifier = Modifier.fillMaxSize(),
                        uiSettings = mapUiSettings,
                        cameraPositionState = cameraPositionState
                    )
                }
            }
        }
    }
}
