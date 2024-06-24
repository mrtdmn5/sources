package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;

/* loaded from: classes3.dex */
public final class NullArgHolder implements ArgumentHolder {
    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public final FieldType getFieldType() {
        return null;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public final Object getSqlArgValue() {
        return null;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public final SqlType getSqlType() {
        return SqlType.STRING;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public final void setMetaInfo(FieldType fieldType, String str) {
    }
}
