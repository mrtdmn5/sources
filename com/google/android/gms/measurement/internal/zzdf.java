package com.google.android.gms.measurement.internal;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.PlatformTypefaces;
import com.google.android.gms.internal.measurement.zzoc;
import com.google.android.gms.internal.measurement.zzod;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzdf implements PlatformTypefaces, zzdq {
    public static final /* synthetic */ zzdf zza = new zzdf();

    /* renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
    public static Typeface m1644createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int r5) {
        boolean z;
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
        int m1641getAndroidTypefaceStyleFO1MlWM = zzcz.m1641getAndroidTypefaceStyleFO1MlWM(fontWeight, r5);
        if (str != null && str.length() != 0) {
            z3 = false;
        }
        if (z3) {
            Typeface defaultFromStyle = Typeface.defaultFromStyle(m1641getAndroidTypefaceStyleFO1MlWM);
            Intrinsics.checkNotNullExpressionValue(defaultFromStyle, "{\n            Typeface.d…le(targetStyle)\n        }");
            return defaultFromStyle;
        }
        Typeface create = Typeface.create(str, m1641getAndroidTypefaceStyleFO1MlWM);
        Intrinsics.checkNotNullExpressionValue(create, "{\n            Typeface.c…y, targetStyle)\n        }");
        return create;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createDefault-FO1MlWM */
    public Typeface mo539createDefaultFO1MlWM(FontWeight fontWeight, int r3) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m1644createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, r3);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* renamed from: createNamed-RetOiIg */
    public Typeface mo540createNamedRetOiIg(GenericFontFamily name, FontWeight fontWeight, int r9) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        String name2 = name.name;
        Intrinsics.checkNotNullParameter(name2, "name");
        int r0 = fontWeight.weight / 100;
        boolean z6 = false;
        if (r0 >= 0 && r0 < 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = name2.concat("-thin");
        } else {
            if (2 <= r0 && r0 < 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str = name2.concat("-light");
            } else {
                if (r0 != 4) {
                    if (r0 == 5) {
                        str = name2.concat("-medium");
                    } else {
                        if (6 <= r0 && r0 < 8) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            if (8 <= r0 && r0 < 11) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                str = name2.concat("-black");
                            }
                        }
                    }
                }
                str = name2;
            }
        }
        if (str.length() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Typeface typeface = null;
        if (!z5) {
            Typeface m1644createAndroidTypefaceUsingTypefaceStyleRetOiIg = m1644createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, r9);
            if (!Intrinsics.areEqual(m1644createAndroidTypefaceUsingTypefaceStyleRetOiIg, Typeface.create(Typeface.DEFAULT, zzcz.m1641getAndroidTypefaceStyleFO1MlWM(fontWeight, r9))) && !Intrinsics.areEqual(m1644createAndroidTypefaceUsingTypefaceStyleRetOiIg, m1644createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, r9))) {
                z6 = true;
            }
            if (z6) {
                typeface = m1644createAndroidTypefaceUsingTypefaceStyleRetOiIg;
            }
        }
        if (typeface == null) {
            return m1644createAndroidTypefaceUsingTypefaceStyleRetOiIg(name2, fontWeight, r9);
        }
        return typeface;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(((zzod) zzoc.zza.zzb.zza()).zzb());
    }
}
