package com.animaconnected.secondo.provider;

import com.animaconnected.cloud.Cloud;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.utils.AmplifyApi;
import com.animaconnected.watch.device.AccountBackend;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: AccountBackendImpl.kt */
/* loaded from: classes3.dex */
public final class AccountBackendImpl implements AccountBackend {
    public static final int $stable = 8;
    private final Cloud cloud;
    private final PoolIdProvider poolIdProvider;
    private final String tag;

    /* compiled from: AccountBackendImpl.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.provider.AccountBackendImpl$1", f = "AccountBackendImpl.kt", l = {27, 28}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.provider.AccountBackendImpl$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ SigninStorage $storage;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SigninStorage signinStorage, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$storage = signinStorage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$storage, continuation);
            anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return invoke(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = this.Z$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                z = this.Z$0;
                AmplifyApi amplifyApi = AmplifyApi.INSTANCE;
                this.Z$0 = z;
                this.label = 1;
                if (amplifyApi.updateUserLocale(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            AccountBackendImpl accountBackendImpl = AccountBackendImpl.this;
            SigninStorage signinStorage = this.$storage;
            this.label = 2;
            if (accountBackendImpl.updateSignInStorage(z, signinStorage, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            return Unit.INSTANCE;
        }

        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public AccountBackendImpl(Cloud cloud, PoolIdProvider poolIdProvider) {
        Intrinsics.checkNotNullParameter(cloud, "cloud");
        Intrinsics.checkNotNullParameter(poolIdProvider, "poolIdProvider");
        this.cloud = cloud;
        this.poolIdProvider = poolIdProvider;
        this.tag = "AccountBackendImpl";
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        SigninStorage signinStorage = new SigninStorage(companion.getContext());
        FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AnonymousClass1(signinStorage, null), AmplifyApi.INSTANCE.loginStateChanged()), companion.getScope());
        printAmplifyAuthEvents();
    }

    private final void printAmplifyAuthEvents() {
        BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new AccountBackendImpl$printAmplifyAuthEvents$1(this, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateSignInStorage(boolean z, SigninStorage signinStorage, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new AccountBackendImpl$updateSignInStorage$2(signinStorage, z, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.device.AccountBackend
    public boolean isSandbox() {
        return this.poolIdProvider.isOnSandbox();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.device.AccountBackend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object token(kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<java.lang.String, com.animaconnected.watch.utils.WatchLibException>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.provider.AccountBackendImpl$token$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.provider.AccountBackendImpl$token$1 r0 = (com.animaconnected.secondo.provider.AccountBackendImpl$token$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.AccountBackendImpl$token$1 r0 = new com.animaconnected.secondo.provider.AccountBackendImpl$token$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.value
            goto L41
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.cloud.Cloud r5 = r4.cloud
            r0.label = r3
            java.lang.Object r5 = r5.m695getCognitoTokenIoAF18A(r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            boolean r0 = r5 instanceof kotlin.Result.Failure
            if (r0 == 0) goto L46
            r5 = 0
        L46:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L50
            com.animaconnected.watch.utils.WatchLibResult$Success r0 = new com.animaconnected.watch.utils.WatchLibResult$Success
            r0.<init>(r5)
            goto L5b
        L50:
            com.animaconnected.watch.utils.WatchLibResult$Failure r0 = new com.animaconnected.watch.utils.WatchLibResult$Failure
            com.animaconnected.watch.utils.WatchLibException$Companion r5 = com.animaconnected.watch.utils.WatchLibException.Companion
            com.animaconnected.watch.utils.WatchLibException r5 = r5.getNoTokenAvailableException()
            r0.<init>(r5)
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.AccountBackendImpl.token(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
