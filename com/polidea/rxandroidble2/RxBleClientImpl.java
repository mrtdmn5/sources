package com.polidea.rxandroidble2;

import bleshadow.dagger.Lazy;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanSetup;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableFilter;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class RxBleClientImpl extends RxBleClient {
    public final BackgroundScanner backgroundScanner;
    public final Scheduler bluetoothInteractionScheduler;
    public final ClientComponent$ClientComponentFinalizer clientComponentFinalizer;
    public final Function<RxBleInternalScanResult, ScanResult> internalToExternalScanResultMapFunction;
    public final Lazy<ClientStateObservable> lazyClientStateObservable;
    public final LocationServicesStatus locationServicesStatus;
    public final ClientOperationQueue operationQueue;
    public final Observable<RxBleAdapterStateObservable.BleAdapterState> rxBleAdapterStateObservable;
    public final RxBleAdapterWrapper rxBleAdapterWrapper;
    public final RxBleDeviceProvider rxBleDeviceProvider;
    public final ScanPreconditionsVerifier scanPreconditionVerifier;
    public final ScanSetupBuilder scanSetupBuilder;

    public RxBleClientImpl(RxBleAdapterWrapper rxBleAdapterWrapper, ClientOperationQueue clientOperationQueue, Observable observable, LocationServicesStatus locationServicesStatus, Lazy lazy, RxBleDeviceProvider rxBleDeviceProvider, ScanSetupBuilder scanSetupBuilder, ScanPreconditionsVerifier scanPreconditionsVerifier, Function function, Scheduler scheduler, ClientComponent$ClientComponentFinalizer clientComponent$ClientComponentFinalizer, BackgroundScanner backgroundScanner) {
        new HashMap();
        this.operationQueue = clientOperationQueue;
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.rxBleAdapterStateObservable = observable;
        this.locationServicesStatus = locationServicesStatus;
        this.lazyClientStateObservable = lazy;
        this.rxBleDeviceProvider = rxBleDeviceProvider;
        this.scanSetupBuilder = scanSetupBuilder;
        this.scanPreconditionVerifier = scanPreconditionsVerifier;
        this.internalToExternalScanResultMapFunction = function;
        this.bluetoothInteractionScheduler = scheduler;
        this.clientComponentFinalizer = clientComponent$ClientComponentFinalizer;
        this.backgroundScanner = backgroundScanner;
    }

    public final void finalize() throws Throwable {
        this.clientComponentFinalizer.onFinalize();
        super.finalize();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public final RxBleDevice getBleDevice(String str) {
        boolean z;
        if (this.rxBleAdapterWrapper.bluetoothAdapter != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return this.rxBleDeviceProvider.getBleDevice(str);
        }
        throw new UnsupportedOperationException("RxAndroidBle library needs a BluetoothAdapter to be available in the system to work. If this is a test on an emulator then you can use 'https://github.com/Polidea/RxAndroidBle/tree/master/mockrxandroidble'");
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public final ObservableDefer scanBleDevices(final ScanSettings scanSettings, final ScanFilter... scanFilterArr) {
        return new ObservableDefer(new Callable() { // from class: com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda0
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Observable maybeToObservable;
                RxBleClientImpl rxBleClientImpl = RxBleClientImpl.this;
                rxBleClientImpl.getClass();
                ScanSettings scanSettings2 = scanSettings;
                rxBleClientImpl.scanPreconditionVerifier.verify(scanSettings2.mShouldCheckLocationProviderState);
                ScanSetup build = rxBleClientImpl.scanSetupBuilder.build(scanSettings2, scanFilterArr);
                ObservableDoOnEach observableDoOnEach = new ObservableDoOnEach(rxBleClientImpl.operationQueue.queue(build.scanOperation).unsubscribeOn(rxBleClientImpl.bluetoothInteractionScheduler).compose(build.scanOperationBehaviourEmulatorTransformer).map(rxBleClientImpl.internalToExternalScanResultMapFunction), new RxBleClientImpl$$ExternalSyntheticLambda1(), Functions.EMPTY_CONSUMER, Functions.EMPTY_ACTION);
                RxBleClientImpl$$ExternalSyntheticLambda2 rxBleClientImpl$$ExternalSyntheticLambda2 = new RxBleClientImpl$$ExternalSyntheticLambda2();
                Observable<RxBleAdapterStateObservable.BleAdapterState> observable = rxBleClientImpl.rxBleAdapterStateObservable;
                observable.getClass();
                MaybeFlatten maybeFlatten = new MaybeFlatten(new ObservableElementAtMaybe(new ObservableFilter(observable, rxBleClientImpl$$ExternalSyntheticLambda2)), new RxBleClientImpl$$ExternalSyntheticLambda3());
                if (maybeFlatten instanceof FuseToObservable) {
                    maybeToObservable = ((FuseToObservable) maybeFlatten).fuseToObservable();
                } else {
                    maybeToObservable = new MaybeToObservable(maybeFlatten);
                }
                if (maybeToObservable != null) {
                    return Observable.merge(observableDoOnEach, maybeToObservable);
                }
                throw new NullPointerException("other is null");
            }
        });
    }
}
