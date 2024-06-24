package com.animaconnected.watch.device;

import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.watch.fitness.HeartrateValue;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceEventHandler.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.DeviceEventHandler$handleEvent$6", f = "DeviceEventHandler.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DeviceEventHandler$handleEvent$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MsgPack $value;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceEventHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceEventHandler$handleEvent$6(MsgPack msgPack, DeviceEventHandler deviceEventHandler, Continuation<? super DeviceEventHandler$handleEvent$6> continuation) {
        super(2, continuation);
        this.$value = msgPack;
        this.this$0 = deviceEventHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceEventHandler$handleEvent$6 deviceEventHandler$handleEvent$6 = new DeviceEventHandler$handleEvent$6(this.$value, this.this$0, continuation);
        deviceEventHandler$handleEvent$6.L$0 = obj;
        return deviceEventHandler$handleEvent$6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        FullWatchEventListener fullWatchEventListener;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                List<MsgPack> asList = this.$value.asList();
                int asInt = asList.get(0).asInt();
                int asInt2 = asList.get(1).asInt();
                fullWatchEventListener = this.this$0.listener;
                fullWatchEventListener.onHeartrateLiveData(new HeartrateValue(asInt, asInt2));
            } catch (Exception unused) {
                str = this.this$0.tag;
                LogKt.verbose$default((Object) coroutineScope, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$6.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to handle fitness result live";
                    }
                }, 6, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceEventHandler$handleEvent$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
