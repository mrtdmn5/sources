package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultChainCredentialsProvider.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class DefaultChainCredentialsProvider$chain$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public DefaultChainCredentialsProvider$chain$1(PlatformProvider platformProvider) {
        super(1, platformProvider, PlatformProvider.class, "getenv", "getenv(Ljava/lang/String;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String str) {
        String p0 = str;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((PlatformProvider) this.receiver).getenv(p0);
    }
}
