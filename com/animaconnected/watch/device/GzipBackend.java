package com.animaconnected.watch.device;

import kotlin.coroutines.Continuation;

/* compiled from: GzipBackend.kt */
/* loaded from: classes3.dex */
public interface GzipBackend {
    Object compress(String str, Continuation<? super byte[]> continuation);

    Object decompress(byte[] bArr, Continuation<? super String> continuation);
}
