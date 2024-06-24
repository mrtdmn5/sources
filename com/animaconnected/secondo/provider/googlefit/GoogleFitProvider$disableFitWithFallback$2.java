package com.animaconnected.secondo.provider.googlefit;

import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.animaconnected.future.FutureCoroutineKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.R;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GoogleFitProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableFitWithFallback$2", f = "GoogleFitProvider.kt", l = {R.styleable.AppTheme_stepsHistoryBackgroundDetail, R.styleable.AppTheme_stepsHistoryGoalLineColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitProvider$disableFitWithFallback$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GoogleFitProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitProvider$disableFitWithFallback$2(GoogleFitProvider googleFitProvider, Continuation<? super GoogleFitProvider$disableFitWithFallback$2> continuation) {
        super(2, continuation);
        this.this$0 = googleFitProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleFitProvider$disableFitWithFallback$2 googleFitProvider$disableFitWithFallback$2 = new GoogleFitProvider$disableFitWithFallback$2(this.this$0, continuation);
        googleFitProvider$disableFitWithFallback$2.L$0 = obj;
        return googleFitProvider$disableFitWithFallback$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final CoroutineScope coroutineScope;
        GoogleSignInClient signInClient;
        GoogleSignInClient signInClient2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.updateUiState();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            GoogleFitProvider googleFitProvider = this.this$0;
            this.L$0 = coroutineScope;
            this.L$1 = googleFitProvider;
            this.label = 1;
            final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
            signInClient = googleFitProvider.getSignInClient();
            zzw revokeAccess = signInClient.revokeAccess();
            final Function1<Void, Unit> function1 = new Function1<Void, Unit>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableFitWithFallback$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
                    invoke2(r12);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r8) {
                    LogKt.debug$default((Object) CoroutineScope.this, FutureCoroutineKt.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableFitWithFallback$2$1$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Successfully revoked access";
                        }
                    }, 6, (Object) null);
                    safeContinuation.resumeWith(Unit.INSTANCE);
                }
            };
            OnSuccessListener onSuccessListener = new OnSuccessListener(function1) { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProviderKt$sam$com_google_android_gms_tasks_OnSuccessListener$0
                private final /* synthetic */ Function1 function;

                {
                    Intrinsics.checkNotNullParameter(function1, "function");
                    this.function = function1;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final /* synthetic */ void onSuccess(Object obj2) {
                    this.function.invoke(obj2);
                }
            };
            revokeAccess.getClass();
            revokeAccess.addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
            revokeAccess.addOnFailureListener(new OnFailureListener() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableFitWithFallback$2$1$2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(final Exception exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    LogKt.warn$default((Object) CoroutineScope.this, FutureCoroutineKt.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableFitWithFallback$2$1$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return AbstractAWSSigner$$ExternalSyntheticOutline0.m(exception, new StringBuilder("Failed to revoke access: "));
                        }
                    }, 6, (Object) null);
                    safeContinuation.resumeWith(Unit.INSTANCE);
                }
            });
            if (safeContinuation.getOrThrow() == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        GoogleFitProvider googleFitProvider2 = this.this$0;
        this.L$0 = coroutineScope;
        this.L$1 = googleFitProvider2;
        this.label = 2;
        final SafeContinuation safeContinuation2 = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
        signInClient2 = googleFitProvider2.getSignInClient();
        zzw signOut = signInClient2.signOut();
        final Function1<Void, Unit> function12 = new Function1<Void, Unit>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableFitWithFallback$2$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
                invoke2(r12);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r8) {
                LogKt.debug$default((Object) CoroutineScope.this, FutureCoroutineKt.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableFitWithFallback$2$2$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Successfully signed out";
                    }
                }, 6, (Object) null);
                safeContinuation2.resumeWith(Unit.INSTANCE);
            }
        };
        OnSuccessListener onSuccessListener2 = new OnSuccessListener(function12) { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProviderKt$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function12, "function");
                this.function = function12;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj2) {
                this.function.invoke(obj2);
            }
        };
        signOut.getClass();
        signOut.addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener2);
        signOut.addOnFailureListener(new OnFailureListener() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableFitWithFallback$2$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(final Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                LogKt.warn$default((Object) CoroutineScope.this, FutureCoroutineKt.TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$disableFitWithFallback$2$2$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(exception, new StringBuilder("Failed to sign out: "));
                    }
                }, 6, (Object) null);
                safeContinuation2.resumeWith(Unit.INSTANCE);
            }
        });
        if (safeContinuation2.getOrThrow() == coroutineSingletons) {
            return coroutineSingletons;
        }
        this.this$0.updateUiState();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleFitProvider$disableFitWithFallback$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
