package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NestedScrollModifier.kt */
/* loaded from: classes.dex */
public final class NestedScrollModifierKt {
    public static final Modifier nestedScroll(Modifier modifier, NestedScrollConnection connection, NestedScrollDispatcher nestedScrollDispatcher) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(connection, "connection");
        return modifier.then(new NestedScrollElement(connection, nestedScrollDispatcher));
    }
}
