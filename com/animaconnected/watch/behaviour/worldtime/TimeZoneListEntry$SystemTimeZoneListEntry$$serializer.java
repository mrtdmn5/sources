package com.animaconnected.watch.behaviour.worldtime;

import androidx.core.util.Preconditions;
import com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: WorldTime.kt */
/* loaded from: classes3.dex */
public final class TimeZoneListEntry$SystemTimeZoneListEntry$$serializer implements GeneratedSerializer<TimeZoneListEntry.SystemTimeZoneListEntry> {
    public static final TimeZoneListEntry$SystemTimeZoneListEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TimeZoneListEntry$SystemTimeZoneListEntry$$serializer timeZoneListEntry$SystemTimeZoneListEntry$$serializer = new TimeZoneListEntry$SystemTimeZoneListEntry$$serializer();
        INSTANCE = timeZoneListEntry$SystemTimeZoneListEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry.SystemTimeZoneListEntry", timeZoneListEntry$SystemTimeZoneListEntry$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("timeZoneId", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TimeZoneListEntry$SystemTimeZoneListEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TimeZoneListEntry.SystemTimeZoneListEntry deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        int r4 = 0;
        String str = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else {
                if (decodeElementIndex != 0) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                str = beginStructure.decodeStringElement(descriptor2, 0);
                r4 |= 1;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new TimeZoneListEntry.SystemTimeZoneListEntry(r4, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TimeZoneListEntry.SystemTimeZoneListEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        TimeZoneListEntry.SystemTimeZoneListEntry.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
