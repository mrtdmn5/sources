package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusRequesterModifier.kt */
/* loaded from: classes.dex */
public final class FocusRequesterModifierKt {
    public static final Modifier focusRequester(Modifier modifier, FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        return modifier.then(new FocusRequesterElement(focusRequester));
    }
}
