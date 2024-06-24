package com.google.firebase.messaging;

import com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0;
import com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder$MessagingClientEventEncoder implements ObjectEncoder<MessagingClientEvent> {
    public static final AutoProtoEncoderDoNotUseEncoder$MessagingClientEventEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$MessagingClientEventEncoder();
    public static final FieldDescriptor PROJECTNUMBER_DESCRIPTOR = new FieldDescriptor("projectNumber", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor MESSAGEID_DESCRIPTOR = new FieldDescriptor("messageId", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor INSTANCEID_DESCRIPTOR = new FieldDescriptor("instanceId", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(3, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor MESSAGETYPE_DESCRIPTOR = new FieldDescriptor("messageType", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(4, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor SDKPLATFORM_DESCRIPTOR = new FieldDescriptor("sdkPlatform", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(5, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor PACKAGENAME_DESCRIPTOR = new FieldDescriptor("packageName", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(6, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor COLLAPSEKEY_DESCRIPTOR = new FieldDescriptor("collapseKey", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(7, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor PRIORITY_DESCRIPTOR = new FieldDescriptor("priority", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(8, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor TTL_DESCRIPTOR = new FieldDescriptor("ttl", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(9, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor TOPIC_DESCRIPTOR = new FieldDescriptor("topic", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(10, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor BULKID_DESCRIPTOR = new FieldDescriptor("bulkId", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(11, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor EVENT_DESCRIPTOR = new FieldDescriptor("event", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(12, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor ANALYTICSLABEL_DESCRIPTOR = new FieldDescriptor("analyticsLabel", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(13, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor CAMPAIGNID_DESCRIPTOR = new FieldDescriptor("campaignId", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(14, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor COMPOSERLABEL_DESCRIPTOR = new FieldDescriptor("composerLabel", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(15, Protobuf.IntEncoding.DEFAULT))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        MessagingClientEvent messagingClientEvent = (MessagingClientEvent) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(PROJECTNUMBER_DESCRIPTOR, messagingClientEvent.project_number_);
        objectEncoderContext2.add(MESSAGEID_DESCRIPTOR, messagingClientEvent.message_id_);
        objectEncoderContext2.add(INSTANCEID_DESCRIPTOR, messagingClientEvent.instance_id_);
        objectEncoderContext2.add(MESSAGETYPE_DESCRIPTOR, messagingClientEvent.message_type_);
        objectEncoderContext2.add(SDKPLATFORM_DESCRIPTOR, messagingClientEvent.sdk_platform_);
        objectEncoderContext2.add(PACKAGENAME_DESCRIPTOR, messagingClientEvent.package_name_);
        objectEncoderContext2.add(COLLAPSEKEY_DESCRIPTOR, messagingClientEvent.collapse_key_);
        objectEncoderContext2.add(PRIORITY_DESCRIPTOR, messagingClientEvent.priority_);
        objectEncoderContext2.add(TTL_DESCRIPTOR, messagingClientEvent.ttl_);
        objectEncoderContext2.add(TOPIC_DESCRIPTOR, messagingClientEvent.topic_);
        objectEncoderContext2.add(BULKID_DESCRIPTOR, messagingClientEvent.bulk_id_);
        objectEncoderContext2.add(EVENT_DESCRIPTOR, messagingClientEvent.event_);
        objectEncoderContext2.add(ANALYTICSLABEL_DESCRIPTOR, messagingClientEvent.analytics_label_);
        objectEncoderContext2.add(CAMPAIGNID_DESCRIPTOR, messagingClientEvent.campaign_id_);
        objectEncoderContext2.add(COMPOSERLABEL_DESCRIPTOR, messagingClientEvent.composer_label_);
    }
}
