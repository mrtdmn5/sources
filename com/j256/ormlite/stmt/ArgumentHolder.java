package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public interface ArgumentHolder {
    FieldType getFieldType();

    Object getSqlArgValue() throws SQLException;

    SqlType getSqlType();

    void setMetaInfo(FieldType fieldType, String str);
}
