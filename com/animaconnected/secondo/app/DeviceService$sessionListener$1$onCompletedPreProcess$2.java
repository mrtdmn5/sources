package com.animaconnected.secondo.app;

import com.animaconnected.watch.account.strava.StravaClient;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceService.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.DeviceService$sessionListener$1$onCompletedPreProcess$2", f = "DeviceService.kt", l = {194}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DeviceService$sessionListener$1$onCompletedPreProcess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WatchLibResult<? extends Boolean, ? extends WatchLibException>>, Object> {
    final /* synthetic */ Session $session;
    int label;
    final /* synthetic */ DeviceService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceService$sessionListener$1$onCompletedPreProcess$2(DeviceService deviceService, Session session, Continuation<? super DeviceService$sessionListener$1$onCompletedPreProcess$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceService;
        this.$session = session;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceService$sessionListener$1$onCompletedPreProcess$2(this.this$0, this.$session, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super WatchLibResult<? extends Boolean, ? extends WatchLibException>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super WatchLibResult<Boolean, WatchLibException>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StravaClient stravaClient;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            stravaClient = this.this$0.getStravaClient();
            Session session = this.$session;
            this.label = 1;
            obj = stravaClient.uploadSession(session, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super WatchLibResult<Boolean, WatchLibException>> continuation) {
        return ((DeviceService$sessionListener$1$onCompletedPreProcess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
