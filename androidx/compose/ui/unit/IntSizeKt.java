package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.SizeKt;

/* compiled from: IntSize.kt */
/* loaded from: classes.dex */
public final class IntSizeKt {
    public static final long IntSize(int r4, int r5) {
        return (r5 & 4294967295L) | (r4 << 32);
    }

    /* renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m595toSizeozmzZPI(long j) {
        return SizeKt.Size((int) (j >> 32), IntSize.m593getHeightimpl(j));
    }
}
