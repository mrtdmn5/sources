package io.ktor.http.auth;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: HttpAuthHeader.kt */
/* loaded from: classes3.dex */
public final class HttpAuthHeaderKt$unescaped$1 extends Lambda implements Function1<MatchResult, CharSequence> {
    public static final HttpAuthHeaderKt$unescaped$1 INSTANCE = new HttpAuthHeaderKt$unescaped$1();

    public HttpAuthHeaderKt$unescaped$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(MatchResult matchResult) {
        MatchResult it = matchResult;
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt___StringsKt.takeLast(1, it.getValue());
    }
}
