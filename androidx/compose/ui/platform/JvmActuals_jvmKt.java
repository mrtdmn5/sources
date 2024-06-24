package androidx.compose.ui.platform;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JvmActuals.jvm.kt */
/* loaded from: classes.dex */
public final class JvmActuals_jvmKt {
    public static final String simpleIdentityToString(Object obj) {
        String simpleName;
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (obj.getClass().isAnonymousClass()) {
            simpleName = obj.getClass().getName();
        } else {
            simpleName = obj.getClass().getSimpleName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(simpleName);
        sb.append('@');
        String format = String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb.append(format);
        return sb.toString();
    }
}
