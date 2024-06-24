package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidClipboardManager.android.kt */
/* loaded from: classes.dex */
public final class DecodeHelper {
    public final Parcel parcel;

    public DecodeHelper(String str) {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
        byte[] decode = Base64.decode(str, 0);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
    }

    public final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    public final float decodeFloat() {
        return this.parcel.readFloat();
    }

    /* renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m496decodeTextUnitXSAIIZE() {
        long j;
        byte readByte = this.parcel.readByte();
        if (readByte == 1) {
            j = 4294967296L;
        } else if (readByte == 2) {
            j = 8589934592L;
        } else {
            j = 0;
        }
        if (TextUnitType.m601equalsimpl0(j, 0L)) {
            return TextUnit.Unspecified;
        }
        return TextUnitKt.pack(decodeFloat(), j);
    }
}
