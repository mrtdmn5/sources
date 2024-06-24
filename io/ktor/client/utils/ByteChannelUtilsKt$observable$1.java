package io.ktor.client.utils;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: ByteChannelUtils.kt */
@DebugMetadata(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", l = {23, 24, 26, 31}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ByteChannelUtilsKt$observable$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Long $contentLength;
    public final /* synthetic */ Function3<Long, Long, Continuation<? super Unit>, Object> $listener;
    public final /* synthetic */ ByteReadChannel $this_observable;
    public int I$0;
    public long J$0;
    public long J$1;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public ByteReadChannel L$2;
    public Function3 L$3;
    public Object L$4;
    public byte[] L$5;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ByteChannelUtilsKt$observable$1(Long l, ByteReadChannel byteReadChannel, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super ByteChannelUtilsKt$observable$1> continuation) {
        super(2, continuation);
        this.$contentLength = l;
        this.$this_observable = byteReadChannel;
        this.$listener = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ByteChannelUtilsKt$observable$1 byteChannelUtilsKt$observable$1 = new ByteChannelUtilsKt$observable$1(this.$contentLength, this.$this_observable, this.$listener, continuation);
        byteChannelUtilsKt$observable$1.L$0 = obj;
        return byteChannelUtilsKt$observable$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelUtilsKt$observable$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00db A[Catch: all -> 0x015a, TryCatch #3 {all -> 0x015a, blocks: (B:26:0x00d5, B:28:0x00db, B:31:0x00f6, B:35:0x0127, B:39:0x015d, B:43:0x0170, B:62:0x009c), top: B:61:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015d A[Catch: all -> 0x015a, TryCatch #3 {all -> 0x015a, blocks: (B:26:0x00d5, B:28:0x00db, B:31:0x00f6, B:35:0x0127, B:39:0x015d, B:43:0x0170, B:62:0x009c), top: B:61:0x009c }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x014d -> B:25:0x0155). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.utils.ByteChannelUtilsKt$observable$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
