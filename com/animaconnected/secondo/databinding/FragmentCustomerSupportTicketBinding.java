package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentCustomerSupportTicketBinding implements ViewBinding {
    public final LinearLayout detailLayout;
    private final LinearLayout rootView;
    public final Button ticketCancel;
    public final EditText ticketDescription;
    public final TextInputEditText ticketEmail;
    public final TextInputLayout ticketEmailLayout;
    public final TextInputEditText ticketLastname;
    public final TextInputLayout ticketLastnameLayout;
    public final TextInputEditText ticketName;
    public final TextInputLayout ticketNameLayout;
    public final Button ticketSend;
    public final Spinner ticketSubjectSpinner;

    private FragmentCustomerSupportTicketBinding(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, EditText editText, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextInputEditText textInputEditText2, TextInputLayout textInputLayout2, TextInputEditText textInputEditText3, TextInputLayout textInputLayout3, Button button2, Spinner spinner) {
        this.rootView = linearLayout;
        this.detailLayout = linearLayout2;
        this.ticketCancel = button;
        this.ticketDescription = editText;
        this.ticketEmail = textInputEditText;
        this.ticketEmailLayout = textInputLayout;
        this.ticketLastname = textInputEditText2;
        this.ticketLastnameLayout = textInputLayout2;
        this.ticketName = textInputEditText3;
        this.ticketNameLayout = textInputLayout3;
        this.ticketSend = button2;
        this.ticketSubjectSpinner = spinner;
    }

    public static FragmentCustomerSupportTicketBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int r0 = R.id.ticket_cancel;
        Button button = (Button) ViewBindings.findChildViewById(R.id.ticket_cancel, view);
        if (button != null) {
            r0 = R.id.ticket_description;
            EditText editText = (EditText) ViewBindings.findChildViewById(R.id.ticket_description, view);
            if (editText != null) {
                r0 = R.id.ticket_email;
                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(R.id.ticket_email, view);
                if (textInputEditText != null) {
                    r0 = R.id.ticket_email_layout;
                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(R.id.ticket_email_layout, view);
                    if (textInputLayout != null) {
                        r0 = R.id.ticket_lastname;
                        TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(R.id.ticket_lastname, view);
                        if (textInputEditText2 != null) {
                            r0 = R.id.ticket_lastname_layout;
                            TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(R.id.ticket_lastname_layout, view);
                            if (textInputLayout2 != null) {
                                r0 = R.id.ticket_name;
                                TextInputEditText textInputEditText3 = (TextInputEditText) ViewBindings.findChildViewById(R.id.ticket_name, view);
                                if (textInputEditText3 != null) {
                                    r0 = R.id.ticket_name_layout;
                                    TextInputLayout textInputLayout3 = (TextInputLayout) ViewBindings.findChildViewById(R.id.ticket_name_layout, view);
                                    if (textInputLayout3 != null) {
                                        r0 = R.id.ticket_send;
                                        Button button2 = (Button) ViewBindings.findChildViewById(R.id.ticket_send, view);
                                        if (button2 != null) {
                                            r0 = R.id.ticket_subject_spinner;
                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(R.id.ticket_subject_spinner, view);
                                            if (spinner != null) {
                                                return new FragmentCustomerSupportTicketBinding(linearLayout, linearLayout, button, editText, textInputEditText, textInputLayout, textInputEditText2, textInputLayout2, textInputEditText3, textInputLayout3, button2, spinner);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentCustomerSupportTicketBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomerSupportTicketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_customer_support_ticket, viewGroup, false);
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
