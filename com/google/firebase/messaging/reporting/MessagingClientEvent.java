package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.ProtoEnum;

/* loaded from: classes3.dex */
public final class MessagingClientEvent {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final String analytics_label_;
    public final String collapse_key_;
    public final String composer_label_;
    public final Event event_;
    public final String instance_id_;
    public final String message_id_;
    public final MessageType message_type_;
    public final String package_name_;
    public final long project_number_;
    public final SDKPlatform sdk_platform_;
    public final String topic_;
    public final int ttl_;
    public final int priority_ = 0;
    public final long bulk_id_ = 0;
    public final long campaign_id_ = 0;

    /* loaded from: classes3.dex */
    public enum Event implements ProtoEnum {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);

        private final int number_;

        Event(int r3) {
            this.number_ = r3;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.number_;
        }
    }

    /* loaded from: classes3.dex */
    public enum MessageType implements ProtoEnum {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);

        private final int number_;

        MessageType(int r3) {
            this.number_ = r3;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.number_;
        }
    }

    /* loaded from: classes3.dex */
    public enum SDKPlatform implements ProtoEnum {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);

        private final int number_;

        SDKPlatform(int r3) {
            this.number_ = r3;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.number_;
        }
    }

    static {
        MessageType messageType = MessageType.UNKNOWN;
        SDKPlatform sDKPlatform = SDKPlatform.UNKNOWN_OS;
        Event event = Event.UNKNOWN_EVENT;
    }

    public MessagingClientEvent(long j, String str, String str2, MessageType messageType, SDKPlatform sDKPlatform, String str3, String str4, int r9, String str5, Event event, String str6, String str7) {
        this.project_number_ = j;
        this.message_id_ = str;
        this.instance_id_ = str2;
        this.message_type_ = messageType;
        this.sdk_platform_ = sDKPlatform;
        this.package_name_ = str3;
        this.collapse_key_ = str4;
        this.ttl_ = r9;
        this.topic_ = str5;
        this.event_ = event;
        this.analytics_label_ = str6;
        this.composer_label_ = str7;
    }
}
