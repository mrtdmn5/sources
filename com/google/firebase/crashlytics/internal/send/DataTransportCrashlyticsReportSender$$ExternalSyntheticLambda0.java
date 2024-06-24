package com.google.firebase.crashlytics.internal.send;

import com.amazonaws.services.s3.internal.Constants;
import com.google.android.datatransport.Transformer;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class DataTransportCrashlyticsReportSender$$ExternalSyntheticLambda0 implements Transformer {
    @Override // com.google.android.datatransport.Transformer
    public final Object apply(Object obj) {
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        DataTransportCrashlyticsReportSender.TRANSFORM.getClass();
        JsonDataEncoderBuilder.AnonymousClass1 anonymousClass1 = CrashlyticsReportJsonTransform.CRASHLYTICS_REPORT_JSON_ENCODER;
        anonymousClass1.getClass();
        StringWriter stringWriter = new StringWriter();
        try {
            anonymousClass1.encode(crashlyticsReport, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString().getBytes(Charset.forName(Constants.DEFAULT_ENCODING));
    }
}
