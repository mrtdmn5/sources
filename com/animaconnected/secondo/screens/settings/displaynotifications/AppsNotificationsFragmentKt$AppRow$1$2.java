package com.animaconnected.secondo.screens.settings.displaynotifications;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* compiled from: AppsNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppRow$1$2", f = "AppsNotificationsFragment.kt", l = {385}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AppsNotificationsFragmentKt$AppRow$1$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppState $app;
    final /* synthetic */ Function4<String, String, Boolean, Continuation<? super Unit>, Object> $onCheckedChange;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppsNotificationsFragmentKt$AppRow$1$2(Function4<? super String, ? super String, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function4, AppState appState, Continuation<? super AppsNotificationsFragmentKt$AppRow$1$2> continuation) {
        super(2, continuation);
        this.$onCheckedChange = function4;
        this.$app = appState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppsNotificationsFragmentKt$AppRow$1$2 appsNotificationsFragmentKt$AppRow$1$2 = new AppsNotificationsFragmentKt$AppRow$1$2(this.$onCheckedChange, this.$app, continuation);
        appsNotificationsFragmentKt$AppRow$1$2.Z$0 = ((Boolean) obj).booleanValue();
        return appsNotificationsFragmentKt$AppRow$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
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
            boolean z = this.Z$0;
            Function4<String, String, Boolean, Continuation<? super Unit>, Object> function4 = this.$onCheckedChange;
            String packageName = this.$app.getPackageName();
            String name = this.$app.getName();
            Boolean valueOf = Boolean.valueOf(z);
            this.label = 1;
            if (function4.invoke(packageName, name, valueOf, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((AppsNotificationsFragmentKt$AppRow$1$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
