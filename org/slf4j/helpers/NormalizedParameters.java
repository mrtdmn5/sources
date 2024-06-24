package org.slf4j.helpers;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import com.google.android.gms.internal.measurement.zzai;
import com.google.android.gms.internal.measurement.zzal;
import com.google.android.gms.internal.measurement.zzap;
import com.google.android.gms.internal.measurement.zzat;
import com.google.android.gms.internal.measurement.zzg;
import com.google.android.gms.internal.measurement.zzh;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class NormalizedParameters {
    public static final AnnotatedString getSelectedText(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<this>");
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        annotatedString.getClass();
        long j = textFieldValue.selection;
        return annotatedString.subSequence(TextRange.m525getMinimpl(j), TextRange.m524getMaximpl(j));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue textFieldValue, int r4) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<this>");
        long j = textFieldValue.selection;
        int m524getMaximpl = TextRange.m524getMaximpl(j);
        int m524getMaximpl2 = TextRange.m524getMaximpl(j) + r4;
        AnnotatedString annotatedString = textFieldValue.annotatedString;
        return annotatedString.subSequence(m524getMaximpl, Math.min(m524getMaximpl2, annotatedString.text.length()));
    }

    public static final AnnotatedString getTextBeforeSelection(TextFieldValue textFieldValue, int r4) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<this>");
        long j = textFieldValue.selection;
        return textFieldValue.annotatedString.subSequence(Math.max(0, TextRange.m525getMinimpl(j) - r4), TextRange.m525getMinimpl(j));
    }

    public static zzap zza(zzal zzalVar, zzat zzatVar, zzg zzgVar, ArrayList arrayList) {
        String str = zzatVar.zza;
        if (zzalVar.zzt(str)) {
            zzap zzf = zzalVar.zzf(str);
            if (zzf instanceof zzai) {
                return ((zzai) zzf).zza(zzgVar, arrayList);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", str));
        }
        if ("hasOwnProperty".equals(str)) {
            zzh.zzh("hasOwnProperty", 1, arrayList);
            if (zzalVar.zzt(zzgVar.zzb((zzap) arrayList.get(0)).zzi())) {
                return zzap.zzk;
            }
            return zzap.zzl;
        }
        throw new IllegalArgumentException(String.format("Object has no function %s", str));
    }
}
