package com.polidea.rxandroidble2;

import android.content.ContentResolver;
import android.content.Context;
import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideContentResolverFactory implements Provider {
    public final Provider<Context> contextProvider;

    public ClientComponent_ClientModule_ProvideContentResolverFactory(InstanceFactory instanceFactory) {
        this.contextProvider = instanceFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        ContentResolver contentResolver = this.contextProvider.get().getContentResolver();
        UnsignedKt.checkNotNullFromProvides(contentResolver);
        return contentResolver;
    }
}
