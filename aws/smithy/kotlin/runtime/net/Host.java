package aws.smithy.kotlin.runtime.net;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Host.kt */
/* loaded from: classes.dex */
public abstract class Host {

    /* compiled from: Host.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:44:0x0091 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:? A[LOOP:0: B:18:0x003b->B:46:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static aws.smithy.kotlin.runtime.net.Host parse(java.lang.String r7) {
            /*
                java.lang.String r0 = "host"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                aws.smithy.kotlin.runtime.net.IpV4Addr r0 = aws.smithy.kotlin.runtime.net.TextKt.parseIpv4OrNull(r7)
                if (r0 == 0) goto Lc
                goto L10
            Lc:
                aws.smithy.kotlin.runtime.net.IpV6Addr r0 = aws.smithy.kotlin.runtime.net.TextKt.parseIpv6OrNull(r7)
            L10:
                if (r0 == 0) goto L19
                aws.smithy.kotlin.runtime.net.Host$IpAddress r7 = new aws.smithy.kotlin.runtime.net.Host$IpAddress
                r7.<init>(r0)
                goto L9a
            L19:
                r0 = 1
                char[] r1 = new char[r0]
                r2 = 46
                r3 = 0
                r1[r3] = r2
                r2 = 6
                java.util.List r1 = kotlin.text.StringsKt__StringsKt.split$default(r3, r2, r7, r1)
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                boolean r2 = r1 instanceof java.util.Collection
                if (r2 == 0) goto L37
                r2 = r1
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L37
                goto L92
            L37:
                java.util.Iterator r1 = r1.iterator()
            L3b:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L92
                java.lang.Object r2 = r1.next()
                java.lang.String r2 = (java.lang.String) r2
                java.lang.String r4 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
                int r4 = r2.length()
                if (r0 > r4) goto L58
                r5 = 64
                if (r4 >= r5) goto L58
                r4 = r0
                goto L59
            L58:
                r4 = r3
            L59:
                if (r4 == 0) goto L8e
                char r4 = r2.charAt(r3)
                boolean r4 = java.lang.Character.isLetterOrDigit(r4)
                if (r4 == 0) goto L8e
                java.lang.String r2 = kotlin.text.StringsKt___StringsKt.drop(r0, r2)
                r4 = r3
            L6a:
                int r5 = r2.length()
                if (r4 >= r5) goto L89
                char r5 = r2.charAt(r4)
                boolean r6 = java.lang.Character.isLetterOrDigit(r5)
                if (r6 != 0) goto L81
                r6 = 45
                if (r5 != r6) goto L7f
                goto L81
            L7f:
                r5 = r3
                goto L82
            L81:
                r5 = r0
            L82:
                if (r5 != 0) goto L86
                r2 = r3
                goto L8a
            L86:
                int r4 = r4 + 1
                goto L6a
            L89:
                r2 = r0
            L8a:
                if (r2 == 0) goto L8e
                r2 = r0
                goto L8f
            L8e:
                r2 = r3
            L8f:
                if (r2 != 0) goto L3b
                r0 = r3
            L92:
                if (r0 == 0) goto L9b
                aws.smithy.kotlin.runtime.net.Host$Domain r0 = new aws.smithy.kotlin.runtime.net.Host$Domain
                r0.<init>(r7)
                r7 = r0
            L9a:
                return r7
            L9b:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = " is not a valid inet host"
                java.lang.String r7 = r7.concat(r1)
                r0.<init>(r7)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.net.Host.Companion.parse(java.lang.String):aws.smithy.kotlin.runtime.net.Host");
        }
    }

    /* compiled from: Host.kt */
    /* loaded from: classes.dex */
    public static final class Domain extends Host {
        public final String name;

        public Domain(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Domain) && Intrinsics.areEqual(this.name, ((Domain) obj).name)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public final String toString() {
            return this.name;
        }
    }

    /* compiled from: Host.kt */
    /* loaded from: classes.dex */
    public static final class IpAddress extends Host {
        public final IpAddr address;

        public IpAddress(IpAddr ipAddr) {
            this.address = ipAddr;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof IpAddress) && Intrinsics.areEqual(this.address, ((IpAddress) obj).address)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.address.hashCode();
        }

        public final String toString() {
            return this.address.toString();
        }
    }
}
