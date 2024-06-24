package okio;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class Okio__OkioKt {
    public static String zza(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String sb;
        int r0 = 0;
        int r1 = 0;
        while (true) {
            length = objArr.length;
            if (r1 >= length) {
                break;
            }
            Object obj = objArr[r1];
            if (obj == null) {
                sb = Constants.NULL_VERSION_ID;
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str2), (Throwable) e);
                    StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("<", str2, " threw ");
                    m.append(e.getClass().getName());
                    m.append(">");
                    sb = m.toString();
                }
            }
            objArr[r1] = sb;
            r1++;
        }
        StringBuilder sb2 = new StringBuilder((length * 16) + str.length());
        int r2 = 0;
        while (true) {
            length2 = objArr.length;
            if (r0 >= length2 || (indexOf = str.indexOf("%s", r2)) == -1) {
                break;
            }
            sb2.append((CharSequence) str, r2, indexOf);
            sb2.append(objArr[r0]);
            r2 = indexOf + 2;
            r0++;
        }
        sb2.append((CharSequence) str, r2, str.length());
        if (r0 < length2) {
            sb2.append(" [");
            sb2.append(objArr[r0]);
            for (int r11 = r0 + 1; r11 < objArr.length; r11++) {
                sb2.append(", ");
                sb2.append(objArr[r11]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }
}
