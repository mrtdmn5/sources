package androidx.core.text;

import android.text.SpannableStringBuilder;
import androidx.core.text.TextDirectionHeuristicsCompat;

/* loaded from: classes.dex */
public final class BidiFormatter {
    public static final BidiFormatter DEFAULT_LTR_INSTANCE;
    public static final BidiFormatter DEFAULT_RTL_INSTANCE;
    public static final String LRM_STRING;
    public static final String RLM_STRING;
    public final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    public final int mFlags;
    public final boolean mIsRtlContext;

    /* loaded from: classes.dex */
    public static class DirectionalityEstimator {
        public static final byte[] DIR_TYPE_CACHE = new byte[1792];
        public int charIndex;
        public char lastChar;
        public final int length;
        public final CharSequence text;

        static {
            for (int r1 = 0; r1 < 1792; r1++) {
                DIR_TYPE_CACHE[r1] = Character.getDirectionality(r1);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence) {
            this.text = charSequence;
            this.length = charSequence.length();
        }

        public final byte dirTypeBackward() {
            int r0 = this.charIndex - 1;
            CharSequence charSequence = this.text;
            char charAt = charSequence.charAt(r0);
            this.lastChar = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(charSequence, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            char c = this.lastChar;
            if (c < 1792) {
                return DIR_TYPE_CACHE[c];
            }
            return Character.getDirectionality(c);
        }
    }

    static {
        TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        LRM_STRING = Character.toString((char) 8206);
        RLM_STRING = Character.toString((char) 8207);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, textDirectionHeuristicInternal);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, textDirectionHeuristicInternal);
    }

