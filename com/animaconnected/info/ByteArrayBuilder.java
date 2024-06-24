package com.animaconnected.info;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;

/* compiled from: ByteArrayBuilder.kt */
/* loaded from: classes.dex */
public final class ByteArrayBuilder {
    private final List<Byte> bytes = new ArrayList();

    public final List<Byte> getBytes() {
        return this.bytes;
    }

    public final boolean int16LE(short s) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.encodeInt16LE(s)));
    }

    public final boolean int32LE(int r2) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.encodeInt32LE(r2)));
    }

    public final boolean int64LE(long j) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.encodeInt64LE(j)));
    }

    public final boolean int8LE(byte b) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.encodeInt8LE(b)));
    }

    public final boolean uInt16LE(int r2) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.m732encodeUInt16LExj2QHRw((short) r2)));
    }

    /* renamed from: uInt16LE-xj2QHRw, reason: not valid java name */
    public final boolean m719uInt16LExj2QHRw(short s) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.m732encodeUInt16LExj2QHRw(s)));
    }

    public final boolean uInt32LE(int r2) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.m737encodeUInt32LEWZ4Q5Ns(r2)));
    }

    /* renamed from: uInt32LE-WZ4Q5Ns, reason: not valid java name */
    public final boolean m720uInt32LEWZ4Q5Ns(int r2) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.m737encodeUInt32LEWZ4Q5Ns(r2)));
    }

    public final boolean uInt64LE(int r4) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.m742encodeUInt64LEVKZWuLQ(r4)));
    }

    /* renamed from: uInt64LE-VKZWuLQ, reason: not valid java name */
    public final boolean m721uInt64LEVKZWuLQ(long j) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.m742encodeUInt64LEVKZWuLQ(j)));
    }

    public final boolean uInt8LE(int r2) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.m745encodeUInt8LE7apg3OU((byte) r2)));
    }

    /* renamed from: uInt8LE-7apg3OU, reason: not valid java name */
    public final boolean m722uInt8LE7apg3OU(byte b) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.m745encodeUInt8LE7apg3OU(b)));
    }

    public final boolean int16LE(int r2) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.encodeInt16LE((short) r2)));
    }

    public final boolean int64LE(int r4) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.encodeInt64LE(r4)));
    }

    public final boolean int8LE(int r2) {
        return this.bytes.addAll(ArraysKt___ArraysJvmKt.asList(ByteUtils.encodeInt8LE((byte) r2)));
    }
}
