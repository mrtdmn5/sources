package androidx.compose.foundation;

import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawModifierNodeImpl;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: Border.kt */
/* loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode {
    public BorderCache borderCache;
    public Brush brush;
    public final CacheDrawModifierNode drawWithCacheModifierNode;
    public Shape shape;
    public float width;

    public BorderModifierNode(float f, Brush brushParameter, Shape shapeParameter) {
        Intrinsics.checkNotNullParameter(brushParameter, "brushParameter");
        Intrinsics.checkNotNullParameter(shapeParameter, "shapeParameter");
        this.width = f;
        this.brush = brushParameter;
        this.shape = shapeParameter;
        CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl = new CacheDrawModifierNodeImpl(new CacheDrawScope(), new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                boolean z;
                float ceil;
                DrawStyle stroke;
                final Brush brush;
                Object nativeColorFilter;
                CacheDrawScope CacheDrawModifierNode = cacheDrawScope;
                Intrinsics.checkNotNullParameter(CacheDrawModifierNode, "$this$CacheDrawModifierNode");
                BorderModifierNode borderModifierNode = BorderModifierNode.this;
                boolean z2 = true;
                if (CacheDrawModifierNode.getDensity() * borderModifierNode.width >= 0.0f && Size.m275getMinDimensionimpl(CacheDrawModifierNode.m231getSizeNHjbRc()) > 0.0f) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return CacheDrawModifierNode.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawContentWithoutBorder$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ContentDrawScope contentDrawScope) {
                            ContentDrawScope onDrawWithContent = contentDrawScope;
                            Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                            onDrawWithContent.drawContent();
                            return Unit.INSTANCE;
                        }
                    });
                }
                if (Dp.m579equalsimpl0(borderModifierNode.width, 0.0f)) {
                    ceil = 1.0f;
                } else {
                    ceil = (float) Math.ceil(CacheDrawModifierNode.getDensity() * borderModifierNode.width);
                }
                float f2 = 2;
                final float min = Math.min(ceil, (float) Math.ceil(Size.m275getMinDimensionimpl(CacheDrawModifierNode.m231getSizeNHjbRc()) / f2));
                final float f3 = min / f2;
                final long Offset = OffsetKt.Offset(f3, f3);
                final long Size = SizeKt.Size(Size.m276getWidthimpl(CacheDrawModifierNode.m231getSizeNHjbRc()) - min, Size.m274getHeightimpl(CacheDrawModifierNode.m231getSizeNHjbRc()) - min);
                if (f2 * min <= Size.m275getMinDimensionimpl(CacheDrawModifierNode.m231getSizeNHjbRc())) {
                    z2 = false;
                }
                Outline mo27createOutlinePq9zytI = borderModifierNode.shape.mo27createOutlinePq9zytI(CacheDrawModifierNode.m231getSizeNHjbRc(), CacheDrawModifierNode.cacheParams.getLayoutDirection(), CacheDrawModifierNode);
                if (mo27createOutlinePq9zytI instanceof Outline.Generic) {
                    final Brush brush2 = borderModifierNode.brush;
                    final Outline.Generic generic = (Outline.Generic) mo27createOutlinePq9zytI;
                    if (z2) {
                        return CacheDrawModifierNode.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ContentDrawScope contentDrawScope) {
                                ContentDrawScope onDrawWithContent = contentDrawScope;
                                Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                                onDrawWithContent.drawContent();
                                Outline.Generic.this.getClass();
                                DrawScope.m383drawPathGBMwjPU$default(onDrawWithContent, null, brush2, 0.0f, null, 60);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    if (brush2 instanceof SolidColor) {
                        long j = ((SolidColor) brush2).value;
                        if (Build.VERSION.SDK_INT >= 29) {
                            nativeColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(j, 5);
                        } else {
                            nativeColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(j), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
                        }
                        Intrinsics.checkNotNullParameter(nativeColorFilter, "nativeColorFilter");
                    }
                    generic.getClass();
                    throw null;
                }
                if (mo27createOutlinePq9zytI instanceof Outline.Rounded) {
                    final Brush brush3 = borderModifierNode.brush;
                    Outline.Rounded rounded = (Outline.Rounded) mo27createOutlinePq9zytI;
                    boolean isSimple = RoundRectKt.isSimple(rounded.roundRect);
                    RoundRect roundRect = rounded.roundRect;
                    if (isSimple) {
                        final long j2 = roundRect.topLeftCornerRadius;
                        final Stroke stroke2 = new Stroke(min, 0.0f, 0, 0, 30);
                        final boolean z3 = z2;
                        return CacheDrawModifierNode.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ContentDrawScope contentDrawScope) {
                                ContentDrawScope onDrawWithContent = contentDrawScope;
                                Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                                onDrawWithContent.drawContent();
                                if (z3) {
                                    DrawScope.m387drawRoundRectZuiqVtQ$default(onDrawWithContent, brush3, 0L, 0L, j2, null, 246);
                                } else {
                                    long j3 = j2;
                                    float m253getXimpl = CornerRadius.m253getXimpl(j3);
                                    float f4 = f3;
                                    if (m253getXimpl < f4) {
                                        float f5 = min;
                                        float m276getWidthimpl = Size.m276getWidthimpl(onDrawWithContent.mo391getSizeNHjbRc());
                                        float f6 = min;
                                        float f7 = m276getWidthimpl - f6;
                                        float m274getHeightimpl = Size.m274getHeightimpl(onDrawWithContent.mo391getSizeNHjbRc()) - f6;
                                        Brush brush4 = brush3;
                                        long j4 = j2;
                                        CanvasDrawScope$drawContext$1 drawContext = onDrawWithContent.getDrawContext();
                                        long mo370getSizeNHjbRc = drawContext.mo370getSizeNHjbRc();
                                        drawContext.getCanvas().save();
                                        drawContext.transform.m373clipRectN_I0leg(f5, f5, f7, m274getHeightimpl, 0);
                                        DrawScope.m387drawRoundRectZuiqVtQ$default(onDrawWithContent, brush4, 0L, 0L, j4, null, 246);
                                        drawContext.getCanvas().restore();
                                        drawContext.mo371setSizeuvyYCjk(mo370getSizeNHjbRc);
                                    } else {
                                        DrawScope.m387drawRoundRectZuiqVtQ$default(onDrawWithContent, brush3, Offset, Size, BorderKt.m23shrinkKibmq7A(f4, j3), stroke2, 208);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    if (borderModifierNode.borderCache == null) {
                        borderModifierNode.borderCache = new BorderCache(0);
                    }
                    BorderCache borderCache = borderModifierNode.borderCache;
                    Intrinsics.checkNotNull(borderCache);
                    final Path path = borderCache.borderPath;
                    if (path == null) {
                        path = OnTimeoutKt.Path();
                        borderCache.borderPath = path;
                    }
                    path.reset();
                    path.addRoundRect(roundRect);
                    if (!z2) {
                        AndroidPath Path = OnTimeoutKt.Path();
                        float f4 = (roundRect.right - roundRect.left) - min;
                        float f5 = (roundRect.bottom - roundRect.top) - min;
                        long m23shrinkKibmq7A = BorderKt.m23shrinkKibmq7A(min, roundRect.topLeftCornerRadius);
                        long m23shrinkKibmq7A2 = BorderKt.m23shrinkKibmq7A(min, roundRect.topRightCornerRadius);
                        long m23shrinkKibmq7A3 = BorderKt.m23shrinkKibmq7A(min, roundRect.bottomLeftCornerRadius);
                        long m23shrinkKibmq7A4 = BorderKt.m23shrinkKibmq7A(min, roundRect.bottomRightCornerRadius);
                        brush = brush3;
                        Path.addRoundRect(new RoundRect(min, min, f4, f5, m23shrinkKibmq7A, m23shrinkKibmq7A2, m23shrinkKibmq7A4, m23shrinkKibmq7A3));
                        path.mo305opN5in7k0(path, Path, 0);
                    } else {
                        brush = brush3;
                    }
                    return CacheDrawModifierNode.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ContentDrawScope contentDrawScope) {
                            ContentDrawScope onDrawWithContent = contentDrawScope;
                            Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                            onDrawWithContent.drawContent();
                            DrawScope.m383drawPathGBMwjPU$default(onDrawWithContent, Path.this, brush, 0.0f, null, 60);
                            return Unit.INSTANCE;
                        }
                    });
                }
                if (mo27createOutlinePq9zytI instanceof Outline.Rectangle) {
                    final Brush brush4 = borderModifierNode.brush;
                    if (z2) {
                        Offset = Offset.Zero;
                    }
                    if (z2) {
                        Size = CacheDrawModifierNode.m231getSizeNHjbRc();
                    }
                    if (z2) {
                        stroke = Fill.INSTANCE;
                    } else {
                        stroke = new Stroke(min, 0.0f, 0, 0, 30);
                    }
                    final DrawStyle drawStyle = stroke;
                    final long j3 = Offset;
                    final long j4 = Size;
                    return CacheDrawModifierNode.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderKt$drawRectBorder$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ContentDrawScope contentDrawScope) {
                            ContentDrawScope onDrawWithContent = contentDrawScope;
                            Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                            onDrawWithContent.drawContent();
                            DrawScope.m385drawRectAsUm42w$default(onDrawWithContent, Brush.this, j3, j4, 0.0f, drawStyle, 0, 104);
                            return Unit.INSTANCE;
                        }
                    });
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        delegate(cacheDrawModifierNodeImpl);
        this.drawWithCacheModifierNode = cacheDrawModifierNodeImpl;
    }
}
