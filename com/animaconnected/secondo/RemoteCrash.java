package com.animaconnected.secondo;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: KronabyFirebaseMessagingService.kt */
/* loaded from: classes.dex */
public final class RemoteCrash extends RuntimeException {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteCrash(String msg) {
        super(msg);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }
}
