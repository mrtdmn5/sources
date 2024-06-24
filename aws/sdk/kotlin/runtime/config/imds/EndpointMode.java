package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImdsClient.kt */
/* loaded from: classes.dex */
public enum EndpointMode {
    IPv4(new Endpoint("http://169.254.169.254")),
    IPv6(new Endpoint("http://[fd00:ec2::254]"));

    public static final Companion Companion = new Companion();
    private final Endpoint defaultEndpoint;

    /* compiled from: ImdsClient.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static EndpointMode fromValue(String str) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (Intrinsics.areEqual(lowerCase, "ipv4")) {
                return EndpointMode.IPv4;
            }
            if (Intrinsics.areEqual(lowerCase, "ipv6")) {
                return EndpointMode.IPv6;
            }
            throw new IllegalArgumentException(EndpointMode$Companion$$ExternalSyntheticOutline0.m("invalid EndpointMode: `", str, '`'));
        }
    }

    EndpointMode(Endpoint endpoint) {
        this.defaultEndpoint = endpoint;
    }

    public final Endpoint getDefaultEndpoint$aws_config() {
        return this.defaultEndpoint;
    }
}
