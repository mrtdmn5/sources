package com.animaconnected.info;

import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayBuilder.kt */
/* loaded from: classes.dex */
public final class ByteArrayBuilderKt {
    public static final byte[] byteArrayBuilder(Function1<? super ByteArrayBuilder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        init.invoke(byteArrayBuilder);
        return CollectionsKt___CollectionsKt.toByteArray(byteArrayBuilder.getBytes());
    }

    public static final <T> T reader(byte[] bArr, Function1<? super ByteArrayReader, ? extends T> read) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(read, "read");
        return read.invoke(new ByteArrayReader(bArr, 0, 2, null));
    }
}
