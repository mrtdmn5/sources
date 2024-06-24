package com.animaconnected.secondo.screens.settings.profile;

import com.animaconnected.watch.account.profile.ProfileState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ProfileFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileFragment$onViewCreated$6", f = "ProfileFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileFragment$onViewCreated$6 extends SuspendLambda implements Function2<ProfileState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProfileFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileFragment$onViewCreated$6(ProfileFragment profileFragment, Continuation<? super ProfileFragment$onViewCreated$6> continuation) {
        super(2, continuation);
        this.this$0 = profileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileFragment$onViewCreated$6 profileFragment$onViewCreated$6 = new ProfileFragment$onViewCreated$6(this.this$0, continuation);
        profileFragment$onViewCreated$6.L$0 = obj;
        return profileFragment$onViewCreated$6;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProfileState profileState, Continuation<? super Unit> continuation) {
        return ((ProfileFragment$onViewCreated$6) create(profileState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.invalidateProfile((ProfileState) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
