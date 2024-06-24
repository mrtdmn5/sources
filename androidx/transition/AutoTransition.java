package androidx.transition;

/* loaded from: classes.dex */
public final class AutoTransition extends TransitionSet {
    public AutoTransition() {
        this.mPlayTogether = false;
        addTransition(new Fade(2));
        addTransition(new ChangeBounds());
        addTransition(new Fade(1));
    }
}
