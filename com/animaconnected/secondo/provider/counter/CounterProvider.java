package com.animaconnected.secondo.provider.counter;

import com.animaconnected.secondo.KronabyApplication;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class CounterProvider {
    private static CounterProvider sInstance;
    private final Set<CounterChangedListener> mListeners = new CopyOnWriteArraySet();
    private final CounterStorage mStorage = new CounterStorage(KronabyApplication.getContext());

    private CounterProvider() {
    }

    public static CounterProvider getInstance() {
        if (sInstance == null) {
            sInstance = new CounterProvider();
        }
        return sInstance;
    }

    private void notifyDataChanged() {
        Iterator<CounterChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onCounterChanged();
        }
    }

    public void addCount(int r2) {
        int count = this.mStorage.getCount() + r2;
        if (count > 999) {
            count = 999;
        }
        this.mStorage.setCount(count);
        notifyDataChanged();
    }

    public int getCount() {
        return this.mStorage.getCount();
    }

    public void registerCounterChangedListener(CounterChangedListener counterChangedListener) {
        this.mListeners.add(counterChangedListener);
    }

    public void removeCount(int r2) {
        int count = this.mStorage.getCount() - r2;
        if (count < 0) {
            count = 0;
        }
        this.mStorage.setCount(count);
        notifyDataChanged();
    }

    public void resetCount() {
        this.mStorage.setCount(0);
        notifyDataChanged();
    }

    public void unregisterCounterChangedListener(CounterChangedListener counterChangedListener) {
        this.mListeners.remove(counterChangedListener);
    }
}
