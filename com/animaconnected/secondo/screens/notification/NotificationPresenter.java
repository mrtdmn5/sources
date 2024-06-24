package com.animaconnected.secondo.screens.notification;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.util.Log;
import android.util.Size;
import android.view.View;
import androidx.activity.result.ActivityResult;
import com.animaconnected.draganddrop.DragAndDrop;
import com.animaconnected.draganddrop.provider.DragAndDropProvider;
import com.animaconnected.draganddrop.provider.ItemChangedListener;
import com.animaconnected.draganddrop.provider.model.ClickListener;
import com.animaconnected.draganddrop.provider.model.DragAndDropDroppableItem;
import com.animaconnected.draganddrop.provider.model.DragAndDropItem;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.notification.model.Contact;
import com.animaconnected.secondo.notification.model.ImportantApp;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.provider.PermissionProvider;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemConstants;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker;
import com.animaconnected.secondo.screens.behaviourconfiguration.FeatureIssue;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingConstants;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingStorage;
import com.animaconnected.secondo.screens.notification.picker.ImportantAppsPagerFragment;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.secondo.utils.ScreenLocationHelper;
import com.animaconnected.watch.WatchProvider;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class NotificationPresenter implements ItemChangedListener<ConfigurationItem>, ClickListener, NotificationUtil.DialogListener, DragAndDropProvider.DragAndDropChangedListener, ConfigurationChecker.DialogListener {
    private static final String TAG = "NotificationPresenter";
    private ConfigurationItem mConfigurationItem;
    private final Context mContext;
    private DragAndDrop mDragAndDrop;
    private boolean mInitialOnboardingStarted;
    private final NotificationDragAndDropProvider mNotificationDragAndDropProvider;
    private final NotificationView mNotificationView;
    private final PermissionCompat.PermissionHelper mPermissionHelper;
    private final PermissionProvider mPermissionProvider;
    private final MainController mainController;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mNotificationAnimationRunnable = new Runnable() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            if (!MiniOnboardingStorage.getOnboardingDone(NotificationPresenter.this.mContext, MiniOnboardingConstants.NOTIFICATION_ONBOARDING_STORAGE) && !NotificationPresenter.this.mInitialOnboardingStarted) {
                NotificationPresenter.this.mInitialOnboardingStarted = true;
                NotificationPresenter.this.mNotificationView.showOnboardingDialog(false);
            }
            NotificationPresenter.this.mNotificationDragAndDropProvider.onAnimationCompleted();
        }
    };
    private int mCenterX = 0;
    private int mCenterY = 0;
    private State mState = State.IDLE;
    private final NotificationProvider mNotificationProvider = ProviderFactory.getNotificationProvider();

    /* loaded from: classes3.dex */
    public interface NotificationView {
        CustomActivityResult<Intent, ActivityResult> activityLauncher();

        void requestCallPermissions();

        void requestContactPermission();

        void requestReadContactPermission();

        void requestSmsPermissions();

        void showContactFragment(int r1, Integer num, int r3, int r4, int r5, int r6, boolean z);

        void showFragment(int r1, int r2, int r3, int r4, int r5, boolean z);

        void showImportantAppFragment(int r1, ImportantApp importantApp, int r3, int r4, int r5, int r6, boolean z);

        void showOnboardingDialog(boolean z);
    }

    /* loaded from: classes3.dex */
    public enum State {
        WAITING_FOR_PERMISSIONS_TO_ADD_NEW_CONTACT,
        WAITING_FOR_PERMISSIONS_FOR_CONTACT,
        WAITING_FOR_PERMISSIONS_FOR_ALL_TEXTS,
        WAITING_FOR_PERMISSIONS_FOR_ALL_CALLS,
        PRE_WAITING_FOR_NOTIFICATIONS_PERMISSION,
        WAITING_FOR_NOTIFICATION_PERMISSION,
        PRE_WAITING_FOR_CONFIGURATION,
        WAITING_FOR_CONFIGURATION,
        IDLE
    }

    public NotificationPresenter(Context context, NotificationView notificationView, MainController mainController, PermissionCompat.PermissionHelper permissionHelper) {
        this.mainController = mainController;
        this.mContext = context;
        this.mNotificationView = notificationView;
        this.mPermissionProvider = new PermissionProvider(context);
        this.mPermissionHelper = permissionHelper;
        NotificationDragAndDropProvider notificationDragAndDropProvider = new NotificationDragAndDropProvider(context);
        this.mNotificationDragAndDropProvider = notificationDragAndDropProvider;
        notificationDragAndDropProvider.registerDragAndDropItemsChangedListener(this);
        ProviderFactory.getImportantAppsProvider().buildUpCache(200L);
    }

    private void allCallsNotificationItemEnabled() {
        final String[] requiredPermissions = NotificationItemConstants.requiredPermissions(0);
        if (!this.mPermissionProvider.arePermissionsGranted(requiredPermissions)) {
            this.mState = State.WAITING_FOR_PERMISSIONS_FOR_ALL_CALLS;
            BottomSheetKt.showBottomDialog(this.mContext, R.layout.dialog_needs_general_singular_permission, (Function1<? super Boolean, Unit>) new Function1() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$allCallsNotificationItemEnabled$1;
                    lambda$allCallsNotificationItemEnabled$1 = NotificationPresenter.this.lambda$allCallsNotificationItemEnabled$1(requiredPermissions, (Boolean) obj);
                    return lambda$allCallsNotificationItemEnabled$1;
                }
            });
        }
    }

    private void allMessagesNotificationItemEnabled() {
        final String[] requiredPermissions = NotificationItemConstants.requiredPermissions(9);
        if (!this.mPermissionProvider.arePermissionsGranted(requiredPermissions)) {
            this.mState = State.WAITING_FOR_PERMISSIONS_FOR_ALL_TEXTS;
            BottomSheetKt.showBottomDialog(this.mContext, R.layout.dialog_needs_general_singular_permission, (Function1<? super Boolean, Unit>) new Function1() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$allMessagesNotificationItemEnabled$3;
                    lambda$allMessagesNotificationItemEnabled$3 = NotificationPresenter.this.lambda$allMessagesNotificationItemEnabled$3(requiredPermissions, (Boolean) obj);
                    return lambda$allMessagesNotificationItemEnabled$3;
                }
            });
        }
    }

    private boolean checkIfCurrentNotificationItemIsConfigured() {
        ConfigurationItem configurationItem = this.mConfigurationItem;
        if (configurationItem == null || !NotificationItemConstants.needsConfiguration(configurationItem.getType()) || ConfigurationChecker.isConfigured(this.mContext, this.mConfigurationItem)) {
            return true;
        }
        if (this.mState == State.WAITING_FOR_CONFIGURATION) {
            notificationChangedFailed();
            this.mState = State.IDLE;
            return true;
        }
        notificationItemNeedsConfiguration();
        return false;
    }

    private void checkNotificationsEnabled() {
        if (!NotificationUtil.isEnabled(this.mContext)) {
            notificationChangedFailed();
        }
        this.mState = State.IDLE;
    }

    private void contactPicked(Uri uri) {
        this.mNotificationProvider.createUpdateContactFromUri(uri, null, new NotificationProvider.Callback<Contact>() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter.3
            @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
            public void onFail(Throwable th) {
                Log.w(NotificationPresenter.TAG, "onFail() called with t = [" + th + "]");
            }

            @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
            public void onSuccess(Contact contact) {
                NotificationPresenter.this.mNotificationDragAndDropProvider.initData();
            }
        });
    }

    private boolean contactsNotificationItemEnabled() {
        int r1;
        final String[] requiredPermissions = NotificationItemConstants.requiredPermissions(2);
        FeatureIssue calculateIssue = FeatureIssue.calculateIssue(requiredPermissions, this.mContext);
        if (calculateIssue == FeatureIssue.GeneralPermission) {
            r1 = R.layout.dialog_needs_general_singular_permission;
        } else if (calculateIssue == FeatureIssue.GeneralPermissions) {
            r1 = R.layout.dialog_needs_general_plural_permission;
        } else {
            r1 = -1;
        }
        if (r1 != -1) {
            this.mState = State.WAITING_FOR_PERMISSIONS_FOR_CONTACT;
            BottomSheetKt.showBottomDialog(this.mContext, r1, (Function1<? super Boolean, Unit>) new Function1() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$contactsNotificationItemEnabled$5;
                    lambda$contactsNotificationItemEnabled$5 = NotificationPresenter.this.lambda$contactsNotificationItemEnabled$5(requiredPermissions, (Boolean) obj);
                    return lambda$contactsNotificationItemEnabled$5;
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$allCallsNotificationItemEnabled$0(String[] strArr) {
        this.mNotificationView.requestCallPermissions();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$allCallsNotificationItemEnabled$1(String[] strArr, Boolean bool) {
        if (bool.booleanValue()) {
            this.mPermissionHelper.requestPermissionOrGoToSettings(strArr, new Function1() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$allCallsNotificationItemEnabled$0;
                    lambda$allCallsNotificationItemEnabled$0 = NotificationPresenter.this.lambda$allCallsNotificationItemEnabled$0((String[]) obj);
                    return lambda$allCallsNotificationItemEnabled$0;
                }
            });
            return null;
        }
        notificationChangedFailed();
        this.mState = State.IDLE;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$allMessagesNotificationItemEnabled$2(String[] strArr) {
        this.mNotificationView.requestSmsPermissions();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$allMessagesNotificationItemEnabled$3(String[] strArr, Boolean bool) {
        if (bool.booleanValue()) {
            this.mPermissionHelper.requestPermissionOrGoToSettings(strArr, new Function1() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$allMessagesNotificationItemEnabled$2;
                    lambda$allMessagesNotificationItemEnabled$2 = NotificationPresenter.this.lambda$allMessagesNotificationItemEnabled$2((String[]) obj);
                    return lambda$allMessagesNotificationItemEnabled$2;
                }
            });
            return null;
        }
        notificationChangedFailed();
        this.mState = State.IDLE;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$contactsNotificationItemEnabled$4(String[] strArr) {
        this.mNotificationView.requestContactPermission();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$contactsNotificationItemEnabled$5(String[] strArr, Boolean bool) {
        if (bool.booleanValue()) {
            this.mPermissionHelper.requestPermissionOrGoToSettings(strArr, new Function1() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$contactsNotificationItemEnabled$4;
                    lambda$contactsNotificationItemEnabled$4 = NotificationPresenter.this.lambda$contactsNotificationItemEnabled$4((String[]) obj);
                    return lambda$contactsNotificationItemEnabled$4;
                }
            });
            return null;
        }
        this.mNotificationDragAndDropProvider.notifyDataChanged();
        notificationItemThatNeedsNotificationPermissionEnabled();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Unit lambda$launchContactPicker$8(ActivityResult activityResult) {
        Intent intent;
        if (activityResult.mResultCode == -1 && (intent = activityResult.mData) != null) {
            contactPicked(intent.getData());
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$requestAddContact$6(String[] strArr) {
        this.mNotificationView.requestReadContactPermission();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$requestAddContact$7(String[] strArr, Boolean bool) {
        if (bool.booleanValue()) {
            this.mPermissionHelper.requestPermissionOrGoToSettings(strArr, new Function1() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$requestAddContact$6;
                    lambda$requestAddContact$6 = NotificationPresenter.this.lambda$requestAddContact$6((String[]) obj);
                    return lambda$requestAddContact$6;
                }
            });
            return null;
        }
        this.mState = State.IDLE;
        return null;
    }

    private void launchContactPicker() {
        this.mNotificationView.activityLauncher().launch(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), new Function1() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$launchContactPicker$8;
                lambda$launchContactPicker$8 = NotificationPresenter.this.lambda$launchContactPicker$8((ActivityResult) obj);
                return lambda$launchContactPicker$8;
            }
        });
    }

    private void launchImportantApps() {
        this.mainController.gotoNextFragmentWithAnimations(ImportantAppsPagerFragment.newInstance(), R.anim.enter_from_bottom, R.anim.none, R.anim.none, R.anim.exit_to_bottom);
    }

    private void notificationChangedFailed() {
        this.mConfigurationItem = null;
        this.mNotificationDragAndDropProvider.notifyDataChanged();
    }

    private void notificationItemNeedsConfiguration() {
        this.mState = State.PRE_WAITING_FOR_CONFIGURATION;
        ConfigurationChecker.showNeedsConfigurationDialog(this.mContext, NotificationItemConstants.getConfigurationDescription(this.mConfigurationItem.getType()), this);
    }

    private void notificationItemNeedsPermission() {
        this.mState = State.PRE_WAITING_FOR_NOTIFICATIONS_PERMISSION;
        NotificationUtil.showNeedsReadNotificationsPermissionDialog(this.mContext, this);
    }

    private void notificationItemThatNeedsConfigurationEnabled() {
        if (!ConfigurationChecker.isConfigured(this.mContext, this.mConfigurationItem)) {
            notificationItemNeedsConfiguration();
        }
    }

    private void notificationItemThatNeedsNotificationPermissionAndConfigurationEnabled() {
        if (!NotificationUtil.isEnabled(this.mContext)) {
            notificationItemNeedsPermission();
        } else if (!ConfigurationChecker.isConfigured(this.mContext, this.mConfigurationItem)) {
            notificationItemNeedsConfiguration();
        }
    }

    private void notificationItemThatNeedsNotificationPermissionEnabled() {
        if (!NotificationUtil.isEnabled(this.mContext)) {
            notificationItemNeedsPermission();
        }
    }

    private void requestAddContact() {
        final String[] requiredPermissions = NotificationItemConstants.requiredPermissions(1);
        if (this.mPermissionProvider.arePermissionsGranted(requiredPermissions)) {
            launchContactPicker();
        } else {
            this.mState = State.WAITING_FOR_PERMISSIONS_TO_ADD_NEW_CONTACT;
            BottomSheetKt.showBottomDialog(this.mContext, R.layout.dialog_needs_contact_permission, (Function1<? super Boolean, Unit>) new Function1() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$requestAddContact$7;
                    lambda$requestAddContact$7 = NotificationPresenter.this.lambda$requestAddContact$7(requiredPermissions, (Boolean) obj);
                    return lambda$requestAddContact$7;
                }
            });
        }
    }

    public NotificationDragAndDropProvider getNotificationDragAndDropProvider() {
        return this.mNotificationDragAndDropProvider;
    }

    public void notificationOnboardingDone() {
        if (!MiniOnboardingStorage.getOnboardingDone(this.mContext, MiniOnboardingConstants.NOTIFICATION_ONBOARDING_STORAGE)) {
            MiniOnboardingStorage.setOnboardingDone(this.mContext, true, MiniOnboardingConstants.NOTIFICATION_ONBOARDING_STORAGE);
            this.mDragAndDrop.startInitialScroll();
        }
    }

    public void onCallAndSmsPermission(boolean z) {
        if (z) {
            this.mNotificationDragAndDropProvider.clearBadgeState(this.mConfigurationItem.getId());
            this.mNotificationDragAndDropProvider.initItemData();
        } else {
            notificationChangedFailed();
        }
        this.mState = State.IDLE;
    }

    public void onContactPermissionsGranted() {
        if (this.mState == State.WAITING_FOR_PERMISSIONS_FOR_CONTACT) {
            this.mNotificationDragAndDropProvider.clearBadgeState(this.mConfigurationItem.getId());
            this.mNotificationDragAndDropProvider.initItemData();
            notificationItemThatNeedsNotificationPermissionEnabled();
        }
    }

    public void onDestroy() {
        this.mNotificationDragAndDropProvider.unregisterDragAndDropItemsChangedListener(this);
    }

    @Override // com.animaconnected.draganddrop.provider.DragAndDropProvider.DragAndDropChangedListener
    public void onDragAndDropDataChanged() {
        if (!MiniOnboardingStorage.getOnboardingDone(this.mContext, MiniOnboardingConstants.NOTIFICATION_ONBOARDING_STORAGE)) {
            this.mDragAndDrop.scrollToLastMarbleIcon();
        }
    }

    @Override // com.animaconnected.draganddrop.provider.model.ClickListener
    public void onItemClicked(DragAndDropItem dragAndDropItem, View view) {
        boolean z;
        final int type = dragAndDropItem.getType();
        if (view != null) {
            Point viewCenterOnScreen = ScreenLocationHelper.getViewCenterOnScreen(view);
            this.mCenterX = viewCenterOnScreen.x;
            this.mCenterY = viewCenterOnScreen.y;
        }
        if (dragAndDropItem instanceof DragAndDropDroppableItem) {
            z = ((DragAndDropDroppableItem) dragAndDropItem).isDropped();
        } else {
            z = false;
        }
        Size screenSize = ScreenLocationHelper.getScreenSize(this.mContext);
        final int width = screenSize.getWidth();
        final int height = screenSize.getHeight();
        switch (type) {
            case 0:
            case 3:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
                this.mNotificationView.showFragment(type, this.mCenterX, this.mCenterY, width, height, z);
                return;
            case 1:
                requestAddContact();
                return;
            case 2:
                this.mNotificationView.showContactFragment(type, dragAndDropItem.getId(), this.mCenterX, this.mCenterY, width, height, z);
                return;
            case 4:
                final boolean z2 = z;
                this.mNotificationProvider.getImportantAppFromConfigurationItemId(dragAndDropItem.getId().intValue(), new NotificationProvider.Callback<ImportantApp>() { // from class: com.animaconnected.secondo.screens.notification.NotificationPresenter.2
                    @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
                    public void onFail(Throwable th) {
                        Log.e(NotificationPresenter.TAG, th.toString(), th);
                    }

                    @Override // com.animaconnected.secondo.provider.notification.NotificationProvider.Callback
                    public void onSuccess(ImportantApp importantApp) {
                        NotificationPresenter.this.mNotificationView.showImportantAppFragment(type, importantApp, NotificationPresenter.this.mCenterX, NotificationPresenter.this.mCenterY, width, height, z2);
                    }
                });
                return;
            case 8:
                launchImportantApps();
                return;
            default:
                Log.d(TAG, "Item has no click action: " + type);
                return;
        }
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker.DialogListener
    public void onNeedsConfigurationAccept() {
        Size screenSize = ScreenLocationHelper.getScreenSize(this.mContext);
        int width = screenSize.getWidth();
        int height = screenSize.getHeight();
        if (this.mState == State.PRE_WAITING_FOR_CONFIGURATION) {
            this.mState = State.WAITING_FOR_CONFIGURATION;
        }
        int type = this.mConfigurationItem.getType();
        if (type != 5) {
            if (type != 10) {
                if (type != 11) {
                    Log.d(TAG, "Ignoring unexpected configuration item type: " + this.mConfigurationItem.getType());
                    return;
                }
                this.mNotificationView.showFragment(this.mConfigurationItem.getType(), this.mCenterX, this.mCenterY, width, height, true);
                return;
            }
            this.mNotificationView.showFragment(10, this.mCenterX, this.mCenterY, width, height, true);
            return;
        }
        this.mNotificationView.showFragment(5, this.mCenterX, this.mCenterY, width, height, true);
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker.DialogListener
    public void onNeedsConfigurationCancel() {
        if (this.mState == State.PRE_WAITING_FOR_CONFIGURATION && this.mConfigurationItem != null) {
            notificationChangedFailed();
        }
    }

    @Override // com.animaconnected.secondo.notification.receiver.NotificationUtil.DialogListener
    public void onNeedsReadNotificationsPermissionCancel() {
        if (this.mState == State.PRE_WAITING_FOR_NOTIFICATIONS_PERMISSION) {
            checkNotificationsEnabled();
        }
    }

    @Override // com.animaconnected.secondo.notification.receiver.NotificationUtil.DialogListener
    public void onNotificationSettingsLaunched() {
        if (this.mState == State.PRE_WAITING_FOR_NOTIFICATIONS_PERMISSION) {
            this.mState = State.WAITING_FOR_NOTIFICATION_PERMISSION;
        }
    }

    public void onPause() {
        this.mNotificationDragAndDropProvider.unregisterItemsChangedListener(this);
        this.mHandler.removeCallbacks(this.mNotificationAnimationRunnable);
    }

    public void onReadContactPermission(Boolean bool) {
        if (bool.booleanValue()) {
            launchContactPicker();
            this.mNotificationDragAndDropProvider.initItemData();
        } else {
            this.mNotificationDragAndDropProvider.notifyDataChanged();
        }
    }

    public void onResume() {
        this.mNotificationDragAndDropProvider.registerItemsChangedListener(this);
        this.mNotificationDragAndDropProvider.initItemData();
        if (this.mState == State.WAITING_FOR_NOTIFICATION_PERMISSION) {
            checkNotificationsEnabled();
        }
        if (!checkIfCurrentNotificationItemIsConfigured()) {
            return;
        }
        this.mHandler.postDelayed(this.mNotificationAnimationRunnable, this.mContext.getResources().getInteger(R.integer.screen_transition_duration_horizontal));
    }

    public void onViewCreated() {
        this.mNotificationDragAndDropProvider.initData();
    }

    public void setDragAndDrop(DragAndDrop dragAndDrop) {
        this.mDragAndDrop = dragAndDrop;
    }

    @Override // com.animaconnected.draganddrop.provider.ItemChangedListener
    public void onItemChanged(ConfigurationItem configurationItem, int r4, int r5, int r6) {
        this.mConfigurationItem = configurationItem;
        this.mCenterX = r5;
        this.mCenterY = r6;
        boolean z = r4 != -1;
        int r42 = r4 + 1;
        WatchProvider watch = ProviderFactory.getWatch();
        if (z) {
            watch.alert(r42);
            switch (configurationItem.getType()) {
                case 0:
                    allCallsNotificationItemEnabled();
                    break;
                case 2:
                    if (!contactsNotificationItemEnabled()) {
                        notificationItemThatNeedsNotificationPermissionEnabled();
                        break;
                    }
                    break;
                case 3:
                case 4:
                    notificationItemThatNeedsNotificationPermissionEnabled();
                    break;
                case 5:
                case 10:
                    notificationItemThatNeedsConfigurationEnabled();
                    break;
                case 6:
                    watch.setStillnessActive(true);
                    break;
                case 9:
                    allMessagesNotificationItemEnabled();
                    break;
                case 11:
                    notificationItemThatNeedsNotificationPermissionAndConfigurationEnabled();
                    break;
            }
        } else {
            if (configurationItem.getType() == 6) {
                watch.setStillnessActive(false);
            }
            this.mConfigurationItem = null;
        }
        this.mNotificationProvider.refresh();
    }
}
