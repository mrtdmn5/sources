package aws.sdk.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.util.PlatformProvider;
import aws.smithy.kotlin.runtime.util.SystemDefaultProvider;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwsUserAgentMetadataJvm.kt */
/* loaded from: classes.dex */
public final class AwsUserAgentMetadataJvmKt {
    public static final SynchronizedLazyImpl jvmMetadataExtras = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, String>>() { // from class: aws.sdk.kotlin.runtime.http.AwsUserAgentMetadataJvmKt$jvmMetadataExtras$1
        @Override // kotlin.jvm.functions.Function0
        public final Map<String, String> invoke() {
            LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("javaVersion", AwsUserAgentMetadataJvmKt.getSystemProperty$default("java.version")), new Pair("jvmName", AwsUserAgentMetadataJvmKt.getSystemProperty$default("java.vm.name")), new Pair("jvmVersion", AwsUserAgentMetadataJvmKt.getSystemProperty$default("java.vm.version")));
            PlatformProvider.Companion.getClass();
            PlatformProvider.Companion.System.getClass();
            if (((Boolean) SystemDefaultProvider.isAndroid$delegate.getValue()).booleanValue()) {
                Class<?> cls = Class.forName("android.os.Build$VERSION");
                Field declaredField = cls.getDeclaredField("SDK_INT");
                Field declaredField2 = cls.getDeclaredField("RELEASE");
                mutableMapOf.put("androidApiVersion", String.valueOf(declaredField.getInt(null)));
                Object obj = declaredField2.get(null);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                mutableMapOf.put("androidRelease", (String) obj);
            }
            return mutableMapOf;
        }
    });

    public static String getSystemProperty$default(String str) {
        Object createFailure;
        try {
            createFailure = System.getProperty(str);
        } catch (Throwable th) {
            createFailure = ResultKt.createFailure(th);
        }
        if (createFailure instanceof Result.Failure) {
            createFailure = "unknown";
        }
        return (String) createFailure;
    }
}
