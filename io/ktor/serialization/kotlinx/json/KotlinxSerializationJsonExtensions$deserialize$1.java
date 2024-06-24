package io.ktor.serialization.kotlinx.json;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: KotlinxSerializationJsonExtensions.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions", f = "KotlinxSerializationJsonExtensions.kt", l = {66}, m = "deserialize")
/* loaded from: classes3.dex */
public final class KotlinxSerializationJsonExtensions$deserialize$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ KotlinxSerializationJsonExtensions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationJsonExtensions$deserialize$1(KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, Continuation<? super KotlinxSerializationJsonExtensions$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = kotlinxSerializationJsonExtensions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, null, this);
    }
}
