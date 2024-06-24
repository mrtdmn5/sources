package androidx.compose.animation;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class ExitTransitionImpl extends ExitTransition {
    public final TransitionData data;

    public ExitTransitionImpl(TransitionData transitionData) {
        this.data = transitionData;
    }

    @Override // androidx.compose.animation.ExitTransition
    public final TransitionData getData$animation_release() {
        return this.data;
    }
}
