package com.animaconnected.secondo.behaviour.distress.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestPermission;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragmentKt;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottiePage;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingPagerAdapter;
import com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda7;
import com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda9;
import com.animaconnected.secondo.widget.MorseCodeView;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.distress.Distress;
import com.kronaby.watch.app.R;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: DistressFragment.kt */
/* loaded from: classes3.dex */
public final class DistressFragment extends BaseAnimationDetailsFragment implements DistressPresenter.DistressView {
    private TextView avatarText;
    private Button inviteSafetyContactButton;
    private TextView observerNameView;
    private View observerView;
    private PermissionCompat.PermissionHelper permissionHelper;
    private final ActivityResultLauncher<String> permissionLauncher;
    private DistressPresenter presenter;
    private ProgressBar setupProgressBar;
    private View stateNotStartedView;
    private View stateWaitingForReplyView;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String FRAGMENT_TAG_CODE_LINK_DIALOG = DistressFragment.class.getName().concat(".CODE_LINK_DIALOG");

    /* compiled from: DistressFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseDetailsFragment newInstance(Slot slot) {
            DistressFragment distressFragment = new DistressFragment();
            Bundle bundle = new Bundle();
            BaseDetailsFragmentKt.putSlot(bundle, "slot", slot);
            bundle.putString("type", Distress.TYPE);
            distressFragment.setArguments(bundle);
            return distressFragment;
        }

        private Companion() {
        }
    }

    /* compiled from: DistressFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[DistressPresenter.State.values().length];
            try {
                r0[DistressPresenter.State.NO_SAFETY_CONTACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[DistressPresenter.State.HAS_SAFETY_CONTACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[DistressPresenter.State.BUSY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[DistressPresenter.State.WAITING_FOR_REPLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DistressFragment() {
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback(this) { // from class: com.animaconnected.secondo.behaviour.distress.detail.DistressFragment$special$$inlined$registerPermission$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Boolean bool) {
                DistressPresenter distressPresenter;
                DistressPresenter distressPresenter2;
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    distressPresenter2 = DistressFragment.this.presenter;
                    if (distressPresenter2 != null) {
                        distressPresenter2.locationPermissionGranted();
                        return;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        throw null;
                    }
                }
                distressPresenter = DistressFragment.this.presenter;
                if (distressPresenter != null) {
                    distressPresenter.locationPermissionDenied();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    throw null;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = registerForActivityResult;
    }

    public static final BaseDetailsFragment newInstance(Slot slot) {
        return Companion.newInstance(slot);
    }

    public static final void onCreateView$lambda$2(DistressFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(scope, MainDispatcherLoader.dispatcher, null, new DistressFragment$onCreateView$1$1(this$0, null), 2);
    }

    public static final void onCreateView$lambda$4$lambda$3(Button button, DistressFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        button.setEnabled(false);
        DistressPresenter distressPresenter = this$0.presenter;
        if (distressPresenter != null) {
            distressPresenter.startInviteSafetyContact();
            SubjectNamePhoneDialogFragment.Companion.newInstance().show(this$0.getChildFragmentManager(), (String) null);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    public static final void onCreateView$lambda$5(DistressFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(scope, MainDispatcherLoader.dispatcher, null, new DistressFragment$onCreateView$3$1(this$0, null), 2);
    }

    @Override // com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter.DistressView
    public void error() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(R.string.distress_unavailable), 0).show();
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter.DistressView
    public void invitationAvailable(String str) {
        InvitationCodeLinkDialogFragment.newInstance(str).show(getChildFragmentManager(), FRAGMENT_TAG_CODE_LINK_DIALOG);
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DistressPresenter.Companion companion = DistressPresenter.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.presenter = companion.getInstance(requireContext);
        this.permissionHelper = PermissionCompat.create(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_details_distress, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.not_started);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.stateNotStartedView = findViewById;
        View findViewById2 = inflate.findViewById(R.id.wait_for_reply);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.stateWaitingForReplyView = findViewById2;
        int r2 = 1;
        inflate.findViewById(R.id.cancel_invitation_btn).setOnClickListener(new SettingsFragment$$ExternalSyntheticLambda7(this, r2));
        View findViewById3 = inflate.findViewById(R.id.invite_safety_contact_btn);
        Button button = (Button) findViewById3;
        button.setOnClickListener(new DistressFragment$$ExternalSyntheticLambda0(button, this, 0));
        Intrinsics.checkNotNullExpressionValue(findViewById3, "also(...)");
        this.inviteSafetyContactButton = (Button) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.avatar_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.avatarText = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.observer);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.observerView = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.observer_name);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.observerNameView = (TextView) findViewById6;
        ((Button) inflate.findViewById(R.id.remove_btn)).setOnClickListener(new SettingsFragment$$ExternalSyntheticLambda9(this, r2));
        View findViewById7 = inflate.findViewById(R.id.setup_progressbar);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.setupProgressBar = (ProgressBar) findViewById7;
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        DistressPresenter distressPresenter = this.presenter;
        if (distressPresenter != null) {
            distressPresenter.pause();
            super.onPause();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DistressPresenter distressPresenter = this.presenter;
        if (distressPresenter != null) {
            distressPresenter.resume(this, this.permissionHelper, getSlot());
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (getHasQuickAction()) {
            ((MorseCodeView) view.findViewById(R.id.emergency_morse_code)).setPattern("..");
            return;
        }
        MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
        miniOnboardingPagerAdapter.setData(CollectionsKt__CollectionsKt.listOf(DetailLottiePage.newInstance(selectAnimation(LottieFile.DvWmhTop, LottieFile.DvWmhBottom), R.string.distress_animation_description)));
        getLottieViewPager().setAdapter(miniOnboardingPagerAdapter);
    }

    @Override // com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter.DistressView
    public void requestLocationPermission() {
        this.permissionLauncher.launch("android.permission.ACCESS_COARSE_LOCATION");
    }

    @Override // com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter.DistressView
    public void setState(DistressPresenter.State state) {
        int r9;
        View view = this.stateNotStartedView;
        if (view != null) {
            view.setVisibility(4);
            View view2 = this.observerView;
            if (view2 != null) {
                view2.setVisibility(4);
                ProgressBar progressBar = this.setupProgressBar;
                if (progressBar != null) {
                    progressBar.setVisibility(4);
                    View view3 = this.stateWaitingForReplyView;
                    if (view3 != null) {
                        view3.setVisibility(4);
                        if (state == null) {
                            r9 = -1;
                        } else {
                            r9 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                        }
                        if (r9 != -1) {
                            if (r9 != 1) {
                                if (r9 != 2) {
                                    if (r9 != 3) {
                                        if (r9 == 4) {
                                            View view4 = this.stateWaitingForReplyView;
                                            if (view4 != null) {
                                                view4.setVisibility(0);
                                                return;
                                            } else {
                                                Intrinsics.throwUninitializedPropertyAccessException("stateWaitingForReplyView");
                                                throw null;
                                            }
                                        }
                                        return;
                                    }
                                    ProgressBar progressBar2 = this.setupProgressBar;
                                    if (progressBar2 != null) {
                                        progressBar2.setVisibility(0);
                                        return;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("setupProgressBar");
                                        throw null;
                                    }
                                }
                                TextView textView = this.avatarText;
                                if (textView != null) {
                                    DistressPresenter distressPresenter = this.presenter;
                                    if (distressPresenter != null) {
                                        textView.setText(distressPresenter.getObserverFirstLetter());
                                        TextView textView2 = this.observerNameView;
                                        if (textView2 != null) {
                                            DistressPresenter distressPresenter2 = this.presenter;
                                            if (distressPresenter2 != null) {
                                                textView2.setText(distressPresenter2.getObserverName());
                                                View view5 = this.observerView;
                                                if (view5 != null) {
                                                    view5.setVisibility(0);
                                                    Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(FRAGMENT_TAG_CODE_LINK_DIALOG);
                                                    if (findFragmentByTag != null && (findFragmentByTag instanceof DialogFragment)) {
                                                        ((DialogFragment) findFragmentByTag).dismiss();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                Intrinsics.throwUninitializedPropertyAccessException("observerView");
                                                throw null;
                                            }
                                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                            throw null;
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException("observerNameView");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("avatarText");
                                throw null;
                            }
                            View view6 = this.stateNotStartedView;
                            if (view6 != null) {
                                view6.setVisibility(0);
                                Button button = this.inviteSafetyContactButton;
                                if (button != null) {
                                    button.setEnabled(true);
                                    return;
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("inviteSafetyContactButton");
                                    throw null;
                                }
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("stateNotStartedView");
                            throw null;
                        }
                        throw new NotImplementedError();
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("stateWaitingForReplyView");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("setupProgressBar");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("observerView");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stateNotStartedView");
        throw null;
    }
}
