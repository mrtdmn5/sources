package androidx.compose.runtime;

/* compiled from: ComposeNodeLifecycleCallback.kt */
/* loaded from: classes.dex */
public interface ComposeNodeLifecycleCallback {
    void onDeactivate();

    void onRelease();

    void onReuse();
}
