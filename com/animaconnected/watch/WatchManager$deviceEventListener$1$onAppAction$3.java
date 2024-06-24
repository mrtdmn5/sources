package com.animaconnected.watch;

import com.animaconnected.watch.device.PhoneNotification;
import com.animaconnected.watch.device.WatchNotificationKt;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.VisibilityState;
import com.animaconnected.watch.display.WatchApp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager$deviceEventListener$1$onAppAction$3", f = "WatchManager.kt", l = {259, 260}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchManager$deviceEventListener$1$onAppAction$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WatchApp $app;
    final /* synthetic */ DisplayWatch $displayWatch;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$deviceEventListener$1$onAppAction$3(DisplayWatch displayWatch, WatchApp watchApp, Continuation<? super WatchManager$deviceEventListener$1$onAppAction$3> continuation) {
        super(2, continuation);
        this.$displayWatch = displayWatch;
        this.$app = watchApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchManager$deviceEventListener$1$onAppAction$3(this.$displayWatch, this.$app, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            DisplayWatch displayWatch = this.$displayWatch;
            PhoneNotification permissionNotification = WatchNotificationKt.permissionNotification(this.$app.getIcon());
            this.label = 1;
            if (WatchNotificationKt.sendNotification(displayWatch, permissionNotification, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        DisplayWatch displayWatch2 = this.$displayWatch;
        AppId id = this.$app.getId();
        VisibilityState visibilityState = VisibilityState.Stopped;
        this.label = 2;
        if (displayWatch2.requestAppState(id, visibilityState, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchManager$deviceEventListener$1$onAppAction$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
