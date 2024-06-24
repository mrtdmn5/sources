package com.animaconnected.secondo.behaviour.distress.model;

import com.animaconnected.secondo.behaviour.distress.api.request.FollowMeLocation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: User.kt */
/* loaded from: classes3.dex */
public final class Subject extends User {
    public static final int $stable = 8;
    private FollowMeLocation location;

    public Subject() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final FollowMeLocation getLocation() {
        return this.location;
    }

    public final void setLocation(FollowMeLocation followMeLocation) {
        Intrinsics.checkNotNullParameter(followMeLocation, "<set-?>");
        this.location = followMeLocation;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Subject(FollowMeLocation location) {
        super(null, null, null, null, 0L, false, 63, null);
        Intrinsics.checkNotNullParameter(location, "location");
        this.location = location;
    }

    public /* synthetic */ Subject(FollowMeLocation followMeLocation, int r10, DefaultConstructorMarker defaultConstructorMarker) {
        this((r10 & 1) != 0 ? new FollowMeLocation(0.0d, 0.0d, 0.0f, 7, null) : followMeLocation);
    }
}
