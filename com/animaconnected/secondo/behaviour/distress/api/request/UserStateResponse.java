package com.animaconnected.secondo.behaviour.distress.api.request;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Requests.kt */
/* loaded from: classes3.dex */
public final class UserStateResponse {
    public static final int $stable = 8;
    private final List<String> followerIds;
    private final FollowMeLocation location;
    private final String state;
    private final int userId;

    public UserStateResponse() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserStateResponse copy$default(UserStateResponse userStateResponse, int r1, String str, List list, FollowMeLocation followMeLocation, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r1 = userStateResponse.userId;
        }
        if ((r5 & 2) != 0) {
            str = userStateResponse.state;
        }
        if ((r5 & 4) != 0) {
            list = userStateResponse.followerIds;
        }
        if ((r5 & 8) != 0) {
            followMeLocation = userStateResponse.location;
        }
        return userStateResponse.copy(r1, str, list, followMeLocation);
    }

    public final int component1() {
        return this.userId;
    }

    public final String component2() {
        return this.state;
    }

    public final List<String> component3() {
        return this.followerIds;
    }

    public final FollowMeLocation component4() {
        return this.location;
    }

    public final UserStateResponse copy(int r2, String str, List<String> list, FollowMeLocation followMeLocation) {
        return new UserStateResponse(r2, str, list, followMeLocation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserStateResponse)) {
            return false;
        }
        UserStateResponse userStateResponse = (UserStateResponse) obj;
        if (this.userId == userStateResponse.userId && Intrinsics.areEqual(this.state, userStateResponse.state) && Intrinsics.areEqual(this.followerIds, userStateResponse.followerIds) && Intrinsics.areEqual(this.location, userStateResponse.location)) {
            return true;
        }
        return false;
    }

    public final List<String> getFollowerIds() {
        return this.followerIds;
    }

    public final FollowMeLocation getLocation() {
        return this.location;
    }

    public final String getState() {
        return this.state;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = Integer.hashCode(this.userId) * 31;
        String str = this.state;
        int r2 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = (hashCode3 + hashCode) * 31;
        List<String> list = this.followerIds;
        if (list == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = list.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        FollowMeLocation followMeLocation = this.location;
        if (followMeLocation != null) {
            r2 = followMeLocation.hashCode();
        }
        return r02 + r2;
    }

    public String toString() {
        return "UserStateResponse(userId=" + this.userId + ", state=" + this.state + ", followerIds=" + this.followerIds + ", location=" + this.location + ')';
    }

    public UserStateResponse(int r1, String str, List<String> list, FollowMeLocation followMeLocation) {
        this.userId = r1;
        this.state = str;
        this.followerIds = list;
        this.location = followMeLocation;
    }

    public /* synthetic */ UserStateResponse(int r2, String str, List list, FollowMeLocation followMeLocation, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this((r6 & 1) != 0 ? 0 : r2, (r6 & 2) != 0 ? null : str, (r6 & 4) != 0 ? null : list, (r6 & 8) != 0 ? null : followMeLocation);
    }
}
