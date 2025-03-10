package com.google.firebase.inject;

/* loaded from: classes3.dex */
public interface Deferred<T> {

    /* loaded from: classes3.dex */
    public interface DeferredHandler<T> {
        void handle(Provider<T> provider);
    }
}
