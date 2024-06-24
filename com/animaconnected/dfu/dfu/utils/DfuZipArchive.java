package com.animaconnected.dfu.dfu.utils;

import android.content.Context;
import android.net.Uri;
import com.animaconnected.dfu.dfu.utils.manifest.Manifest;
import com.animaconnected.dfu.dfu.utils.manifest.ManifestFile;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class DfuZipArchive {
    private static final String MANIFEST = "manifest.json";
    private final Map<String, byte[]> data = new HashMap();
    private Manifest mManifest;

    public DfuZipArchive(Context context, Uri uri) throws IOException {
        parseZip(context, uri);
    }

    private void parseZip(Context context, Uri uri) throws IOException {
        byte[] bArr = new byte[1024];
        ZipInputStream zipInputStream = new ZipInputStream(context.getContentResolver().openInputStream(uri));
        String str = null;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = zipInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (MANIFEST.equals(name)) {
                str = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                this.data.put(name, byteArray);
            }
        }
        if (str != null) {
            Manifest manifest = ((ManifestFile) new Gson().fromJson(str, ManifestFile.class)).getManifest();
            this.mManifest = manifest;
            if (manifest.getApplicationInfo() != null) {
                return;
            } else {
                throw new IOException("manifest.json is missing application data");
            }
        }
        throw new IOException("Zip archive is missing manifest.json");
    }

    public byte[] getApplication() {
        Manifest manifest = this.mManifest;
        if (manifest != null && manifest.getApplicationInfo() != null) {
            return this.data.get(this.mManifest.getApplicationInfo().getBinFileName());
        }
        return null;
    }

    public byte[] getBootloader() {
        Manifest manifest = this.mManifest;
        if (manifest != null && manifest.getBootloaderInfo() != null) {
            return this.data.get(this.mManifest.getBootloaderInfo().getBinFileName());
        }
        return null;
    }
}
