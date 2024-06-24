package com.animaconnected.secondo.screens.notification;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.notification.model.Contact;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.screens.notification.ContactPresenter;
import com.kronaby.watch.app.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactFragment.kt */
/* loaded from: classes3.dex */
public final class ContactFragment extends NotificationDetailsFragment implements ContactPresenter.ContactView {
    private static final String FRAGMENT_CONTACT_ID = "contactId";
    private SwitchWrapper callsSwitch;
    private boolean emailAvailable;
    private SwitchWrapper emailSwitch;
    private Contact mContact;
    private SwitchWrapper messageSwitch;
    private TextView nameTextView;
    private boolean phoneNbrAvailable;
    private ContactPresenter presenter;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "ContactFragment";

    /* compiled from: ContactFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ContactFragment newInstance(int r10, int r11, int r12, int r13, int r14, boolean z, int r16) {
            ContactFragment contactFragment = new ContactFragment();
            NotificationDetailsFragment.Companion.setArguments(contactFragment, r10, r11, r12, r13, r14, z);
            Bundle arguments = contactFragment.getArguments();
            if (arguments != null) {
                arguments.putInt(ContactFragment.FRAGMENT_CONTACT_ID, r16);
            }
            return contactFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(ContactFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ContactPresenter contactPresenter = this$0.presenter;
        if (contactPresenter != null) {
            contactPresenter.onRemoveButtonClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(ContactFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ContactPresenter contactPresenter = this$0.presenter;
        if (contactPresenter != null) {
            contactPresenter.onCallSwitched(z);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(ContactFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.phoneNbrAvailable) {
            SwitchWrapper switchWrapper = this$0.callsSwitch;
            if (switchWrapper != null) {
                if (switchWrapper != null) {
                    switchWrapper.setChecked(!switchWrapper.isChecked());
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("callsSwitch");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("callsSwitch");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3(ContactFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ContactPresenter contactPresenter = this$0.presenter;
        if (contactPresenter != null) {
            contactPresenter.onMessageSwitched(z);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4(ContactFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.phoneNbrAvailable) {
            SwitchWrapper switchWrapper = this$0.messageSwitch;
            if (switchWrapper != null) {
                if (switchWrapper != null) {
                    switchWrapper.setChecked(!switchWrapper.isChecked());
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("messageSwitch");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("messageSwitch");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5(ContactFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ContactPresenter contactPresenter = this$0.presenter;
        if (contactPresenter != null) {
            contactPresenter.onEmailSwitched(z);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6(ContactFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.emailAvailable) {
            SwitchWrapper switchWrapper = this$0.emailSwitch;
            if (switchWrapper != null) {
                if (switchWrapper != null) {
                    switchWrapper.setChecked(!switchWrapper.isChecked());
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("emailSwitch");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("emailSwitch");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "Contact";
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments(...)");
        int r5 = requireArguments.getInt(FRAGMENT_CONTACT_ID, 0);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.presenter = new ContactPresenter(requireContext, this, getMainController(), null);
        ProviderFactory.getNotificationProvider().getContactFromConfigurationItemId(r5, new NotificationProvider.Callback<Contact>() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$onCreate$1
            @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
            public void onFail(final Throwable error) {
                String str;
                Intrinsics.checkNotNullParameter(error, "error");
                str = ContactFragment.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LogKt.err$default((Object) this, str, error, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$onCreate$1$onFail$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Can't load contact: " + error;
                    }
                }, 4, (Object) null);
                FragmentManager parentFragmentManager = ContactFragment.this.getParentFragmentManager();
                parentFragmentManager.getClass();
                parentFragmentManager.enqueueAction(new FragmentManager.PopBackStackState(null, -1, 0), false);
            }

            @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
            public void onSuccess(Contact contact) {
                ContactPresenter contactPresenter;
                ContactPresenter contactPresenter2;
                String str;
                if (contact == null) {
                    str = ContactFragment.TAG;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                    LogKt.err$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$onCreate$1$onSuccess$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Can't find contact";
                        }
                    }, 6, (Object) null);
                    FragmentManager parentFragmentManager = ContactFragment.this.getParentFragmentManager();
                    parentFragmentManager.getClass();
                    parentFragmentManager.enqueueAction(new FragmentManager.PopBackStackState(null, -1, 0), false);
                    return;
                }
                contactPresenter = ContactFragment.this.presenter;
                if (contactPresenter != null) {
                    contactPresenter.setContact$secondo_kronabyRelease(contact);
                    ContactFragment.this.setContact(contact);
                    ContactFragment.this.updateContact(contact);
                    contactPresenter2 = ContactFragment.this.presenter;
                    if (contactPresenter2 != null) {
                        contactPresenter2.onResume();
                        return;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        throw null;
                    }
                }
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
                throw null;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_notification_contact, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.name_text_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.nameTextView = (TextView) findViewById;
        ((Button) inflate.findViewById(R.id.remove)).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactFragment.onCreateView$lambda$0(ContactFragment.this, view);
            }
        });
        View findViewById2 = inflate.findViewById(R.id.calls);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        SwitchWrapper switchWrapper = (SwitchWrapper) findViewById2;
        this.callsSwitch = switchWrapper;
        switchWrapper.setTitle(inflate.getContext().getString(R.string.nft_calls));
        SwitchWrapper switchWrapper2 = this.callsSwitch;
        if (switchWrapper2 != null) {
            switchWrapper2.setSwitchListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ContactFragment.onCreateView$lambda$1(ContactFragment.this, compoundButton, z);
                }
            });
            SwitchWrapper switchWrapper3 = this.callsSwitch;
            if (switchWrapper3 != null) {
                switchWrapper3.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContactFragment.onCreateView$lambda$2(ContactFragment.this, view);
                    }
                });
                View findViewById3 = inflate.findViewById(R.id.messages);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                SwitchWrapper switchWrapper4 = (SwitchWrapper) findViewById3;
                this.messageSwitch = switchWrapper4;
                switchWrapper4.setTitle(inflate.getContext().getString(R.string.nft_messages));
                SwitchWrapper switchWrapper5 = this.messageSwitch;
                if (switchWrapper5 != null) {
                    switchWrapper5.setSwitchListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$$ExternalSyntheticLambda3
                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            ContactFragment.onCreateView$lambda$3(ContactFragment.this, compoundButton, z);
                        }
                    });
                    SwitchWrapper switchWrapper6 = this.messageSwitch;
                    if (switchWrapper6 != null) {
                        switchWrapper6.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$$ExternalSyntheticLambda4
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ContactFragment.onCreateView$lambda$4(ContactFragment.this, view);
                            }
                        });
                        View findViewById4 = inflate.findViewById(R.id.emails);
                        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
                        SwitchWrapper switchWrapper7 = (SwitchWrapper) findViewById4;
                        this.emailSwitch = switchWrapper7;
                        switchWrapper7.setTitle(inflate.getContext().getString(R.string.nft_emails));
                        Contact contact = this.mContact;
                        if (contact != null) {
                            updateContact(contact);
                        }
                        SwitchWrapper switchWrapper8 = this.emailSwitch;
                        if (switchWrapper8 != null) {
                            switchWrapper8.setSwitchListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$$ExternalSyntheticLambda5
                                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                    ContactFragment.onCreateView$lambda$5(ContactFragment.this, compoundButton, z);
                                }
                            });
                            SwitchWrapper switchWrapper9 = this.emailSwitch;
                            if (switchWrapper9 != null) {
                                switchWrapper9.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.notification.ContactFragment$$ExternalSyntheticLambda6
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        ContactFragment.onCreateView$lambda$6(ContactFragment.this, view);
                                    }
                                });
                                initView(inflate);
                                return inflate;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("emailSwitch");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("emailSwitch");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("messageSwitch");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("messageSwitch");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("callsSwitch");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callsSwitch");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ContactPresenter contactPresenter = this.presenter;
        if (contactPresenter != null) {
            contactPresenter.onResume();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    public final void setContact(Contact contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        this.mContact = contact;
    }

    @Override // com.animaconnected.secondo.screens.notification.ContactPresenter.ContactView
    public void updateContact(Contact contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        boolean z = true;
        this.phoneNbrAvailable = !TextUtils.isEmpty(contact.getPhoneNumber());
        String email = contact.getEmail();
        if (email == null || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            z = false;
        }
        this.emailAvailable = z;
        Log.d(TAG, "updateContact. has phone number: " + this.phoneNbrAvailable + " has email: " + this.emailAvailable);
        if (getView() == null) {
            return;
        }
        SwitchWrapper switchWrapper = this.callsSwitch;
        if (switchWrapper != null) {
            switchWrapper.setSwitchEnabled(this.phoneNbrAvailable);
            SwitchWrapper switchWrapper2 = this.messageSwitch;
            if (switchWrapper2 != null) {
                switchWrapper2.setSwitchEnabled(this.phoneNbrAvailable);
                SwitchWrapper switchWrapper3 = this.emailSwitch;
                if (switchWrapper3 != null) {
                    switchWrapper3.setSwitchEnabled(this.emailAvailable);
                    TextView textView = this.nameTextView;
                    if (textView != null) {
                        textView.setText(contact.getName());
                        SwitchWrapper switchWrapper4 = this.callsSwitch;
                        if (switchWrapper4 != null) {
                            switchWrapper4.setChecked(contact.isCallsFilterEnabled());
                            SwitchWrapper switchWrapper5 = this.emailSwitch;
                            if (switchWrapper5 != null) {
                                switchWrapper5.setChecked(contact.isEmailFilterEnabled());
                                SwitchWrapper switchWrapper6 = this.messageSwitch;
                                if (switchWrapper6 != null) {
                                    switchWrapper6.setChecked(contact.isMessagesFilterEnabled());
                                    return;
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("messageSwitch");
                                    throw null;
                                }
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("emailSwitch");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("callsSwitch");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("emailSwitch");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("messageSwitch");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callsSwitch");
        throw null;
    }
}
