package com.mobile.android.lottie;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class BitmapCanvas extends Canvas {

  private final Bitmap bitmap;

  BitmapCanvas(Bitmap bitmap) {
    super(bitmap);
    this.bitmap = bitmap;
  }

  Bitmap getBitmap() {
    return bitmap;
  }
}
