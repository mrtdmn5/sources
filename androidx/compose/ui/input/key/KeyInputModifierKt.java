package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyInputModifier.kt */
/* loaded from: classes.dex */
public final class KeyInputModifierKt {
    public static final Modifier onKeyEvent(Modifier modifier, Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then(new KeyInputElement(function1, null));
    }

    public static final Modifier onPreviewKeyEvent(Modifier modifier, Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then(new KeyInputElement(null, function1));
    }
}
