package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* loaded from: classes3.dex */
public final class OptionalProvider<T> implements Provider<T>, Deferred<T> {
    public volatile Provider<T> delegate;
    public Deferred.DeferredHandler<T> handler;
    public static final OptionalProvider$$ExternalSyntheticLambda0 NOOP_HANDLER = new OptionalProvider$$ExternalSyntheticLambda0();
    public static final OptionalProvider$$ExternalSyntheticLambda1 EMPTY_PROVIDER = new OptionalProvider$$ExternalSyntheticLambda1();

    public OptionalProvider(OptionalProvider$$ExternalSyntheticLambda0 optionalProvider$$ExternalSyntheticLambda0, Provider provider) {
        this.handler = optionalProvider$$ExternalSyntheticLambda0;
        this.delegate = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public final T get() {
        return this.delegate.get();
    }

    public final void whenAvailable(final Deferred.DeferredHandler<T> deferredHandler) {
        Provider<T> provider;
        Provider<T> provider2;
        Provider<T> provider3 = this.delegate;
        OptionalProvider$$ExternalSyntheticLambda1 optionalProvider$$ExternalSyntheticLambda1 = EMPTY_PROVIDER;
        if (provider3 != optionalProvider$$ExternalSyntheticLambda1) {
            deferredHandler.handle(provider3);
            return;
        }
        synchronized (this) {
            provider = this.delegate;
            if (provider != optionalProvider$$ExternalSyntheticLambda1) {
                provider2 = provider;
            } else {
                final Deferred.DeferredHandler<T> deferredHandler2 = this.handler;
                this.handler = new Deferred.DeferredHandler() { // from class: com.google.firebase.components.OptionalProvider$$ExternalSyntheticLambda2
                    @Override // com.google.firebase.inject.Deferred.DeferredHandler
                    public final void handle(Provider provider4) {
                        Deferred.DeferredHandler.this.handle(provider4);
                        deferredHandler.handle(provider4);
                    }
                };
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.handle(provider);
        }
    }
}
