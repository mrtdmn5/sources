package com.amazonaws.services.s3.internal.crypto;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.InputSubstream;
import com.amazonaws.services.s3.internal.RepeatableCipherInputStream;
import com.amazonaws.services.s3.internal.RepeatableFileInputStream;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsAccessor;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amazonaws.util.Base64;
import com.amazonaws.util.LengthCheckInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
/* loaded from: classes.dex */
public class EncryptionUtils {
    static final String INSTRUCTION_SUFFIX = ".instruction";

    public static S3Object adjustOutputToDesiredRange(S3Object s3Object, long[] jArr) {
        if (jArr != null && jArr[0] <= jArr[1]) {
            try {
                s3Object.setObjectContent(new S3ObjectInputStream(new AdjustedRangeInputStream(s3Object.getObjectContent(), jArr[0], jArr[1])));
                return s3Object;
            } catch (IOException e) {
                throw new AmazonClientException("Error adjusting output to desired byte range: " + e.getMessage());
            }
        }
        return s3Object;
    }

    private static EncryptionInstruction buildInstruction(EncryptionMaterials encryptionMaterials, Provider provider) {
        SecretKey generateOneTimeUseSymmetricKey = generateOneTimeUseSymmetricKey();
        CipherFactory cipherFactory = new CipherFactory(generateOneTimeUseSymmetricKey, 1, null, provider);
        return new EncryptionInstruction(encryptionMaterials.getMaterialsDescription(), getEncryptedSymmetricKey(generateOneTimeUseSymmetricKey, encryptionMaterials, provider), generateOneTimeUseSymmetricKey, cipherFactory);
    }

