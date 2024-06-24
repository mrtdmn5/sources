package aws.smithy.kotlin.runtime.awsprotocol.json;

import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;
import com.animaconnected.firebase.AnalyticsConstants;

/* compiled from: RestJsonErrorDeserializer.kt */
/* loaded from: classes.dex */
public final class RestJsonErrorDeserializer {
    public static final SdkFieldDescriptor ERR_CODE_ALT1_DESCRIPTOR;
    public static final SdkFieldDescriptor ERR_CODE_ALT2_DESCRIPTOR;
    public static final SdkFieldDescriptor MESSAGE_ALT1_DESCRIPTOR;
    public static final SdkFieldDescriptor MESSAGE_ALT2_DESCRIPTOR;
    public static final SdkFieldDescriptor MESSAGE_ALT3_DESCRIPTOR;
    public static final SdkObjectDescriptor OBJ_DESCRIPTOR;

    static {
        SerialKind.Integer integer = SerialKind.Integer.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor = new SdkFieldDescriptor(integer, new JsonSerialName(AnalyticsConstants.KEY_CODE));
        ERR_CODE_ALT1_DESCRIPTOR = sdkFieldDescriptor;
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(integer, new JsonSerialName("__type"));
        ERR_CODE_ALT2_DESCRIPTOR = sdkFieldDescriptor2;
        SerialKind.String string = SerialKind.String.INSTANCE;
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(string, new JsonSerialName("message"));
        MESSAGE_ALT1_DESCRIPTOR = sdkFieldDescriptor3;
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(string, new JsonSerialName("Message"));
        MESSAGE_ALT2_DESCRIPTOR = sdkFieldDescriptor4;
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(string, new JsonSerialName("errorMessage"));
        MESSAGE_ALT3_DESCRIPTOR = sdkFieldDescriptor5;
        SdkObjectDescriptor.Builder builder = new SdkObjectDescriptor.Builder();
        builder.field(sdkFieldDescriptor);
        builder.field(sdkFieldDescriptor2);
        builder.field(sdkFieldDescriptor3);
        builder.field(sdkFieldDescriptor4);
        builder.field(sdkFieldDescriptor5);
        OBJ_DESCRIPTOR = new SdkObjectDescriptor(builder);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007e, code lost:            if (r7.intValue() != r2) goto L43;     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails deserialize(aws.smithy.kotlin.runtime.http.Headers r6, byte[] r7) {
        /*
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "X-Amzn-Errortype"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r1 = "x-amzn-error-message"
            java.lang.Object r1 = r6.get(r1)
            if (r1 != 0) goto L1a
            java.lang.String r1 = ":error-message"
            java.lang.Object r1 = r6.get(r1)
        L1a:
            if (r7 == 0) goto L8e
            aws.smithy.kotlin.runtime.serde.json.JsonDeserializer r6 = new aws.smithy.kotlin.runtime.serde.json.JsonDeserializer
            r6.<init>(r7)
            aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor r7 = aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializer.OBJ_DESCRIPTOR
            aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator r6 = r6.deserializeStruct(r7)
        L27:
            java.lang.Integer r7 = r6.findNextFieldIndex()
            aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor r2 = aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializer.ERR_CODE_ALT1_DESCRIPTOR
            int r2 = r2.index
            r3 = 0
            r4 = 1
            if (r7 != 0) goto L34
            goto L3b
        L34:
            int r5 = r7.intValue()
            if (r5 != r2) goto L3b
            goto L48
        L3b:
            aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor r2 = aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializer.ERR_CODE_ALT2_DESCRIPTOR
            int r2 = r2.index
            if (r7 != 0) goto L42
            goto L4a
        L42:
            int r5 = r7.intValue()
            if (r5 != r2) goto L4a
        L48:
            r2 = r4
            goto L4b
        L4a:
            r2 = r3
        L4b:
            if (r2 == 0) goto L52
            java.lang.String r0 = r6.deserializeString()
            goto L27
        L52:
            aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor r2 = aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializer.MESSAGE_ALT1_DESCRIPTOR
            int r2 = r2.index
            if (r7 != 0) goto L59
            goto L60
        L59:
            int r5 = r7.intValue()
            if (r5 != r2) goto L60
            goto L6d
        L60:
            aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor r2 = aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializer.MESSAGE_ALT2_DESCRIPTOR
            int r2 = r2.index
            if (r7 != 0) goto L67
            goto L6f
        L67:
            int r5 = r7.intValue()
            if (r5 != r2) goto L6f
        L6d:
            r2 = r4
            goto L70
        L6f:
            r2 = r3
        L70:
            if (r2 == 0) goto L73
            goto L80
        L73:
            aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor r2 = aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializer.MESSAGE_ALT3_DESCRIPTOR
            int r2 = r2.index
            if (r7 != 0) goto L7a
            goto L81
        L7a:
            int r5 = r7.intValue()
            if (r5 != r2) goto L81
        L80:
            r3 = r4
        L81:
            if (r3 == 0) goto L88
            java.lang.String r1 = r6.deserializeString()
            goto L27
        L88:
            if (r7 == 0) goto L8e
            r6.skipValue()
            goto L27
        L8e:
            aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails r6 = new aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto La1
            java.lang.String r7 = "#"
            java.lang.String r7 = kotlin.text.StringsKt__StringsKt.substringAfter$default(r0, r7)
            java.lang.String r0 = ":"
            java.lang.String r7 = kotlin.text.StringsKt__StringsKt.substringBefore$default(r7, r0)
            goto La2
        La1:
            r7 = 0
        La2:
            java.lang.String r1 = (java.lang.String) r1
            r6.<init>(r7, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.awsprotocol.json.RestJsonErrorDeserializer.deserialize(aws.smithy.kotlin.runtime.http.Headers, byte[]):aws.smithy.kotlin.runtime.awsprotocol.ErrorDetails");
    }
}
