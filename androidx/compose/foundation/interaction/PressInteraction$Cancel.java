package androidx.compose.foundation.interaction;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PressInteraction.kt */
/* loaded from: classes.dex */
public final class PressInteraction$Cancel implements Interaction {
    public final PressInteraction$Press press;

    public PressInteraction$Cancel(PressInteraction$Press press) {
        Intrinsics.checkNotNullParameter(press, "press");
        this.press = press;
    }
}
