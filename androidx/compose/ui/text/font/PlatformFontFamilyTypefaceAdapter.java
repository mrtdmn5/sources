package androidx.compose.ui.text.font;

import android.os.Build;
import com.google.android.gms.measurement.internal.zzde;
import com.google.android.gms.measurement.internal.zzdf;

/* compiled from: PlatformFontFamilyTypefaceAdapter.android.kt */
/* loaded from: classes.dex */
public final class PlatformFontFamilyTypefaceAdapter {
    public final PlatformTypefaces platformTypefaceResolver;

    public PlatformFontFamilyTypefaceAdapter() {
        PlatformTypefaces zzdfVar;
        if (Build.VERSION.SDK_INT >= 28) {
            zzdfVar = new zzde();
        } else {
            zzdfVar = new zzdf();
        }
        this.platformTypefaceResolver = zzdfVar;
    }
}
