package com.animaconnected.secondo.screens.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.bluetooth.util.ConnectionListener;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel$$ExternalSyntheticLambda0;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.battery.BatteryProvider;
import com.animaconnected.secondo.provider.productinfo.ProductInfoData;
import com.animaconnected.secondo.provider.productinfo.ProductInfoProvider;
import com.animaconnected.secondo.provider.productinfo.watchimage.WatchImageType;
import com.animaconnected.secondo.provider.update.BackgroundUpdateChecker;
import com.animaconnected.secondo.provider.update.UpdateChangeListener;
import com.animaconnected.secondo.provider.update.WatchDfuProvider;
import com.animaconnected.secondo.provider.update.WatchFotaProvider;
import com.animaconnected.secondo.provider.update.WatchUpdateProvider;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.calibration.CalibrationFragment;
import com.animaconnected.secondo.screens.campaigns.CampaignFragment$$ExternalSyntheticLambda0;
import com.animaconnected.secondo.screens.settings.AboutWatchDialogFragment;
import com.animaconnected.secondo.screens.settings.ForgetWatchDialogFragment;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory;
import com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment;
import com.animaconnected.secondo.screens.watchupdate.WatchUpdateFragmentFactory;
import com.animaconnected.secondo.widget.LayoutState;
import com.animaconnected.secondo.widget.SectionLayout;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.device.DfuStatus;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.BuildersKt;

/* compiled from: WatchSettingsFragment.kt */
/* loaded from: classes3.dex */
public final class WatchSettingsFragment extends BaseFragment implements DeviceConnectionListener, WatchViewLayouter {
    public static final String addressBundleKey = "address";
    public static final String saveStateJustActivated = "justActivated";
    private Button activateWatch;
    private String address;
    private final BackgroundUpdateChecker backgroundUpdateChecker;
    private ImageView batteryChargingImage;
    private ImageView batteryImage;
    private final WatchSettingsFragment$batteryListener$1 batteryListener;
    private TextView batteryPercentage;
    private final BatteryProvider batteryProvider;
    private SectionLayout calibration;
    private final ConnectionListener connectionListener;
    private final WatchDfuProvider dfuProvider;
    private final Runnable disconnectRunnable;
    private SectionLayout forgetWatch;
    private final WatchFotaProvider fotaProvider;
    private final BroadcastReceiver gpsSwitchStateReceiver;
    private final Handler handler;
    private boolean isRunningDfuReady;
    private boolean justActivatedWatch;
    private SectionLayout lostWatch;
    private final NumberFormat percentageFormat;
    private ProgressBar progressbar;
    private boolean showTurnOnLocation;
    private ImageView skuImage;
    private SectionLayout strongerVibration;
    private final UpdateChangeListener updateListener;
    private boolean updateWatchClicked;
    private final WatchManager watchManager;
    private final WatchProvider watchProvider;
    private TextView watchStatus;
    private SectionLayout watchUpdate;
    private final WatchUpdateProvider watchUpdateProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WatchSettingsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WatchSettingsFragment newInstance(String address) {
            Intrinsics.checkNotNullParameter(address, "address");
            WatchSettingsFragment watchSettingsFragment = new WatchSettingsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(WatchSettingsFragment.addressBundleKey, address);
            watchSettingsFragment.setArguments(bundle);
            return watchSettingsFragment;
        }

