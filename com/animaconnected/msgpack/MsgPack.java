package com.animaconnected.msgpack;

import java.util.List;
import java.util.Map;

/* compiled from: MsgPack.kt */
/* loaded from: classes.dex */
public interface MsgPack {
    boolean asBoolean();

    byte asByte();

    byte[] asByteArray();

    int asInt();

    List<MsgPack> asList();

    long asLong();

    String asReadableString();

    String asString();

    /* renamed from: asUByteArray-TcUX1vc, reason: not valid java name */
    byte[] mo752asUByteArrayTcUX1vc();

    Map<Integer, MsgPack> getMap();

    Map<String, MsgPack> getStringMap();

    boolean isArrayValue();

    boolean isBinaryValue();

    boolean isIntegerValue();

    boolean isMapValue();

    boolean isNilValue();

    boolean isStringValue();

    byte[] toMsgPackBytes();
}
