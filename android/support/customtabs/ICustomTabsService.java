package android.support.customtabs;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.browser.customtabs.CustomTabsClient;

/* loaded from: classes.dex */
public interface ICustomTabsService extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ICustomTabsService {
        public static final /* synthetic */ int $r8$clinit = 0;

        /* loaded from: classes.dex */
        public static class Proxy implements ICustomTabsService {
            public final IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.customtabs.ICustomTabsService
            public final boolean newSession(CustomTabsClient.AnonymousClass2 anonymousClass2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeStrongBinder(anonymousClass2);
                    boolean z = false;
                    if (!this.mRemote.transact(3, obtain, obtain2, 0)) {
                        int r5 = Stub.$r8$clinit;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public final boolean warmup() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeLong(0L);
                    boolean z = false;
                    if (!this.mRemote.transact(2, obtain, obtain2, 0)) {
                        int r2 = Stub.$r8$clinit;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    boolean newSession(CustomTabsClient.AnonymousClass2 anonymousClass2) throws RemoteException;

    boolean warmup() throws RemoteException;
}
