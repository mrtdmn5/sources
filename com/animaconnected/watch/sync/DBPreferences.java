package com.animaconnected.watch.sync;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import app.cash.sqldelight.ColumnAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBPreferences.kt */
/* loaded from: classes3.dex */
public final class DBPreferences {
    private final String identifier;
    private final int preferenceId;
    private final String value_;

    /* compiled from: DBPreferences.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> preferenceIdAdapter;

        public Adapter(ColumnAdapter<Integer, Long> preferenceIdAdapter) {
            Intrinsics.checkNotNullParameter(preferenceIdAdapter, "preferenceIdAdapter");
            this.preferenceIdAdapter = preferenceIdAdapter;
        }

        public final ColumnAdapter<Integer, Long> getPreferenceIdAdapter() {
            return this.preferenceIdAdapter;
        }
    }

    public DBPreferences(String identifier, int r3, String str) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
        this.preferenceId = r3;
        this.value_ = str;
    }

    public static /* synthetic */ DBPreferences copy$default(DBPreferences dBPreferences, String str, int r2, String str2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = dBPreferences.identifier;
        }
        if ((r4 & 2) != 0) {
            r2 = dBPreferences.preferenceId;
        }
        if ((r4 & 4) != 0) {
            str2 = dBPreferences.value_;
        }
        return dBPreferences.copy(str, r2, str2);
    }

    public final String component1() {
        return this.identifier;
    }

    public final int component2() {
        return this.preferenceId;
    }

    public final String component3() {
        return this.value_;
    }

    public final DBPreferences copy(String identifier, int r3, String str) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return new DBPreferences(identifier, r3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBPreferences)) {
            return false;
        }
        DBPreferences dBPreferences = (DBPreferences) obj;
        if (Intrinsics.areEqual(this.identifier, dBPreferences.identifier) && this.preferenceId == dBPreferences.preferenceId && Intrinsics.areEqual(this.value_, dBPreferences.value_)) {
            return true;
        }
        return false;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final int getPreferenceId() {
        return this.preferenceId;
    }

    public final String getValue_() {
        return this.value_;
    }

    public int hashCode() {
        int hashCode;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.preferenceId, this.identifier.hashCode() * 31, 31);
        String str = this.value_;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return m + hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBPreferences(identifier=");
        sb.append(this.identifier);
        sb.append(", preferenceId=");
        sb.append(this.preferenceId);
        sb.append(", value_=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.value_, ')');
    }
}
