package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidGrantException.kt */
/* loaded from: classes.dex */
public class InvalidGrantException extends ServiceException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidGrantException(String message) {
        super(message, "Sorry, we don't have a suggested fix for this error yet.", null, 4, null);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
