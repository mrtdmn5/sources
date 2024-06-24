package com.animaconnected.secondo.provider.stopwatch;

import android.content.SharedPreferences;
import android.util.Log;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class StopwatchProvider implements DeviceConnectionListener {
    private static final String MODEL = "laps";
    private static final String PREFERENCES_NAME = "com.kronaby.watch.stopwatchprovider";
    private static final String TAG = "StopwatchProvider";
    private static StopwatchProvider sInstance;
    private static final Type sLapsType = new TypeToken<ArrayList<Lap>>() { // from class: com.animaconnected.secondo.provider.stopwatch.StopwatchProvider.1
    }.getType();
    private List<Lap> mLaps;
    private int mTotalTime = -1;
    private final Set<LapsUpdateListener> mListeners = new CopyOnWriteArraySet();

    /* loaded from: classes3.dex */
    public interface LapsUpdateListener {
        void onLapsUpdated();
    }

    private StopwatchProvider() {
        ProviderFactory.getWatch().registerDeviceConnectionListener(this);
    }

    public static StopwatchProvider getInstance() {
        if (sInstance == null) {
            sInstance = new StopwatchProvider();
        }
        return sInstance;
    }

    private SharedPreferences getSharedPreferences() {
        return KronabyApplication.getContext().getSharedPreferences(PREFERENCES_NAME, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$0(List list) {
        this.mLaps = new ArrayList();
        this.mTotalTime = 0;
        int r1 = Integer.MAX_VALUE;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        for (int r2 = 0; r2 < list.size(); r2++) {
            int intValue = ((Integer[]) list.get(r2))[0].intValue();
            if (intValue != 0) {
                int r52 = intValue - r5;
                if (r52 < r1) {
                    r1 = r52;
                    r4 = r6;
                }
                if (r52 > r7) {
                    r7 = r52;
                    r3 = r6;
                }
                r6++;
                this.mLaps.add(Lap.createLap(r6, r52));
                this.mTotalTime += r52;
                r5 = intValue;
            }
        }
        if (!this.mLaps.isEmpty()) {
            this.mLaps.get(r3).mWorst = true;
            this.mLaps.get(r4).mBest = true;
            Collections.reverse(this.mLaps);
            save();
            notifyLapsUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$update$1(Throwable th) {
        Log.d(TAG, "Failed to read stopwatch data", th);
    }

    private void load() {
        String string;
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (sharedPreferences.contains(MODEL) && (string = sharedPreferences.getString(MODEL, null)) != null) {
            this.mLaps = (List) new Gson().fromJson(string, sLapsType);
        }
        if (this.mLaps == null) {
            this.mLaps = new ArrayList();
        }
    }

    private void notifyLapsUpdated() {
        Iterator<LapsUpdateListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onLapsUpdated();
        }
    }

    private void save() {
        if (this.mLaps != null) {
            getSharedPreferences().edit().putString(MODEL, new Gson().toJson(this.mLaps)).apply();
        }
    }

    public List<Lap> getAllLaps() {
        if (this.mLaps == null) {
            load();
        }
        return this.mLaps;
    }

    public int getTotalTime() {
        if (this.mTotalTime == -1) {
            this.mTotalTime = 0;
            Iterator<Lap> it = getAllLaps().iterator();
            while (it.hasNext()) {
                this.mTotalTime += it.next().mLapTimeInMilliseconds;
            }
        }
        return this.mTotalTime;
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        update();
    }

    public void registerLapsUpdateListener(LapsUpdateListener lapsUpdateListener) {
        this.mListeners.add(lapsUpdateListener);
    }

    public void unregisterLapsUpdateListener(LapsUpdateListener lapsUpdateListener) {
        this.mListeners.remove(lapsUpdateListener);
    }

    public void update() {
        WatchProvider watch = ProviderFactory.getWatch();
        if (!watch.getCapabilities().getHasStopwatch()) {
            return;
        }
        watch.readStopwatch().success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.stopwatch.StopwatchProvider$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                StopwatchProvider.this.lambda$update$0((List) obj);
            }
        }).fail(new StopwatchProvider$$ExternalSyntheticLambda1());
    }
}
