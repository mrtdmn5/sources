package com.google.android.gms.measurement.internal;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.PlatformTypefaces;
import com.google.android.gms.internal.measurement.zzox;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzde implements PlatformTypefaces, zzdq {
    public static final /* synthetic */ zzde zza = new zzde();

    /* renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    public static Typeface m1643createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int r5) {
        boolean z;
        Typeface create;
        Typeface create2;
        boolean z2;
        boolean z3 = true;
        if (r5 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && Intrinsics.areEqual(fontWeight, FontWeight.Normal)) {
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                Typeface DEFAULT = Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                return DEFAULT;
            }
        }
        if (str == null) {
            create = Typeface.DEFAULT;
        } else {
            create = Typeface.create(str, 0);
        }
        int r4 = fontWeight.weight;
        if (r5 != 1) {
            z3 = false;
        }
        create2 = Typeface.create(create, r4, z3);
        Intrinsics.checkNotNullExpressionValue(create2, "create(\n            fami…ontStyle.Italic\n        )");
        return create2;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createDefault-FO1MlWM */
    public Typeface mo539createDefaultFO1MlWM(FontWeight fontWeight, int r3) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m1643createAndroidTypefaceApi28RetOiIg(null, fontWeight, r3);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createNamed-RetOiIg */
    public Typeface mo540createNamedRetOiIg(GenericFontFamily name, FontWeight fontWeight, int r4) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m1643createAndroidTypefaceApi28RetOiIg(name.name, fontWeight, r4);
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(zzox.zza.zza().zze());
    }
}
