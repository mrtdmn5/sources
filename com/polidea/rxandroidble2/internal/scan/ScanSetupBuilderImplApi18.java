package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.operations.ScanOperationApi18;
import com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ScanSetupBuilderImplApi18 implements ScanSetupBuilder {
    public final InternalScanResultCreator internalScanResultCreator;
    public final RxBleAdapterWrapper rxBleAdapterWrapper;
    public final ScanSettingsEmulator scanSettingsEmulator;

    public ScanSetupBuilderImplApi18(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator, ScanSettingsEmulator scanSettingsEmulator) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.internalScanResultCreator = internalScanResultCreator;
        this.scanSettingsEmulator = scanSettingsEmulator;
    }

    @Override // com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder
    public final ScanSetup build(ScanSettings scanSettings, ScanFilter... scanFilterArr) {
        ScanSettingsEmulator.AnonymousClass2 anonymousClass2;
        final ObservableTransformer observableTransformer;
        ScanSettingsEmulator scanSettingsEmulator = this.scanSettingsEmulator;
        scanSettingsEmulator.getClass();
        int r6 = scanSettings.mScanMode;
        if (r6 != -1) {
            if (r6 != 0) {
                if (r6 != 1) {
                    observableTransformer = ObservableUtil.IDENTITY_TRANSFORMER;
                    final ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> emulateCallbackType = scanSettingsEmulator.emulateCallbackType(scanSettings.mCallbackType);
                    return new ScanSetup(new ScanOperationApi18(this.rxBleAdapterWrapper, this.internalScanResultCreator, new EmulatedScanFilterMatcher(scanFilterArr)), new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18.1
                        @Override // io.reactivex.ObservableTransformer
                        public final Observable apply(Observable observable) {
                            return observable.compose(ObservableTransformer.this).compose(emulateCallbackType);
                        }
                    });
                }
                anonymousClass2 = new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.2
                    public final /* synthetic */ long val$delayToNextWindow;
                    public final /* synthetic */ int val$windowInMillis;

                    /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$2$1 */
                    /* loaded from: classes3.dex */
                    public class AnonymousClass1 implements Function<Observable<Object>, ObservableSource<?>> {
                        public AnonymousClass1() {
                        }

                        @Override // io.reactivex.functions.Function
                        public final ObservableSource<?> apply(Observable<Object> observable) throws Exception {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            return observable.delay(r3, TimeUnit.MILLISECONDS, ScanSettingsEmulator.this.scheduler);
                        }
                    }

                    public AnonymousClass2(int r2, long j) {
                        r2 = r2;
                        r3 = j;
                    }

                    @Override // io.reactivex.ObservableTransformer
                    public final Observable apply(Observable observable) {
                        long j = r2;
                        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                        Scheduler scheduler = ScanSettingsEmulator.this.scheduler;
                        observable.getClass();
                        return new ObservableRepeatWhen(new ObservableTakeUntil(observable, Observable.timer(j, timeUnit, scheduler)), new Function<Observable<Object>, ObservableSource<?>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.2.1
                            public AnonymousClass1() {
                            }

                            @Override // io.reactivex.functions.Function
                            public final ObservableSource<?> apply(Observable<Object> observable2) throws Exception {
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                return observable2.delay(r3, TimeUnit.MILLISECONDS, ScanSettingsEmulator.this.scheduler);
                            }
                        });
                    }
                };
                observableTransformer = anonymousClass2;
                final ObservableTransformer emulateCallbackType2 = scanSettingsEmulator.emulateCallbackType(scanSettings.mCallbackType);
                return new ScanSetup(new ScanOperationApi18(this.rxBleAdapterWrapper, this.internalScanResultCreator, new EmulatedScanFilterMatcher(scanFilterArr)), new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18.1
                    @Override // io.reactivex.ObservableTransformer
                    public final Observable apply(Observable observable) {
                        return observable.compose(ObservableTransformer.this).compose(emulateCallbackType2);
                    }
                });
            }
        } else {
            RxBleLog.w("Cannot emulate opportunistic scan mode since it is OS dependent - fallthrough to low power", new Object[0]);
        }
        anonymousClass2 = new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.2
            public final /* synthetic */ long val$delayToNextWindow;
            public final /* synthetic */ int val$windowInMillis;

            /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$2$1 */
            /* loaded from: classes3.dex */
            public class AnonymousClass1 implements Function<Observable<Object>, ObservableSource<?>> {
                public AnonymousClass1() {
                }

                @Override // io.reactivex.functions.Function
                public final ObservableSource<?> apply(Observable<Object> observable2) throws Exception {
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    return observable2.delay(r3, TimeUnit.MILLISECONDS, ScanSettingsEmulator.this.scheduler);
                }
            }

            public AnonymousClass2(int r2, long j) {
                r2 = r2;
                r3 = j;
            }

            @Override // io.reactivex.ObservableTransformer
            public final Observable apply(Observable observable) {
                long j = r2;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                Scheduler scheduler = ScanSettingsEmulator.this.scheduler;
                observable.getClass();
                return new ObservableRepeatWhen(new ObservableTakeUntil(observable, Observable.timer(j, timeUnit, scheduler)), new Function<Observable<Object>, ObservableSource<?>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.2.1
                    public AnonymousClass1() {
                    }

                    @Override // io.reactivex.functions.Function
                    public final ObservableSource<?> apply(Observable<Object> observable2) throws Exception {
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        return observable2.delay(r3, TimeUnit.MILLISECONDS, ScanSettingsEmulator.this.scheduler);
                    }
                });
            }
        };
        observableTransformer = anonymousClass2;
        final ObservableTransformer emulateCallbackType22 = scanSettingsEmulator.emulateCallbackType(scanSettings.mCallbackType);
        return new ScanSetup(new ScanOperationApi18(this.rxBleAdapterWrapper, this.internalScanResultCreator, new EmulatedScanFilterMatcher(scanFilterArr)), new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSetupBuilderImplApi18.1
            @Override // io.reactivex.ObservableTransformer
            public final Observable apply(Observable observable) {
                return observable.compose(ObservableTransformer.this).compose(emulateCallbackType22);
            }
        });
    }
}
