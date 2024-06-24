package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.OpGenerator {
    public boolean mCommitted;
    public int mIndex;
    public final FragmentManager mManager;

    public BackStackRecord(FragmentManager fragmentManager) {
        fragmentManager.getFragmentFactory();
        FragmentHostCallback<?> fragmentHostCallback = fragmentManager.mHost;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.mContext.getClassLoader();
        }
        this.mIndex = -1;
        this.mManager = fragmentManager;
    }

    public final void bumpBackStackNesting(int r9) {
        if (!this.mAddToBackStack) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + r9);
        }
        ArrayList<FragmentTransaction.Op> arrayList = this.mOps;
        int size = arrayList.size();
        for (int r4 = 0; r4 < size; r4++) {
            FragmentTransaction.Op op = arrayList.get(r4);
            Fragment fragment = op.mFragment;
            if (fragment != null) {
                fragment.mBackStackNesting += r9;
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Bump nesting of " + op.mFragment + " to " + op.mFragment.mBackStackNesting);
                }
            }
        }
    }

    public final int commit() {
        return commitInternal(false);
    }

    public final int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    public final int commitInternal(boolean z) {
        if (!this.mCommitted) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new LogWriter());
                dump("  ", printWriter, true);
                printWriter.close();
            }
            this.mCommitted = true;
            boolean z2 = this.mAddToBackStack;
            FragmentManager fragmentManager = this.mManager;
            if (z2) {
                this.mIndex = fragmentManager.mBackStackIndex.getAndIncrement();
            } else {
                this.mIndex = -1;
            }
            fragmentManager.enqueueAction(this, z);
            return this.mIndex;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void doAddOp(int r4, Fragment fragment, String str, int r7) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str2 = fragment.mTag;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
                }
                fragment.mTag = str;
            }
            if (r4 != 0) {
                if (r4 != -1) {
                    int r6 = fragment.mFragmentId;
                    if (r6 != 0 && r6 != r4) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + r4);
                    }
                    fragment.mFragmentId = r4;
                    fragment.mContainerId = r4;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            addOp(new FragmentTransaction.Op(fragment, r7));
            fragment.mFragmentManager = this.mManager;
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public final void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        ArrayList<FragmentTransaction.Op> arrayList = this.mOps;
        if (!arrayList.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = arrayList.size();
            for (int r2 = 0; r2 < size; r2++) {
                FragmentTransaction.Op op = arrayList.get(r2);
                switch (op.mCmd) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + op.mCmd;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(r2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(op.mFragment);
                if (z) {
                    if (op.mEnterAnim != 0 || op.mExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.mEnterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.mExitAnim));
                    }
                    if (op.mPopEnterAnim != 0 || op.mPopExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.mPopEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.mPopExitAnim));
                    }
                }
            }
        }
    }

    public final void executeOps() {
        ArrayList<FragmentTransaction.Op> arrayList = this.mOps;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            FragmentTransaction.Op op = arrayList.get(r3);
            Fragment fragment = op.mFragment;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.mTransition);
                fragment.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }
            int r6 = op.mCmd;
            FragmentManager fragmentManager = this.mManager;
            switch (r6) {
                case 1:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.setExitAnimationOrder(fragment, false);
                    fragmentManager.addFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.mCmd);
                case 3:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.setExitAnimationOrder(fragment, false);
                    FragmentManager.showFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.setExitAnimationOrder(fragment, false);
                    fragmentManager.attachFragment(fragment);
                    break;
                case 8:
                    fragmentManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    fragmentManager.setPrimaryNavigationFragment(null);
                    break;
                case 10:
                    fragmentManager.setMaxLifecycle(fragment, op.mCurrentMaxState);
                    break;
            }
        }
    }

    public final void executePopOps() {
        ArrayList<FragmentTransaction.Op> arrayList = this.mOps;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = arrayList.get(size);
            Fragment fragment = op.mFragment;
            if (fragment != null) {
                fragment.setPopDirection(true);
                int r5 = this.mTransition;
                int r6 = 8194;
                if (r5 != 4097) {
                    if (r5 != 4099) {
                        if (r5 != 8194) {
                            r6 = 0;
                        } else {
                            r6 = 4097;
                        }
                    } else {
                        r6 = 4099;
                    }
                }
                fragment.setNextTransition(r6);
                fragment.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
            int r52 = op.mCmd;
            FragmentManager fragmentManager = this.mManager;
            switch (r52) {
                case 1:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.setExitAnimationOrder(fragment, true);
                    fragmentManager.removeFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.mCmd);
                case 3:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.addFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.getClass();
                    FragmentManager.showFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.setExitAnimationOrder(fragment, true);
                    fragmentManager.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.mEnterAnim, op.mExitAnim, op.mPopEnterAnim, op.mPopExitAnim);
                    fragmentManager.setExitAnimationOrder(fragment, true);
                    fragmentManager.detachFragment(fragment);
                    break;
                case 8:
                    fragmentManager.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    fragmentManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 10:
                    fragmentManager.setMaxLifecycle(fragment, op.mOldMaxState);
                    break;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public final boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.mAddToBackStack) {
            FragmentManager fragmentManager = this.mManager;
            if (fragmentManager.mBackStack == null) {
                fragmentManager.mBackStack = new ArrayList<>();
            }
            fragmentManager.mBackStack.add(this);
            return true;
        }
        return true;
    }

    public final BackStackRecord remove(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager != null && fragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        addOp(new FragmentTransaction.Op(fragment, 3));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final BackStackRecord setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        FragmentManager fragmentManager2 = this.mManager;
        if (fragmentManager == fragmentManager2) {
            if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
                throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
            }
            if (state != Lifecycle.State.DESTROYED) {
                addOp(new FragmentTransaction.Op(fragment, state));
                return this;
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + fragmentManager2);
    }

    public final BackStackRecord setPrimaryNavigationFragment(Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment != null && (fragmentManager = fragment.mFragmentManager) != null && fragmentManager != this.mManager) {
            throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        addOp(new FragmentTransaction.Op(fragment, 8));
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }
}
