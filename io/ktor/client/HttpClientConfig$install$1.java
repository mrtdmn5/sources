package io.ktor.client;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HttpClientConfig.kt */
/* loaded from: classes3.dex */
public final class HttpClientConfig$install$1 extends Lambda implements Function1 {
    public static final HttpClientConfig$install$1 INSTANCE = new HttpClientConfig$install$1();

    public HttpClientConfig$install$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "$this$null");
        return Unit.INSTANCE;
    }
}
