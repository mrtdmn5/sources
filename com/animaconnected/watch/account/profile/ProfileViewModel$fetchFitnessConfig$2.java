package com.animaconnected.watch.account.profile;

import com.animaconnected.watch.account.profile.ProfileState;
import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: ProfileViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.profile.ProfileViewModel$fetchFitnessConfig$2", f = "ProfileViewModel.kt", l = {26}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileViewModel$fetchFitnessConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileViewModel$fetchFitnessConfig$2(ProfileViewModel profileViewModel, Continuation<? super ProfileViewModel$fetchFitnessConfig$2> continuation) {
        super(2, continuation);
        this.this$0 = profileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileViewModel$fetchFitnessConfig$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        FitnessProvider.Profile profile;
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
            mutableStateFlow = this.this$0.profileState;
            mutableStateFlow.setValue(ProfileState.Loading.INSTANCE);
            profile = this.this$0.provider;
            this.label = 1;
            if (profile.fetchAndUpdateConfig(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.this$0.refresh();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$fetchFitnessConfig$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
