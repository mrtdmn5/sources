package com.amazonaws.mobileconnectors.lambdainvoker;

/* loaded from: classes.dex */
public interface LambdaDataBinder {
    <T> T deserialize(byte[] bArr, Class<T> cls);

    byte[] serialize(Object obj);
}
