package com.polidea.rxandroidble2.internal.util;

import io.reactivex.functions.Function;

/* loaded from: classes3.dex */
public final class ByteAssociationUtil$2 implements Function<ByteAssociation<?>, byte[]> {
    @Override // io.reactivex.functions.Function
    public final byte[] apply(ByteAssociation<?> byteAssociation) throws Exception {
        return byteAssociation.second;
    }
}
