package com.polidea.rxandroidble2.internal.util;

import android.os.ParcelUuid;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class ScanRecordParser {
    public static final UUID BASE_UUID = UUID.fromString("00000000-0000-1000-8000-00805F9B34FB");

    public static byte[] extractBytes(byte[] bArr, int r3, int r4) {
        byte[] bArr2 = new byte[r4];
        System.arraycopy(bArr, r3, bArr2, 0, r4);
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.polidea.rxandroidble2.internal.scan.ScanRecordImplCompat parseFromBytes(byte[] r13) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.internal.util.ScanRecordParser.parseFromBytes(byte[]):com.polidea.rxandroidble2.internal.scan.ScanRecordImplCompat");
    }

    public static void parseServiceSolicitationUuid(byte[] bArr, int r2, int r3, int r4, ArrayList arrayList) {
        while (r3 > 0) {
            arrayList.add(parseUuidFrom(extractBytes(bArr, r2, r4)));
            r3 -= r4;
            r2 += r4;
        }
    }

    public static void parseServiceUuid(byte[] bArr, int r2, int r3, int r4, ArrayList arrayList) {
        while (r3 > 0) {
            arrayList.add(parseUuidFrom(extractBytes(bArr, r2, r4)));
            r3 -= r4;
            r2 += r4;
        }
    }

    public static ParcelUuid parseUuidFrom(byte[] bArr) {
        long j;
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("uuidBytes length invalid - ", length));
        }
        if (length == 16) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
        }
        if (length == 2) {
            j = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
        } else {
            j = ((bArr[3] & 255) << 24) + (bArr[0] & 255) + ((bArr[1] & 255) << 8) + ((bArr[2] & 255) << 16);
        }
        UUID r8 = BASE_UUID;
        return new ParcelUuid(new UUID(r8.getMostSignificantBits() + (j << 32), r8.getLeastSignificantBits()));
    }
}
