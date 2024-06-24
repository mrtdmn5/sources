package io.ktor.util;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteChannels.kt */
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt", f = "ByteChannels.kt", l = {88}, m = "toByteArray")
/* loaded from: classes3.dex */
public final class ByteChannelsKt$toByteArray$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteChannelsKt.toByteArray(null, this);
    }
}
