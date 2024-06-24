package com.animaconnected.watch;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager$sync$sync$1", f = "WatchManager.kt", l = {431, 435}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchManager$sync$sync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $maxRetires;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WatchManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$sync$sync$1(WatchManager watchManager, int r2, Continuation<? super WatchManager$sync$sync$1> continuation) {
        super(2, continuation);
        this.this$0 = watchManager;
        this.$maxRetires = r2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchManager$sync$sync$1 watchManager$sync$sync$1 = new WatchManager$sync$sync$1(this.this$0, this.$maxRetires, continuation);
        watchManager$sync$sync$1.L$0 = obj;
        return watchManager$sync$sync$1;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0115: MOVE (r8 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:278), block:B:88:0x0114 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d9 A[Catch: Exception -> 0x010a, IllegalStateException -> 0x010f, TRY_LEAVE, TryCatch #13 {IllegalStateException -> 0x010f, Exception -> 0x010a, blocks: (B:14:0x00cd, B:16:0x00d9, B:19:0x004e), top: B:13:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096 A[Catch: Exception -> 0x00f3, IllegalStateException -> 0x00f6, TRY_LEAVE, TryCatch #11 {IllegalStateException -> 0x00f6, Exception -> 0x00f3, blocks: (B:31:0x0091, B:33:0x0096), top: B:30:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00aa -> B:9:0x001b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00cc -> B:13:0x00cd). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchManager$sync$sync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((WatchManager$sync$sync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
