package aws.smithy.kotlin.runtime.util;

import kotlin.NoWhenBranchMatchedException;

/* compiled from: Platform.kt */
/* loaded from: classes.dex */
public enum OsFamily {
    Linux,
    MacOs,
    Windows,
    Android,
    Ios,
    Unknown;

    /* compiled from: Platform.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[OsFamily.values().length];
            try {
                r0[OsFamily.Linux.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[OsFamily.MacOs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[OsFamily.Windows.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[OsFamily.Android.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[OsFamily.Ios.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[OsFamily.Unknown.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "linux";
            case 2:
                return "macos";
            case 3:
                return "windows";
            case 4:
                return "android";
            case 5:
                return "ios";
            case 6:
                return "unknown";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
