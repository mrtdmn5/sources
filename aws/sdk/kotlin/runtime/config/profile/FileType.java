package aws.sdk.kotlin.runtime.config.profile;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.runtime.ConfigurationException;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.profile.Token;
import aws.sdk.kotlin.runtime.config.retries.RetryMode;
import aws.smithy.kotlin.runtime.logging.KotlinLoggingAdapter;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.amplifyframework.core.model.ModelIdentifier;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: AwsConfigParser.kt */
/* loaded from: classes.dex */
public enum FileType {
    CONFIGURATION(AwsSdkSetting.AwsConfigFile.INSTANCE, CollectionsKt__CollectionsKt.listOf((Object[]) new KFunction[]{AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE}), CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"~", ".aws", "config"})),
    CREDENTIAL(AwsSdkSetting.AwsSharedCredentialsFile.INSTANCE, CollectionsKt__CollectionsKt.listOf((Object[]) new KFunction[]{AnonymousClass4.INSTANCE, AnonymousClass5.INSTANCE, AnonymousClass6.INSTANCE}), CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"~", ".aws", "credentials"}));

    private final List<Function1<FileLine, Token>> lineParsers;
    private final List<String> pathSegments;
    private final AwsSdkSetting<String> setting;

    /* compiled from: AwsConfigParser.kt */
    /* renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FileLine, Token.Profile> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1, AwsConfigParserKt.class, "configurationProfile", "configurationProfile(Laws/sdk/kotlin/runtime/config/profile/FileLine;)Laws/sdk/kotlin/runtime/config/profile/Token$Profile;", 1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:            if (r1 != false) goto L36;     */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final aws.sdk.kotlin.runtime.config.profile.Token.Profile invoke(aws.sdk.kotlin.runtime.config.profile.FileLine r9) {
            /*
                Method dump skipped, instructions count: 278
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.profile.FileType.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: AwsConfigParser.kt */
    /* renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<FileLine, Token.Property> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1, AwsConfigParserKt.class, "property", "property(Laws/sdk/kotlin/runtime/config/profile/FileLine;)Laws/sdk/kotlin/runtime/config/profile/Token$Property;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Token.Property invoke(FileLine fileLine) {
            FileLine p0 = fileLine;
            Intrinsics.checkNotNullParameter(p0, "p0");
            return AwsConfigParserKt.access$property(p0);
        }
    }

    /* compiled from: AwsConfigParser.kt */
    /* renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<FileLine, Token> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1, AwsConfigParserKt.class, "unmatchedLine", "unmatchedLine(Laws/sdk/kotlin/runtime/config/profile/FileLine;)Laws/sdk/kotlin/runtime/config/profile/Token;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Token invoke(FileLine fileLine) {
            FileLine p0 = fileLine;
            Intrinsics.checkNotNullParameter(p0, "p0");
            KotlinLoggingAdapter kotlinLoggingAdapter = AwsConfigParserKt.logger;
            return new Token.Unmatched(p0);
        }
    }

    /* compiled from: AwsConfigParser.kt */
    /* renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$4, reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<FileLine, Token.Profile> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1, AwsConfigParserKt.class, "credentialProfile", "credentialProfile(Laws/sdk/kotlin/runtime/config/profile/FileLine;)Laws/sdk/kotlin/runtime/config/profile/Token$Profile;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Token.Profile invoke(FileLine fileLine) {
            boolean z;
            String str;
            String obj;
            FileLine p0 = fileLine;
            Intrinsics.checkNotNullParameter(p0, "p0");
            KotlinLoggingAdapter kotlinLoggingAdapter = AwsConfigParserKt.logger;
            String obj2 = StringsKt__StringsKt.trim(AwsConfigParserKt.stripComment(AwsConfigParserKt.stripComment(p0.content, ModelIdentifier.Helper.PRIMARY_KEY_DELIMITER), ";")).toString();
            if (StringsKt__StringsKt.startsWith$default((CharSequence) obj2, '[') && !StringsKt__StringsKt.endsWith$default((CharSequence) obj2, ']')) {
                throw new AwsConfigParseException(ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("Profile definition must end with ']' on line "), p0.lineNumber, ". See https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html for file format details."));
            }
            Character ch = '[';
            Character ch2 = ']';
            if (obj2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && StringsKt___StringsKt.first(obj2) == ch.charValue() && StringsKt___StringsKt.last(obj2) == ch2.charValue()) {
                str = obj2.substring(1, obj2.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                str = null;
            }
            if (str == null || (obj = StringsKt__StringsKt.trim(str).toString()) == null) {
                return null;
            }
            return new Token.Profile(false, obj, AwsConfigParserKt.isContiguous(obj));
        }
    }

    /* compiled from: AwsConfigParser.kt */
    /* renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$5, reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<FileLine, Token.Property> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1, AwsConfigParserKt.class, "property", "property(Laws/sdk/kotlin/runtime/config/profile/FileLine;)Laws/sdk/kotlin/runtime/config/profile/Token$Property;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Token.Property invoke(FileLine fileLine) {
            FileLine p0 = fileLine;
            Intrinsics.checkNotNullParameter(p0, "p0");
            return AwsConfigParserKt.access$property(p0);
        }
    }

    /* compiled from: AwsConfigParser.kt */
    /* renamed from: aws.sdk.kotlin.runtime.config.profile.FileType$6, reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<FileLine, Token> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public AnonymousClass6() {
            super(1, AwsConfigParserKt.class, "unmatchedLine", "unmatchedLine(Laws/sdk/kotlin/runtime/config/profile/FileLine;)Laws/sdk/kotlin/runtime/config/profile/Token;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Token invoke(FileLine fileLine) {
            FileLine p0 = fileLine;
            Intrinsics.checkNotNullParameter(p0, "p0");
            KotlinLoggingAdapter kotlinLoggingAdapter = AwsConfigParserKt.logger;
            return new Token.Unmatched(p0);
        }
    }

    FileType(AwsSdkSetting awsSdkSetting, List list, List list2) {
        this.setting = awsSdkSetting;
        this.lineParsers = list;
        this.pathSegments = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [aws.sdk.kotlin.runtime.config.retries.RetryMode[]] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Enum] */
    public final String path(PlatformProvider platform) {
        String str;
        String obj;
        ?? r5;
        Intrinsics.checkNotNullParameter(platform, "platform");
        AwsSdkSetting<String> awsSdkSetting = this.setting;
        String property = platform.getProperty(awsSdkSetting.jvmProperty);
        String str2 = property;
        if (property == null) {
            str2 = platform.getenv(awsSdkSetting.environmentVariable);
        }
        if (str2 != null) {
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            Object obj2 = null;
            Object obj3 = str2;
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    obj3 = Integer.valueOf(Integer.parseInt(str2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    obj3 = Long.valueOf(Long.parseLong(str2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    obj3 = Boolean.valueOf(Boolean.parseBoolean(str2));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(RetryMode.class))) {
                    ?? values = RetryMode.values();
                    int length = values.length;
                    int r3 = 0;
                    while (true) {
                        if (r3 < length) {
                            r5 = values[r3];
                            if (StringsKt__StringsJVMKt.equals(r5.name(), str2)) {
                                break;
                            }
                            r3++;
                        } else {
                            r5 = null;
                            break;
                        }
                    }
                    if (r5 != null) {
                        obj3 = r5;
                    } else {
                        StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Retry mode ", str2, " is not supported, should be one of: ");
                        m.append(ArraysKt___ArraysKt.joinToString$default(RetryMode.values(), ", ", null, 62));
                        throw new ConfigurationException(m.toString());
                    }
                } else {
                    throw new IllegalStateException(("conversion to " + Reflection.getOrCreateKotlinClass(String.class) + " not implemented for AwsSdkSetting").toString());
                }
            }
            if (obj3 instanceof String) {
                obj2 = obj3;
            }
            str = (String) obj2;
        } else {
            str = awsSdkSetting.defaultValue;
        }
        String str3 = str;
        if (str3 == null || (obj = StringsKt__StringsKt.trim(str3).toString()) == null) {
            return CollectionsKt___CollectionsKt.joinToString$default(this.pathSegments, platform.getFilePathSeparator(), null, null, null, 62);
        }
        return obj;
    }

    public final Token tokenOf(FileLine input) {
        Token token;
        Intrinsics.checkNotNullParameter(input, "input");
        Iterator<T> it = this.lineParsers.iterator();
        while (true) {
            if (it.hasNext()) {
                token = (Token) ((Function1) it.next()).invoke(input);
                if (token != null) {
                    break;
                }
            } else {
                token = null;
                break;
            }
        }
        if (token != null) {
            return token;
        }
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    }
}
