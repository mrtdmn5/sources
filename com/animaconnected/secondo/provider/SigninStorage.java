package com.animaconnected.secondo.provider;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.login.LoginState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SigninStorage.kt */
/* loaded from: classes3.dex */
public final class SigninStorage {
    private static final String KEY_EMAIL = "email";
    private static final String KEY_LOGIN_STATE = "user-login-state-int";
    private static final String KEY_NOT_NOW = "user-login-not-now";
    private static final String KEY_SIGNED_IN = "signedInV2";
    private static final String SHARED_PREFS_NAME = "signInStorage";
    private final SharedPreferences sharedPref;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static String pwStoredInMemory = "";

    /* compiled from: SigninStorage.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getPwStoredInMemory() {
            return SigninStorage.pwStoredInMemory;
        }

        public final void setPwStoredInMemory(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SigninStorage.pwStoredInMemory = str;
        }

        private Companion() {
        }
    }

    public SigninStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPref = sharedPreferences;
    }

    public final String getEmail() {
        String string = this.sharedPref.getString("email", "");
        if (string == null) {
            return "";
        }
        return string;
    }

    public final boolean getNotNow() {
        return this.sharedPref.getBoolean(KEY_NOT_NOW, false);
    }

    public final boolean getSignedIn() {
        return this.sharedPref.getBoolean(KEY_SIGNED_IN, false);
    }

    public final LoginState getState() {
        return LoginState.Companion.fromId(Integer.valueOf(this.sharedPref.getInt(KEY_LOGIN_STATE, -1)));
    }

    public final void setEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.sharedPref.edit().putString("email", email).apply();
    }

    public final void setNotNow(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(this.sharedPref, KEY_NOT_NOW, z);
    }

    public final void setSignedIn(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(this.sharedPref, KEY_SIGNED_IN, z);
    }

    public final void setState(LoginState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.sharedPref.edit().putInt(KEY_LOGIN_STATE, state.getId()).apply();
    }
}
