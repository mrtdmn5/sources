package com.polidea.rxandroidble2.utils;

import com.animaconnected.secondo.R;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class GattStatusParser {
    public static final Map<Integer, String> GATT_STATUS;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(0, "GATT_SUCCESS");
        hashMap.put(1, "GATT_INVALID_HANDLE");
        hashMap.put(2, "GATT_READ_NOT_PERMIT");
        hashMap.put(3, "GATT_WRITE_NOT_PERMIT");
        hashMap.put(4, "GATT_INVALID_PDU");
        hashMap.put(5, "GATT_INSUF_AUTHENTICATION");
        hashMap.put(6, "GATT_REQ_NOT_SUPPORTED");
        hashMap.put(7, "GATT_INVALID_OFFSET");
        hashMap.put(8, "GATT_INSUF_AUTHORIZATION or GATT_CONN_TIMEOUT");
        hashMap.put(9, "GATT_PREPARE_Q_FULL");
        hashMap.put(10, "GATT_NOT_FOUND");
        hashMap.put(11, "GATT_NOT_LONG");
        hashMap.put(12, "GATT_INSUF_KEY_SIZE");
        hashMap.put(13, "GATT_INVALID_ATTR_LEN");
        hashMap.put(14, "GATT_ERR_UNLIKELY");
        hashMap.put(15, "GATT_INSUF_ENCRYPTION");
        hashMap.put(16, "GATT_UNSUPPORT_GRP_TYPE");
        hashMap.put(17, "GATT_INSUF_RESOURCE");
        hashMap.put(19, "GATT_CONN_TERMINATE_PEER_USER");
        hashMap.put(22, "GATT_CONN_TERMINATE_LOCAL_HOST");
        hashMap.put(34, "GATT_CONN_LMP_TIMEOUT");
        hashMap.put(62, "GATT_CONN_FAIL_ESTABLISH");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryColumnColorActivity), "GATT_ILLEGAL_PARAMETER");
        hashMap.put(128, "GATT_NO_RESOURCES");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_statusTopStripeImportant), "GATT_INTERNAL_ERROR");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_statusTopStripeSetup), "GATT_WRONG_STATE");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryBackgroundActivity), "GATT_DB_FULL");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryBackgroundDetail), "GATT_BUSY");
        hashMap.put(133, "GATT_ERROR");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryBaseLineColorDetail), "GATT_CMD_STARTED");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryColumnColorDetail), "GATT_PENDING");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity), "GATT_AUTH_FAIL");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail), "GATT_MORE");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryFontActivity), "GATT_INVALID_CFG");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryFontDetail), "GATT_SERVICE_STARTED");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryGoalLegendColorActivity), "GATT_ENCRYPED_NO_MITM");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryGoalLegendColorDetail), "GATT_NOT_ENCRYPTED");
        hashMap.put(Integer.valueOf(R.styleable.AppTheme_stepsHistoryGoalLineColorActivity), "GATT_CONGESTED");
        hashMap.put(253, "GATT_CCC_CFG_ERR");
        hashMap.put(254, "GATT_PRC_IN_PROGRESS");
        hashMap.put(255, "GATT_OUT_OF_RANGE");
        hashMap.put(256, "GATT_CONN_CANCEL");
        GATT_STATUS = Collections.unmodifiableMap(hashMap);
    }
}
