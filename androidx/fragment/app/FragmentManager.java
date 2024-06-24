package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.Cancellable;
import androidx.activity.ComponentActivity;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import com.kronaby.watch.app.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class FragmentManager {
    public ArrayList<BackStackRecord> mBackStack;
    public ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    public FragmentContainer mContainer;
    public ArrayList<Fragment> mCreatedMenus;
    public int mCurState;
    public final AnonymousClass4 mDefaultSpecialEffectsControllerFactory;
    public boolean mDestroyed;
    public final AnonymousClass5 mExecCommit;
    public boolean mExecutingActions;
    public boolean mHavePendingDeferredStart;
    public FragmentHostCallback<?> mHost;
    public final AnonymousClass3 mHostFragmentFactory;
    public ArrayDeque<LaunchedFragmentInfo> mLaunchedFragments;
    public final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher;
    public boolean mNeedMenuInvalidate;
    public FragmentManagerViewModel mNonConfig;
    public final CopyOnWriteArrayList<FragmentOnAttachListener> mOnAttachListeners;
    public OnBackPressedDispatcher mOnBackPressedDispatcher;
    public Fragment mParent;
    public Fragment mPrimaryNav;
    public ActivityResultRegistry.AnonymousClass3 mRequestPermissions;
    public ActivityResultRegistry.AnonymousClass3 mStartActivityForResult;
    public ActivityResultRegistry.AnonymousClass3 mStartIntentSenderForResult;
    public boolean mStateSaved;
    public boolean mStopped;
    public ArrayList<Fragment> mTmpAddedFragments;
    public ArrayList<Boolean> mTmpIsPop;
    public ArrayList<BackStackRecord> mTmpRecords;
    public final ArrayList<OpGenerator> mPendingActions = new ArrayList<>();
    public final FragmentStore mFragmentStore = new FragmentStore();
    public final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
    public final AnonymousClass1 mOnBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.fragment.app.FragmentManager.1
        public AnonymousClass1() {
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            FragmentManager fragmentManager = FragmentManager.this;
            fragmentManager.execPendingActions(true);
            if (fragmentManager.mOnBackPressedCallback.isEnabled) {
                fragmentManager.popBackStackImmediate();
            } else {
                fragmentManager.mOnBackPressedDispatcher.onBackPressed();
            }
        }
    };
    public final AtomicInteger mBackStackIndex = new AtomicInteger();
    public final Map<String, Bundle> mResults = Collections.synchronizedMap(new HashMap());
    public final Map<String, Object> mResultListeners = Collections.synchronizedMap(new HashMap());
    public final Map<Fragment, HashSet<CancellationSignal>> mExitAnimationCancellationSignals = Collections.synchronizedMap(new HashMap());

    /* renamed from: androidx.fragment.app.FragmentManager$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends OnBackPressedCallback {
        public AnonymousClass1() {
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            FragmentManager fragmentManager = FragmentManager.this;
            fragmentManager.execPendingActions(true);
            if (fragmentManager.mOnBackPressedCallback.isEnabled) {
                fragmentManager.popBackStackImmediate();
            } else {
                fragmentManager.mOnBackPressedDispatcher.onBackPressed();
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$10 */
    /* loaded from: classes.dex */
    public class AnonymousClass10 implements ActivityResultCallback<ActivityResult> {
        public AnonymousClass10() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(ActivityResult activityResult) {
            ActivityResult activityResult2 = activityResult;
            FragmentManager fragmentManager = FragmentManager.this;
            LaunchedFragmentInfo pollFirst = fragmentManager.mLaunchedFragments.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            FragmentStore fragmentStore = fragmentManager.mFragmentStore;
            String str = pollFirst.mWho;
            Fragment findFragmentByWho = fragmentStore.findFragmentByWho(str);
            if (findFragmentByWho == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
            } else {
                findFragmentByWho.onActivityResult(pollFirst.mRequestCode, activityResult2.mResultCode, activityResult2.mData);
            }
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$11 */
    /* loaded from: classes.dex */
    public class AnonymousClass11 implements ActivityResultCallback<Map<String, Boolean>> {
        public AnonymousClass11() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        @SuppressLint({"SyntheticAccessor"})
        public final void onActivityResult(Map<String, Boolean> map) {
            int r4;
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] r6 = new int[arrayList.size()];
            for (int r3 = 0; r3 < arrayList.size(); r3++) {
                if (((Boolean) arrayList.get(r3)).booleanValue()) {
                    r4 = 0;
                } else {
                    r4 = -1;
                }
                r6[r3] = r4;
            }
            FragmentManager fragmentManager = FragmentManager.this;
            LaunchedFragmentInfo pollFirst = fragmentManager.mLaunchedFragments.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            FragmentStore fragmentStore = fragmentManager.mFragmentStore;
            String str = pollFirst.mWho;
            Fragment findFragmentByWho = fragmentStore.findFragmentByWho(str);
            if (findFragmentByWho == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                return;
            }
            findFragmentByWho.onRequestPermissionsResult(pollFirst.mRequestCode, strArr, r6);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 {
        public AnonymousClass2(FragmentManager fragmentManager) {
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 extends FragmentFactory {
        public AnonymousClass3() {
        }

        @Override // androidx.fragment.app.FragmentFactory
        public final Fragment instantiate(String str) {
            return Fragment.instantiate(FragmentManager.this.mHost.mContext, str, null);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 implements SpecialEffectsControllerFactory {
    }

    /* renamed from: androidx.fragment.app.FragmentManager$5 */
    /* loaded from: classes.dex */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            FragmentManager.this.execPendingActions(true);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$6 */
    /* loaded from: classes.dex */
    class AnonymousClass6 implements LifecycleEventObserver {
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event != Lifecycle.Event.ON_START) {
                if (event != Lifecycle.Event.ON_DESTROY) {
                    return;
                } else {
                    throw null;
                }
            }
            throw null;
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$8 */
    /* loaded from: classes.dex */
    public class AnonymousClass8 implements FragmentOnAttachListener {
        public AnonymousClass8() {
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public final void onAttachFragment$1(Fragment fragment) {
            Fragment.this.onAttachFragment(fragment);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$9 */
    /* loaded from: classes.dex */
    public class AnonymousClass9 implements ActivityResultCallback<ActivityResult> {
        public AnonymousClass9() {
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(ActivityResult activityResult) {
            ActivityResult activityResult2 = activityResult;
            FragmentManager fragmentManager = FragmentManager.this;
            LaunchedFragmentInfo pollFirst = fragmentManager.mLaunchedFragments.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            FragmentStore fragmentStore = fragmentManager.mFragmentStore;
            String str = pollFirst.mWho;
            Fragment findFragmentByWho = fragmentStore.findFragmentByWho(str);
            if (findFragmentByWho == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
            } else {
                findFragmentByWho.onActivityResult(pollFirst.mRequestCode, activityResult2.mResultCode, activityResult2.mData);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent createIntent(ComponentActivity componentActivity, Object obj) {
            Bundle bundleExtra;
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) obj;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = intentSenderRequest.fillInIntent;
            if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    IntentSender intentSender = intentSenderRequest.intentSender;
                    Intrinsics.checkNotNullParameter(intentSender, "intentSender");
                    intentSenderRequest = new IntentSenderRequest(intentSender, null, intentSenderRequest.flagsMask, intentSenderRequest.flagsValues);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object parseResult(Intent intent, int r3) {
            return new ActivityResult(intent, r3);
        }
    }

    /* loaded from: classes.dex */
    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    /* loaded from: classes.dex */
    public interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    public class PopBackStackState implements OpGenerator {
        public final int mFlags;
        public final int mId;
        public final String mName;

        public PopBackStackState(String str, int r3, int r4) {
            this.mName = str;
            this.mId = r3;
            this.mFlags = r4;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.mPrimaryNav;
            if (fragment != null && this.mId < 0 && this.mName == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
                return false;
            }
            return FragmentManager.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        }
    }

    /* loaded from: classes.dex */
    public static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
        public int mNumPostponed;
    }

    public FragmentManager() {
        new Object(this) { // from class: androidx.fragment.app.FragmentManager.2
            public AnonymousClass2(FragmentManager this) {
            }
        };
        this.mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
        this.mOnAttachListeners = new CopyOnWriteArrayList<>();
        this.mCurState = -1;
        this.mHostFragmentFactory = new FragmentFactory() { // from class: androidx.fragment.app.FragmentManager.3
            public AnonymousClass3() {
            }

            @Override // androidx.fragment.app.FragmentFactory
            public final Fragment instantiate(String str) {
                return Fragment.instantiate(FragmentManager.this.mHost.mContext, str, null);
            }
        };
        this.mDefaultSpecialEffectsControllerFactory = new AnonymousClass4();
        this.mLaunchedFragments = new ArrayDeque<>();
        this.mExecCommit = new Runnable() { // from class: androidx.fragment.app.FragmentManager.5
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                FragmentManager.this.execPendingActions(true);
            }
        };
    }

    public static boolean isLoggingEnabled(int r1) {
        if (Log.isLoggable("FragmentManager", r1)) {
            return true;
        }
        return false;
    }

    public static boolean isMenuAvailable(Fragment fragment) {
        boolean z;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        Iterator it = fragment.mChildFragmentManager.mFragmentStore.getActiveFragments().iterator();
        boolean z2 = false;
        while (true) {
            if (it.hasNext()) {
                Fragment fragment2 = (Fragment) it.next();
                if (fragment2 != null) {
                    z2 = isMenuAvailable(fragment2);
                }
                if (z2) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            return true;
        }
        return false;
    }

    public static boolean isPrimaryNavigation(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragment.equals(fragmentManager.mPrimaryNav) && isPrimaryNavigation(fragmentManager.mParent)) {
            return true;
        }
        return false;
    }

    public static void showFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final FragmentStateManager addFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        FragmentStateManager createOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.makeActive(createOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            fragmentStore.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return createOrGetFragmentStateManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public final void attachController(FragmentHostCallback<?> fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        String str;
        if (this.mHost == null) {
            this.mHost = fragmentHostCallback;
            this.mContainer = fragmentContainer;
            this.mParent = fragment;
            CopyOnWriteArrayList<FragmentOnAttachListener> copyOnWriteArrayList = this.mOnAttachListeners;
            if (fragment != null) {
                copyOnWriteArrayList.add(new FragmentOnAttachListener() { // from class: androidx.fragment.app.FragmentManager.8
                    public AnonymousClass8() {
                    }

                    @Override // androidx.fragment.app.FragmentOnAttachListener
                    public final void onAttachFragment$1(Fragment fragment2) {
                        Fragment.this.onAttachFragment(fragment2);
                    }
                });
            } else if (fragmentHostCallback instanceof FragmentOnAttachListener) {
                copyOnWriteArrayList.add((FragmentOnAttachListener) fragmentHostCallback);
            }
            if (this.mParent != null) {
                updateOnBackPressedCallbackEnabled();
            }
            if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
                OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
                this.mOnBackPressedDispatcher = onBackPressedDispatcher;
                LifecycleOwner lifecycleOwner = onBackPressedDispatcherOwner;
                if (fragment != null) {
                    lifecycleOwner = fragment;
                }
                onBackPressedDispatcher.addCallback(lifecycleOwner, this.mOnBackPressedCallback);
            }
            if (fragment != null) {
                FragmentManagerViewModel fragmentManagerViewModel = fragment.mFragmentManager.mNonConfig;
                HashMap<String, FragmentManagerViewModel> hashMap = fragmentManagerViewModel.mChildNonConfigs;
                FragmentManagerViewModel fragmentManagerViewModel2 = hashMap.get(fragment.mWho);
                if (fragmentManagerViewModel2 == null) {
                    fragmentManagerViewModel2 = new FragmentManagerViewModel(fragmentManagerViewModel.mStateAutomaticallySaved);
                    hashMap.put(fragment.mWho, fragmentManagerViewModel2);
                }
                this.mNonConfig = fragmentManagerViewModel2;
            } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                this.mNonConfig = (FragmentManagerViewModel) new ViewModelProvider(((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore(), FragmentManagerViewModel.FACTORY).get(FragmentManagerViewModel.class);
            } else {
                this.mNonConfig = new FragmentManagerViewModel(false);
            }
            this.mNonConfig.mIsStateSaved = isStateSaved();
            this.mFragmentStore.mNonConfig = this.mNonConfig;
            Object obj = this.mHost;
            if (obj instanceof ActivityResultRegistryOwner) {
                ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) obj).getActivityResultRegistry();
                if (fragment != null) {
                    str = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), fragment.mWho, ":");
                } else {
                    str = "";
                }
                String m = ConstraintSet$$ExternalSyntheticOutline0.m("FragmentManager:", str);
                this.mStartActivityForResult = activityResultRegistry.register(ComposableInvoker$$ExternalSyntheticOutline0.m(m, "StartActivityForResult"), new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.9
                    public AnonymousClass9() {
                    }

                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(ActivityResult activityResult) {
                        ActivityResult activityResult2 = activityResult;
                        FragmentManager fragmentManager = FragmentManager.this;
                        LaunchedFragmentInfo pollFirst = fragmentManager.mLaunchedFragments.pollFirst();
                        if (pollFirst == null) {
                            Log.w("FragmentManager", "No Activities were started for result for " + this);
                            return;
                        }
                        FragmentStore fragmentStore = fragmentManager.mFragmentStore;
                        String str2 = pollFirst.mWho;
                        Fragment findFragmentByWho = fragmentStore.findFragmentByWho(str2);
                        if (findFragmentByWho == null) {
                            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                        } else {
                            findFragmentByWho.onActivityResult(pollFirst.mRequestCode, activityResult2.mResultCode, activityResult2.mData);
                        }
                    }
                });
                this.mStartIntentSenderForResult = activityResultRegistry.register(ComposableInvoker$$ExternalSyntheticOutline0.m(m, "StartIntentSenderForResult"), new FragmentIntentSenderContract(), new ActivityResultCallback<ActivityResult>() { // from class: androidx.fragment.app.FragmentManager.10
                    public AnonymousClass10() {
                    }

                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(ActivityResult activityResult) {
                        ActivityResult activityResult2 = activityResult;
                        FragmentManager fragmentManager = FragmentManager.this;
                        LaunchedFragmentInfo pollFirst = fragmentManager.mLaunchedFragments.pollFirst();
                        if (pollFirst == null) {
                            Log.w("FragmentManager", "No IntentSenders were started for " + this);
                            return;
                        }
                        FragmentStore fragmentStore = fragmentManager.mFragmentStore;
                        String str2 = pollFirst.mWho;
                        Fragment findFragmentByWho = fragmentStore.findFragmentByWho(str2);
                        if (findFragmentByWho == null) {
                            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str2);
                        } else {
                            findFragmentByWho.onActivityResult(pollFirst.mRequestCode, activityResult2.mResultCode, activityResult2.mData);
                        }
                    }
                });
                this.mRequestPermissions = activityResultRegistry.register(ComposableInvoker$$ExternalSyntheticOutline0.m(m, "RequestPermissions"), new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() { // from class: androidx.fragment.app.FragmentManager.11
                    public AnonymousClass11() {
                    }

                    @Override // androidx.activity.result.ActivityResultCallback
                    @SuppressLint({"SyntheticAccessor"})
                    public final void onActivityResult(Map<String, Boolean> map) {
                        int r4;
                        Map<String, Boolean> map2 = map;
                        String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
                        ArrayList arrayList = new ArrayList(map2.values());
                        int[] r6 = new int[arrayList.size()];
                        for (int r3 = 0; r3 < arrayList.size(); r3++) {
                            if (((Boolean) arrayList.get(r3)).booleanValue()) {
                                r4 = 0;
                            } else {
                                r4 = -1;
                            }
                            r6[r3] = r4;
                        }
                        FragmentManager fragmentManager = FragmentManager.this;
                        LaunchedFragmentInfo pollFirst = fragmentManager.mLaunchedFragments.pollFirst();
                        if (pollFirst == null) {
                            Log.w("FragmentManager", "No permissions were requested for " + this);
                            return;
                        }
                        FragmentStore fragmentStore = fragmentManager.mFragmentStore;
                        String str2 = pollFirst.mWho;
                        Fragment findFragmentByWho = fragmentStore.findFragmentByWho(str2);
                        if (findFragmentByWho == null) {
                            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                            return;
                        }
                        findFragmentByWho.onRequestPermissionsResult(pollFirst.mRequestCode, strArr, r6);
                    }
                });
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public final void attachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.mFragmentStore.addFragment(fragment);
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    public final void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public final HashSet collectAllSpecialEffectsController() {
        HashSet hashSet = new HashSet();
        Iterator it = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((FragmentStateManager) it.next()).mFragment.mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
            }
        }
        return hashSet;
    }

    public final FragmentStateManager createOrGetFragmentStateManager(Fragment fragment) {
        String str = fragment.mWho;
        FragmentStore fragmentStore = this.mFragmentStore;
        FragmentStateManager fragmentStateManager = fragmentStore.mActive.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, fragmentStore, fragment);
        fragmentStateManager2.restoreState(this.mHost.mContext.getClassLoader());
        fragmentStateManager2.mFragmentManagerState = this.mCurState;
        return fragmentStateManager2;
    }

    public final void detachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                FragmentStore fragmentStore = this.mFragmentStore;
                synchronized (fragmentStore.mAdded) {
                    fragmentStore.mAdded.remove(fragment);
                }
                fragment.mAdded = false;
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                setVisibleRemovingFragment(fragment);
            }
        }
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int r1 = 0; r1 < this.mCreatedMenus.size(); r1++) {
                Fragment fragment2 = this.mCreatedMenus.get(r1);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public final void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).forceCompleteAllOperations();
        }
        dispatchStateChange(-1);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            Iterator<Cancellable> it2 = this.mOnBackPressedCallback.cancellables.iterator();
            while (it2.hasNext()) {
                it2.next().cancel();
            }
            this.mOnBackPressedDispatcher = null;
        }
        ActivityResultRegistry.AnonymousClass3 anonymousClass3 = this.mStartActivityForResult;
        if (anonymousClass3 != null) {
            anonymousClass3.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    public final void dispatchLowMemory() {
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public final void dispatchMultiWindowModeChanged(boolean z) {
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState < 1) {
            return;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment != null && fragment.equals(findActiveFragment(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public final void dispatchPictureInPictureModeChanged(boolean z) {
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void dispatchStateChange(int r5) {
        try {
            this.mExecutingActions = true;
            for (FragmentStateManager fragmentStateManager : this.mFragmentStore.mActive.values()) {
                if (fragmentStateManager != null) {
                    fragmentStateManager.mFragmentManagerState = r5;
                }
            }
            moveToState(r5, false);
            Iterator it = collectAllSpecialEffectsController().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).forceCompleteAllOperations();
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String m = ComposableInvoker$$ExternalSyntheticOutline0.m(str, "    ");
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.getClass();
        String str2 = str + "    ";
        HashMap<String, FragmentStateManager> hashMap = fragmentStore.mActive;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : hashMap.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    Fragment fragment = fragmentStateManager.mFragment;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(Constants.NULL_VERSION_ID);
                }
            }
        }
        ArrayList<Fragment> arrayList = fragmentStore.mAdded;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int r2 = 0; r2 < size3; r2++) {
                Fragment fragment2 = arrayList.get(r2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(r2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList2 = this.mCreatedMenus;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int r9 = 0; r9 < size2; r9++) {
                Fragment fragment3 = this.mCreatedMenus.get(r9);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(r9);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<BackStackRecord> arrayList3 = this.mBackStack;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int r92 = 0; r92 < size; r92++) {
                BackStackRecord backStackRecord = this.mBackStack.get(r92);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(r92);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(m, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            int size4 = this.mPendingActions.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int r1 = 0; r1 < size4; r1++) {
                    Object obj = (OpGenerator) this.mPendingActions.get(r1);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(r1);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    public final void enqueueAction(OpGenerator opGenerator, boolean z) {
        if (!z) {
            if (this.mHost == null) {
                if (this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (isStateSaved()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.mPendingActions) {
            if (this.mHost == null) {
                if (z) {
                } else {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.mPendingActions.add(opGenerator);
                scheduleCommit();
            }
        }
    }

    public final void ensureExecReady(boolean z) {
        if (!this.mExecutingActions) {
            if (this.mHost == null) {
                if (this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (Looper.myLooper() == this.mHost.mHandler.getLooper()) {
                if (!z && isStateSaved()) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
                if (this.mTmpRecords == null) {
                    this.mTmpRecords = new ArrayList<>();
                    this.mTmpIsPop = new ArrayList<>();
                }
                this.mExecutingActions = false;
                return;
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public final boolean execPendingActions(boolean z) {
        boolean z2;
        ensureExecReady(z);
        boolean z3 = false;
        while (true) {
            ArrayList<BackStackRecord> arrayList = this.mTmpRecords;
            ArrayList<Boolean> arrayList2 = this.mTmpIsPop;
            synchronized (this.mPendingActions) {
                if (this.mPendingActions.isEmpty()) {
                    z2 = false;
                } else {
                    int size = this.mPendingActions.size();
                    z2 = false;
                    for (int r5 = 0; r5 < size; r5++) {
                        z2 |= this.mPendingActions.get(r5).generateOps(arrayList, arrayList2);
                    }
                    this.mPendingActions.clear();
                    this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                }
            }
            if (!z2) {
                break;
            }
            z3 = true;
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
        this.mFragmentStore.mActive.values().removeAll(Collections.singleton(null));
        return z3;
    }

    public final void execSingleAction(OpGenerator opGenerator, boolean z) {
        if (z && (this.mHost == null || this.mDestroyed)) {
            return;
        }
        ensureExecReady(z);
        if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
        this.mFragmentStore.mActive.values().removeAll(Collections.singleton(null));
    }

    public final void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int r23, int r24) {
        ViewGroup viewGroup;
        FragmentStore fragmentStore;
        FragmentStore fragmentStore2;
        FragmentStore fragmentStore3;
        int r1;
        ArrayList<BackStackRecord> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        boolean z = arrayList3.get(r23).mReorderingAllowed;
        ArrayList<Fragment> arrayList5 = this.mTmpAddedFragments;
        if (arrayList5 == null) {
            this.mTmpAddedFragments = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        ArrayList<Fragment> arrayList6 = this.mTmpAddedFragments;
        FragmentStore fragmentStore4 = this.mFragmentStore;
        arrayList6.addAll(fragmentStore4.getFragments());
        Fragment fragment = this.mPrimaryNav;
        int r9 = r23;
        boolean z2 = false;
        while (true) {
            int r12 = 1;
            if (r9 < r24) {
                BackStackRecord backStackRecord = arrayList3.get(r9);
                if (!arrayList4.get(r9).booleanValue()) {
                    ArrayList<Fragment> arrayList7 = this.mTmpAddedFragments;
                    int r15 = 0;
                    while (true) {
                        ArrayList<FragmentTransaction.Op> arrayList8 = backStackRecord.mOps;
                        if (r15 < arrayList8.size()) {
                            FragmentTransaction.Op op = arrayList8.get(r15);
                            int r3 = op.mCmd;
                            if (r3 != r12) {
                                if (r3 != 2) {
                                    if (r3 != 3 && r3 != 6) {
                                        if (r3 != 7) {
                                            if (r3 == 8) {
                                                arrayList8.add(r15, new FragmentTransaction.Op(fragment, 9));
                                                r15++;
                                                fragment = op.mFragment;
                                            }
                                        } else {
                                            fragmentStore3 = fragmentStore4;
                                            r1 = 1;
                                        }
                                    } else {
                                        arrayList7.remove(op.mFragment);
                                        Fragment fragment2 = op.mFragment;
                                        if (fragment2 == fragment) {
                                            arrayList8.add(r15, new FragmentTransaction.Op(fragment2, 9));
                                            r15++;
                                            fragmentStore3 = fragmentStore4;
                                            r1 = 1;
                                            fragment = null;
                                        }
                                    }
                                    fragmentStore3 = fragmentStore4;
                                    r1 = 1;
                                } else {
                                    Fragment fragment3 = op.mFragment;
                                    int r122 = fragment3.mContainerId;
                                    int size = arrayList7.size() - 1;
                                    boolean z3 = false;
                                    while (size >= 0) {
                                        FragmentStore fragmentStore5 = fragmentStore4;
                                        Fragment fragment4 = arrayList7.get(size);
                                        if (fragment4.mContainerId == r122) {
                                            if (fragment4 == fragment3) {
                                                z3 = true;
                                            } else {
                                                if (fragment4 == fragment) {
                                                    arrayList8.add(r15, new FragmentTransaction.Op(fragment4, 9));
                                                    r15++;
                                                    fragment = null;
                                                }
                                                FragmentTransaction.Op op2 = new FragmentTransaction.Op(fragment4, 3);
                                                op2.mEnterAnim = op.mEnterAnim;
                                                op2.mPopEnterAnim = op.mPopEnterAnim;
                                                op2.mExitAnim = op.mExitAnim;
                                                op2.mPopExitAnim = op.mPopExitAnim;
                                                arrayList8.add(r15, op2);
                                                arrayList7.remove(fragment4);
                                                r15++;
                                                fragment = fragment;
                                            }
                                        }
                                        size--;
                                        fragmentStore4 = fragmentStore5;
                                    }
                                    fragmentStore3 = fragmentStore4;
                                    r1 = 1;
                                    if (z3) {
                                        arrayList8.remove(r15);
                                        r15--;
                                    } else {
                                        op.mCmd = 1;
                                        arrayList7.add(fragment3);
                                    }
                                }
                                r15 += r1;
                                r12 = r1;
                                fragmentStore4 = fragmentStore3;
                            } else {
                                fragmentStore3 = fragmentStore4;
                                r1 = r12;
                            }
                            arrayList7.add(op.mFragment);
                            r15 += r1;
                            r12 = r1;
                            fragmentStore4 = fragmentStore3;
                        } else {
                            fragmentStore2 = fragmentStore4;
                        }
                    }
                } else {
                    fragmentStore2 = fragmentStore4;
                    int r13 = 1;
                    ArrayList<Fragment> arrayList9 = this.mTmpAddedFragments;
                    ArrayList<FragmentTransaction.Op> arrayList10 = backStackRecord.mOps;
                    int size2 = arrayList10.size() - 1;
                    while (size2 >= 0) {
                        FragmentTransaction.Op op3 = arrayList10.get(size2);
                        int r11 = op3.mCmd;
                        if (r11 != r13) {
                            if (r11 != 3) {
                                switch (r11) {
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = op3.mFragment;
                                        break;
                                    case 10:
                                        op3.mCurrentMaxState = op3.mOldMaxState;
                                        break;
                                }
                                size2--;
                                r13 = 1;
                            }
                            arrayList9.add(op3.mFragment);
                            size2--;
                            r13 = 1;
                        }
                        arrayList9.remove(op3.mFragment);
                        size2--;
                        r13 = 1;
                    }
                }
                if (!z2 && !backStackRecord.mAddToBackStack) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                r9++;
                arrayList3 = arrayList;
                arrayList4 = arrayList2;
                fragmentStore4 = fragmentStore2;
            } else {
                FragmentStore fragmentStore6 = fragmentStore4;
                this.mTmpAddedFragments.clear();
                if (!z && this.mCurState >= 1) {
                    for (int r14 = r23; r14 < r24; r14++) {
                        Iterator<FragmentTransaction.Op> it = arrayList.get(r14).mOps.iterator();
                        while (it.hasNext()) {
                            Fragment fragment5 = it.next().mFragment;
                            if (fragment5 != null && fragment5.mFragmentManager != null) {
                                fragmentStore = fragmentStore6;
                                fragmentStore.makeActive(createOrGetFragmentStateManager(fragment5));
                            } else {
                                fragmentStore = fragmentStore6;
                            }
                            fragmentStore6 = fragmentStore;
                        }
                    }
                }
                for (int r16 = r23; r16 < r24; r16++) {
                    BackStackRecord backStackRecord2 = arrayList.get(r16);
                    if (arrayList2.get(r16).booleanValue()) {
                        backStackRecord2.bumpBackStackNesting(-1);
                        backStackRecord2.executePopOps();
                    } else {
                        backStackRecord2.bumpBackStackNesting(1);
                        backStackRecord2.executeOps();
                    }
                }
                boolean booleanValue = arrayList2.get(r24 - 1).booleanValue();
                for (int r32 = r23; r32 < r24; r32++) {
                    BackStackRecord backStackRecord3 = arrayList.get(r32);
                    if (booleanValue) {
                        for (int size3 = backStackRecord3.mOps.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment6 = backStackRecord3.mOps.get(size3).mFragment;
                            if (fragment6 != null) {
                                createOrGetFragmentStateManager(fragment6).moveToExpectedState();
                            }
                        }
                    } else {
                        Iterator<FragmentTransaction.Op> it2 = backStackRecord3.mOps.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment7 = it2.next().mFragment;
                            if (fragment7 != null) {
                                createOrGetFragmentStateManager(fragment7).moveToExpectedState();
                            }
                        }
                    }
                }
                moveToState(this.mCurState, true);
                HashSet hashSet = new HashSet();
                for (int r6 = r23; r6 < r24; r6++) {
                    Iterator<FragmentTransaction.Op> it3 = arrayList.get(r6).mOps.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment8 = it3.next().mFragment;
                        if (fragment8 != null && (viewGroup = fragment8.mContainer) != null) {
                            hashSet.add(SpecialEffectsController.getOrCreateController(viewGroup, getSpecialEffectsControllerFactory()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    SpecialEffectsController specialEffectsController = (SpecialEffectsController) it4.next();
                    specialEffectsController.mOperationDirectionIsPop = booleanValue;
                    specialEffectsController.markPostponedState();
                    specialEffectsController.executePendingOperations();
                }
                for (int r17 = r23; r17 < r24; r17++) {
                    BackStackRecord backStackRecord4 = arrayList.get(r17);
                    if (arrayList2.get(r17).booleanValue() && backStackRecord4.mIndex >= 0) {
                        backStackRecord4.mIndex = -1;
                    }
                    backStackRecord4.getClass();
                }
                if (z2 && this.mBackStackChangeListeners != null) {
                    for (int r8 = 0; r8 < this.mBackStackChangeListeners.size(); r8++) {
                        this.mBackStackChangeListeners.get(r8).onBackStackChanged();
                    }
                    return;
                }
                return;
            }
        }
    }

    public final Fragment findActiveFragment(String str) {
        return this.mFragmentStore.findActiveFragment(str);
    }

    public final Fragment findFragmentById(int r6) {
        FragmentStore fragmentStore = this.mFragmentStore;
        ArrayList<Fragment> arrayList = fragmentStore.mAdded;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                Fragment fragment = arrayList.get(size);
                if (fragment != null && fragment.mFragmentId == r6) {
                    return fragment;
                }
            } else {
                for (FragmentStateManager fragmentStateManager : fragmentStore.mActive.values()) {
                    if (fragmentStateManager != null) {
                        Fragment fragment2 = fragmentStateManager.mFragment;
                        if (fragment2.mFragmentId == r6) {
                            return fragment2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public final Fragment findFragmentByTag(String str) {
        FragmentStore fragmentStore = this.mFragmentStore;
        if (str != null) {
            ArrayList<Fragment> arrayList = fragmentStore.mAdded;
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                Fragment fragment = arrayList.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (FragmentStateManager fragmentStateManager : fragmentStore.mActive.values()) {
                if (fragmentStateManager != null) {
                    Fragment fragment2 = fragmentStateManager.mFragment;
                    if (str.equals(fragment2.mTag)) {
                        return fragment2;
                    }
                }
            }
        } else {
            fragmentStore.getClass();
        }
        return null;
    }

    public final ViewGroup getFragmentContainer(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.mContainer.onHasView()) {
            View onFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
            if (onFindViewById instanceof ViewGroup) {
                return (ViewGroup) onFindViewById;
            }
        }
        return null;
    }

    public final FragmentFactory getFragmentFactory() {
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getFragmentFactory();
        }
        return this.mHostFragmentFactory;
    }

    public final SpecialEffectsControllerFactory getSpecialEffectsControllerFactory() {
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getSpecialEffectsControllerFactory();
        }
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    public final void hideFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            setVisibleRemovingFragment(fragment);
        }
    }

    public final boolean isStateSaved() {
        if (!this.mStateSaved && !this.mStopped) {
            return false;
        }
        return true;
    }

    public final void moveToState(int r5, boolean z) {
        HashMap<String, FragmentStateManager> hashMap;
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.mHost == null && r5 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (!z && r5 == this.mCurState) {
            return;
        }
        this.mCurState = r5;
        FragmentStore fragmentStore = this.mFragmentStore;
        Iterator<Fragment> it = fragmentStore.mAdded.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            hashMap = fragmentStore.mActive;
            if (!hasNext) {
                break;
            }
            FragmentStateManager fragmentStateManager = hashMap.get(it.next().mWho);
            if (fragmentStateManager != null) {
                fragmentStateManager.moveToExpectedState();
            }
        }
        Iterator<FragmentStateManager> it2 = hashMap.values().iterator();
        while (true) {
            boolean z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            FragmentStateManager next = it2.next();
            if (next != null) {
                next.moveToExpectedState();
                Fragment fragment = next.mFragment;
                if (fragment.mRemoving && !fragment.isInBackStack()) {
                    z2 = true;
                }
                if (z2) {
                    fragmentStore.makeInactive(next);
                }
            }
        }
        startPendingDeferredFragments();
        if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 7) {
            fragmentHostCallback.onSupportInvalidateOptionsMenu();
            this.mNeedMenuInvalidate = false;
        }
    }

    public final void noteStateNotSaved() {
        if (this.mHost == null) {
            return;
        }
        this.mStateSaved = false;
        this.mStopped = false;
        this.mNonConfig.mIsStateSaved = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final void popBackStack(String str) {
        enqueueAction(new PopBackStackState(str, -1, 1), false);
    }

    public final boolean popBackStackImmediate() {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, null, -1, 0);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
        this.mFragmentStore.mActive.values().removeAll(Collections.singleton(null));
        return popBackStackState;
    }

    public final boolean popBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int r10, int r11) {
        ArrayList<BackStackRecord> arrayList3 = this.mBackStack;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && r10 < 0 && (r11 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int r3 = -1;
            if (str != null || r10 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    BackStackRecord backStackRecord = this.mBackStack.get(size2);
                    if ((str != null && str.equals(backStackRecord.mName)) || (r10 >= 0 && r10 == backStackRecord.mIndex)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((r11 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        BackStackRecord backStackRecord2 = this.mBackStack.get(size2);
                        if (str == null || !str.equals(backStackRecord2.mName)) {
                            if (r10 < 0 || r10 != backStackRecord2.mIndex) {
                                break;
                            }
                        }
                    }
                }
                r3 = size2;
            }
            if (r3 == this.mBackStack.size() - 1) {
                return false;
            }
            for (int size3 = this.mBackStack.size() - 1; size3 > r3; size3--) {
                arrayList.add(this.mBackStack.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public final void removeFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            FragmentStore fragmentStore = this.mFragmentStore;
            synchronized (fragmentStore.mAdded) {
                fragmentStore.mAdded.remove(fragment);
            }
            fragment.mAdded = false;
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mRemoving = true;
            setVisibleRemovingFragment(fragment);
        }
    }

    public final void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == arrayList2.size()) {
            int size = arrayList.size();
            int r1 = 0;
            int r2 = 0;
            while (r1 < size) {
                if (!arrayList.get(r1).mReorderingAllowed) {
                    if (r2 != r1) {
                        executeOpsTogether(arrayList, arrayList2, r2, r1);
                    }
                    r2 = r1 + 1;
                    if (arrayList2.get(r1).booleanValue()) {
                        while (r2 < size && arrayList2.get(r2).booleanValue() && !arrayList.get(r2).mReorderingAllowed) {
                            r2++;
                        }
                    }
                    executeOpsTogether(arrayList, arrayList2, r1, r2);
                    r1 = r2 - 1;
                }
                r1++;
            }
            if (r2 != size) {
                executeOpsTogether(arrayList, arrayList2, r2, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public final void restoreSaveState(Parcelable parcelable) {
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher;
        int r2;
        boolean z;
        FragmentStateManager fragmentStateManager;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.mActive.clear();
        Iterator<FragmentState> it = fragmentManagerState.mActive.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            fragmentLifecycleCallbacksDispatcher = this.mLifecycleCallbacksDispatcher;
            if (!hasNext) {
                break;
            }
            FragmentState next = it.next();
            if (next != null) {
                Fragment fragment = this.mNonConfig.mRetainedFragments.get(next.mWho);
                if (fragment != null) {
                    if (isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    fragmentStateManager = new FragmentStateManager(fragmentLifecycleCallbacksDispatcher, fragmentStore, fragment, next);
                } else {
                    fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.mContext.getClassLoader(), getFragmentFactory(), next);
                }
                Fragment fragment2 = fragmentStateManager.mFragment;
                fragment2.mFragmentManager = this;
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                }
                fragmentStateManager.restoreState(this.mHost.mContext.getClassLoader());
                fragmentStore.makeActive(fragmentStateManager);
                fragmentStateManager.mFragmentManagerState = this.mCurState;
            }
        }
        FragmentManagerViewModel fragmentManagerViewModel = this.mNonConfig;
        fragmentManagerViewModel.getClass();
        Iterator it2 = new ArrayList(fragmentManagerViewModel.mRetainedFragments.values()).iterator();
        while (it2.hasNext()) {
            Fragment fragment3 = (Fragment) it2.next();
            if (fragmentStore.mActive.get(fragment3.mWho) != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                }
                this.mNonConfig.removeRetainedFragment(fragment3);
                fragment3.mFragmentManager = this;
                FragmentStateManager fragmentStateManager2 = new FragmentStateManager(fragmentLifecycleCallbacksDispatcher, fragmentStore, fragment3);
                fragmentStateManager2.mFragmentManagerState = 1;
                fragmentStateManager2.moveToExpectedState();
                fragment3.mRemoving = true;
                fragmentStateManager2.moveToExpectedState();
            }
        }
        ArrayList<String> arrayList = fragmentManagerState.mAdded;
        fragmentStore.mAdded.clear();
        if (arrayList != null) {
            for (String str : arrayList) {
                Fragment findActiveFragment = fragmentStore.findActiveFragment(str);
                if (findActiveFragment != null) {
                    if (isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + findActiveFragment);
                    }
                    fragmentStore.addFragment(findActiveFragment);
                } else {
                    throw new IllegalStateException(zzav$$ExternalSyntheticOutline0.m("No instantiated fragment for (", str, ")"));
                }
            }
        }
        if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new ArrayList<>(fragmentManagerState.mBackStack.length);
            int r22 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.mBackStack;
                if (r22 >= backStackStateArr.length) {
                    break;
                }
                BackStackState backStackState = backStackStateArr[r22];
                backStackState.getClass();
                BackStackRecord backStackRecord = new BackStackRecord(this);
                int r10 = 0;
                int r11 = 0;
                while (true) {
                    int[] r12 = backStackState.mOps;
                    if (r10 >= r12.length) {
                        break;
                    }
                    FragmentTransaction.Op op = new FragmentTransaction.Op();
                    int r14 = r10 + 1;
                    op.mCmd = r12[r10];
                    if (isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + r11 + " base fragment #" + r12[r14]);
                    }
                    String str2 = backStackState.mFragmentWhos.get(r11);
                    if (str2 != null) {
                        op.mFragment = findActiveFragment(str2);
                    } else {
                        op.mFragment = null;
                    }
                    op.mOldMaxState = Lifecycle.State.values()[backStackState.mOldMaxLifecycleStates[r11]];
                    op.mCurrentMaxState = Lifecycle.State.values()[backStackState.mCurrentMaxLifecycleStates[r11]];
                    int r102 = r14 + 1;
                    int r142 = r12[r14];
                    op.mEnterAnim = r142;
                    int r15 = r102 + 1;
                    int r103 = r12[r102];
                    op.mExitAnim = r103;
                    int r16 = r15 + 1;
                    int r152 = r12[r15];
                    op.mPopEnterAnim = r152;
                    int r122 = r12[r16];
                    op.mPopExitAnim = r122;
                    backStackRecord.mEnterAnim = r142;
                    backStackRecord.mExitAnim = r103;
                    backStackRecord.mPopEnterAnim = r152;
                    backStackRecord.mPopExitAnim = r122;
                    backStackRecord.addOp(op);
                    r11++;
                    r10 = r16 + 1;
                }
                backStackRecord.mTransition = backStackState.mTransition;
                backStackRecord.mName = backStackState.mName;
                backStackRecord.mIndex = backStackState.mIndex;
                backStackRecord.mAddToBackStack = true;
                backStackRecord.mBreadCrumbTitleRes = backStackState.mBreadCrumbTitleRes;
                backStackRecord.mBreadCrumbTitleText = backStackState.mBreadCrumbTitleText;
                backStackRecord.mBreadCrumbShortTitleRes = backStackState.mBreadCrumbShortTitleRes;
                backStackRecord.mBreadCrumbShortTitleText = backStackState.mBreadCrumbShortTitleText;
                backStackRecord.mSharedElementSourceNames = backStackState.mSharedElementSourceNames;
                backStackRecord.mSharedElementTargetNames = backStackState.mSharedElementTargetNames;
                backStackRecord.mReorderingAllowed = backStackState.mReorderingAllowed;
                backStackRecord.bumpBackStackNesting(1);
                if (isLoggingEnabled(2)) {
                    StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("restoreAllState: back stack #", r22, " (index ");
                    m.append(backStackRecord.mIndex);
                    m.append("): ");
                    m.append(backStackRecord);
                    Log.v("FragmentManager", m.toString());
                    PrintWriter printWriter = new PrintWriter(new LogWriter());
                    backStackRecord.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.mBackStack.add(backStackRecord);
                r22++;
            }
            r2 = 0;
        } else {
            r2 = 0;
            this.mBackStack = null;
        }
        this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
        String str3 = fragmentManagerState.mPrimaryNavActiveWho;
        if (str3 != null) {
            Fragment findActiveFragment2 = findActiveFragment(str3);
            this.mPrimaryNav = findActiveFragment2;
            dispatchParentPrimaryNavigationFragmentChanged(findActiveFragment2);
        }
        ArrayList<String> arrayList2 = fragmentManagerState.mResultKeys;
        if (arrayList2 != null) {
            while (r2 < arrayList2.size()) {
                Bundle bundle = fragmentManagerState.mResults.get(r2);
                bundle.setClassLoader(this.mHost.mContext.getClassLoader());
                this.mResults.put(arrayList2.get(r2), bundle);
                r2++;
            }
        }
        this.mLaunchedFragments = new ArrayDeque<>(fragmentManagerState.mLaunchedFragments);
    }

    public final FragmentManagerState saveAllState() {
        int r2;
        BackStackState[] backStackStateArr;
        ArrayList<String> arrayList;
        int size;
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SpecialEffectsController specialEffectsController = (SpecialEffectsController) it.next();
            if (specialEffectsController.mIsContainerPostponed) {
                specialEffectsController.mIsContainerPostponed = false;
                specialEffectsController.executePendingOperations();
            }
        }
        Iterator it2 = collectAllSpecialEffectsController().iterator();
        while (it2.hasNext()) {
            ((SpecialEffectsController) it2.next()).forceCompleteAllOperations();
        }
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.mIsStateSaved = true;
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.getClass();
        HashMap<String, FragmentStateManager> hashMap = fragmentStore.mActive;
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(hashMap.size());
        Iterator<FragmentStateManager> it3 = hashMap.values().iterator();
        while (true) {
            backStackStateArr = null;
            Bundle bundle = null;
            backStackStateArr = null;
            if (!it3.hasNext()) {
                break;
            }
            FragmentStateManager next = it3.next();
            if (next != null) {
                Fragment fragment = next.mFragment;
                FragmentState fragmentState = new FragmentState(fragment);
                if (fragment.mState > -1 && fragmentState.mSavedFragmentState == null) {
                    Bundle bundle2 = new Bundle();
                    fragment.performSaveInstanceState(bundle2);
                    next.mDispatcher.dispatchOnFragmentSaveInstanceState(false);
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                    if (fragment.mView != null) {
                        next.saveViewState();
                    }
                    if (fragment.mSavedViewState != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
                    }
                    if (fragment.mSavedViewRegistryState != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
                    }
                    if (!fragment.mUserVisibleHint) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
                    }
                    fragmentState.mSavedFragmentState = bundle;
                    if (fragment.mTargetWho != null) {
                        if (bundle == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        fragmentState.mSavedFragmentState.putString("android:target_state", fragment.mTargetWho);
                        int r3 = fragment.mTargetRequestCode;
                        if (r3 != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", r3);
                        }
                    }
                } else {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                }
                arrayList2.add(fragmentState);
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (isLoggingEnabled(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        FragmentStore fragmentStore2 = this.mFragmentStore;
        synchronized (fragmentStore2.mAdded) {
            if (fragmentStore2.mAdded.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(fragmentStore2.mAdded.size());
                Iterator<Fragment> it4 = fragmentStore2.mAdded.iterator();
                while (it4.hasNext()) {
                    Fragment next2 = it4.next();
                    arrayList.add(next2.mWho);
                    if (isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + next2.mWho + "): " + next2);
                    }
                }
            }
        }
        ArrayList<BackStackRecord> arrayList3 = this.mBackStack;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (r2 = 0; r2 < size; r2++) {
                backStackStateArr[r2] = new BackStackState(this.mBackStack.get(r2));
                if (isLoggingEnabled(2)) {
                    StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("saveAllState: adding back stack #", r2, ": ");
                    m.append(this.mBackStack.get(r2));
                    Log.v("FragmentManager", m.toString());
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.mActive = arrayList2;
        fragmentManagerState.mAdded = arrayList;
        fragmentManagerState.mBackStack = backStackStateArr;
        fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
        Fragment fragment2 = this.mPrimaryNav;
        if (fragment2 != null) {
            fragmentManagerState.mPrimaryNavActiveWho = fragment2.mWho;
        }
        fragmentManagerState.mResultKeys.addAll(this.mResults.keySet());
        fragmentManagerState.mResults.addAll(this.mResults.values());
        fragmentManagerState.mLaunchedFragments = new ArrayList<>(this.mLaunchedFragments);
        return fragmentManagerState;
    }

    public final void scheduleCommit() {
        synchronized (this.mPendingActions) {
            boolean z = true;
            if (this.mPendingActions.size() != 1) {
                z = false;
            }
            if (z) {
                this.mHost.mHandler.removeCallbacks(this.mExecCommit);
                this.mHost.mHandler.post(this.mExecCommit);
                updateOnBackPressedCallbackEnabled();
            }
        }
    }

    public final void setExitAnimationOrder(Fragment fragment, boolean z) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null && (fragmentContainer instanceof FragmentContainerView)) {
            ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
        }
    }

    public final void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null && (!fragment.equals(findActiveFragment(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.mPrimaryNav;
        this.mPrimaryNav = fragment;
        dispatchParentPrimaryNavigationFragmentChanged(fragment2);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public final void setVisibleRemovingFragment(Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    fragmentContainer.setTag(R.id.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void startPendingDeferredFragments() {
        Iterator it = this.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (it.hasNext()) {
            FragmentStateManager fragmentStateManager = (FragmentStateManager) it.next();
            Fragment fragment = fragmentStateManager.mFragment;
            if (fragment.mDeferStart) {
                if (this.mExecutingActions) {
                    this.mHavePendingDeferredStart = true;
                } else {
                    fragment.mDeferStart = false;
                    fragmentStateManager.moveToExpectedState();
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.mParent;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            sb.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                sb.append("}");
            } else {
                sb.append(Constants.NULL_VERSION_ID);
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void updateOnBackPressedCallbackEnabled() {
        int r1;
        synchronized (this.mPendingActions) {
            try {
                boolean z = true;
                if (!this.mPendingActions.isEmpty()) {
                    AnonymousClass1 anonymousClass1 = this.mOnBackPressedCallback;
                    anonymousClass1.isEnabled = true;
                    Function0<Unit> function0 = anonymousClass1.enabledChangedCallback;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return;
                }
                AnonymousClass1 anonymousClass12 = this.mOnBackPressedCallback;
                ArrayList<BackStackRecord> arrayList = this.mBackStack;
                if (arrayList != null) {
                    r1 = arrayList.size();
                } else {
                    r1 = 0;
                }
                if (r1 <= 0 || !isPrimaryNavigation(this.mParent)) {
                    z = false;
                }
                anonymousClass12.isEnabled = z;
                Function0<Unit> function02 = anonymousClass12.enabledChangedCallback;
                if (function02 != null) {
                    function02.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new AnonymousClass1();
        public final int mRequestCode;
        public final String mWho;

        /* renamed from: androidx.fragment.app.FragmentManager$LaunchedFragmentInfo$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            public final LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final LaunchedFragmentInfo[] newArray(int r1) {
                return new LaunchedFragmentInfo[r1];
            }
        }

        public LaunchedFragmentInfo(String str, int r2) {
            this.mWho = str;
            this.mRequestCode = r2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int r2) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.mWho = parcel.readString();
            this.mRequestCode = parcel.readInt();
        }
    }
}
