package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.transition.TransitionManager;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class ToolbarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    public final WeakReference<Toolbar> mToolbarWeakReference;

    public ToolbarOnDestinationChangedListener(Toolbar toolbar, AppBarConfiguration appBarConfiguration) {
        super(toolbar.getContext(), appBarConfiguration);
        this.mToolbarWeakReference = new WeakReference<>(toolbar);
    }

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        Openable openable;
        boolean z;
        boolean z2;
        boolean z3;
        int r2;
        float f;
        WeakReference<Toolbar> weakReference = this.mToolbarWeakReference;
        if (weakReference.get() == null) {
            navController.mOnDestinationChangedListeners.remove(this);
            return;
        }
        if (!(navDestination instanceof FloatingWindow)) {
            WeakReference<Openable> weakReference2 = this.mOpenableLayoutWeakReference;
            if (weakReference2 != null) {
                openable = weakReference2.get();
            } else {
                openable = null;
            }
            if (weakReference2 != null && openable == null) {
                navController.mOnDestinationChangedListeners.remove(this);
                return;
            }
            CharSequence charSequence = navDestination.mLabel;
            if (charSequence != null) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
                while (matcher.find()) {
                    String group = matcher.group(1);
                    if (bundle != null && bundle.containsKey(group)) {
                        matcher.appendReplacement(stringBuffer, "");
                        stringBuffer.append(bundle.get(group).toString());
                    } else {
                        throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill label " + ((Object) charSequence));
                    }
                }
                matcher.appendTail(stringBuffer);
                weakReference.get().setTitle(stringBuffer);
            }
            while (true) {
                if (this.mTopLevelDestinations.contains(Integer.valueOf(navDestination.mId))) {
                    z = true;
                    break;
                }
                navDestination = navDestination.mParent;
                if (navDestination == null) {
                    z = false;
                    break;
                }
            }
            if (openable == null && z) {
                setNavigationIcon(null, 0);
                return;
            }
            if (openable != null && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.mArrowDrawable == null) {
                this.mArrowDrawable = new DrawerArrowDrawable(this.mContext);
                z3 = false;
            } else {
                z3 = true;
            }
            DrawerArrowDrawable drawerArrowDrawable = this.mArrowDrawable;
            if (z2) {
                r2 = R.string.nav_app_bar_open_drawer_description;
            } else {
                r2 = R.string.nav_app_bar_navigate_up_description;
            }
            setNavigationIcon(drawerArrowDrawable, r2);
            if (z2) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
            if (z3) {
                float f2 = this.mArrowDrawable.mProgress;
                ObjectAnimator objectAnimator = this.mAnimator;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mArrowDrawable, "progress", f2, f);
                this.mAnimator = ofFloat;
                ofFloat.start();
                return;
            }
            this.mArrowDrawable.setProgress(f);
        }
    }

    public final void setNavigationIcon(DrawerArrowDrawable drawerArrowDrawable, int r4) {
        boolean z;
        Toolbar toolbar = this.mToolbarWeakReference.get();
        if (toolbar != null) {
            if (drawerArrowDrawable == null && toolbar.getNavigationIcon() != null) {
                z = true;
            } else {
                z = false;
            }
            toolbar.setNavigationIcon(drawerArrowDrawable);
            toolbar.setNavigationContentDescription(r4);
            if (z) {
                TransitionManager.beginDelayedTransition(toolbar, null);
            }
        }
    }
}
