package com.animaconnected.secondo.screens.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.notification.handler.DisplayNotificationHandler;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.screens.debugsettings.DebugStorage;
import com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment;
import com.animaconnected.secondo.utils.customersupport.CustomerSupportTicketUtils;
import com.animaconnected.watch.device.files.WatchFileSystem;
import com.google.android.material.textfield.TextInputLayout;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: CustomerSupportTicketFragment.kt */
/* loaded from: classes3.dex */
public final class CustomerSupportTicketFragment extends BaseFragment {
    private CustomerSupportTicketUtils customerSupportTicketUtils;
    private EditText descriptionEditText;
    private EditText emailEditText;
    private TextInputLayout emailLayout;
    private EditText lastNameEditText;
    private TextInputLayout lastNameLayout;
    private EditText nameEditText;
    private TextInputLayout nameLayout;
    private SharedPreferences prefs;
    private Button sendButton;
    private Spinner subjectSpinner;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String storageSubjectKey = "ticketSubject";
    private final String storageDescriptionKey = "ticketDescription";
    private final String storageEmailKey = "ticketEmail";
    private final String storageNameKey = "ticketName";
    private final String storageLastNameKey = "ticketLastName";
    private final Lazy subjects$delegate = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends Subject>>() { // from class: com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$subjects$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends CustomerSupportTicketFragment.Subject> invoke() {
            if (ProviderFactory.getWatch().getWatchManager().getCurrentWatch().getHasDisplay()) {
                String string = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_health);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomerSupportTicketFragment.Subject subject = new CustomerSupportTicketFragment.Subject("Health", string);
                String string2 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_apps);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomerSupportTicketFragment.Subject subject2 = new CustomerSupportTicketFragment.Subject("Apps", string2);
                String string3 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_notifications);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomerSupportTicketFragment.Subject subject3 = new CustomerSupportTicketFragment.Subject(DisplayNotificationHandler.TYPE, string3);
                String string4 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_connectivity);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                CustomerSupportTicketFragment.Subject subject4 = new CustomerSupportTicketFragment.Subject("Connectivity", string4);
                String string5 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_battery);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                CustomerSupportTicketFragment.Subject subject5 = new CustomerSupportTicketFragment.Subject("Battery", string5);
                String string6 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_other);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return CollectionsKt__CollectionsKt.listOf((Object[]) new CustomerSupportTicketFragment.Subject[]{subject, subject2, subject3, subject4, subject5, new CustomerSupportTicketFragment.Subject("Other", string6), new CustomerSupportTicketFragment.Subject(null, CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject) + " *")});
            }
            String string7 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_filter_notification);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            CustomerSupportTicketFragment.Subject subject6 = new CustomerSupportTicketFragment.Subject("Filtered notifications", string7);
            String string8 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_watch_face);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            CustomerSupportTicketFragment.Subject subject7 = new CustomerSupportTicketFragment.Subject("Watch face", string8);
            String string9 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_pushers);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            CustomerSupportTicketFragment.Subject subject8 = new CustomerSupportTicketFragment.Subject("Pushers", string9);
            String string10 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_activity);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            CustomerSupportTicketFragment.Subject subject9 = new CustomerSupportTicketFragment.Subject("Activity", string10);
            String string11 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_connectivity);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            CustomerSupportTicketFragment.Subject subject10 = new CustomerSupportTicketFragment.Subject("Connectivity", string11);
            String string12 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_battery);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            CustomerSupportTicketFragment.Subject subject11 = new CustomerSupportTicketFragment.Subject("Battery", string12);
            String string13 = CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject_other);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
            return CollectionsKt__CollectionsKt.listOf((Object[]) new CustomerSupportTicketFragment.Subject[]{subject6, subject7, subject8, subject9, subject10, subject11, new CustomerSupportTicketFragment.Subject("Other", string13), new CustomerSupportTicketFragment.Subject(null, CustomerSupportTicketFragment.this.getString(R.string.contact_support_subject) + " *")});
        }
    });
    private final String name = "CustomerSupportTicket";

    /* compiled from: CustomerSupportTicketFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CustomerSupportTicketFragment newInstance() {
            return new CustomerSupportTicketFragment();
        }

        private Companion() {
        }
    }

    /* compiled from: CustomerSupportTicketFragment.kt */
    /* loaded from: classes3.dex */
    public static final class HintAdapter<T> extends ArrayAdapter<T> {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HintAdapter(Context context, int r3, List<? extends T> objects) {
            super(context, r3, objects);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(objects, "objects");
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            int count = super.getCount();
            if (count > 0) {
                return count - 1;
            }
            return count;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r2, View view, ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view2 = super.getView(r2, view, parent);
            view2.setPadding(0, 0, 0, 0);
            return view2;
        }
    }

    /* compiled from: CustomerSupportTicketFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Subject {
        public static final int $stable = 0;
        private final String supportName;
        private final String value;

        public Subject(String str, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.supportName = str;
            this.value = value;
        }

        public static /* synthetic */ Subject copy$default(Subject subject, String str, String str2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = subject.supportName;
            }
            if ((r3 & 2) != 0) {
                str2 = subject.value;
            }
            return subject.copy(str, str2);
        }

        public final String component1() {
            return this.supportName;
        }

        public final String component2() {
            return this.value;
        }

        public final Subject copy(String str, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Subject(str, value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Subject)) {
                return false;
            }
            Subject subject = (Subject) obj;
            if (Intrinsics.areEqual(this.supportName, subject.supportName) && Intrinsics.areEqual(this.value, subject.value)) {
                return true;
            }
            return false;
        }

        public final String getSupportName() {
            return this.supportName;
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            int hashCode;
            String str = this.supportName;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return this.value.hashCode() + (hashCode * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Subject(supportName=");
            sb.append(this.supportName);
            sb.append(", value=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.value, ')');
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Subject> getSubjects() {
        return (List) this.subjects$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidEmail(Editable editable) {
        if ((!StringsKt__StringsJVMKt.isBlank(editable)) && Patterns.EMAIL_ADDRESS.matcher(StringsKt__StringsKt.trim(editable)).matches()) {
            return true;
        }
        return false;
    }

    private final void showDiscardDialog() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.showBottomDialog(requireContext, R.layout.dialog_ticket_discard, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$showDiscardDialog$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                EditText editText;
                SharedPreferences sharedPreferences;
                String str;
                List subjects;
                Spinner spinner;
                String str2;
                EditText editText2;
                String str3;
                EditText editText3;
                String str4;
                EditText editText4;
                String str5;
                EditText editText5;
                if (z) {
                    sharedPreferences = CustomerSupportTicketFragment.this.prefs;
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        str = CustomerSupportTicketFragment.this.storageSubjectKey;
                        subjects = CustomerSupportTicketFragment.this.getSubjects();
                        spinner = CustomerSupportTicketFragment.this.subjectSpinner;
                        if (spinner != null) {
                            SharedPreferences.Editor putString = edit.putString(str, ((CustomerSupportTicketFragment.Subject) subjects.get(spinner.getSelectedItemPosition())).getSupportName());
                            str2 = CustomerSupportTicketFragment.this.storageDescriptionKey;
                            editText2 = CustomerSupportTicketFragment.this.descriptionEditText;
                            if (editText2 != null) {
                                SharedPreferences.Editor putString2 = putString.putString(str2, editText2.getText().toString());
                                str3 = CustomerSupportTicketFragment.this.storageNameKey;
                                editText3 = CustomerSupportTicketFragment.this.nameEditText;
                                if (editText3 != null) {
                                    SharedPreferences.Editor putString3 = putString2.putString(str3, editText3.getText().toString());
                                    str4 = CustomerSupportTicketFragment.this.storageLastNameKey;
                                    editText4 = CustomerSupportTicketFragment.this.lastNameEditText;
                                    if (editText4 != null) {
                                        SharedPreferences.Editor putString4 = putString3.putString(str4, editText4.getText().toString());
                                        str5 = CustomerSupportTicketFragment.this.storageEmailKey;
                                        editText5 = CustomerSupportTicketFragment.this.emailEditText;
                                        if (editText5 != null) {
                                            putString4.putString(str5, editText5.getText().toString()).apply();
                                        } else {
                                            Intrinsics.throwUninitializedPropertyAccessException("emailEditText");
                                            throw null;
                                        }
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("lastNameEditText");
                                        throw null;
                                    }
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("nameEditText");
                                    throw null;
                                }
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("descriptionEditText");
                                throw null;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("subjectSpinner");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException(WatchFileSystem.prefFilePrefix);
                        throw null;
                    }
                }
                editText = CustomerSupportTicketFragment.this.descriptionEditText;
                if (editText != null) {
                    editText.setText((CharSequence) null);
                    CustomerSupportTicketFragment.this.getMainController().goBack();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("descriptionEditText");
                    throw null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:            if (r2.get(r3.getSelectedItemPosition()).getSupportName() != null) goto L34;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateSendButton() {
        /*
            r5 = this;
            android.widget.Button r0 = r5.sendButton
            r1 = 0
            if (r0 == 0) goto L8b
            android.widget.EditText r2 = r5.descriptionEditText
            if (r2 == 0) goto L85
            android.text.Editable r2 = r2.getText()
            java.lang.String r3 = "getText(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)
            r4 = 1
            r2 = r2 ^ r4
            if (r2 == 0) goto L80
            android.widget.EditText r2 = r5.emailEditText
            if (r2 == 0) goto L7a
            android.text.Editable r2 = r2.getText()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r2 = r5.isValidEmail(r2)
            if (r2 == 0) goto L80
            android.widget.EditText r2 = r5.nameEditText
            if (r2 == 0) goto L74
            android.text.Editable r2 = r2.getText()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)
            r2 = r2 ^ r4
            if (r2 == 0) goto L80
            android.widget.EditText r2 = r5.lastNameEditText
            if (r2 == 0) goto L6e
            android.text.Editable r2 = r2.getText()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r2)
            r2 = r2 ^ r4
            if (r2 == 0) goto L80
            java.util.List r2 = r5.getSubjects()
            android.widget.Spinner r3 = r5.subjectSpinner
            if (r3 == 0) goto L68
            int r1 = r3.getSelectedItemPosition()
            java.lang.Object r1 = r2.get(r1)
            com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$Subject r1 = (com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment.Subject) r1
            java.lang.String r1 = r1.getSupportName()
            if (r1 == 0) goto L80
            goto L81
        L68:
            java.lang.String r0 = "subjectSpinner"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r1
        L6e:
            java.lang.String r0 = "lastNameEditText"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r1
        L74:
            java.lang.String r0 = "nameEditText"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r1
        L7a:
            java.lang.String r0 = "emailEditText"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r1
        L80:
            r4 = 0
        L81:
            r0.setEnabled(r4)
            return
        L85:
            java.lang.String r0 = "descriptionEditText"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r1
        L8b:
            java.lang.String r0 = "sendButton"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment.updateSendButton():void");
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean onBack() {
        EditText editText = this.descriptionEditText;
        if (editText != null) {
            Intrinsics.checkNotNullExpressionValue(editText.getText(), "getText(...)");
            if (!(!StringsKt__StringsJVMKt.isBlank(r0))) {
                return true;
            }
            showDiscardDialog();
            return false;
        }
        Intrinsics.throwUninitializedPropertyAccessException("descriptionEditText");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int r0 = 0;
        View inflate = inflater.inflate(R.layout.fragment_customer_support_ticket, viewGroup, false);
        SharedPreferences sharedPreferences = inflate.getContext().getSharedPreferences("CustomerSupportTicket", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
        RemoteConfigController.Companion companion = RemoteConfigController.Companion;
        Context context = inflate.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        RemoteConfigController companion2 = companion.getInstance(context);
        DebugStorage debugStorage = DebugStorage.INSTANCE;
        Context context2 = inflate.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.customerSupportTicketUtils = new CustomerSupportTicketUtils(companion2, debugStorage.getCustomerSupportDevEnvironment(context2));
        View findViewById = inflate.findViewById(R.id.ticket_description);
        EditText editText = (EditText) findViewById;
        SharedPreferences sharedPreferences2 = this.prefs;
        if (sharedPreferences2 != null) {
            editText.setText(sharedPreferences2.getString(this.storageDescriptionKey, null));
            editText.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$onCreateView$1$1$1
                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                    CustomerSupportTicketFragment.this.updateSendButton();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }
            });
            Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
            this.descriptionEditText = (EditText) findViewById;
            View findViewById2 = inflate.findViewById(R.id.ticket_email_layout);
            String string = getString(R.string.contact_support_email_hint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = string.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            ((TextInputLayout) findViewById2).setHint(upperCase.concat(" *"));
            Intrinsics.checkNotNullExpressionValue(findViewById2, "apply(...)");
            this.emailLayout = (TextInputLayout) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.ticket_email);
            EditText editText2 = (EditText) findViewById3;
            SharedPreferences sharedPreferences3 = this.prefs;
            if (sharedPreferences3 != null) {
                editText2.setText(sharedPreferences3.getString(this.storageEmailKey, null));
                editText2.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$onCreateView$1$3$1
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        TextInputLayout textInputLayout;
                        EditText editText3;
                        boolean isValidEmail;
                        CustomerSupportTicketFragment.this.updateSendButton();
                        textInputLayout = CustomerSupportTicketFragment.this.emailLayout;
                        String str = null;
                        if (textInputLayout != null) {
                            CustomerSupportTicketFragment customerSupportTicketFragment = CustomerSupportTicketFragment.this;
                            editText3 = customerSupportTicketFragment.emailEditText;
                            if (editText3 != null) {
                                Editable text = editText3.getText();
                                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                                isValidEmail = customerSupportTicketFragment.isValidEmail(text);
                                if (!isValidEmail) {
                                    str = CustomerSupportTicketFragment.this.getString(R.string.onboarding_signin_email_input_error);
                                }
                                textInputLayout.setError(str);
                                return;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("emailEditText");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("emailLayout");
                        throw null;
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                    }
                });
                Intrinsics.checkNotNullExpressionValue(findViewById3, "apply(...)");
                this.emailEditText = (EditText) findViewById3;
                View findViewById4 = inflate.findViewById(R.id.ticket_name_layout);
                String string2 = getString(R.string.CreateAccount_NamePlaceholder);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                String upperCase2 = string2.toUpperCase(locale2);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                ((TextInputLayout) findViewById4).setHint(upperCase2.concat(" *"));
                Intrinsics.checkNotNullExpressionValue(findViewById4, "apply(...)");
                this.nameLayout = (TextInputLayout) findViewById4;
                View findViewById5 = inflate.findViewById(R.id.ticket_name);
                EditText editText3 = (EditText) findViewById5;
                SharedPreferences sharedPreferences4 = this.prefs;
                if (sharedPreferences4 != null) {
                    editText3.setText(sharedPreferences4.getString(this.storageNameKey, null));
                    editText3.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$onCreateView$1$5$1
                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            TextInputLayout textInputLayout;
                            EditText editText4;
                            CustomerSupportTicketFragment.this.updateSendButton();
                            textInputLayout = CustomerSupportTicketFragment.this.nameLayout;
                            String str = null;
                            if (textInputLayout != null) {
                                editText4 = CustomerSupportTicketFragment.this.nameEditText;
                                if (editText4 != null) {
                                    Intrinsics.checkNotNullExpressionValue(editText4.getText(), "getText(...)");
                                    if (!(!StringsKt__StringsJVMKt.isBlank(r1))) {
                                        str = CustomerSupportTicketFragment.this.getString(R.string.Validation_NameEmpty);
                                    }
                                    textInputLayout.setError(str);
                                    return;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("nameEditText");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("nameLayout");
                            throw null;
                        }

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(findViewById5, "apply(...)");
                    this.nameEditText = (EditText) findViewById5;
                    View findViewById6 = inflate.findViewById(R.id.ticket_lastname_layout);
                    String string3 = getString(R.string.CreateAccount_LastNamePlaceholder);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    Locale locale3 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
                    String upperCase3 = string3.toUpperCase(locale3);
                    Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                    ((TextInputLayout) findViewById6).setHint(upperCase3.concat(" *"));
                    Intrinsics.checkNotNullExpressionValue(findViewById6, "apply(...)");
                    this.lastNameLayout = (TextInputLayout) findViewById6;
                    View findViewById7 = inflate.findViewById(R.id.ticket_lastname);
                    EditText editText4 = (EditText) findViewById7;
                    SharedPreferences sharedPreferences5 = this.prefs;
                    if (sharedPreferences5 != null) {
                        editText4.setText(sharedPreferences5.getString(this.storageLastNameKey, null));
                        editText4.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$onCreateView$1$7$1
                            @Override // android.text.TextWatcher
                            public void afterTextChanged(Editable editable) {
                                TextInputLayout textInputLayout;
                                EditText editText5;
                                CustomerSupportTicketFragment.this.updateSendButton();
                                textInputLayout = CustomerSupportTicketFragment.this.lastNameLayout;
                                String str = null;
                                if (textInputLayout != null) {
                                    editText5 = CustomerSupportTicketFragment.this.lastNameEditText;
                                    if (editText5 != null) {
                                        Intrinsics.checkNotNullExpressionValue(editText5.getText(), "getText(...)");
                                        if (!(!StringsKt__StringsJVMKt.isBlank(r1))) {
                                            str = CustomerSupportTicketFragment.this.getString(R.string.Validation_LastNameEmpty);
                                        }
                                        textInputLayout.setError(str);
                                        return;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("lastNameEditText");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("lastNameLayout");
                                throw null;
                            }

                            @Override // android.text.TextWatcher
                            public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                            }

                            @Override // android.text.TextWatcher
                            public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(findViewById7, "apply(...)");
                        this.lastNameEditText = (EditText) findViewById7;
                        View findViewById8 = inflate.findViewById(R.id.ticket_subject_spinner);
                        Spinner spinner = (Spinner) findViewById8;
                        Context context3 = spinner.getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                        List<Subject> subjects = getSubjects();
                        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(subjects, 10));
                        Iterator<T> it = subjects.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Subject) it.next()).getValue());
                        }
                        HintAdapter hintAdapter = new HintAdapter(context3, R.layout.item_spinner_settings, arrayList);
                        hintAdapter.setDropDownViewResource(R.layout.item_spinner_drop_down_settings);
                        spinner.setAdapter((SpinnerAdapter) hintAdapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.animaconnected.secondo.screens.settings.CustomerSupportTicketFragment$onCreateView$1$8$3
                            @Override // android.widget.AdapterView.OnItemSelectedListener
                            public void onItemSelected(AdapterView<?> adapterView, View view, int r3, long j) {
                                CustomerSupportTicketFragment.this.updateSendButton();
                            }

                            @Override // android.widget.AdapterView.OnItemSelectedListener
                            public void onNothingSelected(AdapterView<?> adapterView) {
                            }
                        });
                        SharedPreferences sharedPreferences6 = this.prefs;
                        if (sharedPreferences6 != null) {
                            String string4 = sharedPreferences6.getString(this.storageSubjectKey, null);
                            Iterator<Subject> it2 = getSubjects().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (Intrinsics.areEqual(string4, it2.next().getSupportName())) {
                                        break;
                                    }
                                    r0++;
                                } else {
                                    r0 = -1;
                                    break;
                                }
                            }
                            if (r0 == -1) {
                                r0 = getSubjects().size();
                            }
                            spinner.setSelection(r0);
                            Intrinsics.checkNotNullExpressionValue(findViewById8, "apply(...)");
                            this.subjectSpinner = (Spinner) findViewById8;
                            View findViewById9 = inflate.findViewById(R.id.ticket_send);
                            Button button = (Button) findViewById9;
                            Intrinsics.checkNotNull(button);
                            onClick(button, new CustomerSupportTicketFragment$onCreateView$1$9$1(this, button, null));
                            Intrinsics.checkNotNullExpressionValue(findViewById9, "apply(...)");
                            this.sendButton = (Button) findViewById9;
                            updateSendButton();
                            View findViewById10 = inflate.findViewById(R.id.ticket_cancel);
                            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
                            onClick(findViewById10, new CustomerSupportTicketFragment$onCreateView$1$10(this, null));
                            SharedPreferences sharedPreferences7 = this.prefs;
                            if (sharedPreferences7 != null) {
                                sharedPreferences7.edit().putString(this.storageSubjectKey, null).putString(this.storageDescriptionKey, null).putString(this.storageNameKey, null).putString(this.storageLastNameKey, null).putString(this.storageEmailKey, null).apply();
                                return inflate;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException(WatchFileSystem.prefFilePrefix);
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException(WatchFileSystem.prefFilePrefix);
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException(WatchFileSystem.prefFilePrefix);
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException(WatchFileSystem.prefFilePrefix);
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException(WatchFileSystem.prefFilePrefix);
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException(WatchFileSystem.prefFilePrefix);
        throw null;
    }
}
