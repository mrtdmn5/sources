package com.animaconnected.secondo.screens.details;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.DialogFragment$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.BehaviourFactory;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.labs.LabsProvider;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.details.DetailsPresenter;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.secondo.utils.animations.AnimationFinishedListener;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviour;
import com.kronaby.watch.app.R;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailsFragment.kt */
/* loaded from: classes3.dex */
public final class DetailsFragment extends BaseFragment implements DetailsPresenter.DetailsView, Dismissible, BottomDialogDetailView {
    private static final String FRAGMENT_BEHAVIOUR_TYPE = "fragment_behaviour_type";
    private static final String FRAGMENT_CENTER_X = "fragment_center_x";
    private static final String FRAGMENT_CENTER_Y = "fragment_center_y";
    private static final String FRAGMENT_DETAILS_TITLE = "fragment_details_title";
    private static final String FRAGMENT_FINAL_HEIGHT = "fragment_final_height";
    private static final String FRAGMENT_FINAL_WIDTH = "fragment_final_width";
    private static final String FRAGMENT_SHOULD_REVEAL = "fragment_should_reveal";
    private static final String FRAGMENT_SLOT = "fragment_slot";
    public static final String NAME = "Details";
    private String behaviourType;
    private FrameLayout bottomDialog;
    private int centerX;
    private int centerY;
    private DetailsPresenter detailsPresenter;
    private int finalHeight;
    private int finalWidth;
    private ViewGroup fragmentContainerLayout;
    private final String name;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    private boolean shouldReveal;
    private Slot slot;
    private String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DetailsFragment newInstance(String str, Slot slot, String str2, int r7, int r8, int r9, int r10, boolean z) {
            DetailsFragment detailsFragment = new DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DetailsFragment.FRAGMENT_BEHAVIOUR_TYPE, str);
            Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type java.io.Serializable");
            bundle.putSerializable(DetailsFragment.FRAGMENT_SLOT, slot);
            bundle.putString(DetailsFragment.FRAGMENT_DETAILS_TITLE, str2);
            bundle.putInt("fragment_center_x", r7);
            bundle.putInt("fragment_center_y", r8);
            bundle.putInt("fragment_final_width", r9);
            bundle.putInt("fragment_final_height", r10);
            bundle.putBoolean(DetailsFragment.FRAGMENT_SHOULD_REVEAL, z);
            detailsFragment.setArguments(bundle);
            return detailsFragment;
        }

        private Companion() {
        }
    }

    public DetailsFragment() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.animaconnected.secondo.screens.details.DetailsFragment$special$$inlined$registerMultiplePermissions$default$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Map<String, Boolean> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Set<Map.Entry<String, Boolean>> entrySet = result.entrySet();
                if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
                    return;
                }
                Iterator<T> it = entrySet.iterator();
                while (it.hasNext() && ((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = registerForActivityResult;
        this.name = NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$0(OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onDismissed();
    }

    private final BaseDetailsFragment getChildDetailsFragment() {
        return (BaseDetailsFragment) getChildFragmentManager().findFragmentById(R.id.fragment_container);
    }

    @Override // com.animaconnected.secondo.screens.details.Dismissible
    public void dismiss(final OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView(...)");
        int r3 = this.centerX;
        int r4 = this.centerY;
        int r5 = this.finalWidth;
        int r6 = this.finalHeight;
        ViewGroup viewGroup = this.fragmentContainerLayout;
        if (viewGroup != null) {
            AnimationFactoryKotlinKt.startCircularRevealExitAnimation(requireContext, requireView, r3, r4, r5, r6, viewGroup, new AnimationFinishedListener() { // from class: com.animaconnected.secondo.screens.details.DetailsFragment$$ExternalSyntheticLambda0
                @Override // com.animaconnected.secondo.utils.animations.AnimationFinishedListener
                public final void onAnimationFinished() {
                    DetailsFragment.dismiss$lambda$0(OnDismissedListener.this);
                }
            });
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainerLayout");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String str = this.title;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DetailBottomDialog.keyTitle);
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public Drawable getToolbarBackDrawable() {
        Context requireContext = requireContext();
        Object obj = ContextCompat.sLock;
        return ContextCompat.Api21Impl.getDrawable(requireContext, R.drawable.ic_close);
    }

    @Override // com.animaconnected.secondo.screens.details.DetailsPresenter.DetailsView
    public void hideBottomDialog() {
        FrameLayout frameLayout = this.bottomDialog;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("bottomDialog");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BottomDialogDetailView
    public void onBottomDialogClicked() {
        DetailsPresenter detailsPresenter = this.detailsPresenter;
        if (detailsPresenter != null) {
            detailsPresenter.onBottomDialogClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("detailsPresenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Slot slot;
        super.onCreate(bundle);
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments(...)");
        String string = requireArguments.getString(FRAGMENT_BEHAVIOUR_TYPE);
        Intrinsics.checkNotNull(string);
        this.behaviourType = string;
        Serializable serializable = requireArguments.getSerializable(FRAGMENT_SLOT);
        if (serializable instanceof Slot) {
            slot = (Slot) serializable;
        } else {
            slot = null;
        }
        if (slot == null) {
            slot = Slot.Unknown;
        }
        this.slot = slot;
        String string2 = requireArguments.getString(FRAGMENT_DETAILS_TITLE, "");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.title = string2;
        this.centerX = requireArguments.getInt("fragment_center_x", 0);
        this.centerY = requireArguments.getInt("fragment_center_y", 0);
        this.finalWidth = requireArguments.getInt("fragment_final_width", 0);
        this.finalHeight = requireArguments.getInt("fragment_final_height", 0);
        this.shouldReveal = requireArguments.getBoolean(FRAGMENT_SHOULD_REVEAL, false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        int r0;
        boolean z;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LabsProvider labsProvider = ProviderFactory.getLabsProvider();
        String str = this.behaviourType;
        if (str != null) {
            if (labsProvider.isBehaviourTypeLabs(str)) {
                r0 = R.layout.fragment_details_labs;
            } else {
                r0 = R.layout.fragment_details;
            }
            View inflate = inflater.inflate(r0, viewGroup, false);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            BehaviourFactory behaviourFactory = ProviderFactory.getBehaviourFactory();
            String str2 = this.behaviourType;
            if (str2 != null) {
                BehaviourPlugin<Behaviour> plugin = behaviourFactory.getPlugin(str2);
                Slot slot = this.slot;
                if (slot != null) {
                    PermissionCompat.PermissionWrapperFragment create = PermissionCompat.create(this);
                    if (bundle == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.detailsPresenter = new DetailsPresenter(requireContext, this, plugin, slot, create, z);
                    View findViewById = inflate.findViewById(R.id.bottom_dialog_container);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                    this.bottomDialog = (FrameLayout) findViewById;
                    View findViewById2 = inflate.findViewById(R.id.fragment_container);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                    this.fragmentContainerLayout = (ViewGroup) findViewById2;
                    if (this.shouldReveal) {
                        Context requireContext2 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                        int r6 = this.centerX;
                        int r7 = this.centerY;
                        int r8 = this.finalWidth;
                        int r9 = this.finalHeight;
                        ViewGroup viewGroup2 = this.fragmentContainerLayout;
                        if (viewGroup2 != null) {
                            AnimationFactoryKotlinKt.registerCircularRevealAnimation(requireContext2, inflate, r6, r7, r8, r9, viewGroup2);
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainerLayout");
                            throw null;
                        }
                    }
                    this.shouldReveal = false;
                    return inflate;
                }
                Intrinsics.throwUninitializedPropertyAccessException("slot");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("behaviourType");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("behaviourType");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        DetailsPresenter detailsPresenter = this.detailsPresenter;
        if (detailsPresenter != null) {
            detailsPresenter.onPause();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("detailsPresenter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DetailsPresenter detailsPresenter = this.detailsPresenter;
        if (detailsPresenter != null) {
            detailsPresenter.onResume();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("detailsPresenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.details.DetailsPresenter.DetailsView
    public void requestPermissions(String[] permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.permissionLauncher.launch(permissions);
    }

    @Override // com.animaconnected.secondo.screens.details.DetailsPresenter.DetailsView
    public void setFragment(BaseDetailsFragment baseDetailsFragment) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(childFragmentManager);
        Intrinsics.checkNotNull(baseDetailsFragment);
        backStackRecord.replace(R.id.fragment_container, baseDetailsFragment, baseDetailsFragment.getClass().getSimpleName());
        backStackRecord.commit();
    }

    @Override // com.animaconnected.secondo.screens.details.DetailsPresenter.DetailsView
    public void showBottomDialog(int r9, int r10, int r11, int r12, int r13) {
        FrameLayout frameLayout = this.bottomDialog;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            DetailBottomDialog newInstance = DetailBottomDialog.Companion.newInstance(r9, r10, r11, r12, r13);
            FragmentManager childFragmentManager = getChildFragmentManager();
            BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(childFragmentManager, childFragmentManager);
            m.replace(R.id.bottom_dialog_container, newInstance, newInstance.getClass().getSimpleName());
            m.commit();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bottomDialog");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.details.DetailsPresenter.DetailsView
    public void startRefreshing() {
        BaseDetailsFragment childDetailsFragment = getChildDetailsFragment();
        Intrinsics.checkNotNull(childDetailsFragment);
        childDetailsFragment.startRefreshing();
    }

    @Override // com.animaconnected.secondo.screens.details.DetailsPresenter.DetailsView
    public void stopRefreshing() {
        BaseDetailsFragment childDetailsFragment = getChildDetailsFragment();
        Intrinsics.checkNotNull(childDetailsFragment);
        childDetailsFragment.stopRefreshing();
    }
}
