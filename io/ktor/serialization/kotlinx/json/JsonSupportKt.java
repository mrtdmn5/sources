package io.ktor.serialization.kotlinx.json;

import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.json.JsonKt;

/* compiled from: JsonSupport.kt */
/* loaded from: classes3.dex */
public final class JsonSupportKt {
    public static final JsonImpl DefaultJson = JsonKt.Json$default(new Function1<JsonBuilder, Unit>() { // from class: io.ktor.serialization.kotlinx.json.JsonSupportKt$DefaultJson$1
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(JsonBuilder jsonBuilder) {
            JsonBuilder Json = jsonBuilder;
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.encodeDefaults = true;
            Json.isLenient = true;
            Json.allowSpecialFloatingPointValues = true;
            Json.allowStructuredMapKeys = true;
            Json.prettyPrint = false;
            Json.useArrayPolymorphism = false;
            return Unit.INSTANCE;
        }
    });

    public static final void json(Configuration configuration, Json json, ContentType contentType) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        configuration.register(contentType, new KotlinxSerializationConverter(json), new Function1() { // from class: io.ktor.serialization.Configuration$register$1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Intrinsics.checkNotNullParameter((ContentConverter) obj, "$this$null");
                return Unit.INSTANCE;
            }
        });
    }

    public static void json$default(Configuration configuration, Json json, int r3) {
        ContentType contentType;
        if ((r3 & 1) != 0) {
            json = DefaultJson;
        }
        if ((r3 & 2) != 0) {
            contentType = ContentType.Application.Json;
        } else {
            contentType = null;
        }
        json(configuration, json, contentType);
    }
}
