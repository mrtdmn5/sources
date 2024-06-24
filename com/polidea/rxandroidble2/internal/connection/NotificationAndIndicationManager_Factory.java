package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideDisableNotificationValueFactory;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideEnableIndicationValueFactory;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideEnableNotificationValueFactory;

/* loaded from: classes3.dex */
public final class NotificationAndIndicationManager_Factory implements Provider {
    public final Provider<BluetoothGatt> bluetoothGattProvider;
    public final Provider<byte[]> configDisableProvider;
    public final Provider<byte[]> configEnableIndicationProvider;
    public final Provider<byte[]> configEnableNotificationProvider;
    public final Provider<DescriptorWriter> descriptorWriterProvider;
    public final Provider<RxBleGattCallback> gattCallbackProvider;

    public NotificationAndIndicationManager_Factory(Provider provider, Provider provider2, Provider provider3) {
        ClientComponent_ClientModule_ProvideEnableNotificationValueFactory clientComponent_ClientModule_ProvideEnableNotificationValueFactory = ClientComponent_ClientModule_ProvideEnableNotificationValueFactory.InstanceHolder.INSTANCE;
        ClientComponent_ClientModule_ProvideEnableIndicationValueFactory clientComponent_ClientModule_ProvideEnableIndicationValueFactory = ClientComponent_ClientModule_ProvideEnableIndicationValueFactory.InstanceHolder.INSTANCE;
        ClientComponent_ClientModule_ProvideDisableNotificationValueFactory clientComponent_ClientModule_ProvideDisableNotificationValueFactory = ClientComponent_ClientModule_ProvideDisableNotificationValueFactory.InstanceHolder.INSTANCE;
        this.configEnableNotificationProvider = clientComponent_ClientModule_ProvideEnableNotificationValueFactory;
        this.configEnableIndicationProvider = clientComponent_ClientModule_ProvideEnableIndicationValueFactory;
        this.configDisableProvider = clientComponent_ClientModule_ProvideDisableNotificationValueFactory;
        this.bluetoothGattProvider = provider;
        this.gattCallbackProvider = provider2;
        this.descriptorWriterProvider = provider3;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new NotificationAndIndicationManager(this.configEnableNotificationProvider.get(), this.configEnableIndicationProvider.get(), this.configDisableProvider.get(), this.bluetoothGattProvider.get(), this.gattCallbackProvider.get(), this.descriptorWriterProvider.get());
    }
}
