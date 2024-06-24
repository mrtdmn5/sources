package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GrantConstraints;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Map;

/* loaded from: classes.dex */
class GrantConstraintsJsonMarshaller {
    private static GrantConstraintsJsonMarshaller instance;

    public static GrantConstraintsJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new GrantConstraintsJsonMarshaller();
        }
        return instance;
    }

    public void marshall(GrantConstraints grantConstraints, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (grantConstraints.getEncryptionContextSubset() != null) {
            Map<String, String> encryptionContextSubset = grantConstraints.getEncryptionContextSubset();
            awsJsonWriter.name("EncryptionContextSubset");
            awsJsonWriter.beginObject();
            for (Map.Entry<String, String> entry : encryptionContextSubset.entrySet()) {
                String value = entry.getValue();
                if (value != null) {
                    awsJsonWriter.name(entry.getKey());
                    awsJsonWriter.value(value);
                }
            }
            awsJsonWriter.endObject();
        }
        if (grantConstraints.getEncryptionContextEquals() != null) {
            Map<String, String> encryptionContextEquals = grantConstraints.getEncryptionContextEquals();
            awsJsonWriter.name("EncryptionContextEquals");
            awsJsonWriter.beginObject();
            for (Map.Entry<String, String> entry2 : encryptionContextEquals.entrySet()) {
                String value2 = entry2.getValue();
                if (value2 != null) {
                    awsJsonWriter.name(entry2.getKey());
                    awsJsonWriter.value(value2);
                }
            }
            awsJsonWriter.endObject();
        }
        awsJsonWriter.endObject();
    }
}
