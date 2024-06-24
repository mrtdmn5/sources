package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ContentInfoCompat {
    public final Compat mCompat;

    /* loaded from: classes.dex */
    public interface BuilderCompat {
        ContentInfoCompat build();

        void setExtras(Bundle bundle);

        void setFlags(int r1);

        void setLinkUri(Uri uri);
    }

    /* loaded from: classes.dex */
    public static final class BuilderCompat31Impl implements BuilderCompat {
        public final ContentInfo.Builder mPlatformBuilder;

        public BuilderCompat31Impl(ClipData clipData, int r2) {
            this.mPlatformBuilder = ContentInfoCompat$BuilderCompat31Impl$$ExternalSyntheticApiModelOutline2.m(clipData, r2);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final ContentInfoCompat build() {
            ContentInfo build;
            build = this.mPlatformBuilder.build();
            return new ContentInfoCompat(new Compat31Impl(build));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void setExtras(Bundle bundle) {
            this.mPlatformBuilder.setExtras(bundle);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void setFlags(int r2) {
            this.mPlatformBuilder.setFlags(r2);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void setLinkUri(Uri uri) {
            this.mPlatformBuilder.setLinkUri(uri);
        }
    }

    /* loaded from: classes.dex */
    public static final class BuilderCompatImpl implements BuilderCompat {
        public final ClipData mClip;
        public Bundle mExtras;
        public int mFlags;
        public Uri mLinkUri;
        public final int mSource;

        public BuilderCompatImpl(ClipData clipData, int r2) {
            this.mClip = clipData;
            this.mSource = r2;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void setExtras(Bundle bundle) {
            this.mExtras = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void setFlags(int r1) {
            this.mFlags = r1;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void setLinkUri(Uri uri) {
            this.mLinkUri = uri;
        }
    }

    /* loaded from: classes.dex */
    public interface Compat {
        ClipData getClip();

        int getFlags();

        int getSource();

        ContentInfo getWrapped();
    }

    /* loaded from: classes.dex */
    public static final class Compat31Impl implements Compat {
        public final ContentInfo mWrapped;

        public Compat31Impl(ContentInfo contentInfo) {
            contentInfo.getClass();
            this.mWrapped = ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m(contentInfo);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ClipData getClip() {
            ClipData clip;
            clip = this.mWrapped.getClip();
            return clip;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int getFlags() {
            int flags;
            flags = this.mWrapped.getFlags();
            return flags;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int getSource() {
            int source;
            source = this.mWrapped.getSource();
            return source;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ContentInfo getWrapped() {
            return this.mWrapped;
        }

        public final String toString() {
            return "ContentInfoCompat{" + this.mWrapped + "}";
        }
    }

    /* loaded from: classes.dex */
    public static final class CompatImpl implements Compat {
        public final ClipData mClip;
        public final Bundle mExtras;
        public final int mFlags;
        public final Uri mLinkUri;
        public final int mSource;

        public CompatImpl(BuilderCompatImpl builderCompatImpl) {
            ClipData clipData = builderCompatImpl.mClip;
            clipData.getClass();
            this.mClip = clipData;
            int r0 = builderCompatImpl.mSource;
            if (r0 >= 0) {
                if (r0 <= 5) {
                    this.mSource = r0;
                    int r02 = builderCompatImpl.mFlags;
                    if ((r02 & 1) == r02) {
                        this.mFlags = r02;
                        this.mLinkUri = builderCompatImpl.mLinkUri;
                        this.mExtras = builderCompatImpl.mExtras;
                        return;
                    } else {
                        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(r02) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
                    }
                }
                throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", "source", 0, 5));
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", "source", 0, 5));
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ClipData getClip() {
            return this.mClip;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int getFlags() {
            return this.mFlags;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int getSource() {
            return this.mSource;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ContentInfo getWrapped() {
            return null;
        }

        public final String toString() {
            String str;
            String valueOf;
            String str2;
            StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
            sb.append(this.mClip.getDescription());
            sb.append(", source=");
            int r1 = this.mSource;
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 != 2) {
                        if (r1 != 3) {
                            if (r1 != 4) {
                                if (r1 != 5) {
                                    str = String.valueOf(r1);
                                } else {
                                    str = "SOURCE_PROCESS_TEXT";
                                }
                            } else {
                                str = "SOURCE_AUTOFILL";
                            }
                        } else {
                            str = "SOURCE_DRAG_AND_DROP";
                        }
                    } else {
                        str = "SOURCE_INPUT_METHOD";
                    }
                } else {
                    str = "SOURCE_CLIPBOARD";
                }
            } else {
                str = "SOURCE_APP";
            }
            sb.append(str);
            sb.append(", flags=");
            int r12 = this.mFlags;
            if ((r12 & 1) != 0) {
                valueOf = "FLAG_CONVERT_TO_PLAIN_TEXT";
            } else {
                valueOf = String.valueOf(r12);
            }
            sb.append(valueOf);
            String str3 = "";
            Uri uri = this.mLinkUri;
            if (uri == null) {
                str2 = "";
            } else {
                str2 = ", hasLinkUri(" + uri.toString().length() + ")";
            }
            sb.append(str2);
            if (this.mExtras != null) {
                str3 = ", hasExtras";
            }
            return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, str3, "}");
        }
    }

    public ContentInfoCompat(Compat compat) {
        this.mCompat = compat;
    }

    public final String toString() {
        return this.mCompat.toString();
    }
}
