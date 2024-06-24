package com.animaconnected.watch.utils;

import com.animaconnected.watch.account.ErrorResponse;
import com.animaconnected.watch.account.HttpUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WatchLibException.kt */
/* loaded from: classes3.dex */
public final class WatchLibException extends Exception {
    public static final Companion Companion = new Companion(null);
    public static final int NO_DOWNLOAD_REQUEST_INITIATED_CODE = 400;
    private ErrorResponse errorResponse;

    /* compiled from: WatchLibException.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ErrorResponse getDefaultError(String str) {
            if (str == null) {
                str = "SOMETHING_WENT_WRONG";
            }
            return new ErrorResponse(1, str, Boolean.FALSE);
        }

        public final WatchLibException getDefaultErrorException(String str) {
            return new WatchLibException(getDefaultError(str));
        }

        public final ErrorResponse getNoTokenAvailable() {
            return new ErrorResponse(Integer.valueOf(HttpUtilsKt.UNAUTHORIZED_RESPONSE_CODE), "NO_TOKEN_AVAILABLE", Boolean.FALSE);
        }

        public final WatchLibException getNoTokenAvailableException() {
            return new WatchLibException(getNoTokenAvailable());
        }

        private Companion() {
        }
    }

    public WatchLibException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public final ErrorResponse getErrorResponse() {
        return this.errorResponse;
    }

    public final void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
