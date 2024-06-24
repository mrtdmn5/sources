package io.ktor.serialization.kotlinx;

import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: KotlinxSerializationConverter.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", l = {74, 78}, m = "deserialize")
/* loaded from: classes3.dex */
public final class KotlinxSerializationConverter$deserialize$1 extends ContinuationImpl {
    public KotlinxSerializationConverter L$0;
    public Charset L$1;
    public Object L$2;
    public ByteReadChannel L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ KotlinxSerializationConverter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationConverter$deserialize$1(KotlinxSerializationConverter kotlinxSerializationConverter, Continuation<? super KotlinxSerializationConverter$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = kotlinxSerializationConverter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, null, this);
    }
}
