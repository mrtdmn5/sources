package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: PlatformMagnifier.kt */
/* loaded from: classes.dex */
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();

    /* compiled from: PlatformMagnifier.kt */
    /* loaded from: classes.dex */
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* renamed from: update-Wko1d7g */
        public final void mo30updateWko1d7g(long j, long j2, float f) {
            boolean isNaN = Float.isNaN(f);
            Magnifier magnifier = this.magnifier;
            if (!isNaN) {
                magnifier.setZoom(f);
            }
            if (OffsetKt.m266isSpecifiedk4lQ0M(j2)) {
                magnifier.show(Offset.m259getXimpl(j), Offset.m260getYimpl(j), Offset.m259getXimpl(j2), Offset.m260getYimpl(j2));
            } else {
                magnifier.show(Offset.m259getXimpl(j), Offset.m260getYimpl(j));
            }
        }
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public final PlatformMagnifier create(MagnifierStyle style, View view, Density density, float f) {
        boolean z;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(density, "density");
        if (Intrinsics.areEqual(style, MagnifierStyle.TextDefault)) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long mo50toSizeXkaWNTQ = density.mo50toSizeXkaWNTQ(style.size);
        float mo49toPx0680j_4 = density.mo49toPx0680j_4(style.cornerRadius);
        float mo49toPx0680j_42 = density.mo49toPx0680j_4(style.elevation);
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (mo50toSizeXkaWNTQ != Size.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            builder.setSize(MathKt__MathJVMKt.roundToInt(Size.m276getWidthimpl(mo50toSizeXkaWNTQ)), MathKt__MathJVMKt.roundToInt(Size.m274getHeightimpl(mo50toSizeXkaWNTQ)));
        }
        if (!Float.isNaN(mo49toPx0680j_4)) {
            builder.setCornerRadius(mo49toPx0680j_4);
        }
        if (!Float.isNaN(mo49toPx0680j_42)) {
            builder.setElevation(mo49toPx0680j_42);
        }
        if (!Float.isNaN(f)) {
            builder.setInitialZoom(f);
        }
        builder.setClippingEnabled(style.clippingEnabled);
        Magnifier build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(view).run {\n    …    build()\n            }");
        return new PlatformMagnifierImpl(build);
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public final boolean getCanUpdateZoom() {
        return true;
    }
}
