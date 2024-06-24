package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BuildCompat.kt */
/* loaded from: classes.dex */
public final class BuildCompat {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: BuildCompat.kt */
    /* loaded from: classes.dex */
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        public final int getExtensionVersion(int r1) {
            return SdkExtensions.getExtensionVersion(r1);
        }
    }

    static {
        int r0 = Build.VERSION.SDK_INT;
        Api30Impl api30Impl = Api30Impl.INSTANCE;
        if (r0 >= 30) {
            api30Impl.getExtensionVersion(30);
        }
        if (r0 >= 30) {
            api30Impl.getExtensionVersion(31);
        }
        if (r0 >= 30) {
            api30Impl.getExtensionVersion(33);
        }
        if (r0 >= 30) {
            api30Impl.getExtensionVersion(1000000);
        }
    }

    public static final boolean isAtLeastPreReleaseCodename(String str, String str2) {
        if (Intrinsics.areEqual("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.compareTo(upperCase2) < 0) {
            return false;
        }
        return true;
    }

    public static final boolean isAtLeastS() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) {
            if (r0 >= 30) {
                String CODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
                if (isAtLeastPreReleaseCodename("S", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }
}
