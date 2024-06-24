package com.polidea.rxandroidble2.internal.util;

import android.content.Context;
import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CheckerPermission_Factory implements Provider {
    public final Provider<Context> contextProvider;

    public CheckerPermission_Factory(InstanceFactory instanceFactory) {
        this.contextProvider = instanceFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new CheckerPermission(this.contextProvider.get());
    }
}
