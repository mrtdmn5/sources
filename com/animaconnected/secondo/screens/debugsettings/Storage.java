package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.animaconnected.watch.display.AndroidGraphicsKt;
import com.animaconnected.watch.image.ImageBuilder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugImagePreview.kt */
/* loaded from: classes3.dex */
public final class Storage {
    public static final Storage INSTANCE = new Storage();
    public static final String folder = "imagepreview";

    private Storage() {
    }

    public final boolean deleteFile(String name, Context context) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File file = new File(context.getDir(folder, 0), name);
            if (file.exists()) {
                file.delete();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public final List<Pair<String, Bitmap>> getBitmaps(Context context) {
        Bitmap decodeFile;
        Intrinsics.checkNotNullParameter(context, "context");
        File[] listFiles = context.getDir(folder, 0).listFiles();
        if (listFiles != null) {
            ArrayList arrayList = new ArrayList(listFiles.length);
            for (File file : listFiles) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (StringsKt__StringsJVMKt.endsWith(name, ".bin", false)) {
                    decodeFile = AndroidGraphicsKt.toBitmap$default(ImageBuilder.INSTANCE.decodeToMitmap(FilesKt__FileReadWriteKt.readBytes(file)), null, 1, null);
                } else {
                    decodeFile = BitmapFactory.decodeFile(file.getPath(), new BitmapFactory.Options());
                }
                arrayList.add(new Pair(file.getName(), decodeFile));
            }
            return arrayList;
        }
        return EmptyList.INSTANCE;
    }

    public final byte[] getBytes(String name, Context context) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        return FilesKt__FileReadWriteKt.readBytes(new File(context.getDir(folder, 0), name));
    }

    public final void saveBinaryData(String name, byte[] bytes, Context context) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File file = new File(context.getDir(folder, 0), name.concat(".bin"));
            if (file.createNewFile()) {
                FilesKt__FileReadWriteKt.writeBytes(file, bytes);
                return;
            }
            throw new IOException("Can't create file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void saveBitmap(String name, Bitmap bitmap, Context context) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File file = new File(context.getDir(folder, 0), name);
            if (file.createNewFile()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    Intrinsics.checkNotNull(byteArray);
                    FilesKt__FileReadWriteKt.writeBytes(file, byteArray);
                } finally {
                }
            } else {
                throw new IOException("Can't create file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
