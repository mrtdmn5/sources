package com.animaconnected.watch.workout;

import androidx.core.util.Preconditions;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.fitness.SessionTypeSerializer;
import com.animaconnected.watch.workout.ListItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class SessionListItem$$serializer implements GeneratedSerializer<SessionListItem> {
    public static final SessionListItem$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        SessionListItem$$serializer sessionListItem$$serializer = new SessionListItem$$serializer();
        INSTANCE = sessionListItem$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.watch.workout.SessionListItem", sessionListItem$$serializer, 21);
        pluginGeneratedSerialDescriptor.addElement("sessionType", false);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_TIMESTAMP, false);
        pluginGeneratedSerialDescriptor.addElement("distance", false);
        pluginGeneratedSerialDescriptor.addElement("calories", false);
        pluginGeneratedSerialDescriptor.addElement("totalCalories", false);
        pluginGeneratedSerialDescriptor.addElement("activeTime", false);
        pluginGeneratedSerialDescriptor.addElement("totalTime", false);
        pluginGeneratedSerialDescriptor.addElement("steps", false);
        pluginGeneratedSerialDescriptor.addElement("pace", false);
        pluginGeneratedSerialDescriptor.addElement(TransferTable.COLUMN_SPEED, false);
        pluginGeneratedSerialDescriptor.addElement("elevationGain", false);
        pluginGeneratedSerialDescriptor.addElement("route", false);
        pluginGeneratedSerialDescriptor.addElement("splits", false);
        pluginGeneratedSerialDescriptor.addElement("heartrates", false);
        pluginGeneratedSerialDescriptor.addElement("rawAverageHeartrate", false);
        pluginGeneratedSerialDescriptor.addElement("elevations", false);
        pluginGeneratedSerialDescriptor.addElement("activityEntries", false);
        pluginGeneratedSerialDescriptor.addElement("debugElevation", false);
        pluginGeneratedSerialDescriptor.addElement("expanded", true);
        pluginGeneratedSerialDescriptor.addElement("gps", true);
        pluginGeneratedSerialDescriptor.addElement("itemType", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SessionListItem$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = SessionListItem.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{SessionTypeSerializer.INSTANCE, LongSerializer.INSTANCE, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, kSerializerArr[11], kSerializerArr[12], kSerializerArr[13], IntSerializer.INSTANCE, kSerializerArr[15], kSerializerArr[16], kSerializerArr[17], booleanSerializer, booleanSerializer, kSerializerArr[20]};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0043. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public SessionListItem deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        int r13;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = SessionListItem.$childSerializers;
        beginStructure.decodeSequentially();
        List list = null;
        List list2 = null;
        List list3 = null;
        List list4 = null;
        SessionType sessionType = null;
        String str2 = null;
        String str3 = null;
        ListItem.Type type = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        long j = 0;
        int r9 = 0;
        boolean z = true;
        int r25 = 0;
        boolean z2 = false;
        boolean z3 = false;
        List list5 = null;
        List list6 = null;
        while (z) {
            String str11 = str3;
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    str = str2;
                    z = false;
                    str3 = str11;
                    str2 = str;
                case 0:
                    str = str2;
                    sessionType = (SessionType) beginStructure.decodeSerializableElement(descriptor2, 0, SessionTypeSerializer.INSTANCE, sessionType);
                    r9 |= 1;
                    str3 = str11;
                    str2 = str;
                case 1:
                    str = str2;
                    j = beginStructure.decodeLongElement(descriptor2, 1);
                    r9 |= 2;
                    str3 = str11;
                    str2 = str;
                case 2:
                    r9 |= 4;
                    str = beginStructure.decodeStringElement(descriptor2, 2);
                    str3 = str11;
                    str2 = str;
                case 3:
                    str = str2;
                    r9 |= 8;
                    str3 = beginStructure.decodeStringElement(descriptor2, 3);
                    str2 = str;
                case 4:
                    str = str2;
                    r9 |= 16;
                    str10 = beginStructure.decodeStringElement(descriptor2, 4);
                    str3 = str11;
                    str2 = str;
                case 5:
                    str = str2;
                    r9 |= 32;
                    str4 = beginStructure.decodeStringElement(descriptor2, 5);
                    str3 = str11;
                    str2 = str;
                case 6:
                    str = str2;
                    r9 |= 64;
                    str5 = beginStructure.decodeStringElement(descriptor2, 6);
                    str3 = str11;
                    str2 = str;
                case 7:
                    str = str2;
                    r9 |= 128;
                    str6 = beginStructure.decodeStringElement(descriptor2, 7);
                    str3 = str11;
                    str2 = str;
                case 8:
                    str = str2;
                    str7 = beginStructure.decodeStringElement(descriptor2, 8);
                    r9 |= 256;
                    str3 = str11;
                    str2 = str;
                case 9:
                    str = str2;
                    str8 = beginStructure.decodeStringElement(descriptor2, 9);
                    r9 |= DfuBaseService.ERROR_REMOTE_TYPE_SECURE;
                    str3 = str11;
                    str2 = str;
                case 10:
                    str = str2;
                    str9 = beginStructure.decodeStringElement(descriptor2, 10);
                    r9 |= 1024;
                    str3 = str11;
                    str2 = str;
                case 11:
                    str = str2;
                    list = (List) beginStructure.decodeSerializableElement(descriptor2, 11, kSerializerArr[11], list);
                    r9 |= 2048;
                    str3 = str11;
                    str2 = str;
                case 12:
                    str = str2;
                    list5 = (List) beginStructure.decodeSerializableElement(descriptor2, 12, kSerializerArr[12], list5);
                    r9 |= 4096;
                    str3 = str11;
                    str2 = str;
                case 13:
                    str = str2;
                    list6 = (List) beginStructure.decodeSerializableElement(descriptor2, 13, kSerializerArr[13], list6);
                    r9 |= DfuBaseService.ERROR_REMOTE_MASK;
                    str3 = str11;
                    str2 = str;
                case 14:
                    str = str2;
                    r25 = beginStructure.decodeIntElement(descriptor2, 14);
                    r9 |= DfuBaseService.ERROR_CONNECTION_MASK;
                    str3 = str11;
                    str2 = str;
                case 15:
                    str = str2;
                    list4 = (List) beginStructure.decodeSerializableElement(descriptor2, 15, kSerializerArr[15], list4);
                    r13 = DfuBaseService.ERROR_CONNECTION_STATE_MASK;
                    r9 |= r13;
                    str3 = str11;
                    str2 = str;
                case 16:
                    str = str2;
                    list3 = (List) beginStructure.decodeSerializableElement(descriptor2, 16, kSerializerArr[16], list3);
                    r13 = 65536;
                    r9 |= r13;
                    str3 = str11;
                    str2 = str;
                case 17:
                    str = str2;
                    list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 17, kSerializerArr[17], list2);
                    r13 = 131072;
                    r9 |= r13;
                    str3 = str11;
                    str2 = str;
                case 18:
                    str = str2;
                    z2 = beginStructure.decodeBooleanElement(descriptor2, 18);
                    r13 = 262144;
                    r9 |= r13;
                    str3 = str11;
                    str2 = str;
                case 19:
                    str = str2;
                    z3 = beginStructure.decodeBooleanElement(descriptor2, 19);
                    r13 = 524288;
                    r9 |= r13;
                    str3 = str11;
                    str2 = str;
                case 20:
                    str = str2;
                    ListItem.Type type2 = (ListItem.Type) beginStructure.decodeSerializableElement(descriptor2, 20, kSerializerArr[20], type);
                    r9 |= Constants.MB;
                    type = type2;
                    str3 = str11;
                    str2 = str;
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new SessionListItem(r9, sessionType, j, str2, str3, str10, str4, str5, str6, str7, str8, str9, list, list5, list6, r25, list4, list3, list2, z2, z3, type, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SessionListItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        SessionListItem.write$Self$watch_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
