package aws.smithy.kotlin.runtime.util;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: PlatformJVM.kt */
/* loaded from: classes.dex */
public final class SystemDefaultProvider implements PlatformProvider {
    public static final SystemDefaultProvider INSTANCE = new SystemDefaultProvider();
    public static final SynchronizedLazyImpl isAndroid$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: aws.smithy.kotlin.runtime.util.SystemDefaultProvider$isAndroid$2
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            boolean z;
            try {
                Class.forName("android.os.Build");
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    });
    public static final SynchronizedLazyImpl filePathSeparator$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: aws.smithy.kotlin.runtime.util.SystemDefaultProvider$filePathSeparator$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return File.separator;
        }
    });

    public final Map<String, String> getAllEnvVars() {
        Map<String, String> map = System.getenv();
        Intrinsics.checkNotNullExpressionValue(map, "getenv()");
        return map;
    }

    public final LinkedHashMap getAllProperties() {
        Set entrySet = System.getProperties().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "getProperties()\n        .entries");
        Set<Map.Entry> set = entrySet;
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(set, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry : set) {
            Intrinsics.checkNotNullExpressionValue(entry, "(key, value)");
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    public final String getFilePathSeparator() {
        Object value = filePathSeparator$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-filePathSeparator>(...)");
        return (String) value;
    }

    @Override // aws.smithy.kotlin.runtime.util.PropertyProvider
    public final String getProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return System.getProperty(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.EnvironmentProvider
    public final String getenv(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return System.getenv().get(key);
    }

    @Override // aws.smithy.kotlin.runtime.util.PlatformProvider
    public final OperatingSystem osInfo() {
        boolean z;
        OsFamily osFamily;
        Object createFailure;
        String property = System.getProperty("os.name");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"os.name\")");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = property.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        Pattern compile = Pattern.compile("[^a-z0-9+]");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        String replaceAll = compile.matcher(lowerCase).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(replaceAll, "replaceAll(...)");
        try {
            Class.forName("android.os.Build");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        if (z) {
            osFamily = OsFamily.Android;
        } else if (StringsKt__StringsKt.contains(replaceAll, "windows", false)) {
            osFamily = OsFamily.Windows;
        } else if (StringsKt__StringsKt.contains(replaceAll, "linux", false)) {
            osFamily = OsFamily.Linux;
        } else if (StringsKt__StringsKt.contains(replaceAll, "macosx", false)) {
            osFamily = OsFamily.MacOs;
        } else {
            osFamily = OsFamily.Unknown;
        }
        try {
            createFailure = System.getProperty("os.version");
        } catch (Throwable th) {
            createFailure = ResultKt.createFailure(th);
        }
        if (createFailure instanceof Result.Failure) {
            createFailure = null;
        }
        return new OperatingSystem(osFamily, (String) createFailure);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARN: Type inference failed for: r7v5, types: [byte[], java.io.Serializable] */
    @Override // aws.smithy.kotlin.runtime.util.Filesystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable readFileOrNull(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$1
            if (r0 == 0) goto L13
            r0 = r7
            aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$1 r0 = (aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$1 r0 = new aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L30
            if (r2 != r4) goto L28
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.io.IOException -> L46
            goto L43
        L28:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L30:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.scheduling.DefaultIoScheduler r7 = kotlinx.coroutines.Dispatchers.IO     // Catch: java.io.IOException -> L46
            aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$2 r2 = new aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$2     // Catch: java.io.IOException -> L46
            r2.<init>(r6, r3)     // Catch: java.io.IOException -> L46
            r0.label = r4     // Catch: java.io.IOException -> L46
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)     // Catch: java.io.IOException -> L46
            if (r7 != r1) goto L43
            return r1
        L43:
            byte[] r7 = (byte[]) r7     // Catch: java.io.IOException -> L46
            r3 = r7
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.util.SystemDefaultProvider.readFileOrNull(java.lang.String, kotlin.coroutines.Continuation):java.io.Serializable");
    }
}
