package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WrapContentElement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class SizeKt {
    public static final FillElement FillWholeMaxHeight;
    public static final FillElement FillWholeMaxSize;
    public static final FillElement FillWholeMaxWidth;
    public static final WrapContentElement WrapContentHeightCenter;
    public static final WrapContentElement WrapContentHeightTop;
    public static final WrapContentElement WrapContentSizeCenter;
    public static final WrapContentElement WrapContentSizeTopStart;

    static {
        Direction direction = Direction.Horizontal;
        FillWholeMaxWidth = new FillElement(direction, 1.0f, "fillMaxWidth");
        FillWholeMaxHeight = new FillElement(Direction.Vertical, 1.0f, "fillMaxHeight");
        FillWholeMaxSize = new FillElement(Direction.Both, 1.0f, "fillMaxSize");
        final BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        new WrapContentElement(direction, false, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$width$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final IntOffset invoke(IntSize intSize, LayoutDirection layoutDirection) {
                long j = intSize.packedValue;
                LayoutDirection layoutDirection2 = layoutDirection;
                Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
                return new IntOffset(IntOffsetKt.IntOffset(horizontal.align(0, (int) (j >> 32), layoutDirection2), 0));
            }
        }, horizontal, "wrapContentWidth");
        final BiasAlignment.Horizontal horizontal2 = Alignment.Companion.Start;
        new WrapContentElement(direction, false, new Function2<IntSize, LayoutDirection, IntOffset>() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$width$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final IntOffset invoke(IntSize intSize, LayoutDirection layoutDirection) {
                long j = intSize.packedValue;
                LayoutDirection layoutDirection2 = layoutDirection;
                Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
                return new IntOffset(IntOffsetKt.IntOffset(horizontal2.align(0, (int) (j >> 32), layoutDirection2), 0));
            }
        }, horizontal2, "wrapContentWidth");
        WrapContentHeightCenter = WrapContentElement.Companion.height(Alignment.Companion.CenterVertically, false);
        WrapContentHeightTop = WrapContentElement.Companion.height(Alignment.Companion.Top, false);
        WrapContentSizeCenter = WrapContentElement.Companion.size(Alignment.Companion.Center, false);
        WrapContentSizeTopStart = WrapContentElement.Companion.size(Alignment.Companion.TopStart, false);
    }

    /* renamed from: defaultMinSize-VpY3zN4 */
    public static final Modifier m81defaultMinSizeVpY3zN4(Modifier defaultMinSize, float f, float f2) {
        Intrinsics.checkNotNullParameter(defaultMinSize, "$this$defaultMinSize");
        return defaultMinSize.then(new UnspecifiedConstraintsElement(f, f2));
    }

    /* renamed from: defaultMinSize-VpY3zN4$default */
    public static /* synthetic */ Modifier m82defaultMinSizeVpY3zN4$default(Modifier modifier, float f, int r4) {
        float f2;
        if ((r4 & 1) != 0) {
            f2 = Float.NaN;
        } else {
            f2 = 0.0f;
        }
        if ((r4 & 2) != 0) {
            f = Float.NaN;
        }
        return m81defaultMinSizeVpY3zN4(modifier, f2, f);
    }

    public static final Modifier fillMaxHeight(Modifier modifier, float f) {
        boolean z;
        FillElement fillElement;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (f == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            fillElement = FillWholeMaxHeight;
        } else {
            fillElement = new FillElement(Direction.Vertical, f, "fillMaxHeight");
        }
        return modifier.then(fillElement);
    }

    public static Modifier fillMaxSize$default(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then(FillWholeMaxSize);
    }

    public static final Modifier fillMaxWidth(Modifier modifier, float f) {
        boolean z;
        FillElement fillElement;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (f == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            fillElement = FillWholeMaxWidth;
        } else {
            fillElement = new FillElement(Direction.Horizontal, f, "fillMaxWidth");
        }
        return modifier.then(fillElement);
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier) {
        return fillMaxWidth(modifier, 1.0f);
    }

    /* renamed from: height-3ABfNKs */
    public static final Modifier m83height3ABfNKs(Modifier height, float f) {
        Intrinsics.checkNotNullParameter(height, "$this$height");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return height.then(new SizeElement(0.0f, f, 0.0f, f, true, 5));
    }

    /* renamed from: heightIn-VpY3zN4 */
    public static final Modifier m84heightInVpY3zN4(Modifier heightIn, float f, float f2) {
        Intrinsics.checkNotNullParameter(heightIn, "$this$heightIn");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return heightIn.then(new SizeElement(0.0f, f, 0.0f, f2, true, 5));
    }

    /* renamed from: heightIn-VpY3zN4$default */
    public static /* synthetic */ Modifier m85heightInVpY3zN4$default(Modifier modifier, float f, float f2, int r5) {
        if ((r5 & 1) != 0) {
            f = Float.NaN;
        }
        if ((r5 & 2) != 0) {
            f2 = Float.NaN;
        }
        return m84heightInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: requiredHeight-3ABfNKs */
    public static final Modifier m86requiredHeight3ABfNKs(Modifier requiredHeight, float f) {
        Intrinsics.checkNotNullParameter(requiredHeight, "$this$requiredHeight");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return requiredHeight.then(new SizeElement(0.0f, f, 0.0f, f, false, 5));
    }

    /* renamed from: requiredHeightIn-VpY3zN4$default */
    public static Modifier m87requiredHeightInVpY3zN4$default(Modifier requiredHeightIn, float f) {
        Intrinsics.checkNotNullParameter(requiredHeightIn, "$this$requiredHeightIn");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return requiredHeightIn.then(new SizeElement(0.0f, f, 0.0f, Float.NaN, false, 5));
    }

    /* renamed from: requiredSize-3ABfNKs */
    public static final Modifier m88requiredSize3ABfNKs(Modifier requiredSize, float f) {
        Intrinsics.checkNotNullParameter(requiredSize, "$this$requiredSize");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return requiredSize.then(new SizeElement(f, f, f, f, false));
    }

    /* renamed from: requiredSize-VpY3zN4 */
    public static final Modifier m89requiredSizeVpY3zN4(Modifier requiredSize, float f, float f2) {
        Intrinsics.checkNotNullParameter(requiredSize, "$this$requiredSize");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return requiredSize.then(new SizeElement(f, f2, f, f2, false));
    }

    /* renamed from: requiredSizeIn-qDBjuR0$default */
    public static Modifier m90requiredSizeInqDBjuR0$default(Modifier requiredSizeIn, float f, float f2) {
        Intrinsics.checkNotNullParameter(requiredSizeIn, "$this$requiredSizeIn");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return requiredSizeIn.then(new SizeElement(f, f2, Float.NaN, Float.NaN, false));
    }

    /* renamed from: size-3ABfNKs */
    public static final Modifier m91size3ABfNKs(Modifier size, float f) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return size.then(new SizeElement(f, f, f, f, true));
    }

    /* renamed from: size-VpY3zN4 */
    public static final Modifier m92sizeVpY3zN4(Modifier size, float f, float f2) {
        Intrinsics.checkNotNullParameter(size, "$this$size");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return size.then(new SizeElement(f, f2, f, f2, true));
    }

    /* renamed from: sizeIn-qDBjuR0 */
    public static final Modifier m93sizeInqDBjuR0(Modifier sizeIn, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(sizeIn, "$this$sizeIn");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return sizeIn.then(new SizeElement(f, f2, f3, f4, true));
    }

    /* renamed from: width-3ABfNKs */
    public static final Modifier m94width3ABfNKs(Modifier width, float f) {
        Intrinsics.checkNotNullParameter(width, "$this$width");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return width.then(new SizeElement(f, 0.0f, f, 0.0f, true, 10));
    }

    /* renamed from: widthIn-VpY3zN4$default */
    public static Modifier m95widthInVpY3zN4$default(Modifier widthIn, float f, float f2, int r12) {
        float f3;
        float f4;
        if ((r12 & 1) != 0) {
            f3 = Float.NaN;
        } else {
            f3 = f;
        }
        if ((r12 & 2) != 0) {
            f4 = Float.NaN;
        } else {
            f4 = f2;
        }
        Intrinsics.checkNotNullParameter(widthIn, "$this$widthIn");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        return widthIn.then(new SizeElement(f3, 0.0f, f4, 0.0f, true, 10));
    }

    public static Modifier wrapContentHeight$default(Modifier modifier) {
        WrapContentElement height;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (Intrinsics.areEqual(vertical, vertical)) {
            height = WrapContentHeightCenter;
        } else if (Intrinsics.areEqual(vertical, Alignment.Companion.Top)) {
            height = WrapContentHeightTop;
        } else {
            height = WrapContentElement.Companion.height(vertical, false);
        }
        return modifier.then(height);
    }

    public static Modifier wrapContentSize$default(Modifier modifier, BiasAlignment align, int r3) {
        WrapContentElement size;
        int r32 = r3 & 1;
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        if (r32 != 0) {
            align = biasAlignment;
        }
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(align, "align");
        if (Intrinsics.areEqual(align, biasAlignment)) {
            size = WrapContentSizeCenter;
        } else if (Intrinsics.areEqual(align, Alignment.Companion.TopStart)) {
            size = WrapContentSizeTopStart;
        } else {
            size = WrapContentElement.Companion.size(align, false);
        }
        return modifier.then(size);
    }
}
