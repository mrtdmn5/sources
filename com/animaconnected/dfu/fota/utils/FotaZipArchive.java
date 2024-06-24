package com.animaconnected.dfu.fota.utils;

import android.content.Context;
import android.net.Uri;
import com.animaconnected.dfu.fota.utils.manifest.App;
import com.animaconnected.dfu.fota.utils.manifest.FotaManifestFile;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class FotaZipArchive {
    private static final String MANIFEST = "fota.json";
    private final Map<String, byte[]> data = new HashMap();
    private App mApp;

    public FotaZipArchive(Context context, Uri uri) throws IOException {
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
            App app2 = ((FotaManifestFile) new Gson().fromJson(str, FotaManifestFile.class)).getApp();
            this.mApp = app2;
            if (app2 != null && app2.getHash() != null && this.mApp.getFile() != null && this.mApp.getVersion() != null) {
                return;
            } else {
                throw new IOException("fota.json is missing data");
            }
        }
        throw new IOException("Zip archive is missing fota.json");
    }

    public byte[] getFile() {
        App app2 = this.mApp;
        if (app2 != null) {
            return this.data.get(app2.getFile());
        }
        return null;
    }

    public long getHash() {
        App app2 = this.mApp;
        if (app2 != null) {
            return app2.getHash().longValue();
        }
        return -1L;
    }

    public String getVersion() {
        App app2 = this.mApp;
        if (app2 != null) {
            return app2.getVersion();
        }
        return null;
    }
}
