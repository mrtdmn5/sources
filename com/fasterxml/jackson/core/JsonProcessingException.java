package com.fasterxml.jackson.core;

import java.io.IOException;

/* loaded from: classes3.dex */
public class JsonProcessingException extends IOException {
    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            return "N/A";
        }
        return message;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
