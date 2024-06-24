package com.animaconnected.secondo.screens.debugsettings;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.DialogFragment$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentManager;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.WatchViewController;
import com.animaconnected.secondo.screens.details.DummyDetailsFragment;
import com.kronaby.watch.app.R;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugSettingsActivity.kt */
/* loaded from: classes3.dex */
public final class DebugSettingsActivity extends AppCompatActivity implements MainController {
    public static final int $stable = 0;

    private final BaseFragment getCurrentFragment() {
        return (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.content);
    }

    private final BaseFragment getCurrentRevealedFragment() {
        BaseFragment baseFragment = (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.revealed_fragment_container);
        if (baseFragment instanceof DummyDetailsFragment) {
            return null;
        }
        return baseFragment;
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public int getWatchLayoutWidth() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public WatchViewController getWatchViewController() {
        throw new NotImplementedError();
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void goBack() {
        onBackPressed();
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoNextFragment(BaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        gotoNextFragment(fragment, false);
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoNextFragmentWithAnimations(BaseFragment fragment, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        BaseFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager, supportFragmentManager);
            m.setCustomAnimations(r4, r5, r6, r7);
            m.replace(R.id.content, fragment, null);
            m.addToBackStack(currentFragment.getName());
            m.commitAllowingStateLoss();
        }
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoNextRevealedFragmentWithAnimations(BaseFragment fragment, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        BaseFragment currentFragment = getCurrentFragment();
        BaseFragment currentRevealedFragment = getCurrentRevealedFragment();
        if (currentRevealedFragment != null) {
            currentFragment = currentRevealedFragment;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager, supportFragmentManager);
        m.setCustomAnimations(r4, r5, r6, r7);
        m.replace(R.id.revealed_fragment_container, fragment, null);
        Intrinsics.checkNotNull(currentFragment);
        m.addToBackStack(currentFragment.getName());
        m.commitAllowingStateLoss();
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoRevealedFragment(BaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        BaseFragment currentFragment = getCurrentFragment();
        BaseFragment currentRevealedFragment = getCurrentRevealedFragment();
        if (currentRevealedFragment == null) {
            currentRevealedFragment = currentFragment;
        }
        Intrinsics.checkNotNull(currentFragment);
        currentFragment.onRevealedFragmentOpened();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.replace(R.id.revealed_fragment_container, fragment, null);
        Intrinsics.checkNotNull(currentRevealedFragment);
        backStackRecord.addToBackStack(currentRevealedFragment.getName());
        backStackRecord.commitAllowingStateLoss();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_debug_settings);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.doAddOp(R.id.content, DebugSettingsFragment.Companion.newInstance(), null, 1);
        backStackRecord.commit();
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void popUntilFragment(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void setWatchLayerAboveContent(boolean z) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public Object updateWatchAreaViews(int r1, Continuation<? super Unit> continuation) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoNextFragment(BaseFragment fragment, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (getCurrentRevealedFragment() == null) {
            gotoNextFragmentWithAnimations(fragment, R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        } else if (!z) {
            gotoNextRevealedFragmentWithAnimations(fragment, R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        } else {
            gotoNextRevealedFragmentWithAnimations(new DummyDetailsFragment(), R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            gotoNextFragmentWithAnimations(fragment, R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        }
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoOnboarding() {
    }
}
