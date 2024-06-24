package com.amplifyframework.statemachine.codegen.data;

import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.serializer.DateSerializer;
import com.google.android.gms.tasks.zzac;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SignedInData.kt */
@Serializable
/* loaded from: classes.dex */
public final class SignedInData {
    public static final Companion Companion = new Companion(null);
    private final CognitoUserPoolTokens cognitoUserPoolTokens;
    private final SignInMethod signInMethod;
    private final Date signedInDate;
    private final String userId;
    private final String username;

    /* compiled from: SignedInData.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SignedInData> serializer() {
            return SignedInData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SignedInData(int r2, String str, String str2, @Serializable(with = DateSerializer.class) Date date, SignInMethod signInMethod, CognitoUserPoolTokens cognitoUserPoolTokens, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (r2 & 31)) {
            zzac.throwMissingFieldException(r2, 31, SignedInData$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.userId = str;
        this.username = str2;
        this.signedInDate = date;
        this.signInMethod = signInMethod;
        this.cognitoUserPoolTokens = cognitoUserPoolTokens;
    }

    public static /* synthetic */ SignedInData copy$default(SignedInData signedInData, String str, String str2, Date date, SignInMethod signInMethod, CognitoUserPoolTokens cognitoUserPoolTokens, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = signedInData.userId;
        }
        if ((r9 & 2) != 0) {
            str2 = signedInData.username;
        }
        String str3 = str2;
        if ((r9 & 4) != 0) {
            date = signedInData.signedInDate;
        }
        Date date2 = date;
        if ((r9 & 8) != 0) {
            signInMethod = signedInData.signInMethod;
        }
        SignInMethod signInMethod2 = signInMethod;
        if ((r9 & 16) != 0) {
            cognitoUserPoolTokens = signedInData.cognitoUserPoolTokens;
        }
        return signedInData.copy(str, str3, date2, signInMethod2, cognitoUserPoolTokens);
    }

    public static final void write$Self(SignedInData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.userId);
        output.encodeStringElement(serialDesc, 1, self.username);
        output.encodeSerializableElement(serialDesc, 2, DateSerializer.INSTANCE, self.signedInDate);
        output.encodeSerializableElement(serialDesc, 3, SignInMethod.Companion.serializer(), self.signInMethod);
        output.encodeSerializableElement(serialDesc, 4, CognitoUserPoolTokens$$serializer.INSTANCE, self.cognitoUserPoolTokens);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.username;
    }

    public final Date component3() {
        return this.signedInDate;
    }

    public final SignInMethod component4() {
        return this.signInMethod;
    }

    public final CognitoUserPoolTokens component5() {
        return this.cognitoUserPoolTokens;
    }

    public final SignedInData copy(String userId, String username, Date signedInDate, SignInMethod signInMethod, CognitoUserPoolTokens cognitoUserPoolTokens) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(signedInDate, "signedInDate");
        Intrinsics.checkNotNullParameter(signInMethod, "signInMethod");
        Intrinsics.checkNotNullParameter(cognitoUserPoolTokens, "cognitoUserPoolTokens");
        return new SignedInData(userId, username, signedInDate, signInMethod, cognitoUserPoolTokens);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && Intrinsics.areEqual(SignedInData.class, obj.getClass()) && (obj instanceof SignedInData)) {
            SignedInData signedInData = (SignedInData) obj;
            if (Intrinsics.areEqual(this.userId, signedInData.userId) && Intrinsics.areEqual(this.username, signedInData.username) && Intrinsics.areEqual(this.signInMethod, signedInData.signInMethod) && Intrinsics.areEqual(this.cognitoUserPoolTokens, signedInData.cognitoUserPoolTokens)) {
                return true;
            }
        }
        return false;
    }

    public final CognitoUserPoolTokens getCognitoUserPoolTokens() {
        return this.cognitoUserPoolTokens;
    }

    public final SignInMethod getSignInMethod() {
        return this.signInMethod;
    }

    public final Date getSignedInDate() {
        return this.signedInDate;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return this.cognitoUserPoolTokens.hashCode() + ((this.signInMethod.hashCode() + ((this.signedInDate.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.username, this.userId.hashCode() * 31, 31)) * 31)) * 31);
    }

    public String toString() {
        return "SignedInData(userId=" + this.userId + ", username=" + this.username + ", signedInDate=" + this.signedInDate + ", signInMethod=" + this.signInMethod + ", cognitoUserPoolTokens=" + this.cognitoUserPoolTokens + ')';
    }

    public SignedInData(String userId, String username, Date signedInDate, SignInMethod signInMethod, CognitoUserPoolTokens cognitoUserPoolTokens) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(signedInDate, "signedInDate");
        Intrinsics.checkNotNullParameter(signInMethod, "signInMethod");
        Intrinsics.checkNotNullParameter(cognitoUserPoolTokens, "cognitoUserPoolTokens");
        this.userId = userId;
        this.username = username;
        this.signedInDate = signedInDate;
        this.signInMethod = signInMethod;
        this.cognitoUserPoolTokens = cognitoUserPoolTokens;
    }

    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getSignedInDate$annotations() {
    }
}
