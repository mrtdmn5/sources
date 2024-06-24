package no.nordicsemi.android.dfu.internal;

import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;

/* loaded from: classes4.dex */
public class ArchiveInputStream extends InputStream {
    private static final String APPLICATION_BIN = "application.bin";
    private static final String APPLICATION_HEX = "application.hex";
    private static final String APPLICATION_INIT = "application.dat";
    private static final String BOOTLOADER_BIN = "bootloader.bin";
    private static final String BOOTLOADER_HEX = "bootloader.hex";
    private static final String MANIFEST = "manifest.json";
    private static final String SOFTDEVICE_BIN = "softdevice.bin";
    private static final String SOFTDEVICE_HEX = "softdevice.hex";
    private static final String SYSTEM_INIT = "system.dat";
    private static final String TAG = "DfuArchiveInputStream";
    private byte[] applicationBytes;
    private byte[] applicationInitBytes;
    private int applicationSize;
    private byte[] bootloaderBytes;
    private int bootloaderSize;
    private int bytesRead;
    private int bytesReadFromCurrentSource;
    private int bytesReadFromMarkedSource;
    private final CRC32 crc32;
    private byte[] currentSource;
    private final Map<String, byte[]> entries;
    private Manifest manifest;
    private byte[] markedSource;
    private byte[] softDeviceAndBootloaderBytes;
    private byte[] softDeviceBytes;
    private int softDeviceSize;
    private byte[] systemInitBytes;
    private int type;
    private final ZipInputStream zipInputStream;

