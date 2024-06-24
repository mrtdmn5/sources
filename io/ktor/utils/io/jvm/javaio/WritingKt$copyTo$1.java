package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Writing.kt */
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.WritingKt", f = "Writing.kt", l = {22}, m = "copyTo")
/* loaded from: classes3.dex */
public final class WritingKt$copyTo$1 extends ContinuationImpl {
    public long J$0;
    public long J$1;
    public long J$2;
    public ByteReadChannel L$0;
    public OutputStream L$1;
    public byte[] L$2;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WritingKt.copyTo(null, null, 0L, this);
    }
}
