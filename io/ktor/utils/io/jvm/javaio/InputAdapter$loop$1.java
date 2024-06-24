package io.ktor.utils.io.jvm.javaio;

import kotlinx.coroutines.Job;

/* compiled from: Blocking.kt */
/* loaded from: classes3.dex */
public final class InputAdapter$loop$1 extends BlockingAdapter {
    public final /* synthetic */ InputAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAdapter$loop$1(Job job, InputAdapter inputAdapter) {
        super(job);
        this.this$0 = inputAdapter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:            if (r8 == null) goto L34;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:            io.ktor.utils.io.jvm.javaio.PollersKt.getParkingImpl().unpark(r8);     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:            r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:            if (r6 != r1) goto L37;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:            r6 = r13;        r13 = r6;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf A[LOOP:0: B:18:0x004c->B:29:0x00bf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0078 A[EDGE_INSN: B:30:0x0078->B:31:0x0078 BREAK  A[LOOP:0: B:18:0x004c->B:29:0x00bf], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a3 -> B:11:0x00a6). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.jvm.javaio.BlockingAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loop(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1.loop(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
