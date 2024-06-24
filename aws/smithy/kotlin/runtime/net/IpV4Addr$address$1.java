package aws.smithy.kotlin.runtime.net;

import kotlin.UByte;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: IpV4Addr.kt */
/* loaded from: classes.dex */
public final class IpV4Addr$address$1 extends Lambda implements Function1<Byte, CharSequence> {
    public static final IpV4Addr$address$1 INSTANCE = new IpV4Addr$address$1();

    public IpV4Addr$address$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Byte b) {
        return UByte.m1663toStringimpl(b.byteValue());
    }
}
