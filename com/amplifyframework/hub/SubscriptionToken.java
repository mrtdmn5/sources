package com.amplifyframework.hub;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.UUID;

/* loaded from: classes.dex */
public final class SubscriptionToken {
    private final UUID uuid;

    private SubscriptionToken(UUID r1) {
        this.uuid = r1;
    }

    public static SubscriptionToken create() {
        return new SubscriptionToken(UUID.randomUUID());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SubscriptionToken.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(this.uuid, ((SubscriptionToken) obj).uuid);
        }
        return false;
    }

    public int hashCode() {
        UUID r0 = this.uuid;
        if (r0 != null) {
            return r0.hashCode();
        }
        return 0;
    }
}
