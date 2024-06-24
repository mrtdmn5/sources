package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogLabsFeedbackBinding implements ViewBinding {
    public final EditText commentEdit;
    public final TextView labsFeedbackCommentText;
    public final Button labsFeedbackNotNow;
    public final Button labsFeedbackSend;
    public final TextView labsFeedbackTitle;
    private final LinearLayout rootView;

    private DialogLabsFeedbackBinding(LinearLayout linearLayout, EditText editText, TextView textView, Button button, Button button2, TextView textView2) {
        this.rootView = linearLayout;
        this.commentEdit = editText;
        this.labsFeedbackCommentText = textView;
        this.labsFeedbackNotNow = button;
        this.labsFeedbackSend = button2;
        this.labsFeedbackTitle = textView2;
    }

    public static DialogLabsFeedbackBinding bind(View view) {
        int r0 = R.id.comment_edit;
        EditText editText = (EditText) ViewBindings.findChildViewById(R.id.comment_edit, view);
        if (editText != null) {
            r0 = R.id.labs_feedback_comment_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.labs_feedback_comment_text, view);
            if (textView != null) {
                r0 = R.id.labs_feedback_not_now;
                Button button = (Button) ViewBindings.findChildViewById(R.id.labs_feedback_not_now, view);
                if (button != null) {
                    r0 = R.id.labs_feedback_send;
                    Button button2 = (Button) ViewBindings.findChildViewById(R.id.labs_feedback_send, view);
                    if (button2 != null) {
                        r0 = R.id.labs_feedback_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.labs_feedback_title, view);
                        if (textView2 != null) {
                            return new DialogLabsFeedbackBinding((LinearLayout) view, editText, textView, button, button2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogLabsFeedbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogLabsFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_labs_feedback, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
