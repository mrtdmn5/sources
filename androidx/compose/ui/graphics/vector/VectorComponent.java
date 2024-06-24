package androidx.compose.ui.graphics.vector;

import android.graphics.Canvas;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Vector.kt */
/* loaded from: classes.dex */
public final class VectorComponent extends VNode {
    public final DrawCache cacheDrawScope;
    public final VectorComponent$drawVectorBlock$1 drawVectorBlock;
    public final ParcelableSnapshotMutableState intrinsicColorFilter$delegate;
    public Function0<Unit> invalidateCallback;
    public boolean isDirty;
    public long previousDrawSize;
    public final GroupComponent root;
    public float viewportHeight;
    public float viewportWidth;

    public VectorComponent() {
        GroupComponent groupComponent = new GroupComponent();
        groupComponent.pivotX = 0.0f;
        groupComponent.isMatrixDirty = true;
        groupComponent.invalidate();
        groupComponent.pivotY = 0.0f;
        groupComponent.isMatrixDirty = true;
        groupComponent.invalidate();
        groupComponent.setInvalidateListener$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$root$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                VectorComponent vectorComponent = VectorComponent.this;
                vectorComponent.isDirty = true;
                vectorComponent.invalidateCallback.invoke();
                return Unit.INSTANCE;
            }
        });
        this.root = groupComponent;
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$invalidateCallback$1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        };
        this.intrinsicColorFilter$delegate = Platform.mutableStateOf$default(null);
        this.previousDrawSize = Size.Unspecified;
        this.drawVectorBlock = new VectorComponent$drawVectorBlock$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(DrawScope drawScope, float f, ColorFilter colorFilter) {
        boolean z;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        ColorFilter colorFilter2 = colorFilter == null ? (ColorFilter) this.intrinsicColorFilter$delegate.getValue() : colorFilter;
        boolean z2 = this.isDirty;
        DrawCache drawCache = this.cacheDrawScope;
        if (z2 || !Size.m273equalsimpl0(this.previousDrawSize, drawScope.mo391getSizeNHjbRc())) {
            float m276getWidthimpl = Size.m276getWidthimpl(drawScope.mo391getSizeNHjbRc()) / this.viewportWidth;
            GroupComponent groupComponent = this.root;
            groupComponent.scaleX = m276getWidthimpl;
            groupComponent.isMatrixDirty = true;
            groupComponent.invalidate();
            groupComponent.scaleY = Size.m274getHeightimpl(drawScope.mo391getSizeNHjbRc()) / this.viewportHeight;
            groupComponent.isMatrixDirty = true;
            groupComponent.invalidate();
            long IntSize = IntSizeKt.IntSize((int) Math.ceil(Size.m276getWidthimpl(drawScope.mo391getSizeNHjbRc())), (int) Math.ceil(Size.m274getHeightimpl(drawScope.mo391getSizeNHjbRc())));
            LayoutDirection layoutDirection = drawScope.getLayoutDirection();
            drawCache.getClass();
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            VectorComponent$drawVectorBlock$1 block = this.drawVectorBlock;
            Intrinsics.checkNotNullParameter(block, "block");
            drawCache.scopeDensity = drawScope;
            AndroidImageBitmap androidImageBitmap = drawCache.mCachedImage;
            AndroidCanvas androidCanvas = drawCache.cachedCanvas;
            if (androidImageBitmap == null || androidCanvas == null || ((int) (IntSize >> 32)) > androidImageBitmap.getWidth() || IntSize.m593getHeightimpl(IntSize) > androidImageBitmap.getHeight()) {
                androidImageBitmap = ImageBitmapKt.m336ImageBitmapx__hDU$default((int) (IntSize >> 32), IntSize.m593getHeightimpl(IntSize), 0, 28);
                Canvas canvas = AndroidCanvas_androidKt.EmptyCanvas;
                androidCanvas = new AndroidCanvas();
                androidCanvas.internalCanvas = new Canvas(AndroidImageBitmap_androidKt.asAndroidBitmap(androidImageBitmap));
                drawCache.mCachedImage = androidImageBitmap;
                drawCache.cachedCanvas = androidCanvas;
            }
            drawCache.size = IntSize;
            long m595toSizeozmzZPI = IntSizeKt.m595toSizeozmzZPI(IntSize);
            CanvasDrawScope canvasDrawScope = drawCache.cacheScope;
            CanvasDrawScope.DrawParams drawParams = canvasDrawScope.drawParams;
            Density density = drawParams.density;
            LayoutDirection layoutDirection2 = drawParams.layoutDirection;
            androidx.compose.ui.graphics.Canvas canvas2 = drawParams.canvas;
            long j = drawParams.size;
            drawParams.density = drawScope;
            drawParams.layoutDirection = layoutDirection;
            drawParams.canvas = androidCanvas;
            drawParams.size = m595toSizeozmzZPI;
            androidCanvas.save();
            DrawScope.m386drawRectnJ9OG0$default(canvasDrawScope, Color.Black, 0L, 0L, 0.0f, 62);
            block.invoke(canvasDrawScope);
            androidCanvas.restore();
            CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.drawParams;
            drawParams2.getClass();
            Intrinsics.checkNotNullParameter(density, "<set-?>");
            drawParams2.density = density;
            Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
            drawParams2.layoutDirection = layoutDirection2;
            Intrinsics.checkNotNullParameter(canvas2, "<set-?>");
            drawParams2.canvas = canvas2;
            drawParams2.size = j;
            androidImageBitmap.bitmap.prepareToDraw();
            z = false;
            this.isDirty = false;
            this.previousDrawSize = drawScope.mo391getSizeNHjbRc();
        } else {
            z = false;
        }
        drawCache.getClass();
        AndroidImageBitmap androidImageBitmap2 = drawCache.mCachedImage;
        if (androidImageBitmap2 != null) {
            z = true;
        }
        if (z) {
            DrawScope.m379drawImageAZ2fEMs$default(drawScope, androidImageBitmap2, 0L, drawCache.size, 0L, 0L, f, null, colorFilter2, 0, 0, 858);
            return;
        }
        throw new IllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination".toString());
    }

    public final String toString() {
        String str = "Params: \tname: " + this.root.name + "\n\tviewportWidth: " + this.viewportWidth + "\n\tviewportHeight: " + this.viewportHeight + "\n";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        draw(drawScope, 1.0f, null);
    }
}
