package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId;
    private boolean mCancelable;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDialogCreated;
    private Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private Observer<LifecycleOwner> mObserver;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;

    /* renamed from: androidx.fragment.app.DialogFragment$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public final void run() {
            DialogFragment dialogFragment = DialogFragment.this;
            dialogFragment.mOnDismissListener.onDismiss(dialogFragment.mDialog);
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements DialogInterface.OnCancelListener {
        public AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public final void onCancel(DialogInterface dialogInterface) {
            DialogFragment dialogFragment = DialogFragment.this;
            if (dialogFragment.mDialog != null) {
                dialogFragment.onCancel(dialogFragment.mDialog);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements DialogInterface.OnDismissListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public final void onDismiss(DialogInterface dialogInterface) {
            DialogFragment dialogFragment = DialogFragment.this;
            if (dialogFragment.mDialog != null) {
                dialogFragment.onDismiss(dialogFragment.mDialog);
            }
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 implements Observer<LifecycleOwner> {
        public AnonymousClass4() {
        }

        @Override // androidx.lifecycle.Observer
        @SuppressLint({"SyntheticAccessor"})
        public final void onChanged(LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                if (dialogFragment.mShowsDialog) {
                    View requireView = dialogFragment.requireView();
                    if (requireView.getParent() == null) {
                        if (dialogFragment.mDialog != null) {
                            if (FragmentManager.isLoggingEnabled(3)) {
                                Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + dialogFragment.mDialog);
                            }
                            dialogFragment.mDialog.setContentView(requireView);
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
        }
    }

    /* renamed from: androidx.fragment.app.DialogFragment$5 */
    /* loaded from: classes.dex */
    public class AnonymousClass5 extends FragmentContainer {
        public final /* synthetic */ FragmentContainer val$fragmentContainer;

        public AnonymousClass5(FragmentContainer fragmentContainer) {
            r2 = fragmentContainer;
        }

        @Override // androidx.fragment.app.FragmentContainer
        public final View onFindViewById(int r3) {
            FragmentContainer fragmentContainer = r2;
            if (fragmentContainer.onHasView()) {
                return fragmentContainer.onFindViewById(r3);
            }
            return DialogFragment.this.onFindViewById(r3);
        }

        @Override // androidx.fragment.app.FragmentContainer
        public final boolean onHasView() {
            if (!r2.onHasView() && !DialogFragment.this.onHasView()) {
                return false;
            }
            return true;
        }
    }

    public DialogFragment() {
        this.mDismissRunnable = new Runnable() { // from class: androidx.fragment.app.DialogFragment.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            @SuppressLint({"SyntheticAccessor"})
            public final void run() {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.mOnDismissListener.onDismiss(dialogFragment.mDialog);
            }
        };
        this.mOnCancelListener = new DialogInterface.OnCancelListener() { // from class: androidx.fragment.app.DialogFragment.2
            public AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            @SuppressLint({"SyntheticAccessor"})
            public final void onCancel(DialogInterface dialogInterface) {
                DialogFragment dialogFragment = DialogFragment.this;
                if (dialogFragment.mDialog != null) {
                    dialogFragment.onCancel(dialogFragment.mDialog);
                }
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: androidx.fragment.app.DialogFragment.3
            public AnonymousClass3() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            @SuppressLint({"SyntheticAccessor"})
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogFragment dialogFragment = DialogFragment.this;
                if (dialogFragment.mDialog != null) {
                    dialogFragment.onDismiss(dialogFragment.mDialog);
                }
            }
        };
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new Observer<LifecycleOwner>() { // from class: androidx.fragment.app.DialogFragment.4
            public AnonymousClass4() {
            }

            @Override // androidx.lifecycle.Observer
            @SuppressLint({"SyntheticAccessor"})
            public final void onChanged(LifecycleOwner lifecycleOwner) {
                if (lifecycleOwner != null) {
                    DialogFragment dialogFragment = DialogFragment.this;
                    if (dialogFragment.mShowsDialog) {
                        View requireView = dialogFragment.requireView();
                        if (requireView.getParent() == null) {
                            if (dialogFragment.mDialog != null) {
                                if (FragmentManager.isLoggingEnabled(3)) {
                                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + dialogFragment.mDialog);
                                }
                                dialogFragment.mDialog.setContentView(requireView);
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
            }
        };
        this.mDialogCreated = false;
    }

    private void dismissInternal(boolean z, boolean z2) {
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.mHandler.getLooper()) {
                    onDismiss(this.mDialog);
                } else {
                    this.mHandler.post(this.mDismissRunnable);
                }
            }
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            int r6 = this.mBackStackId;
            parentFragmentManager.getClass();
            if (r6 >= 0) {
                parentFragmentManager.enqueueAction(new FragmentManager.PopBackStackState(null, r6, 1), false);
                this.mBackStackId = -1;
                return;
            }
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Bad id: ", r6));
        }
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        parentFragmentManager2.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(parentFragmentManager2);
        backStackRecord.remove(this);
        if (z) {
            backStackRecord.commitAllowingStateLoss();
        } else {
            backStackRecord.commit();
        }
    }

    private void prepareDialog(Bundle bundle) {
        if (this.mShowsDialog && !this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                Dialog onCreateDialog = onCreateDialog(bundle);
                this.mDialog = onCreateDialog;
                if (this.mShowsDialog) {
                    setupDialog(onCreateDialog, this.mStyle);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.mDialog.setOwnerActivity((Activity) context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                } else {
                    this.mDialog = null;
                }
            } finally {
                this.mCreatingDialog = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public FragmentContainer createFragmentContainer() {
        return new FragmentContainer() { // from class: androidx.fragment.app.DialogFragment.5
            public final /* synthetic */ FragmentContainer val$fragmentContainer;

            public AnonymousClass5(FragmentContainer fragmentContainer) {
                r2 = fragmentContainer;
            }

            @Override // androidx.fragment.app.FragmentContainer
            public final View onFindViewById(int r3) {
                FragmentContainer fragmentContainer = r2;
                if (fragmentContainer.onHasView()) {
                    return fragmentContainer.onFindViewById(r3);
                }
                return DialogFragment.this.onFindViewById(r3);
            }

            @Override // androidx.fragment.app.FragmentContainer
            public final boolean onHasView() {
                if (!r2.onHasView() && !DialogFragment.this.onHasView()) {
                    return false;
                }
                return true;
            }
        };
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (!this.mShownByMe) {
            this.mDismissed = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.mHandler = new Handler();
        if (this.mContainerId == 0) {
            z = true;
        } else {
            z = false;
        }
        this.mShowsDialog = z;
        if (bundle != null) {
            this.mStyle = bundle.getInt(SAVED_STYLE, 0);
            this.mTheme = bundle.getInt(SAVED_THEME, 0);
            this.mCancelable = bundle.getBoolean(SAVED_CANCELABLE, true);
            this.mShowsDialog = bundle.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
            this.mBackStackId = bundle.getInt(SAVED_BACK_STACK_ID, -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.mViewDestroyed) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            dismissInternal(true, true);
        }
    }

    public View onFindViewById(int r2) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            return dialog.findViewById(r2);
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (this.mShowsDialog && !this.mCreatingDialog) {
            prepareDialog(bundle);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.mDialog;
            if (dialog != null) {
                return onGetLayoutInflater.cloneInContext(dialog.getContext());
            }
            return onGetLayoutInflater;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.mShowsDialog) {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
            } else {
                Log.d("FragmentManager", "mCreatingDialog = true: " + str);
            }
        }
        return onGetLayoutInflater;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
            bundle.putBundle(SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
        }
        int r0 = this.mStyle;
        if (r0 != 0) {
            bundle.putInt(SAVED_STYLE, r0);
        }
        int r02 = this.mTheme;
        if (r02 != 0) {
            bundle.putInt(SAVED_THEME, r02);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean(SAVED_CANCELABLE, z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean(SAVED_SHOWS_DIALOG, z2);
        }
        int r03 = this.mBackStackId;
        if (r03 != -1) {
            bundle.putInt(SAVED_BACK_STACK_ID, r03);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            ViewTreeLifecycleOwner.set(decorView, this);
            ViewTreeViewModelStoreOwner.set(decorView, this);
            ViewTreeSavedStateRegistryOwner.set(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView == null && this.mDialog != null && bundle != null && (bundle2 = bundle.getBundle(SAVED_DIALOG_STATE_TAG)) != null) {
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    public final Dialog requireDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean z) {
        this.mCancelable = z;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.mShowsDialog = z;
    }

    public void setStyle(int r4, int r5) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + r4 + ", " + r5);
        }
        this.mStyle = r4;
        if (r4 == 2 || r4 == 3) {
            this.mTheme = R.style.Theme.Panel;
        }
        if (r5 != 0) {
            this.mTheme = r5;
        }
    }

    public void setupDialog(Dialog dialog, int r4) {
        if (r4 != 1 && r4 != 2) {
            if (r4 == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void show(FragmentManager fragmentManager, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(fragmentManager, fragmentManager);
        m.doAddOp(0, this, str, 1);
        m.commit();
    }

    public void showNow(FragmentManager fragmentManager, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(fragmentManager, fragmentManager);
        m.doAddOp(0, this, str, 1);
        if (!m.mAddToBackStack) {
            m.mAllowAddToBackStack = false;
            m.mManager.execSingleAction(m, false);
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentTransaction.doAddOp(0, this, str, 1);
        this.mViewDestroyed = false;
        int commitInternal = ((BackStackRecord) fragmentTransaction).commitInternal(false);
        this.mBackStackId = commitInternal;
        return commitInternal;
    }

    public DialogFragment(int r2) {
        super(r2);
        this.mDismissRunnable = new Runnable() { // from class: androidx.fragment.app.DialogFragment.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            @SuppressLint({"SyntheticAccessor"})
            public final void run() {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.mOnDismissListener.onDismiss(dialogFragment.mDialog);
            }
        };
        this.mOnCancelListener = new DialogInterface.OnCancelListener() { // from class: androidx.fragment.app.DialogFragment.2
            public AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            @SuppressLint({"SyntheticAccessor"})
            public final void onCancel(DialogInterface dialogInterface) {
                DialogFragment dialogFragment = DialogFragment.this;
                if (dialogFragment.mDialog != null) {
                    dialogFragment.onCancel(dialogFragment.mDialog);
                }
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: androidx.fragment.app.DialogFragment.3
            public AnonymousClass3() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            @SuppressLint({"SyntheticAccessor"})
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogFragment dialogFragment = DialogFragment.this;
                if (dialogFragment.mDialog != null) {
                    dialogFragment.onDismiss(dialogFragment.mDialog);
                }
            }
        };
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new Observer<LifecycleOwner>() { // from class: androidx.fragment.app.DialogFragment.4
            public AnonymousClass4() {
            }

            @Override // androidx.lifecycle.Observer
            @SuppressLint({"SyntheticAccessor"})
            public final void onChanged(LifecycleOwner lifecycleOwner) {
                if (lifecycleOwner != null) {
                    DialogFragment dialogFragment = DialogFragment.this;
                    if (dialogFragment.mShowsDialog) {
                        View requireView = dialogFragment.requireView();
                        if (requireView.getParent() == null) {
                            if (dialogFragment.mDialog != null) {
                                if (FragmentManager.isLoggingEnabled(3)) {
                                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + dialogFragment.mDialog);
                                }
                                dialogFragment.mDialog.setContentView(requireView);
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                }
            }
        };
        this.mDialogCreated = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
