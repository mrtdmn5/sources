package com.animaconnected.secondo.screens.notification;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.DialogFragment$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemConstants;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.FeedbackView;
import com.animaconnected.secondo.screens.details.BottomDialogDetailView;
import com.animaconnected.secondo.screens.details.Dismissible;
import com.animaconnected.secondo.screens.details.OnDismissedListener;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.animaconnected.secondo.screens.notification.NotificationDetailsPresenter;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.secondo.utils.animations.AnimationFinishedListener;
import com.kronaby.watch.app.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationDetailsFragment.kt */
/* loaded from: classes3.dex */
public abstract class NotificationDetailsFragment extends BaseFragment implements Dismissible, BottomDialogDetailView, NotificationDetailsPresenter.NotificationView {
    private static final String FRAGMENT_CENTER_X = "fragment_center_x";
    private static final String FRAGMENT_CENTER_Y = "fragment_center_y";
    private static final String FRAGMENT_DROPPED = "fragment_dropped";
    private static final String FRAGMENT_FINAL_HEIGHT = "fragment_final_height";
    private static final String FRAGMENT_FINAL_WIDTH = "fragment_final_width";
    private static final String FRAGMENT_TYPE = "fragment_type";
    private static final int NO_TYPE = -1;
    private FrameLayout bottomDialog;
    private int centerX;
    private int centerY;
    private ViewGroup containerLayout;
    private ViewGroup containingContainerLayout;
    private boolean dropped;
    private int finalHeight;
    private int finalWidth;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    private NotificationDetailsPresenter presenter;
    private boolean showCircularRevealAnimation;
    private int type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: NotificationDetailsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NotificationDetailsFragment setArguments(NotificationDetailsFragment fragment, int r4, int r5, int r6, int r7, int r8, boolean z) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Bundle bundle = new Bundle();
            bundle.putInt("fragment_center_x", r4);
            bundle.putInt("fragment_center_y", r5);
            bundle.putInt("fragment_final_width", r6);
            bundle.putInt("fragment_final_height", r7);
            bundle.putInt(NotificationDetailsFragment.FRAGMENT_TYPE, r8);
            bundle.putBoolean(NotificationDetailsFragment.FRAGMENT_DROPPED, z);
            fragment.setArguments(bundle);
            return fragment;
        }

        private Companion() {
        }
    }

    public NotificationDetailsFragment() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.animaconnected.secondo.screens.notification.NotificationDetailsFragment$special$$inlined$registerMultiplePermissions$default$1
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
    }

    public static final void dismiss$lambda$0(OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onDismissed();
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
        ViewGroup viewGroup = this.containerLayout;
        if (viewGroup != null) {
            AnimationFactoryKotlinKt.startCircularRevealExitAnimation(requireContext, requireView, r3, r4, r5, r6, viewGroup, new AnimationFinishedListener() { // from class: com.animaconnected.secondo.screens.notification.NotificationDetailsFragment$$ExternalSyntheticLambda0
                @Override // com.animaconnected.secondo.utils.animations.AnimationFinishedListener
                public final void onAnimationFinished() {
                    NotificationDetailsFragment.dismiss$lambda$0(OnDismissedListener.this);
                }
            });
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("containerLayout");
            throw null;
        }
    }

    public final int getCenterX() {
        return this.centerX;
    }

    public final int getCenterY() {
        return this.centerY;
    }

    public final int getConfigurationDescription() {
        return -1;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_notification);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "NotificationsDetail";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public Drawable getToolbarBackDrawable() {
        Context requireContext = requireContext();
        Object obj = ContextCompat.sLock;
        return ContextCompat.Api21Impl.getDrawable(requireContext, R.drawable.ic_close);
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsPresenter.NotificationView
    public void hideBottomDialog() {
        FrameLayout frameLayout = this.bottomDialog;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public final void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.containerLayout = viewGroup;
        if (this.showCircularRevealAnimation) {
            this.showCircularRevealAnimation = false;
            registerCircularRevealAnimation(view, viewGroup);
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BottomDialogDetailView
    public void onBottomDialogClicked() {
        NotificationDetailsPresenter notificationDetailsPresenter = this.presenter;
        if (notificationDetailsPresenter != null) {
            notificationDetailsPresenter.onDialogButtonClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments(...)");
        this.centerX = requireArguments.getInt("fragment_center_x", 0);
        this.centerY = requireArguments.getInt("fragment_center_y", 0);
        this.finalWidth = requireArguments.getInt("fragment_final_width", 0);
        this.finalHeight = requireArguments.getInt("fragment_final_height", 0);
        this.dropped = requireArguments.getBoolean(FRAGMENT_DROPPED, false);
        this.type = requireArguments.getInt(FRAGMENT_TYPE, -1);
        this.showCircularRevealAnimation = true;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.presenter = new NotificationDetailsPresenter(this, requireContext, this.type, this.dropped, PermissionCompat.create(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        NotificationDetailsPresenter notificationDetailsPresenter = this.presenter;
        if (notificationDetailsPresenter != null) {
            notificationDetailsPresenter.onResume();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.bottomDialog = (FrameLayout) view.findViewById(R.id.bottom_dialog_container);
        if (ProviderFactory.getLabsProvider().isNotificationItemTypeLabs(this.type)) {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.detail_layout);
            this.containingContainerLayout = viewGroup;
            if (viewGroup != null) {
                Context requireContext = requireContext();
                Object obj = ContextCompat.sLock;
                viewGroup.setBackgroundColor(ContextCompat.Api23Impl.getColor(requireContext, R.color.labs_color));
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.feature_icon);
            if (imageView != null) {
                imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
            }
        }
        View findViewById = view.findViewById(R.id.feedback_view);
        if (findViewById instanceof FeedbackView) {
            String notificationName = NotificationItemConstants.getNotificationName(this.type);
            Intrinsics.checkNotNullExpressionValue(notificationName, "getNotificationName(...)");
            ((FeedbackView) findViewById).setAnalyticsName(notificationName);
        }
    }

    public final void registerCircularRevealAnimation(View view, View view2) {
        if (view != null && view2 != null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            AnimationFactoryKotlinKt.registerCircularRevealAnimation(requireContext, view, this.centerX, this.centerY, this.finalWidth, this.finalHeight, view2);
        }
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsPresenter.NotificationView
    public void requestPermissions(String[] permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.permissionLauncher.launch(permissions);
    }

    public final void setCenterX(int r1) {
        this.centerX = r1;
    }

    public final void setCenterY(int r1) {
        this.centerY = r1;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsPresenter.NotificationView
    public void showBottomDialog(int r9, int r10, int r11, int r12, int r13) {
        FrameLayout frameLayout = this.bottomDialog;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(0);
        DetailBottomDialog newInstance = DetailBottomDialog.Companion.newInstance(r9, r10, r11, r12, r13);
        FragmentManager childFragmentManager = getChildFragmentManager();
        BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(childFragmentManager, childFragmentManager);
        m.replace(R.id.bottom_dialog_container, newInstance, newInstance.getClass().getSimpleName());
        m.commit();
    }
}
