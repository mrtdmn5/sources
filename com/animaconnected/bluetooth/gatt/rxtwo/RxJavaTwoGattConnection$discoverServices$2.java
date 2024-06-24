package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothGattService;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RxJavaTwoGattConnection.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$2", f = "RxJavaTwoGattConnection.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattConnection$discoverServices$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<BluetoothGattService>>, Object> {
    int label;
    final /* synthetic */ RxJavaTwoGattConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattConnection$discoverServices$2(RxJavaTwoGattConnection rxJavaTwoGattConnection, Continuation<? super RxJavaTwoGattConnection$discoverServices$2> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$0(Function1 function1, Object obj) {
        return (List) function1.invoke(obj);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattConnection$discoverServices$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RxBleConnection rxBleConnection;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            rxBleConnection = this.this$0.connection;
            if (rxBleConnection == null) {
                return new ArrayList();
            }
            Single<RxBleDeviceServices> discoverServices = rxBleConnection.discoverServices();
            final AnonymousClass1 anonymousClass1 = new Function1<RxBleDeviceServices, List<BluetoothGattService>>() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$2.1
                @Override // kotlin.jvm.functions.Function1
                public final List<BluetoothGattService> invoke(RxBleDeviceServices services) {
                    Intrinsics.checkNotNullParameter(services, "services");
                    return services.bluetoothGattServices;
                }
            };
            Function function = new Function() { // from class: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$discoverServices$2$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj2) {
                    List invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = RxJavaTwoGattConnection$discoverServices$2.invokeSuspend$lambda$0(Function1.this, obj2);
                    return invokeSuspend$lambda$0;
                }
            };
            discoverServices.getClass();
            return new SingleDelayWithObservable(new SingleMap(discoverServices, function), Observable.timer(1600L, TimeUnit.MILLISECONDS, Schedulers.COMPUTATION)).blockingGet();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<BluetoothGattService>> continuation) {
        return ((RxJavaTwoGattConnection$discoverServices$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
