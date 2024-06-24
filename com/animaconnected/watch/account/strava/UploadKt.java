package com.animaconnected.watch.account.strava;

import com.animaconnected.watch.account.strava.UploadStatus;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Upload.kt */
/* loaded from: classes3.dex */
public final class UploadKt {
    public static final boolean isDuplicate(Upload upload) {
        String error;
        if (upload == null || (error = upload.getError()) == null) {
            return false;
        }
        return StringsKt__StringsKt.contains(error, "duplicate of", false);
    }

    public static final UploadStatus statusAsEnum(Upload upload) {
        String str;
        UploadStatus.Companion companion = UploadStatus.Companion;
        if (upload != null) {
            str = upload.getStatus();
        } else {
            str = null;
        }
        return companion.fromString(str);
    }
}
