package com.animaconnected.bluetooth.gatt;

import com.animaconnected.bluetooth.device.scanner.ScannedDevice;
import com.animaconnected.logger.LogKt;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: DeviceScanner.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.DeviceScanner$scan$1", f = "DeviceScanner.kt", l = {60}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DeviceScanner$scan$1 extends SuspendLambda implements Function2<ProducerScope<? super ScannedDevice>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceScanner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceScanner$scan$1(DeviceScanner deviceScanner, Continuation<? super DeviceScanner$scan$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceScanner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceScanner$scan$1 deviceScanner$scan$1 = new DeviceScanner$scan$1(this.this$0, continuation);
        deviceScanner$scan$1.L$0 = obj;
        return deviceScanner$scan$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RxBleClient rxBleClient;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r2 = this.label;
        if (r2 != 0) {
            if (r2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final ArrayList arrayList = new ArrayList();
            rxBleClient = this.this$0.rxBleClient;
            ObservableObserveOn observeOn = rxBleClient.scanBleDevices(new ScanSettings(2, 1, 0L, 1, 3, true), new ScanFilter(null, null, null, null, null, null, null, null, null, -1, null, null)).observeOn(AndroidSchedulers.mainThread());
            final DeviceScanner deviceScanner = this.this$0;
            final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$scan$1$scanDisposable$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                    invoke2(disposable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Disposable disposable) {
                    LogKt.debug$default((Object) producerScope, deviceScanner.getTag(), (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$scan$1$scanDisposable$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Scanning...";
                        }
                    }, 6, (Object) null);
                }
            };
            ObservableDoOnLifecycle observableDoOnLifecycle = new ObservableDoOnLifecycle(observeOn, new Consumer() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$scan$1$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            final DeviceScanner deviceScanner2 = this.this$0;
            final Function1<ScanResult, Unit> function12 = new Function1<ScanResult, Unit>() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$scan$1$scanDisposable$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ScanResult scanResult) {
                    invoke2(scanResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ScanResult bleScanResult) {
                    ScannedDevice parseScannedDevice;
                    Intrinsics.checkNotNullParameter(bleScanResult, "bleScanResult");
                    List<RxBleDevice> list = arrayList;
                    RxBleDevice rxBleDevice = bleScanResult.bleDevice;
                    if (list.contains(rxBleDevice)) {
                        return;
                    }
                    List<RxBleDevice> list2 = arrayList;
                    Intrinsics.checkNotNullExpressionValue(rxBleDevice, "getBleDevice(...)");
                    list2.add(rxBleDevice);
                    parseScannedDevice = deviceScanner2.parseScannedDevice(bleScanResult);
                    if (parseScannedDevice != null) {
                        producerScope.mo1701trySendJP2dKIU(parseScannedDevice);
                    }
                }
            };
            Consumer consumer = new Consumer() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$scan$1$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            };
            final DeviceScanner deviceScanner3 = this.this$0;
            final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$scan$1$scanDisposable$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable throwable) {
                    String description;
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    if (throwable instanceof BleScanException) {
                        String tag = DeviceScanner.this.getTag();
                        description = DeviceScanner.this.description((BleScanException) throwable);
                        LogKt.debug((Object) producerScope, description, tag, throwable, true);
                    }
                    producerScope.close(throwable);
                }
            };
            final LambdaObserver subscribe = observableDoOnLifecycle.subscribe(consumer, new Consumer() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$scan$1$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.animaconnected.bluetooth.gatt.DeviceScanner$scan$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Disposable disposable;
                    if (Disposable.this.isDisposed() || (disposable = Disposable.this) == null) {
                        return;
                    }
                    disposable.dispose();
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super ScannedDevice> producerScope, Continuation<? super Unit> continuation) {
        return ((DeviceScanner$scan$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
