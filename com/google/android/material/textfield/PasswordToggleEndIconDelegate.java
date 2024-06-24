package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import com.kronaby.watch.app.R;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public final class PasswordToggleEndIconDelegate extends EndIconDelegate {
    public final AnonymousClass2 onEditTextAttachedListener;
    public final AnonymousClass3 onEndIconChangedListener;
    public final AnonymousClass1 textWatcher;

    /* renamed from: com.google.android.material.textfield.PasswordToggleEndIconDelegate$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements TextInputLayout.OnEditTextAttachedListener {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public final void onEditTextAttached(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
            passwordToggleEndIconDelegate.endIconView.setChecked(!PasswordToggleEndIconDelegate.access$000(passwordToggleEndIconDelegate));
            AnonymousClass1 anonymousClass1 = passwordToggleEndIconDelegate.textWatcher;
            editText.removeTextChangedListener(anonymousClass1);
            editText.addTextChangedListener(anonymousClass1);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.material.textfield.PasswordToggleEndIconDelegate$1] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.material.textfield.PasswordToggleEndIconDelegate$3] */
    public PasswordToggleEndIconDelegate(TextInputLayout textInputLayout, int r2) {
        super(textInputLayout, r2);
        this.textWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int r22, int r3, int r4) {
                PasswordToggleEndIconDelegate.this.endIconView.setChecked(!PasswordToggleEndIconDelegate.access$000(r1));
            }
        };
        this.onEditTextAttachedListener = new AnonymousClass2();
        this.onEndIconChangedListener = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public final void onEndIconChanged(TextInputLayout textInputLayout2, int r3) {
                final EditText editText = textInputLayout2.getEditText();
                if (editText != null && r3 == 1) {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editText.post(new Runnable() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            editText.removeTextChangedListener(PasswordToggleEndIconDelegate.this.textWatcher);
                        }
                    });
                }
            }
        };
    }

    public static boolean access$000(PasswordToggleEndIconDelegate passwordToggleEndIconDelegate) {
        EditText editText = passwordToggleEndIconDelegate.textInputLayout.getEditText();
        if (editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        int r0 = this.customEndIcon;
        if (r0 == 0) {
            r0 = R.drawable.design_password_eye;
        }
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconDrawable(r0);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        boolean z = true;
        textInputLayout.setEndIconVisible(true);
        textInputLayout.setEndIconCheckable(true);
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordToggleEndIconDelegate passwordToggleEndIconDelegate = PasswordToggleEndIconDelegate.this;
                EditText editText = passwordToggleEndIconDelegate.textInputLayout.getEditText();
                if (editText == null) {
                    return;
                }
                int selectionEnd = editText.getSelectionEnd();
                if (PasswordToggleEndIconDelegate.access$000(passwordToggleEndIconDelegate)) {
                    editText.setTransformationMethod(null);
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                TextInputLayout textInputLayout2 = passwordToggleEndIconDelegate.textInputLayout;
                IconHelper.refreshIconDrawableState(textInputLayout2, textInputLayout2.endIconView, textInputLayout2.endIconTintList);
            }
        });
        LinkedHashSet<TextInputLayout.OnEditTextAttachedListener> linkedHashSet = textInputLayout.editTextAttachedListeners;
        AnonymousClass2 anonymousClass2 = this.onEditTextAttachedListener;
        linkedHashSet.add(anonymousClass2);
        if (textInputLayout.editText != null) {
            anonymousClass2.onEditTextAttached(textInputLayout);
        }
        textInputLayout.endIconChangedListeners.add(this.onEndIconChangedListener);
        EditText editText = textInputLayout.getEditText();
        if (editText == null || (editText.getInputType() != 16 && editText.getInputType() != 128 && editText.getInputType() != 144 && editText.getInputType() != 224)) {
            z = false;
        }
        if (z) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
