package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;

/* compiled from: CodeMismatchException.kt */
/* loaded from: classes.dex */
public class CodeMismatchException extends ServiceException {
    public CodeMismatchException(Throwable th) {
        super("Confirmation code entered is not correct.", "Enter correct confirmation code.", th);
    }
}
