package com.animaconnected.secondo.screens.settings.profile;

import com.animaconnected.secondo.R;
import com.animaconnected.secondo.provider.login.LoginState;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.watch.CommonFlow;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ProfileSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$onViewCreated$9", f = "ProfileSettingsFragment.kt", l = {R.styleable.AppTheme_tabTextSelectedColor}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileSettingsFragment$onViewCreated$9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoginViewModel $loginViewModel;
    int label;
    final /* synthetic */ ProfileSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSettingsFragment$onViewCreated$9(LoginViewModel loginViewModel, ProfileSettingsFragment profileSettingsFragment, Continuation<? super ProfileSettingsFragment$onViewCreated$9> continuation) {
        super(2, continuation);
        this.$loginViewModel = loginViewModel;
        this.this$0 = profileSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileSettingsFragment$onViewCreated$9(this.$loginViewModel, this.this$0, continuation);
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
            CommonFlow<LoginState> loginState = this.$loginViewModel.getLoginState();
            final ProfileSettingsFragment profileSettingsFragment = this.this$0;
            FlowCollector<? super LoginState> flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$onViewCreated$9.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((LoginState) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(LoginState loginState2, Continuation<? super Unit> continuation) {
                    if (Intrinsics.areEqual(loginState2, LoginState.Idle.INSTANCE)) {
                        ProfileSettingsFragment.this.getMainController().goBack();
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (loginState.collect(flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileSettingsFragment$onViewCreated$9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
