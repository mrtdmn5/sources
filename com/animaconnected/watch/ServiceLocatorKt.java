package com.animaconnected.watch;

/* compiled from: ServiceLocator.kt */
/* loaded from: classes3.dex */
public final class ServiceLocatorKt {
    public static final /* synthetic */ void access$ensureMain() {
        ensureMain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureMain() {
        if (DispatchersKt.isCurrentThreadMain()) {
        } else {
            throw new IllegalArgumentException("ServiceLocator functions must be called from main thread".toString());
        }
    }
}
