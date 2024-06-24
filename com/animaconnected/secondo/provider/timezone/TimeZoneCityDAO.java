package com.animaconnected.secondo.provider.timezone;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.kronaby.watch.app.R;
import j$.util.DesugarTimeZone;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
final class TimeZoneCityDAO {
    private static final Pattern NUMERIC_INDEX_REGEX = Pattern.compile("\\d+");

    private TimeZoneCityDAO() {
    }

    private static TimeZoneCity createCity(Resources resources, String str, String str2, TimeZone timeZone) {
        String str3;
        String str4;
        int r1;
        String string;
        String[] split = str2.split("[=:]");
        String str5 = split[1];
        if (TextUtils.isEmpty(split[0])) {
            str3 = str5.substring(0, 1);
        } else {
            str3 = split[0];
        }
        String str6 = str3;
        if (split.length == 3) {
            str4 = split[2];
        } else {
            str4 = str5;
        }
        Matcher matcher = NUMERIC_INDEX_REGEX.matcher(str6);
        if (matcher.find()) {
            r1 = Integer.parseInt(matcher.group());
        } else {
            r1 = -1;
        }
        int r5 = r1;
        long rawOffset = timeZone.getRawOffset();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long abs = Math.abs(timeUnit.toHours(rawOffset));
        long abs2 = Math.abs(timeUnit.toMinutes(rawOffset % TimeUnit.HOURS.toMillis(1L)));
        if (rawOffset > 0) {
            string = resources.getString(R.string.GMT_offset_positive, Long.valueOf(abs), Long.valueOf(abs2));
        } else if (rawOffset == 0) {
            string = resources.getString(R.string.GMT_offset_zero);
        } else {
            string = resources.getString(R.string.GMT_offset_negative, Long.valueOf(abs), Long.valueOf(abs2));
        }
        return new TimeZoneCity(str, r5, str6, str5, str4, timeZone, string);
    }

    private static Set<String> getAvailableTimeZoneIDs() {
        String[] availableIDs = TimeZone.getAvailableIDs();
        HashSet hashSet = new HashSet(availableIDs.length);
        Collections.addAll(hashSet, availableIDs);
        return Collections.unmodifiableSet(hashSet);
    }

    public static Map<String, TimeZoneCity> getCities(Resources resources) {
        TypedArray obtainTypedArray = resources.obtainTypedArray(R.array.city_ids);
        int length = obtainTypedArray.length();
        Set<String> availableTimeZoneIDs = getAvailableTimeZoneIDs();
        ArrayMap arrayMap = new ArrayMap(length);
        for (int r5 = 0; r5 < length; r5++) {
            try {
                int resourceId = obtainTypedArray.getResourceId(r5, 0);
                if (resourceId != 0) {
                    String resourceEntryName = resources.getResourceEntryName(resourceId);
                    String string = obtainTypedArray.getString(r5);
                    if (string != null) {
                        String[] split = string.split("[|]");
                        if (split.length == 2) {
                            String str = split[1];
                            if (availableTimeZoneIDs.contains(str)) {
                                TimeZoneCity createCity = createCity(resources, resourceEntryName, split[0], DesugarTimeZone.getTimeZone(str));
                                arrayMap.put(createCity.getTimeZone().getID(), createCity);
                            }
                        } else {
                            throw new IllegalStateException(String.format("Error parsing malformed city %s", string));
                        }
                    } else {
                        throw new IllegalStateException(String.format("Unable to locate city with id %s", resourceEntryName));
                    }
                } else {
                    throw new IllegalStateException(String.format(Locale.ENGLISH, "Unable to locate city resource id for index %d", Integer.valueOf(r5)));
                }
            } catch (Throwable th) {
                obtainTypedArray.recycle();
                throw th;
            }
        }
        obtainTypedArray.recycle();
        return Collections.unmodifiableMap(arrayMap);
    }
}
