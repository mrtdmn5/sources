package okhttp3.internal.http;

import okhttp3.Interceptor;

/* compiled from: CallServerInterceptor.kt */
/* loaded from: classes4.dex */
public final class CallServerInterceptor implements Interceptor {
    public final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f9 A[Catch: IOException -> 0x0193, TryCatch #3 {IOException -> 0x0193, blocks: (B:74:0x00c7, B:76:0x00d0, B:27:0x00d4, B:33:0x00f9, B:35:0x0103, B:36:0x0106, B:37:0x011e), top: B:73:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a0  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okhttp3.Response intercept(okhttp3.internal.http.RealInterceptorChain r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.internal.http.RealInterceptorChain):okhttp3.Response");
    }
}
