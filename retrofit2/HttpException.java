package retrofit2;

/* loaded from: classes4.dex */
public class HttpException extends RuntimeException {
    public final int code;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HttpException(retrofit2.Response<?> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "response == null"
            java.util.Objects.requireNonNull(r4, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "HTTP "
            r0.<init>(r1)
            okhttp3.Response r1 = r4.rawResponse
            int r2 = r1.code
            r0.append(r2)
            java.lang.String r2 = " "
            r0.append(r2)
            java.lang.String r1 = r1.message
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            okhttp3.Response r4 = r4.rawResponse
            int r0 = r4.code
            r3.code = r0
            java.lang.String r4 = r4.message
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.HttpException.<init>(retrofit2.Response):void");
    }
}
