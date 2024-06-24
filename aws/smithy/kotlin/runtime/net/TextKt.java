package aws.smithy.kotlin.runtime.net;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;

/* compiled from: Text.kt */
/* loaded from: classes.dex */
public final class TextKt {
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a A[LOOP:0: B:8:0x0011->B:30:0x004a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0048 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isIpv6AddressSegment(java.lang.String r5) {
        /*
            int r0 = r5.length()
            r1 = 0
            r2 = 1
            if (r2 > r0) goto Ld
            r3 = 5
            if (r0 >= r3) goto Ld
            r0 = r2
            goto Le
        Ld:
            r0 = r1
        Le:
            if (r0 == 0) goto L51
            r0 = r1
        L11:
            int r3 = r5.length()
            if (r0 >= r3) goto L4d
            char r3 = r5.charAt(r0)
            r4 = 48
            if (r4 > r3) goto L25
            r4 = 58
            if (r3 >= r4) goto L25
            r4 = r2
            goto L26
        L25:
            r4 = r1
        L26:
            if (r4 != 0) goto L45
            r4 = 97
            if (r4 > r3) goto L32
            r4 = 103(0x67, float:1.44E-43)
            if (r3 >= r4) goto L32
            r4 = r2
            goto L33
        L32:
            r4 = r1
        L33:
            if (r4 != 0) goto L45
            r4 = 65
            if (r4 > r3) goto L3f
            r4 = 71
            if (r3 >= r4) goto L3f
            r3 = r2
            goto L40
        L3f:
            r3 = r1
        L40:
            if (r3 == 0) goto L43
            goto L45
        L43:
            r3 = r1
            goto L46
        L45:
            r3 = r2
        L46:
            if (r3 != 0) goto L4a
            r5 = r1
            goto L4e
        L4a:
            int r0 = r0 + 1
            goto L11
        L4d:
            r5 = r2
        L4e:
            if (r5 == 0) goto L51
            r1 = r2
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.net.TextKt.isIpv6AddressSegment(java.lang.String):boolean");
    }

    public static final IpV4Addr parseIpv4OrNull(String str) {
        int r3;
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z2 = true;
        List split$default = StringsKt__StringsKt.split$default(0, 6, str, new char[]{'.'});
        if (split$default.size() == 4) {
            List list = split$default;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it.next());
                    if (intOrNull != null) {
                        r3 = intOrNull.intValue();
                    } else {
                        r3 = -1;
                    }
                    if (r3 >= 0 && r3 < 256) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Byte.valueOf(UStringsKt.toUByte((String) it2.next())));
                }
                return new IpV4Addr(CollectionsKt___CollectionsKt.toByteArray(arrayList));
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final aws.smithy.kotlin.runtime.net.IpV6Addr parseIpv6OrNull(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 772
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.net.TextKt.parseIpv6OrNull(java.lang.String):aws.smithy.kotlin.runtime.net.IpV6Addr");
    }
}
