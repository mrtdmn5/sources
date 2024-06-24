package com.amazonaws.auth;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.internal.SdkDigestInputStream;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.animaconnected.secondo.notification.model.Contact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class AbstractAWSSigner implements Signer {
    private static final int BUFFER_SIZE_MULTIPLIER = 5;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int TIME_MILLISEC = 1000;
    private static final ThreadLocal<MessageDigest> SHA256_MESSAGE_DIGEST = new ThreadLocal<MessageDigest>() { // from class: com.amazonaws.auth.AbstractAWSSigner.1
        @Override // java.lang.ThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new AmazonClientException("Unable to get SHA256 Function" + e.getMessage(), e);
            }
        }
    };
    public static final String EMPTY_STRING_SHA256_HEX = BinaryUtils.toHex(doHash(""));

    private static byte[] doHash(String str) {
        try {
            MessageDigest messageDigestInstance = getMessageDigestInstance();
            messageDigestInstance.update(str.getBytes(StringUtils.UTF8));
            return messageDigestInstance.digest();
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to compute hash while signing request: ")), e);
        }
    }

    private static MessageDigest getMessageDigestInstance() {
        MessageDigest messageDigest = SHA256_MESSAGE_DIGEST.get();
        messageDigest.reset();
        return messageDigest;
    }

    public abstract void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials);

    public byte[] getBinaryRequestPayload(Request<?> request) {
        if (HttpUtils.usePayloadForQueryParameters(request)) {
            String encodeParameters = HttpUtils.encodeParameters(request);
            if (encodeParameters == null) {
                return new byte[0];
            }
            return encodeParameters.getBytes(StringUtils.UTF8);
        }
        return getBinaryRequestPayloadWithoutQueryParams(request);
    }

    public InputStream getBinaryRequestPayloadStream(Request<?> request) {
        if (HttpUtils.usePayloadForQueryParameters(request)) {
            String encodeParameters = HttpUtils.encodeParameters(request);
            if (encodeParameters == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            return new ByteArrayInputStream(encodeParameters.getBytes(StringUtils.UTF8));
        }
        return getBinaryRequestPayloadStreamWithoutQueryParams(request);
    }

    public InputStream getBinaryRequestPayloadStreamWithoutQueryParams(Request<?> request) {
        try {
            InputStream content = request.getContent();
            if (content == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            if (content instanceof StringInputStream) {
                return content;
            }
            if (content.markSupported()) {
                return request.getContent();
            }
            throw new AmazonClientException("Unable to read request payload to sign request.");
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to read request payload to sign request: ")), e);
        }
    }

    public byte[] getBinaryRequestPayloadWithoutQueryParams(Request<?> request) {
        InputStream binaryRequestPayloadStreamWithoutQueryParams = getBinaryRequestPayloadStreamWithoutQueryParams(request);
        try {
            binaryRequestPayloadStreamWithoutQueryParams.mark(-1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[5120];
            while (true) {
                int read = binaryRequestPayloadStreamWithoutQueryParams.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.close();
                    binaryRequestPayloadStreamWithoutQueryParams.reset();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to read request payload to sign request: ")), e);
        }
    }

    public String getCanonicalizedEndpoint(URI r3) {
        String lowerCase = StringUtils.lowerCase(r3.getHost());
        if (HttpUtils.isUsingNonDefaultPort(r3)) {
            StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(lowerCase, ":");
            m.append(r3.getPort());
            return m.toString();
        }
        return lowerCase;
    }

    public String getCanonicalizedQueryString(Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            treeMap.put(HttpUtils.urlEncode(entry.getKey(), false), HttpUtils.urlEncode(entry.getValue(), false));
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append((String) entry2.getKey());
            sb.append("=");
            sb.append((String) entry2.getValue());
            if (it.hasNext()) {
                sb.append(Contact.PHONE_NUMBERS_DELIMITER);
            }
        }
        return sb.toString();
    }

    public String getCanonicalizedResourcePath(String str) {
        return getCanonicalizedResourcePath(str, true);
    }

    public String getRequestPayload(Request<?> request) {
        return newString(getBinaryRequestPayload(request));
    }

    public String getRequestPayloadWithoutQueryParams(Request<?> request) {
        return newString(getBinaryRequestPayloadWithoutQueryParams(request));
    }

    public Date getSignatureDate(long j) {
        Date date = new Date();
        if (j != 0) {
            return new Date(date.getTime() - (j * 1000));
        }
        return date;
    }

    public long getTimeOffset(Request<?> request) {
        long timeOffset = request.getTimeOffset();
        if (SDKGlobalConfiguration.getGlobalTimeOffset() != 0) {
            return SDKGlobalConfiguration.getGlobalTimeOffset();
        }
        return timeOffset;
    }

    public byte[] hash(String str) {
        return doHash(str);
    }

    public String newString(byte[] bArr) {
        return new String(bArr, StringUtils.UTF8);
    }

    public AWSCredentials sanitizeCredentials(AWSCredentials aWSCredentials) {
        String aWSAccessKeyId;
        String aWSSecretKey;
        String str;
        synchronized (aWSCredentials) {
            aWSAccessKeyId = aWSCredentials.getAWSAccessKeyId();
            aWSSecretKey = aWSCredentials.getAWSSecretKey();
            if (aWSCredentials instanceof AWSSessionCredentials) {
                str = ((AWSSessionCredentials) aWSCredentials).getSessionToken();
            } else {
                str = null;
            }
        }
        if (aWSSecretKey != null) {
            aWSSecretKey = aWSSecretKey.trim();
        }
        if (aWSAccessKeyId != null) {
            aWSAccessKeyId = aWSAccessKeyId.trim();
        }
        if (str != null) {
            str = str.trim();
        }
        if (aWSCredentials instanceof AWSSessionCredentials) {
            return new BasicSessionCredentials(aWSAccessKeyId, aWSSecretKey, str);
        }
        return new BasicAWSCredentials(aWSAccessKeyId, aWSSecretKey);
    }

    public byte[] sign(String str, byte[] bArr, SigningAlgorithm signingAlgorithm) {
        try {
            return sign(str.getBytes(StringUtils.UTF8), bArr, signingAlgorithm);
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to calculate a request signature: ")), e);
        }
    }

    public String signAndBase64Encode(String str, String str2, SigningAlgorithm signingAlgorithm) {
        return signAndBase64Encode(str.getBytes(StringUtils.UTF8), str2, signingAlgorithm);
    }

    public String getCanonicalizedResourcePath(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return "/";
        }
        if (z) {
            str = HttpUtils.urlEncode(str, true);
        }
        return str.startsWith("/") ? str : "/".concat(str);
    }

    public byte[] hash(InputStream inputStream) {
        try {
            SdkDigestInputStream sdkDigestInputStream = new SdkDigestInputStream(inputStream, getMessageDigestInstance());
            do {
            } while (sdkDigestInputStream.read(new byte[1024]) > -1);
            return sdkDigestInputStream.getMessageDigest().digest();
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to compute hash while signing request: ")), e);
        }
    }

    public String signAndBase64Encode(byte[] bArr, String str, SigningAlgorithm signingAlgorithm) {
        try {
            return Base64.encodeAsString(sign(bArr, str.getBytes(StringUtils.UTF8), signingAlgorithm));
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to calculate a request signature: ")), e);
        }
    }

    public byte[] sign(byte[] bArr, byte[] bArr2, SigningAlgorithm signingAlgorithm) {
        try {
            Mac mac = Mac.getInstance(signingAlgorithm.toString());
            mac.init(new SecretKeySpec(bArr2, signingAlgorithm.toString()));
            return mac.doFinal(bArr);
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to calculate a request signature: ")), e);
        }
    }

    public byte[] hash(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to compute hash while signing request: ")), e);
        }
    }

    public String getCanonicalizedQueryString(Request<?> request) {
        return HttpUtils.usePayloadForQueryParameters(request) ? "" : getCanonicalizedQueryString(request.getParameters());
    }
}
