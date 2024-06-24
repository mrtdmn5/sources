package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.HashMap;

/* compiled from: CompositeGeneratedAdaptersObserver.kt */
/* loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    public final GeneratedAdapter[] generatedAdapters;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.generatedAdapters = generatedAdapterArr;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        new HashMap();
        GeneratedAdapter[] generatedAdapterArr = this.generatedAdapters;
        for (GeneratedAdapter generatedAdapter : generatedAdapterArr) {
            generatedAdapter.callMethods();
        }
        for (GeneratedAdapter generatedAdapter2 : generatedAdapterArr) {
            generatedAdapter2.callMethods();
        }
    }
}
