package kotlinx.serialization.json;

import com.google.common.hash.AbstractHasher;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.JsonStreamsKt;
import kotlinx.serialization.json.internal.JsonToStringWriter;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModuleKt;

/* compiled from: Json.kt */
/* loaded from: classes4.dex */
public abstract class Json implements StringFormat {
    public static final Default Default = new Default();
    public final DescriptorSchemaCache _schemaCache = new DescriptorSchemaCache();
    public final JsonConfiguration configuration;
    public final AbstractHasher serializersModule;

    /* compiled from: Json.kt */
    /* loaded from: classes4.dex */
    public static final class Default extends Json {
        public Default() {
            super(new JsonConfiguration(false, false, false, false, false, true, "    ", false, false, "type", false, true), SerializersModuleKt.EmptySerializersModule);
        }
    }

    public Json(JsonConfiguration jsonConfiguration, AbstractHasher abstractHasher) {
        this.configuration = jsonConfiguration;
        this.serializersModule = abstractHasher;
    }

    @Override // kotlinx.serialization.StringFormat
    public final Object decodeFromString(KSerializer deserializer, String string) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(string, "string");
        StringJsonLexer stringJsonLexer = new StringJsonLexer(string);
        Object decodeSerializableValue$1 = new StreamingJsonDecoder(this, WriteMode.OBJ, stringJsonLexer, deserializer.getDescriptor(), null).decodeSerializableValue$1(deserializer);
        stringJsonLexer.expectEof();
        return decodeSerializableValue$1;
    }

    @Override // kotlinx.serialization.StringFormat
    public final String encodeToString(KSerializer serializer, Object obj) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        JsonToStringWriter jsonToStringWriter = new JsonToStringWriter();
        try {
            JsonStreamsKt.encodeByWriter(this, jsonToStringWriter, serializer, obj);
            return jsonToStringWriter.toString();
        } finally {
            jsonToStringWriter.release();
        }
    }

    @Override // kotlinx.serialization.SerialFormat
    public final AbstractHasher getSerializersModule() {
        return this.serializersModule;
    }
}
