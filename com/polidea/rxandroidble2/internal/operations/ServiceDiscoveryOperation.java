package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import com.polidea.rxandroidble2.utils.StandardUUIDsParser;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleTimer;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ServiceDiscoveryOperation extends SingleResponseOperation<RxBleDeviceServices> {
    public final LoggerUtilBluetoothServices bleServicesLogger;
    public final BluetoothGatt bluetoothGatt;

    public ServiceDiscoveryOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, LoggerUtilBluetoothServices loggerUtilBluetoothServices, TimeoutConfiguration timeoutConfiguration) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.SERVICE_DISCOVERY, timeoutConfiguration);
        this.bluetoothGatt = bluetoothGatt;
        this.bleServicesLogger = loggerUtilBluetoothServices;
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final Single<RxBleDeviceServices> getCallback(RxBleGattCallback rxBleGattCallback) {
        return new SingleDoOnSuccess(new ObservableElementAtSingle(rxBleGattCallback.withDisconnectionHandling(rxBleGattCallback.servicesDiscoveredOutput).delay(0L, TimeUnit.SECONDS, rxBleGattCallback.callbackScheduler)), new Consumer() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                String str;
                String str2;
                String str3;
                String str4;
                RxBleDeviceServices rxBleDeviceServices = (RxBleDeviceServices) obj;
                ServiceDiscoveryOperation serviceDiscoveryOperation = ServiceDiscoveryOperation.this;
                BluetoothDevice device = serviceDiscoveryOperation.bluetoothGatt.getDevice();
                LoggerUtilBluetoothServices loggerUtilBluetoothServices = serviceDiscoveryOperation.bleServicesLogger;
                loggerUtilBluetoothServices.getClass();
                if (RxBleLog.isAtLeast(2)) {
                    RxBleLog.v("Preparing services description", new Object[0]);
                    StringBuilder sb = new StringBuilder("--------------- ====== Printing peripheral content ====== ---------------\n");
                    sb.append(LoggerUtil.commonMacMessage(device.getAddress()));
                    sb.append("\nPERIPHERAL NAME: ");
                    sb.append(device.getName());
                    sb.append("\n-------------------------------------------------------------------------");
                    for (BluetoothGattService bluetoothGattService : rxBleDeviceServices.bluetoothGattServices) {
                        sb.append("\n\n");
                        if (bluetoothGattService.getType() == 0) {
                            str = "Primary Service";
                        } else {
                            str = "Secondary Service";
                        }
                        sb.append(str);
                        sb.append(" - ");
                        String standardizedUUIDComponent = StandardUUIDsParser.getStandardizedUUIDComponent(bluetoothGattService.getUuid());
                        if (standardizedUUIDComponent != null) {
                            str2 = StandardUUIDsParser.SERVICE_UUIDS.get(standardizedUUIDComponent);
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            str2 = "Unknown service";
                        }
                        sb.append(str2);
                        sb.append(" (...)\nInstance ID: ");
                        bluetoothGattService.getUuid();
                        LoggerUtil.getUuidToLog();
                        sb.append(bluetoothGattService.getInstanceId());
                        sb.append("\n-> Characteristics:");
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                            sb.append("\n\t* ");
                            String standardizedUUIDComponent2 = StandardUUIDsParser.getStandardizedUUIDComponent(bluetoothGattCharacteristic.getUuid());
                            if (standardizedUUIDComponent2 != null) {
                                str3 = StandardUUIDsParser.CHARACTERISTIC_UUIDS.get(standardizedUUIDComponent2);
                            } else {
                                str3 = null;
                            }
                            if (str3 == null) {
                                str3 = "Unknown characteristic";
                            }
                            sb.append(str3);
                            sb.append(" (...)\n\t  Properties: ");
                            bluetoothGattCharacteristic.getUuid();
                            LoggerUtil.getUuidToLog();
                            sb.append(loggerUtilBluetoothServices.characteristicPropertiesParser.propertiesIntToString(bluetoothGattCharacteristic.getProperties()));
                            if (!bluetoothGattCharacteristic.getDescriptors().isEmpty()) {
                                sb.append("\n\t  -> Descriptors: ");
                                for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                    sb.append("\n\t\t* ");
                                    String standardizedUUIDComponent3 = StandardUUIDsParser.getStandardizedUUIDComponent(bluetoothGattDescriptor.getUuid());
                                    if (standardizedUUIDComponent3 != null) {
                                        str4 = StandardUUIDsParser.DESCRIPTOR_UUIDS.get(standardizedUUIDComponent3);
                                    } else {
                                        str4 = null;
                                    }
                                    if (str4 == null) {
                                        str4 = "Unknown descriptor";
                                    }
                                    sb.append(str4);
                                    sb.append(" (...)");
                                    bluetoothGattDescriptor.getUuid();
                                    LoggerUtil.getUuidToLog();
                                }
                            }
                        }
                    }
                    sb.append("\n--------------- ====== Finished peripheral content ====== ---------------");
                    RxBleLog.v(sb.toString(), new Object[0]);
                }
            }
        });
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final boolean startOperation(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.discoverServices();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda1] */
    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final Single timeoutFallbackProcedure(final BluetoothGatt bluetoothGatt, final Scheduler scheduler) {
        return new SingleDefer(new Callable() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                final BluetoothGatt bluetoothGatt2 = bluetoothGatt;
                if (bluetoothGatt2.getServices().size() == 0) {
                    return new SingleError(new Functions.JustValue(new BleGattCallbackTimeoutException(bluetoothGatt2, BleGattOperationType.SERVICE_DISCOVERY)));
                }
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (timeUnit != null) {
                    Scheduler scheduler2 = scheduler;
                    if (scheduler2 != null) {
                        return new SingleFlatMap(new SingleTimer(timeUnit, scheduler2), new Function() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda2
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj) {
                                final BluetoothGatt bluetoothGatt3 = bluetoothGatt2;
                                return new SingleFromCallable(new Callable() { // from class: com.polidea.rxandroidble2.internal.operations.ServiceDiscoveryOperation$$ExternalSyntheticLambda3
                                    @Override // java.util.concurrent.Callable
                                    public final Object call() {
                                        return new RxBleDeviceServices(bluetoothGatt3.getServices());
                                    }
                                });
                            }
                        });
                    }
                    throw new NullPointerException("scheduler is null");
                }
                throw new NullPointerException("unit is null");
            }
        });
    }

    @Override // com.polidea.rxandroidble2.internal.SingleResponseOperation
    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("ServiceDiscoveryOperation{"), super.toString(), '}');
    }
}
