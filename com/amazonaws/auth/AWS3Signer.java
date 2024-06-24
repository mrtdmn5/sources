package com.amazonaws.auth;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Deprecated
/* loaded from: classes.dex */
public class AWS3Signer extends AbstractAWSSigner {
    private static final String AUTHORIZATION_HEADER = "X-Amzn-Authorization";
    private static final String HTTPS_SCHEME = "AWS3-HTTPS";
    private static final String HTTP_SCHEME = "AWS3";
    private static final String NONCE_HEADER = "x-amz-nonce";
    private static final Log log = LogFactory.getLog((Class<?>) AWS3Signer.class);
    private String overriddenDate;

    private String getSignedHeadersComponent(Request<?> request) {
        StringBuilder sb = new StringBuilder("SignedHeaders=");
        boolean z = true;
        for (String str : getHeadersForStringToSign(request)) {
            if (!z) {
                sb.append(";");
            }
            sb.append(str);
            z = false;
        }
        return sb.toString();
    }

    @Override // com.amazonaws.auth.AbstractAWSSigner
    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader(Headers.SECURITY_TOKEN, aWSSessionCredentials.getSessionToken());
    }

    public String getCanonicalizedHeadersForStringToSign(Request<?> request) {
        List<String> headersForStringToSign = getHeadersForStringToSign(request);
        for (int r1 = 0; r1 < headersForStringToSign.size(); r1++) {
            headersForStringToSign.set(r1, StringUtils.lowerCase(headersForStringToSign.get(r1)));
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            if (headersForStringToSign.contains(StringUtils.lowerCase(entry.getKey()))) {
                treeMap.put(StringUtils.lowerCase(entry.getKey()), entry.getValue());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry2 : treeMap.entrySet()) {
            sb.append(StringUtils.lowerCase((String) entry2.getKey()));
            sb.append(":");
            sb.append((String) entry2.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<String> getHeadersForStringToSign(Request<?> request) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = request.getHeaders().entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            String lowerCase = StringUtils.lowerCase(key);
            if (lowerCase.startsWith("x-amz") || "host".equals(lowerCase)) {
                arrayList.add(key);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public void overrideDate(String str) {
        this.overriddenDate = str;
    }

    public boolean shouldUseHttpsScheme(Request<?> request) {
        try {
            String lowerCase = StringUtils.lowerCase(request.getEndpoint().toURL().getProtocol());
            if ("http".equals(lowerCase)) {
                return false;
            }
            if ("https".equals(lowerCase)) {
                return true;
            }
            throw new AmazonClientException("Unknown request endpoint protocol encountered while signing request: " + lowerCase);
        } catch (MalformedURLException e) {
            throw new AmazonClientException("Unable to parse request endpoint during signing", e);
        }
    }

    @Override // com.amazonaws.auth.Signer
    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        if (aWSCredentials instanceof AnonymousAWSCredentials) {
            return;
        }
        AWSCredentials sanitizeCredentials = sanitizeCredentials(aWSCredentials);
        SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
        UUID.randomUUID().toString();
        String formatRFC822Date = DateUtils.formatRFC822Date(getSignatureDate(getTimeOffset(request)));
        String str = this.overriddenDate;
        if (str != null) {
            formatRFC822Date = str;
        }
        request.addHeader("Date", formatRFC822Date);
        request.addHeader("X-Amz-Date", formatRFC822Date);
        String host = request.getEndpoint().getHost();
        if (HttpUtils.isUsingNonDefaultPort(request.getEndpoint())) {
            StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(host, ":");
            m.append(request.getEndpoint().getPort());
            host = m.toString();
        }
        request.addHeader(HttpHeader.HOST, host);
        if (sanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) sanitizeCredentials);
        }
        String str2 = request.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(HttpUtils.appendUri(request.getEndpoint().getPath(), request.getResourcePath())) + "\n" + getCanonicalizedQueryString(request.getParameters()) + "\n" + getCanonicalizedHeadersForStringToSign(request) + "\n" + getRequestPayloadWithoutQueryParams(request);
        byte[] hash = hash(str2);
        log.debug("Calculated StringToSign: " + str2);
        String signAndBase64Encode = signAndBase64Encode(hash, sanitizeCredentials.getAWSSecretKey(), signingAlgorithm);
        StringBuilder m2 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(HTTP_SCHEME, " ");
        m2.append("AWSAccessKeyId=" + sanitizeCredentials.getAWSAccessKeyId() + ",");
        m2.append("Algorithm=" + signingAlgorithm.toString() + ",");
        m2.append(getSignedHeadersComponent(request) + ",");
        StringBuilder sb = new StringBuilder("Signature=");
        sb.append(signAndBase64Encode);
        m2.append(sb.toString());
        request.addHeader(AUTHORIZATION_HEADER, m2.toString());
    }
}
