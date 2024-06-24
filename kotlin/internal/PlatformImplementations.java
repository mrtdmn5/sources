package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes.dex */
public class PlatformImplementations {

    /* compiled from: PlatformImplementations.kt */
    /* loaded from: classes.dex */
    public static final class ReflectThrowable {
        public static final Method addSuppressed;

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r5, java.lang.Throwable.class) != false) goto L14;     */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                int r2 = r1.length
                r3 = 0
                r4 = r3
            Lc:
                r5 = 0
                if (r4 >= r2) goto L3b
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
                if (r7 == 0) goto L33
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "getParameterTypes(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                int r8 = r7.length
                r9 = 1
                if (r8 != r9) goto L2c
                r5 = r7[r3]
            L2c:
                boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
                if (r5 == 0) goto L33
                goto L34
            L33:
                r9 = r3
            L34:
                if (r9 == 0) goto L38
                r5 = r6
                goto L3b
            L38:
                int r4 = r4 + 1
                goto Lc
            L3b:
                kotlin.internal.PlatformImplementations.ReflectThrowable.addSuppressed = r5
                int r0 = r1.length
            L3e:
                if (r3 >= r0) goto L52
                r2 = r1[r3]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
                if (r2 == 0) goto L4f
                goto L52
            L4f:
                int r3 = r3 + 1
                goto L3e
            L52:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.ReflectThrowable.<clinit>():void");
        }
    }

    public void addSuppressed(Throwable cause, Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }
}
