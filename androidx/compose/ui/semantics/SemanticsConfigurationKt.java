package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsConfiguration.kt */
/* loaded from: classes.dex */
public final class SemanticsConfigurationKt {
    public static final <T> T getOrNull(SemanticsConfiguration semanticsConfiguration, SemanticsPropertyKey<T> key) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        SemanticsConfigurationKt$getOrNull$1 defaultValue = new Function0<T>() { // from class: androidx.compose.ui.semantics.SemanticsConfigurationKt$getOrNull$1
            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return null;
            }
        };
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t = (T) semanticsConfiguration.props.get(key);
        if (t == null) {
            return null;
        }
        return t;
    }
}
