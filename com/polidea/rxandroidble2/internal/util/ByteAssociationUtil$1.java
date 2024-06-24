package com.polidea.rxandroidble2.internal.util;

import io.reactivex.functions.Predicate;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class ByteAssociationUtil$1 implements Predicate<ByteAssociation<UUID>> {
    public final /* synthetic */ UUID val$characteristicUUID;

    public ByteAssociationUtil$1(UUID r1) {
        this.val$characteristicUUID = r1;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(ByteAssociation<UUID> byteAssociation) throws Exception {
        return byteAssociation.first.equals(this.val$characteristicUUID);
    }
}
