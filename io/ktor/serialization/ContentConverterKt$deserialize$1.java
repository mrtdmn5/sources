package io.ktor.serialization;

import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ContentConverter.kt */
@DebugMetadata(c = "io.ktor.serialization.ContentConverterKt", f = "ContentConverter.kt", l = {123}, m = "deserialize")
/* loaded from: classes3.dex */
public final class ContentConverterKt$deserialize$1 extends ContinuationImpl {
    public ByteReadChannel L$0;
    public TypeInfo L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContentConverterKt.deserialize(null, null, null, null, this);
    }
}
