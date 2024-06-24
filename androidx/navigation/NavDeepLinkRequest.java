package androidx.navigation;

import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public final class NavDeepLinkRequest {
    public final String mAction;
    public final String mMimeType;
    public final Uri mUri;

    public NavDeepLinkRequest(Intent intent) {
        Uri data = intent.getData();
        String action = intent.getAction();
        String type = intent.getType();
        this.mUri = data;
        this.mAction = action;
        this.mMimeType = type;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NavDeepLinkRequest{");
        Uri uri = this.mUri;
        if (uri != null) {
            sb.append(" uri=");
            sb.append(uri.toString());
        }
        String str = this.mAction;
        if (str != null) {
            sb.append(" action=");
            sb.append(str);
        }
        String str2 = this.mMimeType;
        if (str2 != null) {
            sb.append(" mimetype=");
            sb.append(str2);
        }
        sb.append(" }");
        return sb.toString();
    }
}
