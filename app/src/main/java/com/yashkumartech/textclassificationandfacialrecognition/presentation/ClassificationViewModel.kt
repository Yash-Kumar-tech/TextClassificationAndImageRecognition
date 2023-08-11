package com.yashkumartech.textclassificationandfacialrecognition.presentation

import android.app.Application
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.yashkumartech.textclassificationandfacialrecognition.presentation.GraphicOverlay.Graphic


class ClassificationViewModel(application: Application): AndroidViewModel(application) {

    val options = TextRecognizerOptions.Builder()
        .build()

    fun runTextRecognition(selectedImageUri: Uri?) {
//        val contentResolver = getApplication<Application>().contentResolver
//        val source = ImageDecoder.createSource(selectedImageUri)
//        val bitmap = ImageDecoder.decodeBitmap(source)
        if(selectedImageUri == null) {
            Log.d("HERE", "Image is null")
            return
        }
        Log.d("HERE", "HERE1")
        val source = ImageDecoder.createSource(getApplication<Application>().contentResolver, selectedImageUri)
        Log.d("HERE", "HERE2")
        val bitmap = ImageDecoder.decodeBitmap(source)
        Log.d("HERE", "HERE3")
        val inputImage = InputImage.fromBitmap(bitmap, 0)
        Log.d("HERE", "HERE4")

//        val recognizer = TextRecognition.getClient(options)
//        recognizer.process(inputImage)
//            .addOnSuccessListener {
//                OnSuccessListener<Text>() {
//                    fun OnSuccess(texts: Text) {
//                        processTextRecognitionResult(texts)
//                    }
//                }
//            }
//            .addOnFailureListener {
//                OnFailureListener() {
//                    fun onFailure(e: Exception) {
//                        e.printStackTrace()
//                    }
//                }
//            }
    }

    private fun processTextRecognitionResult(texts: Text) {
        val blocks = texts.textBlocks
        if (blocks.size == 0) {
//            showToast("No text found")
            return
        }
        for (i in blocks.indices) {
            val lines = blocks[i].lines
            for (j in lines.indices) {
                val elements = lines[j].elements
                for (k in elements.indices) {
//                    val textGraphic: Graphic = TextGraphic(mGraphicOverlay, elements[k])
//                    mGraphicOverlay.add(textGraphic)
                    Log.d("HERE", k.toString())
                }
            }
        }
    }
}