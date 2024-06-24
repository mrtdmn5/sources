package com.google.crypto.tink;

import com.amazonaws.services.s3.internal.Constants;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class Util {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        Charset.forName(Constants.DEFAULT_ENCODING);
    }

    public static KeysetInfo getKeysetInfo(Keyset keyset) {
        KeysetInfo.Builder newBuilder = KeysetInfo.newBuilder();
        int primaryKeyId = keyset.getPrimaryKeyId();
        newBuilder.copyOnWrite();
        ((KeysetInfo) newBuilder.instance).primaryKeyId_ = primaryKeyId;
        for (Keyset.Key key : keyset.getKeyList()) {
            KeysetInfo.KeyInfo.Builder newBuilder2 = KeysetInfo.KeyInfo.newBuilder();
            String typeUrl = key.getKeyData().getTypeUrl();
            newBuilder2.copyOnWrite();
            KeysetInfo.KeyInfo.access$100((KeysetInfo.KeyInfo) newBuilder2.instance, typeUrl);
            KeyStatusType status = key.getStatus();
            newBuilder2.copyOnWrite();
            KeysetInfo.KeyInfo.access$500((KeysetInfo.KeyInfo) newBuilder2.instance, status);
            OutputPrefixType outputPrefixType = key.getOutputPrefixType();
            newBuilder2.copyOnWrite();
            KeysetInfo.KeyInfo.access$1000((KeysetInfo.KeyInfo) newBuilder2.instance, outputPrefixType);
            int keyId = key.getKeyId();
            newBuilder2.copyOnWrite();
            ((KeysetInfo.KeyInfo) newBuilder2.instance).keyId_ = keyId;
            KeysetInfo.KeyInfo build = newBuilder2.build();
            newBuilder.copyOnWrite();
            KeysetInfo.access$1700((KeysetInfo) newBuilder.instance, build);
        }
        return newBuilder.build();
    }
}
