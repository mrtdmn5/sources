package com.polidea.rxandroidble2.scan;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.scan.ScanFilterInterface;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class ScanFilter implements Parcelable, ScanFilterInterface {
    public final String mDeviceAddress;
    public final String mDeviceName;
    public final byte[] mManufacturerData;
    public final byte[] mManufacturerDataMask;
    public final int mManufacturerId;
    public final byte[] mServiceData;
    public final byte[] mServiceDataMask;
    public final ParcelUuid mServiceDataUuid;
    public final ParcelUuid mServiceSolicitationUuid;
    public final ParcelUuid mServiceSolicitationUuidMask;
    public final ParcelUuid mServiceUuid;
    public final ParcelUuid mServiceUuidMask;
    public static final ScanFilter EMPTY = new ScanFilter(null, null, null, null, null, null, null, null, null, -1, null, null);
    public static final Parcelable.Creator<ScanFilter> CREATOR = new AnonymousClass1();

    /* renamed from: com.polidea.rxandroidble2.scan.ScanFilter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Parcelable.Creator<ScanFilter> {
        /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
        @Override // android.os.Parcelable.Creator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.polidea.rxandroidble2.scan.ScanFilter createFromParcel(android.os.Parcel r18) {
            /*
                Method dump skipped, instructions count: 291
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.scan.ScanFilter.AnonymousClass1.createFromParcel(android.os.Parcel):java.lang.Object");
        }

        @Override // android.os.Parcelable.Creator
        public final ScanFilter[] newArray(int r1) {
            return new ScanFilter[r1];
        }
    }

    public ScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, ParcelUuid parcelUuid4, ParcelUuid parcelUuid5, byte[] bArr, byte[] bArr2, int r10, byte[] bArr3, byte[] bArr4) {
        this.mDeviceName = str;
        this.mServiceUuid = parcelUuid;
        this.mServiceUuidMask = parcelUuid2;
        this.mServiceSolicitationUuid = parcelUuid3;
        this.mServiceSolicitationUuidMask = parcelUuid4;
        this.mDeviceAddress = str2;
        this.mServiceDataUuid = parcelUuid5;
        this.mServiceData = bArr;
        this.mServiceDataMask = bArr2;
        this.mManufacturerId = r10;
        this.mManufacturerData = bArr3;
        this.mManufacturerDataMask = bArr4;
    }

    public static boolean deepEquals(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && (bArr == null || bArr2 == null || !Arrays.equals(bArr, bArr2))) {
            return false;
        }
        return true;
    }

    public static boolean matchesPartialData(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        if (bArr2 == null) {
            for (int r7 = 0; r7 < bArr.length; r7++) {
                if (bArr3[r7] != bArr[r7]) {
                    return false;
                }
            }
            return true;
        }
        for (int r2 = 0; r2 < bArr.length; r2++) {
            byte b = bArr2[r2];
            if ((bArr3[r2] & b) != (b & bArr[r2])) {
                return false;
            }
        }
        return true;
    }

    public static boolean matchesServiceUuid(UUID r6, UUID r7, UUID r8) {
        if (r7 == null) {
            return r6.equals(r8);
        }
        if ((r6.getLeastSignificantBits() & r7.getLeastSignificantBits()) != (r8.getLeastSignificantBits() & r7.getLeastSignificantBits())) {
            return false;
        }
        if ((r6.getMostSignificantBits() & r7.getMostSignificantBits()) != (r7.getMostSignificantBits() & r8.getMostSignificantBits())) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ScanFilter.class != obj.getClass()) {
            return false;
        }
        ScanFilter scanFilter = (ScanFilter) obj;
        return equals(this.mDeviceName, scanFilter.mDeviceName) && equals(this.mDeviceAddress, scanFilter.mDeviceAddress) && this.mManufacturerId == scanFilter.mManufacturerId && deepEquals(this.mManufacturerData, scanFilter.mManufacturerData) && deepEquals(this.mManufacturerDataMask, scanFilter.mManufacturerDataMask) && equals(this.mServiceDataUuid, scanFilter.mServiceDataUuid) && deepEquals(this.mServiceData, scanFilter.mServiceData) && deepEquals(this.mServiceDataMask, scanFilter.mServiceDataMask) && equals(this.mServiceUuid, scanFilter.mServiceUuid) && equals(this.mServiceUuidMask, scanFilter.mServiceUuidMask) && equals(this.mServiceSolicitationUuid, scanFilter.mServiceSolicitationUuid) && equals(this.mServiceSolicitationUuidMask, scanFilter.mServiceSolicitationUuidMask);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.mDeviceName, this.mDeviceAddress, Integer.valueOf(this.mManufacturerId), Integer.valueOf(Arrays.hashCode(this.mManufacturerData)), Integer.valueOf(Arrays.hashCode(this.mManufacturerDataMask)), this.mServiceDataUuid, Integer.valueOf(Arrays.hashCode(this.mServiceData)), Integer.valueOf(Arrays.hashCode(this.mServiceDataMask)), this.mServiceUuid, this.mServiceUuidMask, this.mServiceSolicitationUuid, this.mServiceSolicitationUuidMask});
    }

    public final String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb = new StringBuilder("BluetoothLeScanFilter [mDeviceName=");
        sb.append(this.mDeviceName);
        sb.append(", ");
        sb.append(LoggerUtil.commonMacMessage(this.mDeviceAddress));
        sb.append(", mUuid=");
        String str5 = null;
        ParcelUuid parcelUuid = this.mServiceUuid;
        if (parcelUuid == null) {
            str = null;
        } else {
            parcelUuid.getUuid();
            LoggerUtil.getUuidToLog();
            str = "...";
        }
        sb.append(str);
        sb.append(", mUuidMask=");
        ParcelUuid parcelUuid2 = this.mServiceUuidMask;
        if (parcelUuid2 == null) {
            str2 = null;
        } else {
            parcelUuid2.getUuid();
            LoggerUtil.getUuidToLog();
            str2 = "...";
        }
        sb.append(str2);
        sb.append(", mSolicitedUuid=");
        ParcelUuid parcelUuid3 = this.mServiceSolicitationUuid;
        if (parcelUuid3 == null) {
            str3 = null;
        } else {
            parcelUuid3.getUuid();
            LoggerUtil.getUuidToLog();
            str3 = "...";
        }
        sb.append(str3);
        sb.append(", mSolicitedUuidMask=");
        ParcelUuid parcelUuid4 = this.mServiceSolicitationUuidMask;
        if (parcelUuid4 == null) {
            str4 = null;
        } else {
            parcelUuid4.getUuid();
            LoggerUtil.getUuidToLog();
            str4 = "...";
        }
        sb.append(str4);
        sb.append(", mServiceDataUuid=");
        ParcelUuid parcelUuid5 = this.mServiceDataUuid;
        if (parcelUuid5 != null) {
            parcelUuid5.getUuid();
            LoggerUtil.getUuidToLog();
            str5 = "...";
        }
        sb.append(str5);
        sb.append(", mServiceData=");
        sb.append(Arrays.toString(this.mServiceData));
        sb.append(", mServiceDataMask=");
        sb.append(Arrays.toString(this.mServiceDataMask));
        sb.append(", mManufacturerId=");
        sb.append(this.mManufacturerId);
        sb.append(", mManufacturerData=");
        sb.append(Arrays.toString(this.mManufacturerData));
        sb.append(", mManufacturerDataMask=");
        sb.append(Arrays.toString(this.mManufacturerDataMask));
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r6) {
        int r3;
        int r32;
        int r33;
        int r34;
        int r35;
        int r2;
        int r22;
        int r23;
        int r36;
        int r37;
        int r0 = 0;
        String str = this.mDeviceName;
        if (str == null) {
            r3 = 0;
        } else {
            r3 = 1;
        }
        parcel.writeInt(r3);
        if (str != null) {
            parcel.writeString(str);
        }
        String str2 = this.mDeviceAddress;
        if (str2 == null) {
            r32 = 0;
        } else {
            r32 = 1;
        }
        parcel.writeInt(r32);
        if (str2 != null) {
            parcel.writeString(str2);
        }
        ParcelUuid parcelUuid = this.mServiceUuid;
        if (parcelUuid == null) {
            r33 = 0;
        } else {
            r33 = 1;
        }
        parcel.writeInt(r33);
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, r6);
            ParcelUuid parcelUuid2 = this.mServiceUuidMask;
            if (parcelUuid2 == null) {
                r37 = 0;
            } else {
                r37 = 1;
            }
            parcel.writeInt(r37);
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, r6);
            }
        }
        ParcelUuid parcelUuid3 = this.mServiceSolicitationUuid;
        if (parcelUuid3 == null) {
            r34 = 0;
        } else {
            r34 = 1;
        }
        parcel.writeInt(r34);
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, r6);
            ParcelUuid parcelUuid4 = this.mServiceSolicitationUuidMask;
            if (parcelUuid4 == null) {
                r36 = 0;
            } else {
                r36 = 1;
            }
            parcel.writeInt(r36);
            if (parcelUuid4 != null) {
                parcel.writeParcelable(parcelUuid4, r6);
            }
        }
        ParcelUuid parcelUuid5 = this.mServiceDataUuid;
        if (parcelUuid5 == null) {
            r35 = 0;
        } else {
            r35 = 1;
        }
        parcel.writeInt(r35);
        if (parcelUuid5 != null) {
            parcel.writeParcelable(parcelUuid5, r6);
            byte[] bArr = this.mServiceData;
            if (bArr == null) {
                r22 = 0;
            } else {
                r22 = 1;
            }
            parcel.writeInt(r22);
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(bArr);
                byte[] bArr2 = this.mServiceDataMask;
                if (bArr2 == null) {
                    r23 = 0;
                } else {
                    r23 = 1;
                }
                parcel.writeInt(r23);
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(bArr2);
                }
            }
        }
        parcel.writeInt(this.mManufacturerId);
        byte[] bArr3 = this.mManufacturerData;
        if (bArr3 == null) {
            r2 = 0;
        } else {
            r2 = 1;
        }
        parcel.writeInt(r2);
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(bArr3);
            byte[] bArr4 = this.mManufacturerDataMask;
            if (bArr4 != null) {
                r0 = 1;
            }
            parcel.writeInt(r0);
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(bArr4);
            }
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
