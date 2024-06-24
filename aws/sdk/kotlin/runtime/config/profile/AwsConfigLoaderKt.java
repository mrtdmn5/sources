package aws.sdk.kotlin.runtime.config.profile;

import aws.smithy.kotlin.runtime.logging.KotlinLoggingAdapter;
import aws.smithy.kotlin.runtime.util.OsFamily;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AwsConfigLoader.kt */
/* loaded from: classes.dex */
public final class AwsConfigLoaderKt {

    /* compiled from: AwsConfigLoader.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[OsFamily.values().length];
            try {
                r0[OsFamily.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[OsFamily.Windows.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r4v5, types: [aws.sdk.kotlin.runtime.config.retries.RetryMode[]] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Enum] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object loadActiveAwsProfile(aws.smithy.kotlin.runtime.util.PlatformProvider r10, kotlin.coroutines.Continuation<? super aws.sdk.kotlin.runtime.config.profile.AwsProfile> r11) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt.loadActiveAwsProfile(aws.smithy.kotlin.runtime.util.PlatformProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Map[], java.lang.Object[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.Serializable loadAwsProfiles(aws.smithy.kotlin.runtime.util.PlatformProvider r10, aws.sdk.kotlin.runtime.config.profile.AwsConfigurationSource r11, kotlin.coroutines.Continuation r12) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt.loadAwsProfiles(aws.smithy.kotlin.runtime.util.PlatformProvider, aws.sdk.kotlin.runtime.config.profile.AwsConfigurationSource, kotlin.coroutines.Continuation):java.io.Serializable");
    }

    public static final String normalizePath(PlatformProvider platform, String path) {
        String str;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(platform, "platform");
        if (!StringsKt__StringsKt.startsWith$default((CharSequence) StringsKt__StringsKt.trim(path).toString(), '~')) {
            return path;
        }
        int r0 = WhenMappings.$EnumSwitchMapping$0[platform.osInfo().family.ordinal()];
        if (r0 != 1 && r0 != 2) {
            str = platform.getenv("HOME");
            if (str == null) {
                str = platform.getProperty("user.home");
            }
        } else {
            str = platform.getenv("HOME");
            if (str == null && (str = platform.getenv("USERPROFILE")) == null) {
                String str2 = platform.getenv("HOMEDRIVE");
                String str3 = platform.getenv("HOMEPATH");
                KotlinLoggingAdapter kotlinLoggingAdapter = AwsConfigParserKt.logger;
                if (str2 != null && str3 != null) {
                    str = str2.concat(str3);
                } else {
                    str = null;
                }
                if (str == null) {
                    str = platform.getProperty("user.home");
                }
            }
        }
        if (str != null) {
            String substring = path.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return str.concat(substring);
        }
        throw new IllegalStateException("Unable to determine user home directory".toString());
    }
}
