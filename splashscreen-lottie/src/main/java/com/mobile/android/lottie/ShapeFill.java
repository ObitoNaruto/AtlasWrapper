package com.mobile.android.lottie;

import android.graphics.Path;
import android.support.annotation.Nullable;

import org.json.JSONObject;

class ShapeFill {
  private final boolean fillEnabled;
  private final Path.FillType fillType;
  @Nullable private final AnimatableColorValue color;
  @Nullable private final AnimatableIntegerValue opacity;

  private ShapeFill(boolean fillEnabled, Path.FillType fillType,
      @Nullable AnimatableColorValue color, @Nullable AnimatableIntegerValue opacity) {
    this.fillEnabled = fillEnabled;
    this.fillType = fillType;
    this.color = color;
    this.opacity = opacity;
  }

  static class Factory {
    private Factory() {
    }

    static ShapeFill newInstance(JSONObject json, LottieComposition composition) {
      AnimatableColorValue color = null;
      boolean fillEnabled;
      AnimatableIntegerValue opacity = null;

      JSONObject jsonColor = json.optJSONObject("c");
      if (jsonColor != null) {
        color = AnimatableColorValue.Factory.newInstance(jsonColor, composition);
      }

      JSONObject jsonOpacity = json.optJSONObject("o");
      if (jsonOpacity != null) {
        opacity = AnimatableIntegerValue.Factory.newInstance(jsonOpacity, composition);
      }
      fillEnabled = json.optBoolean("fillEnabled");

      int fillTypeInt = json.optInt("r", 1);
      Path.FillType fillType = fillTypeInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;

      return new ShapeFill(fillEnabled, fillType, color, opacity);
    }
  }

  @Nullable AnimatableColorValue getColor() {
    return color;
  }

  @Nullable AnimatableIntegerValue getOpacity() {
    return opacity;
  }

  Path.FillType getFillType() {
    return fillType;
  }

  @Override
  public String toString() {
    return "ShapeFill{" + "color=" +
        (color == null ? "null" :  Integer.toHexString(color.getInitialValue())) +
        ", fillEnabled=" + fillEnabled +
        ", opacity=" + (opacity == null ? "null" : opacity.getInitialValue()) +
        '}';
  }
}
