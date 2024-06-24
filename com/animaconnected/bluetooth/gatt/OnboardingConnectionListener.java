package com.animaconnected.bluetooth.gatt;

import kotlin.coroutines.Continuation;

/* compiled from: OnboardingConnectionListener.kt */
/* loaded from: classes.dex */
public interface OnboardingConnectionListener {
    Object associateDevice(String str, Continuation<? super Boolean> continuation);

    void expectingForegroundDialog(boolean z);

    void onDisconnectDuringOnboarding();
}
