package com.animaconnected.secondo.screens;

import com.animaconnected.secondo.screens.details.OnDismissedListener;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda0 implements OnDismissedListener, Continuation {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda0(Object obj, Object obj2) {
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // com.animaconnected.secondo.screens.details.OnDismissedListener
    public final void onDismissed() {
        MainActivity.m826$r8$lambda$fCN0CJJnXiN7siC3CQHqlivHxk((MainActivity) this.f$0, (BaseFragment) this.f$1);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        RequestDeduplicator requestDeduplicator = (RequestDeduplicator) this.f$0;
        String str = (String) this.f$1;
        synchronized (requestDeduplicator) {
            requestDeduplicator.getTokenRequests.remove(str);
        }
        return task;
    }
}
