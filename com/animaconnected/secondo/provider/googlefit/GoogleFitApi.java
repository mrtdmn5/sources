package com.animaconnected.secondo.provider.googlefit;

import android.content.Context;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.Session;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Device;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.datetime.Instant;

/* compiled from: GoogleFitApi.kt */
/* loaded from: classes3.dex */
public final class GoogleFitApi {
    public static final String TAG = "GoogleFitApi";
    private final Function0<GoogleSignInAccount> account;
    private final Context context;
    private Device device;
    private final FitnessProvider fitness;
    private final GoogleFitStorage storage;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: GoogleFitApi.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitApi$1", f = "GoogleFitApi.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.provider.googlefit.GoogleFitApi$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Device, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Device device, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(device, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GoogleFitApi.this.device = (Device) this.L$0;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: GoogleFitApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GoogleFitApi(StateFlow<Device> deviceFlow, Function0<? extends GoogleSignInAccount> account) {
        Intrinsics.checkNotNullParameter(deviceFlow, "deviceFlow");
        Intrinsics.checkNotNullParameter(account, "account");
        this.account = account;
        this.storage = new GoogleFitStorage();
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        this.context = companion.getContext();
        this.fitness = ProviderFactory.getWatch().fitness();
        FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AnonymousClass1(null), deviceFlow), companion.getScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Instant getLastInstant(DataSet dataSet) {
        Instant.Companion companion = Instant.Companion;
        List<DataPoint> dataPoints = dataSet.getDataPoints();
        Intrinsics.checkNotNullExpressionValue(dataPoints, "getDataPoints(...)");
        long convert = TimeUnit.MILLISECONDS.convert(((DataPoint) CollectionsKt___CollectionsKt.last(dataPoints)).zzb, TimeUnit.NANOSECONDS);
        companion.getClass();
        return Instant.Companion.fromEpochMilliseconds(convert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: insertData-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m801insertDatagIAlus(final com.google.android.gms.fitness.data.DataSet r9, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.animaconnected.secondo.provider.googlefit.GoogleFitApi$insertData$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi$insertData$1 r0 = (com.animaconnected.secondo.provider.googlefit.GoogleFitApi$insertData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi$insertData$1 r0 = new com.animaconnected.secondo.provider.googlefit.GoogleFitApi$insertData$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r9 = r0.L$1
            com.google.android.gms.fitness.data.DataSet r9 = (com.google.android.gms.fitness.data.DataSet) r9
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi r0 = (com.animaconnected.secondo.provider.googlefit.GoogleFitApi) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L30
            r10 = r0
            goto L6d
        L30:
            r10 = move-exception
            goto L86
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            kotlin.ResultKt.throwOnFailure(r10)
            android.content.Context r10 = r8.context     // Catch: java.lang.Exception -> L84
            kotlin.jvm.functions.Function0<com.google.android.gms.auth.api.signin.GoogleSignInAccount> r2 = r8.account     // Catch: java.lang.Exception -> L84
            java.lang.Object r2 = r2.invoke()     // Catch: java.lang.Exception -> L84
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r2 = (com.google.android.gms.auth.api.signin.GoogleSignInAccount) r2     // Catch: java.lang.Exception -> L84
            int r4 = com.google.android.gms.fitness.Fitness.$r8$clinit     // Catch: java.lang.Exception -> L84
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch: java.lang.Exception -> L84
            com.google.android.gms.fitness.HistoryClient r4 = new com.google.android.gms.fitness.HistoryClient     // Catch: java.lang.Exception -> L84
            com.google.android.gms.fitness.zzi r5 = new com.google.android.gms.fitness.zzi     // Catch: java.lang.Exception -> L84
            r5.<init>(r10, r2)     // Catch: java.lang.Exception -> L84
            r4.<init>(r10, r5)     // Catch: java.lang.Exception -> L84
            com.google.android.gms.tasks.zzw r10 = r4.insertData(r9)     // Catch: java.lang.Exception -> L84
            java.lang.String r2 = "insertData(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch: java.lang.Exception -> L84
            r0.L$0 = r8     // Catch: java.lang.Exception -> L84
            r0.L$1 = r9     // Catch: java.lang.Exception -> L84
            r0.label = r3     // Catch: java.lang.Exception -> L84
            java.lang.Object r10 = com.animaconnected.secondo.provider.googlefit.GoogleFitProviderKt.getSuspending(r10, r0)     // Catch: java.lang.Exception -> L84
            if (r10 != r1) goto L6c
            return r1
        L6c:
            r10 = r8
        L6d:
            java.lang.String r1 = "GoogleFitApi"
            r2 = 0
            r3 = 0
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi$insertData$2 r4 = new com.animaconnected.secondo.provider.googlefit.GoogleFitApi$insertData$2     // Catch: java.lang.Exception -> L7f
            r4.<init>()     // Catch: java.lang.Exception -> L7f
            r5 = 6
            r6 = 0
            r0 = r10
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L7f
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L7f
            goto L98
        L7f:
            r0 = move-exception
            r7 = r0
            r0 = r10
            r10 = r7
            goto L86
        L84:
            r10 = move-exception
            r0 = r8
        L86:
            java.lang.String r1 = "GoogleFitApi"
            r2 = 0
            r3 = 0
            com.animaconnected.secondo.provider.googlefit.GoogleFitApi$insertData$3 r4 = new com.animaconnected.secondo.provider.googlefit.GoogleFitApi$insertData$3
            r4.<init>()
            r5 = 6
            r6 = 0
            com.animaconnected.logger.LogKt.warn$default(r0, r1, r2, r3, r4, r5, r6)
            kotlin.Result$Failure r9 = kotlin.ResultKt.createFailure(r10)
        L98:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.googlefit.GoogleFitApi.m801insertDatagIAlus(com.google.android.gms.fitness.data.DataSet, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object uploadCalories(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new GoogleFitApi$uploadCalories$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object uploadHeartRate(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new GoogleFitApi$uploadHeartRate$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object uploadLastNightSleep(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new GoogleFitApi$uploadLastNightSleep$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object uploadSession(Session session, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new GoogleFitApi$uploadSession$2(this, session, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object uploadSteps(int r4, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new GoogleFitApi$uploadSteps$2(this, r4, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final Object uploadStepsInChunks(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.IO, new GoogleFitApi$uploadStepsInChunks$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
