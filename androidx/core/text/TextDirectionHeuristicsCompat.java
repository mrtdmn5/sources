package androidx.core.text;

/* loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicInternal FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicInternal FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicInternal LTR = new TextDirectionHeuristicInternal(null, false);
    public static final TextDirectionHeuristicInternal RTL = new TextDirectionHeuristicInternal(null, true);

    /* loaded from: classes.dex */
    public static class FirstStrong implements TextDirectionAlgorithm {
        public static final FirstStrong INSTANCE = new FirstStrong();

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public final int checkRtl(int r6, CharSequence charSequence) {
            int r62 = r6 + 0;
            int r3 = 2;
            for (int r2 = 0; r2 < r62 && r3 == 2; r2++) {
                byte directionality = Character.getDirectionality(charSequence.charAt(r2));
                TextDirectionHeuristicInternal textDirectionHeuristicInternal = TextDirectionHeuristicsCompat.LTR;
                if (directionality != 0) {
                    if (directionality != 1 && directionality != 2) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                break;
                            case 16:
                            case 17:
                                break;
                            default:
                                r3 = 2;
                                break;
                        }
                    }
                    r3 = 0;
                }
                r3 = 1;
            }
            return r3;
        }
    }

    /* loaded from: classes.dex */
    public interface TextDirectionAlgorithm {
        int checkRtl(int r1, CharSequence charSequence);
    }

    /* loaded from: classes.dex */
    public static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        public final TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(FirstStrong firstStrong) {
            this.mAlgorithm = firstStrong;
        }

        public abstract boolean defaultIsRtl();

        public final boolean isRtl(int r2, CharSequence charSequence) {
            if (charSequence != null && r2 >= 0 && charSequence.length() - r2 >= 0) {
                TextDirectionAlgorithm textDirectionAlgorithm = this.mAlgorithm;
                if (textDirectionAlgorithm == null) {
                    return defaultIsRtl();
                }
                int checkRtl = textDirectionAlgorithm.checkRtl(r2, charSequence);
                if (checkRtl == 0) {
                    return true;
                }
                if (checkRtl != 1) {
                    return defaultIsRtl();
                }
                return false;
            }
            throw new IllegalArgumentException();
        }
    }

    /* loaded from: classes.dex */
    public static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        public final boolean mDefaultIsRtl;

        public TextDirectionHeuristicInternal(FirstStrong firstStrong, boolean z) {
            super(firstStrong);
            this.mDefaultIsRtl = z;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public final boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(firstStrong, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(firstStrong, true);
    }
}
