package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;

/* compiled from: Extensions.kt */
/* loaded from: classes3.dex */
public interface KotlinxSerializationExtension {
    Object deserialize(Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation<Object> continuation);

    ChannelWriterContent serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj);
}
