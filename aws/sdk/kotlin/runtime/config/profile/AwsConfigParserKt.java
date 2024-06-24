package aws.sdk.kotlin.runtime.config.profile;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.runtime.config.profile.Token;
import aws.smithy.kotlin.runtime.logging.KotlinLoggingAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: AwsConfigParser.kt */
/* loaded from: classes.dex */
public final class AwsConfigParserKt {
    public static final KotlinLoggingAdapter logger = new KotlinLoggingAdapter("AwsConfigParser");

    public static final Token.Property access$property(FileLine fileLine) {
        boolean z;
        if (!ContinuationMergerKt.isContinuationLine(fileLine.content)) {
            String str = fileLine.content;
            Intrinsics.checkNotNullParameter(str, "<this>");
            if (!StringsKt__StringsKt.startsWith$default((CharSequence) str, '[')) {
                boolean z2 = false;
                List split$default = StringsKt__StringsKt.split$default(2, 2, str, new char[]{'='});
                int size = split$default.size();
                int r7 = fileLine.lineNumber;
                if (size == 2) {
                    if (!StringsKt__StringsJVMKt.isBlank((CharSequence) split$default.get(0))) {
                        String obj = StringsKt__StringsKt.trim((String) split$default.get(0)).toString();
                        String str2 = (String) split$default.get(1);
                        if (str2.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && StringsKt___StringsKt.first(str2) == '\n') {
                            z2 = true;
                        }
                        String str3 = (String) split$default.get(1);
                        if (!z2) {
                            str3 = StringsKt__StringsKt.trim(str3).toString();
                        }
                        if (isContiguous(obj)) {
                            return new Token.Property(obj, str3);
                        }
                        MathKt__MathJVMKt.warn(logger, "Invalid property key: '" + obj + "' on line " + r7 + ". See https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html for file format details.");
                    } else {
                        throw new AwsConfigParseException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Property did not have a name on line ", r7, ". See https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html for file format details."));
                    }
                } else {
                    throw new AwsConfigParseException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Expected an = sign defining a property on line ", r7, ". See https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html for file format details."));
                }
            }
        }
        return null;
    }

    public static final boolean isContiguous(String str) {
        boolean z = false;
        int r1 = 0;
        while (true) {
            if (r1 >= str.length()) {
                break;
            }
            if (CharsKt__CharKt.isWhitespace(str.charAt(r1))) {
                z = true;
                break;
            }
            r1++;
        }
        return !z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> parse(final aws.sdk.kotlin.runtime.config.profile.FileType r6, final java.lang.String r7) {
        /*
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L13
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r7)
            if (r2 == 0) goto L11
            goto L13
        L11:
            r2 = r0
            goto L14
        L13:
            r2 = r1
        L14:
            if (r2 == 0) goto L19
            kotlin.collections.EmptyMap r6 = kotlin.collections.EmptyMap.INSTANCE
            return r6
        L19:
            aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt$parse$tokenMap$1 r2 = new aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt$parse$tokenMap$1
            r2.<init>()
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            r2.invoke(r6)
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L33:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L76
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            aws.sdk.kotlin.runtime.config.profile.Token$Profile r4 = (aws.sdk.kotlin.runtime.config.profile.Token.Profile) r4
            boolean r4 = r4.profilePrefix
            if (r4 != r1) goto L4a
            goto L5f
        L4a:
            if (r4 != 0) goto L70
            aws.sdk.kotlin.runtime.config.profile.Token$Profile r4 = new aws.sdk.kotlin.runtime.config.profile.Token$Profile
            java.lang.Object r5 = r3.getKey()
            aws.sdk.kotlin.runtime.config.profile.Token$Profile r5 = (aws.sdk.kotlin.runtime.config.profile.Token.Profile) r5
            java.lang.String r5 = r5.name
            r4.<init>(r1, r5, r1)
            boolean r4 = r6.containsKey(r4)
            if (r4 != 0) goto L61
        L5f:
            r4 = r1
            goto L62
        L61:
            r4 = r0
        L62:
            if (r4 == 0) goto L33
            java.lang.Object r4 = r3.getKey()
            java.lang.Object r3 = r3.getValue()
            r7.put(r4, r3)
            goto L33
        L70:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L76:
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            int r0 = r7.size()
            int r0 = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(r0)
            r6.<init>(r0)
            java.util.Set r7 = r7.entrySet()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L8d:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto La9
            java.lang.Object r0 = r7.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            aws.sdk.kotlin.runtime.config.profile.Token$Profile r1 = (aws.sdk.kotlin.runtime.config.profile.Token.Profile) r1
            java.lang.String r1 = r1.name
            java.lang.Object r0 = r0.getValue()
            r6.put(r1, r0)
            goto L8d
        La9:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.profile.AwsConfigParserKt.parse(aws.sdk.kotlin.runtime.config.profile.FileType, java.lang.String):java.util.Map");
    }

    public static final String stripComment(String str, String str2) {
        if (!StringsKt__StringsKt.contains$default(str, '\n')) {
            return (String) StringsKt__StringsKt.split$default(str, new String[]{str2}, 2, 2).get(0);
        }
        return str;
    }
}
