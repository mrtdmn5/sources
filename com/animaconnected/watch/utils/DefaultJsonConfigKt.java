package com.animaconnected.watch.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: DefaultJsonConfig.kt */
/* loaded from: classes3.dex */
public final class DefaultJsonConfigKt {
    public static final Json DefaultConfig(Json json) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        return JsonKt.Json$default(new Function1<JsonBuilder, Unit>() { // from class: com.animaconnected.watch.utils.DefaultJsonConfigKt$DefaultConfig$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                invoke2(jsonBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                Json.ignoreUnknownKeys = true;
                Json.encodeDefaults = true;
            }
        });
    }
}
