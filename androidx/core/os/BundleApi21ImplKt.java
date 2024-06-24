package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;

/* compiled from: Bundle.kt */
/* loaded from: classes.dex */
public final class BundleApi21ImplKt {
    public static final void putSize(Bundle bundle, String str, Size size) {
        bundle.putSize(str, size);
    }

    public static final void putSizeF(Bundle bundle, String str, SizeF sizeF) {
        bundle.putSizeF(str, sizeF);
    }
}
