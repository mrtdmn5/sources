package com.animaconnected.secondo.screens;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.labs.LabsProvider;
import com.animaconnected.secondo.screens.FeedbackView;
import com.kronaby.watch.app.R;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedbackView.kt */
/* loaded from: classes3.dex */
public final class FeedbackView extends LinearLayout {
    public static final int $stable = 8;
    private String analyticsName;
    private final LabsProvider labsProvider;
    private String mailSubjectName;
    private final ImageView negativeButton;
    private final ImageView positiveButton;

    /* compiled from: FeedbackView.kt */
    /* loaded from: classes3.dex */
    public static final class FeedbackCommentDialog extends BottomSheetBaseDialogFragment {
        public static final String keyBundleGeneralFeedback = "general-feedback";
        public static final String keyBundleHasRating = "has-rating";
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private Function1<? super String, Unit> listener = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.FeedbackView$FeedbackCommentDialog$listener$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        };
        private String comment = "";

        /* compiled from: FeedbackView.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ FeedbackCommentDialog newInstance$default(Companion companion, boolean z, boolean z2, int r3, Object obj) {
                if ((r3 & 2) != 0) {
                    z2 = false;
                }
                return companion.newInstance(z, z2);
            }

            public final FeedbackCommentDialog newInstance(boolean z, boolean z2) {
                FeedbackCommentDialog feedbackCommentDialog = new FeedbackCommentDialog();
                Bundle bundle = new Bundle();
                bundle.putBoolean(FeedbackCommentDialog.keyBundleHasRating, z);
                bundle.putBoolean(FeedbackCommentDialog.keyBundleGeneralFeedback, z2);
                feedbackCommentDialog.setArguments(bundle);
                return feedbackCommentDialog;
            }

            private Companion() {
            }
        }

        public static final void onCreateDialogView$lambda$0(FeedbackCommentDialog this$0, EditText editText, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.comment = editText.getText().toString();
            this$0.dismiss();
        }

        public static final void onCreateDialogView$lambda$1(FeedbackCommentDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.dismiss();
        }

        @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
        public CreationExtras getDefaultViewModelCreationExtras() {
            return CreationExtras.Empty.INSTANCE;
        }

        public final Function1<String, Unit> getListener() {
            return this.listener;
        }

        @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
        public View onCreateDialogView(BottomDialog dialog) {
            boolean z;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            View inflate = View.inflate(getContext(), R.layout.dialog_labs_feedback, null);
            final EditText editText = (EditText) inflate.findViewById(R.id.comment_edit);
            final View findViewById = inflate.findViewById(R.id.labs_feedback_send);
            Button button = (Button) inflate.findViewById(R.id.labs_feedback_not_now);
            TextView textView = (TextView) inflate.findViewById(R.id.labs_feedback_comment_text);
            Bundle arguments = getArguments();
            boolean z2 = true;
            if (arguments != null && arguments.getBoolean(keyBundleHasRating)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                textView.setText(getString(R.string.labs_feedback_dialog_another_comment));
                editText.setHint(getString(R.string.labs_feedback_dialog_another_comment_hint));
            }
            Bundle arguments2 = getArguments();
            if (arguments2 == null || !arguments2.getBoolean(keyBundleGeneralFeedback)) {
                z2 = false;
            }
            if (z2) {
                ((TextView) inflate.findViewById(R.id.labs_feedback_title)).setText(getString(R.string.labs_feedback));
                textView.setText(getString(R.string.labs_feedback_dialog_labs_comment));
                button.setText(getString(R.string.labs_feedback_dialog_btn_cancel));
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.FeedbackView$FeedbackCommentDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedbackView.FeedbackCommentDialog.onCreateDialogView$lambda$0(FeedbackView.FeedbackCommentDialog.this, editText, view);
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.FeedbackView$FeedbackCommentDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedbackView.FeedbackCommentDialog.onCreateDialogView$lambda$1(FeedbackView.FeedbackCommentDialog.this, view);
                }
            });
            Intrinsics.checkNotNull(editText);
            editText.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.screens.FeedbackView$FeedbackCommentDialog$onCreateDialogView$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    View view = findViewById;
                    boolean z3 = false;
                    if (editable != null && editable.length() > 0) {
                        z3 = true;
                    }
                    view.setEnabled(z3);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }
            });
            dialog.setDismissible(false);
            return inflate;
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            super.onDismiss(dialog);
            this.listener.invoke(this.comment);
        }

        public final void setListener(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.listener = function1;
        }
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public FeedbackView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void _init_$lambda$1(FeedbackView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onThumbClicked(1);
    }

    public static final void _init_$lambda$2(FeedbackView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onThumbClicked(-1);
    }

    public static final void lambda$5$lambda$4(final FeedbackView this$0, final Context context, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        ProviderFactory.getWatch().getDeviceInformation().success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.FeedbackView$$ExternalSyntheticLambda3
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                FeedbackView.lambda$5$lambda$4$lambda$3(FeedbackView.this, context, (Map) obj);
            }
        });
    }

    public static final void lambda$5$lambda$4$lambda$3(FeedbackView this$0, Context context, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.labsProvider.showGiveFeedbackMail(context, map, context.getString(R.string.labs_feedback_subject, this$0.mailSubjectName));
    }

    private final void onThumbClicked(final int r8) {
        if (this.labsProvider.getRating(this.analyticsName) == r8) {
            LabsProvider.setRating$default(this.labsProvider, this.analyticsName, 0, null, 4, null);
            updateThumbImages();
            return;
        }
        final FeedbackCommentDialog newInstance$default = FeedbackCommentDialog.Companion.newInstance$default(FeedbackCommentDialog.Companion, this.labsProvider.hasRating(this.analyticsName), false, 2, null);
        newInstance$default.setListener(new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.FeedbackView$onThumbClicked$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String comment) {
                LabsProvider labsProvider;
                Intrinsics.checkNotNullParameter(comment, "comment");
                LogKt.debug$default((Object) FeedbackView.FeedbackCommentDialog.this, "Dialog comment: ".concat(comment), (String) null, (Throwable) null, false, 14, (Object) null);
                labsProvider = this.labsProvider;
                labsProvider.setRating(this.getAnalyticsName(), r8, comment);
                this.updateThumbImages();
            }
        });
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        newInstance$default.show(((FragmentActivity) context).getSupportFragmentManager(), (String) null);
    }

    public final void updateThumbImages() {
        int r2;
        int r0;
        int rating = this.labsProvider.getRating(this.analyticsName);
        ImageView imageView = this.positiveButton;
        if (rating == 1) {
            r2 = R.drawable.thumbs_up_selected;
        } else {
            r2 = R.drawable.thumbs_up_not_selected;
        }
        imageView.setImageResource(r2);
        ImageView imageView2 = this.negativeButton;
        if (rating == -1) {
            r0 = R.drawable.thumbs_down_selected;
        } else {
            r0 = R.drawable.thumbs_down_not_selected;
        }
        imageView2.setImageResource(r0);
    }

    public final String getAnalyticsName() {
        return this.analyticsName;
    }

    public final String getMailSubjectName() {
        return this.mailSubjectName;
    }

    public final void setAnalyticsName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.analyticsName = value;
        updateThumbImages();
    }

    public final void setMailSubjectName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mailSubjectName = str;
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public FeedbackView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FeedbackView(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackView(final Context context, AttributeSet attributeSet, int r6) {
        super(context, attributeSet, r6);
        Intrinsics.checkNotNullParameter(context, "context");
        this.labsProvider = ProviderFactory.getLabsProvider();
        this.mailSubjectName = "None";
        this.analyticsName = "None";
        String string = context.getTheme().obtainStyledAttributes(attributeSet, com.animaconnected.secondo.R.styleable.FeedbackView, 0, 0).getString(0);
        this.mailSubjectName = string != null ? string : "None";
        View.inflate(context, R.layout.feedback_view, this);
        View findViewById = findViewById(R.id.labs_feedback_btn_positive);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById;
        this.positiveButton = imageView;
        View findViewById2 = findViewById(R.id.labs_feedback_btn_negative);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        ImageView imageView2 = (ImageView) findViewById2;
        this.negativeButton = imageView2;
        if (getResources().getBoolean(R.bool.app_feature_aws_feedback_system)) {
            findViewById(R.id.labs_feedback_view).setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.FeedbackView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedbackView._init_$lambda$1(FeedbackView.this, view);
                }
            });
            imageView2.setOnClickListener(new FeedbackView$$ExternalSyntheticLambda1(0, this));
            updateThumbImages();
            return;
        }
        Button button = (Button) findViewById(R.id.labs_feedback_btn);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.FeedbackView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackView.lambda$5$lambda$4(FeedbackView.this, context, view);
            }
        });
        button.setVisibility(0);
    }
}