    @Deprecated
    public static EncryptionInstruction buildInstructionFromInstructionFile(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return buildInstructionFromInstructionFile(s3Object, new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    @Deprecated
    public static EncryptionInstruction buildInstructionFromObjectMetadata(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return buildInstructionFromObjectMetadata(s3Object, new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    private static long calculateCryptoContentLength(Cipher cipher, PutObjectRequest putObjectRequest, ObjectMetadata objectMetadata) {
        long unencryptedContentLength = getUnencryptedContentLength(putObjectRequest, objectMetadata);
        if (unencryptedContentLength < 0) {
            return -1L;
        }
        long blockSize = cipher.getBlockSize();
        return (blockSize - (unencryptedContentLength % blockSize)) + unencryptedContentLength;
    }

    private static Map<String, String> convertInstructionToJSONObject(EncryptionInstruction encryptionInstruction) {
        HashMap hashMap = new HashMap();
        hashMap.put(Headers.MATERIALS_DESCRIPTION, JsonUtils.mapToString(encryptionInstruction.getMaterialsDescription()));
        hashMap.put(Headers.CRYPTO_KEY, Base64.encodeAsString(encryptionInstruction.getEncryptedSymmetricKey()));
        hashMap.put(Headers.CRYPTO_IV, Base64.encodeAsString(encryptionInstruction.getSymmetricCipher().getIV()));
        return hashMap;
    }

    private static Map<String, String> convertJSONToMap(String str) {
        if (str == null) {
            return null;
        }
        try {
            return JsonUtils.jsonToMap(str);
        } catch (AmazonClientException e) {
            throw new AmazonClientException("Unable to parse encryption materials description from metadata :" + e.getMessage());
        }
    }

    private static String convertStreamToString(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    inputStream.close();
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public static DeleteObjectRequest createInstructionDeleteObjectRequest(DeleteObjectRequest deleteObjectRequest) {
        return new DeleteObjectRequest(deleteObjectRequest.getBucketName(), deleteObjectRequest.getKey() + INSTRUCTION_SUFFIX);
    }

    public static GetObjectRequest createInstructionGetRequest(GetObjectRequest getObjectRequest) {
        return new GetObjectRequest(getObjectRequest.getBucketName(), getObjectRequest.getKey() + INSTRUCTION_SUFFIX, getObjectRequest.getVersionId());
    }

    public static PutObjectRequest createInstructionPutRequest(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(JsonUtils.mapToString(convertInstructionToJSONObject(encryptionInstruction)).getBytes(StringUtils.UTF8));
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        metadata.setContentLength(r5.length);
        metadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, "");
        putObjectRequest.setKey(putObjectRequest.getKey() + INSTRUCTION_SUFFIX);
        putObjectRequest.setMetadata(metadata);
        putObjectRequest.setInputStream(byteArrayInputStream);
        return putObjectRequest;
    }

    public static Cipher createSymmetricCipher(SecretKey secretKey, int r2, Provider provider, byte[] bArr) {
        Cipher cipher;
        try {
            if (provider != null) {
                cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD, provider);
            } else {
                cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            }
            if (bArr != null) {
                cipher.init(r2, secretKey, new IvParameterSpec(bArr));
            } else {
                cipher.init(r2, secretKey);
            }
            return cipher;
        } catch (Exception e) {
            throw new AmazonClientException("Unable to build cipher: " + e.getMessage() + "\nMake sure you have the JCE unlimited strength policy files installed and configured for your JVM: http://www.ngs.ac.uk/tools/jcepolicyfiles", e);
        }
    }

    public static S3Object decryptObjectUsingInstruction(S3Object s3Object, EncryptionInstruction encryptionInstruction) {
        s3Object.setObjectContent(new S3ObjectInputStream(new RepeatableCipherInputStream(s3Object.getObjectContent(), encryptionInstruction.getCipherFactory())));
        return s3Object;
    }

    @Deprecated
    public static S3Object decryptObjectUsingMetadata(S3Object s3Object, EncryptionMaterials encryptionMaterials, Provider provider) {
        return decryptObjectUsingInstruction(s3Object, buildInstructionFromObjectMetadata(s3Object, encryptionMaterials, provider));
    }

    public static PutObjectRequest encryptRequestUsingInstruction(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        if (metadata.getContentMD5() != null) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_MD5, metadata.getContentMD5());
        }
        metadata.setContentMD5(null);
        long unencryptedContentLength = getUnencryptedContentLength(putObjectRequest, metadata);
        if (unencryptedContentLength >= 0) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_LENGTH, Long.toString(unencryptedContentLength));
        }
        long calculateCryptoContentLength = calculateCryptoContentLength(encryptionInstruction.getSymmetricCipher(), putObjectRequest, metadata);
        if (calculateCryptoContentLength >= 0) {
            metadata.setContentLength(calculateCryptoContentLength);
        }
        putObjectRequest.setMetadata(metadata);
        putObjectRequest.setInputStream(getEncryptedInputStream(putObjectRequest, encryptionInstruction.getCipherFactory(), unencryptedContentLength));
        putObjectRequest.setFile(null);
        return putObjectRequest;
    }

    @Deprecated
    public static PutObjectRequest encryptRequestUsingMetadata(PutObjectRequest putObjectRequest, EncryptionMaterials encryptionMaterials, Provider provider) {
        EncryptionInstruction generateInstruction = generateInstruction(encryptionMaterials, provider);
        PutObjectRequest encryptRequestUsingInstruction = encryptRequestUsingInstruction(putObjectRequest, generateInstruction);
        updateMetadataWithEncryptionInstruction(putObjectRequest, generateInstruction);
        return encryptRequestUsingInstruction;
    }

    @Deprecated
    public static EncryptionInstruction generateInstruction(EncryptionMaterials encryptionMaterials, Provider provider) {
        return generateInstruction(new StaticEncryptionMaterialsProvider(encryptionMaterials), provider);
    }

    public static SecretKey generateOneTimeUseSymmetricKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            keyGenerator.init(256, new SecureRandom());
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new AmazonClientException("Unable to generate envelope symmetric key:" + e.getMessage(), e);
        }
    }

    public static long[] getAdjustedCryptoRange(long[] jArr) {
        if (jArr != null) {
            long j = jArr[0];
            if (j <= jArr[1]) {
                return new long[]{getCipherBlockLowerBound(j), getCipherBlockUpperBound(jArr[1])};
            }
            return null;
        }
        return null;
    }

    private static long getCipherBlockLowerBound(long j) {
        long j2 = (j - (j % 16)) - 16;
        if (j2 < 0) {
            return 0L;
        }
        return j2;
    }

    private static long getCipherBlockUpperBound(long j) {
        return (16 - (j % 16)) + j + 16;
    }

    private static byte[] getCryptoBytesFromMetadata(String str, ObjectMetadata objectMetadata) {
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata != null && userMetadata.containsKey(str)) {
            return Base64.decode(userMetadata.get(str));
        }
        return null;
    }

    private static SecretKey getDecryptedSymmetricKey(byte[] bArr, EncryptionMaterials encryptionMaterials, Provider provider) {
        Key symmetricKey;
        Cipher cipher;
        if (encryptionMaterials.getKeyPair() != null) {
            symmetricKey = encryptionMaterials.getKeyPair().getPrivate();
        } else {
            symmetricKey = encryptionMaterials.getSymmetricKey();
        }
        try {
            if (provider != null) {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm(), provider);
            } else {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm());
            }
            cipher.init(2, symmetricKey);
            return new SecretKeySpec(cipher.doFinal(bArr), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to decrypt symmetric key from object metadata : ")), e);
        }
    }

    private static InputStream getEncryptedInputStream(PutObjectRequest putObjectRequest, CipherFactory cipherFactory, long j) {
        try {
            InputStream inputStream = putObjectRequest.getInputStream();
            if (putObjectRequest.getFile() != null) {
                inputStream = new RepeatableFileInputStream(putObjectRequest.getFile());
            }
            if (j > -1) {
                inputStream = new LengthCheckInputStream(inputStream, j, false);
            }
            return new RepeatableCipherInputStream(inputStream, cipherFactory);
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to create cipher input stream: ")), e);
        }
    }

    public static byte[] getEncryptedSymmetricKey(SecretKey secretKey, EncryptionMaterials encryptionMaterials, Provider provider) {
        Key symmetricKey;
        Cipher cipher;
        if (encryptionMaterials.getKeyPair() != null) {
            symmetricKey = encryptionMaterials.getKeyPair().getPublic();
        } else {
            symmetricKey = encryptionMaterials.getSymmetricKey();
        }
        try {
            byte[] encoded = secretKey.getEncoded();
            if (provider != null) {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm(), provider);
            } else {
                cipher = Cipher.getInstance(symmetricKey.getAlgorithm());
            }
            cipher.init(1, symmetricKey);
            return cipher.doFinal(encoded);
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to encrypt symmetric key: ")), e);
        }
    }

    private static String getStringFromMetadata(String str, ObjectMetadata objectMetadata) {
        Map<String, String> userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata != null && userMetadata.containsKey(str)) {
            return userMetadata.get(str);
        }
        return null;
    }

    private static long getUnencryptedContentLength(PutObjectRequest putObjectRequest, ObjectMetadata objectMetadata) {
        if (putObjectRequest.getFile() != null) {
            return putObjectRequest.getFile().length();
        }
        if (putObjectRequest.getInputStream() != null && objectMetadata.getRawMetadataValue("Content-Length") != null) {
            return objectMetadata.getContentLength();
        }
        return -1L;
    }

    public static boolean isEncryptionInfoInInstructionFile(S3Object s3Object) {
        Map<String, String> userMetadata;
        if (s3Object == null || (userMetadata = s3Object.getObjectMetadata().getUserMetadata()) == null) {
            return false;
        }
        return userMetadata.containsKey(Headers.CRYPTO_INSTRUCTION_FILE);
    }

    public static boolean isEncryptionInfoInMetadata(S3Object s3Object) {
        Map<String, String> userMetadata = s3Object.getObjectMetadata().getUserMetadata();
        if (userMetadata != null && userMetadata.containsKey(Headers.CRYPTO_IV) && userMetadata.containsKey(Headers.CRYPTO_KEY)) {
            return true;
        }
        return false;
    }

    private static Map<String, String> parseJSONInstruction(S3Object s3Object) {
        try {
            return JsonUtils.jsonToMap(convertStreamToString(s3Object.getObjectContent()));
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error parsing JSON instruction file: ")));
        }
    }

    private static EncryptionMaterials retrieveOriginalMaterials(Map<String, String> map, EncryptionMaterialsAccessor encryptionMaterialsAccessor) {
        if (encryptionMaterialsAccessor == null) {
            return null;
        }
        return encryptionMaterialsAccessor.getEncryptionMaterials(map);
    }

    private static void updateMetadata(ObjectMetadata objectMetadata, byte[] bArr, Cipher cipher, Map<String, String> map) {
        if (bArr != null) {
            objectMetadata.addUserMetadata(Headers.CRYPTO_KEY, Base64.encodeAsString(bArr));
        }
        objectMetadata.addUserMetadata(Headers.CRYPTO_IV, Base64.encodeAsString(cipher.getIV()));
        objectMetadata.addUserMetadata(Headers.MATERIALS_DESCRIPTION, JsonUtils.mapToString(map));
    }

    public static ObjectMetadata updateMetadataWithEncryptionInfo(InitiateMultipartUploadRequest initiateMultipartUploadRequest, byte[] bArr, Cipher cipher, Map<String, String> map) {
        ObjectMetadata objectMetadata = initiateMultipartUploadRequest.getObjectMetadata();
        if (objectMetadata == null) {
            objectMetadata = new ObjectMetadata();
        }
        updateMetadata(objectMetadata, bArr, cipher, map);
        return objectMetadata;
    }

    public static void updateMetadataWithEncryptionInstruction(PutObjectRequest putObjectRequest, EncryptionInstruction encryptionInstruction) {
        byte[] encryptedSymmetricKey = encryptionInstruction.getEncryptedSymmetricKey();
        Cipher symmetricCipher = encryptionInstruction.getSymmetricCipher();
        Map<String, String> materialsDescription = encryptionInstruction.getMaterialsDescription();
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        if (putObjectRequest.getFile() != null) {
            metadata.setContentType(Mimetypes.getInstance().getMimetype(putObjectRequest.getFile()));
        }
        updateMetadata(metadata, encryptedSymmetricKey, symmetricCipher, materialsDescription);
        putObjectRequest.setMetadata(metadata);
    }

    public static EncryptionInstruction buildInstructionFromInstructionFile(S3Object s3Object, EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        Map<String, String> parseJSONInstruction = parseJSONInstruction(s3Object);
        String str = parseJSONInstruction.get(Headers.CRYPTO_KEY);
        String str2 = parseJSONInstruction.get(Headers.CRYPTO_IV);
        Map<String, String> convertJSONToMap = convertJSONToMap(parseJSONInstruction.get(Headers.MATERIALS_DESCRIPTION));
        byte[] decode = Base64.decode(str);
        byte[] decode2 = Base64.decode(str2);
        if (decode != null && decode2 != null) {
            EncryptionMaterials retrieveOriginalMaterials = retrieveOriginalMaterials(convertJSONToMap, encryptionMaterialsProvider);
            if (retrieveOriginalMaterials != null) {
                SecretKey decryptedSymmetricKey = getDecryptedSymmetricKey(decode, retrieveOriginalMaterials, provider);
                return new EncryptionInstruction(convertJSONToMap, decode, decryptedSymmetricKey, new CipherFactory(decryptedSymmetricKey, 2, decode2, provider));
            }
            throw new AmazonClientException(String.format("Unable to retrieve the encryption materials that originally encrypted object corresponding to instruction file '%s' in bucket '%s'.", s3Object.getKey(), s3Object.getBucketName()));
        }
        throw new AmazonClientException(String.format("Necessary encryption info not found in the instruction file '%s' in bucket '%s'", s3Object.getKey(), s3Object.getBucketName()));
    }

    public static EncryptionInstruction buildInstructionFromObjectMetadata(S3Object s3Object, EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        ObjectMetadata objectMetadata = s3Object.getObjectMetadata();
        byte[] cryptoBytesFromMetadata = getCryptoBytesFromMetadata(Headers.CRYPTO_KEY, objectMetadata);
        byte[] cryptoBytesFromMetadata2 = getCryptoBytesFromMetadata(Headers.CRYPTO_IV, objectMetadata);
        Map<String, String> convertJSONToMap = convertJSONToMap(getStringFromMetadata(Headers.MATERIALS_DESCRIPTION, objectMetadata));
        if (cryptoBytesFromMetadata != null && cryptoBytesFromMetadata2 != null) {
            EncryptionMaterials retrieveOriginalMaterials = retrieveOriginalMaterials(convertJSONToMap, encryptionMaterialsProvider);
            if (retrieveOriginalMaterials != null) {
                SecretKey decryptedSymmetricKey = getDecryptedSymmetricKey(cryptoBytesFromMetadata, retrieveOriginalMaterials, provider);
                return new EncryptionInstruction(convertJSONToMap, cryptoBytesFromMetadata, decryptedSymmetricKey, new CipherFactory(decryptedSymmetricKey, 2, cryptoBytesFromMetadata2, provider));
            }
            throw new AmazonClientException(String.format("Unable to retrieve the encryption materials that originally encrypted file '%s' in bucket '%s'.", s3Object.getKey(), s3Object.getBucketName()));
        }
        throw new AmazonClientException(String.format("Necessary encryption info not found in the headers of file '%s' in bucket '%s'", s3Object.getKey(), s3Object.getBucketName()));
    }

    public static EncryptionInstruction generateInstruction(EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider) {
        return buildInstruction(encryptionMaterialsProvider.getEncryptionMaterials(), provider);
    }

    public static EncryptionInstruction generateInstruction(EncryptionMaterialsProvider encryptionMaterialsProvider, Map<String, String> map, Provider provider) {
        return buildInstruction(encryptionMaterialsProvider.getEncryptionMaterials(map), provider);
    }

    public static long calculateCryptoContentLength(Cipher cipher, UploadPartRequest uploadPartRequest) {
        long partSize;
        if (uploadPartRequest.getFile() != null) {
            if (uploadPartRequest.getPartSize() > 0) {
                partSize = uploadPartRequest.getPartSize();
            } else {
                partSize = uploadPartRequest.getFile().length();
            }
        } else {
            if (uploadPartRequest.getInputStream() == null) {
                return -1L;
            }
            partSize = uploadPartRequest.getPartSize();
        }
        long blockSize = cipher.getBlockSize();
        return (blockSize - (partSize % blockSize)) + partSize;
    }

    public static PutObjectRequest createInstructionPutRequest(String str, String str2, EncryptionInstruction encryptionInstruction) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(JsonUtils.mapToString(convertInstructionToJSONObject(encryptionInstruction)).getBytes(StringUtils.UTF8));
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(r6.length);
        objectMetadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, "");
        return new PutObjectRequest(str, ComposableInvoker$$ExternalSyntheticOutline0.m(str2, INSTRUCTION_SUFFIX), byteArrayInputStream, objectMetadata);
    }

    public static ByteRangeCapturingInputStream getEncryptedInputStream(UploadPartRequest uploadPartRequest, CipherFactory cipherFactory) {
        try {
            InputStream inputStream = uploadPartRequest.getInputStream();
            if (uploadPartRequest.getFile() != null) {
                inputStream = new InputSubstream(new RepeatableFileInputStream(uploadPartRequest.getFile()), uploadPartRequest.getFileOffset(), uploadPartRequest.getPartSize(), uploadPartRequest.isLastPart());
            }
            FilterInputStream repeatableCipherInputStream = new RepeatableCipherInputStream(inputStream, cipherFactory);
            FilterInputStream inputSubstream = !uploadPartRequest.isLastPart() ? new InputSubstream(repeatableCipherInputStream, 0L, uploadPartRequest.getPartSize(), false) : repeatableCipherInputStream;
            long partSize = uploadPartRequest.getPartSize();
            return new ByteRangeCapturingInputStream(inputSubstream, partSize - cipherFactory.createCipher().getBlockSize(), partSize);
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to create cipher input stream: ")), e);
        }
    }
}
