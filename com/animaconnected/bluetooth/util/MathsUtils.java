package com.animaconnected.bluetooth.util;

/* loaded from: classes.dex */
public class MathsUtils {
    public static double floorMod(double d, double d2) {
        return ((d % d2) + d2) % d2;
    }

    public static int floorMod(int r0, int r1) {
        return ((r0 % r1) + r1) % r1;
    }
}
