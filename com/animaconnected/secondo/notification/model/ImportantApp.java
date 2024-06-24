package com.animaconnected.secondo.notification.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = ImportantApp.TABLE_NAME_IMPORTANT_APP)
/* loaded from: classes3.dex */
public class ImportantApp {
    public static final String FIELD_NAME_APP_NAME = "app_name";
    public static final String FIELD_NAME_PACKAGE = "package";
    public static final String TABLE_NAME_IMPORTANT_APP = "important_apps";

    @DatabaseField(columnName = FIELD_NAME_APP_NAME)
    private String mAppName;

    @DatabaseField(columnName = "package", id = true)
    private String mPackageName;

    public ImportantApp() {
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public ImportantApp setAppName(String str) {
        this.mAppName = str;
        return this;
    }

    public ImportantApp setPackageName(String str) {
        this.mPackageName = str;
        return this;
    }

    public ImportantApp(String str, String str2) {
        this.mPackageName = str2;
        this.mAppName = str;
    }
}
