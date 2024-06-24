package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.config.imds.ImdsClient;
import aws.sdk.kotlin.runtime.config.imds.InstanceMetadataProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: ImdsCredentialsProvider.kt */
/* loaded from: classes.dex */
public final class ImdsCredentialsProvider implements CloseableCredentialsProvider {
    public final Lazy<InstanceMetadataProvider> client;
    public final Clock clock;
    public final PlatformEnvironProvider platformProvider;
    public final String profileOverride;

    /* compiled from: ImdsCredentialsProvider.kt */
    /* renamed from: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$1 */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends Lambda implements Function0<ImdsClient> {
        public static final AnonymousClass1 INSTANCE = ;

        @Override // kotlin.jvm.functions.Function0
        public final ImdsClient invoke() {
            return new ImdsClient(new ImdsClient.Builder());
        }
    }

    public ImdsCredentialsProvider() {
        this(null, null, null, 15);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$loadProfile(aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider r4, kotlin.coroutines.Continuation r5) {
        /*
            r4.getClass()
            boolean r0 = r5 instanceof aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$1
            if (r0 == 0) goto L16
            r0 = r5
            aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$1 r0 = (aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$1 r0 = new aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$1
            r0.<init>(r4, r5)
        L1b:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: aws.sdk.kotlin.runtime.config.imds.EC2MetadataError -> L4a
            goto L46
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Lazy<aws.sdk.kotlin.runtime.config.imds.InstanceMetadataProvider> r4 = r4.client     // Catch: aws.sdk.kotlin.runtime.config.imds.EC2MetadataError -> L4a
            java.lang.Object r4 = r4.getValue()     // Catch: aws.sdk.kotlin.runtime.config.imds.EC2MetadataError -> L4a
            aws.sdk.kotlin.runtime.config.imds.InstanceMetadataProvider r4 = (aws.sdk.kotlin.runtime.config.imds.InstanceMetadataProvider) r4     // Catch: aws.sdk.kotlin.runtime.config.imds.EC2MetadataError -> L4a
            r0.label = r3     // Catch: aws.sdk.kotlin.runtime.config.imds.EC2MetadataError -> L4a
            java.lang.Object r5 = r4.get(r0)     // Catch: aws.sdk.kotlin.runtime.config.imds.EC2MetadataError -> L4a
            if (r5 != r1) goto L46
            goto L49
        L46:
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1     // Catch: aws.sdk.kotlin.runtime.config.imds.EC2MetadataError -> L4a
        L49:
            return r1
        L4a:
            r4 = move-exception
            aws.smithy.kotlin.runtime.http.HttpStatusCode r5 = aws.smithy.kotlin.runtime.http.HttpStatusCode.NotFound
            int r5 = r5.value
            int r1 = r4.statusCode
            if (r1 != r5) goto L7a
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            aws.smithy.kotlin.runtime.tracing.TraceSpan r5 = aws.smithy.kotlin.runtime.tracing.CoroutineContextUtilsKt.getTraceSpan(r5)
            aws.smithy.kotlin.runtime.tracing.EventLevel r0 = aws.smithy.kotlin.runtime.tracing.EventLevel.Info
            java.lang.Class<aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider> r1 = aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider.class
            kotlin.jvm.internal.ClassReference r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            java.lang.String r1 = r1.getQualifiedName()
            if (r1 != 0) goto L75
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "log<T> cannot be used on an anonymous object"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L75:
            aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2 r2 = new kotlin.jvm.functions.Function0<java.lang.Object>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2
                static {
                    /*
                        aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2 r0 = new aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2) aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2.INSTANCE aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Received 404 from IMDS when loading profile information. Hint: This instance may not have an IAM role associated."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$loadProfile$2.invoke():java.lang.Object");
                }
            }
            aws.smithy.kotlin.runtime.tracing.TraceSpanExtKt.log(r5, r0, r1, r2)
        L7a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider.access$loadProfile(aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Lazy<InstanceMetadataProvider> lazy = this.client;
        if (lazy.isInitialized()) {
            lazy.getValue().close();
        }
    }

    public ImdsCredentialsProvider(String str, SynchronizedLazyImpl client, PlatformEnvironProvider platformProvider, int r6) {
        str = (r6 & 1) != 0 ? null : str;
        client = (r6 & 2) != 0 ? LazyKt__LazyJVMKt.lazy(AnonymousClass1.INSTANCE) : client;
        if ((r6 & 4) != 0) {
            PlatformProvider.Companion.getClass();
            platformProvider = PlatformProvider.Companion.System;
        }
        Clock.System clock = (r6 & 8) != 0 ? Clock.System.INSTANCE : null;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.profileOverride = str;
        this.client = client;
        this.platformProvider = platformProvider;
        this.clock = clock;
        MutexKt.Mutex$default();
        new LazyAsyncValueImpl(new ImdsCredentialsProvider$profile$1(this, null));
    }
}
