package com.animaconnected.secondo.provider.timezone;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.amplifyframework.core.model.ModelIdentifier;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.timezone.TimeZoneCity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public final class TimeZoneProvider {
    private static final String TAG = "TimeZoneProvider";
    private static TimeZoneProvider sCached;
    private static Locale sLocaleForCached;
    private List<TimeZoneCity> mCitiesRawOffsetOrder;
    private final Map<String, TimeZoneCity> mTZIdCities;
    private boolean mUserTimeZoneChanged;

    private TimeZoneProvider(Resources resources) {
        this.mTZIdCities = TimeZoneCityDAO.getCities(resources);
    }

    public static TimeZoneProvider getProvider(Context context) {
        Locale userLocale = ProviderFactory.createConfigProvider().getUserLocale();
        if (sCached == null || !sLocaleForCached.equals(userLocale)) {
            sCached = new TimeZoneProvider(context.getResources());
            sLocaleForCached = userLocale;
        }
        return sCached;
    }

    private static String timeZoneIdArea(TimeZone timeZone) {
        String str = timeZone.getID();
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public List<TimeZoneCity> getCitiesRawOffsetOrder() {
        if (this.mCitiesRawOffsetOrder == null) {
            ArrayList arrayList = new ArrayList(this.mTZIdCities.values());
            Collections.sort(arrayList, new TimeZoneCity.UtcRawOffsetComparator());
            this.mCitiesRawOffsetOrder = Collections.unmodifiableList(arrayList);
        }
        return this.mCitiesRawOffsetOrder;
    }

    public TimeZoneCity getCityBestMatchingTimeZone(TimeZone timeZone) {
        int r6;
        TimeZoneCity timeZoneCity = this.mTZIdCities.get(timeZone.getID());
        if (timeZoneCity != null) {
            return timeZoneCity;
        }
        String timeZoneIdArea = timeZoneIdArea(timeZone);
        int r3 = 0;
        for (TimeZoneCity timeZoneCity2 : this.mTZIdCities.values()) {
            TimeZone timeZone2 = timeZoneCity2.getTimeZone();
            if (timeZone2.getRawOffset() == timeZone.getRawOffset()) {
                if (timeZone2.hasSameRules(timeZone)) {
                    r6 = 2;
                } else {
                    r6 = 1;
                }
                if (timeZoneIdArea(timeZone2).equalsIgnoreCase(timeZoneIdArea)) {
                    r6 += 2;
                }
                if (r6 > r3) {
                    timeZoneCity = timeZoneCity2;
                    r3 = r6;
                }
            }
        }
        return timeZoneCity;
    }

    public TimeZoneCity getCityByTimeZone(TimeZone timeZone) {
        TimeZoneCity timeZoneCity = this.mTZIdCities.get(timeZone.getID());
        if (timeZoneCity == null) {
            Log.d(TAG, "Doesn't support time zone \"" + timeZone.getID() + ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
        }
        return timeZoneCity;
    }

    public boolean hasDataFor(String str) {
        if (str != null && this.mTZIdCities.containsKey(str)) {
            return true;
        }
        return false;
    }

    public boolean hasUserLeftHomeTimeZone() {
        return this.mUserTimeZoneChanged;
    }

    public void setUserHasLeftHomeTimeZone(boolean z) {
        this.mUserTimeZoneChanged = z;
    }
}
