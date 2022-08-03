/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.objectdetection


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import org.tensorflow.lite.task.vision.detector.Detection
import java.util.*
import kotlin.math.max

class OverlayView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var results: List<Detection> = LinkedList<Detection>()

    private var pointPaint = Paint()

    private var boxPaint = Paint()
    private var textBackgroundPaint = Paint()
    private var textPaint = Paint()

    private var scaleFactor: Float = 1f

    private var Width_image: Float = 1f
    private var Height_image: Float = 1f
    private var Height_image_offset: Float = 1f

    private var bounds = Rect()
    var sock = socketConnection()
    var imageB64send: String = "";



    init {
        initPaints()
    }


    fun clear() {
        textPaint.reset()
        textBackgroundPaint.reset()
        boxPaint.reset()
        invalidate()
        initPaints()
    }

    private fun initPaints() {
        textBackgroundPaint.color = Color.BLACK
        textBackgroundPaint.style = Paint.Style.FILL
        textBackgroundPaint.textSize = 50f

        textPaint.color = Color.WHITE
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = 50f

        boxPaint.color = ContextCompat.getColor(context!!, R.color.bounding_box_color)
        boxPaint.strokeWidth = 8F
        boxPaint.style = Paint.Style.STROKE

        pointPaint.color = Color.RED
        pointPaint.style = Paint.Style.FILL
        pointPaint.textSize = 50f
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        for (result in results) {

            val boundingBox = result.boundingBox

            val top = boundingBox.top * scaleFactor
            val bottom = boundingBox.bottom * scaleFactor
            val left = boundingBox.left * scaleFactor
            val right = boundingBox.right * scaleFactor

            val midX = (left + right) / 2f
            val midY = (top + bottom) / 2f


            val area = ObjectDetectorHelper.area_cuadro

            println("AREA DE LA DETECCION: ${area}-----------------------------------")

            println("CENTRO:==================")
            println("Punto X: $midX")
            println("Punto Y: $midY")

            println("Centro Pantalla:==================")
            println("Pantalla X/2: $Width_image")
            println("Pantalla Y/2: $Height_image")
            println("=========================")

            // VARIABLES PARA CONTROL ===============================================
            canvas.drawCircle(midX, midY, 4F, boxPaint)
            canvas.drawCircle(Width_image, Height_image, 5F, pointPaint)
            // VARIABLES PARA CONTROL ===============================================




            if (sock.isConnected) {

                val msg =
                    midX.toString() + "," +
                    midY.toString() + ","+
                    Width_image.toString() + ","+
                    Height_image.toString()+","+
                    result.categories[0].score.toString()+","+
                    left.toString()+","+
                    top.toString()+","+
                    right.toString()+","+
                    bottom.toString()+";"

                //sock.sendData(msg)
                sock.sendData(msg)

                conectado = true

            }else{
                sock.connect()
                conectado = false
            }




            // Draw bounding box around detected objects
            val drawableRect = RectF(left, top, right, bottom)
            canvas.drawRect(drawableRect, boxPaint)

            // Create text to display alongside detected objects
            val drawableText =
                result.categories[0].label + " " +
                        String.format("%.2f", result.categories[0].score)



            // Draw rect behind display text
            textBackgroundPaint.getTextBounds(drawableText, 0, drawableText.length, bounds)
            val textWidth = bounds.width()
            val textHeight = bounds.height()
            canvas.drawRect(
                left,
                top,
                left + textWidth + Companion.BOUNDING_RECT_TEXT_PADDING,
                top + textHeight + Companion.BOUNDING_RECT_TEXT_PADDING,
                textBackgroundPaint
            )

            // Draw text for detected object
            canvas.drawText(drawableText, left, top + bounds.height(), textPaint)
        }
    }

    fun setResults(
      detectionResults: MutableList<Detection>,
      imageHeight: Int,
      imageWidth: Int,
      imgBase64:  String
    ) {
        results = detectionResults
        imageB64send = imgBase64
        scaleFactor = max(width * 1f / imageWidth, height * 1f / imageHeight)
        Width_image = (imageWidth/2f)*scaleFactor
        Height_image = (imageHeight/2f)*scaleFactor - 160

    }

    companion object {
        private const val BOUNDING_RECT_TEXT_PADDING = 8
        var conectado: Boolean = false
    }

}


