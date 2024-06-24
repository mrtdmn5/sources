package com.animaconnected.secondo.provider;

import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.utils.AmplifyApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: CloudAccountProvider.kt */
/* loaded from: classes3.dex */
public final class CloudAccountProvider {
    public static final int $stable = 0;

    /* compiled from: CloudAccountProvider.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.provider.CloudAccountProvider$1", f = "CloudAccountProvider.kt", l = {10}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.provider.CloudAccountProvider$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* compiled from: CloudAccountProvider.kt */
        /* renamed from: com.animaconnected.secondo.provider.CloudAccountProvider$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C00411<T> implements FlowCollector {
            public static final C00411<T> INSTANCE = new C00411<>();

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0084 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.animaconnected.secondo.provider.CloudAccountProvider$1$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r9
                    com.animaconnected.secondo.provider.CloudAccountProvider$1$1$emit$1 r0 = (com.animaconnected.secondo.provider.CloudAccountProvider$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    com.animaconnected.secondo.provider.CloudAccountProvider$1$1$emit$1 r0 = new com.animaconnected.secondo.provider.CloudAccountProvider$1$1$emit$1
                    r0.<init>(r7, r9)
                L18:
                    java.lang.Object r9 = r0.result
                    kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                    int r2 = r0.label
                    r3 = 0
                    r4 = 3
                    r5 = 2
                    r6 = 1
                    if (r2 == 0) goto L4a
                    if (r2 == r6) goto L3e
                    if (r2 == r5) goto L36
                    if (r2 != r4) goto L2e
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L85
                L2e:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L36:
                    java.lang.Object r8 = r0.L$0
                    com.animaconnected.watch.fitness.FitnessProvider r8 = (com.animaconnected.watch.fitness.FitnessProvider) r8
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L72
                L3e:
                    java.lang.Object r8 = r0.L$1
                    com.animaconnected.watch.fitness.FitnessProvider r8 = (com.animaconnected.watch.fitness.FitnessProvider) r8
                    java.lang.Object r2 = r0.L$0
                    com.animaconnected.watch.fitness.FitnessProvider r2 = (com.animaconnected.watch.fitness.FitnessProvider) r2
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L65
                L4a:
                    kotlin.ResultKt.throwOnFailure(r9)
                    if (r8 == 0) goto L72
                    com.animaconnected.watch.WatchProvider r8 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
                    com.animaconnected.watch.fitness.FitnessProvider r8 = r8.fitness()
                    r0.L$0 = r8
                    r0.L$1 = r8
                    r0.label = r6
                    java.lang.Object r9 = r8.clearLocalProfileData(r0)
                    if (r9 != r1) goto L64
                    return r1
                L64:
                    r2 = r8
                L65:
                    r0.L$0 = r2
                    r0.L$1 = r3
                    r0.label = r5
                    java.lang.Object r8 = r8.forceSyncFitnessDataToCloud(r0)
                    if (r8 != r1) goto L72
                    return r1
                L72:
                    com.animaconnected.watch.WatchProvider r8 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
                    com.animaconnected.watch.WatchManager r8 = r8.getWatchManager()
                    r0.L$0 = r3
                    r0.label = r4
                    java.lang.Object r8 = r8.sync(r0)
                    if (r8 != r1) goto L85
                    return r1
                L85:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.CloudAccountProvider.AnonymousClass1.C00411.emit(boolean, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
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
                Flow<Boolean> loginStateChanged = AmplifyApi.INSTANCE.loginStateChanged();
                FlowCollector<? super Boolean> flowCollector = C00411.INSTANCE;
                this.label = 1;
                if (loginStateChanged.collect(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public CloudAccountProvider() {
        BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new AnonymousClass1(null), 3);
    }
}
