package android.support.customtabs;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICustomTabsCallback extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ICustomTabsCallback {
        public Stub() {
            attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r4, Parcel parcel, Parcel parcel2, int r7) throws RemoteException {
            if (r4 != 1598968902) {
                switch (r4) {
                    case 2:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readInt();
                        if (parcel.readInt() != 0) {
                        }
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                        }
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        if (parcel.readInt() != 0) {
                        }
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                        }
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readInt();
                        if (parcel.readInt() != 0) {
                        }
                        parcel.readInt();
                        if (parcel.readInt() != 0) {
                        }
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                        }
                        parcel2.writeNoException();
                        parcel2.writeInt(0);
                        return true;
                    default:
                        return super.onTransact(r4, parcel, parcel2, r7);
                }
            }
            parcel2.writeString("android.support.customtabs.ICustomTabsCallback");
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}
