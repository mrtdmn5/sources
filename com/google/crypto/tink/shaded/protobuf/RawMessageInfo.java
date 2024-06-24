package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
public final class RawMessageInfo implements MessageInfo {
    public final MessageLite defaultInstance;
    public final int flags;
    public final String info;
    public final Object[] objects;

    public RawMessageInfo(GeneratedMessageLite generatedMessageLite, String str, Object[] objArr) {
        this.defaultInstance = generatedMessageLite;
        this.info = str;
        this.objects = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        int r4 = charAt & 8191;
        int r0 = 1;
        int r1 = 13;
        while (true) {
            int r2 = r0 + 1;
            char charAt2 = str.charAt(r0);
            if (charAt2 >= 55296) {
                r4 |= (charAt2 & 8191) << r1;
                r1 += 13;
                r0 = r2;
            } else {
                this.flags = r4 | (charAt2 << r1);
                return;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public final MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public final Object[] getObjects() {
        return this.objects;
    }

    public final String getStringInfo() {
        return this.info;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public final ProtoSyntax getSyntax() {
        if ((this.flags & 1) == 1) {
            return ProtoSyntax.PROTO2;
        }
        return ProtoSyntax.PROTO3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public final boolean isMessageSetWireFormat() {
        if ((this.flags & 2) == 2) {
            return true;
        }
        return false;
    }
}
