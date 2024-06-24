package com.animaconnected.watch.device;

import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPack;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceEventHandler.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.DeviceEventHandler$handleEvent$5", f = "DeviceEventHandler.kt", l = {122}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DeviceEventHandler$handleEvent$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MsgPack $value;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceEventHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceEventHandler$handleEvent$5(DeviceEventHandler deviceEventHandler, MsgPack msgPack, Continuation<? super DeviceEventHandler$handleEvent$5> continuation) {
        super(2, continuation);
        this.this$0 = deviceEventHandler;
        this.$value = msgPack;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceEventHandler$handleEvent$5 deviceEventHandler$handleEvent$5 = new DeviceEventHandler$handleEvent$5(this.this$0, this.$value, continuation);
        deviceEventHandler$handleEvent$5.L$0 = obj;
        return deviceEventHandler$handleEvent$5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception exc;
        WatchIO io2;
        CoroutineScope coroutineScope2;
        String str;
        FullWatchEventListener fullWatchEventListener;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    exc = e;
                    coroutineScope = coroutineScope2;
                    str = this.this$0.tag;
                    LogKt.debug$default((Object) coroutineScope, str, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$5.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to handle `diag_event`";
                        }
                    }, 4, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            try {
                io2 = this.this$0.getIo();
                Intrinsics.checkNotNull(io2);
                MsgPack msgPack = this.$value;
                this.L$0 = coroutineScope3;
                this.label = 1;
                Object prepareDiagnosticsMap = io2.prepareDiagnosticsMap(msgPack, this);
                if (prepareDiagnosticsMap == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope2 = coroutineScope3;
                obj = prepareDiagnosticsMap;
            } catch (Exception e2) {
                coroutineScope = coroutineScope3;
                exc = e2;
                str = this.this$0.tag;
                LogKt.debug$default((Object) coroutineScope, str, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceEventHandler$handleEvent$5.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to handle `diag_event`";
                    }
                }, 4, (Object) null);
                return Unit.INSTANCE;
            }
        }
        fullWatchEventListener = this.this$0.listener;
        fullWatchEventListener.onDiagEvent((Map) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceEventHandler$handleEvent$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
