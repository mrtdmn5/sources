package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;
import com.amazonaws.services.s3.internal.Constants;

/* loaded from: classes.dex */
public class AppCompatProgressBarHelper {
    public static final int[] TINT_ATTRS = {R.attr.indeterminateDrawable, R.attr.progressDrawable};
    public Bitmap mSampleTile;
    public final ProgressBar mView;

    public AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.mView = progressBar;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int r10) {
        ProgressBar progressBar = this.mView;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(progressBar.getContext(), attributeSet, TINT_ATTRS, r10);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            if (drawableIfKnown instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) drawableIfKnown;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int r5 = 0; r5 < numberOfFrames; r5++) {
                    Drawable tileify = tileify(animationDrawable.getFrame(r5), true);
                    tileify.setLevel(Constants.MAXIMUM_UPLOAD_PARTS);
                    animationDrawable2.addFrame(tileify, animationDrawable.getDuration(r5));
                }
                animationDrawable2.setLevel(Constants.MAXIMUM_UPLOAD_PARTS);
                drawableIfKnown = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(drawableIfKnown);
        }
        Drawable drawableIfKnown2 = obtainStyledAttributes.getDrawableIfKnown(1);
        if (drawableIfKnown2 != null) {
            progressBar.setProgressDrawable(tileify(drawableIfKnown2, false));
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable tileify(Drawable drawable, boolean z) {
        boolean z2;
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawable wrappedDrawable = (WrappedDrawable) drawable;
            Drawable wrappedDrawable2 = wrappedDrawable.getWrappedDrawable();
            if (wrappedDrawable2 != null) {
                wrappedDrawable.setWrappedDrawable(tileify(wrappedDrawable2, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int r3 = 0; r3 < numberOfLayers; r3++) {
                    int id = layerDrawable.getId(r3);
                    Drawable drawable2 = layerDrawable.getDrawable(r3);
                    if (id != 16908301 && id != 16908303) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    drawableArr[r3] = tileify(drawable2, z2);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int r2 = 0; r2 < numberOfLayers; r2++) {
                    layerDrawable2.setId(r2, layerDrawable.getId(r2));
                    layerDrawable2.setLayerGravity(r2, layerDrawable.getLayerGravity(r2));
                    layerDrawable2.setLayerWidth(r2, layerDrawable.getLayerWidth(r2));
                    layerDrawable2.setLayerHeight(r2, layerDrawable.getLayerHeight(r2));
                    layerDrawable2.setLayerInsetLeft(r2, layerDrawable.getLayerInsetLeft(r2));
                    layerDrawable2.setLayerInsetRight(r2, layerDrawable.getLayerInsetRight(r2));
                    layerDrawable2.setLayerInsetTop(r2, layerDrawable.getLayerInsetTop(r2));
                    layerDrawable2.setLayerInsetBottom(r2, layerDrawable.getLayerInsetBottom(r2));
                    layerDrawable2.setLayerInsetStart(r2, layerDrawable.getLayerInsetStart(r2));
                    layerDrawable2.setLayerInsetEnd(r2, layerDrawable.getLayerInsetEnd(r2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.mSampleTile == null) {
                    this.mSampleTile = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                if (z) {
                    return new ClipDrawable(shapeDrawable, 3, 1);
                }
                return shapeDrawable;
            }
        }
        return drawable;
    }
}
