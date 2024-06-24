package com.airbnb.lottie.utils;

import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.KeyPath;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class MiscUtils {
    public static final PointF pathFromDataCurrentPoint = new PointF();

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int floorMod(float f, float f2) {
        boolean z;
        int r3 = (int) f;
        int r4 = (int) f2;
        int r0 = r3 / r4;
        if ((r3 ^ r4) >= 0) {
            z = true;
        } else {
            z = false;
        }
        int r2 = r3 % r4;
        if (!z && r2 != 0) {
            r0--;
        }
        return r3 - (r4 * r0);
    }

    public static void resolveKeyPath(KeyPath keyPath, int r2, ArrayList arrayList, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.fullyResolvesTo(r2, keyPathElementContent.getName())) {
            String name = keyPathElementContent.getName();
            keyPath2.getClass();
            KeyPath keyPath3 = new KeyPath(keyPath2);
            keyPath3.keys.add(name);
            KeyPath keyPath4 = new KeyPath(keyPath3);
            keyPath4.resolvedElement = keyPathElementContent;
            arrayList.add(keyPath4);
        }
    }
}
