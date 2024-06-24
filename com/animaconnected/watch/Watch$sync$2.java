package com.animaconnected.watch;

import com.animaconnected.watch.Watch;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Watch.kt */
@DebugMetadata(c = "com.animaconnected.watch.Watch$sync$2", f = "Watch.kt", l = {294, 304, 305, 306, 308}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Watch$sync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $connecting;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Watch this$0;

    /* compiled from: Watch.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Watch.WatchState.values().length];
            try {
                r0[Watch.WatchState.UpdateRequired.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Watch.WatchState.Disconnected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Watch.WatchState.Inactive.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Watch.WatchState.Syncing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[Watch.WatchState.Initializing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[Watch.WatchState.Initialized.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Watch$sync$2(Watch watch, boolean z, Continuation<? super Watch$sync$2> continuation) {
        super(2, continuation);
        this.this$0 = watch;
        this.$connecting = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Watch$sync$2 watch$sync$2 = new Watch$sync$2(this.this$0, this.$connecting, continuation);
        watch$sync$2.L$0 = obj;
        return watch$sync$2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(1:2)|(1:(1:(1:(1:(1:(8:9|10|11|(1:13)(1:20)|14|(1:16)|17|18)(2:21|22))(10:23|24|25|(1:27)|11|(0)(0)|14|(0)|17|18))(12:28|29|30|(1:32)|25|(0)|11|(0)(0)|14|(0)|17|18))(14:33|34|35|(1:37)|30|(0)|25|(0)|11|(0)(0)|14|(0)|17|18))(4:38|39|40|41))(4:64|65|67|(2:69|70)(2:71|(1:73)(1:74)))|42|43|(4:45|46|47|48)(1:58)|49|(1:51)(13:52|35|(0)|30|(0)|25|(0)|11|(0)(0)|14|(0)|17|18)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0209, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x020a, code lost:            r8 = r15;     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x01c0 A[Catch: Exception -> 0x020e, TryCatch #0 {Exception -> 0x020e, blocks: (B:10:0x001c, B:11:0x01a6, B:13:0x01c0, B:14:0x01df, B:16:0x01ed, B:20:0x01cc, B:24:0x002d, B:25:0x0199, B:29:0x0036, B:30:0x018c, B:34:0x003f, B:35:0x017d, B:67:0x00d2, B:69:0x00da, B:71:0x00dd), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01ed A[Catch: Exception -> 0x020e, TRY_LEAVE, TryCatch #0 {Exception -> 0x020e, blocks: (B:10:0x001c, B:11:0x01a6, B:13:0x01c0, B:14:0x01df, B:16:0x01ed, B:20:0x01cc, B:24:0x002d, B:25:0x0199, B:29:0x0036, B:30:0x018c, B:34:0x003f, B:35:0x017d, B:67:0x00d2, B:69:0x00da, B:71:0x00dd), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01cc A[Catch: Exception -> 0x020e, TryCatch #0 {Exception -> 0x020e, blocks: (B:10:0x001c, B:11:0x01a6, B:13:0x01c0, B:14:0x01df, B:16:0x01ed, B:20:0x01cc, B:24:0x002d, B:25:0x0199, B:29:0x0036, B:30:0x018c, B:34:0x003f, B:35:0x017d, B:67:0x00d2, B:69:0x00da, B:71:0x00dd), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0198 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018b A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch$sync$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((Watch$sync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
