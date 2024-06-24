package com.polidea.rxandroidble2;

import android.content.Context;
import bleshadow.dagger.internal.DoubleCheck;
import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory;
import com.polidea.rxandroidble2.ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider_Factory;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache_Factory;
import com.polidea.rxandroidble2.internal.scan.AndroidScanObjectsConverter_Factory;
import com.polidea.rxandroidble2.internal.scan.BackgroundScannerImpl_Factory;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator_Factory;
import com.polidea.rxandroidble2.internal.scan.InternalToExternalScanResultConverter_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi18_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifierApi24_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi21_Factory;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi23_Factory;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl_Factory;
import com.polidea.rxandroidble2.internal.util.BluetoothManagerWrapper_Factory;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission_Factory;
import com.polidea.rxandroidble2.internal.util.CheckerLocationProvider_Factory;
import com.polidea.rxandroidble2.internal.util.CheckerPermission;
import com.polidea.rxandroidble2.internal.util.CheckerPermission_Factory;
import com.polidea.rxandroidble2.internal.util.CheckerScanPermission;
import com.polidea.rxandroidble2.internal.util.CheckerScanPermission_Factory;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesOkObservableApi23Factory_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi23_Factory;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatusApi31_Factory;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper_Factory;
import io.reactivex.Scheduler;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class DaggerClientComponent$ClientComponentImpl {
    public AndroidScanObjectsConverter_Factory androidScanObjectsConverterProvider;
    public final Context applicationContext;
    public InstanceFactory applicationContextProvider;
    public BackgroundScannerImpl_Factory backgroundScannerImplProvider;
    public Provider<ClientOperationQueue> bindClientOperationQueueProvider;
    public Provider<RxBleClient> bindRxBleClientProvider;
    public BluetoothManagerWrapper_Factory bluetoothManagerWrapperProvider;
    public CheckerLocationProvider_Factory checkerLocationProvider;
    public Provider<CheckerPermission> checkerPermissionProvider;
    public Provider<CheckerScanPermission> checkerScanPermissionProvider;
    public final DaggerClientComponent$ClientComponentImpl clientComponentImpl = this;
    public ClientStateObservable_Factory clientStateObservableProvider;
    public Provider<InternalScanResultCreator> internalScanResultCreatorProvider;
    public InternalToExternalScanResultConverter_Factory internalToExternalScanResultConverterProvider;
    public LocationServicesStatusApi23_Factory locationServicesStatusApi23Provider;
    public LocationServicesStatusApi31_Factory locationServicesStatusApi31Provider;
    public Provider<Scheduler> provideBluetoothCallbacksSchedulerProvider;
    public Provider<ExecutorService> provideBluetoothInteractionExecutorServiceProvider;
    public Provider<Scheduler> provideBluetoothInteractionSchedulerProvider;
    public ClientComponent_ClientModule_ProvideBluetoothManagerFactory provideBluetoothManagerProvider;
    public Provider<ExecutorService> provideConnectionQueueExecutorServiceProvider;
    public ClientComponent_ClientModule_ProvideFinalizationCloseableFactory provideFinalizationCloseableProvider;
    public Provider<Boolean> provideIsNearbyPermissionNeverForLocationProvider;
    public ClientComponent_ClientModule_ProvideLocationServicesStatusFactory provideLocationServicesStatusProvider;
    public ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory provideScanPreconditionVerifierProvider;
    public Provider<ScanSetupBuilder> provideScanSetupProvider;
    public ClientComponent_ClientModule_ProvideTargetSdkFactory provideTargetSdkProvider;
    public RxBleAdapterStateObservable_Factory rxBleAdapterStateObservableProvider;
    public RxBleAdapterWrapper_Factory rxBleAdapterWrapperProvider;
    public Provider<RxBleDeviceProvider> rxBleDeviceProvider;

    /* renamed from: com.polidea.rxandroidble2.DaggerClientComponent$ClientComponentImpl$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Provider<DeviceComponent.Builder> {
        public AnonymousClass1() {
        }

        @Override // bleshadow.javax.inject.Provider
        public final DeviceComponent.Builder get() {
            return new DaggerClientComponent$DeviceComponentBuilder(DaggerClientComponent$ClientComponentImpl.this.clientComponentImpl);
        }
    }

    public DaggerClientComponent$ClientComponentImpl(Context context) {
        this.applicationContext = context;
        InstanceFactory create = InstanceFactory.create(context);
        this.applicationContextProvider = create;
        this.checkerLocationProvider = new CheckerLocationProvider_Factory(new ClientComponent_ClientModule_ProvideContentResolverFactory(create), new ClientComponent_ClientModule_ProvideLocationManagerFactory(create));
        this.checkerPermissionProvider = DoubleCheck.provider(new CheckerPermission_Factory(create));
        InstanceFactory instanceFactory = this.applicationContextProvider;
        this.provideTargetSdkProvider = new ClientComponent_ClientModule_ProvideTargetSdkFactory(instanceFactory);
        Provider<Boolean> provider = DoubleCheck.provider(new ClientComponent_ClientModule_ProvideIsNearbyPermissionNeverForLocationFactory(instanceFactory));
        this.provideIsNearbyPermissionNeverForLocationProvider = provider;
        Provider<CheckerScanPermission> provider2 = DoubleCheck.provider(new CheckerScanPermission_Factory(this.checkerPermissionProvider, new ClientComponent_ClientModule_ProvideRecommendedScanRuntimePermissionNamesFactory(this.provideTargetSdkProvider, provider)));
        this.checkerScanPermissionProvider = provider2;
        InstanceFactory instanceFactory2 = this.applicationContextProvider;
        ClientComponent_ClientModule_ProvideIsAndroidWearFactory clientComponent_ClientModule_ProvideIsAndroidWearFactory = new ClientComponent_ClientModule_ProvideIsAndroidWearFactory(instanceFactory2);
        CheckerLocationProvider_Factory checkerLocationProvider_Factory = this.checkerLocationProvider;
        this.locationServicesStatusApi23Provider = new LocationServicesStatusApi23_Factory(checkerLocationProvider_Factory, provider2, this.provideTargetSdkProvider, clientComponent_ClientModule_ProvideIsAndroidWearFactory);
        this.locationServicesStatusApi31Provider = new LocationServicesStatusApi31_Factory(checkerLocationProvider_Factory, provider2, clientComponent_ClientModule_ProvideIsAndroidWearFactory, this.provideIsNearbyPermissionNeverForLocationProvider);
        ClientComponent_ClientModule_ProvideBluetoothManagerFactory clientComponent_ClientModule_ProvideBluetoothManagerFactory = new ClientComponent_ClientModule_ProvideBluetoothManagerFactory(instanceFactory2);
        this.provideBluetoothManagerProvider = clientComponent_ClientModule_ProvideBluetoothManagerFactory;
        this.bluetoothManagerWrapperProvider = new BluetoothManagerWrapper_Factory(clientComponent_ClientModule_ProvideBluetoothManagerFactory);
        this.rxBleAdapterWrapperProvider = new RxBleAdapterWrapper_Factory();
        Provider<ExecutorService> provider3 = DoubleCheck.provider(ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory.InstanceHolder.INSTANCE);
        this.provideBluetoothInteractionExecutorServiceProvider = provider3;
        Provider<Scheduler> provider4 = DoubleCheck.provider(new ClientComponent_ClientModule_ProvideBluetoothInteractionSchedulerFactory(provider3));
        this.provideBluetoothInteractionSchedulerProvider = provider4;
        this.bindClientOperationQueueProvider = DoubleCheck.provider(new ClientOperationQueueImpl_Factory(provider4));
        InstanceFactory instanceFactory3 = this.applicationContextProvider;
        RxBleAdapterStateObservable_Factory rxBleAdapterStateObservable_Factory = new RxBleAdapterStateObservable_Factory(instanceFactory3);
        this.rxBleAdapterStateObservableProvider = rxBleAdapterStateObservable_Factory;
        ClientComponent_ClientModule_ProvideLocationServicesStatusFactory clientComponent_ClientModule_ProvideLocationServicesStatusFactory = new ClientComponent_ClientModule_ProvideLocationServicesStatusFactory(this.locationServicesStatusApi23Provider, this.locationServicesStatusApi31Provider);
        this.provideLocationServicesStatusProvider = clientComponent_ClientModule_ProvideLocationServicesStatusFactory;
        this.clientStateObservableProvider = new ClientStateObservable_Factory(this.rxBleAdapterWrapperProvider, rxBleAdapterStateObservable_Factory, new ClientComponent_ClientModule_ProvideLocationServicesOkObservableFactory(new LocationServicesOkObservableApi23Factory_Factory(instanceFactory3, clientComponent_ClientModule_ProvideLocationServicesStatusFactory)), clientComponent_ClientModule_ProvideLocationServicesStatusFactory);
        this.rxBleDeviceProvider = DoubleCheck.provider(new RxBleDeviceProvider_Factory(DoubleCheck.provider(DeviceComponentCache_Factory.InstanceHolder.INSTANCE), new Provider<DeviceComponent.Builder>() { // from class: com.polidea.rxandroidble2.DaggerClientComponent$ClientComponentImpl.1
            public AnonymousClass1() {
            }

            @Override // bleshadow.javax.inject.Provider
            public final DeviceComponent.Builder get() {
                return new DaggerClientComponent$DeviceComponentBuilder(DaggerClientComponent$ClientComponentImpl.this.clientComponentImpl);
            }
        }));
        Provider<InternalScanResultCreator> provider5 = DoubleCheck.provider(new InternalScanResultCreator_Factory(DoubleCheck.provider(new ClientComponent_ClientModule_ProvideIsConnectableCheckerFactory())));
        this.internalScanResultCreatorProvider = provider5;
        ScanSettingsEmulator_Factory scanSettingsEmulator_Factory = new ScanSettingsEmulator_Factory();
        RxBleAdapterWrapper_Factory rxBleAdapterWrapper_Factory = this.rxBleAdapterWrapperProvider;
        ScanSetupBuilderImplApi18_Factory scanSetupBuilderImplApi18_Factory = new ScanSetupBuilderImplApi18_Factory(rxBleAdapterWrapper_Factory, provider5, scanSettingsEmulator_Factory);
        AndroidScanObjectsConverter_Factory androidScanObjectsConverter_Factory = new AndroidScanObjectsConverter_Factory();
        this.androidScanObjectsConverterProvider = androidScanObjectsConverter_Factory;
        this.provideScanSetupProvider = DoubleCheck.provider(new ClientComponent_ClientModule_ProvideScanSetupProviderFactory(scanSetupBuilderImplApi18_Factory, new ScanSetupBuilderImplApi21_Factory(rxBleAdapterWrapper_Factory, provider5, scanSettingsEmulator_Factory, androidScanObjectsConverter_Factory), new ScanSetupBuilderImplApi23_Factory(rxBleAdapterWrapper_Factory, provider5, scanSettingsEmulator_Factory, androidScanObjectsConverter_Factory)));
        ScanPreconditionsVerifierApi18_Factory scanPreconditionsVerifierApi18_Factory = new ScanPreconditionsVerifierApi18_Factory(this.rxBleAdapterWrapperProvider, this.provideLocationServicesStatusProvider);
        this.provideScanPreconditionVerifierProvider = new ClientComponent_ClientModule_ProvideScanPreconditionVerifierFactory(scanPreconditionsVerifierApi18_Factory, new ScanPreconditionsVerifierApi24_Factory(scanPreconditionsVerifierApi18_Factory));
        this.internalToExternalScanResultConverterProvider = new InternalToExternalScanResultConverter_Factory(this.rxBleDeviceProvider);
        this.provideBluetoothCallbacksSchedulerProvider = DoubleCheck.provider(ClientComponent_ClientModule_ProvideBluetoothCallbacksSchedulerFactory.InstanceHolder.INSTANCE);
        Provider<ExecutorService> provider6 = DoubleCheck.provider(ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory.InstanceHolder.INSTANCE);
        this.provideConnectionQueueExecutorServiceProvider = provider6;
        this.provideFinalizationCloseableProvider = new ClientComponent_ClientModule_ProvideFinalizationCloseableFactory(this.provideBluetoothInteractionExecutorServiceProvider, this.provideBluetoothCallbacksSchedulerProvider, provider6);
        this.backgroundScannerImplProvider = new BackgroundScannerImpl_Factory(this.rxBleAdapterWrapperProvider, this.androidScanObjectsConverterProvider, this.internalScanResultCreatorProvider, this.internalToExternalScanResultConverterProvider);
        this.bindRxBleClientProvider = DoubleCheck.provider(new RxBleClientImpl_Factory(this.bluetoothManagerWrapperProvider, this.rxBleAdapterWrapperProvider, this.bindClientOperationQueueProvider, this.rxBleAdapterStateObservableProvider, this.provideLocationServicesStatusProvider, this.clientStateObservableProvider, this.rxBleDeviceProvider, this.provideScanSetupProvider, this.provideScanPreconditionVerifierProvider, this.internalToExternalScanResultConverterProvider, this.provideBluetoothInteractionSchedulerProvider, this.provideFinalizationCloseableProvider, this.backgroundScannerImplProvider, this.checkerScanPermissionProvider, DoubleCheck.provider(new CheckerConnectPermission_Factory(this.checkerPermissionProvider, new ClientComponent_ClientModule_ProvideRecommendedConnectRuntimePermissionNamesFactory(this.provideTargetSdkProvider)))));
    }
}
