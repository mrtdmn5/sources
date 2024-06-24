package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeValidationException.kt */
/* loaded from: classes.dex */
public class CodeValidationException extends ServiceException {
    public CodeValidationException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ CodeValidationException(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
        this((r2 & 1) != 0 ? "Failed to parse code from the fetch token Uri" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeValidationException(String message) {
        super(message, "Sorry, we don't have a suggested fix for this error yet.", null, 4, null);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
