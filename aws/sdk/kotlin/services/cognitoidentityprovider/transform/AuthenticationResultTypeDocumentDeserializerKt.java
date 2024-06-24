package aws.sdk.kotlin.services.cognitoidentityprovider.transform;

import aws.sdk.kotlin.services.cognitoidentity.transform.ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AuthenticationResultType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.NewDeviceMetadataType;
import aws.smithy.kotlin.runtime.serde.Deserializer$FieldIterator;
import aws.smithy.kotlin.runtime.serde.FieldTrait;
import aws.smithy.kotlin.runtime.serde.SdkFieldDescriptor;
import aws.smithy.kotlin.runtime.serde.SdkObjectDescriptor;
import aws.smithy.kotlin.runtime.serde.SerialKind;
import aws.smithy.kotlin.runtime.serde.json.JsonDeserializer;
import aws.smithy.kotlin.runtime.serde.json.JsonSerialName;

/* compiled from: AuthenticationResultTypeDocumentDeserializer.kt */
/* loaded from: classes.dex */
public final class AuthenticationResultTypeDocumentDeserializerKt {
    public static final AuthenticationResultType deserializeAuthenticationResultTypeDocument(JsonDeserializer jsonDeserializer) {
        SdkFieldDescriptor sdkFieldDescriptor;
        AuthenticationResultType.Builder builder = new AuthenticationResultType.Builder();
        SerialKind.String string = SerialKind.String.INSTANCE;
        int r4 = 1;
        SdkFieldDescriptor sdkFieldDescriptor2 = new SdkFieldDescriptor(string, new JsonSerialName("AccessToken"));
        SdkFieldDescriptor sdkFieldDescriptor3 = new SdkFieldDescriptor(SerialKind.Integer.INSTANCE, new JsonSerialName("ExpiresIn"));
        SdkFieldDescriptor sdkFieldDescriptor4 = new SdkFieldDescriptor(string, new JsonSerialName("IdToken"));
        SdkFieldDescriptor sdkFieldDescriptor5 = new SdkFieldDescriptor(SerialKind.Struct.INSTANCE, new JsonSerialName("NewDeviceMetadata"));
        SdkFieldDescriptor sdkFieldDescriptor6 = new SdkFieldDescriptor(string, new JsonSerialName("RefreshToken"));
        SdkFieldDescriptor sdkFieldDescriptor7 = new SdkFieldDescriptor(string, new JsonSerialName("TokenType"));
        SdkObjectDescriptor.Builder builder2 = new SdkObjectDescriptor.Builder();
        builder2.field(sdkFieldDescriptor2);
        builder2.field(sdkFieldDescriptor3);
        builder2.field(sdkFieldDescriptor4);
        builder2.field(sdkFieldDescriptor5);
        builder2.field(sdkFieldDescriptor6);
        builder2.field(sdkFieldDescriptor7);
        Deserializer$FieldIterator deserializeStruct = jsonDeserializer.deserializeStruct(new SdkObjectDescriptor(builder2));
        while (true) {
            Integer findNextFieldIndex = deserializeStruct.findNextFieldIndex();
            int r12 = sdkFieldDescriptor2.index;
            if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r12) {
                builder.accessToken = deserializeStruct.deserializeString();
            } else {
                int r122 = sdkFieldDescriptor3.index;
                if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r122) {
                    builder.expiresIn = deserializeStruct.deserializeInt();
                } else {
                    int r123 = sdkFieldDescriptor4.index;
                    if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r123) {
                        builder.idToken = deserializeStruct.deserializeString();
                    } else {
                        int r124 = sdkFieldDescriptor5.index;
                        if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r124) {
                            NewDeviceMetadataType.Builder builder3 = new NewDeviceMetadataType.Builder();
                            SerialKind.String string2 = SerialKind.String.INSTANCE;
                            FieldTrait[] fieldTraitArr = new FieldTrait[r4];
                            fieldTraitArr[0] = new JsonSerialName("DeviceGroupKey");
                            SdkFieldDescriptor sdkFieldDescriptor8 = new SdkFieldDescriptor(string2, fieldTraitArr);
                            sdkFieldDescriptor = sdkFieldDescriptor2;
                            SdkFieldDescriptor sdkFieldDescriptor9 = new SdkFieldDescriptor(string2, new JsonSerialName("DeviceKey"));
                            SdkObjectDescriptor.Builder builder4 = new SdkObjectDescriptor.Builder();
                            builder4.field(sdkFieldDescriptor8);
                            builder4.field(sdkFieldDescriptor9);
                            Deserializer$FieldIterator m = ExternalServiceExceptionDeserializer$$ExternalSyntheticOutline0.m(builder4, jsonDeserializer);
                            while (true) {
                                Integer findNextFieldIndex2 = m.findNextFieldIndex();
                                int r14 = sdkFieldDescriptor8.index;
                                if (findNextFieldIndex2 != null && findNextFieldIndex2.intValue() == r14) {
                                    builder3.deviceGroupKey = m.deserializeString();
                                } else {
                                    int r142 = sdkFieldDescriptor9.index;
                                    if (findNextFieldIndex2 != null && findNextFieldIndex2.intValue() == r142) {
                                        builder3.deviceKey = m.deserializeString();
                                    } else {
                                        if (findNextFieldIndex2 == null) {
                                            break;
                                        }
                                        m.skipValue();
                                    }
                                }
                            }
                            builder.newDeviceMetadata = new NewDeviceMetadataType(builder3);
                        } else {
                            sdkFieldDescriptor = sdkFieldDescriptor2;
                            int r2 = sdkFieldDescriptor6.index;
                            if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r2) {
                                builder.refreshToken = deserializeStruct.deserializeString();
                            } else {
                                int r22 = sdkFieldDescriptor7.index;
                                if (findNextFieldIndex != null && findNextFieldIndex.intValue() == r22) {
                                    builder.tokenType = deserializeStruct.deserializeString();
                                } else if (findNextFieldIndex != null) {
                                    deserializeStruct.skipValue();
                                } else {
                                    return new AuthenticationResultType(builder);
                                }
                            }
                        }
                        r4 = 1;
                        sdkFieldDescriptor2 = sdkFieldDescriptor;
                    }
                }
            }
        }
    }
}