    public BidiFormatter(boolean z, int r2, TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal) {
        this.mIsRtlContext = z;
        this.mFlags = r2;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicInternal;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:            return 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006e, code lost:            if (r1 != 0) goto L31;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0071, code lost:            if (r2 == 0) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:            return r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0077, code lost:            if (r0.charIndex <= 0) goto L63;     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x007d, code lost:            switch(r0.dirTypeBackward()) {            case 14: goto L66;            case 15: goto L66;            case 16: goto L65;            case 17: goto L65;            case 18: goto L64;            default: goto L70;        };     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0081, code lost:            r3 = r3 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0084, code lost:            if (r1 != r3) goto L43;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x008c, code lost:            r3 = r3 - 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0088, code lost:            if (r1 != r3) goto L43;     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:            return 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:            return 0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getEntryDir(java.lang.CharSequence r9) {
        /*
            androidx.core.text.BidiFormatter$DirectionalityEstimator r0 = new androidx.core.text.BidiFormatter$DirectionalityEstimator
            r0.<init>(r9)
            r9 = 0
            r0.charIndex = r9
            r1 = r9
            r2 = r1
            r3 = r2
        Lb:
            int r4 = r0.charIndex
            int r5 = r0.length
            r6 = -1
            r7 = 1
            if (r4 >= r5) goto L6e
            if (r1 != 0) goto L6e
            java.lang.CharSequence r5 = r0.text
            char r4 = r5.charAt(r4)
            r0.lastChar = r4
            boolean r4 = java.lang.Character.isHighSurrogate(r4)
            if (r4 == 0) goto L37
            int r4 = r0.charIndex
            int r4 = java.lang.Character.codePointAt(r5, r4)
            int r5 = r0.charIndex
            int r8 = java.lang.Character.charCount(r4)
            int r8 = r8 + r5
            r0.charIndex = r8
            byte r4 = java.lang.Character.getDirectionality(r4)
            goto L4b
        L37:
            int r4 = r0.charIndex
            int r4 = r4 + r7
            r0.charIndex = r4
            char r4 = r0.lastChar
            r5 = 1792(0x700, float:2.511E-42)
            if (r4 >= r5) goto L47
            byte[] r5 = androidx.core.text.BidiFormatter.DirectionalityEstimator.DIR_TYPE_CACHE
            r4 = r5[r4]
            goto L4b
        L47:
            byte r4 = java.lang.Character.getDirectionality(r4)
        L4b:
            if (r4 == 0) goto L69
            if (r4 == r7) goto L66
            r5 = 2
            if (r4 == r5) goto L66
            r5 = 9
            if (r4 == r5) goto Lb
            switch(r4) {
                case 14: goto L62;
                case 15: goto L62;
                case 16: goto L5e;
                case 17: goto L5e;
                case 18: goto L5a;
                default: goto L59;
            }
        L59:
            goto L6c
        L5a:
            int r3 = r3 + (-1)
            r2 = r9
            goto Lb
        L5e:
            int r3 = r3 + 1
            r2 = r7
            goto Lb
        L62:
            int r3 = r3 + 1
            r2 = r6
            goto Lb
        L66:
            if (r3 != 0) goto L6c
            goto L86
        L69:
            if (r3 != 0) goto L6c
            goto L8a
        L6c:
            r1 = r3
            goto Lb
        L6e:
            if (r1 != 0) goto L71
            goto L8f
        L71:
            if (r2 == 0) goto L75
            r9 = r2
            goto L8f
        L75:
            int r2 = r0.charIndex
            if (r2 <= 0) goto L8f
            byte r2 = r0.dirTypeBackward()
            switch(r2) {
                case 14: goto L88;
                case 15: goto L88;
                case 16: goto L84;
                case 17: goto L84;
                case 18: goto L81;
                default: goto L80;
            }
        L80:
            goto L75
        L81:
            int r3 = r3 + 1
            goto L75
        L84:
            if (r1 != r3) goto L8c
        L86:
            r9 = r7
            goto L8f
        L88:
            if (r1 != r3) goto L8c
        L8a:
            r9 = r6
            goto L8f
        L8c:
            int r3 = r3 + (-1)
            goto L75
        L8f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.BidiFormatter.getEntryDir(java.lang.CharSequence):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0041, code lost:            return 1;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x0020. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getExitDir(java.lang.CharSequence r6) {
        /*
            androidx.core.text.BidiFormatter$DirectionalityEstimator r0 = new androidx.core.text.BidiFormatter$DirectionalityEstimator
            r0.<init>(r6)
            int r6 = r0.length
            r0.charIndex = r6
            r6 = 0
            r1 = r6
        Lb:
            r2 = r1
        Lc:
            int r3 = r0.charIndex
            if (r3 <= 0) goto L41
            byte r3 = r0.dirTypeBackward()
            if (r3 == 0) goto L39
            r4 = 1
            if (r3 == r4) goto L32
            r5 = 2
            if (r3 == r5) goto L32
            r5 = 9
            if (r3 == r5) goto Lc
            switch(r3) {
                case 14: goto L2c;
                case 15: goto L2c;
                case 16: goto L29;
                case 17: goto L29;
                case 18: goto L26;
                default: goto L23;
            }
        L23:
            if (r1 != 0) goto Lc
            goto L3f
        L26:
            int r2 = r2 + 1
            goto Lc
        L29:
            if (r1 != r2) goto L2f
            goto L34
        L2c:
            if (r1 != r2) goto L2f
            goto L3b
        L2f:
            int r2 = r2 + (-1)
            goto Lc
        L32:
            if (r2 != 0) goto L36
        L34:
            r6 = r4
            goto L41
        L36:
            if (r1 != 0) goto Lc
            goto L3f
        L39:
            if (r2 != 0) goto L3d
        L3b:
            r6 = -1
            goto L41
        L3d:
            if (r1 != 0) goto Lc
        L3f:
            r1 = r2
            goto Lb
        L41:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.BidiFormatter.getExitDir(java.lang.CharSequence):int");
    }

    public final SpannableStringBuilder unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean z;
        TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal;
        char c;
        TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal textDirectionHeuristicInternal2;
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = ((TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl) textDirectionHeuristicCompat).isRtl(charSequence.length(), charSequence);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if ((this.mFlags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        String str2 = RLM_STRING;
        String str3 = LRM_STRING;
        boolean z2 = this.mIsRtlContext;
        if (z) {
            if (isRtl) {
                textDirectionHeuristicInternal2 = TextDirectionHeuristicsCompat.RTL;
            } else {
                textDirectionHeuristicInternal2 = TextDirectionHeuristicsCompat.LTR;
            }
            boolean isRtl2 = textDirectionHeuristicInternal2.isRtl(charSequence.length(), charSequence);
            if (!z2 && (isRtl2 || getEntryDir(charSequence) == 1)) {
                str = str3;
            } else if (!z2 || (isRtl2 && getEntryDir(charSequence) != -1)) {
                str = "";
            } else {
                str = str2;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        if (isRtl != z2) {
            if (isRtl) {
                c = 8235;
            } else {
                c = 8234;
            }
            spannableStringBuilder.append(c);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (isRtl) {
            textDirectionHeuristicInternal = TextDirectionHeuristicsCompat.RTL;
        } else {
            textDirectionHeuristicInternal = TextDirectionHeuristicsCompat.LTR;
        }
        boolean isRtl3 = textDirectionHeuristicInternal.isRtl(charSequence.length(), charSequence);
        if (!z2 && (isRtl3 || getExitDir(charSequence) == 1)) {
            str2 = str3;
        } else if (!z2 || (isRtl3 && getExitDir(charSequence) != -1)) {
            str2 = "";
        }
        spannableStringBuilder.append((CharSequence) str2);
        return spannableStringBuilder;
    }
}
