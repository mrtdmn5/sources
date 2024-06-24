package com.animaconnected.secondo.screens.helpcenter;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class HelpCenterGuideDialog extends BottomSheetBaseDialogFragment implements HelpCenterStateChangedListener {
    private static final int DIALOG_BODY_STRING_SIZE = 16;
    static final int INITIAL_OVERLAY_FADE_IN_ANIMATION_DURATION = 750;
    static final int OVERLAY_FADE_IN_ANIMATION_DURATION = 200;
    static final int OVERLAY_FADE_OUT_ANIMATION_DURATION = 250;
    private Button mButton;
    private TextView mDescription;
    private TextView mDescriptionNew;
    private ImageView mOverlayImage;
    private ProgressBar mProgressBar;
    private final HelpCenterProvider mProvider = ProviderFactory.getHelpCenterProvider();
    private boolean mSwitchSide;
    private TextView mTitle;
    private TextView mTitleNew;

    /* renamed from: com.animaconnected.secondo.screens.helpcenter.HelpCenterGuideDialog$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState;

        static {
            int[] r0 = new int[HelpCenterProvider.HelpState.values().length];
            $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState = r0;
            try {
                r0[HelpCenterProvider.HelpState.BT_TOGGLE_INSTRUCTIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpCenterProvider.HelpState.BT_TOGGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpCenterProvider.HelpState.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpCenterProvider.HelpState.FAQ_INSTRUCTIONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpCenterProvider.HelpState.FAQ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpCenterProvider.HelpState.BT_TOGGLE_WORKED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void animateOverlayImage(final Integer num) {
        this.mOverlayImage.animate().alpha(0.0f).setDuration(250L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.animaconnected.secondo.screens.helpcenter.HelpCenterGuideDialog$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HelpCenterGuideDialog.this.lambda$animateOverlayImage$1(num);
            }
        }).start();
    }

    private void animateTextViews(final TextView textView, final TextView textView2, final int r12) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.help_center_slide_right_start);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.help_center_slide_right_end);
        textView.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.animaconnected.secondo.screens.helpcenter.HelpCenterGuideDialog.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                textView.setText("");
                textView.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                textView2.setText(r12);
                textView2.startAnimation(loadAnimation2);
                textView2.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private int getHeightOfText(int r4) {
        TextView textView = new TextView(getContext());
        textView.setText(r4);
        textView.setTextSize(0, 16.0f);
        textView.measure(View.MeasureSpec.makeMeasureSpec(Resources.getSystem().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return textView.getMeasuredHeight();
    }

    private int getTallestStringResource(int[] r7) {
        int r3 = r7[0];
        int r1 = 0;
        for (int r4 : r7) {
            int heightOfText = getHeightOfText(r4);
            if (heightOfText > r1) {
                r3 = r4;
                r1 = heightOfText;
            }
        }
        return r3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateOverlayImage$1(Integer num) {
        if (num != null) {
            this.mOverlayImage.setImageResource(num.intValue());
            this.mOverlayImage.animate().alpha(1.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialogView$0(View view) {
        this.mProvider.goToNextState();
    }

    public static HelpCenterGuideDialog newInstance() {
        return new HelpCenterGuideDialog();
    }

    private void updateDialogContent(int r3, int r4, Integer num, Integer num2) {
        if (num == null) {
            this.mButton.setVisibility(8);
        } else {
            this.mButton.setVisibility(0);
            this.mButton.setText(num.intValue());
        }
        if (!this.mSwitchSide) {
            animateTextViews(this.mDescription, this.mDescriptionNew, r4);
            animateTextViews(this.mTitle, this.mTitleNew, r3);
        } else {
            animateTextViews(this.mDescriptionNew, this.mDescription, r4);
            animateTextViews(this.mTitleNew, this.mTitle, r3);
        }
        this.mSwitchSide = !this.mSwitchSide;
        animateOverlayImage(num2);
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog bottomDialog) {
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_help_center, null);
        this.mTitle = (TextView) inflate.findViewById(R.id.help_center_dialog_title);
        this.mTitleNew = (TextView) inflate.findViewById(R.id.help_center_dialog_title_new);
        this.mDescription = (TextView) inflate.findViewById(R.id.help_center_description);
        this.mDescriptionNew = (TextView) inflate.findViewById(R.id.help_center_description_new);
        this.mButton = (Button) inflate.findViewById(R.id.help_center_button);
        this.mOverlayImage = (ImageView) inflate.findViewById(R.id.help_center_image_overlay);
        this.mProgressBar = (ProgressBar) inflate.findViewById(R.id.help_center_progressbar);
        ((TextView) inflate.findViewById(R.id.help_center_description_hidden)).setText(getTallestStringResource(new int[]{R.string.help_center_start_description, R.string.help_center_bt_description, R.string.help_center_bt_failed_description, R.string.help_center_bt_success_description}));
        this.mOverlayImage.animate().alpha(1.0f).setDuration(750L).setInterpolator(new AccelerateInterpolator()).start();
        this.mButton.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.helpcenter.HelpCenterGuideDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelpCenterGuideDialog.this.lambda$onCreateDialogView$0(view);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.mProvider.getCurrentState() != HelpCenterProvider.HelpState.DISCONNECTED && this.mProvider.getCurrentState() != HelpCenterProvider.HelpState.CONNECTED) {
            this.mProvider.onDialogDismissed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mProvider.unregisterHelpCenterListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mProvider.registerHelpCenterListener(this);
        if (this.mProvider.hasUserConnectedInBackground()) {
            dismiss();
        }
    }

    @Override // com.animaconnected.secondo.screens.helpcenter.HelpCenterStateChangedListener
    public void onStateChanged(HelpCenterProvider.HelpState helpState, HelpCenterProvider.HelpState helpState2) {
        Integer valueOf;
        switch (AnonymousClass2.$SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[helpState2.ordinal()]) {
            case 1:
                if (Build.VERSION.SDK_INT >= 33) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(R.string.help_center_bt_button);
                }
                updateDialogContent(R.string.help_center_bt_title, R.string.help_center_bt_description, valueOf, null);
                ((BottomDialog) getDialog()).setDismissible(false);
                return;
            case 2:
                this.mProgressBar.setVisibility(0);
                this.mButton.setEnabled(false);
                this.mOverlayImage.setAlpha(0.0f);
                return;
            case 3:
                this.mProgressBar.setVisibility(4);
                dismiss();
                return;
            case 4:
                updateDialogContent(R.string.help_center_bt_failed_title, R.string.help_center_bt_failed_description, Integer.valueOf(R.string.help_center_bt_failed_button), Integer.valueOf(R.drawable.trouble_assistant_error));
                ((BottomDialog) getDialog()).setDismissible(true);
                this.mButton.setEnabled(true);
                this.mProgressBar.setVisibility(4);
                return;
            case 5:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.faq_help_center_uri))));
                dismiss();
                return;
            case 6:
                updateDialogContent(R.string.help_center_bt_success_title, R.string.help_center_bt_success_description, Integer.valueOf(R.string.help_center_bt_success_button), Integer.valueOf(R.drawable.trouble_assistant_success));
                this.mButton.setEnabled(true);
                this.mProgressBar.setVisibility(4);
                ((BottomDialog) getDialog()).setDismissible(true);
                return;
            default:
                return;
        }
    }
}
