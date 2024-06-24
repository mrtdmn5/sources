package com.animaconnected.secondo.screens.notification;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.notification.model.Contact;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.screens.MainController;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactPresenter.kt */
/* loaded from: classes3.dex */
public final class ContactPresenter implements NotificationUtil.DialogListener {
    private Contact contact;
    private final ContactView contactView;
    private final Context context;
    private final MainController mainController;
    private final NotificationProvider notificationProvider;
    private State state;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "ContactPresenter";

    /* compiled from: ContactPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: ContactPresenter.kt */
    /* loaded from: classes3.dex */
    public interface ContactView {
        void updateContact(Contact contact);
    }

    /* compiled from: ContactPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class State extends Enum<State> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State PRE_WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION = new State("PRE_WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION", 0);
        public static final State UPDATING_CONTACT = new State("UPDATING_CONTACT", 1);
        public static final State WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION = new State("WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION", 2);
        public static final State IDLE = new State("IDLE", 3);

        private static final /* synthetic */ State[] $values() {
            return new State[]{PRE_WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION, UPDATING_CONTACT, WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION, IDLE};
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private State(String str, int r2) {
            super(str, r2);
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public ContactPresenter(Context context, ContactView contactView, MainController mainController, Contact contact) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contactView, "contactView");
        Intrinsics.checkNotNullParameter(mainController, "mainController");
        this.context = context;
        this.contactView = contactView;
        this.mainController = mainController;
        this.contact = contact;
        this.notificationProvider = ProviderFactory.getNotificationProvider();
        this.state = State.IDLE;
    }

    public static final void onRemoveButtonClicked$lambda$0(ContactPresenter this$0, Void r1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainController.goBack();
    }

    public static final void onRemoveButtonClicked$lambda$1(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Log.w(TAG, "onFail() called with t = [" + error + ']');
    }

    private final void updateContactInNotificationProvider(Contact contact) {
        this.notificationProvider.createUpdateContactFromUri(Uri.parse(contact.getUri()), contact, new NotificationProvider.Callback<Contact>() { // from class: com.animaconnected.secondo.screens.notification.ContactPresenter$updateContactInNotificationProvider$1
            @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
            public void onFail(Throwable t) {
                String str;
                Intrinsics.checkNotNullParameter(t, "t");
                str = ContactPresenter.TAG;
                Log.w(str, "onFail() called with t = [" + t + ']');
            }

            @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
            public void onSuccess(Contact data) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        });
    }

    private final void updateCurrentContactView() {
        Contact contact = this.contact;
        if (contact == null) {
            return;
        }
        updateContactInNotificationProvider(contact);
        this.state = State.UPDATING_CONTACT;
        this.contactView.updateContact(contact);
        this.state = State.IDLE;
    }

    public final Contact getContact$secondo_kronabyRelease() {
        return this.contact;
    }

    public final void onCallSwitched(boolean z) {
        Contact contact = this.contact;
        if (contact != null && this.state != State.UPDATING_CONTACT) {
            contact.setCallsFilterEnabled(z);
            updateContactInNotificationProvider(contact);
        }
    }

    public final void onEmailSwitched(boolean z) {
        Contact contact = this.contact;
        if (contact != null && this.state != State.UPDATING_CONTACT) {
            contact.setEmailFilterEnabled(z);
            updateContactInNotificationProvider(contact);
            State state = this.state;
            State state2 = State.PRE_WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION;
            if (state != state2 && state != State.WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION && z && !NotificationUtil.isEnabled(this.context)) {
                this.state = state2;
                NotificationUtil.showNeedsReadNotificationsPermissionDialog(this.context, this);
            }
        }
    }

    public final void onMessageSwitched(boolean z) {
        Contact contact = this.contact;
        if (contact != null && this.state != State.UPDATING_CONTACT) {
            contact.setMessagesFilterEnabled(z);
            updateContactInNotificationProvider(contact);
        }
    }

    @Override // com.animaconnected.secondo.notification.receiver.NotificationUtil.DialogListener
    public void onNeedsReadNotificationsPermissionCancel() {
        if (this.state == State.PRE_WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION) {
            updateCurrentContactView();
        }
    }

    @Override // com.animaconnected.secondo.notification.receiver.NotificationUtil.DialogListener
    public void onNotificationSettingsLaunched() {
        if (this.state == State.PRE_WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION) {
            this.state = State.WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION;
        }
    }

    public final void onRemoveButtonClicked() {
        this.notificationProvider.deleteContactAndConfigurationItem(this.contact).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.notification.ContactPresenter$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                ContactPresenter.onRemoveButtonClicked$lambda$0(ContactPresenter.this, (Void) obj);
            }
        }).fail(new ContactPresenter$$ExternalSyntheticLambda1(0));
    }

    public final void onResume() {
        if (this.state == State.WAITING_FOR_EMAIL_NOTIFICATION_PERMISSION) {
            updateCurrentContactView();
        }
    }

    public final void setContact$secondo_kronabyRelease(Contact contact) {
        this.contact = contact;
    }
}
