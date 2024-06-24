package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class FragmentTransaction {
    public boolean mAddToBackStack;
    public int mBreadCrumbShortTitleRes;
    public CharSequence mBreadCrumbShortTitleText;
    public int mBreadCrumbTitleRes;
    public CharSequence mBreadCrumbTitleText;
    public int mEnterAnim;
    public int mExitAnim;
    public String mName;
    public int mPopEnterAnim;
    public int mPopExitAnim;
    public ArrayList<String> mSharedElementSourceNames;
    public ArrayList<String> mSharedElementTargetNames;
    public int mTransition;
    public final ArrayList<Op> mOps = new ArrayList<>();
    public boolean mAllowAddToBackStack = true;
    public boolean mReorderingAllowed = false;

    /* loaded from: classes.dex */
    public static final class Op {
        public int mCmd;
        public Lifecycle.State mCurrentMaxState;
        public int mEnterAnim;
        public int mExitAnim;
        public Fragment mFragment;
        public Lifecycle.State mOldMaxState;
        public int mPopEnterAnim;
        public int mPopExitAnim;

        public Op() {
        }

        public Op(Fragment fragment, int r2) {
            this.mCmd = r2;
            this.mFragment = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.mOldMaxState = state;
            this.mCurrentMaxState = state;
        }

        public Op(Fragment fragment, Lifecycle.State state) {
            this.mCmd = 10;
            this.mFragment = fragment;
            this.mOldMaxState = fragment.mMaxState;
            this.mCurrentMaxState = state;
        }
    }

    public final void addOp(Op op) {
        this.mOps.add(op);
        op.mEnterAnim = this.mEnterAnim;
        op.mExitAnim = this.mExitAnim;
        op.mPopEnterAnim = this.mPopEnterAnim;
        op.mPopExitAnim = this.mPopExitAnim;
    }

    public final void addToBackStack(String str) {
        if (this.mAllowAddToBackStack) {
            this.mAddToBackStack = true;
            this.mName = str;
            return;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public abstract void doAddOp(int r1, Fragment fragment, String str, int r4);

    public final void replace(int r2, Fragment fragment, String str) {
        if (r2 != 0) {
            doAddOp(r2, fragment, str, 2);
            return;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public final void setCustomAnimations(int r1, int r2, int r3, int r4) {
        this.mEnterAnim = r1;
        this.mExitAnim = r2;
        this.mPopEnterAnim = r3;
        this.mPopExitAnim = r4;
    }

    public abstract BackStackRecord setMaxLifecycle(Fragment fragment, Lifecycle.State state);
}
