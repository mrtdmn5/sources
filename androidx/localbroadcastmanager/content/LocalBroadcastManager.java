package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.animaconnected.firebase.AnalyticsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public final class LocalBroadcastManager {
    public static LocalBroadcastManager mInstance;
    public static final Object mLock = new Object();
    public final Context mAppContext;
    public final AnonymousClass1 mHandler;
    public final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers = new HashMap<>();
    public final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    public final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();

    /* loaded from: classes.dex */
    public static final class BroadcastRecord {
        public final Intent intent;
        public final ArrayList<ReceiverRecord> receivers;

        public BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class ReceiverRecord {
        public boolean broadcasting;
        public boolean dead;
        public final IntentFilter filter;
        public final BroadcastReceiver receiver;

        public ReceiverRecord(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.dead) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.localbroadcastmanager.content.LocalBroadcastManager$1] */
    public LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: androidx.localbroadcastmanager.content.LocalBroadcastManager.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int size;
                BroadcastRecord[] broadcastRecordArr;
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.this;
                while (true) {
                    synchronized (localBroadcastManager.mReceivers) {
                        size = localBroadcastManager.mPendingBroadcasts.size();
                        if (size <= 0) {
                            return;
                        }
                        broadcastRecordArr = new BroadcastRecord[size];
                        localBroadcastManager.mPendingBroadcasts.toArray(broadcastRecordArr);
                        localBroadcastManager.mPendingBroadcasts.clear();
                    }
                    for (int r3 = 0; r3 < size; r3++) {
                        BroadcastRecord broadcastRecord = broadcastRecordArr[r3];
                        int size2 = broadcastRecord.receivers.size();
                        for (int r6 = 0; r6 < size2; r6++) {
                            ReceiverRecord receiverRecord = broadcastRecord.receivers.get(r6);
                            if (!receiverRecord.dead) {
                                receiverRecord.receiver.onReceive(localBroadcastManager.mAppContext, broadcastRecord.intent);
                            }
                        }
                    }
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    public final void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(broadcastReceiver, intentFilter);
            ArrayList<ReceiverRecord> arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (int r7 = 0; r7 < intentFilter.countActions(); r7++) {
                String action = intentFilter.getAction(r7);
                ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    public final void sendBroadcast(Intent intent) {
        boolean z;
        ArrayList<ReceiverRecord> arrayList;
        int r20;
        String str;
        ?? r12;
        String str2;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            int r11 = 1;
            boolean z2 = false;
            if ((intent.getFlags() & 8) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(intent.getAction());
            if (arrayList2 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                }
                ArrayList arrayList3 = null;
                int r9 = 0;
                while (r9 < arrayList2.size()) {
                    ReceiverRecord receiverRecord = arrayList2.get(r9);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.filter);
                    }
                    if (receiverRecord.broadcasting) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        arrayList = arrayList2;
                        r20 = r9;
                        str = action;
                        r12 = r11;
                    } else {
                        String str3 = action;
                        arrayList = arrayList2;
                        r20 = r9;
                        str = action;
                        r12 = r11;
                        int match = receiverRecord.filter.match(str3, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(receiverRecord);
                            receiverRecord.broadcasting = r12;
                        } else if (z) {
                            if (match != -4) {
                                if (match != -3) {
                                    if (match != -2) {
                                        if (match != -1) {
                                            str2 = "unknown reason";
                                        } else {
                                            str2 = "type";
                                        }
                                    } else {
                                        str2 = "data";
                                    }
                                } else {
                                    str2 = AnalyticsConstants.KEY_ACTION;
                                }
                            } else {
                                str2 = "category";
                            }
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + str2);
                        }
                    }
                    r9 = r20 + 1;
                    r11 = r12;
                    arrayList2 = arrayList;
                    action = str;
                    z2 = false;
                }
                int r122 = r11;
                if (arrayList3 != null) {
                    for (int r10 = 0; r10 < arrayList3.size(); r10++) {
                        ((ReceiverRecord) arrayList3.get(r10)).broadcasting = false;
                    }
                    this.mPendingBroadcasts.add(new BroadcastRecord(intent, arrayList3));
                    if (!hasMessages(r122)) {
                        sendEmptyMessage(r122);
                    }
                }
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<ReceiverRecord> remove = this.mReceivers.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                ReceiverRecord receiverRecord = remove.get(size);
                receiverRecord.dead = true;
                for (int r5 = 0; r5 < receiverRecord.filter.countActions(); r5++) {
                    String action = receiverRecord.filter.getAction(r5);
                    ArrayList<ReceiverRecord> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            ReceiverRecord receiverRecord2 = arrayList.get(size2);
                            if (receiverRecord2.receiver == broadcastReceiver) {
                                receiverRecord2.dead = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
