package com.animaconnected.watch.account.profile;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ProfileHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
final class UserProfileResponse {
    public static final Companion Companion = new Companion(null);
    private final Profile data;

    /* compiled from: ProfileHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UserProfileResponse> serializer() {
            return UserProfileResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* compiled from: ProfileHttpClient.kt */
    @Serializable
    /* loaded from: classes3.dex */
    public static final class Profile {
        public static final Companion Companion = new Companion(null);
        private final Long lastUpdated;
        private final String profile;

        /* compiled from: ProfileHttpClient.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Profile> serializer() {
                return UserProfileResponse$Profile$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Profile(int r3, Long l, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (2 != (r3 & 2)) {
                zzac.throwMissingFieldException(r3, 2, UserProfileResponse$Profile$$serializer.INSTANCE.getDescriptor());
                throw null;
            }
            if ((r3 & 1) == 0) {
                this.lastUpdated = null;
            } else {
                this.lastUpdated = l;
            }
            this.profile = str;
        }

        public static /* synthetic */ Profile copy$default(Profile profile, Long l, String str, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                l = profile.lastUpdated;
            }
            if ((r3 & 2) != 0) {
                str = profile.profile;
            }
            return profile.copy(l, str);
        }

        public static final /* synthetic */ void write$Self$watch_release(Profile profile, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            boolean z;
            if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || profile.lastUpdated != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, profile.lastUpdated);
            }
            compositeEncoder.encodeStringElement(serialDescriptor, 1, profile.profile);
        }

        public final Long component1() {
            return this.lastUpdated;
        }

        public final String component2() {
            return this.profile;
        }

        public final Profile copy(Long l, String profile) {
            Intrinsics.checkNotNullParameter(profile, "profile");
            return new Profile(l, profile);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Profile)) {
                return false;
            }
            Profile profile = (Profile) obj;
            if (Intrinsics.areEqual(this.lastUpdated, profile.lastUpdated) && Intrinsics.areEqual(this.profile, profile.profile)) {
                return true;
            }
            return false;
        }

        public final Long getLastUpdated() {
            return this.lastUpdated;
        }

        public final String getProfile() {
            return this.profile;
        }

        public int hashCode() {
            int hashCode;
            Long l = this.lastUpdated;
            if (l == null) {
                hashCode = 0;
            } else {
                hashCode = l.hashCode();
            }
            return this.profile.hashCode() + (hashCode * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Profile(lastUpdated=");
            sb.append(this.lastUpdated);
            sb.append(", profile=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.profile, ')');
        }

        public Profile(Long l, String profile) {
            Intrinsics.checkNotNullParameter(profile, "profile");
            this.lastUpdated = l;
            this.profile = profile;
        }

        public /* synthetic */ Profile(Long l, String str, int r3, DefaultConstructorMarker defaultConstructorMarker) {
            this((r3 & 1) != 0 ? null : l, str);
        }
    }

    public /* synthetic */ UserProfileResponse(int r2, Profile profile, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 == (r2 & 1)) {
            this.data = profile;
        } else {
            zzac.throwMissingFieldException(r2, 1, UserProfileResponse$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
    }

    public static /* synthetic */ UserProfileResponse copy$default(UserProfileResponse userProfileResponse, Profile profile, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            profile = userProfileResponse.data;
        }
        return userProfileResponse.copy(profile);
    }

    public final Profile component1() {
        return this.data;
    }

    public final UserProfileResponse copy(Profile profile) {
        return new UserProfileResponse(profile);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UserProfileResponse) && Intrinsics.areEqual(this.data, ((UserProfileResponse) obj).data)) {
            return true;
        }
        return false;
    }

    public final Profile getData() {
        return this.data;
    }

    public int hashCode() {
        Profile profile = this.data;
        if (profile == null) {
            return 0;
        }
        return profile.hashCode();
    }

    public String toString() {
        return "UserProfileResponse(data=" + this.data + ')';
    }

    public UserProfileResponse(Profile profile) {
        this.data = profile;
    }
}
