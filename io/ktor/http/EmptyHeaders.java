package io.ktor.http;

import io.ktor.util.StringValues;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Headers.kt */
/* loaded from: classes3.dex */
public final class EmptyHeaders implements Headers {
    public static final EmptyHeaders INSTANCE = new EmptyHeaders();

    @Override // io.ktor.util.StringValues
    public final Set<Map.Entry<String, List<String>>> entries() {
        return EmptySet.INSTANCE;
    }

    @Override // io.ktor.util.StringValues
    public final void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
        StringValues.DefaultImpls.forEach(this, function2);
    }

    @Override // io.ktor.util.StringValues
    public final String get(String str) {
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final List<String> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return null;
    }

    @Override // io.ktor.util.StringValues
    public final boolean getCaseInsensitiveName() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public final Set<String> names() {
        return EmptySet.INSTANCE;
    }

    public final String toString() {
        return "Headers " + EmptySet.INSTANCE;
    }
}
