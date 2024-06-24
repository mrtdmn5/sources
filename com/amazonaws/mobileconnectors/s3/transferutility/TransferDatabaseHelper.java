package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
class TransferDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "awss3transfertable.db";
    private static final int DATABASE_VERSION = 6;
    private final Context context;
    private int version;

    public TransferDatabaseHelper(Context context) {
        this(context, 6);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        TransferTable.onCreate(sQLiteDatabase, this.version);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int r2, int r3) {
        this.context.deleteDatabase(DATABASE_NAME);
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int r2, int r3) {
        TransferTable.onUpgrade(sQLiteDatabase, r2, r3);
    }

    public TransferDatabaseHelper(Context context, int r4) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, r4);
        this.context = context;
        this.version = r4;
    }
}
