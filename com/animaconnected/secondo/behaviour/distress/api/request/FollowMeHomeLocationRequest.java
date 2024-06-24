package com.animaconnected.secondo.behaviour.distress.api.request;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Requests.kt */
/* loaded from: classes3.dex */
public final class FollowMeHomeLocationRequest {
    public static final int $stable = 8;
    private final FollowMeLocation location;
    private final String userId;

    public FollowMeHomeLocationRequest(String userId, FollowMeLocation location) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(location, "location");
        this.userId = userId;
        this.location = location;
    }

    public final FollowMeLocation getLocation() {
        return this.location;
    }

    public final String getUserId() {
        return this.userId;
    }
}
