package androidx.compose.animation;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class EnterTransitionImpl extends EnterTransition {
    public final TransitionData data;

    public EnterTransitionImpl(TransitionData transitionData) {
        this.data = transitionData;
    }

    @Override // androidx.compose.animation.EnterTransition
    public final TransitionData getData$animation_release() {
        return this.data;
    }
}
