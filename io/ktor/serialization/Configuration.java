package io.ktor.serialization;

import io.ktor.http.ContentType;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter;
import kotlin.jvm.functions.Function1;

/* compiled from: ContentConverter.kt */
/* loaded from: classes3.dex */
public interface Configuration {
    void register(ContentType contentType, KotlinxSerializationConverter kotlinxSerializationConverter, Function1 function1);
}
