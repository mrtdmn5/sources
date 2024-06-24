package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonEncoder;

/* compiled from: JsonStreams.kt */
/* loaded from: classes4.dex */
public final class JsonStreamsKt {
    public static final void encodeByWriter(Json json, JsonToStringWriter jsonToStringWriter, KSerializer serializer, Object obj) {
        Composer composer;
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        WriteMode mode = WriteMode.OBJ;
        JsonEncoder[] jsonEncoderArr = new JsonEncoder[WriteMode.values().length];
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (json.configuration.prettyPrint) {
            composer = new ComposerWithPrettyPrint(jsonToStringWriter, json);
        } else {
            composer = new Composer(jsonToStringWriter);
        }
        new StreamingJsonEncoder(composer, json, mode, jsonEncoderArr).encodeSerializableValue(serializer, obj);
    }
}
