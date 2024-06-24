package com.animaconnected.secondo.screens.details.bottomdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.details.BottomDialogDetailView;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailBottomDialog.kt */
/* loaded from: classes3.dex */
public final class DetailBottomDialog extends Fragment {
    public static final String keyBadge = "badge";
    public static final String keyButtonText = "buttonText";
    public static final String keyColor = "color";
    public static final String keyDescription = "description";
    public static final String keyTitle = "title";
    private int badge;
    private int buttonText;
    private int color;
    private int description;
    private int title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DetailBottomDialog.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DetailBottomDialog newInstance(int r4, int r5, int r6, int r7, int r8) {
            DetailBottomDialog detailBottomDialog = new DetailBottomDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(DetailBottomDialog.keyColor, r4);
            bundle.putInt(DetailBottomDialog.keyBadge, r5);
            bundle.putInt(DetailBottomDialog.keyTitle, r6);
            bundle.putInt(DetailBottomDialog.keyDescription, r7);
            bundle.putInt(DetailBottomDialog.keyButtonText, r8);
            detailBottomDialog.setArguments(bundle);
            return detailBottomDialog;
        }

        private Companion() {
        }
    }

    public static final DetailBottomDialog newInstance(int r6, int r7, int r8, int r9, int r10) {
        return Companion.newInstance(r6, r7, r8, r9, r10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$lambda$1$lambda$0(DetailBottomDialog this$0, View view) {
        BottomDialogDetailView bottomDialogDetailView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityResultCaller parentFragment = this$0.getParentFragment();
        if (parentFragment instanceof BottomDialogDetailView) {
            bottomDialogDetailView = (BottomDialogDetailView) parentFragment;
        } else {
            bottomDialogDetailView = null;
        }
        if (bottomDialogDetailView != null) {
            bottomDialogDetailView.onBottomDialogClicked();
        }
    }

    public final int getBadge() {
        return this.badge;
    }

    public final int getButtonText() {
        return this.buttonText;
    }

    public final int getColor() {
        return this.color;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public final int getDescription() {
        return this.description;
    }

    public final int getTitle() {
        return this.title;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.color = arguments.getInt(keyColor);
            this.badge = arguments.getInt(keyBadge);
            this.title = arguments.getInt(keyTitle);
            this.description = arguments.getInt(keyDescription);
            this.buttonText = arguments.getInt(keyButtonText);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_detail_bottom_dialog, viewGroup, false);
        inflate.findViewById(R.id.bottom_dialog_stripe).setBackgroundResource(this.color);
        ((ImageView) inflate.findViewById(R.id.bottom_dialog_badge)).setImageResource(this.badge);
        ((TextView) inflate.findViewById(R.id.bottom_dialog_title)).setText(this.title);
        ((TextView) inflate.findViewById(R.id.bottom_dialog_description)).setText(this.description);
        Button button = (Button) inflate.findViewById(R.id.bottom_dialog_button);
        button.setText(this.buttonText);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailBottomDialog.onCreateView$lambda$2$lambda$1$lambda$0(DetailBottomDialog.this, view);
            }
        });
        return inflate;
    }

    public final void setBadge(int r1) {
        this.badge = r1;
    }

    public final void setButtonText(int r1) {
        this.buttonText = r1;
    }

    public final void setColor(int r1) {
        this.color = r1;
    }

    public final void setDescription(int r1) {
        this.description = r1;
    }

    public final void setTitle(int r1) {
        this.title = r1;
    }
}
