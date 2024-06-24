package com.animaconnected.bluetooth.gatt.rxtwo;

import com.animaconnected.bluetooth.device.ClientProvider;
import com.animaconnected.logger.LogKt;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RxJavaTwoGattDevice.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$2", f = "RxJavaTwoGattDevice.kt", l = {489}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice$scan$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $address;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RxJavaTwoGattDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattDevice$scan$2(RxJavaTwoGattDevice rxJavaTwoGattDevice, String str, Continuation<? super RxJavaTwoGattDevice$scan$2> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattDevice;
        this.$address = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxJavaTwoGattDevice$scan$2 rxJavaTwoGattDevice$scan$2 = new RxJavaTwoGattDevice$scan$2(this.this$0, this.$address, continuation);
        rxJavaTwoGattDevice$scan$2.L$0 = obj;
        return rxJavaTwoGattDevice$scan$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r2 = this.label;
        if (r2 != 0) {
            if (r2 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        final RxJavaTwoGattDevice rxJavaTwoGattDevice = this.this$0;
        final String str = this.$address;
        this.L$0 = coroutineScope;
        this.L$1 = rxJavaTwoGattDevice;
        this.L$2 = str;
        this.label = 1;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
        cancellableContinuationImpl.initCancellability();
        ObservableObserveOn observeOn = ClientProvider.getClient(rxJavaTwoGattDevice.getContext()).scanBleDevices(new ScanSettings(2, 1, 0L, 1, 3, true), new ScanFilter(null, null, null, null, null, null, null, null, null, -1, null, null)).observeOn(AndroidSchedulers.mainThread());
        final Function1<ScanResult, Unit> function1 = new Function1<ScanResult, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$2$1$disposable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScanResult scanResult) {
                if (Intrinsics.areEqual(scanResult.bleDevice.getMacAddress(), str) && cancellableContinuationImpl.isActive()) {
                    cancellableContinuationImpl.resumeWith(null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScanResult scanResult) {
                invoke2(scanResult);
                return Unit.INSTANCE;
            }
        };
        Consumer consumer = new Consumer(function1) { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$sam$io_reactivex_functions_Consumer$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj2) {
                this.function.invoke(obj2);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$2$1$disposable$2
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
                LogKt.debug((Object) CoroutineScope.this, "Scan failed", rxJavaTwoGattDevice.getTAG(), th, true);
                if (cancellableContinuationImpl.isActive()) {
                    cancellableContinuationImpl.resumeWith(null);
                }
            }
        };
        final LambdaObserver subscribe = observeOn.subscribe(consumer, new Consumer(function12) { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$sam$io_reactivex_functions_Consumer$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function12, "function");
                this.function = function12;
            }

            @Override // io.reactivex.functions.Consumer
            public final /* synthetic */ void accept(Object obj2) {
                this.function.invoke(obj2);
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$scan$2$1$1
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
                Disposable disposable = Disposable.this;
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == coroutineSingletons) {
            return coroutineSingletons;
        }
        return result;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxJavaTwoGattDevice$scan$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
