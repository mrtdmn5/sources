package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoBatchedLogRequestEncoder {
    public static final AutoBatchedLogRequestEncoder CONFIG = new AutoBatchedLogRequestEncoder();

    /* loaded from: classes3.dex */
    public static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {
        public static final AndroidClientInfoEncoder INSTANCE = new AndroidClientInfoEncoder();
        public static final FieldDescriptor SDKVERSION_DESCRIPTOR = FieldDescriptor.of("sdkVersion");
        public static final FieldDescriptor MODEL_DESCRIPTOR = FieldDescriptor.of("model");
        public static final FieldDescriptor HARDWARE_DESCRIPTOR = FieldDescriptor.of("hardware");
        public static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
        public static final FieldDescriptor PRODUCT_DESCRIPTOR = FieldDescriptor.of("product");
        public static final FieldDescriptor OSBUILD_DESCRIPTOR = FieldDescriptor.of("osBuild");
        public static final FieldDescriptor MANUFACTURER_DESCRIPTOR = FieldDescriptor.of("manufacturer");
        public static final FieldDescriptor FINGERPRINT_DESCRIPTOR = FieldDescriptor.of("fingerprint");
        public static final FieldDescriptor LOCALE_DESCRIPTOR = FieldDescriptor.of("locale");
        public static final FieldDescriptor COUNTRY_DESCRIPTOR = FieldDescriptor.of("country");
        public static final FieldDescriptor MCCMNC_DESCRIPTOR = FieldDescriptor.of("mccMnc");
        public static final FieldDescriptor APPLICATIONBUILD_DESCRIPTOR = FieldDescriptor.of("applicationBuild");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(SDKVERSION_DESCRIPTOR, androidClientInfo.getSdkVersion());
            objectEncoderContext2.add(MODEL_DESCRIPTOR, androidClientInfo.getModel());
            objectEncoderContext2.add(HARDWARE_DESCRIPTOR, androidClientInfo.getHardware());
            objectEncoderContext2.add(DEVICE_DESCRIPTOR, androidClientInfo.getDevice());
            objectEncoderContext2.add(PRODUCT_DESCRIPTOR, androidClientInfo.getProduct());
            objectEncoderContext2.add(OSBUILD_DESCRIPTOR, androidClientInfo.getOsBuild());
            objectEncoderContext2.add(MANUFACTURER_DESCRIPTOR, androidClientInfo.getManufacturer());
            objectEncoderContext2.add(FINGERPRINT_DESCRIPTOR, androidClientInfo.getFingerprint());
            objectEncoderContext2.add(LOCALE_DESCRIPTOR, androidClientInfo.getLocale());
            objectEncoderContext2.add(COUNTRY_DESCRIPTOR, androidClientInfo.getCountry());
            objectEncoderContext2.add(MCCMNC_DESCRIPTOR, androidClientInfo.getMccMnc());
            objectEncoderContext2.add(APPLICATIONBUILD_DESCRIPTOR, androidClientInfo.getApplicationBuild());
        }
    }

    /* loaded from: classes3.dex */
    public static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {
        public static final BatchedLogRequestEncoder INSTANCE = new BatchedLogRequestEncoder();
        public static final FieldDescriptor LOGREQUEST_DESCRIPTOR = FieldDescriptor.of("logRequest");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(LOGREQUEST_DESCRIPTOR, ((BatchedLogRequest) obj).getLogRequests());
        }
    }

    /* loaded from: classes3.dex */
    public static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {
        public static final ClientInfoEncoder INSTANCE = new ClientInfoEncoder();
        public static final FieldDescriptor CLIENTTYPE_DESCRIPTOR = FieldDescriptor.of("clientType");
        public static final FieldDescriptor ANDROIDCLIENTINFO_DESCRIPTOR = FieldDescriptor.of("androidClientInfo");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            ClientInfo clientInfo = (ClientInfo) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(CLIENTTYPE_DESCRIPTOR, clientInfo.getClientType());
            objectEncoderContext2.add(ANDROIDCLIENTINFO_DESCRIPTOR, clientInfo.getAndroidClientInfo());
        }
    }

    /* loaded from: classes3.dex */
    public static final class LogEventEncoder implements ObjectEncoder<LogEvent> {
        public static final LogEventEncoder INSTANCE = new LogEventEncoder();
        public static final FieldDescriptor EVENTTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventTimeMs");
        public static final FieldDescriptor EVENTCODE_DESCRIPTOR = FieldDescriptor.of("eventCode");
        public static final FieldDescriptor EVENTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventUptimeMs");
        public static final FieldDescriptor SOURCEEXTENSION_DESCRIPTOR = FieldDescriptor.of("sourceExtension");
        public static final FieldDescriptor SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR = FieldDescriptor.of("sourceExtensionJsonProto3");
        public static final FieldDescriptor TIMEZONEOFFSETSECONDS_DESCRIPTOR = FieldDescriptor.of("timezoneOffsetSeconds");
        public static final FieldDescriptor NETWORKCONNECTIONINFO_DESCRIPTOR = FieldDescriptor.of("networkConnectionInfo");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            LogEvent logEvent = (LogEvent) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(EVENTTIMEMS_DESCRIPTOR, logEvent.getEventTimeMs());
            objectEncoderContext2.add(EVENTCODE_DESCRIPTOR, logEvent.getEventCode());
            objectEncoderContext2.add(EVENTUPTIMEMS_DESCRIPTOR, logEvent.getEventUptimeMs());
            objectEncoderContext2.add(SOURCEEXTENSION_DESCRIPTOR, logEvent.getSourceExtension());
            objectEncoderContext2.add(SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR, logEvent.getSourceExtensionJsonProto3());
            objectEncoderContext2.add(TIMEZONEOFFSETSECONDS_DESCRIPTOR, logEvent.getTimezoneOffsetSeconds());
            objectEncoderContext2.add(NETWORKCONNECTIONINFO_DESCRIPTOR, logEvent.getNetworkConnectionInfo());
        }
    }

    /* loaded from: classes3.dex */
    public static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {
        public static final LogRequestEncoder INSTANCE = new LogRequestEncoder();
        public static final FieldDescriptor REQUESTTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestTimeMs");
        public static final FieldDescriptor REQUESTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestUptimeMs");
        public static final FieldDescriptor CLIENTINFO_DESCRIPTOR = FieldDescriptor.of("clientInfo");
        public static final FieldDescriptor LOGSOURCE_DESCRIPTOR = FieldDescriptor.of("logSource");
        public static final FieldDescriptor LOGSOURCENAME_DESCRIPTOR = FieldDescriptor.of("logSourceName");
        public static final FieldDescriptor LOGEVENT_DESCRIPTOR = FieldDescriptor.of("logEvent");
        public static final FieldDescriptor QOSTIER_DESCRIPTOR = FieldDescriptor.of("qosTier");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            LogRequest logRequest = (LogRequest) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(REQUESTTIMEMS_DESCRIPTOR, logRequest.getRequestTimeMs());
            objectEncoderContext2.add(REQUESTUPTIMEMS_DESCRIPTOR, logRequest.getRequestUptimeMs());
            objectEncoderContext2.add(CLIENTINFO_DESCRIPTOR, logRequest.getClientInfo());
            objectEncoderContext2.add(LOGSOURCE_DESCRIPTOR, logRequest.getLogSource());
            objectEncoderContext2.add(LOGSOURCENAME_DESCRIPTOR, logRequest.getLogSourceName());
            objectEncoderContext2.add(LOGEVENT_DESCRIPTOR, logRequest.getLogEvents());
            objectEncoderContext2.add(QOSTIER_DESCRIPTOR, logRequest.getQosTier());
        }
    }

    /* loaded from: classes3.dex */
    public static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {
        public static final NetworkConnectionInfoEncoder INSTANCE = new NetworkConnectionInfoEncoder();
        public static final FieldDescriptor NETWORKTYPE_DESCRIPTOR = FieldDescriptor.of("networkType");
        public static final FieldDescriptor MOBILESUBTYPE_DESCRIPTOR = FieldDescriptor.of("mobileSubtype");

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.add(NETWORKTYPE_DESCRIPTOR, networkConnectionInfo.getNetworkType());
            objectEncoderContext2.add(MOBILESUBTYPE_DESCRIPTOR, networkConnectionInfo.getMobileSubtype());
        }
    }

    public final void configure(EncoderConfig<?> encoderConfig) {
        BatchedLogRequestEncoder batchedLogRequestEncoder = BatchedLogRequestEncoder.INSTANCE;
        JsonDataEncoderBuilder jsonDataEncoderBuilder = (JsonDataEncoderBuilder) encoderConfig;
        jsonDataEncoderBuilder.registerEncoder(BatchedLogRequest.class, batchedLogRequestEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_BatchedLogRequest.class, batchedLogRequestEncoder);
        LogRequestEncoder logRequestEncoder = LogRequestEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(LogRequest.class, logRequestEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_LogRequest.class, logRequestEncoder);
        ClientInfoEncoder clientInfoEncoder = ClientInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(ClientInfo.class, clientInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_ClientInfo.class, clientInfoEncoder);
        AndroidClientInfoEncoder androidClientInfoEncoder = AndroidClientInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(AndroidClientInfo.class, androidClientInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_AndroidClientInfo.class, androidClientInfoEncoder);
        LogEventEncoder logEventEncoder = LogEventEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(LogEvent.class, logEventEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_LogEvent.class, logEventEncoder);
        NetworkConnectionInfoEncoder networkConnectionInfoEncoder = NetworkConnectionInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_NetworkConnectionInfo.class, networkConnectionInfoEncoder);
    }
}
