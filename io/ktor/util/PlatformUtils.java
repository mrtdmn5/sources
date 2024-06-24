package io.ktor.util;

/* compiled from: PlatformUtils.kt */
/* loaded from: classes3.dex */
public final class PlatformUtils {
    public static final boolean IS_BROWSER;
    public static final boolean IS_DEVELOPMENT_MODE;
    public static final boolean IS_NATIVE;

    static {
        boolean z;
        boolean z2;
        Platform platform = Platform.Jvm;
        boolean z3 = true;
        if (platform == Platform.Browser) {
            z = true;
        } else {
            z = false;
        }
        IS_BROWSER = z;
        if (platform == Platform.Native) {
            z2 = true;
        } else {
            z2 = false;
        }
        IS_NATIVE = z2;
        String property = System.getProperty("io.ktor.development");
        if (property == null || !Boolean.parseBoolean(property)) {
            z3 = false;
        }
        IS_DEVELOPMENT_MODE = z3;
    }
}
