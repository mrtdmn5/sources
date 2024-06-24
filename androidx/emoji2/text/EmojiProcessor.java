package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class EmojiProcessor {
    public final EmojiCompat.GlyphChecker mGlyphChecker;
    public final MetadataRepo mMetadataRepo;
    public final EmojiCompat.SpanFactory mSpanFactory;

    /* loaded from: classes.dex */
    public static class EmojiProcessAddSpanCallback implements EmojiProcessCallback<UnprecomputeTextOnModificationSpannable> {
        public final EmojiCompat.SpanFactory mSpanFactory;
        public UnprecomputeTextOnModificationSpannable spannable;

        public EmojiProcessAddSpanCallback(UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable, EmojiCompat.SpanFactory spanFactory) {
            this.spannable = unprecomputeTextOnModificationSpannable;
            this.mSpanFactory = spanFactory;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final UnprecomputeTextOnModificationSpannable getResult() {
            return this.spannable;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final boolean handleEmoji(CharSequence charSequence, int r5, int r6, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            boolean z;
            Spannable spannableString;
            if ((typefaceEmojiRasterizer.mCache & 4) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            if (this.spannable == null) {
                if (charSequence instanceof Spannable) {
                    spannableString = (Spannable) charSequence;
                } else {
                    spannableString = new SpannableString(charSequence);
                }
                this.spannable = new UnprecomputeTextOnModificationSpannable(spannableString);
            }
            ((EmojiCompat.DefaultSpanFactory) this.mSpanFactory).getClass();
            this.spannable.setSpan(new TypefaceEmojiSpan(typefaceEmojiRasterizer), r5, r6, 33);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface EmojiProcessCallback<T> {
        T getResult();

        boolean handleEmoji(CharSequence charSequence, int r2, int r3, TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    /* loaded from: classes.dex */
    public static final class ProcessorSm {
        public int mCurrentDepth;
        public MetadataRepo.Node mCurrentNode;
        public final int[] mEmojiAsDefaultStyleExceptions;
        public MetadataRepo.Node mFlushNode;
        public int mLastCodepoint;
        public final MetadataRepo.Node mRootNode;
        public int mState = 1;
        public final boolean mUseEmojiAsDefaultStyle;

        public ProcessorSm(MetadataRepo.Node node, boolean z, int[] r4) {
            this.mRootNode = node;
            this.mCurrentNode = node;
            this.mUseEmojiAsDefaultStyle = z;
            this.mEmojiAsDefaultStyleExceptions = r4;
        }

        public final void reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
        }

        public final boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            boolean z;
            boolean z2;
            int[] r0;
            MetadataItem metadataItem = this.mCurrentNode.mData.getMetadataItem();
            int __offset = metadataItem.__offset(6);
            if (__offset != 0 && metadataItem.bb.get(__offset + metadataItem.bb_pos) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            if (this.mLastCodepoint == 65039) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
            if (!this.mUseEmojiAsDefaultStyle || ((r0 = this.mEmojiAsDefaultStyleExceptions) != null && Arrays.binarySearch(r0, this.mCurrentNode.mData.getCodepointAt(0)) >= 0)) {
                return false;
            }
            return true;
        }
    }

    public EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.DefaultSpanFactory defaultSpanFactory, DefaultGlyphChecker defaultGlyphChecker, Set set) {
        this.mSpanFactory = defaultSpanFactory;
        this.mMetadataRepo = metadataRepo;
        this.mGlyphChecker = defaultGlyphChecker;
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                int[] r9 = (int[]) it.next();
                String str = new String(r9, 0, r9.length);
                process(str, 0, str.length(), 1, true, new MarkExclusionCallback(str));
            }
        }
    }

    public static boolean delete(Editable editable, KeyEvent keyEvent, boolean z) {
        boolean z2;
        EmojiSpan[] emojiSpanArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean hasGlyph(CharSequence charSequence, int r9, int r10, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        int r8;
        if ((typefaceEmojiRasterizer.mCache & 3) == 0) {
            EmojiCompat.GlyphChecker glyphChecker = this.mGlyphChecker;
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int __offset = metadataItem.__offset(8);
            if (__offset != 0) {
                metadataItem.bb.getShort(__offset + metadataItem.bb_pos);
            }
            DefaultGlyphChecker defaultGlyphChecker = (DefaultGlyphChecker) glyphChecker;
            defaultGlyphChecker.getClass();
            ThreadLocal<StringBuilder> threadLocal = DefaultGlyphChecker.sStringBuilder;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = threadLocal.get();
            sb.setLength(0);
            while (r9 < r10) {
                sb.append(charSequence.charAt(r9));
                r9++;
            }
            TextPaint textPaint = defaultGlyphChecker.mTextPaint;
            String sb2 = sb.toString();
            int r102 = PaintCompat.$r8$clinit;
            boolean hasGlyph = PaintCompat.Api23Impl.hasGlyph(textPaint, sb2);
            int r92 = typefaceEmojiRasterizer.mCache & 4;
            if (hasGlyph) {
                r8 = r92 | 2;
            } else {
                r8 = r92 | 1;
            }
            typefaceEmojiRasterizer.mCache = r8;
        }
        if ((typefaceEmojiRasterizer.mCache & 3) != 2) {
            return false;
        }
        return true;
    }

    public final <T> T process(CharSequence charSequence, int r18, int r19, int r20, boolean z, EmojiProcessCallback<T> emojiProcessCallback) {
        boolean z2;
        MetadataRepo.Node node;
        boolean z3;
        boolean z4;
        char c;
        MetadataRepo.Node node2 = null;
        ProcessorSm processorSm = new ProcessorSm(this.mMetadataRepo.mRootNode, false, null);
        int r10 = r18;
        int codePointAt = Character.codePointAt(charSequence, r18);
        int r12 = 0;
        boolean z5 = true;
        int r6 = r10;
        while (r6 < r19 && r12 < r20 && z5) {
            SparseArray<MetadataRepo.Node> sparseArray = processorSm.mCurrentNode.mChildren;
            if (sparseArray == null) {
                node = node2;
            } else {
                node = sparseArray.get(codePointAt);
            }
            if (processorSm.mState != 2) {
                if (node == null) {
                    processorSm.reset();
                    c = 1;
                } else {
                    processorSm.mState = 2;
                    processorSm.mCurrentNode = node;
                    processorSm.mCurrentDepth = 1;
                    c = 2;
                }
            } else {
                if (node != null) {
                    processorSm.mCurrentNode = node;
                    processorSm.mCurrentDepth++;
                } else {
                    if (codePointAt == 65038) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        processorSm.reset();
                    } else {
                        if (codePointAt == 65039) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4) {
                            MetadataRepo.Node node3 = processorSm.mCurrentNode;
                            if (node3.mData != null) {
                                if (processorSm.mCurrentDepth == 1) {
                                    if (processorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                                        processorSm.mFlushNode = processorSm.mCurrentNode;
                                        processorSm.reset();
                                    } else {
                                        processorSm.reset();
                                    }
                                } else {
                                    processorSm.mFlushNode = node3;
                                    processorSm.reset();
                                }
                                c = 3;
                            } else {
                                processorSm.reset();
                            }
                        }
                    }
                    c = 1;
                }
                c = 2;
            }
            processorSm.mLastCodepoint = codePointAt;
            if (c != 1) {
                if (c != 2) {
                    if (c == 3) {
                        if (!z && hasGlyph(charSequence, r10, r6, processorSm.mFlushNode.mData)) {
                            r10 = r6;
                        } else {
                            boolean handleEmoji = emojiProcessCallback.handleEmoji(charSequence, r10, r6, processorSm.mFlushNode.mData);
                            r12++;
                            r10 = r6;
                            z5 = handleEmoji;
                        }
                    }
                } else {
                    r6 += Character.charCount(codePointAt);
                    if (r6 < r19) {
                        codePointAt = Character.codePointAt(charSequence, r6);
                    }
                }
                node2 = null;
            } else {
                r10 += Character.charCount(Character.codePointAt(charSequence, r10));
                if (r10 < r19) {
                    codePointAt = Character.codePointAt(charSequence, r10);
                }
            }
            r6 = r10;
            node2 = null;
        }
        if (processorSm.mState == 2 && processorSm.mCurrentNode.mData != null && (processorSm.mCurrentDepth > 1 || processorSm.shouldUseEmojiPresentationStyleForSingleCodepoint())) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && r12 < r20 && z5 && (z || !hasGlyph(charSequence, r10, r6, processorSm.mCurrentNode.mData))) {
            emojiProcessCallback.handleEmoji(charSequence, r10, r6, processorSm.mCurrentNode.mData);
        }
        return emojiProcessCallback.getResult();
    }

    /* loaded from: classes.dex */
    public static class EmojiProcessLookupCallback implements EmojiProcessCallback<EmojiProcessLookupCallback> {
        public final int mOffset;
        public int start = -1;
        public int end = -1;

        public EmojiProcessLookupCallback(int r2) {
            this.mOffset = r2;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final boolean handleEmoji(CharSequence charSequence, int r2, int r3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            int r4 = this.mOffset;
            if (r2 <= r4 && r4 < r3) {
                this.start = r2;
                this.end = r3;
                return false;
            }
            if (r3 > r4) {
                return false;
            }
            return true;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final EmojiProcessLookupCallback getResult() {
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class MarkExclusionCallback implements EmojiProcessCallback<MarkExclusionCallback> {
        public final String mExclusion;

        public MarkExclusionCallback(String str) {
            this.mExclusion = str;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final boolean handleEmoji(CharSequence charSequence, int r2, int r3, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (TextUtils.equals(charSequence.subSequence(r2, r3), this.mExclusion)) {
                typefaceEmojiRasterizer.mCache = (typefaceEmojiRasterizer.mCache & 3) | 4;
                return false;
            }
            return true;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public final MarkExclusionCallback getResult() {
            return this;
        }
    }
}
