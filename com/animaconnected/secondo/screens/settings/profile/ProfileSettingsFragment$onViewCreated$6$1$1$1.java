package com.animaconnected.secondo.screens.settings.profile;

import android.view.View;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.utils.Loading;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ProfileSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$onViewCreated$6$1$1$1", f = "ProfileSettingsFragment.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileSettingsFragment$onViewCreated$6$1$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDialog $dialog;
    final /* synthetic */ Loading $loading;
    final /* synthetic */ LoginViewModel $loginViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSettingsFragment$onViewCreated$6$1$1$1(Loading loading, LoginViewModel loginViewModel, BottomDialog bottomDialog, Continuation<? super ProfileSettingsFragment$onViewCreated$6$1$1$1> continuation) {
        super(2, continuation);
        this.$loading = loading;
        this.$loginViewModel = loginViewModel;
        this.$dialog = bottomDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileSettingsFragment$onViewCreated$6$1$1$1(this.$loading, this.$loginViewModel, this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((ProfileSettingsFragment$onViewCreated$6$1$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
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
            this.$loading.invalidate(true);
            LoginViewModel loginViewModel = this.$loginViewModel;
            this.label = 1;
            if (loginViewModel.deleteAccount(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.$loading.invalidate(false);
        this.$dialog.dismiss();
        return Unit.INSTANCE;
    }
}
