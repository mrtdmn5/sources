package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import java.util.List;

/* compiled from: VectorPainter.kt */
/* loaded from: classes.dex */
public abstract class VectorProperty<T> {

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class Fill extends VectorProperty<Brush> {
        public static final Fill INSTANCE = new Fill();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class FillAlpha extends VectorProperty<Float> {
        public static final FillAlpha INSTANCE = new FillAlpha();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class PathData extends VectorProperty<List<? extends PathNode>> {
        public static final PathData INSTANCE = new PathData();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class PivotX extends VectorProperty<Float> {
        public static final PivotX INSTANCE = new PivotX();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class PivotY extends VectorProperty<Float> {
        public static final PivotY INSTANCE = new PivotY();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class Rotation extends VectorProperty<Float> {
        public static final Rotation INSTANCE = new Rotation();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class ScaleX extends VectorProperty<Float> {
        public static final ScaleX INSTANCE = new ScaleX();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class ScaleY extends VectorProperty<Float> {
        public static final ScaleY INSTANCE = new ScaleY();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class Stroke extends VectorProperty<Brush> {
        public static final Stroke INSTANCE = new Stroke();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class StrokeAlpha extends VectorProperty<Float> {
        public static final StrokeAlpha INSTANCE = new StrokeAlpha();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class StrokeLineWidth extends VectorProperty<Float> {
        public static final StrokeLineWidth INSTANCE = new StrokeLineWidth();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TranslateX extends VectorProperty<Float> {
        public static final TranslateX INSTANCE = new TranslateX();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TranslateY extends VectorProperty<Float> {
        public static final TranslateY INSTANCE = new TranslateY();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TrimPathEnd extends VectorProperty<Float> {
        public static final TrimPathEnd INSTANCE = new TrimPathEnd();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TrimPathOffset extends VectorProperty<Float> {
        public static final TrimPathOffset INSTANCE = new TrimPathOffset();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TrimPathStart extends VectorProperty<Float> {
        public static final TrimPathStart INSTANCE = new TrimPathStart();
    }
}
