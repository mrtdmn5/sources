package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
public interface MessageInfoFactory {
    boolean isSupported(Class<?> cls);

    MessageInfo messageInfoFor(Class<?> cls);
}
