package androidx.compose.foundation.pager;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pager.kt */
/* loaded from: classes.dex */
public interface PageSize {

    /* compiled from: Pager.kt */
    /* loaded from: classes.dex */
    public static final class Fill implements PageSize {
        public static final Fill INSTANCE = new Fill();

        @Override // androidx.compose.foundation.pager.PageSize
        public final int calculateMainAxisPageSize(Density density, int r3) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return r3;
        }
    }

    int calculateMainAxisPageSize(Density density, int r2);
}
