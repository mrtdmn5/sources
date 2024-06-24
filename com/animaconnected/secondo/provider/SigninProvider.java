package com.animaconnected.secondo.provider;

/* loaded from: classes3.dex */
public interface SigninProvider {
    String getEmail();

    String getPassword();

    boolean isSignedIn();

    void setEmail(String str);

    void setPassword(String str);

    void setSignedIn(boolean z);
}
