package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public class zzkp extends IOException {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static zzkp zzc() {
        return new zzkp("Protocol message had invalid UTF-8.");
    }

    public static zzkp zzd() {
        return new zzkp("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzkp zze() {
        return new zzkp("Failed to parse the message.");
    }

    public static zzkp zzf() {
        return new zzkp("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
