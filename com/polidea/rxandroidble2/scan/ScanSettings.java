package com.polidea.rxandroidble2.scan;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public final class ScanSettings implements Parcelable {
    public static final Parcelable.Creator<ScanSettings> CREATOR = new AnonymousClass1();
    public final int mCallbackType;
    public final int mMatchMode;
    public final int mNumOfMatchesPerFilter;
    public final long mReportDelayMillis;
    public final int mScanMode;
    public final boolean mShouldCheckLocationProviderState;

    /* renamed from: com.polidea.rxandroidble2.scan.ScanSettings$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Parcelable.Creator<ScanSettings> {
        @Override // android.os.Parcelable.Creator
        public final ScanSettings createFromParcel(Parcel parcel) {
            return new ScanSettings(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ScanSettings[] newArray(int r1) {
            return new ScanSettings[r1];
        }
    }

    public ScanSettings(int r1, int r2, long j, int r5, int r6, boolean z) {
        this.mScanMode = r1;
        this.mCallbackType = r2;
        this.mReportDelayMillis = j;
        this.mNumOfMatchesPerFilter = r6;
        this.mMatchMode = r5;
        this.mShouldCheckLocationProviderState = z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        parcel.writeInt(this.mScanMode);
        parcel.writeInt(this.mCallbackType);
        parcel.writeLong(this.mReportDelayMillis);
        parcel.writeInt(this.mMatchMode);
        parcel.writeInt(this.mNumOfMatchesPerFilter);
        parcel.writeInt(this.mShouldCheckLocationProviderState ? 1 : 0);
    }

    public ScanSettings(Parcel parcel) {
        this.mScanMode = parcel.readInt();
        this.mCallbackType = parcel.readInt();
        this.mReportDelayMillis = parcel.readLong();
        this.mMatchMode = parcel.readInt();
        this.mNumOfMatchesPerFilter = parcel.readInt();
        this.mShouldCheckLocationProviderState = parcel.readInt() != 0;
    }
}
