package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: KotlinxSerializationConverter.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter", f = "KotlinxSerializationConverter.kt", l = {59}, m = "serializeNullable")
/* loaded from: classes3.dex */
public final class KotlinxSerializationConverter$serializeNullable$1 extends ContinuationImpl {
    public KotlinxSerializationConverter L$0;
    public ContentType L$1;
    public Charset L$2;
    public TypeInfo L$3;
    public Object L$4;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ KotlinxSerializationConverter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationConverter$serializeNullable$1(KotlinxSerializationConverter kotlinxSerializationConverter, Continuation<? super KotlinxSerializationConverter$serializeNullable$1> continuation) {
        super(continuation);
        this.this$0 = kotlinxSerializationConverter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.serializeNullable(null, null, null, null, this);
    }
}
