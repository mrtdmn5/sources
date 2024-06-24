package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ScanRecordParser_Factory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ScanRecordParser_Factory INSTANCE = new ScanRecordParser_Factory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ScanRecordParser();
    }
}
