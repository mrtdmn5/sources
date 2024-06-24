package com.animaconnected.secondo.screens.settings;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.ArrayMap;
import androidx.activity.result.ActivityResult;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentActivity;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.info.UserCategoryKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.labs.LabsProvider;
import com.animaconnected.secondo.provider.productinfo.ProductInfoData;
import com.animaconnected.secondo.provider.productinfo.ProductInfoProvider;
import com.animaconnected.secondo.screens.FeedbackView;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.quiethours.QuietHoursFragment;
import com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment;
import com.animaconnected.secondo.screens.settings.displaynotifications.CallsTextFragment;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.secondo.utils.customersupport.CustomerSupportMailUtils;
import com.animaconnected.secondo.utils.customersupport.CustomerSupportMailUtilsKt;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.filter.Application;
import com.animaconnected.watch.filter.ApplicationSetting;
import com.animaconnected.watch.filter.FilterSettings;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: SettingsPresenter.kt */
/* loaded from: classes3.dex */
public final class SettingsPresenter implements DeviceConnectionListener {
    public static final int $stable = 8;
    private final Context context;
    private final Lazy customerSupportMail$delegate;
    private Map<DeviceInfo, String> deviceInfoMap;
    private final LabsProvider labsProvider;
    private final MainController mainController;
    private final SettingsView view;
    private final WatchManager watchManager;
    private final WatchProvider watchProvider;

    /* compiled from: SettingsPresenter.kt */
    /* loaded from: classes3.dex */
    public interface SettingsView {
        CustomActivityResult<Intent, ActivityResult> getActivityLauncher();

        void updateWatches(List<WatchModel> list);
    }

    /* compiled from: SettingsPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class WatchModel {
        public static final int $stable = 8;
        private final String address;
        private final boolean connected;
        private final boolean current;
        private final boolean inDfuMode;
        private final boolean isUpdateAvailable;
        private final String name;
        private final String sku;
        private final DeviceType type;
        private final FirmwareVariant variant;

        public WatchModel(String address, DeviceType type, FirmwareVariant variant, String str, boolean z, boolean z2, boolean z3, boolean z4, String name) {
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(variant, "variant");
            Intrinsics.checkNotNullParameter(name, "name");
            this.address = address;
            this.type = type;
            this.variant = variant;
            this.sku = str;
            this.current = z;
            this.connected = z2;
            this.isUpdateAvailable = z3;
            this.inDfuMode = z4;
            this.name = name;
        }

        public static /* synthetic */ WatchModel copy$default(WatchModel watchModel, String str, DeviceType deviceType, FirmwareVariant firmwareVariant, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3, int r20, Object obj) {
            String str4;
            DeviceType deviceType2;
            FirmwareVariant firmwareVariant2;
            String str5;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            String str6;
            if ((r20 & 1) != 0) {
                str4 = watchModel.address;
            } else {
                str4 = str;
            }
            if ((r20 & 2) != 0) {
                deviceType2 = watchModel.type;
            } else {
                deviceType2 = deviceType;
            }
            if ((r20 & 4) != 0) {
                firmwareVariant2 = watchModel.variant;
            } else {
                firmwareVariant2 = firmwareVariant;
            }
            if ((r20 & 8) != 0) {
                str5 = watchModel.sku;
            } else {
                str5 = str2;
            }
            if ((r20 & 16) != 0) {
                z5 = watchModel.current;
            } else {
                z5 = z;
            }
            if ((r20 & 32) != 0) {
                z6 = watchModel.connected;
            } else {
                z6 = z2;
            }
            if ((r20 & 64) != 0) {
                z7 = watchModel.isUpdateAvailable;
            } else {
                z7 = z3;
            }
            if ((r20 & 128) != 0) {
                z8 = watchModel.inDfuMode;
            } else {
                z8 = z4;
            }
            if ((r20 & 256) != 0) {
                str6 = watchModel.name;
            } else {
                str6 = str3;
            }
            return watchModel.copy(str4, deviceType2, firmwareVariant2, str5, z5, z6, z7, z8, str6);
        }

        public final String component1() {
            return this.address;
        }

        public final DeviceType component2() {
            return this.type;
        }

        public final FirmwareVariant component3() {
            return this.variant;
        }

        public final String component4() {
            return this.sku;
        }

        public final boolean component5() {
            return this.current;
        }

        public final boolean component6() {
            return this.connected;
        }

        public final boolean component7() {
            return this.isUpdateAvailable;
        }

        public final boolean component8() {
            return this.inDfuMode;
        }

