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
public final class TimeZoneListEntry$PredefinedTimeZoneListEntry$$serializer implements GeneratedSerializer<TimeZoneListEntry.PredefinedTimeZoneListEntry> {
    public static final TimeZoneListEntry$PredefinedTimeZoneListEntry$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TimeZoneListEntry$PredefinedTimeZoneListEntry$$serializer timeZoneListEntry$PredefinedTimeZoneListEntry$$serializer = new TimeZoneListEntry$PredefinedTimeZoneListEntry$$serializer();
        INSTANCE = timeZoneListEntry$PredefinedTimeZoneListEntry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.behaviour.worldtime.TimeZoneListEntry.PredefinedTimeZoneListEntry", timeZoneListEntry$PredefinedTimeZoneListEntry$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("timeZoneId", false);
        pluginGeneratedSerialDescriptor.addElement("cityKey", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TimeZoneListEntry$PredefinedTimeZoneListEntry$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TimeZoneListEntry.PredefinedTimeZoneListEntry deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        beginStructure.decodeSequentially();
        boolean z = true;
        int r6 = 0;
        String str = null;
        String str2 = null;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            if (decodeElementIndex == -1) {
                z = false;
            } else if (decodeElementIndex == 0) {
                str2 = beginStructure.decodeStringElement(descriptor2, 0);
                r6 |= 1;
            } else {
                if (decodeElementIndex != 1) {
                    throw new UnknownFieldException(decodeElementIndex);
                }
                str = beginStructure.decodeStringElement(descriptor2, 1);
                r6 |= 2;
            }
        }
        beginStructure.endStructure(descriptor2);
        return new TimeZoneListEntry.PredefinedTimeZoneListEntry(r6, str2, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TimeZoneListEntry.PredefinedTimeZoneListEntry value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        TimeZoneListEntry.PredefinedTimeZoneListEntry.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
