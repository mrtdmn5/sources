package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import java.io.Closeable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ByteChannels.kt */
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", l = {58, 60, 61}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ByteChannelsKt$copyToBoth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ByteWriteChannel $first;
    public final /* synthetic */ ByteWriteChannel $second;
    public final /* synthetic */ ByteReadChannel $this_copyToBoth;
    public int I$0;
    public Closeable L$0;
    public ByteWriteChannel L$1;
    public ByteWriteChannel L$2;
    public ByteReadChannel L$3;
    public ByteReadPacket L$4;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$copyToBoth$1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Continuation<? super ByteChannelsKt$copyToBoth$1> continuation) {
        super(2, continuation);
        this.$this_copyToBoth = byteReadChannel;
        this.$first = byteWriteChannel;
        this.$second = byteWriteChannel2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ByteChannelsKt$copyToBoth$1(this.$this_copyToBoth, this.$first, this.$second, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelsKt$copyToBoth$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(1:(11:7|8|9|10|11|12|13|14|15|16|(2:62|(3:64|65|66)(1:67))(2:22|(1:24)(7:26|27|28|29|31|32|(1:34)(4:35|36|37|(1:39)(10:40|11|12|13|14|15|16|(2:18|20)|62|(0)(0))))))(2:83|84))(7:85|86|87|88|36|37|(0)(0))|44|45|13|14|15|16|(0)|62|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:26|28|29|31|32|(1:34)(4:35|36|37|(1:39)(10:40|11|12|13|14|15|16|(2:18|20)|62|(0)(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00df, code lost:            r9 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e0, code lost:            r8 = r15;        r15 = r9;        r9 = r6;        r6 = r7;        r7 = r8;     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0118, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0119, code lost:            r0 = r15;        r15 = r0;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[Catch: all -> 0x0118, TryCatch #9 {all -> 0x0118, blocks: (B:15:0x00f0, B:16:0x0059, B:18:0x0061, B:20:0x0069, B:22:0x0071, B:62:0x0107, B:67:0x0117), top: B:14:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0117 A[Catch: all -> 0x0118, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x0118, blocks: (B:15:0x00f0, B:16:0x0059, B:18:0x0061, B:20:0x0069, B:22:0x0071, B:62:0x0107, B:67:0x0117), top: B:14:0x00f0 }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.intrinsics.CoroutineSingletons] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [io.ktor.util.ByteChannelsKt$copyToBoth$1] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [io.ktor.util.ByteChannelsKt$copyToBoth$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v9, types: [io.ktor.util.ByteChannelsKt$copyToBoth$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r6v7, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00d0 -> B:11:0x00d2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e6 -> B:13:0x00d4). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt$copyToBoth$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
