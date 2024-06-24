package io.ktor.client.engine.android;

import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.util.date.GMTDate;
import java.net.HttpURLConnection;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: AndroidClientEngine.kt */
/* loaded from: classes3.dex */
public final class AndroidClientEngine$execute$2 extends Lambda implements Function1<HttpURLConnection, HttpResponseData> {
    public final /* synthetic */ CoroutineContext $callContext;
    public final /* synthetic */ HttpRequestData $data;
    public final /* synthetic */ GMTDate $requestTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidClientEngine$execute$2(CoroutineContext coroutineContext, HttpRequestData httpRequestData, GMTDate gMTDate) {
        super(1);
        this.$callContext = coroutineContext;
        this.$data = httpRequestData;
        this.$requestTime = gMTDate;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0114  */
    /* JADX WARN: Type inference failed for: r6v7, types: [io.ktor.client.network.sockets.TimeoutExceptionsKt$ByteChannelWithMappedExceptions$1] */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final io.ktor.client.request.HttpResponseData invoke(java.net.HttpURLConnection r11) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.android.AndroidClientEngine$execute$2.invoke(java.lang.Object):java.lang.Object");
    }
}
