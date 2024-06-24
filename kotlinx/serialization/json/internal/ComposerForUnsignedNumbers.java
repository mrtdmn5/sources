package kotlinx.serialization.json.internal;

import kotlin.UByte;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composers.kt */
/* loaded from: classes4.dex */
public final class ComposerForUnsignedNumbers extends Composer {
    public final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(JsonWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void print(int r5) {
        String l = Long.toString(4294967295L & r5, 10);
        if (this.forceQuoting) {
            printQuoted(l);
        } else {
            print(l);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void print(long j) {
        int r1 = 63;
        String str = "0";
        if (this.forceQuoting) {
            if (j != 0) {
                if (j > 0) {
                    str = Long.toString(j, 10);
                } else {
                    char[] cArr = new char[64];
                    long j2 = (j >>> 1) / 5;
                    long j3 = 10;
                    cArr[63] = Character.forDigit((int) (j - (j2 * j3)), 10);
                    while (j2 > 0) {
                        r1--;
                        cArr[r1] = Character.forDigit((int) (j2 % j3), 10);
                        j2 /= j3;
                    }
                    str = new String(cArr, r1, 64 - r1);
                }
            }
            printQuoted(str);
            return;
        }
        if (j != 0) {
            if (j > 0) {
                str = Long.toString(j, 10);
            } else {
                char[] cArr2 = new char[64];
                long j4 = (j >>> 1) / 5;
                long j5 = 10;
                cArr2[63] = Character.forDigit((int) (j - (j4 * j5)), 10);
                while (j4 > 0) {
                    r1--;
                    cArr2[r1] = Character.forDigit((int) (j4 % j5), 10);
                    j4 /= j5;
                }
                str = new String(cArr2, r1, 64 - r1);
            }
        }
        print(str);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void print(byte b) {
        String m1663toStringimpl = UByte.m1663toStringimpl(b);
        if (this.forceQuoting) {
            printQuoted(m1663toStringimpl);
        } else {
            print(m1663toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void print(short s) {
        String m1665toStringimpl = UShort.m1665toStringimpl(s);
        if (this.forceQuoting) {
            printQuoted(m1665toStringimpl);
        } else {
            print(m1665toStringimpl);
        }
    }
}
