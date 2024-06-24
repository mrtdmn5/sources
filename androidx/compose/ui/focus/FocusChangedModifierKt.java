package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusChangedModifier.kt */
/* loaded from: classes.dex */
public final class FocusChangedModifierKt {
    public static final Modifier onFocusChanged(Modifier modifier, Function1<? super FocusState, Unit> onFocusChanged) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        return modifier.then(new FocusChangedElement(onFocusChanged));
    }
}
