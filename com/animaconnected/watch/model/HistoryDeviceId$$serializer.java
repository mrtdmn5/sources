package com.animaconnected.watch.model;

import androidx.core.util.Preconditions;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: HistoryDeviceId.kt */
/* loaded from: classes3.dex */
public final class HistoryDeviceId$$serializer implements GeneratedSerializer<HistoryDeviceId> {
    public static final HistoryDeviceId$$serializer INSTANCE;
    private static final /* synthetic */ InlineClassDescriptor descriptor;

    static {
        HistoryDeviceId$$serializer historyDeviceId$$serializer = new HistoryDeviceId$$serializer();
        INSTANCE = historyDeviceId$$serializer;
        InlineClassDescriptor inlineClassDescriptor = new InlineClassDescriptor("com.animaconnected.watch.model.HistoryDeviceId", historyDeviceId$$serializer);
        inlineClassDescriptor.addElement(ConfigurationItem.COLUMN_NAME_ID, false);
        descriptor = inlineClassDescriptor;
    }

    private HistoryDeviceId$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return HistoryDeviceId.m1556boximpl(m1563deserialize1z8L_Yw(decoder));
    }

    /* renamed from: deserialize-1z8L_Yw */
    public String m1563deserialize1z8L_Yw(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return HistoryDeviceId.m1557constructorimpl(decoder.decodeInline(getDescriptor()).decodeString());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m1564serializenDauRJo(encoder, ((HistoryDeviceId) obj).m1562unboximpl());
    }

    /* renamed from: serialize-nDauRJo */
    public void m1564serializenDauRJo(Encoder encoder, String value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        Encoder encodeInline = encoder.encodeInline(getDescriptor());
        if (encodeInline != null) {
            encodeInline.encodeString(value);
        }
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
