package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes.dex */
public final class BundleCompat$Api18Impl {
    public static IBinder getBinder(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
