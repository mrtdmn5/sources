package androidx.core.widget;

import android.os.Build;

/* loaded from: classes.dex */
public interface AutoSizeableTextView {

    @Deprecated
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE;

    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 27) {
            z = true;
        } else {
            z = false;
        }
        PLATFORM_SUPPORTS_AUTOSIZE = z;
    }
}
