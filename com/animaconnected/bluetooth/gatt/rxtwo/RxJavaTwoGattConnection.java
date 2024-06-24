package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.animaconnected.bluetooth.gatt.GattId;
import com.animaconnected.logger.LogKt;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: RxJavaTwoGattConnection.kt */
/* loaded from: classes.dex */
public final class RxJavaTwoGattConnection implements CoroutineScope {
    public static final Companion Companion = new Companion(null);
    private static final long discoverServiceDelay = 1600;
    private RxBleConnection connection;
    private Disposable connectionDisposable;
    private Function1<? super Throwable, Unit> disconnectCallback;
    private final ExecutorCoroutineDispatcher ioDispatcher;
    private final CompletableJob job;
    private Map<UUID, Disposable> notificationDisposables;
    private final RxBleDevice rxBleDevice;
    private final String tag;
    private Job timeoutConnectionJob;

    /* compiled from: RxJavaTwoGattConnection.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RxJavaTwoGattConnection(RxBleDevice rxBleDevice) {
        Intrinsics.checkNotNullParameter(rxBleDevice, "rxBleDevice");
        this.rxBleDevice = rxBleDevice;
        this.tag = "RxJavaTwoGattConnection";
        this.disconnectCallback = new Function1<Throwable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$disconnectCallback$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        };
        this.notificationDisposables = new LinkedHashMap();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.ioDispatcher = new ExecutorCoroutineDispatcherImpl(newSingleThreadExecutor);
        this.job = SupervisorKt.SupervisorJob$default();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clean() {
        Job job = this.timeoutConnectionJob;
        if (job != null) {
            job.cancel(null);
        }
        Disposable disposable = this.connectionDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.connectionDisposable = null;
        Iterator<T> it = this.notificationDisposables.values().iterator();
        while (it.hasNext()) {
            ((Disposable) it.next()).dispose();
        }
        this.notificationDisposables = new LinkedHashMap();
        this.connection = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connect$lambda$0(RxJavaTwoGattConnection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LogKt.debug$default((Object) this$0, "Connection fully closed!", this$0.tag, (Throwable) null, true, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connect$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connect$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource setNotification$lambda$4(Function1 tmp0, Object p0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (ObservableSource) tmp0.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNotification$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNotification$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void connect(boolean z, final Function1<? super RxJavaTwoGattConnection, Unit> connectCallback, final Function1<? super Throwable, Unit> disconnectCallback) {
        Intrinsics.checkNotNullParameter(connectCallback, "connectCallback");
        Intrinsics.checkNotNullParameter(disconnectCallback, "disconnectCallback");
        this.timeoutConnectionJob = BuildersKt.launch$default(this, null, null, new RxJavaTwoGattConnection$connect$1(this, disconnectCallback, null), 3);
        this.disconnectCallback = disconnectCallback;
        ObservableDefer establishConnection = this.rxBleDevice.establishConnection(z);
        Action action = new Action() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                RxJavaTwoGattConnection.connect$lambda$0(RxJavaTwoGattConnection.this);
            }
        };
        establishConnection.getClass();
        ObservableObserveOn observeOn = new ObservableDoFinally(establishConnection, action).observeOn(AndroidSchedulers.mainThread());
        final Function1<RxBleConnection, Unit> function1 = new Function1<RxBleConnection, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$connect$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RxBleConnection rxBleConnection) {
                invoke2(rxBleConnection);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RxBleConnection rxBleConnection) {
                Job job;
                RxJavaTwoGattConnection.this.connection = rxBleConnection;
                job = RxJavaTwoGattConnection.this.timeoutConnectionJob;
                if (job != null) {
                    job.cancel(null);
                }
                connectCallback.invoke(RxJavaTwoGattConnection.this);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxJavaTwoGattConnection.connect$lambda$1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$connect$4
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
            public final void invoke2(Throwable th) {
                RxJavaTwoGattConnection.this.clean();
                Function1<Throwable, Unit> function13 = disconnectCallback;
                Intrinsics.checkNotNull(th);
                function13.invoke(th);
            }
        };
        this.connectionDisposable = observeOn.subscribe(consumer, new Consumer() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxJavaTwoGattConnection.connect$lambda$2(Function1.this, obj);
            }
        });
    }

    public final void disconnect() {
        this.disconnectCallback.invoke(new RuntimeException("Disconnect() executed"));
        this.disconnectCallback = new Function1<Throwable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$disconnect$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        };
        clean();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object discoverServices(kotlin.coroutines.Continuation<? super java.util.List<? extends android.bluetooth.BluetoothGattService>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$1 r0 = (com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$1 r0 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.ExecutorCoroutineDispatcher r6 = r5.ioDispatcher
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$2 r2 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$2
            r4 = 0
            r2.<init>(r5, r4)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            java.lang.String r0 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection.discoverServices(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return MainDispatcherLoader.dispatcher.plus(this.job);
    }

    public final String getTag() {
        return this.tag;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object read(android.bluetooth.BluetoothGattCharacteristic r6, kotlin.coroutines.Continuation<? super byte[]> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$read$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$read$1 r0 = (com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$read$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$read$1 r0 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$read$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r7)
            goto L43
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.ExecutorCoroutineDispatcher r7 = r5.ioDispatcher
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$read$2 r2 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$read$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            java.lang.String r6 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection.read(android.bluetooth.BluetoothGattCharacteristic, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object refreshServices(Continuation<Object> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new RxJavaTwoGattConnection$refreshServices$2(this, null), continuation);
    }

    public final Object setNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, final Function1<? super byte[], Unit> function1, Continuation<? super Boolean> continuation) {
        RxBleConnection rxBleConnection = this.connection;
        if (rxBleConnection == null) {
            return Boolean.FALSE;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(GattId.Descriptor.CLIENT_CHARACTERISTIC_CONFIGURATION);
        if (descriptor == null) {
            return Boolean.FALSE;
        }
        if (!this.notificationDisposables.containsKey(bluetoothGattCharacteristic.getUuid())) {
            Observable<Observable<byte[]>> observable = rxBleConnection.setupNotification(bluetoothGattCharacteristic);
            final RxJavaTwoGattConnection$setNotification$disposable$1 rxJavaTwoGattConnection$setNotification$disposable$1 = new Function1<Observable<byte[]>, ObservableSource<? extends byte[]>>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$setNotification$disposable$1
                @Override // kotlin.jvm.functions.Function1
                public final ObservableSource<? extends byte[]> invoke(Observable<byte[]> t) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    return t;
                }
            };
            ObservableObserveOn observeOn = observable.flatMap(new Function() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource notification$lambda$4;
                    notification$lambda$4 = RxJavaTwoGattConnection.setNotification$lambda$4(Function1.this, obj);
                    return notification$lambda$4;
                }
            }).observeOn(AndroidSchedulers.mainThread());
            final Function1<byte[], Unit> function12 = new Function1<byte[], Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$setNotification$disposable$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr2) {
                    invoke2(bArr2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(byte[] bArr2) {
                    Function1<byte[], Unit> function13 = function1;
                    Intrinsics.checkNotNull(bArr2);
                    function13.invoke(bArr2);
                }
            };
            Consumer consumer = new Consumer() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RxJavaTwoGattConnection.setNotification$lambda$5(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$setNotification$disposable$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    LogKt.debug((Object) RxJavaTwoGattConnection.this, "Notification closed", RxJavaTwoGattConnection.this.getTag(), th, true);
                }
            };
            LambdaObserver subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RxJavaTwoGattConnection.setNotification$lambda$6(Function1.this, obj);
                }
            });
            Map<UUID, Disposable> map = this.notificationDisposables;
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
            map.put(uuid, subscribe);
        }
        return BuildersKt.withContext(this.ioDispatcher, new RxJavaTwoGattConnection$setNotification$2(rxBleConnection, descriptor, bArr, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object write(android.bluetooth.BluetoothGattCharacteristic r6, byte[] r7, kotlin.coroutines.Continuation<? super byte[]> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$write$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$write$1 r0 = (com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$write$1 r0 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$write$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r8)
            goto L43
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.ExecutorCoroutineDispatcher r8 = r5.ioDispatcher
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$write$2 r2 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$write$2
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            java.lang.String r6 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection.write(android.bluetooth.BluetoothGattCharacteristic, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeRead(android.bluetooth.BluetoothGattCharacteristic r6, byte[] r7, kotlin.coroutines.Continuation<? super byte[]> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$writeRead$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$writeRead$1 r0 = (com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$writeRead$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$writeRead$1 r0 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$writeRead$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r8)
            goto L43
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.ExecutorCoroutineDispatcher r8 = r5.ioDispatcher
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$writeRead$2 r2 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$writeRead$2
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            java.lang.String r6 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection.writeRead(android.bluetooth.BluetoothGattCharacteristic, byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }
}
