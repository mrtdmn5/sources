package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.hashing.Sha256;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignatureCalculator.kt */
/* loaded from: classes.dex */
public final class DefaultSignatureCalculator implements SignatureCalculator {
    public final Function0<Object> sha256Provider;

    /* compiled from: SignatureCalculator.kt */
    /* renamed from: aws.smithy.kotlin.runtime.auth.awssigning.DefaultSignatureCalculator$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Sha256> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0, Sha256.class, "<init>", "<init>()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Sha256 invoke() {
            return new Sha256();
        }
    }

    public DefaultSignatureCalculator(int r2) {
        AnonymousClass1 sha256Provider = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(sha256Provider, "sha256Provider");
        this.sha256Provider = sha256Provider;
    }
}
