package okhttp3;

import java.io.IOException;
import okhttp3.internal.connection.RealCall;

/* compiled from: Callback.kt */
/* loaded from: classes4.dex */
public interface Callback {
    void onFailure(RealCall realCall, IOException iOException);

    void onResponse(RealCall realCall, Response response) throws IOException;
}
