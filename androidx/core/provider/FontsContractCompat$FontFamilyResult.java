package androidx.core.provider;

/* loaded from: classes.dex */
public final class FontsContractCompat$FontFamilyResult {
    public final FontsContractCompat$FontInfo[] mFonts;
    public final int mStatusCode;

    @Deprecated
    public FontsContractCompat$FontFamilyResult(int r1, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr) {
        this.mStatusCode = r1;
        this.mFonts = fontsContractCompat$FontInfoArr;
    }
}
