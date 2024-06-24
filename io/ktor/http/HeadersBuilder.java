package io.ktor.http;

import io.ktor.util.StringValuesBuilderImpl;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Headers.kt */
/* loaded from: classes3.dex */
public final class HeadersBuilder extends StringValuesBuilderImpl {
    public HeadersBuilder() {
        this(0);
    }

    public final HeadersImpl build() {
        return new HeadersImpl(this.values);
    }

    @Override // io.ktor.util.StringValuesBuilderImpl
    public final void validateName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<String> list = HttpHeaders.UnsafeHeadersList;
        int r0 = 0;
        int r1 = 0;
        while (r0 < name.length()) {
            char charAt = name.charAt(r0);
            int r3 = r1 + 1;
            if (Intrinsics.compare(charAt, 32) > 0 && !StringsKt__StringsKt.contains$default("\"(),/:;<=>?@[\\]{}", charAt)) {
                r0++;
                r1 = r3;
            } else {
                throw new IllegalHeaderNameException(name, r1);
            }
        }
    }

    @Override // io.ktor.util.StringValuesBuilderImpl
    public final void validateValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        List<String> list = HttpHeaders.UnsafeHeadersList;
        int r0 = 0;
        int r1 = 0;
        while (r0 < value.length()) {
            char charAt = value.charAt(r0);
            int r3 = r1 + 1;
            if (Intrinsics.compare(charAt, 32) < 0 && charAt != '\t') {
                throw new IllegalHeaderValueException(value, r1);
            }
            r0++;
            r1 = r3;
        }
    }

    public HeadersBuilder(int r1) {
        super(8);
    }
}
