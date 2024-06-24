package com.animaconnected.secondo.behaviour.distress.api.request;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Requests.kt */
/* loaded from: classes3.dex */
public final class FollowMeHomeRequest {
    public static final int $stable = 8;
    private final String[] followerIds;
    private final FollowMeLocation location;
    private final String state;
    private final String userId;

    public FollowMeHomeRequest(String userId, String[] followerIds, String str, FollowMeLocation followMeLocation) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(followerIds, "followerIds");
        this.userId = userId;
        this.followerIds = followerIds;
        this.state = str;
        this.location = followMeLocation;
    }

    public final String[] getFollowerIds() {
        return this.followerIds;
    }

    public final FollowMeLocation getLocation() {
        return this.location;
    }

    public final String getState() {
        return this.state;
    }

    public final String getUserId() {
        return this.userId;
    }

    public /* synthetic */ FollowMeHomeRequest(String str, String[] strArr, String str2, FollowMeLocation followMeLocation, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, strArr, (r6 & 4) != 0 ? null : str2, (r6 & 8) != 0 ? null : followMeLocation);
    }
}
