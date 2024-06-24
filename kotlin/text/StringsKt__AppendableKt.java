package kotlin.text;

import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: Appendable.kt */
/* loaded from: classes.dex */
public class StringsKt__AppendableKt implements zzdq {
    public static final /* synthetic */ StringsKt__AppendableKt zza = new StringsKt__AppendableKt();

    public static final void appendElement(Appendable appendable, Object obj, Function1 function1) {
        boolean z;
        if (function1 != null) {
            appendable.append((CharSequence) function1.invoke(obj));
            return;
        }
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof CharSequence;
        }
        if (z) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(String.valueOf(obj));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Integer.valueOf((int) zznn.zza.zza().zzf());
    }
}
