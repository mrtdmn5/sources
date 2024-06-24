package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.IResultReceiver;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new AnonymousClass1();
    public IResultReceiver mReceiver;

    /* renamed from: android.support.v4.os.ResultReceiver$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        public final ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ResultReceiver[] newArray(int r1) {
            return new ResultReceiver[r1];
        }
    }

    /* loaded from: classes.dex */
    public class MyResultReceiver extends IResultReceiver.Stub {
        public MyResultReceiver() {
        }
    }

    public ResultReceiver(Parcel parcel) {
        IResultReceiver proxy;
        IBinder readStrongBinder = parcel.readStrongBinder();
        int r0 = IResultReceiver.Stub.$r8$clinit;
        if (readStrongBinder == null) {
            proxy = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(IResultReceiver.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IResultReceiver)) {
                proxy = (IResultReceiver) queryLocalInterface;
            } else {
                proxy = new IResultReceiver.Stub.Proxy(readStrongBinder);
            }
        }
        this.mReceiver = proxy;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r2) {
        synchronized (this) {
            if (this.mReceiver == null) {
                this.mReceiver = new MyResultReceiver();
            }
            parcel.writeStrongBinder(this.mReceiver.asBinder());
        }
    }

    public void onReceiveResult(int r1, Bundle bundle) {
    }
}
