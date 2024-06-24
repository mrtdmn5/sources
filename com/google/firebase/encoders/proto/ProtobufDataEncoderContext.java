package com.google.firebase.encoders.proto;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.secondo.R;
import com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ProtobufDataEncoderContext implements ObjectEncoderContext {
    public static final ProtobufDataEncoderContext$$ExternalSyntheticLambda0 DEFAULT_MAP_ENCODER;
    public static final FieldDescriptor MAP_KEY_DESC;
    public static final FieldDescriptor MAP_VALUE_DESC;
    public static final Charset UTF_8 = Charset.forName(Constants.DEFAULT_ENCODING);
    public final ObjectEncoder<Object> fallbackEncoder;
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    public OutputStream output;
    public final ProtobufValueEncoderContext valueEncoderContext = new ProtobufValueEncoderContext(this);
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding;

        static {
            int[] r0 = new int[Protobuf.IntEncoding.values().length];
            $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding = r0;
            try {
                r0[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        Protobuf.IntEncoding intEncoding = Protobuf.IntEncoding.DEFAULT;
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, intEncoding);
        HashMap hashMap = new HashMap();
        hashMap.put(Protobuf.class, atProtobuf$ProtobufImpl);
        MAP_KEY_DESC = new FieldDescriptor(TransferTable.COLUMN_KEY, AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(hashMap));
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2, intEncoding);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Protobuf.class, atProtobuf$ProtobufImpl2);
        MAP_VALUE_DESC = new FieldDescriptor("value", AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder$$ExternalSyntheticOutline1.m(hashMap2));
        DEFAULT_MAP_ENCODER = new ProtobufDataEncoderContext$$ExternalSyntheticLambda0();
    }

    public ProtobufDataEncoderContext(ByteArrayOutputStream byteArrayOutputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.output = byteArrayOutputStream;
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
    }

    public static int getTag(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf != null) {
            return ((AtProtobuf$ProtobufImpl) protobuf).tag;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public final void add(FieldDescriptor fieldDescriptor, int r4, boolean z) throws IOException {
        if (z && r4 == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf != null) {
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = (AtProtobuf$ProtobufImpl) protobuf;
            int r5 = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[atProtobuf$ProtobufImpl.intEncoding.ordinal()];
            int r3 = atProtobuf$ProtobufImpl.tag;
            if (r5 == 1) {
                writeVarInt32(r3 << 3);
                writeVarInt32(r4);
                return;
            } else if (r5 == 2) {
                writeVarInt32(r3 << 3);
                writeVarInt32((r4 << 1) ^ (r4 >> 31));
                return;
            } else {
                if (r5 != 3) {
                    return;
                }
                writeVarInt32((r3 << 3) | 5);
                this.output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(r4).array());
                return;
            }
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public final void doEncode(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            OutputStream outputStream = this.output;
            this.output = lengthCountingOutputStream;
            try {
                objectEncoder.encode(obj, this);
                this.output = outputStream;
                long j = lengthCountingOutputStream.length;
                lengthCountingOutputStream.close();
                if (z && j == 0) {
                    return;
                }
                writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
                writeVarInt64(j);
                objectEncoder.encode(obj, this);
            } catch (Throwable th) {
                this.output = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void writeVarInt32(int r5) throws IOException {
        while ((r5 & (-128)) != 0) {
            this.output.write((r5 & R.styleable.AppTheme_statusTextH5) | 128);
            r5 >>>= 7;
        }
        this.output.write(r5 & R.styleable.AppTheme_statusTextH5);
    }

    public final void writeVarInt64(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.output.write((((int) j) & R.styleable.AppTheme_statusTextH5) | 128);
            j >>>= 7;
        }
        this.output.write(((int) j) & R.styleable.AppTheme_statusTextH5);
    }

    public final void add(FieldDescriptor fieldDescriptor, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf != null) {
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = (AtProtobuf$ProtobufImpl) protobuf;
            int r7 = AnonymousClass1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[atProtobuf$ProtobufImpl.intEncoding.ordinal()];
            int r4 = atProtobuf$ProtobufImpl.tag;
            if (r7 == 1) {
                writeVarInt32(r4 << 3);
                writeVarInt64(j);
                return;
            } else if (r7 == 2) {
                writeVarInt32(r4 << 3);
                writeVarInt64((j >> 63) ^ (j << 1));
                return;
            } else {
                if (r7 != 3) {
                    return;
                }
                writeVarInt32((r4 << 3) | 1);
                this.output.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j).array());
                return;
            }
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        add(fieldDescriptor, obj, true);
        return this;
    }

    public final ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(UTF_8);
            writeVarInt32(bytes.length);
            this.output.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                add(fieldDescriptor, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                doEncode(DEFAULT_MAP_ENCODER, fieldDescriptor, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (!z || doubleValue != 0.0d) {
                writeVarInt32((getTag(fieldDescriptor) << 3) | 1);
                this.output.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(doubleValue).array());
            }
            return this;
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (!z || floatValue != 0.0f) {
                writeVarInt32((getTag(fieldDescriptor) << 3) | 5);
                this.output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(floatValue).array());
            }
            return this;
        }
        if (obj instanceof Number) {
            add(fieldDescriptor, ((Number) obj).longValue(), z);
            return this;
        }
        if (obj instanceof Boolean) {
            add(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            writeVarInt32(bArr.length);
            this.output.write(bArr);
            return this;
        }
        ObjectEncoder<?> objectEncoder = this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            doEncode(objectEncoder, fieldDescriptor, obj, z);
            return this;
        }
        ValueEncoder<?> valueEncoder = this.valueEncoders.get(obj.getClass());
        if (valueEncoder != null) {
            ProtobufValueEncoderContext protobufValueEncoderContext = this.valueEncoderContext;
            protobufValueEncoderContext.encoded = false;
            protobufValueEncoderContext.field = fieldDescriptor;
            protobufValueEncoderContext.skipDefault = z;
            valueEncoder.encode(obj, protobufValueEncoderContext);
            return this;
        }
        if (obj instanceof ProtoEnum) {
            add(fieldDescriptor, ((ProtoEnum) obj).getNumber(), true);
            return this;
        }
        if (obj instanceof Enum) {
            add(fieldDescriptor, ((Enum) obj).ordinal(), true);
            return this;
        }
        doEncode(this.fallbackEncoder, fieldDescriptor, obj, z);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int r3) throws IOException {
        add(fieldDescriptor, r3, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        add(fieldDescriptor, j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        add(fieldDescriptor, z ? 1 : 0, true);
        return this;
    }
}
