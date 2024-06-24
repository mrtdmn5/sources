package kotlin.internal.jdk8;

import kotlin.internal.jdk7.JDK7PlatformImplementations;

/* compiled from: JDK8PlatformImplementations.kt */
/* loaded from: classes.dex */
public final class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    /* compiled from: JDK8PlatformImplementations.kt */
    /* loaded from: classes.dex */
    public static final class ReflectSdkVersion {
        public static final Integer sdkVersion;

        /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
        static {
            /*
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L18
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L18
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L18
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L18
                if (r2 == 0) goto L18
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L18
                goto L19
            L18:
                r1 = r0
            L19:
                if (r1 == 0) goto L27
                int r2 = r1.intValue()
                if (r2 <= 0) goto L23
                r2 = 1
                goto L24
            L23:
                r2 = 0
            L24:
                if (r2 == 0) goto L27
                r0 = r1
            L27:
                kotlin.internal.jdk8.JDK8PlatformImplementations.ReflectSdkVersion.sdkVersion = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.jdk8.JDK8PlatformImplementations.ReflectSdkVersion.<clinit>():void");
        }
    }
}
