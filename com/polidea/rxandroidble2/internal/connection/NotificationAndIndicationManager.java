package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class NotificationAndIndicationManager {
    public static final UUID CLIENT_CHARACTERISTIC_CONFIG_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public final HashMap activeNotificationObservableMap = new HashMap();
    public final BluetoothGatt bluetoothGatt;
    public final byte[] configDisable;
    public final byte[] configEnableIndication;
    public final byte[] configEnableNotification;
    public final DescriptorWriter descriptorWriter;
    public final RxBleGattCallback gattCallback;

    /* renamed from: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode;

        static {
            int[] r0 = new int[NotificationSetupMode.values().length];
            $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode = r0;
            try {
                r0[NotificationSetupMode.COMPAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[NotificationSetupMode.QUICK_SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[NotificationSetupMode.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public NotificationAndIndicationManager(byte[] bArr, byte[] bArr2, byte[] bArr3, BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, DescriptorWriter descriptorWriter) {
        this.configEnableNotification = bArr;
        this.configEnableIndication = bArr2;
        this.configDisable = bArr3;
        this.bluetoothGatt = bluetoothGatt;
        this.gattCallback = rxBleGattCallback;
        this.descriptorWriter = descriptorWriter;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda7] */
    public static Completable writeClientCharacteristicConfig(final BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter, byte[] bArr) {
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID);
        if (descriptor == null) {
            return new CompletableError(new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 2, null));
        }
        Observable queue = descriptorWriter.operationQueue.queue(descriptorWriter.operationsProvider.provideWriteDescriptor(descriptor, bArr));
        queue.getClass();
        return new CompletableResumeNext(new ObservableIgnoreElementsCompletable(queue), new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return new CompletableError(new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 3, (Throwable) obj));
            }
        });
    }
}
