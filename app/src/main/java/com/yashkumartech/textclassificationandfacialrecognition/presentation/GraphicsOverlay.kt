package com.yashkumartech.textclassificationandfacialrecognition.presentation
//
//import android.content.Context
//import android.hardware.camera2.CameraCharacteristics
//import android.util.AttributeSet
//import android.view.View
//import androidx.compose.foundation.layout.BoxWithConstraints
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Canvas
//import androidx.compose.ui.viewinterop.AndroidView
//
////class GraphicOverlay(context: Context?, attrs: AttributeSet?) :
////    View(context, attrs) {
////    private val lock = Any()
////    private var previewWidth = 0
////    private var widthScaleFactor = 1.0f
////    private var previewHeight = 0
////    private var heightScaleFactor = 1.0f
////    private var facing = CameraCharacteristics.LENS_FACING_BACK
////    private val graphics: MutableSet<Graphic> = HashSet()
////
////    abstract class Graphic(private val overlay: GraphicOverlay) {
////        abstract fun draw(canvas: Canvas?)
////        fun scaleX(horizontal: Float): Float {
////            return horizontal * overlay.widthScaleFactor
////        }
////
////        fun scaleY(vertical: Float): Float {
////            return vertical * overlay.heightScaleFactor
////        }
////
////        val applicationContext: Context
////            get() = overlay.context.applicationContext
////
////        fun translateX(x: Float): Float {
////            return if (overlay.facing == CameraCharacteristics.LENS_FACING_FRONT) {
////                overlay.width - scaleX(x)
////            } else {
////                scaleX(x)
////            }
////        }
////
////        fun translateY(y: Float): Float {
////            return scaleY(y)
////        }
////
////        fun postInvalidate() {
////            overlay.postInvalidate()
////        }
////    }
////
////    fun clear() {
////        synchronized(lock) { graphics.clear() }
////        postInvalidate()
////    }
////
////    fun add(graphic: Graphic) {
////        synchronized(lock) { graphics.add(graphic) }
////        postInvalidate()
////    }
////
////    fun remove(graphic: Graphic) {
////        synchronized(lock) { graphics.remove(graphic) }
////        postInvalidate()
////    }
////
////    fun setCameraInfo(previewWidth: Int, previewHeight: Int, facing: Int) {
////        synchronized(lock) {
////            this.previewWidth = previewWidth
////            this.previewHeight = previewHeight
////            this.facing = facing
////        }
////        postInvalidate()
////    }
////
////    override fun onDraw(canvas: Canvas) {
////        super.onDraw(canvas)
////        synchronized(lock) {
////            if (previewWidth != 0 && previewHeight != 0) {
////                widthScaleFactor = canvas.getWidth() as Float / previewWidth.toFloat()
////                heightScaleFactor = canvas.getHeight() as Float / previewHeight.toFloat()
////            }
////            for (graphic in graphics) {
////                graphic.draw(canvas)
////            }
////        }
////    }
////}
//
////@Composable
////fun GraphicOverlay(
////    previewWidth: Int,
////    previewHeight: Int,
////    facing: Int,
////    graphics: Set<Graphic>,
////    modifier: Modifier = Modifier
////) {
////    Canvas(
////        modifier = Modifier.fillMaxSize()
////    ) {
//////            val widthScaleFactor = size.width / previewWidth
//////            val heightScaleFactor = size.height / previewHeight
////        val widthScaleFactor = 1.0f
////        val heightScaleFactor = 1.0f
////
////        graphics.forEach { graphic ->
////            graphic.draw(this, widthScaleFactor, heightScaleFactor, facing)
////        }
////    }
////}
////
////data class Graphic(
////    val draw: Canvas.(widthScaleFactor: Float, heightScaleFactor: Float, facing: Int) -> Unit
////)
//
//
//@Composable
//fun GraphicsOverlay() {
//    AndroidView(factory = )
//}