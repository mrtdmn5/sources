package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class Logger {
    public final String zza;
    public final String zzb;
    public final int zzd;

    public Logger(String str, String... strArr) {
        String sb;
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            sb = sb2.toString();
        }
        this.zzb = sb;
        this.zza = str;
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        int r8 = 2;
        while (r8 <= 7 && !Log.isLoggable(this.zza, r8)) {
            r8++;
        }
        this.zzd = r8;
    }

    public final void d(String str, Object... objArr) {
        boolean z;
        if (this.zzd <= 3) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (objArr.length > 0) {
                str = String.format(Locale.US, str, objArr);
            }
            Log.d(this.zza, this.zzb.concat(str));
        }
    }
}
