package io.ktor.client.request.forms;

import io.ktor.http.EmptyHeaders;
import io.ktor.http.Headers;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: formDsl.kt */
/* loaded from: classes3.dex */
public final class FormBuilder {
    public final ArrayList parts = new ArrayList();

    public static void append$default(FormBuilder formBuilder, String str, String value) {
        Headers.Companion.getClass();
        EmptyHeaders emptyHeaders = EmptyHeaders.INSTANCE;
        formBuilder.getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        formBuilder.parts.add(new FormPart(str, value, emptyHeaders));
    }
}
