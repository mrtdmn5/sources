package com.animaconnected.watch.account.profile;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileViewModel.kt */
/* loaded from: classes3.dex */
public abstract class ProfileState {

    /* compiled from: ProfileViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Content extends ProfileState {
        private final FitnessConfigState attributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Content(FitnessConfigState attributes) {
            super(null);
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.attributes = attributes;
        }

        public static /* synthetic */ Content copy$default(Content content, FitnessConfigState fitnessConfigState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                fitnessConfigState = content.attributes;
            }
            return content.copy(fitnessConfigState);
        }

        public final FitnessConfigState component1() {
            return this.attributes;
        }

        public final Content copy(FitnessConfigState attributes) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return new Content(attributes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Content) && Intrinsics.areEqual(this.attributes, ((Content) obj).attributes)) {
                return true;
            }
            return false;
        }

        public final FitnessConfigState getAttributes() {
            return this.attributes;
        }

        public int hashCode() {
            return this.attributes.hashCode();
        }

        public String toString() {
            return "Content(attributes=" + this.attributes + ')';
        }
    }

    /* compiled from: ProfileViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Error extends ProfileState {
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }

    /* compiled from: ProfileViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Loading extends ProfileState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    public /* synthetic */ ProfileState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProfileState() {
    }
}
