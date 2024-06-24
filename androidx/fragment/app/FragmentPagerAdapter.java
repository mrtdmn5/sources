package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
/* loaded from: classes.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final FragmentManager mFragmentManager;

    @Deprecated
    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String makeFragmentName(int r2, long j) {
        return "android:switcher:" + r2 + ":" + j;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int r3, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            this.mCurTransaction = DialogFragment$$ExternalSyntheticOutline0.m(fragmentManager, fragmentManager);
        }
        BackStackRecord backStackRecord = (BackStackRecord) this.mCurTransaction;
        backStackRecord.getClass();
        FragmentManager fragmentManager2 = fragment.mFragmentManager;
        if (fragmentManager2 != null && fragmentManager2 != backStackRecord.mManager) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        backStackRecord.addOp(new FragmentTransaction.Op(fragment, 6));
        if (fragment.equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.mCurTransaction;
        if (fragmentTransaction != null) {
            if (!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    BackStackRecord backStackRecord = (BackStackRecord) fragmentTransaction;
                    if (!backStackRecord.mAddToBackStack) {
                        backStackRecord.mAllowAddToBackStack = false;
                        backStackRecord.mManager.execSingleAction(backStackRecord, true);
                    } else {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                } finally {
                    this.mExecutingFinishUpdate = false;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public abstract Fragment getItem(int r1);

    public long getItemId(int r3) {
        return r3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int r7) {
        if (this.mCurTransaction == null) {
            FragmentManager fragmentManager = this.mFragmentManager;
            this.mCurTransaction = DialogFragment$$ExternalSyntheticOutline0.m(fragmentManager, fragmentManager);
        }
        long itemId = getItemId(r7);
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(makeFragmentName(viewGroup.getId(), itemId));
        if (findFragmentByTag != null) {
            FragmentTransaction fragmentTransaction = this.mCurTransaction;
            fragmentTransaction.getClass();
            fragmentTransaction.addOp(new FragmentTransaction.Op(findFragmentByTag, 7));
        } else {
            findFragmentByTag = getItem(r7);
            this.mCurTransaction.doAddOp(viewGroup.getId(), findFragmentByTag, makeFragmentName(viewGroup.getId(), itemId), 1);
        }
        if (findFragmentByTag != this.mCurrentPrimaryItem) {
            findFragmentByTag.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.setMaxLifecycle(findFragmentByTag, Lifecycle.State.STARTED);
            } else {
                findFragmentByTag.setUserVisibleHint(false);
            }
        }
        return findFragmentByTag;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (((Fragment) obj).getView() == view) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int r4, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        FragmentManager fragmentManager = this.mFragmentManager;
                        this.mCurTransaction = DialogFragment$$ExternalSyntheticOutline0.m(fragmentManager, fragmentManager);
                    }
                    this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    FragmentManager fragmentManager2 = this.mFragmentManager;
                    this.mCurTransaction = DialogFragment$$ExternalSyntheticOutline0.m(fragmentManager2, fragmentManager2);
                }
                this.mCurTransaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentPagerAdapter(FragmentManager fragmentManager, int r3) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager;
        this.mBehavior = r3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }
}
