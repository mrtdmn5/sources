package com.animaconnected.secondo.notification.handler;

import android.service.notification.StatusBarNotification;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.DisplayWatchJvm;
import com.animaconnected.watch.Watch;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DisplayNotificationHandler.kt */
@DebugMetadata(c = "com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$handleRemoval$3", f = "DisplayNotificationHandler.kt", l = {170}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DisplayNotificationHandler$handleRemoval$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StatusBarNotification $sbn;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DisplayNotificationHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayNotificationHandler$handleRemoval$3(DisplayNotificationHandler displayNotificationHandler, StatusBarNotification statusBarNotification, Continuation<? super DisplayNotificationHandler$handleRemoval$3> continuation) {
        super(2, continuation);
        this.this$0 = displayNotificationHandler;
        this.$sbn = statusBarNotification;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DisplayNotificationHandler$handleRemoval$3 displayNotificationHandler$handleRemoval$3 = new DisplayNotificationHandler$handleRemoval$3(this.this$0, this.$sbn, continuation);
        displayNotificationHandler$handleRemoval$3.L$0 = obj;
        return displayNotificationHandler$handleRemoval$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        String str;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception unused) {
                    coroutineScope = coroutineScope2;
                    LogKt.verbose$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$handleRemoval$3.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to remove notification";
                        }
                    }, 7, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            Watch watch = ProviderFactory.getWatch().getWatch();
            if (watch instanceof DisplayWatch) {
                try {
                    str = this.this$0.tag;
                    final StatusBarNotification statusBarNotification = this.$sbn;
                    LogKt.debug$default((Object) coroutineScope3, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$handleRemoval$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "handleRemoval: removing " + statusBarNotification.getKey().hashCode();
                        }
                    }, 6, (Object) null);
                    int hashCode = this.$sbn.getKey().hashCode();
                    this.L$0 = coroutineScope3;
                    this.label = 1;
                    if (DisplayWatchJvm.removeNotification((DisplayWatch) watch, hashCode, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (Exception unused2) {
                    coroutineScope = coroutineScope3;
                    LogKt.verbose$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.handler.DisplayNotificationHandler$handleRemoval$3.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to remove notification";
                        }
                    }, 7, (Object) null);
                    return Unit.INSTANCE;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DisplayNotificationHandler$handleRemoval$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
