package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: Vector.kt */
/* loaded from: classes.dex */
public final class PathComponent extends VNode {
    public Brush fill;
    public float fillAlpha = 1.0f;
    public boolean isPathDirty;
    public boolean isStrokeDirty;
    public boolean isTrimPathDirty;
    public final AndroidPath path;
    public List<? extends PathNode> pathData;
    public final Lazy pathMeasure$delegate;
    public AndroidPath renderPath;
    public Brush stroke;
    public float strokeAlpha;
    public int strokeLineCap;
    public int strokeLineJoin;
    public float strokeLineMiter;
    public float strokeLineWidth;
    public Stroke strokeStyle;
    public float trimPathEnd;
    public float trimPathOffset;
    public float trimPathStart;

    public PathComponent() {
        int r1 = VectorKt.$r8$clinit;
        this.pathData = EmptyList.INSTANCE;
        this.strokeAlpha = 1.0f;
        this.strokeLineCap = 0;
        this.strokeLineJoin = 0;
        this.strokeLineMiter = 4.0f;
        this.trimPathEnd = 1.0f;
        this.isPathDirty = true;
        this.isStrokeDirty = true;
        AndroidPath Path = OnTimeoutKt.Path();
        this.path = Path;
        this.renderPath = Path;
        this.pathMeasure$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0<PathMeasure>() { // from class: androidx.compose.ui.graphics.vector.PathComponent$pathMeasure$2
            @Override // kotlin.jvm.functions.Function0
            public final PathMeasure invoke() {
                return new AndroidPathMeasure(new android.graphics.PathMeasure());
            }
        });
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (this.isPathDirty) {
            PathParserKt.toPath(this.pathData, this.path);
            updateRenderPath();
        } else if (this.isTrimPathDirty) {
            updateRenderPath();
        }
        this.isPathDirty = false;
        this.isTrimPathDirty = false;
        Brush brush = this.fill;
        if (brush != null) {
            DrawScope.m383drawPathGBMwjPU$default(drawScope, this.renderPath, brush, this.fillAlpha, null, 56);
        }
        Brush brush2 = this.stroke;
        if (brush2 != null) {
            Stroke stroke = this.strokeStyle;
            if (this.isStrokeDirty || stroke == null) {
                stroke = new Stroke(this.strokeLineWidth, this.strokeLineMiter, this.strokeLineCap, this.strokeLineJoin, 16);
                this.strokeStyle = stroke;
                this.isStrokeDirty = false;
            }
            DrawScope.m383drawPathGBMwjPU$default(drawScope, this.renderPath, brush2, this.strokeAlpha, stroke, 48);
        }
    }

    public final String toString() {
        return this.path.toString();
    }

    public final void updateRenderPath() {
        boolean z;
        boolean z2 = false;
        if (this.trimPathStart == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        AndroidPath androidPath = this.path;
        if (z) {
            if (this.trimPathEnd == 1.0f) {
                z2 = true;
            }
            if (z2) {
                this.renderPath = androidPath;
                return;
            }
        }
        if (Intrinsics.areEqual(this.renderPath, androidPath)) {
            this.renderPath = OnTimeoutKt.Path();
        } else {
            int mo304getFillTypeRgk1Os = this.renderPath.mo304getFillTypeRgk1Os();
            this.renderPath.rewind();
            this.renderPath.mo306setFillTypeoQ8Xj4U(mo304getFillTypeRgk1Os);
        }
        Lazy lazy = this.pathMeasure$delegate;
        ((PathMeasure) lazy.getValue()).setPath(androidPath);
        float length = ((PathMeasure) lazy.getValue()).getLength();
        float f = this.trimPathStart;
        float f2 = this.trimPathOffset;
        float f3 = ((f + f2) % 1.0f) * length;
        float f4 = ((this.trimPathEnd + f2) % 1.0f) * length;
        if (f3 > f4) {
            ((PathMeasure) lazy.getValue()).getSegment(f3, length, this.renderPath);
            ((PathMeasure) lazy.getValue()).getSegment(0.0f, f4, this.renderPath);
        } else {
            ((PathMeasure) lazy.getValue()).getSegment(f3, f4, this.renderPath);
        }
    }
}
