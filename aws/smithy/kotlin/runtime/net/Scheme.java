package aws.smithy.kotlin.runtime.net;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scheme.kt */
/* loaded from: classes.dex */
public final class Scheme {
    public static final Scheme HTTP;
    public static final Scheme HTTPS;
    public static final LinkedHashMap byName;
    public final int defaultPort;
    public final String protocolName;

    /* compiled from: Scheme.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static Scheme parse(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LinkedHashMap linkedHashMap = Scheme.byName;
            String lowerCase = scheme.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            Scheme scheme2 = (Scheme) linkedHashMap.get(lowerCase);
            if (scheme2 == null) {
                return new Scheme(scheme, -1);
            }
            return scheme2;
        }
    }

    static {
        Scheme scheme = new Scheme("https", 443);
        HTTPS = scheme;
        Scheme scheme2 = new Scheme("http", 80);
        HTTP = scheme2;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Scheme[]{scheme2, scheme, new Scheme("ws", 80), new Scheme("wss", 443)});
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(listOf, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Object obj : listOf) {
            linkedHashMap.put(((Scheme) obj).protocolName, obj);
        }
        byName = linkedHashMap;
    }

    public Scheme(String protocolName, int r3) {
        Intrinsics.checkNotNullParameter(protocolName, "protocolName");
        this.protocolName = protocolName;
        this.defaultPort = r3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme)) {
            return false;
        }
        Scheme scheme = (Scheme) obj;
        if (Intrinsics.areEqual(this.protocolName, scheme.protocolName) && this.defaultPort == scheme.defaultPort) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.defaultPort) + (this.protocolName.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Scheme(protocolName=");
        sb.append(this.protocolName);
        sb.append(", defaultPort=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.defaultPort, ')');
    }
}
