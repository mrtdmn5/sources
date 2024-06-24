package com.airbnb.lottie.network;

import java.io.Closeable;
import java.net.HttpURLConnection;

/* loaded from: classes.dex */
public final class DefaultLottieFetchResult implements Closeable {
    public final HttpURLConnection connection;

    public DefaultLottieFetchResult(HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.connection.disconnect();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0010 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String error() {
        /*
            r4 = this;
            java.net.HttpURLConnection r0 = r4.connection
            int r1 = r0.getResponseCode()     // Catch: java.io.IOException -> Ld
            int r1 = r1 / 100
            r2 = 2
            if (r1 != r2) goto Ld
            r1 = 1
            goto Le
        Ld:
            r1 = 0
        Le:
            if (r1 == 0) goto L12
            r0 = 0
            goto L64
        L12:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L6a
            r1.<init>()     // Catch: java.io.IOException -> L6a
            java.lang.String r2 = "Unable to fetch "
            r1.append(r2)     // Catch: java.io.IOException -> L6a
            java.net.URL r2 = r0.getURL()     // Catch: java.io.IOException -> L6a
            r1.append(r2)     // Catch: java.io.IOException -> L6a
            java.lang.String r2 = ". Failed with "
            r1.append(r2)     // Catch: java.io.IOException -> L6a
            int r2 = r0.getResponseCode()     // Catch: java.io.IOException -> L6a
            r1.append(r2)     // Catch: java.io.IOException -> L6a
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch: java.io.IOException -> L6a
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.io.IOException -> L6a
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L6a
            java.io.InputStream r0 = r0.getErrorStream()     // Catch: java.io.IOException -> L6a
            r3.<init>(r0)     // Catch: java.io.IOException -> L6a
            r2.<init>(r3)     // Catch: java.io.IOException -> L6a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L6a
            r0.<init>()     // Catch: java.io.IOException -> L6a
        L47:
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L56
            r0.append(r3)     // Catch: java.lang.Throwable -> L65
            r3 = 10
            r0.append(r3)     // Catch: java.lang.Throwable -> L65
            goto L47
        L56:
            r2.close()     // Catch: java.lang.Exception -> L59
        L59:
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L6a
            r1.append(r0)     // Catch: java.io.IOException -> L6a
            java.lang.String r0 = r1.toString()     // Catch: java.io.IOException -> L6a
        L64:
            return r0
        L65:
            r0 = move-exception
            r2.close()     // Catch: java.lang.Exception -> L69
        L69:
            throw r0     // Catch: java.io.IOException -> L6a
        L6a:
            r0 = move-exception
            java.lang.String r1 = "get error failed "
            com.airbnb.lottie.utils.Logger.warning(r1, r0)
            java.lang.String r0 = r0.getMessage()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.network.DefaultLottieFetchResult.error():java.lang.String");
    }
}
