package com.j256.ormlite.misc;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class IOUtils {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void closeThrowSqlException(Closeable closeable, String str) throws SQLException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw SupervisorKt.create("could not close ".concat(str), e);
            }
        }
    }
}
