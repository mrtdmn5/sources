package com.animaconnected.watch.display;

import android.graphics.Path;
import android.os.Build;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt$asList$5;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKanvas.kt */
/* loaded from: classes3.dex */
public final class AndroidPath implements CanvasPath {
    private final Path path;

    public AndroidPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    @Override // com.animaconnected.watch.display.CanvasPath
    public void archTo(float f, float f2, float f3, float f4, float f5) {
        this.path.arcTo(DpUtilsKt.toPx(f - f3), DpUtilsKt.toPx(f2 - f3), DpUtilsKt.toPx(f + f3), DpUtilsKt.toPx(f2 + f3), f4, f5, false);
    }

    @Override // com.animaconnected.watch.display.CanvasPath
    public void close() {
        this.path.close();
    }

    @Override // com.animaconnected.watch.display.CanvasPath
    public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.path.cubicTo(DpUtilsKt.toPx(f), DpUtilsKt.toPx(f2), DpUtilsKt.toPx(f3), DpUtilsKt.toPx(f4), DpUtilsKt.toPx(f5), DpUtilsKt.toPx(f6));
    }

    @Override // com.animaconnected.watch.display.CanvasPath
    public PointF getCurrentPoint() {
        PointF pointF = (PointF) CollectionsKt___CollectionsKt.lastOrNull(getPoints());
        if (pointF == null) {
            return PointF.Companion.getZero();
        }
        return pointF;
    }

    public final Path getPath$graphics_release() {
        return this.path;
    }

    @Override // com.animaconnected.watch.display.CanvasPath
    public List<PointF> getPoints() {
        float[] approximate;
        if (Build.VERSION.SDK_INT >= 26) {
            approximate = this.path.approximate(0.5f);
            Intrinsics.checkNotNull(approximate);
            return CollectionsKt___CollectionsKt.windowed(new ArraysKt___ArraysJvmKt$asList$5(approximate), 3, 3, false, new Function1<List<? extends Float>, PointF>() { // from class: com.animaconnected.watch.display.AndroidPath$getPoints$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final PointF invoke2(List<Float> list) {
                    Intrinsics.checkNotNullParameter(list, "<name for destructuring parameter 0>");
                    return new PointF(DpUtilsKt.toDp(list.get(1).floatValue()), DpUtilsKt.toDp(list.get(2).floatValue()));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ PointF invoke(List<? extends Float> list) {
                    return invoke2((List<Float>) list);
                }
            });
        }
        throw new UnsupportedOperationException("WatchPath not supported");
    }

    @Override // com.animaconnected.watch.display.CanvasPath
    public void lineTo(float f, float f2) {
        this.path.lineTo(DpUtilsKt.toPx(f), DpUtilsKt.toPx(f2));
    }

    @Override // com.animaconnected.watch.display.CanvasPath
    public void moveTo(float f, float f2) {
        this.path.moveTo(DpUtilsKt.toPx(f), DpUtilsKt.toPx(f2));
    }

    @Override // com.animaconnected.watch.display.CanvasPath
    public void quadTo(float f, float f2, float f3, float f4) {
        this.path.quadTo(DpUtilsKt.toPx(f), DpUtilsKt.toPx(f2), DpUtilsKt.toPx(f3), DpUtilsKt.toPx(f4));
    }
}
