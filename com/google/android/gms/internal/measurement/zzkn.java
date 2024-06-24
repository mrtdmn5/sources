package com.google.android.gms.internal.measurement;

import com.amazonaws.services.s3.internal.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkn {
    public static final Charset zzb;
    public static final byte[] zzd;

    static {
        Charset.forName("US-ASCII");
        zzb = Charset.forName(Constants.DEFAULT_ENCODING);
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzd = bArr;
        ByteBuffer.wrap(bArr);
    }

    public static int zzc(long j) {
        return (int) (j ^ (j >>> 32));
    }
}
