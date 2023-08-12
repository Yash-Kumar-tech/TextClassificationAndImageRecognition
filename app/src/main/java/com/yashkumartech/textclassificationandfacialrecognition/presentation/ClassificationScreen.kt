package com.yashkumartech.textclassificationandfacialrecognition.presentation

import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage


@Composable
fun ClassificationScreen(
    viewModel: ClassificationViewModel
) {

    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            selectedImageUri = uri
            Log.d("ImageUri", uri.toString())
        }
    )
    val recognizedText by viewModel.recognizedText.collectAsState()
    val screenState by viewModel.screenState.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                AsyncImage(
                    model = selectedImageUri,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
                AndroidView(
                    factory = { context ->
                        GraphicOverlay(context, null)
                    },
                    update = { view ->

                    }
                )
            }
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(8.dp)
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                Text(recognizedText)
            }
        }
        TextButton(
            onClick = {
                Log.d("HERE", "Button Pressed")
                singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)
        ) {
            Text("Pick Image")
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    Log.d("HERE", "Button Pressed")
                    viewModel.runTextRecognition(selectedImageUri)
                },
                enabled = true
            ) {
                Text("Text Classification")
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Facial Recognition")
            }
        }
    }    
}
