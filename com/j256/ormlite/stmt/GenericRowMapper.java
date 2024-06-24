package com.j256.ormlite.stmt;

import com.j256.ormlite.android.AndroidDatabaseResults;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public interface GenericRowMapper<T> {
    Object mapRow(AndroidDatabaseResults androidDatabaseResults) throws SQLException;
}
