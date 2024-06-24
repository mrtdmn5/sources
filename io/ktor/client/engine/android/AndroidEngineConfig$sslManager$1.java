package io.ktor.client.engine.android;

import javax.net.ssl.HttpsURLConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AndroidEngineConfig.kt */
/* loaded from: classes3.dex */
public final class AndroidEngineConfig$sslManager$1 extends Lambda implements Function1<HttpsURLConnection, Unit> {
    public static final AndroidEngineConfig$sslManager$1 INSTANCE = new AndroidEngineConfig$sslManager$1();

    public AndroidEngineConfig$sslManager$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(HttpsURLConnection httpsURLConnection) {
        HttpsURLConnection it = httpsURLConnection;
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
