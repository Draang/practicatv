package com.example.pruebatv3;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import androidx.core.content.ContextCompat;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/*
 * A CardPresenter is used to generate Views and bind Objects to them on demand.
 * It contains an Image CardView
 */
public class CardPresenter extends Presenter {
    static class ViewHolder extends Presenter.ViewHolder{
        private ImageCardView mCardView;
        public ViewHolder(View view){
            super(view);
            mCardView=(ImageCardView) view;
        }
        public ImageCardView getmCardView(){
            return mCardView;
        }
        public void updateCardViewImage(Context context,String link){
            Picasso.with(context).
                    load(link).
                    resize(210,210).
                    centerCrop().
                    into(mCardView.getMainImageView());
        }
    }

    @Override
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup parent) {
        ImageCardView cardView=new ImageCardView(parent.getContext());
        cardView.setFocusable(true);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        Movie movie=(Movie) item;
        if(!TextUtils.isEmpty(movie.getPoster())){
            ((ViewHolder) viewHolder).mCardView.setTitleText(movie.getTitulo());
            ((ViewHolder) viewHolder).mCardView.setMainImageDimensions(210,210);
            ((ViewHolder) viewHolder).updateCardViewImage(
                    ((ViewHolder) viewHolder).getmCardView().getContext(),
                    movie.getPoster());
        }
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {

    }

    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder holder) {
    }
}