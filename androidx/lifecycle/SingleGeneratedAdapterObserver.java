package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: SingleGeneratedAdapterObserver.kt */
/* loaded from: classes.dex */
public final class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    public final GeneratedAdapter generatedAdapter;

    public SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.generatedAdapter = generatedAdapter;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        GeneratedAdapter generatedAdapter = this.generatedAdapter;
        generatedAdapter.callMethods();
        generatedAdapter.callMethods();
    }
}
