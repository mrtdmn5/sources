package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.RectF;
import com.animaconnected.watch.graphs.TouchListener;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkerView.kt */
/* loaded from: classes3.dex */
public final class MarkerViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void configureBounds(MarkerView markerView, float f, float f2) {
        float xPos = markerView.getXPos() - (f / 2);
        float yPos = (markerView.getYPos() - f2) - markerView.getPadding();
        if (yPos < markerView.getOuterBounds().getTop()) {
            yPos = markerView.getYPos() + markerView.getPadding();
        }
        markerView.setBounds(new RectF(xPos, yPos, f + xPos, f2 + yPos));
        RectF copy$default = RectF.copy$default(markerView.getBounds(), 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        copy$default.inset(-8.0f, -16.0f);
        if (markerView.getBounds().getTop() < markerView.getOuterBounds().getTop()) {
            RectF.offset$default(markerView.getBounds(), 0.0f, markerView.getOuterBounds().getTop() - markerView.getBounds().getTop(), 1, null);
        } else if (markerView.getBounds().getBottom() > markerView.getOuterBounds().getBottom()) {
            RectF.offset$default(markerView.getBounds(), 0.0f, markerView.getOuterBounds().getBottom() - markerView.getBounds().getBottom(), 1, null);
        }
        if (copy$default.contains(markerView.getTouchPosition()) && (markerView.getTouchEvent() instanceof TouchListener.Event.Changed)) {
            RectF.offset$default(markerView.getBounds(), -56.0f, 0.0f, 2, null);
        }
        if (markerView.getBounds().getLeft() < markerView.getOuterBounds().getLeft()) {
            RectF.offset$default(markerView.getBounds(), markerView.getOuterBounds().getLeft() - markerView.getBounds().getLeft(), 0.0f, 2, null);
        } else if (markerView.getBounds().getRight() > markerView.getOuterBounds().getRight()) {
            RectF.offset$default(markerView.getBounds(), markerView.getOuterBounds().getRight() - markerView.getBounds().getRight(), 0.0f, 2, null);
        }
    }

    public static final boolean resetPosition(MarkerView markerView) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(markerView, "<this>");
        boolean z3 = true;
        if (markerView.getXPos() == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (markerView.getYPos() == 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                RectF bounds = markerView.getBounds();
                RectF.Companion companion = RectF.Companion;
                if (Intrinsics.areEqual(bounds, companion.getZero()) && Intrinsics.areEqual(markerView.getOuterBounds(), companion.getZero())) {
                    z3 = false;
                }
            }
        }
        if (z3) {
            markerView.setXPos(0.0f);
            markerView.setYPos(0.0f);
            RectF.Companion companion2 = RectF.Companion;
            markerView.setBounds(companion2.getZero());
            markerView.setOuterBounds(companion2.getZero());
        }
        return z3;
    }
}
