package com.animaconnected.secondo.screens.settings;

import androidx.core.util.Preconditions;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: OpenSourceLicenses.kt */
/* loaded from: classes3.dex */
public final class Project$$serializer implements GeneratedSerializer<Project> {
    public static final int $stable = 0;
    public static final Project$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Project$$serializer project$$serializer = new Project$$serializer();
        INSTANCE = project$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.animaconnected.secondo.screens.settings.Project", project$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("project", false);
        pluginGeneratedSerialDescriptor.addElement(DetailBottomDialog.keyDescription, false);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.KEY_VERSION, false);
        pluginGeneratedSerialDescriptor.addElement("developers", false);
        pluginGeneratedSerialDescriptor.addElement(Constants.URL_ENCODING, false);
        pluginGeneratedSerialDescriptor.addElement("year", false);
        pluginGeneratedSerialDescriptor.addElement("licenses", false);
        pluginGeneratedSerialDescriptor.addElement("dependency", false);
        pluginGeneratedSerialDescriptor.addElement("copyrightSymbol", true);
        pluginGeneratedSerialDescriptor.addElement("developersString", true);
        pluginGeneratedSerialDescriptor.addElement("formattedYear", true);
        pluginGeneratedSerialDescriptor.addElement("projectAndVersion", true);
        pluginGeneratedSerialDescriptor.addElement("copyright", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Project$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = Project.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[3]), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[6]), BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0032. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public Project deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int r6;
        int r4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = Project.$childSerializers;
        beginStructure.decodeSequentially();
        String str = null;
        String str2 = null;
        String str3 = null;
        List list = null;
        String str4 = null;
        String str5 = null;
        List list2 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        int r7 = 0;
        boolean z = true;
        while (z) {
            int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
            switch (decodeElementIndex) {
                case -1:
                    z = false;
                case 0:
                    str = beginStructure.decodeStringElement(descriptor2, 0);
                    r6 = r7 | 1;
                    r7 = r6;
                case 1:
                    str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str2);
                    r4 = r7 | 2;
                    r6 = r4;
                    r7 = r6;
                case 2:
                    str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str3);
                    r4 = r7 | 4;
                    r6 = r4;
                    r7 = r6;
                case 3:
                    list = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kSerializerArr[3], list);
                    r4 = r7 | 8;
                    r6 = r4;
                    r7 = r6;
                case 4:
                    str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str4);
                    r4 = r7 | 16;
                    r6 = r4;
                    r7 = r6;
                case 5:
                    str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str5);
                    r4 = r7 | 32;
                    r6 = r4;
                    r7 = r6;
                case 6:
                    list2 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 6, kSerializerArr[6], list2);
                    r4 = r7 | 64;
                    r6 = r4;
                    r7 = r6;
                case 7:
                    str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str6);
                    r7 |= 128;
                case 8:
                    str7 = beginStructure.decodeStringElement(descriptor2, 8);
                    r7 |= 256;
                case 9:
                    str8 = beginStructure.decodeStringElement(descriptor2, 9);
                    r7 |= DfuBaseService.ERROR_REMOTE_TYPE_SECURE;
                case 10:
                    str9 = beginStructure.decodeStringElement(descriptor2, 10);
                    r7 |= 1024;
                case 11:
                    r7 |= 2048;
                    str10 = beginStructure.decodeStringElement(descriptor2, 11);
                case 12:
                    r7 |= 4096;
                    str11 = beginStructure.decodeStringElement(descriptor2, 12);
                default:
                    throw new UnknownFieldException(decodeElementIndex);
            }
        }
        beginStructure.endStructure(descriptor2);
        return new Project(r7, str, str2, str3, list, str4, str5, list2, str6, str7, str8, str9, str10, str11, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Project value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Project.write$Self$secondo_kronabyRelease(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return Preconditions.EMPTY_SERIALIZER_ARRAY;
    }
}
