package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes3.dex */
public final class ByteType extends ByteObjectType {
    public static final ByteType singleTon = new ByteType();

    public ByteType() {
        super(SqlType.BYTE, new Class[]{Byte.TYPE});
    }
}
