package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class FirebaseOptions {
    public final String apiKey;
    public final String applicationId;
    public final String databaseUrl;
    public final String gaTrackingId;
    public final String gcmSenderId;
    public final String projectId;
    public final String storageBucket;

    public FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkState("ApplicationId must be set.", !Strings.isEmptyOrWhitespace(str));
        this.applicationId = str;
        this.apiKey = str2;
        this.databaseUrl = str3;
        this.gaTrackingId = str4;
        this.gcmSenderId = str5;
        this.storageBucket = str6;
        this.projectId = str7;
    }

    public static FirebaseOptions fromResource(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        if (!Objects.equal(this.applicationId, firebaseOptions.applicationId) || !Objects.equal(this.apiKey, firebaseOptions.apiKey) || !Objects.equal(this.databaseUrl, firebaseOptions.databaseUrl) || !Objects.equal(this.gaTrackingId, firebaseOptions.gaTrackingId) || !Objects.equal(this.gcmSenderId, firebaseOptions.gcmSenderId) || !Objects.equal(this.storageBucket, firebaseOptions.storageBucket) || !Objects.equal(this.projectId, firebaseOptions.projectId)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId});
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(this.applicationId, "applicationId");
        toStringHelper.add(this.apiKey, "apiKey");
        toStringHelper.add(this.databaseUrl, "databaseUrl");
        toStringHelper.add(this.gcmSenderId, "gcmSenderId");
        toStringHelper.add(this.storageBucket, "storageBucket");
        toStringHelper.add(this.projectId, "projectId");
        return toStringHelper.toString();
    }
}
