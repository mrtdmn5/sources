package io.ktor.serialization.kotlinx.json;

import io.ktor.serialization.kotlinx.KotlinxSerializationExtension;
import io.ktor.serialization.kotlinx.KotlinxSerializationExtensionProvider;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.json.Json;

/* compiled from: KotlinxSerializationJsonExtensions.kt */
/* loaded from: classes3.dex */
public final class KotlinxSerializationJsonExtensionProvider implements KotlinxSerializationExtensionProvider {
    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtensionProvider
    public KotlinxSerializationExtension extension(SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (!(format instanceof Json)) {
            return null;
        }
        return new KotlinxSerializationJsonExtensions((Json) format);
    }
}
