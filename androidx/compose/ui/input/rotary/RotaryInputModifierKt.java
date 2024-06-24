package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RotaryInputModifier.kt */
/* loaded from: classes.dex */
public final class RotaryInputModifierKt {
    public static final Modifier onRotaryScrollEvent(AndroidComposeView$rotaryInputModifier$1 onRotaryScrollEvent) {
        Intrinsics.checkNotNullParameter(onRotaryScrollEvent, "onRotaryScrollEvent");
        return new RotaryInputElement(onRotaryScrollEvent);
    }
}
