package com.animaconnected.draganddrop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Utilities {
    public static float getDescendantCoordRelativeToParent(View view, View view2, int[] r11, boolean z) {
        ArrayList arrayList = new ArrayList();
        float[] fArr = {r11[0], r11[1]};
        for (View view3 = view; view3 != view2 && view3 != null; view3 = (View) view3.getParent()) {
            arrayList.add(view3);
        }
        arrayList.add(view2);
        int size = arrayList.size();
        float f = 1.0f;
        for (int r5 = 0; r5 < size; r5++) {
            View view4 = (View) arrayList.get(r5);
            if (view4 != view || z) {
                fArr[0] = fArr[0] - view4.getScrollX();
                fArr[1] = fArr[1] - view4.getScrollY();
            }
            view4.getMatrix().mapPoints(fArr);
            fArr[0] = fArr[0] + view4.getLeft();
            fArr[1] = fArr[1] + view4.getTop();
            f *= view4.getScaleX();
        }
        r11[0] = Math.round(fArr[0]);
        r11[1] = Math.round(fArr[1]);
        return f;
    }

    public static Typeface getTypefaceFromFontPath(Context context, String str) {
        try {
            return Typeface.createFromAsset(context.getAssets(), str);
        } catch (RuntimeException unused) {
            return Typeface.create(str, 0);
        }
    }

    public static Typeface getTypefaceFromResource(Context context, int r1) {
        try {
            return ResourcesCompat.getFont(context, r1);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static float mapCoordInSelfToDescendent(View view, View view2, int[] r11) {
        View view3;
        ArrayList arrayList = new ArrayList();
        float[] fArr = {r11[0], r11[1]};
        while (view != view2) {
            arrayList.add(view);
            view = (View) view.getParent();
        }
        arrayList.add(view2);
        Matrix matrix = new Matrix();
        float f = 1.0f;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            View view4 = (View) arrayList.get(size);
            if (size > 0) {
                view3 = (View) arrayList.get(size - 1);
            } else {
                view3 = null;
            }
            fArr[0] = fArr[0] + view4.getScrollX();
            fArr[1] = fArr[1] + view4.getScrollY();
            if (view3 != null) {
                fArr[0] = fArr[0] - view3.getLeft();
                fArr[1] = fArr[1] - view3.getTop();
                view3.getMatrix().invert(matrix);
                matrix.mapPoints(fArr);
                f = view3.getScaleX() * f;
            }
        }
        r11[0] = Math.round(fArr[0]);
        r11[1] = Math.round(fArr[1]);
        return f;
    }
}
