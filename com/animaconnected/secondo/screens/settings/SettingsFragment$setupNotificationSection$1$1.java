package com.animaconnected.secondo.screens.settings;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.SettingsFragment$setupNotificationSection$1$1", f = "SettingsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SettingsFragment$setupNotificationSection$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsFragment$setupNotificationSection$1$1(SettingsFragment settingsFragment, Continuation<? super SettingsFragment$setupNotificationSection$1$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsFragment$setupNotificationSection$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((SettingsFragment$setupNotificationSection$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SettingsPresenter settingsPresenter;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            settingsPresenter = this.this$0.settingsPresenter;
            if (settingsPresenter != null) {
                settingsPresenter.onNotificationsCallsClicked();
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