        public final String component9() {
            return this.name;
        }

        public final WatchModel copy(String address, DeviceType type, FirmwareVariant variant, String str, boolean z, boolean z2, boolean z3, boolean z4, String name) {
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(variant, "variant");
            Intrinsics.checkNotNullParameter(name, "name");
            return new WatchModel(address, type, variant, str, z, z2, z3, z4, name);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WatchModel)) {
                return false;
            }
            WatchModel watchModel = (WatchModel) obj;
            if (Intrinsics.areEqual(this.address, watchModel.address) && this.type == watchModel.type && Intrinsics.areEqual(this.variant, watchModel.variant) && Intrinsics.areEqual(this.sku, watchModel.sku) && this.current == watchModel.current && this.connected == watchModel.connected && this.isUpdateAvailable == watchModel.isUpdateAvailable && this.inDfuMode == watchModel.inDfuMode && Intrinsics.areEqual(this.name, watchModel.name)) {
                return true;
            }
            return false;
        }

        public final String getAddress() {
            return this.address;
        }

        public final boolean getConnected() {
            return this.connected;
        }

        public final boolean getCurrent() {
            return this.current;
        }

        public final boolean getInDfuMode() {
            return this.inDfuMode;
        }

        public final String getName() {
            return this.name;
        }

        public final String getSku() {
            return this.sku;
        }

        public final DeviceType getType() {
            return this.type;
        }

        public final FirmwareVariant getVariant() {
            return this.variant;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = (this.variant.hashCode() + ((this.type.hashCode() + (this.address.hashCode() * 31)) * 31)) * 31;
            String str = this.sku;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return this.name.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.inDfuMode, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isUpdateAvailable, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.connected, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.current, (hashCode2 + hashCode) * 31, 31), 31), 31), 31);
        }

        public final boolean isUpdateAvailable() {
            return this.isUpdateAvailable;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("WatchModel(address=");
            sb.append(this.address);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(", variant=");
            sb.append(this.variant);
            sb.append(", sku=");
            sb.append(this.sku);
            sb.append(", current=");
            sb.append(this.current);
            sb.append(", connected=");
            sb.append(this.connected);
            sb.append(", isUpdateAvailable=");
            sb.append(this.isUpdateAvailable);
            sb.append(", inDfuMode=");
            sb.append(this.inDfuMode);
            sb.append(", name=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.name, ')');
        }
    }

    public SettingsPresenter(Context context, SettingsView view, MainController mainController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mainController, "mainController");
        this.context = context;
        this.view = view;
        this.mainController = mainController;
        this.customerSupportMail$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CustomerSupportMailUtils>() { // from class: com.animaconnected.secondo.screens.settings.SettingsPresenter$customerSupportMail$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CustomerSupportMailUtils invoke() {
                Context context2;
                context2 = SettingsPresenter.this.context;
                return new CustomerSupportMailUtils(context2);
            }
        });
        WatchProvider watch = ProviderFactory.getWatch();
        this.watchProvider = watch;
        this.watchManager = watch.getWatchManager();
        this.labsProvider = ProviderFactory.getLabsProvider();
        this.deviceInfoMap = new ArrayMap();
    }

    private final CustomerSupportMailUtils getCustomerSupportMail() {
        return (CustomerSupportMailUtils) this.customerSupportMail$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(SettingsPresenter this$0, Map deviceInfoMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deviceInfoMap, "deviceInfoMap");
        Map<DeviceInfo, String> unmodifiableMap = Collections.unmodifiableMap(deviceInfoMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(...)");
        this$0.deviceInfoMap = unmodifiableMap;
    }

    private final void updateWatches() {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        SettingsPresenter settingsPresenter = this;
        Watch currentWatch = settingsPresenter.watchManager.getCurrentWatch();
        SettingsView settingsView = settingsPresenter.view;
        List<Watch> watches = settingsPresenter.watchManager.getWatches();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(watches, 10));
        for (Watch watch : watches) {
            boolean areEqual = Intrinsics.areEqual(currentWatch, watch);
            if (areEqual && (settingsPresenter.watchProvider.isInDfuMode() || settingsPresenter.watchProvider.isInUpdateRequired())) {
                z = true;
            } else {
                z = false;
            }
            if (areEqual && (ProviderFactory.getWatchDfuProvider().isDfuAvailable() || ProviderFactory.getWatch().isInDfuMode() || ProviderFactory.getWatchFotaProvider().isReadyToPerformFota())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (areEqual && settingsPresenter.watchProvider.isConnected()) {
                z3 = true;
            } else {
                z3 = false;
            }
            ProductInfoData data = ProductInfoProvider.INSTANCE.getData(watch.getSku());
            if (data == null || (str = data.getCoreUnitDisplayName()) == null) {
                str = settingsPresenter.context.getString(R.string.watch_brand) + ' ' + StringsKt___StringsKt.takeLast(4, StringsKt__StringsJVMKt.replace$default(watch.getIdentifier(), ":", ""));
            }
            arrayList.add(new WatchModel(watch.getIdentifier(), watch.getWatchType(), watch.getFirmwareVariant(), watch.getSku(), areEqual, z3, z2, z, str));
            settingsPresenter = this;
        }
        settingsView.updateWatches(arrayList);
    }

    public final String getDescriptionTextForApps() {
        boolean z;
        FilterSettings filterSettings = ProviderFactory.getWatch().getWatchManager().getFilterSettings();
        List<Application> applications = filterSettings.getApplications();
        int r3 = 0;
        if (!(applications instanceof Collection) || !applications.isEmpty()) {
            Iterator<T> it = applications.iterator();
            int r2 = 0;
            while (it.hasNext()) {
                if (((Application) it.next()).getSetting() == ApplicationSetting.Important) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (r2 = r2 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                    throw null;
                }
            }
            r3 = r2;
        }
        if (filterSettings.isAllAppsEnabled()) {
            String string = this.context.getString(R.string.filtered_notifications_apps_enabled_for_all);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (r3 > 0) {
            String string2 = this.context.getString(R.string.filtered_notifications_apps_enabled_for_x, Integer.valueOf(r3));
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        String string3 = this.context.getString(R.string.general_disabled);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    public final String getDescriptionTextForTextsAndCalls() {
        FilterSettings.Allowed callsFilter = ProviderFactory.getWatch().getWatchManager().getFilterSettings().getCallsFilter();
        FilterSettings.Allowed textsFilter = ProviderFactory.getWatch().getWatchManager().getFilterSettings().getTextsFilter();
        FilterSettings.Allowed allowed = FilterSettings.Allowed.All;
        if (callsFilter == allowed && textsFilter == allowed) {
            String string = this.context.getString(R.string.filtered_notifications_calls_texts_enabled_for_everyone);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        FilterSettings.Allowed allowed2 = FilterSettings.Allowed.None;
        if (callsFilter == allowed2 && textsFilter == allowed2) {
            String string2 = this.context.getString(R.string.general_disabled);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        String string3 = this.context.getString(R.string.filtered_notifications_calls_texts_enabled_for_some_contacts);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    public final boolean hasDisplay() {
        return this.watchProvider.getWatch().getHasDisplay();
    }

    public final boolean hasFacebookLink() {
        boolean z;
        boolean z2;
        String string = this.context.getString(R.string.facebook_uri_web);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String string2 = this.context.getString(R.string.facebook_uri_app);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            if (string2.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasHowToVideos() {
        String string = this.context.getString(R.string.how_to_videos_uri);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() > 0) {
            return true;
        }
        return false;
    }

    public final boolean hasInstagramLink() {
        String string = this.context.getString(R.string.instagram_uri);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() > 0) {
            return true;
        }
        return false;
    }

    public final boolean hasRateUs() {
        boolean z;
        boolean z2;
        String string = this.context.getString(R.string.google_play_store_link);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (string.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String string2 = this.context.getString(R.string.google_play_url_link);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            if (string2.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final boolean isQuiteHoursEnabled() {
        return this.watchManager.getQuietHours().isEnabled();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        updateWatches();
    }

    public final void onContactLabs() {
        if (this.context.getResources().getBoolean(R.bool.app_feature_aws_feedback_system)) {
            final FeedbackView.FeedbackCommentDialog newInstance = FeedbackView.FeedbackCommentDialog.Companion.newInstance(this.labsProvider.hasRating(LabsProvider.LABS_FEEDBACK_NAME), true);
            newInstance.setListener(new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.settings.SettingsPresenter$onContactLabs$1$1
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
                    if (comment.length() > 0) {
                        labsProvider = this.labsProvider;
                        labsProvider.setRating(LabsProvider.LABS_FEEDBACK_NAME, 1, comment);
                    }
                }
            });
            Context context = this.context;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            newInstance.show(((FragmentActivity) context).getSupportFragmentManager(), (String) null);
            return;
        }
        CustomerSupportMailUtilsKt.showEmailIntent(this.context, getCustomerSupportMail().getContactLabsEmailAddress(), this.context.getString(R.string.contact_labs_msg_subject), getCustomerSupportMail().getSupportMsgTechData(this.deviceInfoMap) + this.context.getString(R.string.contact_labs_msg_body_description_feedback));
    }

    public final void onContactSupport() {
        boolean z = this.context.getResources().getBoolean(R.bool.app_feature_customer_support_ticket_api);
        String customSupportMail = RemoteConfigController.Companion.getInstance(this.context).getCustomSupportMail();
        if (StringsKt__StringsJVMKt.isBlank(customSupportMail) && z) {
            this.mainController.gotoNextFragment(CustomerSupportTicketFragment.Companion.newInstance());
            return;
        }
        String str = getCustomerSupportMail().getSupportMsgTechData(this.deviceInfoMap) + this.context.getString(R.string.support_msg_body_describe_support_needed);
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        if (StringsKt__StringsJVMKt.isBlank(customSupportMail)) {
            customSupportMail = getCustomerSupportMail().getSupportEmailAddress();
        }
        Context context = this.context;
        CustomerSupportMailUtilsKt.showEmailIntent(context, customSupportMail, context.getString(R.string.support_msg_subject), str);
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        updateWatches();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        updateWatches();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterUpdateRequired() {
        updateWatches();
    }

    public final void onFAQButtonClicked() {
        CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.intent.action.VIEW", Uri.parse(this.context.getString(R.string.faq_uri))), null, 2, null);
    }

    public final void onFacebookButtonClicked() {
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo("com.facebook.katana", 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            if (applicationInfo.enabled) {
                CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.intent.action.VIEW", Uri.parse(this.context.getString(R.string.facebook_uri_app))), null, 2, null);
                return;
            }
        } catch (ActivityNotFoundException | PackageManager.NameNotFoundException unused) {
        }
        CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.intent.action.VIEW", Uri.parse(this.context.getString(R.string.facebook_uri_web))), null, 2, null);
    }

    public final void onHowToVideosButtonClicked() {
        CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.intent.action.VIEW", Uri.parse(this.context.getString(R.string.how_to_videos_uri))), null, 2, null);
    }

    public final void onInstagramButtonClicked() {
        CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.intent.action.VIEW", Uri.parse(this.context.getString(R.string.instagram_uri))), null, 2, null);
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveDfuMode() {
        updateWatches();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveUpdateRequired() {
        updateWatches();
    }

    public final void onNotificationsAppsClicked() {
        this.mainController.gotoNextFragment(AppsNotificationsFragment.Companion.newInstance());
    }

    public final void onNotificationsCallsClicked() {
        this.mainController.gotoNextFragment(CallsTextFragment.Companion.newInstance());
    }

    public final void onNotificationsQuietHoursClicked() {
        MainController mainController = this.mainController;
        QuietHoursFragment.Companion companion = QuietHoursFragment.Companion;
        String string = this.context.getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        mainController.gotoNextFragment(companion.newInstance(string, R.drawable.ic_back_arrow_white));
    }

    public final void onPause() {
        ProviderFactory.getWatch().unregisterDeviceConnectionListener(this);
    }

    public final void onPrivacyPolicyButtonClicked() {
        CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.intent.action.VIEW", Uri.parse(this.context.getString(R.string.privacy_policy_link_uri))), null, 2, null);
    }

    public final void onRateUsButtonClicked() {
        try {
            CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.intent.action.VIEW", Uri.parse(this.context.getString(R.string.google_play_store_link))), null, 2, null);
        } catch (ActivityNotFoundException unused) {
            CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.intent.action.VIEW", Uri.parse(this.context.getString(R.string.google_play_url_link))), null, 2, null);
        }
    }

    public final void onResume() {
        this.watchProvider.registerDeviceConnectionListener(this);
        if (this.watchProvider.isConnected()) {
            onConnected();
        }
        updateWatches();
        this.watchProvider.getDeviceInformation().success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.settings.SettingsPresenter$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                SettingsPresenter.onResume$lambda$0(SettingsPresenter.this, (Map) obj);
            }
        });
    }

    public final void onTermsOfUseButtonClicked() {
        CustomActivityResult.launch$default(this.view.getActivityLauncher(), new Intent("android.intent.action.VIEW", Uri.parse(this.context.getString(R.string.terms_of_use_link_uri))), null, 2, null);
    }

    public final boolean userCategoryDebugMenuEnabled() {
        return UserCategoryKt.debugMenuEnabled(this.watchProvider.getUserCategory());
    }
}
