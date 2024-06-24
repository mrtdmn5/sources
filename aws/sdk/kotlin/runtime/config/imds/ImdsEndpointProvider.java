package aws.sdk.kotlin.runtime.config.imds;

import aws.sdk.kotlin.runtime.config.imds.EndpointConfiguration;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImdsEndpointProvider.kt */
/* loaded from: classes.dex */
public final class ImdsEndpointProvider implements EndpointProvider<Unit> {
    public final LazyAsyncValueImpl activeProfile;
    public final EndpointConfiguration endpointConfiguration;
    public final PlatformProvider platformProvider;
    public final LazyAsyncValueImpl resolvedEndpoint;

    public ImdsEndpointProvider(PlatformProvider platformProvider, EndpointConfiguration.Default endpointConfiguration) {
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(endpointConfiguration, "endpointConfiguration");
        this.platformProvider = platformProvider;
        this.endpointConfiguration = endpointConfiguration;
        this.resolvedEndpoint = new LazyAsyncValueImpl(new ImdsEndpointProvider$resolvedEndpoint$1(this));
        this.activeProfile = new LazyAsyncValueImpl(new ImdsEndpointProvider$activeProfile$1(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadEndpointFromProfile(kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.client.endpoints.Endpoint> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointFromProfile$1
            if (r0 == 0) goto L13
            r0 = r5
            aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointFromProfile$1 r0 = (aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointFromProfile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointFromProfile$1 r0 = new aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointFromProfile$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl r5 = r4.activeProfile
            java.lang.Object r5 = r5.get(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            aws.sdk.kotlin.runtime.config.profile.AwsProfile r5 = (aws.sdk.kotlin.runtime.config.profile.AwsProfile) r5
            java.lang.String r0 = "ec2_metadata_service_endpoint"
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L4f
            aws.smithy.kotlin.runtime.client.endpoints.Endpoint r0 = new aws.smithy.kotlin.runtime.client.endpoints.Endpoint
            r0.<init>(r5)
            goto L50
        L4f:
            r0 = 0
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider.loadEndpointFromProfile(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Enum loadEndpointModeFromProfile(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointModeFromProfile$1
            if (r0 == 0) goto L13
            r0 = r5
            aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointModeFromProfile$1 r0 = (aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointModeFromProfile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointModeFromProfile$1 r0 = new aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$loadEndpointModeFromProfile$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl r5 = r4.activeProfile
            java.lang.Object r5 = r5.get(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            aws.sdk.kotlin.runtime.config.profile.AwsProfile r5 = (aws.sdk.kotlin.runtime.config.profile.AwsProfile) r5
            java.lang.String r0 = "ec2_metadata_service_endpoint_mode"
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L53
            aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion r0 = aws.sdk.kotlin.runtime.config.imds.EndpointMode.Companion
            r0.getClass()
            aws.sdk.kotlin.runtime.config.imds.EndpointMode r5 = aws.sdk.kotlin.runtime.config.imds.EndpointMode.Companion.fromValue(r5)
            goto L54
        L53:
            r5 = 0
        L54:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider.loadEndpointModeFromProfile(kotlin.coroutines.Continuation):java.lang.Enum");
    }

    @Override // aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider
    public final Object resolveEndpoint(Unit unit, Continuation continuation) {
        return this.resolvedEndpoint.get(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x013c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object resolveEndpointFromConfig(kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.client.endpoints.Endpoint> r18) {
        /*
            Method dump skipped, instructions count: 575
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider.resolveEndpointFromConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
