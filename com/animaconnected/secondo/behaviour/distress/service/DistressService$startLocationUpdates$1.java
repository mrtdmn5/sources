package com.animaconnected.secondo.behaviour.distress.service;

import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.location.LocationResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: DistressService.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1", f = "DistressService.kt", l = {56, 71}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DistressService$startLocationUpdates$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DistressService this$0;

    /* compiled from: DistressService.kt */
    /* renamed from: com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ DistressService this$0;

        public AnonymousClass1(DistressService distressService, CoroutineScope coroutineScope) {
            this.this$0 = distressService;
            this.$$this$launch = coroutineScope;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((LocationResult) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(final com.animaconnected.watch.location.LocationResult r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
            /*
                r21 = this;
                r1 = r21
                r0 = r22
                r2 = r23
                boolean r3 = r2 instanceof com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$emit$1
                if (r3 == 0) goto L19
                r3 = r2
                com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$emit$1 r3 = (com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$emit$1) r3
                int r4 = r3.label
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = r4 & r5
                if (r6 == 0) goto L19
                int r4 = r4 - r5
                r3.label = r4
                goto L1e
            L19:
                com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$emit$1 r3 = new com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$emit$1
                r3.<init>(r1, r2)
            L1e:
                java.lang.Object r2 = r3.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r5 = r3.label
                java.lang.String r6 = "access$getTAG$cp(...)"
                r7 = 1
                if (r5 == 0) goto L40
                if (r5 != r7) goto L38
                java.lang.Object r0 = r3.L$0
                r3 = r0
                com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1 r3 = (com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1.AnonymousClass1) r3
                kotlin.ResultKt.throwOnFailure(r2)     // Catch: java.lang.Exception -> L35
                goto Lbc
            L35:
                r0 = move-exception
                r9 = r0
                goto L8f
            L38:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L40:
                kotlin.ResultKt.throwOnFailure(r2)
                boolean r2 = r0 instanceof com.animaconnected.watch.location.Spot
                if (r2 == 0) goto La1
                com.animaconnected.secondo.behaviour.distress.model.DistressModel$Companion r2 = com.animaconnected.secondo.behaviour.distress.model.DistressModel.Companion
                com.animaconnected.secondo.behaviour.distress.service.DistressService r5 = r1.this$0
                android.content.Context r5 = r5.getApplicationContext()
                java.lang.String r8 = "getApplicationContext(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
                com.animaconnected.secondo.behaviour.distress.model.DistressModel r2 = r2.getInstance(r5)
                boolean r2 = r2.isActive()
                if (r2 == 0) goto Lbc
                com.animaconnected.secondo.behaviour.distress.api.DistressApi$Companion r2 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.Companion     // Catch: java.lang.Exception -> L8c
                com.animaconnected.secondo.behaviour.distress.service.DistressService r5 = r1.this$0     // Catch: java.lang.Exception -> L8c
                android.content.Context r5 = r5.getApplicationContext()     // Catch: java.lang.Exception -> L8c
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)     // Catch: java.lang.Exception -> L8c
                com.animaconnected.secondo.behaviour.distress.api.DistressApi r2 = r2.getInstance(r5)     // Catch: java.lang.Exception -> L8c
                com.animaconnected.secondo.behaviour.distress.api.request.FollowMeLocation r5 = new com.animaconnected.secondo.behaviour.distress.api.request.FollowMeLocation     // Catch: java.lang.Exception -> L8c
                r8 = r0
                com.animaconnected.watch.location.Spot r8 = (com.animaconnected.watch.location.Spot) r8     // Catch: java.lang.Exception -> L8c
                double r9 = r8.latitude     // Catch: java.lang.Exception -> L8c
                r8 = r0
                com.animaconnected.watch.location.Spot r8 = (com.animaconnected.watch.location.Spot) r8     // Catch: java.lang.Exception -> L8c
                double r11 = r8.longitude     // Catch: java.lang.Exception -> L8c
                com.animaconnected.watch.location.Spot r0 = (com.animaconnected.watch.location.Spot) r0     // Catch: java.lang.Exception -> L8c
                float r13 = r0.accuracy     // Catch: java.lang.Exception -> L8c
                r8 = r5
                r8.<init>(r9, r11, r13)     // Catch: java.lang.Exception -> L8c
                r3.L$0 = r1     // Catch: java.lang.Exception -> L8c
                r3.label = r7     // Catch: java.lang.Exception -> L8c
                java.lang.Object r0 = r2.updateLocation(r5, r3)     // Catch: java.lang.Exception -> L8c
                if (r0 != r4) goto Lbc
                return r4
            L8c:
                r0 = move-exception
                r9 = r0
                r3 = r1
            L8f:
                kotlinx.coroutines.CoroutineScope r7 = r3.$$this$launch
                java.lang.String r8 = com.animaconnected.secondo.behaviour.distress.service.DistressService.access$getTAG$cp()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
                r10 = 0
                com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$1 r11 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.secondo.behaviour.distress.service.DistressService.startLocationUpdates.1.1.1
                    static {
                        /*
                            com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$1 r0 = new com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT (r0 I:com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$1) com.animaconnected.secondo.behaviour.distress.service.DistressService.startLocationUpdates.1.1.1.INSTANCE com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1.AnonymousClass1.C00371.<clinit>():void");
                    }

                    {
                        /*
                            r1 = this;
                            r0 = 0
                            r1.<init>(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1.AnonymousClass1.C00371.<init>():void");
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final java.lang.String invoke() {
                        /*
                            r1 = this;
                            java.lang.String r0 = "DistressApi.updateLocation() failed"
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1.AnonymousClass1.C00371.invoke():java.lang.String");
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ java.lang.String invoke() {
                        /*
                            r1 = this;
                            java.lang.String r0 = r1.invoke()
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1.AnonymousClass1.C00371.invoke():java.lang.Object");
                    }
                }
                r12 = 4
                r13 = 0
                com.animaconnected.logger.LogKt.debug$default(r7, r8, r9, r10, r11, r12, r13)
                goto Lbc
            La1:
                kotlinx.coroutines.CoroutineScope r14 = r1.$$this$launch
                java.lang.String r15 = com.animaconnected.secondo.behaviour.distress.service.DistressService.access$getTAG$cp()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r6)
                r16 = 0
                r17 = 0
                com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$2 r2 = new com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1$1$2
                r2.<init>()
                r19 = 6
                r20 = 0
                r18 = r2
                com.animaconnected.logger.LogKt.debug$default(r14, r15, r16, r17, r18, r19, r20)
            Lbc:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.service.DistressService$startLocationUpdates$1.AnonymousClass1.emit(com.animaconnected.watch.location.LocationResult, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressService$startLocationUpdates$1(DistressService distressService, Continuation<? super DistressService$startLocationUpdates$1> continuation) {
        super(2, continuation);
        this.this$0 = distressService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DistressService$startLocationUpdates$1 distressService$startLocationUpdates$1 = new DistressService$startLocationUpdates$1(this.this$0, continuation);
        distressService$startLocationUpdates$1.L$0 = obj;
        return distressService$startLocationUpdates$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.startLocationUpdates();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Flow<LocationResult> locations = ProviderFactory.getWatch().getWatchManager().getLocationProvider().getLocations();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, coroutineScope);
            this.label = 1;
            if (locations.collect(anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        int r7 = Duration.$r8$clinit;
        long duration = DurationKt.toDuration(10, DurationUnit.SECONDS);
        this.label = 2;
        if (DelayKt.m1695delayVtjQ1oo(duration, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        this.this$0.startLocationUpdates();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DistressService$startLocationUpdates$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
