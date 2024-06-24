package com.animaconnected.secondo.screens.settings.profile;

import com.animaconnected.secondo.provider.login.LoginState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileFragment$onViewCreated$5", f = "ProfileFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileFragment$onViewCreated$5 extends SuspendLambda implements Function2<LoginState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProfileFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileFragment$onViewCreated$5(ProfileFragment profileFragment, Continuation<? super ProfileFragment$onViewCreated$5> continuation) {
        super(2, continuation);
        this.this$0 = profileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileFragment$onViewCreated$5 profileFragment$onViewCreated$5 = new ProfileFragment$onViewCreated$5(this.this$0, continuation);
        profileFragment$onViewCreated$5.L$0 = obj;
        return profileFragment$onViewCreated$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LoginState loginState, Continuation<? super Unit> continuation) {
        return ((ProfileFragment$onViewCreated$5) create(loginState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.invalidateLogin(Intrinsics.areEqual((LoginState) this.L$0, LoginState.SignedIn.INSTANCE));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
