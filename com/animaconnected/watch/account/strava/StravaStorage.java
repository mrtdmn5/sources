package com.animaconnected.watch.account.strava;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.BasicStorage;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.serialization.json.Json;

/* compiled from: StravaStorage.kt */
/* loaded from: classes3.dex */
public final class StravaStorage {
    private final BasicStorage storage = ServiceLocator.INSTANCE.getStorageFactory().createStorage("stravaStorage");
    private final String stravaTokenKey = "key_token";
    private final String accessTokenKey = "key_access_token";
    private final String refreshTokenKey = "key_refresh_token";
    private final String expiresAtKey = "key_expires_at";

    public final void deleteToken() {
        this.storage.put(this.stravaTokenKey, (String) null);
        this.storage.put(this.accessTokenKey, (String) null);
        this.storage.put(this.refreshTokenKey, (String) null);
        this.storage.put(this.expiresAtKey, 0L);
    }

    public final String getAccessToken() {
        return this.storage.getString(this.accessTokenKey);
    }

    public final Instant getExpiresAt() {
        Long l = this.storage.getLong(this.expiresAtKey);
        if (l == null) {
            Instant.Companion.getClass();
            return Instant.DISTANT_PAST;
        }
        return Instant.Companion.fromEpochSeconds$default(Instant.Companion, l.longValue());
    }

    public final String getRefreshToken() {
        return this.storage.getString(this.refreshTokenKey);
    }

    public final void saveToken(StravaToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        BasicStorage basicStorage = this.storage;
        String str = this.stravaTokenKey;
        Json.Default r2 = Json.Default;
        r2.getClass();
        basicStorage.put(str, r2.encodeToString(StravaToken.Companion.serializer(), token));
        this.storage.put(this.accessTokenKey, token.getAccessToken());
        this.storage.put(this.refreshTokenKey, token.getRefreshToken());
        this.storage.put(this.expiresAtKey, token.getExpiresAt());
    }
}
