package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.util.DateUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class QueryStringSigner extends AbstractAWSSigner {
    private Date overriddenDate;

    private String calculateStringToSignV1(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(map);
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }

    private String calculateStringToSignV2(Request<?> request) {
        return "POST\n" + getCanonicalizedEndpoint(request.getEndpoint()) + "\n" + getCanonicalizedResourcePath(request) + "\n" + getCanonicalizedQueryString(request.getParameters());
    }

    private String getCanonicalizedResourcePath(Request<?> request) {
        String str = "";
        if (request.getEndpoint().getPath() != null) {
            str = "" + request.getEndpoint().getPath();
        }
        if (request.getResourcePath() != null) {
            if (str.length() > 0 && !str.endsWith("/") && !request.getResourcePath().startsWith("/")) {
                str = str.concat("/");
            }
            StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
            m.append(request.getResourcePath());
            str = m.toString();
        } else if (!str.endsWith("/")) {
            str = str.concat("/");
        }
        if (!str.startsWith("/")) {
            str = "/".concat(str);
        }
        if (str.startsWith("//")) {
            return str.substring(1);
        }
        return str;
    }

    private String getFormattedTimestamp(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        Date date = this.overriddenDate;
        if (date != null) {
            return simpleDateFormat.format(date);
        }
        return simpleDateFormat.format(getSignatureDate(j));
    }

    @Override // com.amazonaws.auth.AbstractAWSSigner
    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addParameter("SecurityToken", aWSSessionCredentials.getSessionToken());
    }

    public void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    @Override // com.amazonaws.auth.Signer
    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        sign(request, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, aWSCredentials);
    }

    public void sign(Request<?> request, SignatureVersion signatureVersion, SigningAlgorithm signingAlgorithm, AWSCredentials aWSCredentials) {
        String calculateStringToSignV2;
        if (aWSCredentials instanceof AnonymousAWSCredentials) {
            return;
        }
        AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
        request.addParameter("AWSAccessKeyId", sanitizeCredentials.getAWSAccessKeyId());
        request.addParameter("SignatureVersion", signatureVersion.toString());
        request.addParameter("Timestamp", getFormattedTimestamp(getTimeOffset(request)));
        if (sanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
        }
        if (signatureVersion.equals(SignatureVersion.V1)) {
            calculateStringToSignV2 = calculateStringToSignV1(request.getParameters());
        } else if (signatureVersion.equals(SignatureVersion.V2)) {
            request.addParameter("SignatureMethod", signingAlgorithm.toString());
            calculateStringToSignV2 = calculateStringToSignV2(request);
        } else {
            throw new AmazonClientException("Invalid Signature Version specified");
        }
        request.addParameter("Signature", signAndBase64Encode(calculateStringToSignV2, sanitizeCredentials.getAWSSecretKey(), signingAlgorithm));
    }
}
