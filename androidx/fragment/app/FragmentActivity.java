package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final FragmentController mFragments;
    boolean mResumed;
    boolean mStopped;

    /* renamed from: androidx.fragment.app.FragmentActivity$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements SavedStateRegistry.SavedStateProvider {
        public AnonymousClass1() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public final Bundle saveState() {
            Bundle bundle = new Bundle();
            FragmentActivity fragmentActivity = FragmentActivity.this;
            fragmentActivity.markFragmentsCreated();
            fragmentActivity.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            FragmentManagerState saveAllState = fragmentActivity.mFragments.mHost.mFragmentManager.saveAllState();
            if (saveAllState != null) {
                bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, saveAllState);
            }
            return bundle;
        }
    }

    /* renamed from: androidx.fragment.app.FragmentActivity$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements OnContextAvailableListener {
        public AnonymousClass2() {
        }

        @Override // androidx.activity.contextaware.OnContextAvailableListener
        public final void onContextAvailable(Context context) {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            FragmentHostCallback<?> fragmentHostCallback = fragmentActivity.mFragments.mHost;
            fragmentHostCallback.mFragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, null);
            Bundle consumeRestoredStateForKey = fragmentActivity.getSavedStateRegistry().consumeRestoredStateForKey(FragmentActivity.FRAGMENTS_TAG);
            if (consumeRestoredStateForKey != null) {
                Parcelable parcelable = consumeRestoredStateForKey.getParcelable(FragmentActivity.FRAGMENTS_TAG);
                FragmentHostCallback<?> fragmentHostCallback2 = fragmentActivity.mFragments.mHost;
                if (fragmentHostCallback2 instanceof ViewModelStoreOwner) {
                    fragmentHostCallback2.mFragmentManager.restoreSaveState(parcelable);
                    return;
                }
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
        }
    }

    /* loaded from: classes.dex */
    public class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, FragmentOnAttachListener {
        public HostCallbacks() {
            super(FragmentActivity.this);
        }

        @Override // androidx.activity.result.ActivityResultRegistryOwner
        public final ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public final Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.OnBackPressedDispatcherOwner
        public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        public final ViewModelStore getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public final void onAttachFragment$1(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.FragmentContainer
        public final View onFindViewById(int r2) {
            return FragmentActivity.this.findViewById(r2);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final FragmentActivity onGetHost$1() {
            return FragmentActivity.this;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final LayoutInflater onGetLayoutInflater() {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            return fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
        }

        @Override // androidx.fragment.app.FragmentContainer
        public final boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            if (window != null && window.peekDecorView() != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final boolean onShouldShowRequestPermissionRationale(String str) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.FragmentHostCallback
        public final void onSupportInvalidateOptionsMenu() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }
    }

    public FragmentActivity() {
        this.mFragments = new FragmentController(new HostCallbacks());
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    private void init() {
        getSavedStateRegistry().registerSavedStateProvider(FRAGMENTS_TAG, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.fragment.app.FragmentActivity.1
            public AnonymousClass1() {
            }

            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                Bundle bundle = new Bundle();
                FragmentActivity fragmentActivity = FragmentActivity.this;
                fragmentActivity.markFragmentsCreated();
                fragmentActivity.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                FragmentManagerState saveAllState = fragmentActivity.mFragments.mHost.mFragmentManager.saveAllState();
                if (saveAllState != null) {
                    bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, saveAllState);
                }
                return bundle;
            }
        });
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: androidx.fragment.app.FragmentActivity.2
            public AnonymousClass2() {
            }

            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public final void onContextAvailable(Context context) {
                FragmentActivity fragmentActivity = FragmentActivity.this;
                FragmentHostCallback<?> fragmentHostCallback = fragmentActivity.mFragments.mHost;
                fragmentHostCallback.mFragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, null);
                Bundle consumeRestoredStateForKey = fragmentActivity.getSavedStateRegistry().consumeRestoredStateForKey(FragmentActivity.FRAGMENTS_TAG);
                if (consumeRestoredStateForKey != null) {
                    Parcelable parcelable = consumeRestoredStateForKey.getParcelable(FragmentActivity.FRAGMENTS_TAG);
                    FragmentHostCallback<?> fragmentHostCallback2 = fragmentActivity.mFragments.mHost;
                    if (fragmentHostCallback2 instanceof ViewModelStoreOwner) {
                        fragmentHostCallback2.mFragmentManager.restoreSaveState(parcelable);
                        return;
                    }
                    throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
                }
            }
        });
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z = false;
        for (Fragment fragment : fragmentManager.mFragmentStore.getFragments()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), state);
                }
                FragmentViewLifecycleOwner fragmentViewLifecycleOwner = fragment.mViewLifecycleOwner;
                if (fragmentViewLifecycleOwner != null) {
                    fragmentViewLifecycleOwner.initialize();
                    if (fragmentViewLifecycleOwner.mLifecycleRegistry.state.isAtLeast(Lifecycle.State.STARTED)) {
                        fragment.mViewLifecycleOwner.mLifecycleRegistry.setCurrentState(state);
                        z = true;
                    }
                }
                if (fragment.mLifecycleRegistry.state.isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mLifecycleRegistry.setCurrentState(state);
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.mHost.mFragmentManager.mLayoutInflaterFactory.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            LoaderManager.getInstance(this).dump(str2, printWriter);
        }
        this.mFragments.mHost.mFragmentManager.dump(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.mHost.mFragmentManager;
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r2, int r3, Intent intent) {
        this.mFragments.noteStateNotSaved();
        super.onActivityResult(r2, r3, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.noteStateNotSaved();
        super.onConfigurationChanged(configuration);
        this.mFragments.mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        FragmentManagerImpl fragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int r3, Menu menu) {
        if (r3 == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(r3, menu);
            FragmentController fragmentController = this.mFragments;
            return onCreatePanelMenu | fragmentController.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(r3, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.mHost.mFragmentManager.dispatchDestroy();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.mHost.mFragmentManager.dispatchLowMemory();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int r2, MenuItem menuItem) {
        if (super.onMenuItemSelected(r2, menuItem)) {
            return true;
        }
        if (r2 != 0) {
            if (r2 != 6) {
                return false;
            }
            return this.mFragments.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
        }
        return this.mFragments.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.mHost.mFragmentManager.dispatchMultiWindowModeChanged(z);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.noteStateNotSaved();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r2, Menu menu) {
        if (r2 == 0) {
            this.mFragments.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu);
        }
        super.onPanelClosed(r2, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.mHost.mFragmentManager.dispatchStateChange(5);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.mHost.mFragmentManager.dispatchPictureInPictureModeChanged(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int r1, View view, Menu menu) {
        if (r1 == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
        }
        return super.onPreparePanel(r1, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r2, String[] strArr, int[] r4) {
        this.mFragments.noteStateNotSaved();
        super.onRequestPermissionsResult(r2, strArr, r4);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.noteStateNotSaved();
        super.onResume();
        this.mResumed = true;
        this.mFragments.mHost.mFragmentManager.execPendingActions(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        FragmentManagerImpl fragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl.dispatchStateChange(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.noteStateNotSaved();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            FragmentManagerImpl fragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
            fragmentManagerImpl.mStateSaved = false;
            fragmentManagerImpl.mStopped = false;
            fragmentManagerImpl.mNonConfig.mIsStateSaved = false;
            fragmentManagerImpl.dispatchStateChange(4);
        }
        this.mFragments.mHost.mFragmentManager.execPendingActions(true);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        FragmentManagerImpl fragmentManagerImpl2 = this.mFragments.mHost.mFragmentManager;
        fragmentManagerImpl2.mStateSaved = false;
        fragmentManagerImpl2.mStopped = false;
        fragmentManagerImpl2.mNonConfig.mIsStateSaved = false;
        fragmentManagerImpl2.dispatchStateChange(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        FragmentManagerImpl fragmentManagerImpl = this.mFragments.mHost.mFragmentManager;
        fragmentManagerImpl.mStopped = true;
        fragmentManagerImpl.mNonConfig.mIsStateSaved = true;
        fragmentManagerImpl.dispatchStateChange(4);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        int r1 = ActivityCompat.$r8$clinit;
        ActivityCompat.Api21Impl.setEnterSharedElementCallback(this, null);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        int r1 = ActivityCompat.$r8$clinit;
        ActivityCompat.Api21Impl.setExitSharedElementCallback(this, null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int r4) {
        startActivityFromFragment(fragment, intent, r4, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int r12, Intent intent, int r14, int r15, int r16, Bundle bundle) throws IntentSender.SendIntentException {
        if (r12 == -1) {
            int r0 = ActivityCompat.$r8$clinit;
            ActivityCompat.Api16Impl.startIntentSenderForResult(this, intentSender, r12, intent, r14, r15, r16, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, r12, intent, r14, r15, r16, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        int r0 = ActivityCompat.$r8$clinit;
        ActivityCompat.Api21Impl.finishAfterTransition(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        int r0 = ActivityCompat.$r8$clinit;
        ActivityCompat.Api21Impl.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        int r0 = ActivityCompat.$r8$clinit;
        ActivityCompat.Api21Impl.startPostponedEnterTransition(this);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int r4, Bundle bundle) {
        if (r4 == -1) {
            int r2 = ActivityCompat.$r8$clinit;
            ActivityCompat.Api16Impl.startActivityForResult(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, r4, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public FragmentActivity(int r2) {
        super(r2);
        this.mFragments = new FragmentController(new HostCallbacks());
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        init();
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.core.app.ActivityCompat.RequestPermissionsRequestCodeValidator
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int r1) {
    }
}
