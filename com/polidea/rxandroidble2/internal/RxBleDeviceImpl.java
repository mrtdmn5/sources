package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.ConnectionSetup;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.exceptions.BleAlreadyConnectedException;
import com.polidea.rxandroidble2.internal.connection.Connector;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class RxBleDeviceImpl implements RxBleDevice {
    public final BluetoothDevice bluetoothDevice;
    public final Connector connector;
    public final AtomicBoolean isConnected = new AtomicBoolean(false);

    public RxBleDeviceImpl(BluetoothDevice bluetoothDevice, Connector connector) {
        this.bluetoothDevice = bluetoothDevice;
        this.connector = connector;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxBleDeviceImpl)) {
            return false;
        }
        return this.bluetoothDevice.equals(((RxBleDeviceImpl) obj).bluetoothDevice);
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public final ObservableDefer establishConnection(boolean z) {
        final ConnectionSetup connectionSetup = new ConnectionSetup(z, true, new Timeout(TimeUnit.SECONDS));
        return new ObservableDefer(new Callable() { // from class: com.polidea.rxandroidble2.internal.RxBleDeviceImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                final RxBleDeviceImpl rxBleDeviceImpl = RxBleDeviceImpl.this;
                if (rxBleDeviceImpl.isConnected.compareAndSet(false, true)) {
                    ObservableDefer prepareConnection = rxBleDeviceImpl.connector.prepareConnection(connectionSetup);
                    Action action = new Action() { // from class: com.polidea.rxandroidble2.internal.RxBleDeviceImpl$$ExternalSyntheticLambda1
                        @Override // io.reactivex.functions.Action
                        public final void run() {
                            RxBleDeviceImpl.this.isConnected.set(false);
                        }
                    };
                    prepareConnection.getClass();
                    return new ObservableDoFinally(prepareConnection, action);
                }
                return Observable.error(new BleAlreadyConnectedException(rxBleDeviceImpl.bluetoothDevice.getAddress()));
            }
        });
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public final BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public final String getMacAddress() {
        return this.bluetoothDevice.getAddress();
    }

    @Override // com.polidea.rxandroidble2.RxBleDevice
    public final String getName() {
        return this.bluetoothDevice.getName();
    }

    public final int hashCode() {
        return this.bluetoothDevice.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RxBleDeviceImpl{");
        BluetoothDevice bluetoothDevice = this.bluetoothDevice;
        sb.append(LoggerUtil.commonMacMessage(bluetoothDevice.getAddress()));
        sb.append(", name=");
        sb.append(bluetoothDevice.getName());
        sb.append('}');
        return sb.toString();
    }
}
