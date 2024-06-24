package com.animaconnected.watch.image.pickers;

import com.animaconnected.watch.image.Kolor;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PalettePicker.kt */
/* loaded from: classes3.dex */
public final class PalettePickerKt {
    /* renamed from: closestValue-8COdPW0, reason: not valid java name */
    public static final Kolor m1550closestValue8COdPW0(List<Kolor> closestValue, int r8) {
        Object obj;
        Intrinsics.checkNotNullParameter(closestValue, "$this$closestValue");
        Iterator<T> it = closestValue.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                double abs = Math.abs(m1551distanceTonjUnlhg(((Kolor) next).m1546unboximpl(), r8));
                do {
                    Object next2 = it.next();
                    double abs2 = Math.abs(m1551distanceTonjUnlhg(((Kolor) next2).m1546unboximpl(), r8));
                    if (Double.compare(abs, abs2) > 0) {
                        next = next2;
                        abs = abs2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        return (Kolor) obj;
    }

    /* renamed from: distanceTo-njUnlhg, reason: not valid java name */
    public static final double m1551distanceTonjUnlhg(int r6, int r7) {
        return Math.sqrt(Math.pow(Kolor.m1540getAlphaimpl(r6) - Kolor.m1540getAlphaimpl(r7), 2.0d) + Math.pow(Kolor.m1541getBlueimpl(r6) - Kolor.m1541getBlueimpl(r7), 2.0d) + Math.pow(Kolor.m1542getGreenimpl(r6) - Kolor.m1542getGreenimpl(r7), 2.0d) + Math.pow(Kolor.m1543getRedimpl(r6) - Kolor.m1543getRedimpl(r7), 2.0d));
    }
}
