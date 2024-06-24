package com.animaconnected.secondo.behaviour.time;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.content.ContextCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.TimeChangedReceiver;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.timezone.TimeZoneCity;
import com.animaconnected.secondo.provider.timezone.TimeZoneProvider;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.WatchFaceBehavior;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Scale;
import com.animaconnected.watch.device.WatchConstants;
import com.animaconnected.watch.device.WatchConstantsKt;
import com.animaconnected.watch.device.WatchFace;
import com.kronaby.watch.app.R;
import j$.util.DesugarTimeZone;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class Time extends WatchFaceBehavior {
    private static final String BEHAVIOUR_ANALYTICS_NAME = "secondary_time";
    private static final String HOME_TIMEZONE_CHANGED_FROM = "HomeTimeZone_changed_from";
    private static final String HOME_TIMEZONE_CHANGED_TO = "HomeTimeZone_changed_to";
    private static final long REFRESH_INTERVAL = 1000;
    private static final String SETTINGS_HOME_TIME_ZONE = "homeTimeZone";
    private static final String SETTINGS_TIME_ZONE = "timeZone";
    private static final String TAG = "Time";
    private static final int TIME_NOTIFICATION_ID = 17070999;
    public static final String TYPE = "Time";
    private final Context mContext;
    private Slot mCurrentSlot = Slot.Unknown;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mRefreshRunnable = new Runnable() { // from class: com.animaconnected.secondo.behaviour.time.Time.1
        @Override // java.lang.Runnable
        public void run() {
            Time.this.refresh();
            Time.this.mHandler.postDelayed(this, Time.REFRESH_INTERVAL);
        }
    };
    private boolean mRegisteredReceiver;
    private final WatchProvider mWatchProvider;

    public Time(Context context, WatchProvider watchProvider) {
        this.mContext = context;
        this.mWatchProvider = watchProvider;
        initSettings();
    }

    private static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
    }

    private void initSettings() {
        TimeZoneProvider provider = TimeZoneProvider.getProvider(this.mContext);
        if (getTimezoneId() != null && !provider.hasDataFor(getTimezoneId())) {
            setTimezoneId(matchingTimeZoneOrDefault(provider, getTimezoneId()));
        }
        if (getHomeTimezoneId() != null && !provider.hasDataFor(getHomeTimezoneId())) {
            setHomeTimezoneId(matchingTimeZoneOrDefault(provider, getHomeTimezoneId()));
        }
        TimeZone timeZone = TimeZone.getDefault();
        if (getTimezoneId() == null) {
            if (timeZone.getDisplayName().equalsIgnoreCase(DesugarTimeZone.getTimeZone(WatchConstants.DEFAULT_SECONDTIMEZONE).getDisplayName())) {
                setTimezoneId(WatchConstants.DEFAULT_SECONDTIMEZONE_IN_DEFAULT_SECONDTIMEZONE);
            } else {
                setTimezoneId(WatchConstants.DEFAULT_SECONDTIMEZONE);
            }
        }
        if (getHomeTimezoneId() == null) {
            setHomeTimezoneId(matchingTimeZoneOrDefault(provider, timeZone.getID()));
        }
    }

    private String matchingTimeZoneOrDefault(TimeZoneProvider timeZoneProvider, String str) {
        TimeZoneCity timeZoneCity;
        TimeZone timeZone = DesugarTimeZone.getTimeZone(str);
        if (timeZone != null) {
            timeZoneCity = timeZoneProvider.getCityBestMatchingTimeZone(timeZone);
        } else {
            timeZoneCity = null;
        }
        if (timeZoneCity != null) {
            return timeZoneCity.getTimeZone().getID();
        }
        return WatchConstants.DEFAULT_SECONDTIMEZONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        notifyDataChanged();
    }

    private void registerTimeZoneReceiver() {
        if (!this.mRegisteredReceiver) {
            ContextCompat.registerReceiver(KronabyApplication.getContext(), new BroadcastReceiver() { // from class: com.animaconnected.secondo.behaviour.time.Time.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TimeChangedReceiver.HOME_TIMEZONE_CHANGED_INTENT.equals(intent.getAction()) && Time.this.mCurrentSlot != Slot.Unknown) {
                        Time.this.onTimeZoneChanged();
                    }
                }
            }, new IntentFilter(TimeChangedReceiver.HOME_TIMEZONE_CHANGED_INTENT), 4);
            this.mRegisteredReceiver = true;
        }
    }

    private static void showNotification(Context context, String str) {
        NotificationManager notificationManager = getNotificationManager(context);
        Intent createStartApplicationIntent = KronabyApplication.createStartApplicationIntent();
        createStartApplicationIntent.setFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(context, 0, createStartApplicationIntent, AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(context.getString(R.string.notification_time_title));
        NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
        notificationCompat$BigTextStyle.bigText(str);
        createNotificationBuilder.setStyle(notificationCompat$BigTextStyle);
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.mContentIntent = activity;
        createNotificationBuilder.setFlag(16, true);
        notificationManager.notify(TIME_NOTIFICATION_ID, createNotificationBuilder.build());
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void activate(Slot slot) {
        super.activate(slot);
        this.mCurrentSlot = slot;
        registerTimeZoneReceiver();
        this.mWatchProvider.setTimeZoneId(getActiveTimezone().getID());
        if (isHomeTimezoneActive()) {
            ProviderFactory.getAppAnalytics().sendAction(HOME_TIMEZONE_CHANGED_TO);
        }
        Log.d(TAG, "Set timezone in device data. Timezone: " + getActiveTimezone().getID());
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return Arrays.asList(Scale.ZeroToTwentyFour, Scale.ZeroToTwelve);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.SubComplication1, Slot.SubComplication2, Slot.MainComplication, Slot.MainComplicationDouble};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void deactivated(Slot slot) {
        super.deactivated(slot);
        this.mCurrentSlot = Slot.Unknown;
    }

    public TimeZone getActiveTimezone() {
        if (isHomeTimezoneActive()) {
            return getHomeTimezone();
        }
        return getTimezone();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return BEHAVIOUR_ANALYTICS_NAME;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public int getDeviceComplicationMode() {
        return 1;
    }

    public TimeZone getHomeTimezone() {
        return DesugarTimeZone.getTimeZone(getHomeTimezoneId());
    }

    public String getHomeTimezoneId() {
        return this.mContext.getSharedPreferences(TYPE, 0).getString(SETTINGS_HOME_TIME_ZONE, null);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getHoursInDegrees() {
        return getHoursInDegrees(this.mCurrentSlot);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getMinutesInDegrees() {
        return (new GregorianCalendar(getActiveTimezone()).get(12) / 60.0f) * 360.0f;
    }

    public TimeZone getTimezone() {
        return DesugarTimeZone.getTimeZone(getTimezoneId());
    }

    public String getTimezoneId() {
        return this.mContext.getSharedPreferences(TYPE, 0).getString(SETTINGS_TIME_ZONE, null);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return TYPE;
    }

    public boolean isHomeTimezoneActive() {
        if (TimeStorage.getHomeTimezoneEnabled(this.mContext)) {
            return !Calendar.getInstance().getTimeZone().getDisplayName().equalsIgnoreCase(DesugarTimeZone.getTimeZone(getHomeTimezoneId()).getDisplayName());
        }
        return false;
    }

    public void onTimeZoneChanged() {
        if (TimeStorage.getHomeTimezoneEnabled(this.mContext)) {
            TimeZoneProvider provider = TimeZoneProvider.getProvider(this.mContext);
            String displayName = TimeZone.getDefault().getDisplayName();
            TimeZone timeZone = DesugarTimeZone.getTimeZone(getHomeTimezoneId());
            if (!displayName.equalsIgnoreCase(timeZone.getDisplayName())) {
                provider.setUserHasLeftHomeTimeZone(true);
                setDeviceTimezoneId(getHomeTimezone().getID());
                TimeZoneCity cityByTimeZone = provider.getCityByTimeZone(timeZone);
                ProviderFactory.getAppAnalytics().sendAction(HOME_TIMEZONE_CHANGED_TO);
                Context context = this.mContext;
                showNotification(context, context.getString(R.string.notification_home_timezone_description, cityByTimeZone.getName()));
                return;
            }
            if (provider.hasUserLeftHomeTimeZone()) {
                provider.setUserHasLeftHomeTimeZone(false);
                TimeZone timezone = getTimezone();
                setDeviceTimezoneId(timezone.getID());
                TimeZoneCity cityByTimeZone2 = provider.getCityByTimeZone(timezone);
                ProviderFactory.getAppAnalytics().sendAction(HOME_TIMEZONE_CHANGED_FROM);
                Context context2 = this.mContext;
                showNotification(context2, context2.getString(R.string.notification_timezone_description, cityByTimeZone2.getName()));
            }
        }
    }

    public void setDeviceTimezoneId(String str) {
        this.mWatchProvider.setTimeZoneId(str);
    }

    public void setHomeTimezoneId(String str) {
        this.mContext.getSharedPreferences(TYPE, 0).edit().putString(SETTINGS_HOME_TIME_ZONE, str).apply();
    }

    public void setTimezoneId(String str) {
        this.mContext.getSharedPreferences(TYPE, 0).edit().putString(SETTINGS_TIME_ZONE, str).apply();
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void startRefreshing() {
        this.mHandler.post(this.mRefreshRunnable);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void stopRefreshing() {
        this.mHandler.removeCallbacks(this.mRefreshRunnable);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getHoursInDegrees(Slot slot) {
        int r4;
        if (slot == Slot.SubComplication1 || slot == Slot.SubComplication2) {
            Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
            WatchFace watchFace = WatchConstantsKt.toWatchFace(slot);
            if (!capabilities.hasScaleOnWatchFace(watchFace, Scale.ZeroToTwelve)) {
                if (capabilities.hasScaleOnWatchFace(watchFace, Scale.ZeroToTwentyFour)) {
                    r4 = 24;
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(getActiveTimezone());
                    return (((gregorianCalendar.get(12) / 60.0f) + (gregorianCalendar.get(11) % r4)) / r4) * 360.0f;
                }
                throw new RuntimeException("Slot put on unsupported watch face");
            }
        }
        r4 = 12;
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(getActiveTimezone());
        return (((gregorianCalendar2.get(12) / 60.0f) + (gregorianCalendar2.get(11) % r4)) / r4) * 360.0f;
    }
}
