package com.animaconnected.secondo.behaviour.distress.api.request;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Requests.kt */
/* loaded from: classes3.dex */
public final class RegisterUserRequest {
    public static final int $stable = 8;
    private final String firstName;
    private String lastName;
    private final String phoneNumber;

    public RegisterUserRequest(String firstName, String str, String phoneNumber) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.firstName = firstName;
        this.lastName = str;
        this.phoneNumber = phoneNumber;
    }

    public static /* synthetic */ RegisterUserRequest copy$default(RegisterUserRequest registerUserRequest, String str, String str2, String str3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = registerUserRequest.firstName;
        }
        if ((r4 & 2) != 0) {
            str2 = registerUserRequest.lastName;
        }
        if ((r4 & 4) != 0) {
            str3 = registerUserRequest.phoneNumber;
        }
        return registerUserRequest.copy(str, str2, str3);
    }

    public final String component1() {
        return this.firstName;
    }

    public final String component2() {
        return this.lastName;
    }

    public final String component3() {
        return this.phoneNumber;
    }

    public final RegisterUserRequest copy(String firstName, String str, String phoneNumber) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return new RegisterUserRequest(firstName, str, phoneNumber);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterUserRequest)) {
            return false;
        }
        RegisterUserRequest registerUserRequest = (RegisterUserRequest) obj;
        if (Intrinsics.areEqual(this.firstName, registerUserRequest.firstName) && Intrinsics.areEqual(this.lastName, registerUserRequest.lastName) && Intrinsics.areEqual(this.phoneNumber, registerUserRequest.phoneNumber)) {
            return true;
        }
        return false;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.firstName.hashCode() * 31;
        String str = this.lastName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return this.phoneNumber.hashCode() + ((hashCode2 + hashCode) * 31);
    }

    public final void setLastName(String str) {
        this.lastName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RegisterUserRequest(firstName=");
        sb.append(this.firstName);
        sb.append(", lastName=");
        sb.append(this.lastName);
        sb.append(", phoneNumber=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.phoneNumber, ')');
    }

    public /* synthetic */ RegisterUserRequest(String str, String str2, String str3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (r4 & 2) != 0 ? "" : str2, str3);
    }
}
