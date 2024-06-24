package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IResultReceiver extends IInterface {
    public static final String DESCRIPTOR = "android$support$v4$os$IResultReceiver".replace('$', '.');

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IResultReceiver {
        public static final /* synthetic */ int $r8$clinit = 0;

        /* loaded from: classes.dex */
        public static class Proxy implements IResultReceiver {
            public final IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }
        }

        public Stub() {
            attachInterface(this, IResultReceiver.DESCRIPTOR);
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r4, Parcel parcel, Parcel parcel2, int r7) throws RemoteException {
            Object obj;
            String str = IResultReceiver.DESCRIPTOR;
            if (r4 >= 1 && r4 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (r4 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (r4 != 1) {
                return super.onTransact(r4, parcel, parcel2, r7);
            }
            int readInt = parcel.readInt();
            Parcelable.Creator creator = Bundle.CREATOR;
            if (parcel.readInt() != 0) {
                obj = creator.createFromParcel(parcel);
            } else {
                obj = null;
            }
            ResultReceiver resultReceiver = ResultReceiver.this;
            resultReceiver.getClass();
            resultReceiver.onReceiveResult(readInt, (Bundle) obj);
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}
