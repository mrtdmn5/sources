package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.animaconnected.firebase.AnalyticsConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Padding.kt */
/* loaded from: classes.dex */
public final class PaddingKt {
    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(paddingValues, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo78calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo77calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(paddingValues, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo77calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo78calculateRightPaddingu2uoSUM(layoutDirection);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.foundation.layout.PaddingKt$padding$4] */
    public static final Modifier padding(Modifier modifier, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(InspectorInfo inspectorInfo) {
                InspectorInfo $receiver = inspectorInfo;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                $receiver.properties.set(PaddingValues.this, "paddingValues");
                return Unit.INSTANCE;
            }
        }));
    }

    /* renamed from: padding-3ABfNKs */
    public static final Modifier m71padding3ABfNKs(Modifier padding, float f) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        return padding.then(new PaddingElement(f, f, f, f, new Function1<InspectorInfo, Unit>(f) { // from class: androidx.compose.foundation.layout.PaddingKt$padding$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(InspectorInfo inspectorInfo) {
                InspectorInfo $receiver = inspectorInfo;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                return Unit.INSTANCE;
            }
        }));
    }

    /* renamed from: padding-VpY3zN4 */
    public static final Modifier m72paddingVpY3zN4(Modifier padding, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        return padding.then(new PaddingElement(f, f2, f, f2, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(InspectorInfo inspectorInfo) {
                InspectorInfo $receiver = inspectorInfo;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                Dp dp = new Dp(f);
                ValueElementSequence valueElementSequence = $receiver.properties;
                valueElementSequence.set(dp, "horizontal");
                valueElementSequence.set(new Dp(f2), "vertical");
                return Unit.INSTANCE;
            }
        }));
    }

    /* renamed from: padding-VpY3zN4$default */
    public static Modifier m73paddingVpY3zN4$default(Modifier modifier, float f, float f2, int r5) {
        if ((r5 & 1) != 0) {
            f = 0;
        }
        if ((r5 & 2) != 0) {
            f2 = 0;
        }
        return m72paddingVpY3zN4(modifier, f, f2);
    }

    /* renamed from: padding-qDBjuR0 */
    public static final Modifier m74paddingqDBjuR0(Modifier padding, final float f, final float f2, final float f3, final float f4) {
        Intrinsics.checkNotNullParameter(padding, "$this$padding");
        return padding.then(new PaddingElement(f, f2, f3, f4, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(InspectorInfo inspectorInfo) {
                InspectorInfo $receiver = inspectorInfo;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                Dp dp = new Dp(f);
                ValueElementSequence valueElementSequence = $receiver.properties;
                valueElementSequence.set(dp, "start");
                valueElementSequence.set(new Dp(f2), AnalyticsConstants.KEY_TOP);
                valueElementSequence.set(new Dp(f3), "end");
                valueElementSequence.set(new Dp(f4), AnalyticsConstants.KEY_BOTTOM);
                return Unit.INSTANCE;
            }
        }));
    }

    /* renamed from: padding-qDBjuR0$default */
    public static Modifier m75paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int r7) {
        if ((r7 & 1) != 0) {
            f = 0;
        }
        if ((r7 & 2) != 0) {
            f2 = 0;
        }
        if ((r7 & 4) != 0) {
            f3 = 0;
        }
        if ((r7 & 8) != 0) {
            f4 = 0;
        }
        return m74paddingqDBjuR0(modifier, f, f2, f3, f4);
    }
}
