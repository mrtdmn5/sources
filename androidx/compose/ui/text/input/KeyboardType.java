package androidx.compose.ui.text.input;

import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;

/* compiled from: KeyboardType.kt */
/* loaded from: classes.dex */
public final class KeyboardType implements zzdq {
    public static final /* synthetic */ KeyboardType zza = new KeyboardType();

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m544toStringimpl(int r3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = false;
        if (r3 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Text";
        }
        if (r3 == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Ascii";
        }
        if (r3 == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "Number";
        }
        if (r3 == 4) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return "Phone";
        }
        if (r3 == 5) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            return "Uri";
        }
        if (r3 == 6) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            return "Email";
        }
        if (r3 == 7) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return "Password";
        }
        if (r3 == 8) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            return "NumberPassword";
        }
        if (r3 == 9) {
            z9 = true;
        }
        if (z9) {
            return "Decimal";
        }
        return "Invalid";
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Long.valueOf(zznn.zza.zza().zzr());
    }
}
