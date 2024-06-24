package com.animaconnected.secondo.screens.watchupdate.updateinfo;

import android.util.Log;
import com.animaconnected.watch.device.FirmwareUpdate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class UpdateHelper {
    private static final String TAG = "UpdateHelper";
    private static final SimpleDateFormat sSimpleFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);

    /* renamed from: com.animaconnected.secondo.screens.watchupdate.updateinfo.UpdateHelper$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$animaconnected$watch$device$FirmwareUpdate;

        static {
            int[] r0 = new int[FirmwareUpdate.values().length];
            $SwitchMap$com$animaconnected$watch$device$FirmwareUpdate = r0;
            try {
                r0[FirmwareUpdate.DFU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$animaconnected$watch$device$FirmwareUpdate[FirmwareUpdate.DFU15.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$animaconnected$watch$device$FirmwareUpdate[FirmwareUpdate.FOTA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static Date firmwareRevisionToDate(String str) {
        if (str == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = sSimpleFormat;
        int length = simpleDateFormat.toPattern().length();
        if (str.length() >= length) {
            try {
                return simpleDateFormat.parse(str.substring(0, length));
            } catch (ParseException unused) {
                Log.d(TAG, "Couldn't parse " + str + "to a date, wrong format.");
            }
        } else {
            Log.d(TAG, "Couldn't parse " + str + "to a date, wrong prefix.");
        }
        return null;
    }

    public static List<Update> getUpdatesBetweenDates(List<Update> list, Date date, Date date2) {
        ArrayList arrayList = new ArrayList();
        if (date != null && date2 != null) {
            for (Update update : list) {
                Date date3 = update.getDate();
                if (date3 != null && date3.compareTo(date) > 0 && date3.compareTo(date2) <= 0) {
                    arrayList.add(update);
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        return arrayList;
    }

    public static boolean isFWLatestOrLater(String str, FirmwareUpdate firmwareUpdate) {
        Date firmwareRevisionToDate = firmwareRevisionToDate(str);
        if (firmwareRevisionToDate == null) {
            return false;
        }
        int r4 = AnonymousClass1.$SwitchMap$com$animaconnected$watch$device$FirmwareUpdate[firmwareUpdate.ordinal()];
        if (r4 != 1) {
            if (r4 != 2) {
                if (r4 != 3 || firmwareRevisionToDate.compareTo(firmwareRevisionToDate(Update.LATEST_LIVE_FOTA_FW)) < 0) {
                    return false;
                }
                return true;
            }
            if (firmwareRevisionToDate.compareTo(firmwareRevisionToDate(Update.LATEST_LIVE_DFU15_FW)) < 0) {
                return false;
            }
            return true;
        }
        if (firmwareRevisionToDate.compareTo(firmwareRevisionToDate(Update.LATEST_LIVE_DFU8_FW)) < 0) {
            return false;
        }
        return true;
    }
}
