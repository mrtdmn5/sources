package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* loaded from: classes3.dex */
public interface LazyStringList extends List {
    void add(ByteString byteString);

    Object getRaw(int r1);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();
}
