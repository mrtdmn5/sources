package com.animaconnected.secondo.screens.settings.displaynotifications;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AppsNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AllAppsRow$1$1", f = "AppsNotificationsFragment.kt", l = {345}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AppsNotificationsFragmentKt$AllAppsRow$1$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, Continuation<? super Unit>, Object> $onCheckedChange;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppsNotificationsFragmentKt$AllAppsRow$1$1(Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AppsNotificationsFragmentKt$AllAppsRow$1$1> continuation) {
        super(2, continuation);
        this.$onCheckedChange = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppsNotificationsFragmentKt$AllAppsRow$1$1 appsNotificationsFragmentKt$AllAppsRow$1$1 = new AppsNotificationsFragmentKt$AllAppsRow$1$1(this.$onCheckedChange, continuation);
        appsNotificationsFragmentKt$AllAppsRow$1$1.Z$0 = ((Boolean) obj).booleanValue();
        return appsNotificationsFragmentKt$AllAppsRow$1$1;
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
            Function2<Boolean, Continuation<? super Unit>, Object> function2 = this.$onCheckedChange;
            Boolean valueOf = Boolean.valueOf(z);
            this.label = 1;
            if (function2.invoke(valueOf, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((AppsNotificationsFragmentKt$AllAppsRow$1$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
