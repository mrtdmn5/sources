package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzcb;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class Utils {
    public static Utils singleton;
    public final zzcb clock;
    public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = TimeUnit.HOURS.toSeconds(1);
    public static final Pattern API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");

    public Utils(zzcb zzcbVar) {
        this.clock = zzcbVar;
    }

    public final boolean isAuthTokenExpired(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        if (TextUtils.isEmpty(autoValue_PersistedInstallationEntry.authToken)) {
            return true;
        }
        long j = autoValue_PersistedInstallationEntry.expiresInSecs + autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.clock.getClass();
        if (j < timeUnit.toSeconds(System.currentTimeMillis()) + AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS) {
            return true;
        }
        return false;
    }
}
