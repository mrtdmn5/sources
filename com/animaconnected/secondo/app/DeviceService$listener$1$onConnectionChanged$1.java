package com.animaconnected.secondo.app;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.WatchProvider;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceService.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.DeviceService$listener$1$onConnectionChanged$1", f = "DeviceService.kt", l = {R.styleable.AppTheme_styleMarbleText}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DeviceService$listener$1$onConnectionChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeviceService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceService$listener$1$onConnectionChanged$1(DeviceService deviceService, Continuation<? super DeviceService$listener$1$onConnectionChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceService$listener$1$onConnectionChanged$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchProvider watchProvider;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getClass();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            watchProvider = this.this$0.getWatchProvider();
            this.label = 1;
            if (watchProvider.m1052resetDeviceIoAF18A(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceService$listener$1$onConnectionChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
