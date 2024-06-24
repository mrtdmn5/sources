package com.animaconnected.bluetooth.gatt.rxtwo;

import com.polidea.rxandroidble2.RxBleConnection;
import io.reactivex.Observable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RxJavaTwoGattConnection.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$refreshServices$2", f = "RxJavaTwoGattConnection.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattConnection$refreshServices$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    int label;
    final /* synthetic */ RxJavaTwoGattConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattConnection$refreshServices$2(RxJavaTwoGattConnection rxJavaTwoGattConnection, Continuation<? super RxJavaTwoGattConnection$refreshServices$2> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattConnection$refreshServices$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RxBleConnection rxBleConnection;
        Observable queue;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            rxBleConnection = this.this$0.connection;
            if (rxBleConnection != null && (queue = rxBleConnection.queue(new GattRefresh())) != null) {
                BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
                queue.subscribe(blockingFirstObserver);
                if (blockingFirstObserver.getCount() != 0) {
                    try {
                        blockingFirstObserver.await();
                    } catch (InterruptedException e) {
                        blockingFirstObserver.dispose();
                        throw ExceptionHelper.wrapOrThrow(e);
                    }
                }
                Throwable th = blockingFirstObserver.error;
                if (th == null) {
                    Object obj2 = blockingFirstObserver.value;
                    if (obj2 == null) {
                        throw new NoSuchElementException();
                    }
                    return obj2;
                }
                throw ExceptionHelper.wrapOrThrow(th);
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((RxJavaTwoGattConnection$refreshServices$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
