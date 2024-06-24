package com.amazonaws.mobileconnectors.s3.transferutility;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ANY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public abstract class TransferNetworkConnectionType {
    private static final /* synthetic */ TransferNetworkConnectionType[] $VALUES;

    @SerializedName("ANY")
    public static final TransferNetworkConnectionType ANY;
    private static final Log LOGGER;
    private static final Map<String, TransferNetworkConnectionType> MAP;

    @SerializedName("MOBILE")
    public static final TransferNetworkConnectionType MOBILE;

    @SerializedName("WIFI")
    public static final TransferNetworkConnectionType WIFI;

    static {
        int r2 = 0;
        TransferNetworkConnectionType transferNetworkConnectionType = new TransferNetworkConnectionType("ANY", r2) { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType.1
            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType
            public boolean verify(NetworkInfo networkInfo) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    return true;
                }
                return false;
            }
        };
        ANY = transferNetworkConnectionType;
        TransferNetworkConnectionType transferNetworkConnectionType2 = new TransferNetworkConnectionType("WIFI", 1) { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType.2
            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType
            public boolean verify(NetworkInfo networkInfo) {
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1) {
                    return true;
                }
                return false;
            }
        };
        WIFI = transferNetworkConnectionType2;
        TransferNetworkConnectionType transferNetworkConnectionType3 = new TransferNetworkConnectionType("MOBILE", 2) { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType.3
            @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkConnectionType
            public boolean verify(NetworkInfo networkInfo) {
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 0) {
                    return true;
                }
                return false;
            }
        };
        MOBILE = transferNetworkConnectionType3;
        $VALUES = new TransferNetworkConnectionType[]{transferNetworkConnectionType, transferNetworkConnectionType2, transferNetworkConnectionType3};
        MAP = new HashMap();
        TransferNetworkConnectionType[] values = values();
        int length = values.length;
        while (r2 < length) {
            TransferNetworkConnectionType transferNetworkConnectionType4 = values[r2];
            MAP.put(transferNetworkConnectionType4.toString(), transferNetworkConnectionType4);
            r2++;
        }
        LOGGER = LogFactory.getLog((Class<?>) TransferNetworkConnectionType.class);
    }

    private TransferNetworkConnectionType(String str, int r2) {
    }

    public static TransferNetworkConnectionType getConnectionType(String str) {
        Map<String, TransferNetworkConnectionType> map = MAP;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        LOGGER.error("Unknown connection type " + str + " transfer will have connection type set to ANY.");
        return ANY;
    }

    public static TransferNetworkConnectionType valueOf(String str) {
        return (TransferNetworkConnectionType) Enum.valueOf(TransferNetworkConnectionType.class, str);
    }

    public static TransferNetworkConnectionType[] values() {
        return (TransferNetworkConnectionType[]) $VALUES.clone();
    }

    public boolean isConnected(ConnectivityManager connectivityManager) {
        return verify(connectivityManager.getActiveNetworkInfo());
    }

    public abstract boolean verify(NetworkInfo networkInfo);
}
