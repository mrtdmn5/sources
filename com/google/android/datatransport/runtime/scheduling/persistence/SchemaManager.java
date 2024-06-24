package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public final class SchemaManager extends SQLiteOpenHelper {
    public boolean configured;
    public final int schemaVersion;
    public static final String CREATE_INITIAL_GLOBAL_LOG_EVENT_STATE_VALUE_SQL = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";
    public static final int SCHEMA_VERSION = 5;
    public static final List<Migration> INCREMENTAL_MIGRATIONS = Arrays.asList(new SchemaManager$$ExternalSyntheticLambda0(), new SchemaManager$$ExternalSyntheticLambda1(), new SchemaManager$$ExternalSyntheticLambda2(), new SchemaManager$$ExternalSyntheticLambda3(), new SchemaManager$$ExternalSyntheticLambda4());

    /* loaded from: classes3.dex */
    public interface Migration {
        void upgrade(SQLiteDatabase sQLiteDatabase);
    }

    public SchemaManager(Context context, String str, int r4) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, r4);
        this.configured = false;
        this.schemaVersion = r4;
    }

    public static void upgrade(SQLiteDatabase sQLiteDatabase, int r5, int r6) {
        List<Migration> list = INCREMENTAL_MIGRATIONS;
        if (r6 <= list.size()) {
            while (r5 < r6) {
                list.get(r5).upgrade(sQLiteDatabase);
                r5++;
            }
        } else {
            StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Migration from ", r5, " to ", r6, " was requested, but cannot be performed. Only ");
            m.append(list.size());
            m.append(" migrations are provided");
            throw new IllegalArgumentException(m.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.configured = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
        upgrade(sQLiteDatabase, 0, this.schemaVersion);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int r2, int r3) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
        upgrade(sQLiteDatabase, 0, r3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int r3, int r4) {
        if (!this.configured) {
            onConfigure(sQLiteDatabase);
        }
        upgrade(sQLiteDatabase, r3, r4);
    }
}
