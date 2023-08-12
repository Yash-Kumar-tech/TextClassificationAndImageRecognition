package com.yashkumartech.textclassificationandfacialrecognition.presentation

import android.app.Application
import android.graphics.ImageDecoder
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ClassificationViewModel(application: Application): AndroidViewModel(application) {

    private val _screenState = MutableStateFlow("INITIALIZED")
    val screenState: StateFlow<String> = _screenState

    private val _recognizedText = MutableStateFlow("")
    val recognizedText: StateFlow<String> = _recognizedText

    val options = TextRecognizerOptions.Builder()
        .build()
    fun runTextRecognition(selectedImageUri: Uri?) {
        if(selectedImageUri == null) {
            _screenState.value = "NULL_IMAGE"
            return
        }
        val source = ImageDecoder.createSource(getApplication<Application>().contentResolver, selectedImageUri)
        val bitmap = ImageDecoder.decodeBitmap(source)
        val inputImage = InputImage.fromBitmap(bitmap, 0)

        val recognizer = TextRecognition.getClient(options)
        recognizer.process(inputImage)
            .addOnSuccessListener { texts ->
                _screenState.value = "SUCCESS"
                processTextRecognitionResult(texts!!)
            }
            .addOnFailureListener { e -> // Task failed with an exception
                _screenState.value = "ERROR"
                e.printStackTrace()
            }
    }

    private fun processTextRecognitionResult(texts: Text) {
        val blocks = texts.textBlocks
        if (blocks.size == 0) {
            _screenState.value = "NO_TEXT_FOUND"
            return
        }
        for (i in blocks.indices) {
            val lines = blocks[i].lines
            for (j in lines.indices) {
                val elements = lines[j].elements
                for (k in elements.indices) {
//                    val textGraphic: Graphic = TextGraphic(mGraphicOverlay, elements[k])
//                    mGraphicOverlay.add(textGraphic)
                    _recognizedText.value = _recognizedText.value + " " + elements[k].text
                    Log.d("HERE", elements[k].text)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}