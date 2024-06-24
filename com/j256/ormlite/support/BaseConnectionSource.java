package com.j256.ormlite.support;

import com.j256.ormlite.android.AndroidDatabaseConnection;

/* loaded from: classes3.dex */
public abstract class BaseConnectionSource implements ConnectionSource {
    public final ThreadLocal<NestedConnection> specialConnection = new ThreadLocal<>();

    /* loaded from: classes3.dex */
    public static class NestedConnection {
        public final DatabaseConnection connection;
        public int nestedC = 1;

        public NestedConnection(AndroidDatabaseConnection androidDatabaseConnection) {
            this.connection = androidDatabaseConnection;
        }
    }
}
