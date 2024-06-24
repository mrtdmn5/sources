package com.animaconnected.msgpack;

import java.util.List;
import java.util.Map;

/* compiled from: MsgPack.kt */
/* loaded from: classes.dex */
public interface MsgPackCreator {
    MsgPack fromBytes(byte[] bArr);

    MsgPack newArray(List<? extends Object> list);

    MsgPack newArray(Object[] objArr);

    MsgPack newBoolean(boolean z);

    MsgPack newEmpty();

    MsgPack newInt(int r1);

    MsgPack newIntMap(Map<Integer, ? extends Object> map);

    MsgPack newString(String str);

    MsgPack newStringMap(Map<String, ? extends Object> map);
}
