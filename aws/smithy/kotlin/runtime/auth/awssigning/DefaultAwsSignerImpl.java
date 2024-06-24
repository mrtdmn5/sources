package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.auth.awssigning.Canonicalizer;
import aws.smithy.kotlin.runtime.auth.awssigning.SignatureCalculator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultAwsSigner.kt */
/* loaded from: classes.dex */
public final class DefaultAwsSignerImpl {
    public DefaultAwsSignerImpl() {
        Canonicalizer.Companion.getClass();
        DefaultCanonicalizer canonicalizer = Canonicalizer.Companion.Default;
        SignatureCalculator.Companion.getClass();
        DefaultSignatureCalculator signatureCalculator = SignatureCalculator.Companion.Default;
        Intrinsics.checkNotNullParameter(canonicalizer, "canonicalizer");
        Intrinsics.checkNotNullParameter(signatureCalculator, "signatureCalculator");
    }
}
