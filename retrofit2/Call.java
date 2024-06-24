package retrofit2;

import okhttp3.Request;

/* loaded from: classes4.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    /* renamed from: clone */
    Call<T> mo1739clone();

    void enqueue(Callback<T> callback);

    boolean isCanceled();

    Request request();
}
