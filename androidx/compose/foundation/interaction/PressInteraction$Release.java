package androidx.compose.foundation.interaction;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PressInteraction.kt */
/* loaded from: classes.dex */
public final class PressInteraction$Release implements Interaction {
    public final PressInteraction$Press press;

    public PressInteraction$Release(PressInteraction$Press press) {
        Intrinsics.checkNotNullParameter(press, "press");
        this.press = press;
    }
}
