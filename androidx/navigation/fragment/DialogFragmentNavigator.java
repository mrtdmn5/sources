package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import java.util.HashSet;

@Navigator.Name("dialog")
/* loaded from: classes.dex */
public final class DialogFragmentNavigator extends Navigator<Destination> {
    public final Context mContext;
    public final FragmentManager mFragmentManager;
    public int mDialogCount = 0;
    public final HashSet<String> mRestoredTagsAwaitingAttach = new HashSet<>();
    public final LifecycleEventObserver mObserver = new LifecycleEventObserver() { // from class: androidx.navigation.fragment.DialogFragmentNavigator.1
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            NavController findNavController;
            if (event == Lifecycle.Event.ON_STOP) {
                DialogFragment dialogFragment = (DialogFragment) lifecycleOwner;
                if (!dialogFragment.requireDialog().isShowing()) {
                    int r5 = NavHostFragment.$r8$clinit;
                    Fragment fragment = dialogFragment;
                    while (true) {
                        if (fragment != null) {
                            if (fragment instanceof NavHostFragment) {
                                findNavController = ((NavHostFragment) fragment).mNavController;
                                if (findNavController == null) {
                                    throw new IllegalStateException("NavController is not available before onCreate()");
                                }
                            } else {
                                Fragment fragment2 = fragment.getParentFragmentManager().mPrimaryNav;
                                if (fragment2 instanceof NavHostFragment) {
                                    findNavController = ((NavHostFragment) fragment2).mNavController;
                                    if (findNavController == null) {
                                        throw new IllegalStateException("NavController is not available before onCreate()");
                                    }
                                } else {
                                    fragment = fragment.getParentFragment();
                                }
                            }
                        } else {
                            View view = dialogFragment.getView();
                            if (view != null) {
                                findNavController = Navigation.findNavController(view);
                            } else {
                                Dialog dialog = dialogFragment.getDialog();
                                if (dialog != null && dialog.getWindow() != null) {
                                    findNavController = Navigation.findNavController(dialog.getWindow().getDecorView());
                                } else {
                                    throw new IllegalStateException("Fragment " + dialogFragment + " does not have a NavController set");
                                }
                            }
                        }
                    }
                    findNavController.popBackStack();
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public static class Destination extends NavDestination implements FloatingWindow {
        public String mClassName;

        @Override // androidx.navigation.NavDestination
        public final void onInflate(Context context, AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.DialogFragmentNavigator);
            String string = obtainAttributes.getString(0);
            if (string != null) {
                this.mClassName = string;
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(FragmentManager fragmentManager, Context context) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
    }

    @Override // androidx.navigation.Navigator
    public final Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions) {
        Destination destination = (Destination) navDestination;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager.isStateSaved()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String str = destination.mClassName;
        if (str != null) {
            char charAt = str.charAt(0);
            Context context = this.mContext;
            if (charAt == '.') {
                str = context.getPackageName() + str;
            }
            FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
            context.getClassLoader();
            Fragment instantiate = fragmentFactory.instantiate(str);
            if (DialogFragment.class.isAssignableFrom(instantiate.getClass())) {
                DialogFragment dialogFragment = (DialogFragment) instantiate;
                dialogFragment.setArguments(bundle);
                dialogFragment.getLifecycle().addObserver(this.mObserver);
                StringBuilder sb = new StringBuilder("androidx-nav-fragment:navigator:dialog:");
                int r1 = this.mDialogCount;
                this.mDialogCount = r1 + 1;
                sb.append(r1);
                dialogFragment.show(fragmentManager, sb.toString());
                return destination;
            }
            StringBuilder sb2 = new StringBuilder("Dialog destination ");
            String str2 = destination.mClassName;
            if (str2 != null) {
                throw new IllegalArgumentException(ComponentActivity$2$$ExternalSyntheticOutline0.m(sb2, str2, " is not an instance of DialogFragment"));
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }
        throw new IllegalStateException("DialogFragment class was not set");
    }

    @Override // androidx.navigation.Navigator
    public final void onRestoreState(Bundle bundle) {
        this.mDialogCount = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
        for (int r1 = 0; r1 < this.mDialogCount; r1++) {
            DialogFragment dialogFragment = (DialogFragment) this.mFragmentManager.findFragmentByTag(SubMenuBuilder$$ExternalSyntheticOutline0.m("androidx-nav-fragment:navigator:dialog:", r1));
            if (dialogFragment != null) {
                dialogFragment.getLifecycle().addObserver(this.mObserver);
            } else {
                this.mRestoredTagsAwaitingAttach.add("androidx-nav-fragment:navigator:dialog:" + r1);
            }
        }
    }

    @Override // androidx.navigation.Navigator
    public final Bundle onSaveState() {
        if (this.mDialogCount == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.mDialogCount);
        return bundle;
    }

    @Override // androidx.navigation.Navigator
    public final boolean popBackStack() {
        if (this.mDialogCount == 0) {
            return false;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager.isStateSaved()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        StringBuilder sb = new StringBuilder("androidx-nav-fragment:navigator:dialog:");
        int r2 = this.mDialogCount - 1;
        this.mDialogCount = r2;
        sb.append(r2);
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(sb.toString());
        if (findFragmentByTag != null) {
            findFragmentByTag.getLifecycle().removeObserver(this.mObserver);
            ((DialogFragment) findFragmentByTag).dismiss();
        }
        return true;
    }
}
