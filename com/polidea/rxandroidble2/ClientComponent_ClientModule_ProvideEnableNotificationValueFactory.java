package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothGattDescriptor;
import bleshadow.javax.inject.Provider;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ClientComponent_ClientModule_ProvideEnableNotificationValueFactory implements Provider {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ClientComponent_ClientModule_ProvideEnableNotificationValueFactory INSTANCE = new ClientComponent_ClientModule_ProvideEnableNotificationValueFactory();
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        byte[] bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        UnsignedKt.checkNotNullFromProvides(bArr);
        return bArr;
    }
}
