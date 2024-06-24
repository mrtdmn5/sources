package com.amplifyframework.storage;

import com.animaconnected.secondo.R;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: ObjectMetadata.kt */
/* loaded from: classes.dex */
public final class ObjectMetadata {
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_MD5 = "Content-MD5";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final Companion Companion = new Companion(null);
    public static final String REDIRECT_LOCATION = "x-amz-website-redirect-location";
    public static final String REQUESTER_PAYS_HEADER = "x-amz-request-payer";
    public static final String S3_TAGGING = "x-amz-tagging";
    public static final String SERVER_SIDE_ENCRYPTION = "x-amz-server-side-encryption";
    public static final String SERVER_SIDE_ENCRYPTION_KMS_KEY_ID = "x-amz-server-side-encryption-aws-kms-key-id";
    public static final String STORAGE_CLASS = "x-amz-storage-class";
    private Date expirationTime;
    private String expirationTimeRuleId;
    private Date httpExpiresDate;
    private Map<String, Object> metaData;
    private Boolean ongoingRestore;
    private Date restoreExpirationTime;
    private Map<String, String> userMetadata;

    /* compiled from: ObjectMetadata.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ObjectMetadata() {
        this(null, null, null, null, null, null, null, R.styleable.AppTheme_statusTextH5, null);
    }

    public static /* synthetic */ ObjectMetadata copy$default(ObjectMetadata objectMetadata, Map map, Map map2, Date date, Date date2, String str, Boolean bool, Date date3, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            map = objectMetadata.userMetadata;
        }
        if ((r13 & 2) != 0) {
            map2 = objectMetadata.metaData;
        }
        Map map3 = map2;
        if ((r13 & 4) != 0) {
            date = objectMetadata.httpExpiresDate;
        }
        Date date4 = date;
        if ((r13 & 8) != 0) {
            date2 = objectMetadata.expirationTime;
        }
        Date date5 = date2;
        if ((r13 & 16) != 0) {
            str = objectMetadata.expirationTimeRuleId;
        }
        String str2 = str;
        if ((r13 & 32) != 0) {
            bool = objectMetadata.ongoingRestore;
        }
        Boolean bool2 = bool;
        if ((r13 & 64) != 0) {
            date3 = objectMetadata.restoreExpirationTime;
        }
        return objectMetadata.copy(map, map3, date4, date5, str2, bool2, date3);
    }

    public final Map<String, String> component1() {
        return this.userMetadata;
    }

    public final Map<String, Object> component2() {
        return this.metaData;
    }

    public final Date component3() {
        return this.httpExpiresDate;
    }

    public final Date component4() {
        return this.expirationTime;
    }

    public final String component5() {
        return this.expirationTimeRuleId;
    }

    public final Boolean component6() {
        return this.ongoingRestore;
    }

    public final Date component7() {
        return this.restoreExpirationTime;
    }

    public final ObjectMetadata copy(Map<String, String> userMetadata, Map<String, Object> metaData, Date date, Date date2, String str, Boolean bool, Date date3) {
        Intrinsics.checkNotNullParameter(userMetadata, "userMetadata");
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        return new ObjectMetadata(userMetadata, metaData, date, date2, str, bool, date3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObjectMetadata)) {
            return false;
        }
        ObjectMetadata objectMetadata = (ObjectMetadata) obj;
        if (Intrinsics.areEqual(this.userMetadata, objectMetadata.userMetadata) && Intrinsics.areEqual(this.metaData, objectMetadata.metaData) && Intrinsics.areEqual(this.httpExpiresDate, objectMetadata.httpExpiresDate) && Intrinsics.areEqual(this.expirationTime, objectMetadata.expirationTime) && Intrinsics.areEqual(this.expirationTimeRuleId, objectMetadata.expirationTimeRuleId) && Intrinsics.areEqual(this.ongoingRestore, objectMetadata.ongoingRestore) && Intrinsics.areEqual(this.restoreExpirationTime, objectMetadata.restoreExpirationTime)) {
            return true;
        }
        return false;
    }

    public final Date getExpirationTime() {
        return this.expirationTime;
    }

    public final String getExpirationTimeRuleId() {
        return this.expirationTimeRuleId;
    }

    public final Date getHttpExpiresDate() {
        return this.httpExpiresDate;
    }

    public final Map<String, Object> getMetaData() {
        return this.metaData;
    }

    public final Boolean getOngoingRestore() {
        return this.ongoingRestore;
    }

    public final Date getRestoreExpirationTime() {
        return this.restoreExpirationTime;
    }

    public final Map<String, String> getUserMetadata() {
        return this.userMetadata;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = (this.metaData.hashCode() + (this.userMetadata.hashCode() * 31)) * 31;
        Date date = this.httpExpiresDate;
        int r2 = 0;
        if (date == null) {
            hashCode = 0;
        } else {
            hashCode = date.hashCode();
        }
        int r1 = (hashCode5 + hashCode) * 31;
        Date date2 = this.expirationTime;
        if (date2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = date2.hashCode();
        }
        int r12 = (r1 + hashCode2) * 31;
        String str = this.expirationTimeRuleId;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int r13 = (r12 + hashCode3) * 31;
        Boolean bool = this.ongoingRestore;
        if (bool == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bool.hashCode();
        }
        int r14 = (r13 + hashCode4) * 31;
        Date date3 = this.restoreExpirationTime;
        if (date3 != null) {
            r2 = date3.hashCode();
        }
        return r14 + r2;
    }

    public final void setExpirationTime(Date date) {
        this.expirationTime = date;
    }

    public final void setExpirationTimeRuleId(String str) {
        this.expirationTimeRuleId = str;
    }

    public final void setHttpExpiresDate(Date date) {
        this.httpExpiresDate = date;
    }

    public final void setMetaData(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.metaData = map;
    }

    public final void setOngoingRestore(Boolean bool) {
        this.ongoingRestore = bool;
    }

    public final void setRestoreExpirationTime(Date date) {
        this.restoreExpirationTime = date;
    }

    public final void setUserMetadata(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.userMetadata = map;
    }

    public String toString() {
        return "ObjectMetadata(userMetadata=" + this.userMetadata + ", metaData=" + this.metaData + ", httpExpiresDate=" + this.httpExpiresDate + ", expirationTime=" + this.expirationTime + ", expirationTimeRuleId=" + this.expirationTimeRuleId + ", ongoingRestore=" + this.ongoingRestore + ", restoreExpirationTime=" + this.restoreExpirationTime + ')';
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ObjectMetadata(Map<String, String> userMetadata) {
        this(userMetadata, null, null, null, null, null, null, 126, null);
        Intrinsics.checkNotNullParameter(userMetadata, "userMetadata");
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ObjectMetadata(Map<String, String> userMetadata, Map<String, Object> metaData) {
        this(userMetadata, metaData, null, null, null, null, null, 124, null);
        Intrinsics.checkNotNullParameter(userMetadata, "userMetadata");
        Intrinsics.checkNotNullParameter(metaData, "metaData");
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ObjectMetadata(Map<String, String> userMetadata, Map<String, Object> metaData, Date date) {
        this(userMetadata, metaData, date, null, null, null, null, 120, null);
        Intrinsics.checkNotNullParameter(userMetadata, "userMetadata");
        Intrinsics.checkNotNullParameter(metaData, "metaData");
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ObjectMetadata(Map<String, String> userMetadata, Map<String, Object> metaData, Date date, Date date2) {
        this(userMetadata, metaData, date, date2, null, null, null, 112, null);
        Intrinsics.checkNotNullParameter(userMetadata, "userMetadata");
        Intrinsics.checkNotNullParameter(metaData, "metaData");
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ObjectMetadata(Map<String, String> userMetadata, Map<String, Object> metaData, Date date, Date date2, String str) {
        this(userMetadata, metaData, date, date2, str, null, null, 96, null);
        Intrinsics.checkNotNullParameter(userMetadata, "userMetadata");
        Intrinsics.checkNotNullParameter(metaData, "metaData");
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ObjectMetadata(Map<String, String> userMetadata, Map<String, Object> metaData, Date date, Date date2, String str, Boolean bool) {
        this(userMetadata, metaData, date, date2, str, bool, null, 64, null);
        Intrinsics.checkNotNullParameter(userMetadata, "userMetadata");
        Intrinsics.checkNotNullParameter(metaData, "metaData");
    }

    public ObjectMetadata(Map<String, String> userMetadata, Map<String, Object> metaData, Date date, Date date2, String str, Boolean bool, Date date3) {
        Intrinsics.checkNotNullParameter(userMetadata, "userMetadata");
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        this.userMetadata = userMetadata;
        this.metaData = metaData;
        this.httpExpiresDate = date;
        this.expirationTime = date2;
        this.expirationTimeRuleId = str;
        this.ongoingRestore = bool;
        this.restoreExpirationTime = date3;
    }

    public /* synthetic */ ObjectMetadata(Map map, Map map2, Date date, Date date2, String str, Boolean bool, Date date3, int r16, DefaultConstructorMarker defaultConstructorMarker) {
        this((r16 & 1) != 0 ? new TreeMap(StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER()) : map, (r16 & 2) != 0 ? new TreeMap(StringsKt__StringsJVMKt.getCASE_INSENSITIVE_ORDER()) : map2, (r16 & 4) != 0 ? null : date, (r16 & 8) != 0 ? null : date2, (r16 & 16) != 0 ? null : str, (r16 & 32) != 0 ? Boolean.FALSE : bool, (r16 & 64) == 0 ? date3 : null);
    }
}
