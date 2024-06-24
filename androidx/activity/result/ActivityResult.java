package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new AnonymousClass1();
    public final Intent mData;
    public final int mResultCode;

    /* renamed from: androidx.activity.result.ActivityResult$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Parcelable.Creator<ActivityResult> {
        @Override // android.os.Parcelable.Creator
        public final ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityResult[] newArray(int r1) {
            return new ActivityResult[r1];
        }
    }

    public ActivityResult(Intent intent, int r2) {
        this.mResultCode = r2;
        this.mData = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int r2 = this.mResultCode;
        if (r2 != -1) {
            if (r2 != 0) {
                str = String.valueOf(r2);
            } else {
                str = "RESULT_CANCELED";
            }
        } else {
            str = "RESULT_OK";
        }
        sb.append(str);
        sb.append(", data=");
        sb.append(this.mData);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int r1;
        parcel.writeInt(this.mResultCode);
        Intent intent = this.mData;
        if (intent == null) {
            r1 = 0;
        } else {
            r1 = 1;
        }
        parcel.writeInt(r1);
        if (intent != null) {
            intent.writeToParcel(parcel, r4);
        }
    }

    public ActivityResult(Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mData = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
