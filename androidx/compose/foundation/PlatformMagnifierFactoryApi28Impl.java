package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformMagnifier.kt */
/* loaded from: classes.dex */
public final class PlatformMagnifierFactoryApi28Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi28Impl INSTANCE = new PlatformMagnifierFactoryApi28Impl();

    /* compiled from: PlatformMagnifier.kt */
    /* loaded from: classes.dex */
    public static class PlatformMagnifierImpl implements PlatformMagnifier {
        public final Magnifier magnifier;

        public PlatformMagnifierImpl(Magnifier magnifier) {
            this.magnifier = magnifier;
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        public final void dismiss() {
            this.magnifier.dismiss();
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        /* renamed from: getSize-YbymL2g */
        public final long mo29getSizeYbymL2g() {
            Magnifier magnifier = this.magnifier;
            return IntSizeKt.IntSize(magnifier.getWidth(), magnifier.getHeight());
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        /* renamed from: update-Wko1d7g */
        public void mo30updateWko1d7g(long j, long j2, float f) {
            this.magnifier.show(Offset.m259getXimpl(j), Offset.m260getYimpl(j));
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        public final void updateContent() {
            this.magnifier.update();
        }
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public final PlatformMagnifier create(MagnifierStyle style, View view, Density density, float f) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(density, "density");
        return new PlatformMagnifierImpl(new Magnifier(view));
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public final boolean getCanUpdateZoom() {
        return false;
    }
}
