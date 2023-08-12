package com.yashkumartech.textclassificationandfacialrecognition

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yashkumartech.textclassificationandfacialrecognition.presentation.ClassificationScreen
import com.yashkumartech.textclassificationandfacialrecognition.presentation.ClassificationViewModel
import com.yashkumartech.textclassificationandfacialrecognition.ui.theme.TextClassificationAndFacialRecognitionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val classificationViewModel = ViewModelProvider(this)[ClassificationViewModel::class.java]
        setContent {
            TextClassificationAndFacialRecognitionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClassificationScreen(
                        viewModel = classificationViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextClassificationAndFacialRecognitionTheme {
        Greeting("Android")
    }
}