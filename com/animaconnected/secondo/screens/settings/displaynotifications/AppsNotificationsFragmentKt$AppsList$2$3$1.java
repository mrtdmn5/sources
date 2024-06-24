package com.animaconnected.secondo.screens.settings.displaynotifications;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* compiled from: AppsNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$3$1", f = "AppsNotificationsFragment.kt", l = {286}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AppsNotificationsFragmentKt$AppsList$2$3$1 extends SuspendLambda implements Function4<String, String, Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<String, String, Boolean, Continuation<? super Unit>, Object> $onAppToggle;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppsNotificationsFragmentKt$AppsList$2$3$1(Function4<? super String, ? super String, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super AppsNotificationsFragmentKt$AppsList$2$3$1> continuation) {
        super(4, continuation);
        this.$onAppToggle = function4;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(String str, String str2, Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(str, str2, bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            String str = (String) this.L$0;
            String str2 = (String) this.L$1;
            boolean z = this.Z$0;
            Function4<String, String, Boolean, Continuation<? super Unit>, Object> function4 = this.$onAppToggle;
            Boolean valueOf = Boolean.valueOf(z);
            this.L$0 = null;
            this.label = 1;
            if (function4.invoke(str, str2, valueOf, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(String str, String str2, boolean z, Continuation<? super Unit> continuation) {
        AppsNotificationsFragmentKt$AppsList$2$3$1 appsNotificationsFragmentKt$AppsList$2$3$1 = new AppsNotificationsFragmentKt$AppsList$2$3$1(this.$onAppToggle, continuation);
        appsNotificationsFragmentKt$AppsList$2$3$1.L$0 = str;
        appsNotificationsFragmentKt$AppsList$2$3$1.L$1 = str2;
        appsNotificationsFragmentKt$AppsList$2$3$1.Z$0 = z;
        return appsNotificationsFragmentKt$AppsList$2$3$1.invokeSuspend(Unit.INSTANCE);
    }
}
