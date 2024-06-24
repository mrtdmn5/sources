package com.animaconnected.secondo.provider;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SigninProviderImpl.kt */
/* loaded from: classes3.dex */
public final class SigninProviderImpl implements SigninProvider {
    public static final int $stable = 8;
    private String mPassword;
    private final SigninStorage signInStorage;

    public SigninProviderImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.signInStorage = new SigninStorage(context);
        this.mPassword = "";
    }

    @Override // com.animaconnected.secondo.provider.SigninProvider
    public String getEmail() {
        return this.signInStorage.getEmail();
    }

    @Override // com.animaconnected.secondo.provider.SigninProvider
    public String getPassword() {
        return this.mPassword;
    }

    @Override // com.animaconnected.secondo.provider.SigninProvider
    public boolean isSignedIn() {
        return this.signInStorage.getSignedIn();
    }

    @Override // com.animaconnected.secondo.provider.SigninProvider
    public void setEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.signInStorage.setEmail(email);
    }

    @Override // com.animaconnected.secondo.provider.SigninProvider
    public void setPassword(String password) {
        Intrinsics.checkNotNullParameter(password, "password");
        this.mPassword = password;
    }

    @Override // com.animaconnected.secondo.provider.SigninProvider
    public void setSignedIn(boolean z) {
        this.signInStorage.setSignedIn(z);
    }
}
