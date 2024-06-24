package com.google.android.gms.dynamic;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zaa {
    public final /* synthetic */ DeferredLifecycleHelper zaa;

    public zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        DeferredLifecycleHelper deferredLifecycleHelper = this.zaa;
        deferredLifecycleHelper.zaa = lifecycleDelegate;
        Iterator it = deferredLifecycleHelper.zac.iterator();
        while (it.hasNext()) {
            ((zah) it.next()).zab();
        }
        deferredLifecycleHelper.zac.clear();
        deferredLifecycleHelper.zab = null;
    }
}
