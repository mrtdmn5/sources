package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.MultiInstanceInvalidationService;

/* loaded from: classes.dex */
public abstract class IMultiInstanceInvalidationService$Stub extends Binder implements IInterface {
    public IMultiInstanceInvalidationService$Stub() {
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r5, Parcel parcel, Parcel parcel2, int r8) throws RemoteException {
        IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback = null;
        if (r5 != 1) {
            if (r5 != 2) {
                if (r5 != 3) {
                    if (r5 != 1598968902) {
                        return super.onTransact(r5, parcel, parcel2, r8);
                    }
                    parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                    return true;
                }
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                ((MultiInstanceInvalidationService.AnonymousClass2) this).broadcastInvalidation(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            final IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                if (queryLocalInterface != null && (queryLocalInterface instanceof IMultiInstanceInvalidationCallback)) {
                    iMultiInstanceInvalidationCallback = (IMultiInstanceInvalidationCallback) queryLocalInterface;
                } else {
                    iMultiInstanceInvalidationCallback = new IMultiInstanceInvalidationCallback(readStrongBinder) { // from class: androidx.room.IMultiInstanceInvalidationCallback$Stub$Proxy
                        public final IBinder mRemote;

                        {
                            this.mRemote = readStrongBinder;
                        }

                        @Override // android.os.IInterface
                        public final IBinder asBinder() {
                            return this.mRemote;
                        }

                        @Override // androidx.room.IMultiInstanceInvalidationCallback
                        public final void onInvalidation(String[] strArr) throws RemoteException {
                            Parcel obtain = Parcel.obtain();
                            try {
                                obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                                obtain.writeStringArray(strArr);
                                this.mRemote.transact(1, obtain, null, 1);
                            } finally {
                                obtain.recycle();
                            }
                        }
                    };
                }
            }
            int readInt = parcel.readInt();
            MultiInstanceInvalidationService.AnonymousClass2 anonymousClass2 = (MultiInstanceInvalidationService.AnonymousClass2) this;
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService.this.mCallbackList.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(readInt));
            }
            parcel2.writeNoException();
            return true;
        }
        parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
        final IBinder readStrongBinder2 = parcel.readStrongBinder();
        if (readStrongBinder2 != null) {
            IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface2 != null && (queryLocalInterface2 instanceof IMultiInstanceInvalidationCallback)) {
                iMultiInstanceInvalidationCallback = (IMultiInstanceInvalidationCallback) queryLocalInterface2;
            } else {
                iMultiInstanceInvalidationCallback = new IMultiInstanceInvalidationCallback(readStrongBinder2) { // from class: androidx.room.IMultiInstanceInvalidationCallback$Stub$Proxy
                    public final IBinder mRemote;

                    {
                        this.mRemote = readStrongBinder2;
                    }

                    @Override // android.os.IInterface
                    public final IBinder asBinder() {
                        return this.mRemote;
                    }

                    @Override // androidx.room.IMultiInstanceInvalidationCallback
                    public final void onInvalidation(String[] strArr) throws RemoteException {
                        Parcel obtain = Parcel.obtain();
                        try {
                            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                            obtain.writeStringArray(strArr);
                            this.mRemote.transact(1, obtain, null, 1);
                        } finally {
                            obtain.recycle();
                        }
                    }
                };
            }
        }
        int registerCallback = ((MultiInstanceInvalidationService.AnonymousClass2) this).registerCallback(iMultiInstanceInvalidationCallback, parcel.readString());
        parcel2.writeNoException();
        parcel2.writeInt(registerCallback);
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
