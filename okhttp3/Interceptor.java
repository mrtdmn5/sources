package okhttp3;

import java.io.IOException;
import okhttp3.internal.http.RealInterceptorChain;

/* compiled from: Interceptor.kt */
/* loaded from: classes4.dex */
public interface Interceptor {
    Response intercept(RealInterceptorChain realInterceptorChain) throws IOException;
}
