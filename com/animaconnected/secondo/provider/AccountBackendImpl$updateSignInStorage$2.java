package com.animaconnected.secondo.provider;

import com.animaconnected.secondo.provider.login.LoginState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AccountBackendImpl.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.AccountBackendImpl$updateSignInStorage$2", f = "AccountBackendImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountBackendImpl$updateSignInStorage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $signedIn;
    final /* synthetic */ SigninStorage $storage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountBackendImpl$updateSignInStorage$2(SigninStorage signinStorage, boolean z, Continuation<? super AccountBackendImpl$updateSignInStorage$2> continuation) {
        super(2, continuation);
        this.$storage = signinStorage;
        this.$signedIn = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountBackendImpl$updateSignInStorage$2(this.$storage, this.$signedIn, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$storage.setSignedIn(this.$signedIn);
            if (this.$signedIn) {
                this.$storage.setState(LoginState.SignedIn.INSTANCE);
            } else {
                this.$storage.setState(LoginState.Idle.INSTANCE);
                SigninStorage.Companion.setPwStoredInMemory("");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountBackendImpl$updateSignInStorage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
