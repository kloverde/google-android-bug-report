package com.demo

import android.service.wallpaper.WallpaperService

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder


class DemoWallpaper: WallpaperService() {
   override fun onCreateEngine(): Engine = WallpaperEngine()

   inner class WallpaperEngine : WallpaperService.Engine() {
      override fun onSurfaceChanged(
         holder: SurfaceHolder,
         format: Int,
         width: Int,
         height: Int
      ) {
         super.onSurfaceChanged(holder, format, width, height)

         val paint = Paint()
         paint.color = Color.BLACK
         paint.style = Paint.Style.FILL
         paint.textSize = 400f

         val canvas: Canvas = holder.lockCanvas()

         canvas.drawColor( Color.WHITE )
         canvas.drawText("Hello", 0f, height / 2f, paint)

         holder.unlockCanvasAndPost(canvas)
      }
   }
}
