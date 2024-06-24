package com.animaconnected.watch.device;

import com.animaconnected.msgpack.MsgPack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceEventHandler.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.DeviceEventHandler$handleEvent$2", f = "DeviceEventHandler.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DeviceEventHandler$handleEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MsgPack $value;
    int label;
    final /* synthetic */ DeviceEventHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceEventHandler$handleEvent$2(MsgPack msgPack, DeviceEventHandler deviceEventHandler, Continuation<? super DeviceEventHandler$handleEvent$2> continuation) {
        super(2, continuation);
        this.$value = msgPack;
        this.this$0 = deviceEventHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceEventHandler$handleEvent$2(this.$value, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FullWatchEventListener fullWatchEventListener;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int asInt = this.$value.asList().get(1).asInt();
            fullWatchEventListener = this.this$0.listener;
            fullWatchEventListener.onDeviceCrash(asInt);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceEventHandler$handleEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
