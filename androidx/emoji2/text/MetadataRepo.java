package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;

/* loaded from: classes.dex */
public final class MetadataRepo {
    public final char[] mEmojiCharArray;
    public final MetadataList mMetadataList;
    public final Node mRootNode = new Node(1024);
    public final Typeface mTypeface;

    /* loaded from: classes.dex */
    public static class Node {
        public final SparseArray<Node> mChildren;
        public TypefaceEmojiRasterizer mData;

        public Node() {
            this(1);
        }

        public final void put(TypefaceEmojiRasterizer typefaceEmojiRasterizer, int r5, int r6) {
            Node node;
            int codepointAt = typefaceEmojiRasterizer.getCodepointAt(r5);
            SparseArray<Node> sparseArray = this.mChildren;
            if (sparseArray == null) {
                node = null;
            } else {
                node = sparseArray.get(codepointAt);
            }
            if (node == null) {
                node = new Node();
                sparseArray.put(typefaceEmojiRasterizer.getCodepointAt(r5), node);
            }
            if (r6 > r5) {
                node.put(typefaceEmojiRasterizer, r5 + 1, r6);
            } else {
                node.mData = typefaceEmojiRasterizer;
            }
        }

        public Node(int r2) {
            this.mChildren = new SparseArray<>(r2);
        }
    }

    public MetadataRepo(Typeface typeface, MetadataList metadataList) {
        int r0;
        int r6;
        int r2;
        boolean z;
        this.mTypeface = typeface;
        this.mMetadataList = metadataList;
        int __offset = metadataList.__offset(6);
        if (__offset != 0) {
            int r02 = __offset + metadataList.bb_pos;
            r0 = metadataList.bb.getInt(metadataList.bb.getInt(r02) + r02);
        } else {
            r0 = 0;
        }
        this.mEmojiCharArray = new char[r0 * 2];
        int __offset2 = metadataList.__offset(6);
        if (__offset2 != 0) {
            int r62 = __offset2 + metadataList.bb_pos;
            r6 = metadataList.bb.getInt(metadataList.bb.getInt(r62) + r62);
        } else {
            r6 = 0;
        }
        for (int r7 = 0; r7 < r6; r7++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, r7);
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int __offset3 = metadataItem.__offset(4);
            if (__offset3 != 0) {
                r2 = metadataItem.bb.getInt(__offset3 + metadataItem.bb_pos);
            } else {
                r2 = 0;
            }
            Character.toChars(r2, this.mEmojiCharArray, r7 * 2);
            if (typefaceEmojiRasterizer.getCodepointsLength() > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument("invalid metadata codepoint length", z);
            this.mRootNode.put(typefaceEmojiRasterizer, 0, typefaceEmojiRasterizer.getCodepointsLength() - 1);
        }
    }
}
