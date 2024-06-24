package okhttp3;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.tls.CertificateChainCleaner;

/* compiled from: CertificatePinner.kt */
/* loaded from: classes4.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new CertificatePinner(CollectionsKt___CollectionsKt.toSet(new ArrayList()), null);
    public final CertificateChainCleaner certificateChainCleaner;
    public final Set<Pin> pins;

    /* compiled from: CertificatePinner.kt */
    /* loaded from: classes4.dex */
    public static final class Pin {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            pin.getClass();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                return false;
            }
            pin.getClass();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                return false;
            }
            pin.getClass();
            if (Intrinsics.areEqual((Object) null, (Object) null)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    public CertificatePinner(Set<Pin> pins, CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public final void check$okhttp(String hostname, Function0<? extends List<? extends X509Certificate>> function0) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Iterator<T> it = this.pins.iterator();
        if (!it.hasNext()) {
            return;
        }
        ((Pin) it.next()).getClass();
        StringsKt__StringsJVMKt.startsWith(null, "**.", false);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Intrinsics.areEqual(certificatePinner.pins, this.pins) && Intrinsics.areEqual(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int hashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            r1 = certificateChainCleaner.hashCode();
        } else {
            r1 = 0;
        }
        return hashCode + r1;
    }
}