        private Companion() {
        }
    }

    /* compiled from: WatchSettingsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class WatchState extends Enum<WatchState> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WatchState[] $VALUES;
        public static final WatchState Connected = new WatchState("Connected", 0);
        public static final WatchState Connecting = new WatchState("Connecting", 1);
        public static final WatchState Disconnected = new WatchState("Disconnected", 2);
        public static final WatchState InDfu = new WatchState("InDfu", 3);
        public static final WatchState Inactive = new WatchState("Inactive", 4);

        private static final /* synthetic */ WatchState[] $values() {
            return new WatchState[]{Connected, Connecting, Disconnected, InDfu, Inactive};
        }

        static {
            WatchState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private WatchState(String str, int r2) {
            super(str, r2);
        }

        public static EnumEntries<WatchState> getEntries() {
            return $ENTRIES;
        }

        public static WatchState valueOf(String str) {
            return (WatchState) Enum.valueOf(WatchState.class, str);
        }

        public static WatchState[] values() {
            return (WatchState[]) $VALUES.clone();
        }
    }

    /* compiled from: WatchSettingsFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[WatchState.values().length];
            try {
                r0[WatchState.InDfu.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WatchState.Connected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WatchState.Disconnected.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[WatchState.Connecting.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[WatchState.Inactive.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[DfuStatus.values().length];
            try {
                r02[DfuStatus.BatteryLow.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[DfuStatus.TooCold.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.animaconnected.secondo.screens.settings.WatchSettingsFragment$batteryListener$1] */
    public WatchSettingsFragment() {
        WatchProvider watch = ProviderFactory.getWatch();
        this.watchProvider = watch;
        this.watchManager = watch.getWatchManager();
        this.handler = new Handler(Looper.getMainLooper());
        this.disconnectRunnable = new DistressModel$$ExternalSyntheticLambda0(1, this);
        this.batteryListener = new BatteryProvider.BatteryListener() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$batteryListener$1
            @Override // com.animaconnected.secondo.provider.battery.BatteryProvider.BatteryListener
            public void onBatteryValuesChanged() {
                WatchSettingsFragment.this.updateBatteryUI();
            }
        };
        this.batteryProvider = ProviderFactory.getBatteryProvider();
        NumberFormat percentInstance = NumberFormat.getPercentInstance(Locale.getDefault());
        Intrinsics.checkNotNullExpressionValue(percentInstance, "getPercentInstance(...)");
        this.percentageFormat = percentInstance;
        this.gpsSwitchStateReceiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$gpsSwitchStateReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                WatchSettingsFragment.this.updateLostWatchMenu();
            }
        };
        this.dfuProvider = ProviderFactory.getWatchDfuProvider();
        this.fotaProvider = ProviderFactory.getWatchFotaProvider();
        this.watchUpdateProvider = ProviderFactory.getWatchUpdateProvider();
        this.backgroundUpdateChecker = ProviderFactory.getBackgroundUpdateChecker();
        this.updateListener = new UpdateChangeListener() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$$ExternalSyntheticLambda2
            @Override // com.animaconnected.secondo.provider.update.UpdateChangeListener
            public final void onUpdateInfoChanged() {
                WatchSettingsFragment.updateListener$lambda$12(WatchSettingsFragment.this);
            }
        };
        this.connectionListener = new ConnectionListener() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$$ExternalSyntheticLambda3
            @Override // com.animaconnected.bluetooth.util.ConnectionListener
            public final void onChanged(boolean z) {
                WatchSettingsFragment.connectionListener$lambda$14(WatchSettingsFragment.this, z);
            }
        };
    }

    public static final void connectionListener$lambda$14(final WatchSettingsFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handler.post(new Runnable() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                WatchSettingsFragment.connectionListener$lambda$14$lambda$13(WatchSettingsFragment.this);
            }
        });
    }

    public static final void connectionListener$lambda$14$lambda$13(WatchSettingsFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateWatchUpdateUi();
    }

    public static final void disconnectRunnable$lambda$0(WatchSettingsFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onDisconnected();
    }

    private final boolean isCurrentActiveWatch() {
        String str = this.address;
        if (str != null) {
            return Intrinsics.areEqual(str, this.watchProvider.getAddress());
        }
        Intrinsics.throwUninitializedPropertyAccessException(addressBundleKey);
        throw null;
    }

    public static final void onCreateView$lambda$8$lambda$1(WatchSettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AboutWatchDialogFragment.Companion companion = AboutWatchDialogFragment.Companion;
        String str = this$0.address;
        if (str != null) {
            companion.newInstance(str).show(this$0.getChildFragmentManager(), (String) null);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException(addressBundleKey);
            throw null;
        }
    }

    public static final void onCreateView$lambda$8$lambda$2(WatchSettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setState(WatchState.Connecting);
        BuildersKt.launch$default(Hashing.getLifecycleScope(this$0), null, null, new WatchSettingsFragment$onCreateView$1$2$1(this$0, null), 3);
    }

    public static final void onCreateView$lambda$8$lambda$4(WatchSettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMainController().gotoNextFragment(CalibrationFragment.Companion.newInstance(false));
    }

    public static final void onCreateView$lambda$8$lambda$5(WatchSettingsFragment this$0, final Watch watch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        SectionLayout sectionLayout = this$0.strongerVibration;
        if (sectionLayout != null) {
            sectionLayout.setOnCheckedChangeListener(new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$onCreateView$1$5$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    Watch.this.setStrongVibrationEnabled(z);
                }
            });
            SectionLayout sectionLayout2 = this$0.strongerVibration;
            if (sectionLayout2 != null) {
                sectionLayout2.setChecked(watch.getStrongVibrationEnabled());
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("strongerVibration");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("strongerVibration");
        throw null;
    }

    public static final void onCreateView$lambda$8$lambda$6(WatchSettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onLostWatchClicked();
    }

    public static final void onCreateView$lambda$8$lambda$7(WatchSettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ForgetWatchDialogFragment.Companion companion = ForgetWatchDialogFragment.Companion;
        String str = this$0.address;
        if (str != null) {
            companion.newInstance(str).show(this$0.getChildFragmentManager(), (String) null);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException(addressBundleKey);
            throw null;
        }
    }

    private final void onLostWatchClicked() {
        String str;
        if (this.showTurnOnLocation) {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.setFlags(268435456);
            startActivity(intent);
            return;
        }
        if (ProviderFactory.getWatch().isConnected()) {
            str = "connected";
        } else {
            str = "disconnected";
        }
        ProviderFactory.getAppAnalytics().sendLostWatchEvent("lost_watch_clicked_".concat(str), null);
        MainController mainController = getMainController();
        String str2 = this.address;
        if (str2 != null) {
            LostWatchFragment newInstance = LostWatchFragment.newInstance(str2);
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            mainController.gotoNextFragment(newInstance);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException(addressBundleKey);
        throw null;
    }

    public final String readableError(DfuStatus dfuStatus) {
        int r2 = WhenMappings.$EnumSwitchMapping$1[dfuStatus.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                return null;
            }
            return KronabyApplication.Companion.getContext().getString(R.string.watch_update_error_too_cold);
        }
        return KronabyApplication.Companion.getContext().getString(R.string.watch_update_error_battery_too_low);
    }

    private final void setState(WatchState watchState) {
        if (isCurrentActiveWatch() || watchState == WatchState.Inactive || watchState == WatchState.Connecting) {
            int r14 = WhenMappings.$EnumSwitchMapping$0[watchState.ordinal()];
            if (r14 != 1) {
                if (r14 != 2) {
                    if (r14 != 3) {
                        if (r14 != 4) {
                            if (r14 == 5) {
                                ImageView imageView = this.skuImage;
                                if (imageView != null) {
                                    imageView.setAlpha(0.3f);
                                    SectionLayout sectionLayout = this.calibration;
                                    if (sectionLayout != null) {
                                        LayoutState layoutState = LayoutState.Disabled;
                                        sectionLayout.setLayoutState(layoutState);
                                        SectionLayout sectionLayout2 = this.strongerVibration;
                                        if (sectionLayout2 != null) {
                                            sectionLayout2.setLayoutState(layoutState);
                                            TextView textView = this.watchStatus;
                                            if (textView != null) {
                                                textView.setVisibility(4);
                                                Button button = this.activateWatch;
                                                if (button != null) {
                                                    button.setVisibility(0);
                                                    ProgressBar progressBar = this.progressbar;
                                                    if (progressBar != null) {
                                                        progressBar.setVisibility(8);
                                                        return;
                                                    } else {
                                                        Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                                                        throw null;
                                                    }
                                                }
                                                Intrinsics.throwUninitializedPropertyAccessException("activateWatch");
                                                throw null;
                                            }
                                            Intrinsics.throwUninitializedPropertyAccessException("watchStatus");
                                            throw null;
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException("strongerVibration");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("calibration");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("skuImage");
                                throw null;
                            }
                            return;
                        }
                        ImageView imageView2 = this.skuImage;
                        if (imageView2 != null) {
                            imageView2.setAlpha(0.3f);
                            SectionLayout sectionLayout3 = this.calibration;
                            if (sectionLayout3 != null) {
                                LayoutState layoutState2 = LayoutState.Disabled;
                                sectionLayout3.setLayoutState(layoutState2);
                                SectionLayout sectionLayout4 = this.strongerVibration;
                                if (sectionLayout4 != null) {
                                    sectionLayout4.setLayoutState(layoutState2);
                                    TextView textView2 = this.watchStatus;
                                    if (textView2 != null) {
                                        textView2.setText(getString(R.string.dashboard_description_connecting));
                                        TextView textView3 = this.watchStatus;
                                        if (textView3 != null) {
                                            textView3.setVisibility(0);
                                            Button button2 = this.activateWatch;
                                            if (button2 != null) {
                                                button2.setVisibility(4);
                                                ProgressBar progressBar2 = this.progressbar;
                                                if (progressBar2 != null) {
                                                    progressBar2.setVisibility(0);
                                                    return;
                                                } else {
                                                    Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                                                    throw null;
                                                }
                                            }
                                            Intrinsics.throwUninitializedPropertyAccessException("activateWatch");
                                            throw null;
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException("watchStatus");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("watchStatus");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("strongerVibration");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("calibration");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("skuImage");
                        throw null;
                    }
                    ImageView imageView3 = this.skuImage;
                    if (imageView3 != null) {
                        imageView3.setAlpha(0.3f);
                        SectionLayout sectionLayout5 = this.calibration;
                        if (sectionLayout5 != null) {
                            LayoutState layoutState3 = LayoutState.Disabled;
                            sectionLayout5.setLayoutState(layoutState3);
                            SectionLayout sectionLayout6 = this.strongerVibration;
                            if (sectionLayout6 != null) {
                                sectionLayout6.setLayoutState(layoutState3);
                                TextView textView4 = this.watchStatus;
                                if (textView4 != null) {
                                    textView4.setText(getString(R.string.watch_status_disconnected));
                                    TextView textView5 = this.watchStatus;
                                    if (textView5 != null) {
                                        textView5.setVisibility(0);
                                        Button button3 = this.activateWatch;
                                        if (button3 != null) {
                                            button3.setVisibility(4);
                                            ProgressBar progressBar3 = this.progressbar;
                                            if (progressBar3 != null) {
                                                progressBar3.setVisibility(8);
                                                return;
                                            } else {
                                                Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                                                throw null;
                                            }
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException("activateWatch");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("watchStatus");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("watchStatus");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("strongerVibration");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("calibration");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("skuImage");
                    throw null;
                }
                ImageView imageView4 = this.skuImage;
                if (imageView4 != null) {
                    imageView4.setAlpha(1.0f);
                    SectionLayout sectionLayout7 = this.calibration;
                    if (sectionLayout7 != null) {
                        LayoutState layoutState4 = LayoutState.Enabled;
                        sectionLayout7.setLayoutState(layoutState4);
                        SectionLayout sectionLayout8 = this.strongerVibration;
                        if (sectionLayout8 != null) {
                            sectionLayout8.setLayoutState(layoutState4);
                            TextView textView6 = this.watchStatus;
                            if (textView6 != null) {
                                textView6.setText(getString(R.string.watch_status_connected));
                                TextView textView7 = this.watchStatus;
                                if (textView7 != null) {
                                    textView7.setVisibility(0);
                                    Button button4 = this.activateWatch;
                                    if (button4 != null) {
                                        button4.setVisibility(4);
                                        ProgressBar progressBar4 = this.progressbar;
                                        if (progressBar4 != null) {
                                            progressBar4.setVisibility(8);
                                            return;
                                        } else {
                                            Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                                            throw null;
                                        }
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("activateWatch");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("watchStatus");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("watchStatus");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("strongerVibration");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("calibration");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("skuImage");
                throw null;
            }
            ImageView imageView5 = this.skuImage;
            if (imageView5 != null) {
                imageView5.setAlpha(1.0f);
                SectionLayout sectionLayout9 = this.calibration;
                if (sectionLayout9 != null) {
                    LayoutState layoutState5 = LayoutState.Disabled;
                    sectionLayout9.setLayoutState(layoutState5);
                    SectionLayout sectionLayout10 = this.strongerVibration;
                    if (sectionLayout10 != null) {
                        sectionLayout10.setLayoutState(layoutState5);
                        TextView textView8 = this.watchStatus;
                        if (textView8 != null) {
                            textView8.setText(getString(R.string.watch_status_connected));
                            TextView textView9 = this.watchStatus;
                            if (textView9 != null) {
                                textView9.setVisibility(0);
                                Button button5 = this.activateWatch;
                                if (button5 != null) {
                                    button5.setVisibility(4);
                                    ProgressBar progressBar5 = this.progressbar;
                                    if (progressBar5 != null) {
                                        progressBar5.setVisibility(8);
                                        return;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("progressbar");
                                        throw null;
                                    }
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("activateWatch");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("watchStatus");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("watchStatus");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("strongerVibration");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("calibration");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("skuImage");
            throw null;
        }
    }

    private final void setupUpdateWatch() {
        SectionLayout sectionLayout = this.watchUpdate;
        if (sectionLayout != null) {
            sectionLayout.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WatchSettingsFragment.setupUpdateWatch$lambda$15(WatchSettingsFragment.this, view);
                }
            });
        } else {
            Intrinsics.throwUninitializedPropertyAccessException(BaseWatchUpdateFragment.NAME);
            throw null;
        }
    }

    public static final void setupUpdateWatch$lambda$15(WatchSettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isRunningDfuReady) {
            this$0.updateWatchClicked = true;
            SectionLayout sectionLayout = this$0.watchUpdate;
            if (sectionLayout != null) {
                sectionLayout.setLayoutState(LayoutState.Disabled);
                SectionLayout sectionLayout2 = this$0.watchUpdate;
                if (sectionLayout2 != null) {
                    sectionLayout2.showProgressBar(true);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException(BaseWatchUpdateFragment.NAME);
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException(BaseWatchUpdateFragment.NAME);
            throw null;
        }
        this$0.getMainController().gotoNextFragment(WatchUpdateFragmentFactory.INSTANCE.getWatchUpdateFragment$secondo_kronabyRelease(ProviderFactory.getWatch().getFirmwareUpdate()));
    }

    private final void showWatchUpdateMenu() {
        SectionLayout sectionLayout = this.watchUpdate;
        if (sectionLayout != null) {
            sectionLayout.setVisibility(0);
            sectionLayout.setLayoutState(LayoutState.Enabled);
            sectionLayout.setDescriptionText(getString(R.string.dashboard_dfu_failed_description));
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException(BaseWatchUpdateFragment.NAME);
        throw null;
    }

    public final void showWatchUpdateStart() {
        SectionLayout sectionLayout = this.watchUpdate;
        if (sectionLayout != null) {
            sectionLayout.setVisibility(0);
            sectionLayout.setLayoutState(LayoutState.Enabled);
            sectionLayout.showProgressBar(false);
            sectionLayout.setDescriptionText(getString(R.string.dashboard_dfu_failed_description));
            if (this.updateWatchClicked) {
                this.updateWatchClicked = false;
                getMainController().gotoNextFragment(WatchUpdateFragmentFactory.INSTANCE.getWatchUpdateFragment$secondo_kronabyRelease(ProviderFactory.getWatch().getFirmwareUpdate()));
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException(BaseWatchUpdateFragment.NAME);
        throw null;
    }

    public final void showWatchUpdateWarning(String str) {
        SectionLayout sectionLayout = this.watchUpdate;
        if (sectionLayout != null) {
            sectionLayout.setVisibility(0);
            sectionLayout.setLayoutState(LayoutState.WarningDisabled);
            sectionLayout.showProgressBar(false);
            sectionLayout.setDescriptionText(str);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException(BaseWatchUpdateFragment.NAME);
        throw null;
    }

    public final void updateBatteryUI() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        WatchProvider watch = ProviderFactory.getWatch();
        int r4 = 8;
        if (watch.isConnected()) {
            String address = watch.getAddress();
            String str = this.address;
            if (str != null) {
                if (Intrinsics.areEqual(address, str) && watch.getCapabilities().getHasChargeableBattery()) {
                    Float percentage = this.batteryProvider.getPercentage();
                    if (percentage != null) {
                        float floatValue = percentage.floatValue();
                        TextView textView = this.batteryPercentage;
                        if (textView != null) {
                            boolean z6 = false;
                            textView.setVisibility(0);
                            ImageView imageView = this.batteryImage;
                            if (imageView != null) {
                                imageView.setVisibility(0);
                                ImageView imageView2 = this.batteryChargingImage;
                                if (imageView2 != null) {
                                    if (this.batteryProvider.isCharging()) {
                                        r4 = 0;
                                    }
                                    imageView2.setVisibility(r4);
                                    float floatValue2 = Float.valueOf(floatValue).floatValue();
                                    if (floatValue2 >= 0.95f && floatValue2 <= 1.0f) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        ImageView imageView3 = this.batteryImage;
                                        if (imageView3 != null) {
                                            imageView3.setImageResource(R.drawable.battery_green_95_100);
                                        } else {
                                            Intrinsics.throwUninitializedPropertyAccessException("batteryImage");
                                            throw null;
                                        }
                                    } else {
                                        float floatValue3 = Float.valueOf(floatValue).floatValue();
                                        if (floatValue3 >= 0.75f && floatValue3 <= 0.95f) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            ImageView imageView4 = this.batteryImage;
                                            if (imageView4 != null) {
                                                imageView4.setImageResource(R.drawable.battery_green_75_95);
                                            } else {
                                                Intrinsics.throwUninitializedPropertyAccessException("batteryImage");
                                                throw null;
                                            }
                                        } else {
                                            float floatValue4 = Float.valueOf(floatValue).floatValue();
                                            if (floatValue4 >= 0.5f && floatValue4 <= 0.75f) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                ImageView imageView5 = this.batteryImage;
                                                if (imageView5 != null) {
                                                    imageView5.setImageResource(R.drawable.battery_green_50_75);
                                                } else {
                                                    Intrinsics.throwUninitializedPropertyAccessException("batteryImage");
                                                    throw null;
                                                }
                                            } else {
                                                float floatValue5 = Float.valueOf(floatValue).floatValue();
                                                if (floatValue5 >= 0.3f && floatValue5 <= 0.5f) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    ImageView imageView6 = this.batteryImage;
                                                    if (imageView6 != null) {
                                                        imageView6.setImageResource(R.drawable.battery_green_30_50);
                                                    } else {
                                                        Intrinsics.throwUninitializedPropertyAccessException("batteryImage");
                                                        throw null;
                                                    }
                                                } else {
                                                    float floatValue6 = Float.valueOf(floatValue).floatValue();
                                                    if (floatValue6 >= 0.15f && floatValue6 <= 0.3f) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    if (z5) {
                                                        ImageView imageView7 = this.batteryImage;
                                                        if (imageView7 != null) {
                                                            imageView7.setImageResource(R.drawable.battery_yellow_15_30);
                                                        } else {
                                                            Intrinsics.throwUninitializedPropertyAccessException("batteryImage");
                                                            throw null;
                                                        }
                                                    } else {
                                                        float floatValue7 = Float.valueOf(floatValue).floatValue();
                                                        if (floatValue7 >= 0.0f && floatValue7 <= 0.15f) {
                                                            z6 = true;
                                                        }
                                                        if (z6) {
                                                            ImageView imageView8 = this.batteryImage;
                                                            if (imageView8 != null) {
                                                                imageView8.setImageResource(R.drawable.battery_red_0_15);
                                                            } else {
                                                                Intrinsics.throwUninitializedPropertyAccessException("batteryImage");
                                                                throw null;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    TextView textView2 = this.batteryPercentage;
                                    if (textView2 != null) {
                                        textView2.setText(this.percentageFormat.format(floatValue));
                                        return;
                                    } else {
                                        Intrinsics.throwUninitializedPropertyAccessException("batteryPercentage");
                                        throw null;
                                    }
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("batteryChargingImage");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("batteryImage");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("batteryPercentage");
                        throw null;
                    }
                    return;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException(addressBundleKey);
                throw null;
            }
        }
        TextView textView3 = this.batteryPercentage;
        if (textView3 != null) {
            textView3.setVisibility(8);
            ImageView imageView9 = this.batteryImage;
            if (imageView9 != null) {
                imageView9.setVisibility(8);
                ImageView imageView10 = this.batteryChargingImage;
                if (imageView10 != null) {
                    imageView10.setVisibility(8);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("batteryChargingImage");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("batteryImage");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("batteryPercentage");
        throw null;
    }

    private final void updateDfuReady() {
        this.isRunningDfuReady = true;
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new WatchSettingsFragment$updateDfuReady$1(this, null), 3).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$updateDfuReady$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                WatchSettingsFragment.this.isRunningDfuReady = false;
            }
        });
    }

    public static final void updateListener$lambda$12(WatchSettingsFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateWatchUpdateUi();
    }

    private final void updateLostwatchUi(boolean z, boolean z2) {
        if (!isAdded()) {
            return;
        }
        if (z) {
            SectionLayout sectionLayout = this.lostWatch;
            if (sectionLayout != null) {
                sectionLayout.setDescriptionText(getString(R.string.lost_watch_warning_no_location));
                sectionLayout.setLayoutState(LayoutState.WarningDisabled);
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("lostWatch");
                throw null;
            }
        }
        if (z2) {
            SectionLayout sectionLayout2 = this.lostWatch;
            if (sectionLayout2 != null) {
                sectionLayout2.setDescriptionText(getString(R.string.lost_watch_warning_location_off));
                sectionLayout2.setLayoutState(LayoutState.WarningEnabled);
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("lostWatch");
                throw null;
            }
        }
        SectionLayout sectionLayout3 = this.lostWatch;
        if (sectionLayout3 != null) {
            sectionLayout3.setDescriptionText(getString(R.string.settings_lost_watch_descripton_text));
            sectionLayout3.setLayoutState(LayoutState.Enabled);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("lostWatch");
            throw null;
        }
    }

    private final void updateWatchUpdateUi() {
        if (!this.isRunningDfuReady && isCurrentActiveWatch()) {
            FirmwareUpdate firmwareUpdate = ProviderFactory.getWatch().getFirmwareUpdate();
            if (firmwareUpdate == FirmwareUpdate.FOTA) {
                updateWatchUpdateUiFota();
                return;
            }
            if (firmwareUpdate.isDfu()) {
                updateWatchUpdateUiDfu();
                return;
            }
            SectionLayout sectionLayout = this.watchUpdate;
            if (sectionLayout != null) {
                sectionLayout.setVisibility(8);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException(BaseWatchUpdateFragment.NAME);
                throw null;
            }
        }
    }

    private final void updateWatchUpdateUiDfu() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (ProviderFactory.getWatch().isInDfuMode()) {
            if (!this.watchUpdateProvider.isPhoneBatteryOKForUpdate(context)) {
                showWatchUpdateWarning(context.getString(R.string.watch_update_error_phone_battery_to_low));
                return;
            } else {
                showWatchUpdateStart();
                return;
            }
        }
        if (this.dfuProvider.isDfuAvailable() || ProviderFactory.getWatch().isInUpdateRequired()) {
            showWatchUpdateMenu();
            if (!ConnectionFactory.getConnection().isEnabled()) {
                showWatchUpdateWarning(context.getString(R.string.watch_update_error_bluetooth_off));
                return;
            }
            if (!this.watchProvider.isConnected() && !this.watchProvider.isInUpdateRequired()) {
                showWatchUpdateWarning(context.getString(R.string.watch_update_error_disconnected));
            } else if (!this.watchUpdateProvider.isPhoneBatteryOKForUpdate(context)) {
                showWatchUpdateWarning(context.getString(R.string.watch_update_error_phone_battery_to_low));
            } else {
                updateDfuReady();
            }
        }
    }

    private final void updateWatchUpdateUiFota() {
        Context context = getContext();
        if (context != null && this.fotaProvider.isReadyToPerformFota()) {
            showWatchUpdateMenu();
            if (!ConnectionFactory.getConnection().isEnabled()) {
                showWatchUpdateWarning(context.getString(R.string.watch_update_error_bluetooth_off));
            } else if (!ProviderFactory.getWatch().isConnected()) {
                showWatchUpdateWarning(context.getString(R.string.watch_update_error_disconnected));
            } else {
                updateDfuReady();
            }
        }
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
        return "Watch Settings";
    }

    public final WatchManager getWatchManager() {
        return this.watchManager;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4) {
        return new int[0];
    }

    public final WatchProvider getWatchProvider() {
        return this.watchProvider;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return 1;
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        this.handler.removeCallbacks(this.disconnectRunnable);
        setState(WatchState.Connected);
        updateBatteryUI();
        updateWatchUpdateUi();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnecting() {
        this.handler.removeCallbacks(this.disconnectRunnable);
        setState(WatchState.Connecting);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        boolean z;
        String sb;
        int r1;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(addressBundleKey);
        } else {
            str = null;
        }
        if (str != null) {
            this.address = str;
            if (bundle != null) {
                z = bundle.getBoolean(saveStateJustActivated);
            } else {
                z = false;
            }
            this.justActivatedWatch = z;
            WatchManager watchManager = this.watchManager;
            String str2 = this.address;
            if (str2 != null) {
                final Watch watch = watchManager.getWatch(str2);
                if (watch != null) {
                    View inflate = inflater.inflate(R.layout.fragment_watch_settings, viewGroup, false);
                    inflate.findViewById(R.id.touch_area_help_button).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WatchSettingsFragment.onCreateView$lambda$8$lambda$1(WatchSettingsFragment.this, view);
                        }
                    });
                    ((RelativeLayout) inflate.findViewById(R.id.image_container)).getLayoutTransition().enableTransitionType(4);
                    TextView textView = (TextView) inflate.findViewById(R.id.watch_settings_title);
                    ProductInfoProvider productInfoProvider = ProductInfoProvider.INSTANCE;
                    ProductInfoData data = productInfoProvider.getData(watch.getSku());
                    if (data == null || (sb = data.getCoreUnitDisplayName()) == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(inflate.getContext().getString(R.string.watch_brand));
                        sb2.append(' ');
                        String str3 = this.address;
                        if (str3 != null) {
                            sb2.append(StringsKt___StringsKt.takeLast(4, StringsKt__StringsJVMKt.replace$default(str3, ":", "")));
                            sb = sb2.toString();
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException(addressBundleKey);
                            throw null;
                        }
                    }
                    textView.setText(sb);
                    View findViewById = inflate.findViewById(R.id.watch_settings_update);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                    this.watchUpdate = (SectionLayout) findViewById;
                    setupUpdateWatch();
                    View findViewById2 = inflate.findViewById(R.id.watch_status);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                    this.watchStatus = (TextView) findViewById2;
                    View findViewById3 = inflate.findViewById(R.id.connecting_progressbar);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                    this.progressbar = (ProgressBar) findViewById3;
                    View findViewById4 = inflate.findViewById(R.id.activate_watch);
                    Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
                    Button button = (Button) findViewById4;
                    this.activateWatch = button;
                    button.setOnClickListener(new CampaignFragment$$ExternalSyntheticLambda0(this, 1));
                    View findViewById5 = inflate.findViewById(R.id.watch_settings_battery_flash_image);
                    Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
                    this.batteryChargingImage = (ImageView) findViewById5;
                    View findViewById6 = inflate.findViewById(R.id.watch_settings_battery_image);
                    Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
                    this.batteryImage = (ImageView) findViewById6;
                    View findViewById7 = inflate.findViewById(R.id.watch_settings_battery_percent);
                    Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
                    this.batteryPercentage = (TextView) findViewById7;
                    View findViewById8 = inflate.findViewById(R.id.sku_image);
                    Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
                    this.skuImage = (ImageView) findViewById8;
                    WatchImageType watchImageType = WatchImageType.THUMBNAIL;
                    Bitmap image = productInfoProvider.getImage(watchImageType, watch.getSku());
                    if (image != null) {
                        ImageView imageView = this.skuImage;
                        if (imageView != null) {
                            imageView.setImageBitmap(image);
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("skuImage");
                            throw null;
                        }
                    } else {
                        Bitmap bitmap = WatchImageModelFactory.getDefaultSketch(inflate.getContext(), watch.getWatchType(), watch.getFirmwareVariant()).get(watchImageType);
                        if (bitmap != null) {
                            ImageView imageView2 = this.skuImage;
                            if (imageView2 != null) {
                                imageView2.setImageBitmap(bitmap);
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("skuImage");
                                throw null;
                            }
                        }
                    }
                    View findViewById9 = inflate.findViewById(R.id.watch_settings_calibrate);
                    Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
                    SectionLayout sectionLayout = (SectionLayout) findViewById9;
                    this.calibration = sectionLayout;
                    sectionLayout.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WatchSettingsFragment.onCreateView$lambda$8$lambda$4(WatchSettingsFragment.this, view);
                        }
                    });
                    View findViewById10 = inflate.findViewById(R.id.watch_settings_stronger_vibration);
                    Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
                    SectionLayout sectionLayout2 = (SectionLayout) findViewById10;
                    this.strongerVibration = sectionLayout2;
                    if (watch.getCapabilities().getHasChargeableBattery()) {
                        r1 = R.string.settings_vibrations_chargable_description;
                    } else {
                        r1 = R.string.settings_vibrations_description;
                    }
                    sectionLayout2.setDescriptionText(getString(r1));
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            WatchSettingsFragment.onCreateView$lambda$8$lambda$5(WatchSettingsFragment.this, watch);
                        }
                    });
                    View findViewById11 = inflate.findViewById(R.id.watch_settings_lost_watch);
                    Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
                    SectionLayout sectionLayout3 = (SectionLayout) findViewById11;
                    this.lostWatch = sectionLayout3;
                    sectionLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$$ExternalSyntheticLambda7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WatchSettingsFragment.onCreateView$lambda$8$lambda$6(WatchSettingsFragment.this, view);
                        }
                    });
                    updateLostWatchMenu();
                    View findViewById12 = inflate.findViewById(R.id.watch_settings_forget_watch);
                    Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
                    SectionLayout sectionLayout4 = (SectionLayout) findViewById12;
                    this.forgetWatch = sectionLayout4;
                    sectionLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.WatchSettingsFragment$$ExternalSyntheticLambda8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WatchSettingsFragment.onCreateView$lambda$8$lambda$7(WatchSettingsFragment.this, view);
                        }
                    });
                    if (!isCurrentActiveWatch()) {
                        setState(WatchState.Inactive);
                    }
                    return inflate;
                }
                throw new RuntimeException("No device");
            }
            Intrinsics.throwUninitializedPropertyAccessException(addressBundleKey);
            throw null;
        }
        throw new RuntimeException("No address");
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        setState(WatchState.Disconnected);
        updateBatteryUI();
        updateWatchUpdateUi();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        setState(WatchState.InDfu);
        updateWatchUpdateUi();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterUpdateRequired() {
        setState(WatchState.InDfu);
        updateWatchUpdateUi();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveDfuMode() {
        setState(WatchState.Disconnected);
        updateWatchUpdateUi();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveUpdateRequired() {
        setState(WatchState.Disconnected);
        updateWatchUpdateUi();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Context context;
        super.onPause();
        this.handler.removeCallbacks(this.disconnectRunnable);
        this.watchProvider.unregisterDeviceConnectionListener(this);
        this.batteryProvider.unregisterBatteryListener(this.batteryListener);
        ConnectionFactory.getConnection().removeConnectionListener(this.connectionListener);
        this.backgroundUpdateChecker.unregisterListener(this.updateListener);
        if (ProviderFactory.getLostWatchProvider().isEnabled() && (context = getContext()) != null) {
            context.unregisterReceiver(this.gpsSwitchStateReceiver);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.watchProvider.registerDeviceConnectionListener(this);
        if (this.justActivatedWatch) {
            this.justActivatedWatch = false;
            setState(WatchState.Connecting);
            this.handler.postDelayed(this.disconnectRunnable, 7000L);
        } else if (this.watchProvider.isConnected()) {
            onConnected();
        } else if (this.watchProvider.isInDfuMode()) {
            onEnterDfuMode();
        } else if (this.watchProvider.isInUpdateRequired()) {
            onEnterUpdateRequired();
        } else {
            onDisconnected();
        }
        updateBatteryUI();
        this.batteryProvider.registerBatteryListener(this.batteryListener);
        updateWatchUpdateUi();
        ConnectionFactory.getConnection().addConnectionListener(this.connectionListener);
        this.backgroundUpdateChecker.registerListener(this.updateListener);
        if (ProviderFactory.getLostWatchProvider().isEnabled()) {
            Context context = getContext();
            if (context != null) {
                context.registerReceiver(this.gpsSwitchStateReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
            }
            updateLostWatchMenu();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean(saveStateJustActivated, this.justActivatedWatch);
        super.onSaveInstanceState(outState);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:            if (r0.hasStoredLocation(r1) == false) goto L68;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateLostWatchMenu() {
        /*
            r6 = this;
            com.animaconnected.secondo.provider.lostwatch.LostWatchProvider r0 = com.animaconnected.secondo.provider.ProviderFactory.getLostWatchProvider()
            com.animaconnected.watch.WatchProvider r1 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            boolean r1 = r1.isConnected()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L18
            boolean r1 = com.animaconnected.secondo.provider.location.AndroidLocationBackend.isLocationEnabled()
            if (r1 != 0) goto L18
            r1 = r2
            goto L19
        L18:
            r1 = r3
        L19:
            com.animaconnected.watch.WatchProvider r4 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            boolean r4 = r4.isConnected()
            if (r4 != 0) goto L33
            boolean r4 = com.animaconnected.secondo.provider.location.AndroidLocationBackend.isLocationEnabled()
            if (r4 != 0) goto L33
            com.animaconnected.secondo.provider.lostwatch.LostWatchProvider$FetchStatus r4 = r0.getStatus()
            com.animaconnected.secondo.provider.lostwatch.LostWatchProvider$FetchStatus r5 = com.animaconnected.secondo.provider.lostwatch.LostWatchProvider.FetchStatus.IDLE
            if (r4 == r5) goto L33
            r4 = r2
            goto L34
        L33:
            r4 = r3
        L34:
            if (r1 != 0) goto L3b
            if (r4 == 0) goto L39
            goto L3b
        L39:
            r1 = r3
            goto L3c
        L3b:
            r1 = r2
        L3c:
            r6.showTurnOnLocation = r1
            com.animaconnected.watch.WatchProvider r1 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            boolean r1 = r1.isConnected()
            if (r1 != 0) goto L62
            com.animaconnected.secondo.provider.lostwatch.LostWatchProvider$FetchStatus r1 = r0.getStatus()
            com.animaconnected.secondo.provider.lostwatch.LostWatchProvider$FetchStatus r4 = com.animaconnected.secondo.provider.lostwatch.LostWatchProvider.FetchStatus.IDLE
            if (r1 != r4) goto L62
            java.lang.String r1 = r6.address
            if (r1 == 0) goto L5b
            boolean r0 = r0.hasStoredLocation(r1)
            if (r0 != 0) goto L62
            goto L63
        L5b:
            java.lang.String r0 = "address"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
            throw r0
        L62:
            r2 = r3
        L63:
            boolean r0 = r6.showTurnOnLocation
            r6.updateLostwatchUi(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.WatchSettingsFragment.updateLostWatchMenu():void");
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4, int r5) {
        return new int[0];
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r1) {
    }
}
