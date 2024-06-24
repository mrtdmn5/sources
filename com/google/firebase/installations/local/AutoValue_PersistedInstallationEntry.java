package com.google.firebase.installations.local;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* loaded from: classes3.dex */
public final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {
    public final String authToken;
    public final long expiresInSecs;
    public final String firebaseInstallationId;
    public final String fisError;
    public final String refreshToken;
    public final PersistedInstallation.RegistrationStatus registrationStatus;
    public final long tokenCreationEpochInSecs;

    /* loaded from: classes3.dex */
    public static final class Builder extends PersistedInstallationEntry.Builder {
        public String authToken;
        public Long expiresInSecs;
        public String firebaseInstallationId;
        public String fisError;
        public String refreshToken;
        public PersistedInstallation.RegistrationStatus registrationStatus;
        public Long tokenCreationEpochInSecs;

        public Builder(PersistedInstallationEntry persistedInstallationEntry) {
            this.firebaseInstallationId = persistedInstallationEntry.getFirebaseInstallationId();
            this.registrationStatus = persistedInstallationEntry.getRegistrationStatus();
            this.authToken = persistedInstallationEntry.getAuthToken();
            this.refreshToken = persistedInstallationEntry.getRefreshToken();
            this.expiresInSecs = Long.valueOf(persistedInstallationEntry.getExpiresInSecs());
            this.tokenCreationEpochInSecs = Long.valueOf(persistedInstallationEntry.getTokenCreationEpochInSecs());
            this.fisError = persistedInstallationEntry.getFisError();
        }

        public final AutoValue_PersistedInstallationEntry build() {
            String str;
            if (this.registrationStatus == null) {
                str = " registrationStatus";
            } else {
                str = "";
            }
            if (this.expiresInSecs == null) {
                str = str.concat(" expiresInSecs");
            }
            if (this.tokenCreationEpochInSecs == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " tokenCreationEpochInSecs");
            }
            if (str.isEmpty()) {
                return new AutoValue_PersistedInstallationEntry(this.firebaseInstallationId, this.registrationStatus, this.authToken, this.refreshToken, this.expiresInSecs.longValue(), this.tokenCreationEpochInSecs.longValue(), this.fisError);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public final Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus != null) {
                this.registrationStatus = registrationStatus;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }
    }

    public AutoValue_PersistedInstallationEntry(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j, long j2, String str4) {
        this.firebaseInstallationId = str;
        this.registrationStatus = registrationStatus;
        this.authToken = str2;
        this.refreshToken = str3;
        this.expiresInSecs = j;
        this.tokenCreationEpochInSecs = j2;
        this.fisError = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.firebaseInstallationId;
        if (str3 != null ? str3.equals(persistedInstallationEntry.getFirebaseInstallationId()) : persistedInstallationEntry.getFirebaseInstallationId() == null) {
            if (this.registrationStatus.equals(persistedInstallationEntry.getRegistrationStatus()) && ((str = this.authToken) != null ? str.equals(persistedInstallationEntry.getAuthToken()) : persistedInstallationEntry.getAuthToken() == null) && ((str2 = this.refreshToken) != null ? str2.equals(persistedInstallationEntry.getRefreshToken()) : persistedInstallationEntry.getRefreshToken() == null) && this.expiresInSecs == persistedInstallationEntry.getExpiresInSecs() && this.tokenCreationEpochInSecs == persistedInstallationEntry.getTokenCreationEpochInSecs()) {
                String str4 = this.fisError;
                if (str4 == null) {
                    if (persistedInstallationEntry.getFisError() == null) {
                        return true;
                    }
                } else if (str4.equals(persistedInstallationEntry.getFisError())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String getAuthToken() {
        return this.authToken;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final long getExpiresInSecs() {
        return this.expiresInSecs;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String getFisError() {
        return this.fisError;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final PersistedInstallation.RegistrationStatus getRegistrationStatus() {
        return this.registrationStatus;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public final long getTokenCreationEpochInSecs() {
        return this.tokenCreationEpochInSecs;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r0 = 0;
        String str = this.firebaseInstallationId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode4 = (((hashCode ^ 1000003) * 1000003) ^ this.registrationStatus.hashCode()) * 1000003;
        String str2 = this.authToken;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int r1 = (hashCode4 ^ hashCode2) * 1000003;
        String str3 = this.refreshToken;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int r12 = (r1 ^ hashCode3) * 1000003;
        long j = this.expiresInSecs;
        int r13 = (r12 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.tokenCreationEpochInSecs;
        int r14 = (r13 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.fisError;
        if (str4 != null) {
            r0 = str4.hashCode();
        }
        return r0 ^ r14;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb.append(this.firebaseInstallationId);
        sb.append(", registrationStatus=");
        sb.append(this.registrationStatus);
        sb.append(", authToken=");
        sb.append(this.authToken);
        sb.append(", refreshToken=");
        sb.append(this.refreshToken);
        sb.append(", expiresInSecs=");
        sb.append(this.expiresInSecs);
        sb.append(", tokenCreationEpochInSecs=");
        sb.append(this.tokenCreationEpochInSecs);
        sb.append(", fisError=");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.fisError, "}");
    }
}
