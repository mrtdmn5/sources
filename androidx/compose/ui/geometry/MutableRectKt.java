package androidx.compose.ui.geometry;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.IntOffset;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfj;

/* compiled from: MutableRect.kt */
/* loaded from: classes.dex */
public final class MutableRectKt {
    public static final int access$calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable lookaheadCapablePlaceable, AlignmentLine alignmentLine) {
        boolean z;
        int r5;
        LookaheadCapablePlaceable child = lookaheadCapablePlaceable.getChild();
        if (child != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (lookaheadCapablePlaceable.getMeasureResult$ui_release().getAlignmentLines().containsKey(alignmentLine)) {
                Integer num = lookaheadCapablePlaceable.getMeasureResult$ui_release().getAlignmentLines().get(alignmentLine);
                if (num == null) {
                    return Integer.MIN_VALUE;
                }
                return num.intValue();
            }
            int r3 = child.get(alignmentLine);
            if (r3 == Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            child.isShallowPlacing = true;
            lookaheadCapablePlaceable.isPlacingForAlignment = true;
            lookaheadCapablePlaceable.replace$ui_release();
            child.isShallowPlacing = false;
            lookaheadCapablePlaceable.isPlacingForAlignment = false;
            if (alignmentLine instanceof HorizontalAlignmentLine) {
                r5 = IntOffset.m590getYimpl(child.mo454getPositionnOccac());
            } else {
                long mo454getPositionnOccac = child.mo454getPositionnOccac();
                int r0 = IntOffset.$r8$clinit;
                r5 = (int) (mo454getPositionnOccac >> 32);
            }
            return r5 + r3;
        }
        throw new IllegalStateException(("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line").toString());
    }

    public static String zzb(String str, String[] strArr, String[] strArr2) {
        int min = Math.min(strArr.length, strArr2.length);
        for (int r1 = 0; r1 < min; r1++) {
            String str2 = strArr[r1];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[r1];
            }
        }
        return null;
    }

    public static String zzc(Context context, String str) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str)) {
            str = zzfj.zza(context);
        }
        int identifier = resources.getIdentifier("google_app_id", "string", str);
        if (identifier != 0) {
            try {
                return resources.getString(identifier);
            } catch (Resources.NotFoundException unused) {
                return null;
            }
        }
        return null;
    }
}
