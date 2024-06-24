package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Hoverable.kt */
/* loaded from: classes.dex */
public final class HoverableKt {
    public static final Modifier hoverable(MutableInteractionSource interactionSource, Modifier modifier, boolean z) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        if (z) {
            modifier2 = new HoverableElement(interactionSource);
        } else {
            int r1 = Modifier.$r8$clinit;
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        return modifier.then(modifier2);
    }
}
