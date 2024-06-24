package androidx.profileinstaller;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class ProfileTranscoder {
    public static final byte[] MAGIC_PROF = {112, 114, 111, 0};
    public static final byte[] MAGIC_PROFM = {112, 114, 109, 0};

    public static byte[] createCompressibleBody(DexProfileData[] dexProfileDataArr, byte[] bArr) throws IOException {
        int r1 = 0;
        int r3 = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            r3 += (((((dexProfileData.numMethodIds * 2) + 8) - 1) & (-8)) / 8) + (dexProfileData.classSetSize * 2) + generateDexKey(dexProfileData.apkName, dexProfileData.dexName, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + dexProfileData.hotMethodRegionSize;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(r3);
        if (Arrays.equals(bArr, ProfileVersion.V009_O_MR1)) {
            int length = dexProfileDataArr.length;
            while (r1 < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[r1];
                writeLineHeader(byteArrayOutputStream, dexProfileData2, generateDexKey(dexProfileData2.apkName, dexProfileData2.dexName, bArr));
                writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData2);
                writeClasses(byteArrayOutputStream, dexProfileData2);
                writeMethodBitmap(byteArrayOutputStream, dexProfileData2);
                r1++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData3, generateDexKey(dexProfileData3.apkName, dexProfileData3.dexName, bArr));
            }
            int length2 = dexProfileDataArr.length;
            while (r1 < length2) {
                DexProfileData dexProfileData4 = dexProfileDataArr[r1];
                writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData4);
                writeClasses(byteArrayOutputStream, dexProfileData4);
                writeMethodBitmap(byteArrayOutputStream, dexProfileData4);
                r1++;
            }
        }
        if (byteArrayOutputStream.size() == r3) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + r3);
    }

    public static String generateDexKey(String str, String str2, byte[] bArr) {
        Object obj;
        byte[] bArr2 = ProfileVersion.V001_N;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = ProfileVersion.V005_O;
        String str3 = "!";
        if (!equals && !Arrays.equals(bArr, bArr3)) {
            obj = "!";
        } else {
            obj = ":";
        }
        if (str.length() <= 0) {
            if ("!".equals(obj)) {
                return str2.replace(":", "!");
            }
            if (":".equals(obj)) {
                str2 = str2.replace("!", ":");
            }
            return str2;
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (!str2.contains("!") && !str2.contains(":")) {
            if (str2.endsWith(".apk")) {
                return str2;
            }
            StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
            if (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) {
                str3 = ":";
            }
            return ComponentActivity$2$$ExternalSyntheticOutline0.m(m, str3, str2);
        }
        if ("!".equals(obj)) {
            return str2.replace(":", "!");
        }
        if (":".equals(obj)) {
            str2 = str2.replace("!", ":");
        }
        return str2;
    }

    public static int methodFlagBitmapIndex(int r1, int r2, int r3) {
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 == 4) {
                    return r2 + r3;
                }
                throw new IllegalStateException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Unexpected flag: ", r1));
            }
            return r2;
        }
        throw new IllegalStateException("HOT methods are not stored in the bitmap");
    }

    public static int[] readClasses(ByteArrayInputStream byteArrayInputStream, int r5) throws IOException {
        int[] r0 = new int[r5];
        int r2 = 0;
        for (int r1 = 0; r1 < r5; r1++) {
            r2 += Encoding.readUInt16(byteArrayInputStream);
            r0[r1] = r2;
        }
        return r0;
    }

    public static DexProfileData[] readMeta(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] bArr3 = ProfileVersion.METADATA_V001_N;
        if (Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(ProfileVersion.V015_S, bArr2)) {
                if (Arrays.equals(bArr, bArr3)) {
                    int readUInt = (int) Encoding.readUInt(fileInputStream, 1);
                    byte[] readCompressed = Encoding.readCompressed(fileInputStream, (int) Encoding.readUInt(fileInputStream, 4), (int) Encoding.readUInt(fileInputStream, 4));
                    if (fileInputStream.read() <= 0) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readCompressed);
                        try {
                            DexProfileData[] readMetadataForNBody = readMetadataForNBody(byteArrayInputStream, readUInt, dexProfileDataArr);
                            byteArrayInputStream.close();
                            return readMetadataForNBody;
                        } catch (Throwable th) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    throw new IllegalStateException("Content found after the end of file");
                }
                throw new IllegalStateException("Unsupported meta version");
            }
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (Arrays.equals(bArr, ProfileVersion.METADATA_V002)) {
            int readUInt16 = Encoding.readUInt16(fileInputStream);
            byte[] readCompressed2 = Encoding.readCompressed(fileInputStream, (int) Encoding.readUInt(fileInputStream, 4), (int) Encoding.readUInt(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(readCompressed2);
                try {
                    DexProfileData[] readMetadataV002Body = readMetadataV002Body(byteArrayInputStream2, bArr2, readUInt16, dexProfileDataArr);
                    byteArrayInputStream2.close();
                    return readMetadataV002Body;
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        }
        throw new IllegalStateException("Unsupported meta version");
    }

    public static DexProfileData[] readMetadataForNBody(ByteArrayInputStream byteArrayInputStream, int r8, DexProfileData[] dexProfileDataArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (r8 == dexProfileDataArr.length) {
            String[] strArr = new String[r8];
            int[] r2 = new int[r8];
            for (int r3 = 0; r3 < r8; r3++) {
                int readUInt16 = Encoding.readUInt16(byteArrayInputStream);
                r2[r3] = Encoding.readUInt16(byteArrayInputStream);
                strArr[r3] = new String(Encoding.read(byteArrayInputStream, readUInt16), StandardCharsets.UTF_8);
            }
            for (int r1 = 0; r1 < r8; r1++) {
                DexProfileData dexProfileData = dexProfileDataArr[r1];
                if (dexProfileData.dexName.equals(strArr[r1])) {
                    int r4 = r2[r1];
                    dexProfileData.classSetSize = r4;
                    dexProfileData.classes = readClasses(byteArrayInputStream, r4);
                } else {
                    throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dexProfileDataArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static DexProfileData[] readMetadataV002Body(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int r11, DexProfileData[] dexProfileDataArr) throws IOException {
        DexProfileData dexProfileData;
        String str;
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (r11 == dexProfileDataArr.length) {
            for (int r0 = 0; r0 < r11; r0++) {
                Encoding.readUInt16(byteArrayInputStream);
                String str2 = new String(Encoding.read(byteArrayInputStream, Encoding.readUInt16(byteArrayInputStream)), StandardCharsets.UTF_8);
                long readUInt = Encoding.readUInt(byteArrayInputStream, 4);
                int readUInt16 = Encoding.readUInt16(byteArrayInputStream);
                if (dexProfileDataArr.length > 0) {
                    int indexOf = str2.indexOf("!");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf(":");
                    }
                    if (indexOf > 0) {
                        str = str2.substring(indexOf + 1);
                    } else {
                        str = str2;
                    }
                    for (int r7 = 0; r7 < dexProfileDataArr.length; r7++) {
                        if (dexProfileDataArr[r7].dexName.equals(str)) {
                            dexProfileData = dexProfileDataArr[r7];
                            break;
                        }
                    }
                }
                dexProfileData = null;
                if (dexProfileData != null) {
                    dexProfileData.mTypeIdCount = readUInt;
                    int[] readClasses = readClasses(byteArrayInputStream, readUInt16);
                    if (Arrays.equals(bArr, ProfileVersion.V001_N)) {
                        dexProfileData.classSetSize = readUInt16;
                        dexProfileData.classes = readClasses;
                    }
                } else {
                    throw new IllegalStateException("Missing profile key: ".concat(str2));
                }
            }
            return dexProfileDataArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static DexProfileData[] readProfile(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.V010_P)) {
            int readUInt = (int) Encoding.readUInt(fileInputStream, 1);
            byte[] readCompressed = Encoding.readCompressed(fileInputStream, (int) Encoding.readUInt(fileInputStream, 4), (int) Encoding.readUInt(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readCompressed);
                try {
                    DexProfileData[] readUncompressedBody = readUncompressedBody(str, byteArrayInputStream, readUInt);
                    byteArrayInputStream.close();
                    return readUncompressedBody;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        }
        throw new IllegalStateException("Unsupported version");
    }

    public static DexProfileData[] readUncompressedBody(String str, ByteArrayInputStream byteArrayInputStream, int r19) throws IOException {
        TreeMap<Integer, Integer> treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[r19];
        for (int r4 = 0; r4 < r19; r4++) {
            int readUInt16 = Encoding.readUInt16(byteArrayInputStream);
            int readUInt162 = Encoding.readUInt16(byteArrayInputStream);
            dexProfileDataArr[r4] = new DexProfileData(str, new String(Encoding.read(byteArrayInputStream, readUInt16), StandardCharsets.UTF_8), Encoding.readUInt(byteArrayInputStream, 4), readUInt162, (int) Encoding.readUInt(byteArrayInputStream, 4), (int) Encoding.readUInt(byteArrayInputStream, 4), new int[readUInt162], new TreeMap());
        }
        for (int r42 = 0; r42 < r19; r42++) {
            DexProfileData dexProfileData = dexProfileDataArr[r42];
            int available = byteArrayInputStream.available() - dexProfileData.hotMethodRegionSize;
            int r8 = 0;
            while (true) {
                int available2 = byteArrayInputStream.available();
                treeMap = dexProfileData.methods;
                if (available2 <= available) {
                    break;
                }
                r8 += Encoding.readUInt16(byteArrayInputStream);
                treeMap.put(Integer.valueOf(r8), 1);
                for (int readUInt163 = Encoding.readUInt16(byteArrayInputStream); readUInt163 > 0; readUInt163--) {
                    Encoding.readUInt16(byteArrayInputStream);
                    int readUInt = (int) Encoding.readUInt(byteArrayInputStream, 1);
                    if (readUInt != 6 && readUInt != 7) {
                        while (readUInt > 0) {
                            Encoding.readUInt(byteArrayInputStream, 1);
                            for (int readUInt2 = (int) Encoding.readUInt(byteArrayInputStream, 1); readUInt2 > 0; readUInt2--) {
                                Encoding.readUInt16(byteArrayInputStream);
                            }
                            readUInt--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() == available) {
                dexProfileData.classes = readClasses(byteArrayInputStream, dexProfileData.classSetSize);
                int r6 = dexProfileData.numMethodIds;
                BitSet valueOf = BitSet.valueOf(Encoding.read(byteArrayInputStream, ((((r6 * 2) + 8) - 1) & (-8)) / 8));
                for (int r82 = 0; r82 < r6; r82++) {
                    int r9 = 2;
                    if (!valueOf.get(methodFlagBitmapIndex(2, r82, r6))) {
                        r9 = 0;
                    }
                    if (valueOf.get(methodFlagBitmapIndex(4, r82, r6))) {
                        r9 |= 4;
                    }
                    if (r9 != 0) {
                        Integer num = treeMap.get(Integer.valueOf(r82));
                        if (num == null) {
                            num = 0;
                        }
                        treeMap.put(Integer.valueOf(r82), Integer.valueOf(r9 | num.intValue()));
                    }
                }
            } else {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
        }
        return dexProfileDataArr;
    }

    public static boolean transcodeAndWriteBody(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        ArrayList arrayList;
        int length;
        byte[] bArr2 = ProfileVersion.V015_S;
        int r6 = 0;
        if (Arrays.equals(bArr, bArr2)) {
            ArrayList arrayList2 = new ArrayList(3);
            ArrayList arrayList3 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                Encoding.writeUInt16(byteArrayOutputStream2, dexProfileDataArr.length);
                int r9 = 2;
                int r11 = 2;
                for (DexProfileData dexProfileData : dexProfileDataArr) {
                    Encoding.writeUInt(byteArrayOutputStream2, dexProfileData.dexChecksum, 4);
                    Encoding.writeUInt(byteArrayOutputStream2, dexProfileData.mTypeIdCount, 4);
                    Encoding.writeUInt(byteArrayOutputStream2, dexProfileData.numMethodIds, 4);
                    String generateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, bArr2);
                    int length2 = generateDexKey.getBytes(StandardCharsets.UTF_8).length;
                    Encoding.writeUInt16(byteArrayOutputStream2, length2);
                    r11 = r11 + 4 + 4 + 4 + 2 + (length2 * 1);
                    byteArrayOutputStream2.write(generateDexKey.getBytes(StandardCharsets.UTF_8));
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (r11 == byteArray.length) {
                    WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.DEX_FILES, byteArray, false);
                    byteArrayOutputStream2.close();
                    arrayList2.add(writableFileSection);
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    int r10 = 0;
                    for (int r4 = 0; r4 < dexProfileDataArr.length; r4++) {
                        try {
                            DexProfileData dexProfileData2 = dexProfileDataArr[r4];
                            Encoding.writeUInt16(byteArrayOutputStream3, r4);
                            Encoding.writeUInt16(byteArrayOutputStream3, dexProfileData2.classSetSize);
                            r10 = r10 + 2 + 2 + (dexProfileData2.classSetSize * 2);
                            writeClasses(byteArrayOutputStream3, dexProfileData2);
                        } finally {
                        }
                    }
                    byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                    if (r10 == byteArray2.length) {
                        WritableFileSection writableFileSection2 = new WritableFileSection(FileSectionType.CLASSES, byteArray2, true);
                        byteArrayOutputStream3.close();
                        arrayList2.add(writableFileSection2);
                        byteArrayOutputStream3 = new ByteArrayOutputStream();
                        int r42 = 0;
                        int r102 = 0;
                        while (r42 < dexProfileDataArr.length) {
                            try {
                                DexProfileData dexProfileData3 = dexProfileDataArr[r42];
                                Iterator<Map.Entry<Integer, Integer>> it = dexProfileData3.methods.entrySet().iterator();
                                int r15 = r6;
                                while (it.hasNext()) {
                                    r15 |= it.next().getValue().intValue();
                                }
                                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                                try {
                                    writeMethodBitmap(byteArrayOutputStream4, dexProfileData3);
                                    byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                                    byteArrayOutputStream4.close();
                                    byteArrayOutputStream4 = new ByteArrayOutputStream();
                                    try {
                                        writeMethodsWithInlineCaches(byteArrayOutputStream4, dexProfileData3);
                                        byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                                        byteArrayOutputStream4.close();
                                        Encoding.writeUInt16(byteArrayOutputStream3, r42);
                                        int length3 = byteArray3.length + r9 + byteArray4.length;
                                        int r103 = r102 + 2 + 4;
                                        ArrayList arrayList4 = arrayList3;
                                        Encoding.writeUInt(byteArrayOutputStream3, length3, 4);
                                        Encoding.writeUInt16(byteArrayOutputStream3, r15);
                                        byteArrayOutputStream3.write(byteArray3);
                                        byteArrayOutputStream3.write(byteArray4);
                                        r102 = r103 + length3;
                                        r42++;
                                        arrayList3 = arrayList4;
                                        r6 = 0;
                                        r9 = 2;
                                    } finally {
                                    }
                                } finally {
                                }
                            } finally {
                            }
                        }
                        ArrayList arrayList5 = arrayList3;
                        byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
                        if (r102 == byteArray5.length) {
                            WritableFileSection writableFileSection3 = new WritableFileSection(FileSectionType.METHODS, byteArray5, true);
                            byteArrayOutputStream3.close();
                            arrayList2.add(writableFileSection3);
                            long j = 4;
                            long size = j + j + 4 + (arrayList2.size() * 16);
                            Encoding.writeUInt(byteArrayOutputStream, arrayList2.size(), 4);
                            int r43 = 0;
                            while (r43 < arrayList2.size()) {
                                WritableFileSection writableFileSection4 = (WritableFileSection) arrayList2.get(r43);
                                Encoding.writeUInt(byteArrayOutputStream, writableFileSection4.mType.getValue(), 4);
                                Encoding.writeUInt(byteArrayOutputStream, size, 4);
                                boolean z = writableFileSection4.mNeedsCompression;
                                byte[] bArr3 = writableFileSection4.mContents;
                                if (z) {
                                    long length4 = bArr3.length;
                                    byte[] compress = Encoding.compress(bArr3);
                                    arrayList = arrayList5;
                                    arrayList.add(compress);
                                    Encoding.writeUInt(byteArrayOutputStream, compress.length, 4);
                                    Encoding.writeUInt(byteArrayOutputStream, length4, 4);
                                    length = compress.length;
                                } else {
                                    arrayList = arrayList5;
                                    arrayList.add(bArr3);
                                    Encoding.writeUInt(byteArrayOutputStream, bArr3.length, 4);
                                    Encoding.writeUInt(byteArrayOutputStream, 0L, 4);
                                    length = bArr3.length;
                                }
                                size += length;
                                r43++;
                                arrayList5 = arrayList;
                            }
                            ArrayList arrayList6 = arrayList5;
                            for (int r62 = 0; r62 < arrayList6.size(); r62++) {
                                byteArrayOutputStream.write((byte[]) arrayList6.get(r62));
                            }
                            return true;
                        }
                        throw new IllegalStateException("Expected size " + r102 + ", does not match actual size " + byteArray5.length);
                    }
                    throw new IllegalStateException("Expected size " + r10 + ", does not match actual size " + byteArray2.length);
                }
                throw new IllegalStateException("Expected size " + r11 + ", does not match actual size " + byteArray.length);
            } finally {
                try {
                    byteArrayOutputStream2.close();
                    throw th;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
        }
        byte[] bArr4 = ProfileVersion.V010_P;
        if (Arrays.equals(bArr, bArr4)) {
            byte[] createCompressibleBody = createCompressibleBody(dexProfileDataArr, bArr4);
            Encoding.writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
            Encoding.writeUInt(byteArrayOutputStream, createCompressibleBody.length, 4);
            byte[] compress2 = Encoding.compress(createCompressibleBody);
            Encoding.writeUInt(byteArrayOutputStream, compress2.length, 4);
            byteArrayOutputStream.write(compress2);
            return true;
        }
        byte[] bArr5 = ProfileVersion.V005_O;
        if (Arrays.equals(bArr, bArr5)) {
            Encoding.writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
            for (DexProfileData dexProfileData4 : dexProfileDataArr) {
                int size2 = dexProfileData4.methods.size() * 4;
                String generateDexKey2 = generateDexKey(dexProfileData4.apkName, dexProfileData4.dexName, bArr5);
                Encoding.writeUInt16(byteArrayOutputStream, generateDexKey2.getBytes(StandardCharsets.UTF_8).length);
                Encoding.writeUInt16(byteArrayOutputStream, dexProfileData4.classes.length);
                Encoding.writeUInt(byteArrayOutputStream, size2, 4);
                Encoding.writeUInt(byteArrayOutputStream, dexProfileData4.dexChecksum, 4);
                byteArrayOutputStream.write(generateDexKey2.getBytes(StandardCharsets.UTF_8));
                Iterator<Integer> it2 = dexProfileData4.methods.keySet().iterator();
                while (it2.hasNext()) {
                    Encoding.writeUInt16(byteArrayOutputStream, it2.next().intValue());
                    Encoding.writeUInt16(byteArrayOutputStream, 0);
                }
                for (int r0 : dexProfileData4.classes) {
                    Encoding.writeUInt16(byteArrayOutputStream, r0);
                }
            }
            return true;
        }
        byte[] bArr6 = ProfileVersion.V009_O_MR1;
        if (Arrays.equals(bArr, bArr6)) {
            byte[] createCompressibleBody2 = createCompressibleBody(dexProfileDataArr, bArr6);
            Encoding.writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
            Encoding.writeUInt(byteArrayOutputStream, createCompressibleBody2.length, 4);
            byte[] compress3 = Encoding.compress(createCompressibleBody2);
            Encoding.writeUInt(byteArrayOutputStream, compress3.length, 4);
            byteArrayOutputStream.write(compress3);
            return true;
        }
        byte[] bArr7 = ProfileVersion.V001_N;
        if (Arrays.equals(bArr, bArr7)) {
            Encoding.writeUInt16(byteArrayOutputStream, dexProfileDataArr.length);
            for (DexProfileData dexProfileData5 : dexProfileDataArr) {
                String generateDexKey3 = generateDexKey(dexProfileData5.apkName, dexProfileData5.dexName, bArr7);
                Encoding.writeUInt16(byteArrayOutputStream, generateDexKey3.getBytes(StandardCharsets.UTF_8).length);
                TreeMap<Integer, Integer> treeMap = dexProfileData5.methods;
                Encoding.writeUInt16(byteArrayOutputStream, treeMap.size());
                Encoding.writeUInt16(byteArrayOutputStream, dexProfileData5.classes.length);
                Encoding.writeUInt(byteArrayOutputStream, dexProfileData5.dexChecksum, 4);
                byteArrayOutputStream.write(generateDexKey3.getBytes(StandardCharsets.UTF_8));
                Iterator<Integer> it3 = treeMap.keySet().iterator();
                while (it3.hasNext()) {
                    Encoding.writeUInt16(byteArrayOutputStream, it3.next().intValue());
                }
                for (int r02 : dexProfileData5.classes) {
                    Encoding.writeUInt16(byteArrayOutputStream, r02);
                }
            }
            return true;
        }
        return false;
    }

    public static void writeClasses(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) throws IOException {
        int r2 = 0;
        for (int r0 : dexProfileData.classes) {
            Integer valueOf = Integer.valueOf(r0);
            Encoding.writeUInt16(byteArrayOutputStream, valueOf.intValue() - r2);
            r2 = valueOf.intValue();
        }
    }

    public static void writeLineHeader(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData, String str) throws IOException {
        Encoding.writeUInt16(byteArrayOutputStream, str.getBytes(StandardCharsets.UTF_8).length);
        Encoding.writeUInt16(byteArrayOutputStream, dexProfileData.classSetSize);
        Encoding.writeUInt(byteArrayOutputStream, dexProfileData.hotMethodRegionSize, 4);
        Encoding.writeUInt(byteArrayOutputStream, dexProfileData.dexChecksum, 4);
        Encoding.writeUInt(byteArrayOutputStream, dexProfileData.numMethodIds, 4);
        byteArrayOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeMethodBitmap(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[((((dexProfileData.numMethodIds * 2) + 8) - 1) & (-8)) / 8];
        for (Map.Entry<Integer, Integer> entry : dexProfileData.methods.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            int r5 = intValue2 & 2;
            int r7 = dexProfileData.numMethodIds;
            if (r5 != 0) {
                int methodFlagBitmapIndex = methodFlagBitmapIndex(2, intValue, r7);
                int r8 = methodFlagBitmapIndex / 8;
                bArr[r8] = (byte) ((1 << (methodFlagBitmapIndex % 8)) | bArr[r8]);
            }
            if ((intValue2 & 4) != 0) {
                int methodFlagBitmapIndex2 = methodFlagBitmapIndex(4, intValue, r7);
                int r4 = methodFlagBitmapIndex2 / 8;
                bArr[r4] = (byte) ((1 << (methodFlagBitmapIndex2 % 8)) | bArr[r4]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeMethodsWithInlineCaches(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) throws IOException {
        int r1 = 0;
        for (Map.Entry<Integer, Integer> entry : dexProfileData.methods.entrySet()) {
            int intValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                Encoding.writeUInt16(byteArrayOutputStream, intValue - r1);
                Encoding.writeUInt16(byteArrayOutputStream, 0);
                r1 = intValue;
            }
        }
    }
}
