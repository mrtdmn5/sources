package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class NativeCallbackDispatcher_Factory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final NativeCallbackDispatcher_Factory INSTANCE = new NativeCallbackDispatcher_Factory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new NativeCallbackDispatcher();
    }
}