    /* JADX WARN: Removed duplicated region for block: B:81:0x024e A[Catch: all -> 0x0256, TRY_ENTER, TryCatch #0 {all -> 0x0256, blocks: (B:5:0x002d, B:7:0x0035, B:13:0x0043, B:15:0x0065, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00d9, B:29:0x00da, B:30:0x00e1, B:31:0x00e2, B:34:0x00ec, B:36:0x00f0, B:38:0x0112, B:39:0x0119, B:40:0x0131, B:41:0x0132, B:44:0x013c, B:46:0x0140, B:48:0x0144, B:50:0x0148, B:52:0x016a, B:55:0x0241, B:58:0x01a1, B:59:0x01a8, B:60:0x017b, B:61:0x0193, B:62:0x0194, B:63:0x019b, B:65:0x006c, B:66:0x0084, B:69:0x01ab, B:77:0x0211, B:81:0x024e, B:82:0x0255, B:83:0x0214, B:85:0x0220, B:86:0x022a, B:88:0x022e, B:89:0x01e5, B:91:0x01f1, B:92:0x01fb, B:94:0x01ff, B:95:0x01af, B:97:0x01bb, B:98:0x01c5, B:100:0x01c9), top: B:4:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0220 A[Catch: all -> 0x0256, TryCatch #0 {all -> 0x0256, blocks: (B:5:0x002d, B:7:0x0035, B:13:0x0043, B:15:0x0065, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00d9, B:29:0x00da, B:30:0x00e1, B:31:0x00e2, B:34:0x00ec, B:36:0x00f0, B:38:0x0112, B:39:0x0119, B:40:0x0131, B:41:0x0132, B:44:0x013c, B:46:0x0140, B:48:0x0144, B:50:0x0148, B:52:0x016a, B:55:0x0241, B:58:0x01a1, B:59:0x01a8, B:60:0x017b, B:61:0x0193, B:62:0x0194, B:63:0x019b, B:65:0x006c, B:66:0x0084, B:69:0x01ab, B:77:0x0211, B:81:0x024e, B:82:0x0255, B:83:0x0214, B:85:0x0220, B:86:0x022a, B:88:0x022e, B:89:0x01e5, B:91:0x01f1, B:92:0x01fb, B:94:0x01ff, B:95:0x01af, B:97:0x01bb, B:98:0x01c5, B:100:0x01c9), top: B:4:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x022e A[Catch: all -> 0x0256, TryCatch #0 {all -> 0x0256, blocks: (B:5:0x002d, B:7:0x0035, B:13:0x0043, B:15:0x0065, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00d9, B:29:0x00da, B:30:0x00e1, B:31:0x00e2, B:34:0x00ec, B:36:0x00f0, B:38:0x0112, B:39:0x0119, B:40:0x0131, B:41:0x0132, B:44:0x013c, B:46:0x0140, B:48:0x0144, B:50:0x0148, B:52:0x016a, B:55:0x0241, B:58:0x01a1, B:59:0x01a8, B:60:0x017b, B:61:0x0193, B:62:0x0194, B:63:0x019b, B:65:0x006c, B:66:0x0084, B:69:0x01ab, B:77:0x0211, B:81:0x024e, B:82:0x0255, B:83:0x0214, B:85:0x0220, B:86:0x022a, B:88:0x022e, B:89:0x01e5, B:91:0x01f1, B:92:0x01fb, B:94:0x01ff, B:95:0x01af, B:97:0x01bb, B:98:0x01c5, B:100:0x01c9), top: B:4:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f1 A[Catch: all -> 0x0256, TryCatch #0 {all -> 0x0256, blocks: (B:5:0x002d, B:7:0x0035, B:13:0x0043, B:15:0x0065, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00d9, B:29:0x00da, B:30:0x00e1, B:31:0x00e2, B:34:0x00ec, B:36:0x00f0, B:38:0x0112, B:39:0x0119, B:40:0x0131, B:41:0x0132, B:44:0x013c, B:46:0x0140, B:48:0x0144, B:50:0x0148, B:52:0x016a, B:55:0x0241, B:58:0x01a1, B:59:0x01a8, B:60:0x017b, B:61:0x0193, B:62:0x0194, B:63:0x019b, B:65:0x006c, B:66:0x0084, B:69:0x01ab, B:77:0x0211, B:81:0x024e, B:82:0x0255, B:83:0x0214, B:85:0x0220, B:86:0x022a, B:88:0x022e, B:89:0x01e5, B:91:0x01f1, B:92:0x01fb, B:94:0x01ff, B:95:0x01af, B:97:0x01bb, B:98:0x01c5, B:100:0x01c9), top: B:4:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ff A[Catch: all -> 0x0256, TryCatch #0 {all -> 0x0256, blocks: (B:5:0x002d, B:7:0x0035, B:13:0x0043, B:15:0x0065, B:16:0x0086, B:19:0x0090, B:21:0x0094, B:23:0x0098, B:25:0x00ba, B:26:0x00c1, B:27:0x00d9, B:29:0x00da, B:30:0x00e1, B:31:0x00e2, B:34:0x00ec, B:36:0x00f0, B:38:0x0112, B:39:0x0119, B:40:0x0131, B:41:0x0132, B:44:0x013c, B:46:0x0140, B:48:0x0144, B:50:0x0148, B:52:0x016a, B:55:0x0241, B:58:0x01a1, B:59:0x01a8, B:60:0x017b, B:61:0x0193, B:62:0x0194, B:63:0x019b, B:65:0x006c, B:66:0x0084, B:69:0x01ab, B:77:0x0211, B:81:0x024e, B:82:0x0255, B:83:0x0214, B:85:0x0220, B:86:0x022a, B:88:0x022e, B:89:0x01e5, B:91:0x01f1, B:92:0x01fb, B:94:0x01ff, B:95:0x01af, B:97:0x01bb, B:98:0x01c5, B:100:0x01c9), top: B:4:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ArchiveInputStream(java.io.InputStream r10, int r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.internal.ArchiveInputStream.<init>(java.io.InputStream, int, int):void");
    }

    private void parseZip(int r7) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = this.zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String validateFilename = validateFilename(nextEntry.getName(), InstructionFileId.DOT);
            if (nextEntry.isDirectory()) {
                Log.w(TAG, "A directory found in the ZIP: " + validateFilename + "!");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = this.zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (validateFilename.toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(byteArray, r7);
                    byteArray = new byte[hexInputStream.available()];
                    hexInputStream.read(byteArray);
                    hexInputStream.close();
                }
                if (MANIFEST.equals(validateFilename)) {
                    str = new String(byteArray, StandardCharsets.UTF_8);
                } else {
                    this.entries.put(validateFilename, byteArray);
                }
            }
        }
        if (!this.entries.isEmpty()) {
            if (str != null) {
                Manifest manifest = ((ManifestFile) new Gson().fromJson(str, ManifestFile.class)).getManifest();
                this.manifest = manifest;
                if (manifest == null) {
                    Log.w(TAG, "Manifest failed to be parsed. Did you add \n-keep class no.nordicsemi.android.dfu.** { *; }\nto your proguard rules?");
                    return;
                }
                return;
            }
            Log.w(TAG, "Manifest not found in the ZIP. It is recommended to use a distribution file created with: https://github.com/NordicSemiconductor/pc-nrfutil/ (for Legacy DFU use version 0.5.x)");
            return;
        }
        throw new FileNotFoundException("No files found in the ZIP. Check if the URI provided is valid and the ZIP contains required files on root level, not in a directory.");
    }

    private int rawRead(byte[] bArr, int r4, int r5) {
        byte[] bArr2 = this.currentSource;
        if (bArr2 != null && r4 >= 0 && r5 >= 0) {
            int min = Math.min(r5, bArr2.length - this.bytesReadFromCurrentSource);
            System.arraycopy(this.currentSource, this.bytesReadFromCurrentSource, bArr, r4, min);
            this.bytesReadFromCurrentSource += min;
            this.bytesRead += min;
            this.crc32.update(bArr, r4, min);
            return min;
        }
        return -1;
    }

    private byte[] startNextFile() {
        byte[] bArr;
        byte[] bArr2 = this.currentSource;
        if (bArr2 == this.softDeviceBytes && (bArr = this.bootloaderBytes) != null && (this.type & 2) > 0) {
            this.currentSource = bArr;
        } else {
            bArr = this.applicationBytes;
            if (bArr2 != bArr && bArr != null && (this.type & 4) > 0) {
                this.currentSource = bArr;
            } else {
                bArr = null;
                this.currentSource = null;
            }
        }
        this.bytesReadFromCurrentSource = 0;
        return bArr;
    }

    private String validateFilename(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith(new File(str2).getCanonicalPath())) {
            return canonicalPath.substring(1);
        }
        throw new IllegalStateException("File is outside extraction target directory.");
    }

    public int applicationImageSize() {
        if ((this.type & 4) > 0) {
            return this.applicationSize;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int available() {
        byte[] bArr = this.softDeviceAndBootloaderBytes;
        if (bArr != null && this.softDeviceSize == 0 && this.bootloaderSize == 0 && (this.type & 3) > 0) {
            return (applicationImageSize() + bArr.length) - this.bytesRead;
        }
        return (applicationImageSize() + (bootloaderImageSize() + softDeviceImageSize())) - this.bytesRead;
    }

    public int bootloaderImageSize() {
        if ((this.type & 2) > 0) {
            return this.bootloaderSize;
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.softDeviceBytes = null;
        this.bootloaderBytes = null;
        this.applicationBytes = null;
        this.softDeviceAndBootloaderBytes = null;
        this.applicationSize = 0;
        this.bootloaderSize = 0;
        this.softDeviceSize = 0;
        this.currentSource = null;
        this.bytesReadFromCurrentSource = 0;
        this.bytesRead = 0;
        this.zipInputStream.close();
    }

    public void fullReset() {
        byte[] bArr;
        byte[] bArr2 = this.softDeviceBytes;
        if (bArr2 != null && (bArr = this.bootloaderBytes) != null && this.currentSource == bArr) {
            this.currentSource = bArr2;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
    }

    public byte[] getApplicationInit() {
        return this.applicationInitBytes;
    }

    public int getBytesRead() {
        return this.bytesRead;
    }

    public int getContentType() {
        this.type = 0;
        if (this.softDeviceAndBootloaderBytes != null) {
            this.type = 0 | 3;
        }
        if (this.softDeviceSize > 0) {
            this.type |= 1;
        }
        if (this.bootloaderSize > 0) {
            this.type |= 2;
        }
        if (this.applicationSize > 0) {
            this.type |= 4;
        }
        return this.type;
    }

    public long getCrc32() {
        return this.crc32.getValue();
    }

    public byte[] getSystemInit() {
        return this.systemInitBytes;
    }

    public boolean isSecureDfuRequired() {
        Manifest manifest = this.manifest;
        if (manifest != null && manifest.isSecureDfuRequired()) {
            return true;
        }
        return false;
    }

    @Override // java.io.InputStream
    public void mark(int r1) {
        this.markedSource = this.currentSource;
        this.bytesReadFromMarkedSource = this.bytesReadFromCurrentSource;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        int r1;
        byte[] bArr;
        this.currentSource = this.markedSource;
        int r0 = this.bytesReadFromMarkedSource;
        this.bytesReadFromCurrentSource = r0;
        this.bytesRead = r0;
        this.crc32.reset();
        if (this.currentSource == this.bootloaderBytes && (bArr = this.softDeviceBytes) != null) {
            this.crc32.update(bArr);
            this.bytesRead += this.softDeviceSize;
        }
        byte[] bArr2 = this.currentSource;
        if (bArr2 != null && (r1 = this.bytesReadFromCurrentSource) > 0) {
            this.crc32.update(bArr2, 0, r1);
        }
    }

    public int setContentType(int r4) {
        byte[] bArr;
        this.type = r4;
        int r0 = r4 & 4;
        if (r0 > 0 && this.applicationBytes == null) {
            this.type = r4 & (-5);
        }
        int r1 = r4 & 3;
        if (r1 == 3) {
            if (this.softDeviceBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
            if (this.bootloaderBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
        } else if (this.softDeviceAndBootloaderBytes != null) {
            this.type &= -4;
        }
        if (r1 > 0 && (bArr = this.softDeviceAndBootloaderBytes) != null) {
            this.currentSource = bArr;
        } else if ((r4 & 1) > 0) {
            this.currentSource = this.softDeviceBytes;
        } else if ((r4 & 2) > 0) {
            this.currentSource = this.bootloaderBytes;
        } else if (r0 > 0) {
            this.currentSource = this.applicationBytes;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
        return this.type;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return 0L;
    }

    public int softDeviceImageSize() {
        if ((this.type & 1) > 0) {
            return this.softDeviceSize;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int r4, int r5) {
        int rawRead = rawRead(bArr, r4, r5);
        return (r5 <= rawRead || startNextFile() == null) ? rawRead : rawRead + rawRead(bArr, r4 + rawRead, r5 - rawRead);
    }
}
