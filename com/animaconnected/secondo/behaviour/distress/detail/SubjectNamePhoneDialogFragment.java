package com.animaconnected.secondo.behaviour.distress.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: SubjectNamePhoneDialogFragment.kt */
/* loaded from: classes3.dex */
public final class SubjectNamePhoneDialogFragment extends BottomSheetBaseDialogFragment {
    private Button continueButton;
    private boolean dismissed;
    private DistressPresenter distressPresenter;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SubjectNamePhoneDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubjectNamePhoneDialogFragment newInstance() {
            return new SubjectNamePhoneDialogFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialogView$lambda$1$lambda$0(SubjectNamePhoneDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt.launch$default(Hashing.getLifecycleScope(this$0), null, null, new SubjectNamePhoneDialogFragment$onCreateDialogView$1$1$1(this$0, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshState() {
        Button button = this.continueButton;
        if (button != null) {
            DistressPresenter distressPresenter = this.distressPresenter;
            if (distressPresenter != null) {
                button.setEnabled(distressPresenter.canGetInvitation());
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("distressPresenter");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("continueButton");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        if (!this.dismissed) {
            DistressPresenter distressPresenter = this.distressPresenter;
            if (distressPresenter != null) {
                distressPresenter.cancelInviteSafetyContact();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("distressPresenter");
                throw null;
            }
        }
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        View inflate = View.inflate(getContext(), R.layout.fragment_details_distress_subject_name_phone, null);
        DistressPresenter.Companion companion = DistressPresenter.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.distressPresenter = companion.getInstance(requireContext);
        View findViewById = inflate.findViewById(R.id.continue_btn);
        ((Button) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.behaviour.distress.detail.SubjectNamePhoneDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectNamePhoneDialogFragment.onCreateDialogView$lambda$1$lambda$0(SubjectNamePhoneDialogFragment.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
        this.continueButton = (Button) findViewById;
        EditText editText = (EditText) inflate.findViewById(R.id.name_edit_text);
        DistressPresenter distressPresenter = this.distressPresenter;
        if (distressPresenter != null) {
            editText.setText(distressPresenter.getSubjectName());
            editText.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.behaviour.distress.detail.SubjectNamePhoneDialogFragment$onCreateDialogView$lambda$3$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    DistressPresenter distressPresenter2;
                    distressPresenter2 = SubjectNamePhoneDialogFragment.this.distressPresenter;
                    if (distressPresenter2 != null) {
                        distressPresenter2.setSubjectName(String.valueOf(editable));
                        SubjectNamePhoneDialogFragment.this.refreshState();
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("distressPresenter");
                        throw null;
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }
            });
            EditText editText2 = (EditText) inflate.findViewById(R.id.phone_number_edit_text);
            DistressPresenter distressPresenter2 = this.distressPresenter;
            if (distressPresenter2 != null) {
                editText2.setText(distressPresenter2.getSubjectPhoneNumber());
                editText2.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.behaviour.distress.detail.SubjectNamePhoneDialogFragment$onCreateDialogView$lambda$5$$inlined$addTextChangedListener$default$1
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        DistressPresenter distressPresenter3;
                        distressPresenter3 = SubjectNamePhoneDialogFragment.this.distressPresenter;
                        if (distressPresenter3 != null) {
                            distressPresenter3.setSubjectPhoneNumber(String.valueOf(editable));
                            SubjectNamePhoneDialogFragment.this.refreshState();
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("distressPresenter");
                            throw null;
                        }
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                    }
                });
                return inflate;
            }
            Intrinsics.throwUninitializedPropertyAccessException("distressPresenter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("distressPresenter");
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (!this.dismissed) {
            DistressPresenter distressPresenter = this.distressPresenter;
            if (distressPresenter != null) {
                distressPresenter.cancelInviteSafetyContact();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("distressPresenter");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshState();
    }
}
