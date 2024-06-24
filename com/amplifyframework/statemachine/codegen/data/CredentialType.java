package com.amplifyframework.statemachine.codegen.data;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AmplifyCredential.kt */
/* loaded from: classes.dex */
public abstract class CredentialType {

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public static final class ASF extends CredentialType {
        public static final ASF INSTANCE = new ASF();

        private ASF() {
            super(null);
        }
    }

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public static final class Amplify extends CredentialType {
        public static final Amplify INSTANCE = new Amplify();

        private Amplify() {
            super(null);
        }
    }

    /* compiled from: AmplifyCredential.kt */
    /* loaded from: classes.dex */
    public static final class Device extends CredentialType {
        private final String username;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Device(String username) {
            super(null);
            Intrinsics.checkNotNullParameter(username, "username");
            this.username = username;
        }

        public static /* synthetic */ Device copy$default(Device device, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = device.username;
            }
            return device.copy(str);
        }

        public final String component1() {
            return this.username;
        }

        public final Device copy(String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            return new Device(username);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Device) && Intrinsics.areEqual(this.username, ((Device) obj).username)) {
                return true;
            }
            return false;
        }

        public final String getUsername() {
            return this.username;
        }

        public int hashCode() {
            return this.username.hashCode();
        }

        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Device(username="), this.username, ')');
        }
    }

    public /* synthetic */ CredentialType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CredentialType() {
    }
}
