package com.animaconnected.watch.filter;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBAncsFilter.kt */
/* loaded from: classes3.dex */
public final class DBAncsFilter {
    private final Long ancs_attribute;
    private final Long ancs_category;
    private final String identifier;
    private final long idx;
    private final Long linked_filter_index;
    private final Long match_method;
    private final String search_string;
    private final Long vibration_pattern;

    public DBAncsFilter(String identifier, long j, Long l, Long l2, String str, Long l3, Long l4, Long l5) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
        this.idx = j;
        this.ancs_category = l;
        this.ancs_attribute = l2;
        this.search_string = str;
        this.vibration_pattern = l3;
        this.linked_filter_index = l4;
        this.match_method = l5;
    }

    public static /* synthetic */ DBAncsFilter copy$default(DBAncsFilter dBAncsFilter, String str, long j, Long l, Long l2, String str2, Long l3, Long l4, Long l5, int r20, Object obj) {
        String str3;
        long j2;
        Long l6;
        Long l7;
        String str4;
        Long l8;
        Long l9;
        Long l10;
        if ((r20 & 1) != 0) {
            str3 = dBAncsFilter.identifier;
        } else {
            str3 = str;
        }
        if ((r20 & 2) != 0) {
            j2 = dBAncsFilter.idx;
        } else {
            j2 = j;
        }
        if ((r20 & 4) != 0) {
            l6 = dBAncsFilter.ancs_category;
        } else {
            l6 = l;
        }
        if ((r20 & 8) != 0) {
            l7 = dBAncsFilter.ancs_attribute;
        } else {
            l7 = l2;
        }
        if ((r20 & 16) != 0) {
            str4 = dBAncsFilter.search_string;
        } else {
            str4 = str2;
        }
        if ((r20 & 32) != 0) {
            l8 = dBAncsFilter.vibration_pattern;
        } else {
            l8 = l3;
        }
        if ((r20 & 64) != 0) {
            l9 = dBAncsFilter.linked_filter_index;
        } else {
            l9 = l4;
        }
        if ((r20 & 128) != 0) {
            l10 = dBAncsFilter.match_method;
        } else {
            l10 = l5;
        }
        return dBAncsFilter.copy(str3, j2, l6, l7, str4, l8, l9, l10);
    }

    public final String component1() {
        return this.identifier;
    }

    public final long component2() {
        return this.idx;
    }

    public final Long component3() {
        return this.ancs_category;
    }

    public final Long component4() {
        return this.ancs_attribute;
    }

    public final String component5() {
        return this.search_string;
    }

    public final Long component6() {
        return this.vibration_pattern;
    }

    public final Long component7() {
        return this.linked_filter_index;
    }

    public final Long component8() {
        return this.match_method;
    }

    public final DBAncsFilter copy(String identifier, long j, Long l, Long l2, String str, Long l3, Long l4, Long l5) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return new DBAncsFilter(identifier, j, l, l2, str, l3, l4, l5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBAncsFilter)) {
            return false;
        }
        DBAncsFilter dBAncsFilter = (DBAncsFilter) obj;
        if (Intrinsics.areEqual(this.identifier, dBAncsFilter.identifier) && this.idx == dBAncsFilter.idx && Intrinsics.areEqual(this.ancs_category, dBAncsFilter.ancs_category) && Intrinsics.areEqual(this.ancs_attribute, dBAncsFilter.ancs_attribute) && Intrinsics.areEqual(this.search_string, dBAncsFilter.search_string) && Intrinsics.areEqual(this.vibration_pattern, dBAncsFilter.vibration_pattern) && Intrinsics.areEqual(this.linked_filter_index, dBAncsFilter.linked_filter_index) && Intrinsics.areEqual(this.match_method, dBAncsFilter.match_method)) {
            return true;
        }
        return false;
    }

    public final Long getAncs_attribute() {
        return this.ancs_attribute;
    }

    public final Long getAncs_category() {
        return this.ancs_category;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final long getIdx() {
        return this.idx;
    }

    public final Long getLinked_filter_index() {
        return this.linked_filter_index;
    }

    public final Long getMatch_method() {
        return this.match_method;
    }

    public final String getSearch_string() {
        return this.search_string;
    }

    public final Long getVibration_pattern() {
        return this.vibration_pattern;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int m = Scale$$ExternalSyntheticOutline0.m(this.idx, this.identifier.hashCode() * 31, 31);
        Long l = this.ancs_category;
        int r2 = 0;
        if (l == null) {
            hashCode = 0;
        } else {
            hashCode = l.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Long l2 = this.ancs_attribute;
        if (l2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = l2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        String str = this.search_string;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Long l3 = this.vibration_pattern;
        if (l3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = l3.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        Long l4 = this.linked_filter_index;
        if (l4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = l4.hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        Long l5 = this.match_method;
        if (l5 != null) {
            r2 = l5.hashCode();
        }
        return r05 + r2;
    }

    public String toString() {
        return "DBAncsFilter(identifier=" + this.identifier + ", idx=" + this.idx + ", ancs_category=" + this.ancs_category + ", ancs_attribute=" + this.ancs_attribute + ", search_string=" + this.search_string + ", vibration_pattern=" + this.vibration_pattern + ", linked_filter_index=" + this.linked_filter_index + ", match_method=" + this.match_method + ')';
    }
}
