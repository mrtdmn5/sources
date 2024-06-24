package com.polidea.rxandroidble2;

import bleshadow.dagger.Lazy;
import bleshadow.dagger.internal.DoubleCheck;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.util.BluetoothManagerWrapper;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission;
import com.polidea.rxandroidble2.internal.util.CheckerScanPermission;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser_Factory;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanResult;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;

/* loaded from: classes3.dex */
public final class RxBleClientImpl_Factory implements Provider {
    public final Provider<Observable<RxBleAdapterStateObservable.BleAdapterState>> adapterStateObservableProvider;
    public final Provider<BackgroundScanner> backgroundScannerProvider;
    public final Provider<Scheduler> bluetoothInteractionSchedulerProvider;
    public final Provider<BluetoothManagerWrapper> bluetoothManagerWrapperProvider;
    public final Provider<CheckerConnectPermission> checkerConnectPermissionProvider;
    public final Provider<CheckerScanPermission> checkerScanPermissionProvider;
    public final Provider<ClientComponent$ClientComponentFinalizer> clientComponentFinalizerProvider;
    public final Provider<ClientStateObservable> clientStateObservableProvider;
    public final Provider<Function<RxBleInternalScanResult, ScanResult>> internalToExternalScanResultMapFunctionProvider;
    public final Provider<LocationServicesStatus> locationServicesStatusProvider;
    public final Provider<ClientOperationQueue> operationQueueProvider;
    public final Provider<RxBleAdapterWrapper> rxBleAdapterWrapperProvider;
    public final Provider<RxBleDeviceProvider> rxBleDeviceProvider;
    public final Provider<ScanPreconditionsVerifier> scanPreconditionVerifierProvider;
    public final Provider<ScanRecordParser> scanRecordParserProvider;
    public final Provider<ScanSetupBuilder> scanSetupBuilderProvider;

    public RxBleClientImpl_Factory(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5, Provider provider6, Provider provider7, Provider provider8, Provider provider9, Provider provider10, Provider provider11, Provider provider12, Provider provider13, Provider provider14, Provider provider15) {
        ScanRecordParser_Factory scanRecordParser_Factory = ScanRecordParser_Factory.InstanceHolder.INSTANCE;
        this.bluetoothManagerWrapperProvider = provider;
        this.rxBleAdapterWrapperProvider = provider2;
        this.operationQueueProvider = provider3;
        this.adapterStateObservableProvider = provider4;
        this.scanRecordParserProvider = scanRecordParser_Factory;
        this.locationServicesStatusProvider = provider5;
        this.clientStateObservableProvider = provider6;
        this.rxBleDeviceProvider = provider7;
        this.scanSetupBuilderProvider = provider8;
        this.scanPreconditionVerifierProvider = provider9;
        this.internalToExternalScanResultMapFunctionProvider = provider10;
        this.bluetoothInteractionSchedulerProvider = provider11;
        this.clientComponentFinalizerProvider = provider12;
        this.backgroundScannerProvider = provider13;
        this.checkerScanPermissionProvider = provider14;
        this.checkerConnectPermissionProvider = provider15;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37, types: [bleshadow.dagger.Lazy] */
    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        DoubleCheck doubleCheck;
        this.bluetoothManagerWrapperProvider.get();
        RxBleAdapterWrapper rxBleAdapterWrapper = this.rxBleAdapterWrapperProvider.get();
        ClientOperationQueue clientOperationQueue = this.operationQueueProvider.get();
        Observable<RxBleAdapterStateObservable.BleAdapterState> observable = this.adapterStateObservableProvider.get();
        this.scanRecordParserProvider.get();
        LocationServicesStatus locationServicesStatus = this.locationServicesStatusProvider.get();
        Object obj = DoubleCheck.UNINITIALIZED;
        Provider<ClientStateObservable> provider = this.clientStateObservableProvider;
        if (provider instanceof Lazy) {
            doubleCheck = (Lazy) provider;
        } else {
            provider.getClass();
            doubleCheck = new DoubleCheck(provider);
        }
        RxBleDeviceProvider rxBleDeviceProvider = this.rxBleDeviceProvider.get();
        ScanSetupBuilder scanSetupBuilder = this.scanSetupBuilderProvider.get();
        ScanPreconditionsVerifier scanPreconditionsVerifier = this.scanPreconditionVerifierProvider.get();
        Function<RxBleInternalScanResult, ScanResult> function = this.internalToExternalScanResultMapFunctionProvider.get();
        Scheduler scheduler = this.bluetoothInteractionSchedulerProvider.get();
        ClientComponent$ClientComponentFinalizer clientComponent$ClientComponentFinalizer = this.clientComponentFinalizerProvider.get();
        BackgroundScanner backgroundScanner = this.backgroundScannerProvider.get();
        this.checkerScanPermissionProvider.get();
        this.checkerConnectPermissionProvider.get();
        return new RxBleClientImpl(rxBleAdapterWrapper, clientOperationQueue, observable, locationServicesStatus, doubleCheck, rxBleDeviceProvider, scanSetupBuilder, scanPreconditionsVerifier, function, scheduler, clientComponent$ClientComponentFinalizer, backgroundScanner);
    }
}
