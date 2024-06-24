package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothGattDescriptor;
import bleshadow.javax.inject.Provider;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideEnableIndicationValueFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ClientComponent_ClientModule_ProvideEnableIndicationValueFactory INSTANCE = new ClientComponent_ClientModule_ProvideEnableIndicationValueFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        byte[] bArr = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        UnsignedKt.checkNotNullFromProvides(bArr);
        return bArr;
    }
}
