package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import com.kronaby.watch.app.R;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class NavHostFragment extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean mDefaultNavHost;
    public int mGraphId;
    public Boolean mIsPrimaryBeforeOnCreate = null;
    public NavHostController mNavController;
    public View mViewParent;

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        if (this.mDefaultNavHost) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            parentFragmentManager.getClass();
            BackStackRecord backStackRecord = new BackStackRecord(parentFragmentManager);
            backStackRecord.setPrimaryNavigationFragment(this);
            backStackRecord.commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        NavigatorProvider navigatorProvider = this.mNavController.mNavigatorProvider;
        navigatorProvider.getClass();
        DialogFragmentNavigator dialogFragmentNavigator = (DialogFragmentNavigator) navigatorProvider.getNavigator(NavigatorProvider.getNameForNavigator(DialogFragmentNavigator.class));
        if (dialogFragmentNavigator.mRestoredTagsAwaitingAttach.remove(fragment.getTag())) {
            fragment.getLifecycle().addObserver(dialogFragmentNavigator.mObserver);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        boolean z;
        Bundle bundle2;
        NavHostController navHostController = new NavHostController(requireContext());
        this.mNavController = navHostController;
        if (this != navHostController.mLifecycleOwner) {
            navHostController.mLifecycleOwner = this;
            getLifecycle().addObserver(navHostController.mLifecycleObserver);
        }
        NavHostController navHostController2 = this.mNavController;
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        if (navHostController2.mLifecycleOwner != null) {
            NavController.AnonymousClass2 anonymousClass2 = navHostController2.mOnBackPressedCallback;
            Iterator<Cancellable> it = anonymousClass2.cancellables.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            onBackPressedDispatcher.addCallback(navHostController2.mLifecycleOwner, anonymousClass2);
            NavHostController navHostController3 = this.mNavController;
            Boolean bool = this.mIsPrimaryBeforeOnCreate;
            int r3 = 0;
            if (bool != null && bool.booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            navHostController3.mEnableOnBackPressedCallback = z;
            navHostController3.updateOnBackPressedCallbackEnabled();
            Bundle bundle3 = null;
            this.mIsPrimaryBeforeOnCreate = null;
            NavHostController navHostController4 = this.mNavController;
            ViewModelStore viewModelStore = getViewModelStore();
            NavControllerViewModel navControllerViewModel = navHostController4.mViewModel;
            NavControllerViewModel.AnonymousClass1 anonymousClass1 = NavControllerViewModel.FACTORY;
            if (navControllerViewModel != ((NavControllerViewModel) new ViewModelProvider(viewModelStore, anonymousClass1).get(NavControllerViewModel.class))) {
                if (navHostController4.mBackStack.isEmpty()) {
                    navHostController4.mViewModel = (NavControllerViewModel) new ViewModelProvider(viewModelStore, anonymousClass1).get(NavControllerViewModel.class);
                } else {
                    throw new IllegalStateException("ViewModelStore should be set before setGraph call");
                }
            }
            NavHostController navHostController5 = this.mNavController;
            navHostController5.mNavigatorProvider.addNavigator(new DialogFragmentNavigator(getChildFragmentManager(), requireContext()));
            Context requireContext = requireContext();
            FragmentManager childFragmentManager = getChildFragmentManager();
            int id = getId();
            if (id == 0 || id == -1) {
                id = R.id.nav_host_fragment_container;
            }
            navHostController5.mNavigatorProvider.addNavigator(new FragmentNavigator(requireContext, childFragmentManager, id));
            if (bundle != null) {
                bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
                if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                    this.mDefaultNavHost = true;
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    parentFragmentManager.getClass();
                    BackStackRecord backStackRecord = new BackStackRecord(parentFragmentManager);
                    backStackRecord.setPrimaryNavigationFragment(this);
                    backStackRecord.commit();
                }
                this.mGraphId = bundle.getInt("android-support-nav:fragment:graphId");
            } else {
                bundle2 = null;
            }
            if (bundle2 != null) {
                NavHostController navHostController6 = this.mNavController;
                bundle2.setClassLoader(navHostController6.mContext.getClassLoader());
                navHostController6.mNavigatorStateToRestore = bundle2.getBundle("android-support-nav:controller:navigatorState");
                navHostController6.mBackStackToRestore = bundle2.getParcelableArray("android-support-nav:controller:backStack");
                navHostController6.mDeepLinkHandled = bundle2.getBoolean("android-support-nav:controller:deepLinkHandled");
            }
            int r2 = this.mGraphId;
            if (r2 != 0) {
                this.mNavController.setGraph(r2, null);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    r3 = arguments.getInt("android-support-nav:fragment:graphId");
                }
                if (arguments != null) {
                    bundle3 = arguments.getBundle("android-support-nav:fragment:startDestinationArgs");
                }
                if (r3 != 0) {
                    this.mNavController.setGraph(r3, bundle3);
                }
            }
            super.onCreate(bundle);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        int id = getId();
        if (id == 0 || id == -1) {
            id = R.id.nav_host_fragment_container;
        }
        fragmentContainerView.setId(id);
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        View view = this.mViewParent;
        if (view != null && Navigation.findNavController(view) == this.mNavController) {
            this.mViewParent.setTag(R.id.nav_controller_view_tag, null);
        }
        this.mViewParent = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.navigation.R$styleable.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.mGraphId = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(0, false)) {
            this.mDefaultNavHost = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPrimaryNavigationFragmentChanged(boolean z) {
        NavHostController navHostController = this.mNavController;
        if (navHostController != null) {
            navHostController.mEnableOnBackPressedCallback = z;
            navHostController.updateOnBackPressedCallbackEnabled();
        } else {
            this.mIsPrimaryBeforeOnCreate = Boolean.valueOf(z);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2;
        super.onSaveInstanceState(bundle);
        NavHostController navHostController = this.mNavController;
        navHostController.getClass();
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle3 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : navHostController.mNavigatorProvider.mNavigators.entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle3.putBundle(key, onSaveState);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle2 = new Bundle();
            bundle3.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle2.putBundle("android-support-nav:controller:navigatorState", bundle3);
        } else {
            bundle2 = null;
        }
        ArrayDeque arrayDeque = navHostController.mBackStack;
        if (!arrayDeque.isEmpty()) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[arrayDeque.size()];
            Iterator it = arrayDeque.iterator();
            int r4 = 0;
            while (it.hasNext()) {
                parcelableArr[r4] = new NavBackStackEntryState((NavBackStackEntry) it.next());
                r4++;
            }
            bundle2.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (navHostController.mDeepLinkHandled) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android-support-nav:controller:deepLinkHandled", navHostController.mDeepLinkHandled);
        }
        if (bundle2 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", bundle2);
        }
        if (this.mDefaultNavHost) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int r0 = this.mGraphId;
        if (r0 != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", r0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            view.setTag(R.id.nav_controller_view_tag, this.mNavController);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.mViewParent = view2;
                if (view2.getId() == getId()) {
                    this.mViewParent.setTag(R.id.nav_controller_view_tag, this.mNavController);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }
}
