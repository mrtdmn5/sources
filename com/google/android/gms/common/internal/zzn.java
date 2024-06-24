package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzn {
    public static final Uri zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    public final String zzb;
    public final String zzc;
    public final int zze;
    public final boolean zzf;

    public zzn(String str, int r2, String str2, boolean z) {
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        Preconditions.checkNotEmpty(str2);
        this.zzc = str2;
        this.zze = r2;
        this.zzf = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        if (Objects.equal(this.zzb, zznVar.zzb) && Objects.equal(this.zzc, zznVar.zzc) && Objects.equal(null, null) && this.zze == zznVar.zze && this.zzf == zznVar.zzf) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, null, Integer.valueOf(this.zze), Boolean.valueOf(this.zzf)});
    }

    public final String toString() {
        String str = this.zzb;
        if (str != null) {
            return str;
        }
        Preconditions.checkNotNull(null);
        throw null;
    }

    public final Intent zzc(Context context) {
        Bundle bundle;
        Intent intent = null;
        String str = this.zzb;
        if (str != null) {
            if (this.zzf) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", str);
                try {
                    bundle = context.getContentResolver().call(zza, "serviceIntentCall", (String) null, bundle2);
                } catch (IllegalArgumentException e) {
                    Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                    bundle = null;
                }
                if (bundle != null) {
                    intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
                }
            }
            if (intent == null) {
                return new Intent(str).setPackage(this.zzc);
            }
            return intent;
        }
        return new Intent().setComponent(null);
    }
}
