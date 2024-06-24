package io.ktor.client.engine.android;

import java.net.HttpURLConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AndroidEngineConfig.kt */
/* loaded from: classes3.dex */
public final class AndroidEngineConfig$requestConfig$1 extends Lambda implements Function1<HttpURLConnection, Unit> {
    public static final AndroidEngineConfig$requestConfig$1 INSTANCE = new AndroidEngineConfig$requestConfig$1();

    public AndroidEngineConfig$requestConfig$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(HttpURLConnection httpURLConnection) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "$this$null");
        return Unit.INSTANCE;
    }
}
