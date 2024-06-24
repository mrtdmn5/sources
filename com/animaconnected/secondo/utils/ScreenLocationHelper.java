package com.animaconnected.secondo.utils;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.Size;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowMetrics;

/* loaded from: classes3.dex */
public class ScreenLocationHelper {
    public static Size getScreenSize(Context context) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return new Size(0, 0);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            return new Size(bounds.width(), bounds.height());
        }
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return new Size(0, 0);
        }
        Display display = displayManager.getDisplay(0);
        Point point = new Point();
        display.getSize(point);
        return new Size(point.x, point.y);
    }

    public static Point getViewCenterOnScreen(View view) {
        int[] r1 = new int[2];
        view.getLocationInWindow(r1);
        return new Point((view.getWidth() / 2) + r1[0], (view.getHeight() / 2) + r1[1]);
    }
}
