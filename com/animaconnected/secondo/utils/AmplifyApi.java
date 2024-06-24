package com.animaconnected.secondo.utils;

import android.app.Activity;
import com.amplifyframework.auth.AuthChannelEventName;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import com.amplifyframework.auth.AuthProvider;
import com.amplifyframework.auth.cognito.AWSCognitoAuthSession;
import com.amplifyframework.auth.result.AuthResetPasswordResult;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.auth.result.AuthUpdateAttributeResult;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.kotlin.core.Amplify;
import com.amplifyframework.kotlin.hub.Hub;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: AmplifyApi.kt */
/* loaded from: classes3.dex */
public final class AmplifyApi {
    public static final int $stable = 0;
    public static final AmplifyApi INSTANCE = new AmplifyApi();
    private static final String TAG = "Amplify";

    private AmplifyApi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchAuthSession(Continuation<? super AmplifyResult<AWSCognitoAuthSession>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$fetchAuthSession$2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object isSignedIn(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$isSignedIn$2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object signIn(String str, String str2, Continuation<? super AmplifyResult<AuthSignInResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$signIn$2(str, str2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object signInWithSocialWebUI(AuthProvider authProvider, Activity activity, Continuation<? super AmplifyResult<AuthSignInResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$signInWithSocialWebUI$2(authProvider, activity, null), continuation);
    }

    public final Object confirmResetPassword(String str, String str2, String str3, Continuation<? super AmplifyResult> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$confirmResetPassword$2(str, str2, str3, null), continuation);
    }

    public final Object confirmSignUp(String str, String str2, Continuation<? super AmplifyResult<AuthSignUpResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$confirmSignUp$2(str, str2, null), continuation);
    }

    public final Flow<Boolean> loginStateChanged() {
        final Flow subscribe$default = Hub.DefaultImpls.subscribe$default(Amplify.Companion.getHub(), HubChannel.AUTH, null, 2, null);
        final Flow<AuthChannelEventName> flow = new Flow<AuthChannelEventName>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1$2", f = "AmplifyApi.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r12, kotlin.coroutines.Continuation r13) {
                    /*
                        r11 = this;
                        boolean r0 = r13 instanceof com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r13
                        com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1$2$1 r0 = (com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1$2$1 r0 = new com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1$2$1
                        r0.<init>(r13)
                    L18:
                        java.lang.Object r13 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r13)
                        goto L5e
                    L27:
                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                        java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                        r12.<init>(r13)
                        throw r12
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r13)
                        kotlinx.coroutines.flow.FlowCollector r13 = r11.$this_unsafeFlow
                        com.amplifyframework.hub.HubEvent r12 = (com.amplifyframework.hub.HubEvent) r12
                        java.lang.String r12 = r12.getName()     // Catch: java.lang.Exception -> L54
                        java.lang.String r2 = "getName(...)"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)     // Catch: java.lang.Exception -> L54
                        com.amplifyframework.auth.AuthChannelEventName r12 = com.amplifyframework.auth.AuthChannelEventName.valueOf(r12)     // Catch: java.lang.Exception -> L54
                        com.animaconnected.secondo.utils.AmplifyApi r4 = com.animaconnected.secondo.utils.AmplifyApi.INSTANCE     // Catch: java.lang.Exception -> L54
                        java.lang.String r5 = "Amplify"
                        r6 = 0
                        r7 = 0
                        com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$1$1 r8 = new com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$1$1     // Catch: java.lang.Exception -> L54
                        r8.<init>()     // Catch: java.lang.Exception -> L54
                        r9 = 6
                        r10 = 0
                        com.animaconnected.logger.LogKt.debug$default(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L54
                        goto L55
                    L54:
                        r12 = 0
                    L55:
                        r0.label = r3
                        java.lang.Object r12 = r13.emit(r12, r0)
                        if (r12 != r1) goto L5e
                        return r1
                    L5e:
                        kotlin.Unit r12 = kotlin.Unit.INSTANCE
                        return r12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super AuthChannelEventName> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        final Flow<AuthChannelEventName> flow2 = new Flow<AuthChannelEventName>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1$2", f = "AmplifyApi.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1$2$1 r0 = (com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1$2$1 r0 = new com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L4e
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        r2 = r6
                        com.amplifyframework.auth.AuthChannelEventName r2 = (com.amplifyframework.auth.AuthChannelEventName) r2
                        com.amplifyframework.auth.AuthChannelEventName r4 = com.amplifyframework.auth.AuthChannelEventName.SIGNED_IN
                        if (r2 == r4) goto L42
                        com.amplifyframework.auth.AuthChannelEventName r4 = com.amplifyframework.auth.AuthChannelEventName.SIGNED_OUT
                        if (r2 != r4) goto L40
                        goto L42
                    L40:
                        r2 = 0
                        goto L43
                    L42:
                        r2 = r3
                    L43:
                        if (r2 == 0) goto L4e
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L4e
                        return r1
                    L4e:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super AuthChannelEventName> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        return FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2$2", f = "AmplifyApi.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2$2$1 r0 = (com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2$2$1 r0 = new com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4a
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        com.amplifyframework.auth.AuthChannelEventName r5 = (com.amplifyframework.auth.AuthChannelEventName) r5
                        com.amplifyframework.auth.AuthChannelEventName r2 = com.amplifyframework.auth.AuthChannelEventName.SIGNED_IN
                        if (r5 != r2) goto L3c
                        r5 = r3
                        goto L3d
                    L3c:
                        r5 = 0
                    L3d:
                        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4a
                        return r1
                    L4a:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi$loginStateChanged$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final Object resendCode(String str, Continuation<? super AmplifyResult<AuthCodeDeliveryDetails>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$resendCode$2(str, null), continuation);
    }

    public final Object resetPassword(String str, Continuation<? super AmplifyResult<AuthResetPasswordResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$resetPassword$2(str, null), continuation);
    }

    public final Object signOut(Continuation<? super AmplifyResult<Boolean>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$signOut$2(null), continuation);
    }

    public final Object signUp(String str, String str2, Continuation<? super AmplifyResult<AuthSignUpResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$signUp$2(str, str2, null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x002a, B:13:0x0098, B:23:0x007d, B:25:0x0085, B:27:0x0088), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0088 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x002a, B:13:0x0098, B:23:0x007d, B:25:0x0085, B:27:0x0088), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.animaconnected.secondo.utils.AmplifyApi] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.animaconnected.secondo.utils.AmplifyApi, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object trySignInWithEmail(java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation<? super com.animaconnected.secondo.utils.AmplifyResult<com.amplifyframework.auth.result.AuthSignInResult>> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.animaconnected.secondo.utils.AmplifyApi$trySignInWithEmail$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.secondo.utils.AmplifyApi$trySignInWithEmail$1 r0 = (com.animaconnected.secondo.utils.AmplifyApi$trySignInWithEmail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.utils.AmplifyApi$trySignInWithEmail$1 r0 = new com.animaconnected.secondo.utils.AmplifyApi$trySignInWithEmail$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L54
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r9 = r0.L$0
            com.animaconnected.secondo.utils.AmplifyApi r9 = (com.animaconnected.secondo.utils.AmplifyApi) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L2f
            goto L98
        L2f:
            r10 = move-exception
            r0 = r9
            goto L9f
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            java.lang.Object r9 = r0.L$2
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.utils.AmplifyApi r2 = (com.animaconnected.secondo.utils.AmplifyApi) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L51
            r7 = r10
            r10 = r9
            r9 = r2
            r2 = r11
            r11 = r7
            goto L7d
        L51:
            r10 = move-exception
            r0 = r2
            goto L9f
        L54:
            kotlin.ResultKt.throwOnFailure(r11)
            com.animaconnected.secondo.utils.Internet r11 = com.animaconnected.secondo.utils.Internet.INSTANCE     // Catch: java.lang.Exception -> L9d
            boolean r11 = r11.isAvailable()     // Catch: java.lang.Exception -> L9d
            if (r11 != 0) goto L6a
            com.animaconnected.secondo.utils.AmplifyResult$Failure r9 = new com.animaconnected.secondo.utils.AmplifyResult$Failure     // Catch: java.lang.Exception -> L9d
            com.animaconnected.secondo.utils.NoInternetAccessException r10 = new com.animaconnected.secondo.utils.NoInternetAccessException     // Catch: java.lang.Exception -> L9d
            r10.<init>()     // Catch: java.lang.Exception -> L9d
            r9.<init>(r10)     // Catch: java.lang.Exception -> L9d
            return r9
        L6a:
            r0.L$0 = r8     // Catch: java.lang.Exception -> L9d
            r0.L$1 = r9     // Catch: java.lang.Exception -> L9d
            r0.L$2 = r10     // Catch: java.lang.Exception -> L9d
            r0.label = r4     // Catch: java.lang.Exception -> L9d
            java.lang.Object r11 = r8.isSignedIn(r0)     // Catch: java.lang.Exception -> L9d
            if (r11 != r1) goto L79
            return r1
        L79:
            r2 = r11
            r11 = r10
            r10 = r9
            r9 = r8
        L7d:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Exception -> L2f
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L2f
            if (r2 == 0) goto L88
            com.animaconnected.secondo.utils.AmplifyResult$SuccessNothingDone r9 = com.animaconnected.secondo.utils.AmplifyResult.SuccessNothingDone.INSTANCE     // Catch: java.lang.Exception -> L2f
            goto Lb2
        L88:
            r0.L$0 = r9     // Catch: java.lang.Exception -> L2f
            r2 = 0
            r0.L$1 = r2     // Catch: java.lang.Exception -> L2f
            r0.L$2 = r2     // Catch: java.lang.Exception -> L2f
            r0.label = r3     // Catch: java.lang.Exception -> L2f
            java.lang.Object r11 = r9.signIn(r10, r11, r0)     // Catch: java.lang.Exception -> L2f
            if (r11 != r1) goto L98
            return r1
        L98:
            r10 = r11
            com.animaconnected.secondo.utils.AmplifyResult r10 = (com.animaconnected.secondo.utils.AmplifyResult) r10     // Catch: java.lang.Exception -> L2f
            r9 = r10
            goto Lb2
        L9d:
            r10 = move-exception
            r0 = r8
        L9f:
            java.lang.String r1 = r10.toString()
            java.lang.String r2 = "Amplify"
            r4 = 0
            r5 = 8
            r6 = 0
            r3 = r10
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.secondo.utils.AmplifyResult$Failure r9 = new com.animaconnected.secondo.utils.AmplifyResult$Failure
            r9.<init>(r10)
        Lb2:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi.trySignInWithEmail(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x002a, B:13:0x008d, B:23:0x0072, B:25:0x007a, B:27:0x007d), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x002a, B:13:0x008d, B:23:0x0072, B:25:0x007a, B:27:0x007d), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.animaconnected.secondo.utils.AmplifyApi] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.animaconnected.secondo.utils.AmplifyApi, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object trySignInWithSocialWebUI(com.amplifyframework.auth.AuthProvider r9, android.app.Activity r10, kotlin.coroutines.Continuation<? super com.animaconnected.secondo.utils.AmplifyResult<com.amplifyframework.auth.result.AuthSignInResult>> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.animaconnected.secondo.utils.AmplifyApi$trySignInWithSocialWebUI$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.secondo.utils.AmplifyApi$trySignInWithSocialWebUI$1 r0 = (com.animaconnected.secondo.utils.AmplifyApi$trySignInWithSocialWebUI$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.utils.AmplifyApi$trySignInWithSocialWebUI$1 r0 = new com.animaconnected.secondo.utils.AmplifyApi$trySignInWithSocialWebUI$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L54
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r9 = r0.L$0
            com.animaconnected.secondo.utils.AmplifyApi r9 = (com.animaconnected.secondo.utils.AmplifyApi) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L2f
            goto L8d
        L2f:
            r10 = move-exception
            r0 = r9
            goto L9a
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            java.lang.Object r9 = r0.L$2
            r10 = r9
            android.app.Activity r10 = (android.app.Activity) r10
            java.lang.Object r9 = r0.L$1
            com.amplifyframework.auth.AuthProvider r9 = (com.amplifyframework.auth.AuthProvider) r9
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.utils.AmplifyApi r2 = (com.animaconnected.secondo.utils.AmplifyApi) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L51
            r7 = r10
            r10 = r9
            r9 = r2
            r2 = r11
            r11 = r7
            goto L72
        L51:
            r10 = move-exception
            r0 = r2
            goto L9a
        L54:
            kotlin.ResultKt.throwOnFailure(r11)
            com.animaconnected.secondo.utils.Internet r11 = com.animaconnected.secondo.utils.Internet.INSTANCE     // Catch: java.lang.Exception -> L98
            boolean r11 = r11.isAvailable()     // Catch: java.lang.Exception -> L98
            if (r11 == 0) goto L92
            r0.L$0 = r8     // Catch: java.lang.Exception -> L98
            r0.L$1 = r9     // Catch: java.lang.Exception -> L98
            r0.L$2 = r10     // Catch: java.lang.Exception -> L98
            r0.label = r4     // Catch: java.lang.Exception -> L98
            java.lang.Object r11 = r8.isSignedIn(r0)     // Catch: java.lang.Exception -> L98
            if (r11 != r1) goto L6e
            return r1
        L6e:
            r2 = r11
            r11 = r10
            r10 = r9
            r9 = r8
        L72:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Exception -> L2f
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L2f
            if (r2 == 0) goto L7d
            com.animaconnected.secondo.utils.AmplifyResult$SuccessNothingDone r9 = com.animaconnected.secondo.utils.AmplifyResult.SuccessNothingDone.INSTANCE     // Catch: java.lang.Exception -> L2f
            goto Lad
        L7d:
            r0.L$0 = r9     // Catch: java.lang.Exception -> L2f
            r2 = 0
            r0.L$1 = r2     // Catch: java.lang.Exception -> L2f
            r0.L$2 = r2     // Catch: java.lang.Exception -> L2f
            r0.label = r3     // Catch: java.lang.Exception -> L2f
            java.lang.Object r11 = r9.signInWithSocialWebUI(r10, r11, r0)     // Catch: java.lang.Exception -> L2f
            if (r11 != r1) goto L8d
            return r1
        L8d:
            r10 = r11
            com.animaconnected.secondo.utils.AmplifyResult r10 = (com.animaconnected.secondo.utils.AmplifyResult) r10     // Catch: java.lang.Exception -> L2f
            r9 = r10
            goto Lad
        L92:
            com.animaconnected.secondo.utils.NoInternetAccessException r9 = new com.animaconnected.secondo.utils.NoInternetAccessException     // Catch: java.lang.Exception -> L98
            r9.<init>()     // Catch: java.lang.Exception -> L98
            throw r9     // Catch: java.lang.Exception -> L98
        L98:
            r10 = move-exception
            r0 = r8
        L9a:
            java.lang.String r1 = r10.toString()
            java.lang.String r2 = "Amplify"
            r4 = 0
            r5 = 8
            r6 = 0
            r3 = r10
            com.animaconnected.logger.LogKt.verbose$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.secondo.utils.AmplifyResult$Failure r9 = new com.animaconnected.secondo.utils.AmplifyResult$Failure
            r9.<init>(r10)
        Lad:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.AmplifyApi.trySignInWithSocialWebUI(com.amplifyframework.auth.AuthProvider, android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object updateUserLocale(Continuation<? super AmplifyResult<AuthUpdateAttributeResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new AmplifyApi$updateUserLocale$2(null), continuation);
    }
}
