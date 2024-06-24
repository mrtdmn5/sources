package io.ktor.serialization.kotlinx.json;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.serialization.KSerializer;

/* compiled from: KotlinxSerializationJsonExtensions.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", l = {80, 119, 89}, m = "serialize")
/* loaded from: classes3.dex */
public final class KotlinxSerializationJsonExtensions$serialize$3<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public KSerializer L$2;
    public Charset L$3;
    public ByteWriteChannel L$4;
    public JsonArraySymbols L$5;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ KotlinxSerializationJsonExtensions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationJsonExtensions$serialize$3(KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, Continuation<? super KotlinxSerializationJsonExtensions$serialize$3> continuation) {
        super(continuation);
        this.this$0 = kotlinxSerializationJsonExtensions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KotlinxSerializationJsonExtensions.access$serialize(this.this$0, null, null, null, null, this);
    }
}
