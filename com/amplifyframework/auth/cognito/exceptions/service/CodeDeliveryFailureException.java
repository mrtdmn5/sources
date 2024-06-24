package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CodeDeliveryFailureException.kt */
/* loaded from: classes.dex */
public class CodeDeliveryFailureException extends ServiceException {
    public CodeDeliveryFailureException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ CodeDeliveryFailureException(Throwable th, int r2, DefaultConstructorMarker defaultConstructorMarker) {
        this((r2 & 1) != 0 ? null : th);
    }

    public CodeDeliveryFailureException(Throwable th) {
        super("Error in delivering the confirmation code.", "Retry operation and send another confirmation code.", th);
    }
}
