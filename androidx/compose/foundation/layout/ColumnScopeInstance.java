package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Column.kt */
/* loaded from: classes.dex */
public final class ColumnScopeInstance implements ColumnScope {
    public static final ColumnScopeInstance INSTANCE = new ColumnScopeInstance();

    @Override // androidx.compose.foundation.layout.ColumnScope
    public final Modifier align(Modifier modifier) {
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then(new HorizontalAlignElement(horizontal));
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
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
