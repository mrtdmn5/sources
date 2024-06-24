package io.ktor.utils.io.jvm.javaio;

/* compiled from: Pollers.kt */
/* loaded from: classes3.dex */
public interface Parking<T> {
    void park(long j);

    void unpark(T t);
}
