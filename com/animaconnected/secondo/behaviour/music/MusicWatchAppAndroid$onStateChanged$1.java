package com.animaconnected.secondo.behaviour.music;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.device.PhoneNotification;
import com.animaconnected.watch.device.WatchNotificationKt;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.VisibilityState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MusicWatchAppAndroid.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$onStateChanged$1", f = "MusicWatchAppAndroid.kt", l = {36, 37}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MusicWatchAppAndroid$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MusicWatchAppAndroid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicWatchAppAndroid$onStateChanged$1(MusicWatchAppAndroid musicWatchAppAndroid, Continuation<? super MusicWatchAppAndroid$onStateChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = musicWatchAppAndroid;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicWatchAppAndroid$onStateChanged$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DisplayWatch displayWatch;
        DisplayWatch displayWatch2;
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
            displayWatch = this.this$0.watch;
            if (displayWatch != null) {
                PhoneNotification permissionNotification = WatchNotificationKt.permissionNotification(this.this$0.getIcon());
                this.label = 1;
                if (WatchNotificationKt.sendNotification(displayWatch, permissionNotification, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        displayWatch2 = this.this$0.watch;
        if (displayWatch2 != null) {
            AppId id = this.this$0.getId();
            VisibilityState visibilityState = VisibilityState.Stopped;
            this.label = 2;
            if (displayWatch2.requestAppState(id, visibilityState, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MusicWatchAppAndroid$onStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
