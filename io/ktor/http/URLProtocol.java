package io.ktor.http;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLProtocol.kt */
/* loaded from: classes3.dex */
public final class URLProtocol {
    public static final URLProtocol HTTP;
    public static final URLProtocol HTTPS;
    public static final LinkedHashMap byName;
    public final int defaultPort;
    public final String name;

    static {
        URLProtocol uRLProtocol = new URLProtocol("http", 80);
        HTTP = uRLProtocol;
        URLProtocol uRLProtocol2 = new URLProtocol("https", 443);
        HTTPS = uRLProtocol2;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new URLProtocol[]{uRLProtocol, uRLProtocol2, new URLProtocol("ws", 80), new URLProtocol("wss", 443), new URLProtocol("socks", 1080)});
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(listOf, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Object obj : listOf) {
            linkedHashMap.put(((URLProtocol) obj).name, obj);
        }
        byName = linkedHashMap;
    }

    public URLProtocol(String str, int r6) {
        this.name = str;
        this.defaultPort = r6;
        boolean z = false;
        int r0 = 0;
        while (true) {
            if (r0 < str.length()) {
                char charAt = str.charAt(r0);
                if (!(Character.toLowerCase(charAt) == charAt)) {
                    break;
                } else {
                    r0++;
                }
            } else {
                z = true;
                break;
            }
        }
        if (z) {
        } else {
            throw new IllegalArgumentException("All characters should be lower case".toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof URLProtocol)) {
            return false;
        }
        URLProtocol uRLProtocol = (URLProtocol) obj;
        if (Intrinsics.areEqual(this.name, uRLProtocol.name) && this.defaultPort == uRLProtocol.defaultPort) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.defaultPort) + (this.name.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("URLProtocol(name=");
        sb.append(this.name);
        sb.append(", defaultPort=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.defaultPort, ')');
    }
}
