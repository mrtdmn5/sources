package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Row.kt */
/* loaded from: classes.dex */
public final class RowScopeInstance implements RowScope {
    public static final RowScopeInstance INSTANCE = new RowScopeInstance();

    @Override // androidx.compose.foundation.layout.RowScope
    public final Modifier weight(Modifier modifier, float f, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (f > 0.0d) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return modifier.then(new LayoutWeightElement(f, z));
        }
        throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", f, "; must be greater than zero").toString());
    }
}
