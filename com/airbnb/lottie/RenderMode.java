package com.airbnb.lottie;

/* loaded from: classes.dex */
public enum RenderMode {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* renamed from: com.airbnb.lottie.RenderMode$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$RenderMode;

        static {
            int[] r0 = new int[RenderMode.values().length];
            $SwitchMap$com$airbnb$lottie$RenderMode = r0;
            try {
                r0[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$RenderMode[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean useSoftwareRendering(int r5, boolean z, int r7) {
        int r0 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$RenderMode[ordinal()];
        if (r0 == 1) {
            return false;
        }
        if (r0 == 2) {
            return true;
        }
        if ((!z || r5 >= 28) && r7 <= 4 && r5 > 25) {
            return false;
        }
        return true;
    }
}
