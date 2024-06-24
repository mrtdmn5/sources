package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.jakewharton.rxrelay2.SerializedRelay;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleGattCharacteristicException;
import com.polidea.rxandroidble2.exceptions.BleGattDescriptorException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.util.ByteAssociation;
import com.polidea.rxandroidble2.internal.util.CharacteristicChangedEvent;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class RxBleGattCallback {
    public final AnonymousClass2 bluetoothGattCallback;
    public final BluetoothGattProvider bluetoothGattProvider;
    public final Scheduler callbackScheduler;
    public final Relay<CharacteristicChangedEvent> changedCharacteristicSerializedPublishRelay;
    public final Output<Integer> changedMtuOutput;
    public final DisconnectionRouter disconnectionRouter;
    public final AnonymousClass1 errorMapper;
    public final NativeCallbackDispatcher nativeCallbackDispatcher;
    public final Output<ByteAssociation<BluetoothGattDescriptor>> readDescriptorOutput;
    public final Output<Integer> readRssiOutput;
    public final Output<Object> updatedConnectionOutput;
    public final Output<ByteAssociation<BluetoothGattDescriptor>> writeDescriptorOutput;
    public final PublishRelay<RxBleConnection.RxBleConnectionState> connectionStatePublishRelay = new PublishRelay<>();
    public final Output<RxBleDeviceServices> servicesDiscoveredOutput = new Output<>();
    public final Output<ByteAssociation<UUID>> readCharacteristicOutput = new Output<>();
    public final Output<ByteAssociation<UUID>> writeCharacteristicOutput = new Output<>();

    /* renamed from: com.polidea.rxandroidble2.internal.connection.RxBleGattCallback$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Function<BleGattException, Observable<?>> {
        @Override // io.reactivex.functions.Function
        public final Observable<?> apply(BleGattException bleGattException) throws Exception {
            return Observable.error(bleGattException);
        }
    }

    /* loaded from: classes3.dex */
    public static class Output<T> {
        public final PublishRelay<T> valueRelay = new PublishRelay<>();
        public final PublishRelay<BleGattException> errorRelay = new PublishRelay<>();

        public final boolean hasObservers() {
            if (!this.valueRelay.hasObservers() && !this.errorRelay.hasObservers()) {
                return false;
            }
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.polidea.rxandroidble2.internal.connection.RxBleGattCallback$2] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.jakewharton.rxrelay2.SerializedRelay] */
    public RxBleGattCallback(Scheduler scheduler, BluetoothGattProvider bluetoothGattProvider, DisconnectionRouter disconnectionRouter, NativeCallbackDispatcher nativeCallbackDispatcher) {
        PublishRelay publishRelay = new PublishRelay();
        this.changedCharacteristicSerializedPublishRelay = publishRelay instanceof SerializedRelay ? publishRelay : new SerializedRelay(publishRelay);
        this.readDescriptorOutput = new Output<>();
        this.writeDescriptorOutput = new Output<>();
        this.readRssiOutput = new Output<>();
        this.changedMtuOutput = new Output<>();
        this.updatedConnectionOutput = new Output<>();
        this.errorMapper = new AnonymousClass1();
        this.bluetoothGattCallback = new BluetoothGattCallback() { // from class: com.polidea.rxandroidble2.internal.connection.RxBleGattCallback.2
            @Override // android.bluetooth.BluetoothGattCallback
            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                int r0 = LoggerUtil.$r8$clinit;
                if (RxBleLog.isAtLeast(4)) {
                    RxBleLog.i(LoggerUtil.commonMacMessage(bluetoothGatt) + " %24s(), value=%s", "onCharacteristicChanged", new LoggerUtil.AttributeLogWrapper(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue(), true));
                }
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                BluetoothGattCallback bluetoothGattCallback = rxBleGattCallback.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                }
                super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                if (rxBleGattCallback.changedCharacteristicSerializedPublishRelay.hasObservers()) {
                    rxBleGattCallback.changedCharacteristicSerializedPublishRelay.accept(new CharacteristicChangedEvent(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getValue()));
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int r8) {
                boolean z;
                boolean z2 = true;
                LoggerUtil.logCallback("onCharacteristicRead", bluetoothGatt, r8, bluetoothGattCharacteristic, true);
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                BluetoothGattCallback bluetoothGattCallback = rxBleGattCallback.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, r8);
                }
                super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, r8);
                Output<ByteAssociation<UUID>> output = rxBleGattCallback.readCharacteristicOutput;
                if (output.hasObservers()) {
                    BleGattOperationType bleGattOperationType = BleGattOperationType.CHARACTERISTIC_READ;
                    if (r8 != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        output.errorRelay.accept(new BleGattCharacteristicException(bluetoothGatt, r8, bleGattOperationType));
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        output.valueRelay.accept(new ByteAssociation<>(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue()));
                    }
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int r8) {
                boolean z;
                boolean z2 = false;
                LoggerUtil.logCallback("onCharacteristicWrite", bluetoothGatt, r8, bluetoothGattCharacteristic, false);
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                BluetoothGattCallback bluetoothGattCallback = rxBleGattCallback.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, r8);
                }
                super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, r8);
                Output<ByteAssociation<UUID>> output = rxBleGattCallback.writeCharacteristicOutput;
                if (output.hasObservers()) {
                    BleGattOperationType bleGattOperationType = BleGattOperationType.CHARACTERISTIC_WRITE;
                    if (r8 != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        output.errorRelay.accept(new BleGattCharacteristicException(bluetoothGatt, r8, bleGattOperationType));
                        z2 = true;
                    }
                    if (!z2) {
                        output.valueRelay.accept(new ByteAssociation<>(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue()));
                    }
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int r8, int r9) {
                boolean z;
                RxBleConnection.RxBleConnectionState rxBleConnectionState;
                LoggerUtil.logCallback("onConnectionStateChange", bluetoothGatt, r8, r9);
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                BluetoothGattCallback bluetoothGattCallback = rxBleGattCallback.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, r8, r9);
                }
                super.onConnectionStateChange(bluetoothGatt, r8, r9);
                AtomicReference<BluetoothGatt> atomicReference = rxBleGattCallback.bluetoothGattProvider.reference;
                while (!atomicReference.compareAndSet(null, bluetoothGatt) && atomicReference.get() == null) {
                }
                if (r9 != 0 && r9 != 3) {
                    z = false;
                } else {
                    z = true;
                }
                DisconnectionRouter disconnectionRouter2 = rxBleGattCallback.disconnectionRouter;
                if (z) {
                    disconnectionRouter2.bleExceptionBehaviorRelay.accept(new BleDisconnectedException(bluetoothGatt.getDevice().getAddress(), r8));
                } else if (r8 != 0) {
                    disconnectionRouter2.bleExceptionBehaviorRelay.accept(new BleGattException(bluetoothGatt, r8, BleGattOperationType.CONNECTION_STATE));
                }
                if (r9 != 1) {
                    if (r9 != 2) {
                        if (r9 != 3) {
                            rxBleConnectionState = RxBleConnection.RxBleConnectionState.DISCONNECTED;
                        } else {
                            rxBleConnectionState = RxBleConnection.RxBleConnectionState.DISCONNECTING;
                        }
                    } else {
                        rxBleConnectionState = RxBleConnection.RxBleConnectionState.CONNECTED;
                    }
                } else {
                    rxBleConnectionState = RxBleConnection.RxBleConnectionState.CONNECTING;
                }
                rxBleGattCallback.connectionStatePublishRelay.accept(rxBleConnectionState);
            }

            public void onConnectionUpdated(BluetoothGatt bluetoothGatt, int r10, int r11, int r12, int r13) {
                int r1 = LoggerUtil.$r8$clinit;
                if (RxBleLog.isAtLeast(4)) {
                    RxBleLog.i(LoggerUtil.commonMacMessage(bluetoothGatt) + " %24s(), status=%d, interval=%d (%.2f ms), latency=%d, timeout=%d (%.0f ms)", "onConnectionUpdated", Integer.valueOf(r13), Integer.valueOf(r10), Float.valueOf(r10 * 1.25f), Integer.valueOf(r11), Integer.valueOf(r12), Float.valueOf(r12 * 10.0f));
                }
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                rxBleGattCallback.nativeCallbackDispatcher.getClass();
                Output<Object> output = rxBleGattCallback.updatedConnectionOutput;
                if (output.hasObservers() && !RxBleGattCallback.propagateErrorIfOccurred$2(output, bluetoothGatt, r13, BleGattOperationType.CONNECTION_PRIORITY_CHANGE)) {
                    output.valueRelay.accept(new ViewPropertyAnimatorListenerAdapter());
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int r8) {
                boolean z;
                boolean z2 = true;
                LoggerUtil.logCallback("onDescriptorRead", bluetoothGatt, r8, bluetoothGattDescriptor, true);
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                BluetoothGattCallback bluetoothGattCallback = rxBleGattCallback.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, r8);
                }
                super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, r8);
                Output<ByteAssociation<BluetoothGattDescriptor>> output = rxBleGattCallback.readDescriptorOutput;
                if (output.hasObservers()) {
                    BleGattOperationType bleGattOperationType = BleGattOperationType.DESCRIPTOR_READ;
                    if (r8 != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        output.errorRelay.accept(new BleGattDescriptorException(bluetoothGatt, r8, bleGattOperationType));
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        output.valueRelay.accept(new ByteAssociation<>(bluetoothGattDescriptor, bluetoothGattDescriptor.getValue()));
                    }
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int r8) {
                boolean z;
                boolean z2 = false;
                LoggerUtil.logCallback("onDescriptorWrite", bluetoothGatt, r8, bluetoothGattDescriptor, false);
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                BluetoothGattCallback bluetoothGattCallback = rxBleGattCallback.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, r8);
                }
                super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, r8);
                Output<ByteAssociation<BluetoothGattDescriptor>> output = rxBleGattCallback.writeDescriptorOutput;
                if (output.hasObservers()) {
                    BleGattOperationType bleGattOperationType = BleGattOperationType.DESCRIPTOR_WRITE;
                    if (r8 != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        output.errorRelay.accept(new BleGattDescriptorException(bluetoothGatt, r8, bleGattOperationType));
                        z2 = true;
                    }
                    if (!z2) {
                        output.valueRelay.accept(new ByteAssociation<>(bluetoothGattDescriptor, bluetoothGattDescriptor.getValue()));
                    }
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public final void onMtuChanged(BluetoothGatt bluetoothGatt, int r4, int r5) {
                LoggerUtil.logCallback("onMtuChanged", bluetoothGatt, r5, r4);
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                BluetoothGattCallback bluetoothGattCallback = rxBleGattCallback.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onMtuChanged(bluetoothGatt, r4, r5);
                }
                super.onMtuChanged(bluetoothGatt, r4, r5);
                Output<Integer> output = rxBleGattCallback.changedMtuOutput;
                if (output.hasObservers() && !RxBleGattCallback.propagateErrorIfOccurred$2(output, bluetoothGatt, r5, BleGattOperationType.ON_MTU_CHANGED)) {
                    output.valueRelay.accept(Integer.valueOf(r4));
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int r4, int r5) {
                LoggerUtil.logCallback("onReadRemoteRssi", bluetoothGatt, r5, r4);
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                BluetoothGattCallback bluetoothGattCallback = rxBleGattCallback.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onReadRemoteRssi(bluetoothGatt, r4, r5);
                }
                super.onReadRemoteRssi(bluetoothGatt, r4, r5);
                Output<Integer> output = rxBleGattCallback.readRssiOutput;
                if (output.hasObservers() && !RxBleGattCallback.propagateErrorIfOccurred$2(output, bluetoothGatt, r5, BleGattOperationType.READ_RSSI)) {
                    output.valueRelay.accept(Integer.valueOf(r4));
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int r3) {
                LoggerUtil.logCallback("onReliableWriteCompleted", bluetoothGatt, r3);
                BluetoothGattCallback bluetoothGattCallback = RxBleGattCallback.this.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onReliableWriteCompleted(bluetoothGatt, r3);
                }
                super.onReliableWriteCompleted(bluetoothGatt, r3);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int r4) {
                LoggerUtil.logCallback("onServicesDiscovered", bluetoothGatt, r4);
                RxBleGattCallback rxBleGattCallback = RxBleGattCallback.this;
                BluetoothGattCallback bluetoothGattCallback = rxBleGattCallback.nativeCallbackDispatcher.nativeCallback;
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onServicesDiscovered(bluetoothGatt, r4);
                }
                super.onServicesDiscovered(bluetoothGatt, r4);
                Output<RxBleDeviceServices> output = rxBleGattCallback.servicesDiscoveredOutput;
                if (output.hasObservers() && !RxBleGattCallback.propagateErrorIfOccurred$2(output, bluetoothGatt, r4, BleGattOperationType.SERVICE_DISCOVERY)) {
                    output.valueRelay.accept(new RxBleDeviceServices(bluetoothGatt.getServices()));
                }
            }
        };
        this.callbackScheduler = scheduler;
        this.bluetoothGattProvider = bluetoothGattProvider;
        this.disconnectionRouter = disconnectionRouter;
        this.nativeCallbackDispatcher = nativeCallbackDispatcher;
    }

    public static boolean propagateErrorIfOccurred$2(Output<?> output, BluetoothGatt bluetoothGatt, int r5, BleGattOperationType bleGattOperationType) {
        boolean z;
        if (r5 != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        output.errorRelay.accept(new BleGattException(bluetoothGatt, r5, bleGattOperationType));
        return true;
    }

    public final <T> Observable<T> withDisconnectionHandling(Output<T> output) {
        Observable<Object> observable = this.disconnectionRouter.firstDisconnectionExceptionObs;
        PublishRelay<T> publishRelay = output.valueRelay;
        ObservableSource flatMap = output.errorRelay.flatMap(this.errorMapper);
        if (observable != null) {
            if (publishRelay != null) {
                if (flatMap != null) {
                    return Observable.fromArray(observable, publishRelay, flatMap).flatMap(Functions.IDENTITY, 3);
                }
                throw new NullPointerException("source3 is null");
            }
            throw new NullPointerException("source2 is null");
        }
        throw new NullPointerException("source1 is null");
    }
}
