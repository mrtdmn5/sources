package com.animaconnected.watch.display;

import java.util.List;

/* compiled from: Kanvas.kt */
/* loaded from: classes3.dex */
public interface CanvasPath {
    void archTo(float f, float f2, float f3, float f4, float f5);

    void close();

    void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    PointF getCurrentPoint();

    List<PointF> getPoints();

    void lineTo(float f, float f2);

    void moveTo(float f, float f2);

    void quadTo(float f, float f2, float f3, float f4);
}
