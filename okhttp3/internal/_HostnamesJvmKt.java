package okhttp3.internal;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.common.base.Strings;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* compiled from: -HostnamesJvm.kt */
/* loaded from: classes4.dex */
public final class _HostnamesJvmKt {
    public static String badPositionIndex(int r0, int r1, String str) {
        if (r0 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(r0));
        }
        if (r1 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(r0), Integer.valueOf(r1));
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("negative size: ", r1));
    }

    public static void checkElementIndex(int r2, int r3) {
        String lenientFormat;
        if (r2 >= 0 && r2 < r3) {
            return;
        }
        if (r2 >= 0) {
            if (r3 >= 0) {
                lenientFormat = Strings.lenientFormat("%s (%s) must be less than size (%s)", AnalyticsConstants.KEY_INDEX, Integer.valueOf(r2), Integer.valueOf(r3));
            } else {
                throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("negative size: ", r3));
            }
        } else {
            lenientFormat = Strings.lenientFormat("%s (%s) must not be negative", AnalyticsConstants.KEY_INDEX, Integer.valueOf(r2));
        }
        throw new IndexOutOfBoundsException(lenientFormat);
    }

    public static void checkPositionIndexes(int r1, int r2, int r3) {
        String badPositionIndex;
        if (r1 >= 0 && r2 >= r1 && r2 <= r3) {
            return;
        }
        if (r1 >= 0 && r1 <= r3) {
            if (r2 >= 0 && r2 <= r3) {
                badPositionIndex = Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(r2), Integer.valueOf(r1));
            } else {
                badPositionIndex = badPositionIndex(r2, r3, "end index");
            }
        } else {
            badPositionIndex = badPositionIndex(r1, r3, "start index");
        }
        throw new IndexOutOfBoundsException(badPositionIndex);
    }

    public static final SerializationStrategy findPolymorphicSerializer(AbstractPolymorphicSerializer abstractPolymorphicSerializer, Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(abstractPolymorphicSerializer, "<this>");
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationStrategy findPolymorphicSerializerOrNull = abstractPolymorphicSerializer.findPolymorphicSerializerOrNull(encoder, (Encoder) value);
        if (findPolymorphicSerializerOrNull == null) {
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(value.getClass());
            KClass baseClass = abstractPolymorphicSerializer.getBaseClass();
            Intrinsics.checkNotNullParameter(baseClass, "baseClass");
            String simpleName = orCreateKotlinClass.getSimpleName();
            if (simpleName == null) {
                simpleName = String.valueOf(orCreateKotlinClass);
            }
            InstantApps.throwSubtypeNotRegistered(simpleName, baseClass);
            throw null;
        }
        return findPolymorphicSerializerOrNull;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String toCanonicalHost(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._HostnamesJvmKt.toCanonicalHost(java.lang.String):java.lang.String");
    }

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
