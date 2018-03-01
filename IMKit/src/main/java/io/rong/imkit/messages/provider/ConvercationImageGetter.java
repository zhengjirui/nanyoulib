package io.rong.imkit.messages.provider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import io.rong.imageloader.core.ImageLoader;
import io.rong.imageloader.core.listener.SimpleImageLoadingListener;
import io.rong.imkit.NYAppManger;
import io.rong.imkit.Utils.NyUtiles;

/**
 * Created by 18513 on 2018/2/28.
 */

public class ConvercationImageGetter implements Html.ImageGetter {
    TextView container;

    public ConvercationImageGetter(TextView text) {
        this.container = text;
    }

    public Drawable getDrawable(String source) {
        final LevelListDrawable drawable = new LevelListDrawable();
        ImageLoader.getInstance().loadImage(source,null, NYAppManger.getInstance().getOptions(), new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if(loadedImage != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(loadedImage);
                    drawable.addLevel(1, 1, bitmapDrawable);
                    int width = loadedImage.getWidth();
                    int height = loadedImage.getHeight();
                    float scaleRate = 1f;
                    if(width >= 700){
                        scaleRate = 700f / width;
                    }
                    drawable.setBounds(0, 0, (int)(width * scaleRate),(int)(height * scaleRate));
                    drawable.setLevel(1);
                    container.invalidate();
                    container.setText(container.getText());
                }
            }
        });
        return drawable;
    }
}
