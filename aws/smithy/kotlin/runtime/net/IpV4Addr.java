package aws.smithy.kotlin.runtime.net;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IpV4Addr.kt */
/* loaded from: classes.dex */
public final class IpV4Addr extends IpAddr {
    public final byte[] octets;

    static {
        new IpV4Addr(Byte.MAX_VALUE, (byte) 1);
        new IpV4Addr((byte) 0, (byte) 0);
    }

    public IpV4Addr(byte[] bArr) {
        this.octets = bArr;
        if (bArr.length == 4) {
            return;
        }
        throw new IllegalArgumentException(("Invalid IPv4 repr: " + bArr + "; expected 4 bytes").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && IpV4Addr.class == obj.getClass() && Arrays.equals(this.octets, ((IpV4Addr) obj).octets)) {
            return true;
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public final byte[] getOctets() {
        return this.octets;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.octets);
    }

    public final String toString() {
        byte[] bArr = this.octets;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int r5 = 0;
        for (byte b : bArr) {
            r5++;
            if (r5 > 1) {
                sb.append((CharSequence) InstructionFileId.DOT);
            }
            IpV4Addr$address$1 ipV4Addr$address$1 = IpV4Addr$address$1.INSTANCE;
            if (ipV4Addr$address$1 != null) {
                sb.append((CharSequence) ipV4Addr$address$1.invoke(Byte.valueOf(b)));
            } else {
                sb.append((CharSequence) String.valueOf((int) b));
            }
        }
        sb.append((CharSequence) "");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public IpV4Addr(byte b, byte b2) {
        this(new byte[]{b, 0, 0, b2});
    }
}
