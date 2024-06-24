package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    public Random mRandom = new Random();
    public final HashMap mRcToKey = new HashMap();
    public final HashMap mKeyToRc = new HashMap();
    public final HashMap mKeyToLifecycleContainers = new HashMap();
    public ArrayList<String> mLaunchedKeys = new ArrayList<>();
    public final transient HashMap mKeyToCallback = new HashMap();
    public final HashMap mParsedPendingResults = new HashMap();
    public final Bundle mPendingResults = new Bundle();

    /* renamed from: androidx.activity.result.ActivityResultRegistry$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass3 extends ActivityResultLauncher<Object> {
        public final /* synthetic */ ActivityResultContract val$contract;
        public final /* synthetic */ String val$key;

        public AnonymousClass3(String str, ActivityResultContract activityResultContract) {
            this.val$key = str;
            this.val$contract = activityResultContract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public final void launch(Object obj) {
            ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
            HashMap hashMap = activityResultRegistry.mKeyToRc;
            String str = this.val$key;
            Integer num = (Integer) hashMap.get(str);
            ActivityResultContract activityResultContract = this.val$contract;
            if (num != null) {
                activityResultRegistry.mLaunchedKeys.add(str);
                try {
                    activityResultRegistry.onLaunch(num.intValue(), activityResultContract, obj);
                    return;
                } catch (Exception e) {
                    activityResultRegistry.mLaunchedKeys.remove(str);
                    throw e;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public final void unregister() {
            ActivityResultRegistry.this.unregister(this.val$key);
        }
    }

    /* loaded from: classes.dex */
    public static class CallbackAndContract<O> {
        public final ActivityResultCallback<O> mCallback;
        public final ActivityResultContract<?, O> mContract;

        public CallbackAndContract(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
            this.mCallback = activityResultCallback;
            this.mContract = activityResultContract;
        }
    }

    /* loaded from: classes.dex */
    public static class LifecycleContainer {
        public final Lifecycle mLifecycle;
        public final ArrayList<LifecycleEventObserver> mObservers = new ArrayList<>();

        public LifecycleContainer(Lifecycle lifecycle) {
            this.mLifecycle = lifecycle;
        }
    }

    public final boolean dispatchResult(int r4, int r5, Intent intent) {
        ActivityResultCallback<O> activityResultCallback;
        String str = (String) this.mRcToKey.get(Integer.valueOf(r4));
        if (str == null) {
            return false;
        }
        CallbackAndContract callbackAndContract = (CallbackAndContract) this.mKeyToCallback.get(str);
        if (callbackAndContract != null && (activityResultCallback = callbackAndContract.mCallback) != 0 && this.mLaunchedKeys.contains(str)) {
            activityResultCallback.onActivityResult(callbackAndContract.mContract.parseResult(intent, r5));
            this.mLaunchedKeys.remove(str);
            return true;
        }
        this.mParsedPendingResults.remove(str);
        this.mPendingResults.putParcelable(str, new ActivityResult(intent, r5));
        return true;
    }

    public abstract void onLaunch(int r1, ActivityResultContract activityResultContract, @SuppressLint({"UnknownNullness"}) Object obj);

    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.activity.result.ActivityResultRegistry$2] */
    public final AnonymousClass2 register(final String str, LifecycleOwner lifecycleOwner, final ActivityResultContract activityResultContract, final ActivityResultCallback activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            registerKey(str);
            HashMap hashMap = this.mKeyToLifecycleContainers;
            LifecycleContainer lifecycleContainer = (LifecycleContainer) hashMap.get(str);
            if (lifecycleContainer == null) {
                lifecycleContainer = new LifecycleContainer(lifecycle);
            }
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                    boolean equals = Lifecycle.Event.ON_START.equals(event);
                    String str2 = str;
                    ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
                    if (equals) {
                        HashMap hashMap2 = activityResultRegistry.mKeyToCallback;
                        ActivityResultContract activityResultContract2 = activityResultContract;
                        ActivityResultCallback activityResultCallback2 = activityResultCallback;
                        hashMap2.put(str2, new CallbackAndContract(activityResultContract2, activityResultCallback2));
                        HashMap hashMap3 = activityResultRegistry.mParsedPendingResults;
                        if (hashMap3.containsKey(str2)) {
                            Object obj = hashMap3.get(str2);
                            hashMap3.remove(str2);
                            activityResultCallback2.onActivityResult(obj);
                        }
                        Bundle bundle = activityResultRegistry.mPendingResults;
                        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str2);
                        if (activityResult != null) {
                            bundle.remove(str2);
                            activityResultCallback2.onActivityResult(activityResultContract2.parseResult(activityResult.mData, activityResult.mResultCode));
                            return;
                        }
                        return;
                    }
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        activityResultRegistry.mKeyToCallback.remove(str2);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        activityResultRegistry.unregister(str2);
                    }
                }
            };
            lifecycleContainer.mLifecycle.addObserver(lifecycleEventObserver);
            lifecycleContainer.mObservers.add(lifecycleEventObserver);
            hashMap.put(str, lifecycleContainer);
            return new ActivityResultLauncher<Object>() { // from class: androidx.activity.result.ActivityResultRegistry.2
                @Override // androidx.activity.result.ActivityResultLauncher
                public final void launch(Object obj) {
                    ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
                    HashMap hashMap2 = activityResultRegistry.mKeyToRc;
                    String str2 = str;
                    Integer num = (Integer) hashMap2.get(str2);
                    ActivityResultContract activityResultContract2 = activityResultContract;
                    if (num != null) {
                        activityResultRegistry.mLaunchedKeys.add(str2);
                        try {
                            activityResultRegistry.onLaunch(num.intValue(), activityResultContract2, obj);
                            return;
                        } catch (Exception e) {
                            activityResultRegistry.mLaunchedKeys.remove(str2);
                            throw e;
                        }
                    }
                    throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                }

                @Override // androidx.activity.result.ActivityResultLauncher
                public final void unregister() {
                    ActivityResultRegistry.this.unregister(str);
                }
            };
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final void registerKey(String str) {
        HashMap hashMap = this.mKeyToRc;
        if (((Integer) hashMap.get(str)) != null) {
            return;
        }
        int nextInt = this.mRandom.nextInt(2147418112);
        while (true) {
            int r1 = nextInt + 65536;
            HashMap hashMap2 = this.mRcToKey;
            if (hashMap2.containsKey(Integer.valueOf(r1))) {
                nextInt = this.mRandom.nextInt(2147418112);
            } else {
                hashMap2.put(Integer.valueOf(r1), str);
                hashMap.put(str, Integer.valueOf(r1));
                return;
            }
        }
    }

    public final void unregister(String str) {
        Integer num;
        if (!this.mLaunchedKeys.contains(str) && (num = (Integer) this.mKeyToRc.remove(str)) != null) {
            this.mRcToKey.remove(num);
        }
        this.mKeyToCallback.remove(str);
        HashMap hashMap = this.mParsedPendingResults;
        if (hashMap.containsKey(str)) {
            StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Dropping pending result for request ", str, ": ");
            m.append(hashMap.get(str));
            Log.w("ActivityResultRegistry", m.toString());
            hashMap.remove(str);
        }
        Bundle bundle = this.mPendingResults;
        if (bundle.containsKey(str)) {
            StringBuilder m2 = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Dropping pending result for request ", str, ": ");
            m2.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", m2.toString());
            bundle.remove(str);
        }
        HashMap hashMap2 = this.mKeyToLifecycleContainers;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) hashMap2.get(str);
        if (lifecycleContainer != null) {
            ArrayList<LifecycleEventObserver> arrayList = lifecycleContainer.mObservers;
            Iterator<LifecycleEventObserver> it = arrayList.iterator();
            while (it.hasNext()) {
                lifecycleContainer.mLifecycle.removeObserver(it.next());
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }

    public final AnonymousClass3 register(String str, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        registerKey(str);
        this.mKeyToCallback.put(str, new CallbackAndContract(activityResultContract, activityResultCallback));
        HashMap hashMap = this.mParsedPendingResults;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        Bundle bundle = this.mPendingResults;
        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
        if (activityResult != null) {
            bundle.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.mData, activityResult.mResultCode));
        }
        return new AnonymousClass3(str, activityResultContract);
    }
}
