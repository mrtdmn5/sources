package com.animaconnected.watch.display;

import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.image.GraphicsKt;
import com.animaconnected.watch.image.Kolor;
import com.animaconnected.watch.image.Mitmap;
import java.util.ArrayList;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchKanvas.kt */
/* loaded from: classes3.dex */
public final class WatchKanvas implements Kanvas {
    private float displayMultiplier;
    private final List<DrawCommand> drawCommands;
    private int leftMargin;
    private int topMargin;

    /* compiled from: WatchKanvas.kt */
    /* loaded from: classes3.dex */
    public final class WatchPath implements CanvasPath {
        private List<Point> points = CollectionsKt__CollectionsKt.mutableListOf(new Point(0, 0));

        public WatchPath() {
        }

        @Override // com.animaconnected.watch.display.CanvasPath
        public void archTo(float f, float f2, float f3, float f4, float f5) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // com.animaconnected.watch.display.CanvasPath
        public void close() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // com.animaconnected.watch.display.CanvasPath
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            float f7 = 2;
            PointF pointF = new PointF((f + f3) / f7, (f2 + f4) / f7);
            WatchKanvas.this.drawCommands.add(new LineCommand(((Point) CollectionsKt___CollectionsKt.last(this.points)).getX(), ((Point) CollectionsKt___CollectionsKt.last(this.points)).getY(), (int) pointF.getX(), (int) pointF.getY(), 0, 0, 48, null));
            List list = WatchKanvas.this.drawCommands;
            int x = (int) pointF.getX();
            int y = (int) pointF.getY();
            int r1 = (int) f5;
            int r13 = (int) f6;
            list.add(new LineCommand(x, y, r1, r13, 0, 0, 48, null));
            this.points.add(new Point(r1, r13));
        }

        @Override // com.animaconnected.watch.display.CanvasPath
        public PointF getCurrentPoint() {
            PointF pointF = (PointF) CollectionsKt___CollectionsKt.lastOrNull(getPoints());
            if (pointF == null) {
                return new PointF(0.0f, 0.0f);
            }
            return pointF;
        }

        @Override // com.animaconnected.watch.display.CanvasPath
        public List<PointF> getPoints() {
            List<Point> list = this.points;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            for (Point point : list) {
                arrayList.add(new PointF(point.getX(), point.getY()));
            }
            return arrayList;
        }

        @Override // com.animaconnected.watch.display.CanvasPath
        public void lineTo(float f, float f2) {
            Point point = (Point) CollectionsKt___CollectionsKt.last(this.points);
            int r13 = (int) f;
            int r14 = (int) f2;
            WatchKanvas.this.drawCommands.add(new LineCommand(point.getX(), point.getY(), r13, r14, 0, 0, 48, null));
            this.points.add(new Point(r13, r14));
        }

        @Override // com.animaconnected.watch.display.CanvasPath
        public void moveTo(float f, float f2) {
            this.points.add(new Point((int) f, (int) f2));
        }

        @Override // com.animaconnected.watch.display.CanvasPath
        public void quadTo(float f, float f2, float f3, float f4) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WatchKanvas() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.display.WatchKanvas.<init>():void");
    }

    public static /* synthetic */ void drawContainer$default(WatchKanvas watchKanvas, int r8, int r9, int r10, int r11, int r12, int r13, Object obj) {
        int r5;
        int r6;
        if ((r13 & 8) != 0) {
            r5 = 0;
        } else {
            r5 = r11;
        }
        if ((r13 & 16) != 0) {
            r6 = 0;
        } else {
            r6 = r12;
        }
        watchKanvas.drawContainer(r8, r9, r10, r5, r6);
    }

    public final void clear() {
        this.drawCommands.clear();
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public CanvasPaint createColorPaint(int r2, boolean z, float f, Kanvas.DashedLine dashedLine) {
        WatchPaint watchPaint = new WatchPaint(Kolor.m1537constructorimpl(r2), z, null);
        watchPaint.setWidth(f);
        return watchPaint;
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public CanvasPath createPath() {
        return new WatchPath();
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public CanvasPaint createTextPaint(Kanvas.TextConfig textConfig) {
        Intrinsics.checkNotNullParameter(textConfig, "textConfig");
        return new WatchPaint(Kolor.m1537constructorimpl(textConfig.getTextColor()), false, 2, null);
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawCircle(float f, float f2, float f3, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final void drawContainer(int r9, int r10, int r11, int r12, int r13) {
        this.drawCommands.add(new ContainerCommand(r9, r10, r11, r12, r13));
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawImage(float f, float f2, float f3, float f4, Mitmap mitmap, CanvasPaint canvasPaint) {
        Intrinsics.checkNotNullParameter(mitmap, "mitmap");
        this.drawCommands.add(GraphicsKt.toImageCommand$default(mitmap, (int) (f + this.leftMargin), (int) (f2 + this.topMargin), null, null, 12, null));
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawLine(float f, float f2, float f3, float f4, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        List<DrawCommand> list = this.drawCommands;
        int r3 = this.leftMargin;
        int r5 = this.topMargin;
        list.add(new LineCommand((int) (r3 + f), (int) (r5 + f2), (int) (r3 + f3), (int) (r5 + f4), (int) paint.getWidth(), 0, 32, null));
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawPath(CanvasPath path, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawRect(float f, float f2, float f3, float f4, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        int r1 = this.leftMargin;
        int r5 = (int) (r1 + f);
        int r3 = this.topMargin;
        int r6 = (int) (r3 + f);
        this.drawCommands.add(new RectCommand(r5, r6, r5 - ((int) (r1 + f3)), ((int) (r3 + f2)) - r6, paint.getFill(), 0, paint.getColor(), 32, null));
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void drawText(String text, float f, float f2, float f3, Kanvas.Anchor anchor, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.drawCommands.add(new TextCommand(text, (int) (this.leftMargin + f), (int) (this.topMargin + f2), 0, paint.getFont(), null, null, null, null, 488, null));
    }

    public final void drawWatchText(String text, int r17, int r18, CanvasPaint paint, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.drawCommands.add(new TextCommand(text, this.leftMargin + r17, this.topMargin + r18, 0, paint.getFont(), num, num2, num3, null, 264, null));
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public float getDisplayMultiplier() {
        return this.displayMultiplier;
    }

    public final List<DrawCommand> getDrawCommands() {
        return CollectionsKt___CollectionsKt.toList(this.drawCommands);
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public PointF pointRelativeToAnchor(Kanvas.Anchor anchor, Size size) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(size, "size");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void rotate(float f) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.display.Kanvas
    public void setDisplayMultiplier(float f) {
        this.displayMultiplier = f;
    }

    public WatchKanvas(int r1, int r2) {
        this.leftMargin = r1;
        this.topMargin = r2;
        this.displayMultiplier = 1.0f;
        this.drawCommands = new ArrayList();
    }

    public /* synthetic */ WatchKanvas(int r2, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? 0 : r2, (r4 & 2) != 0 ? 0 : r3);
    }
}
