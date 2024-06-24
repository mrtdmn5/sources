package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.observables.GroupedObservable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ScanSettingsEmulator {
    public final AnonymousClass1 emulateFirstMatch;
    public final Scheduler scheduler;
    public final AnonymousClass5 emulateMatchLost = new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.5
        @Override // io.reactivex.ObservableTransformer
        public final Observable apply(Observable observable) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Scheduler scheduler = ScanSettingsEmulator.this.scheduler;
            observable.getClass();
            if (timeUnit != null) {
                if (scheduler != null) {
                    return new ObservableDebounceTimed(observable, timeUnit, scheduler).map(new AnonymousClass6());
                }
                throw new NullPointerException("scheduler is null");
            }
            throw new NullPointerException("unit is null");
        }
    };
    public final AnonymousClass7 emulateFirstMatchAndMatchLost = new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.7
        @Override // io.reactivex.ObservableTransformer
        public final Observable apply(Observable observable) {
            Function<Observable<RxBleInternalScanResult>, Observable<RxBleInternalScanResult>> function = new Function<Observable<RxBleInternalScanResult>, Observable<RxBleInternalScanResult>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.7.1
                @Override // io.reactivex.functions.Function
                public final Observable<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable2) throws Exception {
                    Observable<RxBleInternalScanResult> observable3 = observable2;
                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                    return Observable.merge(observable3.compose(ScanSettingsEmulator.this.emulateFirstMatch), observable3.compose(ScanSettingsEmulator.this.emulateMatchLost));
                }
            };
            observable.getClass();
            return new ObservablePublishSelector(observable, function);
        }
    };

    /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> {
        public final ObservableTimer timerObservable;
        public final AnonymousClass4 toFirstMatchFunc = new AnonymousClass4();
        public final C01361 emitAfterTimerFunc = new Function<RxBleInternalScanResult, Observable<?>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.1.1
            @Override // io.reactivex.functions.Function
            public final Observable<?> apply(RxBleInternalScanResult rxBleInternalScanResult) throws Exception {
                return AnonymousClass1.this.timerObservable;
            }
        };
        public final AnonymousClass2 takeFirstFromEachWindowFunc = new AnonymousClass2();

        /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$1$2, reason: invalid class name */
        /* loaded from: classes3.dex */
        public class AnonymousClass2 implements Function<Observable<RxBleInternalScanResult>, Observable<RxBleInternalScanResult>> {
            @Override // io.reactivex.functions.Function
            public final Observable<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable) throws Exception {
                Observable<RxBleInternalScanResult> observable2 = observable;
                observable2.getClass();
                return new ObservableTake(observable2);
            }
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$1$1] */
        public AnonymousClass1(Scheduler scheduler) {
            this.timerObservable = Observable.timer(10L, TimeUnit.SECONDS, scheduler);
        }

        @Override // io.reactivex.ObservableTransformer
        public final Observable apply(Observable observable) {
            Function<Observable<RxBleInternalScanResult>, ObservableSource<RxBleInternalScanResult>> function = new Function<Observable<RxBleInternalScanResult>, ObservableSource<RxBleInternalScanResult>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.1.3
                @Override // io.reactivex.functions.Function
                public final ObservableSource<RxBleInternalScanResult> apply(Observable<RxBleInternalScanResult> observable2) throws Exception {
                    Observable<RxBleInternalScanResult> observable3 = observable2;
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    Observable<R> switchMap = observable3.switchMap(anonymousClass1.emitAfterTimerFunc);
                    int r2 = Flowable.BUFFER_SIZE;
                    if (switchMap != 0) {
                        ObjectHelper.verifyPositive(r2, "bufferSize");
                        return new ObservableWindowBoundary(observable3, switchMap, r2).flatMap(anonymousClass1.takeFirstFromEachWindowFunc).map(anonymousClass1.toFirstMatchFunc);
                    }
                    throw new NullPointerException("boundary is null");
                }
            };
            observable.getClass();
            return new ObservablePublishSelector(observable, function);
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass4 implements Function<RxBleInternalScanResult, RxBleInternalScanResult> {
        @Override // io.reactivex.functions.Function
        public final RxBleInternalScanResult apply(RxBleInternalScanResult rxBleInternalScanResult) throws Exception {
            RxBleInternalScanResult rxBleInternalScanResult2 = rxBleInternalScanResult;
            return new RxBleInternalScanResult(rxBleInternalScanResult2.bluetoothDevice, rxBleInternalScanResult2.rssi, rxBleInternalScanResult2.timestampNanos, rxBleInternalScanResult2.scanRecord, ScanCallbackType.CALLBACK_TYPE_FIRST_MATCH, rxBleInternalScanResult2.isConnectable);
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$6, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass6 implements Function<RxBleInternalScanResult, RxBleInternalScanResult> {
        @Override // io.reactivex.functions.Function
        public final RxBleInternalScanResult apply(RxBleInternalScanResult rxBleInternalScanResult) throws Exception {
            RxBleInternalScanResult rxBleInternalScanResult2 = rxBleInternalScanResult;
            return new RxBleInternalScanResult(rxBleInternalScanResult2.bluetoothDevice, rxBleInternalScanResult2.rssi, rxBleInternalScanResult2.timestampNanos, rxBleInternalScanResult2.scanRecord, ScanCallbackType.CALLBACK_TYPE_MATCH_LOST, rxBleInternalScanResult2.isConnectable);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$5] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$7] */
    public ScanSettingsEmulator(Scheduler scheduler) {
        this.scheduler = scheduler;
        this.emulateFirstMatch = new AnonymousClass1(scheduler);
    }

    public final ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> emulateCallbackType(int r2) {
        if (r2 != 2) {
            if (r2 != 4) {
                if (r2 != 6) {
                    return ObservableUtil.IDENTITY_TRANSFORMER;
                }
                final AnonymousClass7 anonymousClass7 = this.emulateFirstMatchAndMatchLost;
                return new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.3

                    /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$3$2, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public class AnonymousClass2 implements Function<RxBleInternalScanResult, String> {
                        @Override // io.reactivex.functions.Function
                        public final String apply(RxBleInternalScanResult rxBleInternalScanResult) throws Exception {
                            return rxBleInternalScanResult.bluetoothDevice.getAddress();
                        }
                    }

                    @Override // io.reactivex.ObservableTransformer
                    public final Observable apply(Observable observable) {
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
                        observable.getClass();
                        int r1 = Flowable.BUFFER_SIZE;
                        ObjectHelper.verifyPositive(r1, "bufferSize");
                        return new ObservableGroupBy(observable, anonymousClass2, r1).flatMap(new Function<GroupedObservable<String, RxBleInternalScanResult>, Observable<RxBleInternalScanResult>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.3.1
                            @Override // io.reactivex.functions.Function
                            public final Observable<RxBleInternalScanResult> apply(GroupedObservable<String, RxBleInternalScanResult> groupedObservable) throws Exception {
                                return groupedObservable.compose(ObservableTransformer.this);
                            }
                        });
                    }
                };
            }
            final AnonymousClass5 anonymousClass5 = this.emulateMatchLost;
            return new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.3

                /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$3$2, reason: invalid class name */
                /* loaded from: classes3.dex */
                public class AnonymousClass2 implements Function<RxBleInternalScanResult, String> {
                    @Override // io.reactivex.functions.Function
                    public final String apply(RxBleInternalScanResult rxBleInternalScanResult) throws Exception {
                        return rxBleInternalScanResult.bluetoothDevice.getAddress();
                    }
                }

                @Override // io.reactivex.ObservableTransformer
                public final Observable apply(Observable observable) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2();
                    observable.getClass();
                    int r1 = Flowable.BUFFER_SIZE;
                    ObjectHelper.verifyPositive(r1, "bufferSize");
                    return new ObservableGroupBy(observable, anonymousClass2, r1).flatMap(new Function<GroupedObservable<String, RxBleInternalScanResult>, Observable<RxBleInternalScanResult>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.3.1
                        @Override // io.reactivex.functions.Function
                        public final Observable<RxBleInternalScanResult> apply(GroupedObservable<String, RxBleInternalScanResult> groupedObservable) throws Exception {
                            return groupedObservable.compose(ObservableTransformer.this);
                        }
                    });
                }
            };
        }
        final AnonymousClass1 anonymousClass1 = this.emulateFirstMatch;
        return new ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.3

            /* renamed from: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator$3$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public class AnonymousClass2 implements Function<RxBleInternalScanResult, String> {
                @Override // io.reactivex.functions.Function
                public final String apply(RxBleInternalScanResult rxBleInternalScanResult) throws Exception {
                    return rxBleInternalScanResult.bluetoothDevice.getAddress();
                }
            }

            @Override // io.reactivex.ObservableTransformer
            public final Observable apply(Observable observable) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2();
                observable.getClass();
                int r1 = Flowable.BUFFER_SIZE;
                ObjectHelper.verifyPositive(r1, "bufferSize");
                return new ObservableGroupBy(observable, anonymousClass2, r1).flatMap(new Function<GroupedObservable<String, RxBleInternalScanResult>, Observable<RxBleInternalScanResult>>() { // from class: com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator.3.1
                    @Override // io.reactivex.functions.Function
                    public final Observable<RxBleInternalScanResult> apply(GroupedObservable<String, RxBleInternalScanResult> groupedObservable) throws Exception {
                        return groupedObservable.compose(ObservableTransformer.this);
                    }
                });
            }
        };
    }
}
