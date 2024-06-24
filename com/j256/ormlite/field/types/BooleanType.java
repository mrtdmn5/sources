package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes3.dex */
public class BooleanType extends BooleanObjectType {
    public static final BooleanType singleTon = new BooleanType();

    public BooleanType() {
        super(SqlType.BOOLEAN, new Class[]{Boolean.TYPE});
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isPrimitive() {
        return true;
    }
}
