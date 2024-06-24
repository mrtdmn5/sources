package com.google.firebase.crashlytics.internal.send;

import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* loaded from: classes3.dex */
public final class DataTransportCrashlyticsReportSender {
    public final ReportQueue reportQueue;
    public static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    public static final String CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    public static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    public static final DataTransportCrashlyticsReportSender$$ExternalSyntheticLambda0 DEFAULT_TRANSFORM = new DataTransportCrashlyticsReportSender$$ExternalSyntheticLambda0();

    public DataTransportCrashlyticsReportSender(ReportQueue reportQueue) {
        this.reportQueue = reportQueue;
    }

    public static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length >= 0 && length <= 1) {
            StringBuilder sb = new StringBuilder(str2.length() + str.length());
            for (int r1 = 0; r1 < str.length(); r1++) {
                sb.append(str.charAt(r1));
                if (str2.length() > r1) {
                    sb.append(str2.charAt(r1));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }
}
