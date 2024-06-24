package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {
    public int mMaxClientId = 0;
    public final HashMap<Integer, String> mClientNames = new HashMap<>();
    public final AnonymousClass1 mCallbackList = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() { // from class: androidx.room.MultiInstanceInvalidationService.1
        @Override // android.os.RemoteCallbackList
        public final void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };
    public final AnonymousClass2 mBinder = new AnonymousClass2();

    /* renamed from: androidx.room.MultiInstanceInvalidationService$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends IMultiInstanceInvalidationService$Stub {
        public AnonymousClass2() {
        }

        public final void broadcastInvalidation(int r8, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                String str = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(r8));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = beginBroadcast();
                for (int r3 = 0; r3 < beginBroadcast; r3++) {
                    try {
                        int intValue = ((Integer) getBroadcastCookie(r3)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(intValue));
                        if (r8 != intValue && str.equals(str2)) {
                            try {
                                getBroadcastItem(r3).onInvalidation(strArr);
                            } catch (RemoteException e) {
                                Log.w("ROOM", "Error invoking a remote callback", e);
                            }
                        }
                    } finally {
                        finishBroadcast();
                    }
                }
            }
        }

        public final int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int r3 = multiInstanceInvalidationService.mMaxClientId + 1;
                multiInstanceInvalidationService.mMaxClientId = r3;
                if (multiInstanceInvalidationService.mCallbackList.register(iMultiInstanceInvalidationCallback, Integer.valueOf(r3))) {
                    MultiInstanceInvalidationService.this.mClientNames.put(Integer.valueOf(r3), str);
                    return r3;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.mMaxClientId--;
                return 0;
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
