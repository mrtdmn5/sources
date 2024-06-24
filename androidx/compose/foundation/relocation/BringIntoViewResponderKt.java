package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BringIntoViewResponder.kt */
/* loaded from: classes.dex */
public final class BringIntoViewResponderKt {
    public static final Modifier bringIntoViewResponder(Modifier modifier, BringIntoViewResponder responder) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(responder, "responder");
        return modifier.then(new BringIntoViewResponderElement(responder));
    }
}
