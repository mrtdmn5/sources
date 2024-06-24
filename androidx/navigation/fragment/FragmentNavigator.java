package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.amazonaws.services.s3.internal.Constants;
import java.util.ArrayDeque;
import java.util.Iterator;

@Navigator.Name("fragment")
/* loaded from: classes.dex */
public final class FragmentNavigator extends Navigator<Destination> {
    public final ArrayDeque<Integer> mBackStack = new ArrayDeque<>();
    public final int mContainerId;
    public final Context mContext;
    public final FragmentManager mFragmentManager;

    /* loaded from: classes.dex */
    public static class Destination extends NavDestination {
        public String mClassName;

        @Override // androidx.navigation.NavDestination
        public final void onInflate(Context context, AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.FragmentNavigator);
            String string = obtainAttributes.getString(0);
            if (string != null) {
                this.mClassName = string;
            }
            obtainAttributes.recycle();
        }

        @Override // androidx.navigation.NavDestination
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.mClassName;
            if (str == null) {
                sb.append(Constants.NULL_VERSION_ID);
            } else {
                sb.append(str);
            }
            return sb.toString();
        }
    }

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int r4) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = r4;
    }

    public static String generateBackStackName(int r1, int r2) {
        return r1 + "-" + r2;
    }

    @Override // androidx.navigation.Navigator
    public final Destination createDestination() {
        return new Destination(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e5  */
    @Override // androidx.navigation.Navigator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.navigation.NavDestination navigate(androidx.navigation.NavDestination r10, android.os.Bundle r11, androidx.navigation.NavOptions r12) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.FragmentNavigator.navigate(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions):androidx.navigation.NavDestination");
    }

    @Override // androidx.navigation.Navigator
    public final void onRestoreState(Bundle bundle) {
        int[] intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds");
        if (intArray != null) {
            ArrayDeque<Integer> arrayDeque = this.mBackStack;
            arrayDeque.clear();
            for (int r0 : intArray) {
                arrayDeque.add(Integer.valueOf(r0));
            }
        }
    }

    @Override // androidx.navigation.Navigator
    public final Bundle onSaveState() {
        Bundle bundle = new Bundle();
        ArrayDeque<Integer> arrayDeque = this.mBackStack;
        int[] r2 = new int[arrayDeque.size()];
        Iterator<Integer> it = arrayDeque.iterator();
        int r3 = 0;
        while (it.hasNext()) {
            r2[r3] = it.next().intValue();
            r3++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", r2);
        return bundle;
    }

    @Override // androidx.navigation.Navigator
    public final boolean popBackStack() {
        ArrayDeque<Integer> arrayDeque = this.mBackStack;
        if (arrayDeque.isEmpty()) {
            return false;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager.isStateSaved()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        fragmentManager.popBackStack(generateBackStackName(arrayDeque.size(), arrayDeque.peekLast().intValue()));
        arrayDeque.removeLast();
        return true;
    }
}
