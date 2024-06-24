package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {
    public static final AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder();
    public static final FieldDescriptor CURRENTCACHESIZEBYTES_DESCRIPTOR = new FieldDescriptor("currentCacheSizeBytes", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1, Protobuf.IntEncoding.DEFAULT))));
    public static final FieldDescriptor MAXCACHESIZEBYTES_DESCRIPTOR = new FieldDescriptor("maxCacheSizeBytes", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline0.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2, Protobuf.IntEncoding.DEFAULT))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        StorageMetrics storageMetrics = (StorageMetrics) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(CURRENTCACHESIZEBYTES_DESCRIPTOR, storageMetrics.current_cache_size_bytes_);
        objectEncoderContext2.add(MAXCACHESIZEBYTES_DESCRIPTOR, storageMetrics.max_cache_size_bytes_);
    }
}
