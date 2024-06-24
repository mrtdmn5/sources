package androidx.core.provider;

import android.net.Uri;

/* loaded from: classes.dex */
public final class FontsContractCompat$FontInfo {
    public final boolean mItalic;
    public final int mResultCode;
    public final int mTtcIndex;
    public final Uri mUri;
    public final int mWeight;

    @Deprecated
    public FontsContractCompat$FontInfo(Uri uri, int r2, int r3, boolean z, int r5) {
        uri.getClass();
        this.mUri = uri;
        this.mTtcIndex = r2;
        this.mWeight = r3;
        this.mItalic = z;
        this.mResultCode = r5;
    }
}
