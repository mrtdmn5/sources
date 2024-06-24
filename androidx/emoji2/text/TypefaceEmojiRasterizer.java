package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TypefaceEmojiRasterizer {
    public static final ThreadLocal<MetadataItem> sMetadataItem = new ThreadLocal<>();
    public volatile int mCache = 0;
    public final int mIndex;
    public final MetadataRepo mMetadataRepo;

    public TypefaceEmojiRasterizer(MetadataRepo metadataRepo, int r3) {
        this.mMetadataRepo = metadataRepo;
        this.mIndex = r3;
    }

    public final int getCodepointAt(int r4) {
        MetadataItem metadataItem = getMetadataItem();
        int __offset = metadataItem.__offset(16);
        if (__offset != 0) {
            ByteBuffer byteBuffer = metadataItem.bb;
            int r1 = __offset + metadataItem.bb_pos;
            return byteBuffer.getInt((r4 * 4) + byteBuffer.getInt(r1) + r1 + 4);
        }
        return 0;
    }

    public final int getCodepointsLength() {
        MetadataItem metadataItem = getMetadataItem();
        int __offset = metadataItem.__offset(16);
        if (__offset != 0) {
            int r1 = __offset + metadataItem.bb_pos;
            return metadataItem.bb.getInt(metadataItem.bb.getInt(r1) + r1);
        }
        return 0;
    }

    public final MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> threadLocal = sMetadataItem;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        MetadataList metadataList = this.mMetadataRepo.mMetadataList;
        int __offset = metadataList.__offset(6);
        if (__offset != 0) {
            int r2 = __offset + metadataList.bb_pos;
            int r22 = (this.mIndex * 4) + metadataList.bb.getInt(r2) + r2 + 4;
            metadataItem.__reset(metadataList.bb.getInt(r22) + r22, metadataList.bb);
        }
        return metadataItem;
    }

    public final String toString() {
        int r1;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        MetadataItem metadataItem = getMetadataItem();
        int __offset = metadataItem.__offset(4);
        if (__offset != 0) {
            r1 = metadataItem.bb.getInt(__offset + metadataItem.bb_pos);
        } else {
            r1 = 0;
        }
        sb.append(Integer.toHexString(r1));
        sb.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        for (int r3 = 0; r3 < codepointsLength; r3++) {
            sb.append(Integer.toHexString(getCodepointAt(r3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
