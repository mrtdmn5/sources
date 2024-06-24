package okhttp3;

import okhttp3.internal.connection.RealCall;

/* compiled from: Call.kt */
/* loaded from: classes4.dex */
public interface Call extends Cloneable {

    /* compiled from: Call.kt */
    /* loaded from: classes4.dex */
    public interface Factory {
        RealCall newCall(Request request);
    }

    void cancel();

    void enqueue(Callback callback);

    boolean isCanceled();

    Request request();
}
