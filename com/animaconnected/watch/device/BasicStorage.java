package com.animaconnected.watch.device;

/* compiled from: BasicStorage.kt */
/* loaded from: classes3.dex */
public interface BasicStorage {
    void clear();

    boolean contains(String str);

    Boolean getBoolean(String str);

    byte[] getBytes(String str);

    Float getFloat(String str);

    Integer getInt(String str);

    Long getLong(String str);

    String getString(String str);

    void put(String str, float f);

    void put(String str, int r2);

    void put(String str, long j);

    void put(String str, String str2);

    void put(String str, boolean z);

    void put(String str, byte[] bArr);

    void remove(String str);
}
