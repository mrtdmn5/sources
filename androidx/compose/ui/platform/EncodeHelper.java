package androidx.compose.ui.platform;

import android.os.Parcel;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidClipboardManager.android.kt */
/* loaded from: classes.dex */
public final class EncodeHelper {
    public Parcel parcel;

    public EncodeHelper() {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    /* renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m498encodeR2X_6o(long j) {
        long m597getTypeUIouoOA = TextUnit.m597getTypeUIouoOA(j);
        byte b = 0;
        if (!TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 0L)) {
            if (TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 4294967296L)) {
                b = 1;
            } else if (TextUnitType.m601equalsimpl0(m597getTypeUIouoOA, 8589934592L)) {
                b = 2;
            }
        }
        encode(b);
        if (!TextUnitType.m601equalsimpl0(TextUnit.m597getTypeUIouoOA(j), 0L)) {
            encode(TextUnit.m598getValueimpl(j));
        }
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }
}
