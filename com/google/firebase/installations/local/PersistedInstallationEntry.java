package com.google.firebase.installations.local;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

@AutoValue
/* loaded from: classes3.dex */
public abstract class PersistedInstallationEntry {
    public static final /* synthetic */ int $r8$clinit = 0;

    @AutoValue.Builder
    /* loaded from: classes3.dex */
    public static abstract class Builder {
    }

    static {
        AutoValue_PersistedInstallationEntry.Builder builder = new AutoValue_PersistedInstallationEntry.Builder();
        builder.tokenCreationEpochInSecs = 0L;
        builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION);
        builder.expiresInSecs = 0L;
        builder.build();
    }

    public abstract String getAuthToken();

    public abstract long getExpiresInSecs();

    public abstract String getFirebaseInstallationId();

    public abstract String getFisError();

    public abstract String getRefreshToken();

    public abstract PersistedInstallation.RegistrationStatus getRegistrationStatus();

    public abstract long getTokenCreationEpochInSecs();
}
