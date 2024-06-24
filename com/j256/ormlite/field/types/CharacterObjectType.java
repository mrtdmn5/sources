package com.j256.ormlite.field.types;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class CharacterObjectType extends BaseDataType {
    public static final CharacterObjectType singleTon = new CharacterObjectType();

    public CharacterObjectType() {
        super(SqlType.CHAR, new Class[]{Character.class});
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new SQLException("Problems with field " + fieldType + ", default string to long for Character: '" + str + "'");
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return Character.valueOf(androidDatabaseResults.getChar(r2));
    }
}
