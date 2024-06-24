package aws.smithy.kotlin.runtime.serde.json;

import aws.smithy.kotlin.runtime.serde.ListSerializer;
import aws.smithy.kotlin.runtime.serde.MapSerializer;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkSerializableLambda;
import aws.smithy.kotlin.runtime.serde.Serializer;
import aws.smithy.kotlin.runtime.serde.StructSerializer;
import com.amazonaws.services.s3.internal.Constants;
import com.amplifyframework.core.model.ModelIdentifier;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: JsonSerializer.kt */
/* loaded from: classes.dex */
public final class JsonSerializer implements Serializer, ListSerializer, MapSerializer, StructSerializer {
    public static final Set<Double> doublesToStringify = SetsKt__SetsKt.setOf((Object[]) new Double[]{Double.valueOf(Double.NEGATIVE_INFINITY), Double.valueOf(Double.POSITIVE_INFINITY), Double.valueOf(Double.NaN)});
    public static final Set<Float> floatsToStringify = SetsKt__SetsKt.setOf((Object[]) new Float[]{Float.valueOf(Float.NEGATIVE_INFINITY), Float.valueOf(Float.POSITIVE_INFINITY), Float.valueOf(Float.NaN)});
    public final JsonEncoder jsonWriter = new JsonEncoder(false);

    public final JsonSerializer beginList(SdkFieldDescriptor sdkFieldDescriptor) {
        JsonEncoder jsonEncoder = this.jsonWriter;
        jsonEncoder.getClass();
        LexerState lexerState = LexerState.ArrayFirstValueOrEnd;
        jsonEncoder.encodeValue("[");
        if (jsonEncoder.pretty) {
            jsonEncoder.buffer.append('\n');
        }
        jsonEncoder.depth++;
        ArrayList arrayList = jsonEncoder.state;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.add(lexerState);
        return this;
    }

    public final JsonSerializer beginMap(SdkFieldDescriptor sdkFieldDescriptor) {
        JsonEncoder jsonEncoder = this.jsonWriter;
        jsonEncoder.getClass();
        LexerState lexerState = LexerState.ObjectFirstKeyOrEnd;
        jsonEncoder.encodeValue("{");
        if (jsonEncoder.pretty) {
            jsonEncoder.buffer.append('\n');
        }
        jsonEncoder.depth++;
        ArrayList arrayList = jsonEncoder.state;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.add(lexerState);
        return this;
    }

    @Override // aws.smithy.kotlin.runtime.serde.Serializer
    public final JsonSerializer beginStruct(SdkObjectDescriptor sdkObjectDescriptor) {
        JsonEncoder jsonEncoder = this.jsonWriter;
        jsonEncoder.getClass();
        LexerState lexerState = LexerState.ObjectFirstKeyOrEnd;
        jsonEncoder.encodeValue("{");
        if (jsonEncoder.pretty) {
            jsonEncoder.buffer.append('\n');
        }
        jsonEncoder.depth++;
        ArrayList arrayList = jsonEncoder.state;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.add(lexerState);
        return this;
    }

    public final void endList() {
        JsonEncoder jsonEncoder = this.jsonWriter;
        jsonEncoder.getClass();
        jsonEncoder.closeStructure("]", LexerState.ArrayFirstValueOrEnd, LexerState.ArrayNextValueOrEnd);
    }

    public final void endMap() {
        JsonEncoder jsonEncoder = this.jsonWriter;
        jsonEncoder.getClass();
        jsonEncoder.closeStructure("}", LexerState.ObjectFirstKeyOrEnd, LexerState.ObjectNextKeyOrEnd);
    }

    public final void endStruct() {
        JsonEncoder jsonEncoder = this.jsonWriter;
        jsonEncoder.getClass();
        jsonEncoder.closeStructure("}", LexerState.ObjectFirstKeyOrEnd, LexerState.ObjectNextKeyOrEnd);
    }

    @Override // aws.smithy.kotlin.runtime.serde.MapSerializer
    public final void entry(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        JsonEncoder jsonEncoder = this.jsonWriter;
        jsonEncoder.writeName(key);
        if (str != null) {
            serializeString(str);
        } else {
            jsonEncoder.encodeValue(Constants.NULL_VERSION_ID);
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.StructSerializer
    public final void field(SdkFieldDescriptor sdkFieldDescriptor, SdkSerializableLambda sdkSerializableLambda) {
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(sdkFieldDescriptor));
        sdkSerializableLambda.serialize(this);
    }

    public final void listField(SdkFieldDescriptor sdkFieldDescriptor, Function1<? super ListSerializer, Unit> function1) {
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(sdkFieldDescriptor));
        beginList(sdkFieldDescriptor);
        function1.invoke(this);
        endList();
    }

    public final void mapField(SdkFieldDescriptor sdkFieldDescriptor, Function1<? super MapSerializer, Unit> function1) {
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(sdkFieldDescriptor));
        beginMap(sdkFieldDescriptor);
        function1.invoke(this);
        endMap();
    }

    @Override // aws.smithy.kotlin.runtime.serde.PrimitiveSerializer
    public final void serializeSdkSerializable(SdkSerializableLambda sdkSerializableLambda) {
        sdkSerializableLambda.serialize(this);
    }

    public final void serializeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        JsonEncoder jsonEncoder = this.jsonWriter;
        jsonEncoder.getClass();
        jsonEncoder.encodeValue(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR + JsonEncoderKt.escape(value) + '\"');
    }

    public final byte[] toByteArray() {
        String sb = this.jsonWriter.buffer.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "buffer.toString()");
        return StringsKt__StringsJVMKt.encodeToByteArray(sb);
    }

    public final void field(SdkFieldDescriptor sdkFieldDescriptor, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.jsonWriter.writeName(JsonFieldTraitsKt.getSerialName(sdkFieldDescriptor));
        serializeString(value);
    }
}
