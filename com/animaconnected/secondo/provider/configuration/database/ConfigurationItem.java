package com.animaconnected.secondo.provider.configuration.database;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "configurationItems")
/* loaded from: classes3.dex */
public class ConfigurationItem {
    public static final String COLUMN_NAME_CATEGORY = "subType";
    public static final String COLUMN_NAME_EXTERNAL_ID = "externalId";
    public static final String COLUMN_NAME_GROUP = "group";
    public static final String COLUMN_NAME_GROUP_PRIORITY = "groupPriority";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_TYPE = "type";

    @SerializedName("category")
    @DatabaseField(columnName = COLUMN_NAME_CATEGORY)
    int mCategory;

    @SerializedName(COLUMN_NAME_EXTERNAL_ID)
    @DatabaseField(columnName = COLUMN_NAME_EXTERNAL_ID)
    String mExternalId;

    @SerializedName(COLUMN_NAME_GROUP)
    @DatabaseField(columnName = COLUMN_NAME_GROUP)
    int mGroup;

    @SerializedName(COLUMN_NAME_GROUP_PRIORITY)
    @DatabaseField(columnName = COLUMN_NAME_GROUP_PRIORITY)
    int mGroupPriority;

    @SerializedName(COLUMN_NAME_ID)
    @DatabaseField(columnName = COLUMN_NAME_ID, generatedId = true)
    int mId;

    @SerializedName("type")
    @DatabaseField(columnName = "type")
    int mType;

    public ConfigurationItem() {
    }

    public int getCategory() {
        return this.mCategory;
    }

    public String getExternalId() {
        return this.mExternalId;
    }

    public int getGroup() {
        return this.mGroup;
    }

    public int getGroupPriority() {
        return this.mGroupPriority;
    }

    public int getId() {
        return this.mId;
    }

    public int getType() {
        return this.mType;
    }

    public void setExternalId(String str) {
        this.mExternalId = str;
    }

    public void setGroup(int r1) {
        this.mGroup = r1;
    }

    public void setGroupPriority(int r1) {
        this.mGroupPriority = r1;
    }

    public void setType(int r1) {
        this.mType = r1;
    }

    public ConfigurationItem(int r1, int r2, String str, int r4, int r5) {
        this.mType = r1;
        this.mCategory = r2;
        this.mExternalId = str;
        this.mGroup = r4;
        this.mGroupPriority = r5;
    }
}
