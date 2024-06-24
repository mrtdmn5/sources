package io.ktor.serialization;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;

/* compiled from: ContentConverter.kt */
/* loaded from: classes3.dex */
public interface ContentConverter {
    Object deserialize(Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation<Object> continuation);

    Object serializeNullable(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super OutgoingContent> continuation);
}
