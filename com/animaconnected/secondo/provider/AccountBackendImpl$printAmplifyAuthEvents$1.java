package com.animaconnected.secondo.provider;

import com.amplifyframework.auth.AuthChannelEventName;
import com.amplifyframework.core.InitializationStatus;
import com.amplifyframework.hub.HubChannel;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.kotlin.core.Amplify;
import com.amplifyframework.kotlin.hub.Hub;
import com.animaconnected.logger.LogKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AccountBackendImpl.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.AccountBackendImpl$printAmplifyAuthEvents$1", f = "AccountBackendImpl.kt", l = {61}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountBackendImpl$printAmplifyAuthEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AccountBackendImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountBackendImpl$printAmplifyAuthEvents$1(AccountBackendImpl accountBackendImpl, Continuation<? super AccountBackendImpl$printAmplifyAuthEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = accountBackendImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountBackendImpl$printAmplifyAuthEvents$1 accountBackendImpl$printAmplifyAuthEvents$1 = new AccountBackendImpl$printAmplifyAuthEvents$1(this.this$0, continuation);
        accountBackendImpl$printAmplifyAuthEvents$1.L$0 = obj;
        return accountBackendImpl$printAmplifyAuthEvents$1;
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
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Flow subscribe$default = Hub.DefaultImpls.subscribe$default(Amplify.Companion.getHub(), HubChannel.AUTH, null, 2, null);
            final AccountBackendImpl accountBackendImpl = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.animaconnected.secondo.provider.AccountBackendImpl$printAmplifyAuthEvents$1.1

                /* compiled from: AccountBackendImpl.kt */
                /* renamed from: com.animaconnected.secondo.provider.AccountBackendImpl$printAmplifyAuthEvents$1$1$WhenMappings */
                /* loaded from: classes3.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] r0 = new int[AuthChannelEventName.values().length];
                        try {
                            r0[AuthChannelEventName.SIGNED_IN.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            r0[AuthChannelEventName.SIGNED_OUT.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            r0[AuthChannelEventName.SESSION_EXPIRED.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            r0[AuthChannelEventName.USER_DELETED.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        $EnumSwitchMapping$0 = r0;
                    }
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((HubEvent<?>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(HubEvent<?> hubEvent, Continuation<? super Unit> continuation) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    String str6;
                    String name = hubEvent.getName();
                    if (Intrinsics.areEqual(name, InitializationStatus.SUCCEEDED.toString())) {
                        CoroutineScope coroutineScope2 = CoroutineScope.this;
                        str6 = accountBackendImpl.tag;
                        LogKt.debug$default((Object) coroutineScope2, str6, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.AccountBackendImpl.printAmplifyAuthEvents.1.1.1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Auth successfully initialized";
                            }
                        }, 6, (Object) null);
                    } else if (Intrinsics.areEqual(name, InitializationStatus.FAILED.toString())) {
                        CoroutineScope coroutineScope3 = CoroutineScope.this;
                        str5 = accountBackendImpl.tag;
                        LogKt.debug$default((Object) coroutineScope3, str5, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.AccountBackendImpl.printAmplifyAuthEvents.1.1.2
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Auth failed to succeed";
                            }
                        }, 6, (Object) null);
                    } else {
                        String name2 = hubEvent.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        int r12 = WhenMappings.$EnumSwitchMapping$0[AuthChannelEventName.valueOf(name2).ordinal()];
                        if (r12 == 1) {
                            CoroutineScope coroutineScope4 = CoroutineScope.this;
                            str = accountBackendImpl.tag;
                            LogKt.debug$default((Object) coroutineScope4, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.AccountBackendImpl.printAmplifyAuthEvents.1.1.3
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Auth just became signed in.";
                                }
                            }, 6, (Object) null);
                        } else if (r12 == 2) {
                            CoroutineScope coroutineScope5 = CoroutineScope.this;
                            str2 = accountBackendImpl.tag;
                            LogKt.debug$default((Object) coroutineScope5, str2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.AccountBackendImpl.printAmplifyAuthEvents.1.1.4
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Auth just became signed out.";
                                }
                            }, 6, (Object) null);
                        } else if (r12 == 3) {
                            CoroutineScope coroutineScope6 = CoroutineScope.this;
                            str3 = accountBackendImpl.tag;
                            LogKt.debug$default((Object) coroutineScope6, str3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.AccountBackendImpl.printAmplifyAuthEvents.1.1.5
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Auth session just expired.";
                                }
                            }, 6, (Object) null);
                        } else if (r12 == 4) {
                            CoroutineScope coroutineScope7 = CoroutineScope.this;
                            str4 = accountBackendImpl.tag;
                            LogKt.debug$default((Object) coroutineScope7, str4, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.AccountBackendImpl.printAmplifyAuthEvents.1.1.6
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "User has been deleted.";
                                }
                            }, 6, (Object) null);
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (subscribe$default.collect(flowCollector, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountBackendImpl$printAmplifyAuthEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
