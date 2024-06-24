package aws.smithy.kotlin.runtime.net;

import java.util.Arrays;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.UShortArray;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.CharsKt__CharKt;

/* compiled from: IpV6Addr.kt */
/* loaded from: classes.dex */
public final class IpV6Addr extends IpAddr {
    public final SynchronizedLazyImpl address$delegate;
    public final byte[] octets;
    public final SynchronizedLazyImpl segments$delegate;
    public final String zoneId;
    public static final IpV6Addr LOCALHOST = new IpV6Addr(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, null);
    public static final IpV6Addr UNSPECIFIED = new IpV6Addr(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, null);
    public static final byte[] IPV4_MAPPED_PREFIX_OCTETS = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1};

    public /* synthetic */ IpV6Addr() {
        throw null;
    }

    public IpV6Addr(byte[] bArr, String str) {
        this.octets = bArr;
        this.zoneId = str;
        if (bArr.length == 16) {
            this.segments$delegate = LazyKt__LazyJVMKt.lazy(new Function0<UShortArray>() { // from class: aws.smithy.kotlin.runtime.net.IpV6Addr$segments$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final UShortArray invoke() {
                    boolean z;
                    IpV6Addr ipV6Addr = IpV6Addr.this;
                    int length = ipV6Addr.octets.length / 2;
                    short[] sArr = new short[length];
                    for (int r4 = 0; r4 < length; r4++) {
                        int r5 = r4 * 2;
                        byte[] bArr2 = ipV6Addr.octets;
                        if (r5 <= bArr2.length - 2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            sArr[r4] = (short) ((bArr2[r5 + 1] & 255) | ((bArr2[r5] & 255) << 8));
                        } else {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                    return new UShortArray(sArr);
                }
            });
            this.address$delegate = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: aws.smithy.kotlin.runtime.net.IpV6Addr$address$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    byte[] copyOfRange;
                    IpV4Addr ipV4Addr;
                    String sb;
                    IpV6Addr ipV6Addr = IpV6Addr.this;
                    ipV6Addr.getClass();
                    byte[] bArr2 = IpV6Addr.IPV4_MAPPED_PREFIX_OCTETS;
                    int length = bArr2.length;
                    int r4 = 0;
                    int r5 = 0;
                    while (true) {
                        byte[] bArr3 = ipV6Addr.octets;
                        if (r4 < length) {
                            int r9 = r5 + 1;
                            if (bArr3[r5] != bArr2[r4]) {
                                ipV4Addr = null;
                                break;
                            }
                            r4++;
                            r5 = r9;
                        } else {
                            IntRange indices = RangesKt___RangesKt.until(bArr2.length, bArr3.length);
                            Intrinsics.checkNotNullParameter(indices, "indices");
                            if (indices.isEmpty()) {
                                copyOfRange = new byte[0];
                            } else {
                                copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(bArr3, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
                            }
                            ipV4Addr = new IpV4Addr(copyOfRange);
                        }
                    }
                    if (Intrinsics.areEqual(ipV6Addr, IpV6Addr.LOCALHOST)) {
                        sb = "::1";
                    } else if (Intrinsics.areEqual(ipV6Addr, IpV6Addr.UNSPECIFIED)) {
                        sb = "::";
                    } else if (ipV4Addr != null) {
                        sb = "::ffff:" + ipV4Addr;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        IpV6Addr$address$2$formatted$1$Span ipV6Addr$address$2$formatted$1$Span = new IpV6Addr$address$2$formatted$1$Span();
                        IpV6Addr$address$2$formatted$1$Span ipV6Addr$address$2$formatted$1$Span2 = new IpV6Addr$address$2$formatted$1$Span();
                        short[] m620getSegmentsamswpOA = ipV6Addr.m620getSegmentsamswpOA();
                        int length2 = m620getSegmentsamswpOA.length;
                        int r92 = 0;
                        int r10 = 0;
                        while (r92 < length2) {
                            int r12 = r10 + 1;
                            if (m620getSegmentsamswpOA[r92] == ((short) 0)) {
                                int r11 = ipV6Addr$address$2$formatted$1$Span.len;
                                if (r11 == 0) {
                                    ipV6Addr$address$2$formatted$1$Span.start = r10;
                                }
                                int r112 = r11 + 1;
                                ipV6Addr$address$2$formatted$1$Span.len = r112;
                                if (r112 > ipV6Addr$address$2$formatted$1$Span2.len) {
                                    ipV6Addr$address$2$formatted$1$Span2 = ipV6Addr$address$2$formatted$1$Span;
                                }
                            } else {
                                ipV6Addr$address$2$formatted$1$Span = new IpV6Addr$address$2$formatted$1$Span();
                            }
                            r92++;
                            r10 = r12;
                        }
                        if (ipV6Addr$address$2$formatted$1$Span2.len > 1) {
                            CollectionsKt___CollectionsKt.joinTo$default(RangesKt___RangesKt.until(0, ipV6Addr$address$2$formatted$1$Span2.start), sb2, ":", new Function1<Integer, CharSequence>() { // from class: aws.smithy.kotlin.runtime.net.IpV6Addr$formatSegments$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final CharSequence invoke(Integer num) {
                                    int r2 = IpV6Addr.this.m620getSegmentsamswpOA()[num.intValue()] & 65535;
                                    CharsKt__CharKt.checkRadix(16);
                                    String num2 = Integer.toString(r2, 16);
                                    Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                                    return num2;
                                }
                            }, 60);
                            sb2.append("::");
                            CollectionsKt___CollectionsKt.joinTo$default(RangesKt___RangesKt.until(ipV6Addr$address$2$formatted$1$Span2.start + ipV6Addr$address$2$formatted$1$Span2.len, ipV6Addr.m620getSegmentsamswpOA().length), sb2, ":", new Function1<Integer, CharSequence>() { // from class: aws.smithy.kotlin.runtime.net.IpV6Addr$formatSegments$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final CharSequence invoke(Integer num) {
                                    int r2 = IpV6Addr.this.m620getSegmentsamswpOA()[num.intValue()] & 65535;
                                    CharsKt__CharKt.checkRadix(16);
                                    String num2 = Integer.toString(r2, 16);
                                    Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                                    return num2;
                                }
                            }, 60);
                        } else {
                            Intrinsics.checkNotNullParameter(ipV6Addr.m620getSegmentsamswpOA(), "<this>");
                            CollectionsKt___CollectionsKt.joinTo$default(new IntRange(0, r2.length - 1), sb2, ":", new Function1<Integer, CharSequence>() { // from class: aws.smithy.kotlin.runtime.net.IpV6Addr$formatSegments$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final CharSequence invoke(Integer num) {
                                    int r2 = IpV6Addr.this.m620getSegmentsamswpOA()[num.intValue()] & 65535;
                                    CharsKt__CharKt.checkRadix(16);
                                    String num2 = Integer.toString(r2, 16);
                                    Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                                    return num2;
                                }
                            }, 60);
                        }
                        sb = sb2.toString();
                        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
                    }
                    String str2 = ipV6Addr.zoneId;
                    if (str2 != null) {
                        return sb + '%' + str2;
                    }
                    return sb;
                }
            });
        } else {
            throw new IllegalArgumentException(("Invalid IPv6 repr: " + bArr + "; expected 16 bytes").toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && IpV6Addr.class == obj.getClass() && Arrays.equals(this.octets, ((IpV6Addr) obj).octets)) {
            return true;
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.net.IpAddr
    public final byte[] getOctets() {
        return this.octets;
    }

    /* renamed from: getSegments-amswpOA */
    public final short[] m620getSegmentsamswpOA() {
        return ((UShortArray) this.segments$delegate.getValue()).storage;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.octets);
    }

    public final String toString() {
        return (String) this.address$delegate.getValue();
    }
}
