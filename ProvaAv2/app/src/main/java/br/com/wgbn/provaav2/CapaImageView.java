package br.com.wgbn.provaav2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Classe que extende do componente RoundedImageView para redimencionar
 * automaticamente a imagem para caber dentro do CardView.
 * Essa classe foi retirada do Stackoverflow:
 * http://stackoverflow.com/questions/13992535/android-imageview-scale-smaller-image-to-width-with-flexible-height-without-crop
 */
public class CapaImageView extends RoundedImageView {

    public CapaImageView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final Drawable d = this.getDrawable();

        if (d != null) {
            // ceil not round - avoid thin vertical gaps along the left/right edges
            final int width = View.MeasureSpec.getSize(widthMeasureSpec);
            final int height = (int) Math.ceil(width * (float) d.getIntrinsicHeight() / d.getIntrinsicWidth());
            this.setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
