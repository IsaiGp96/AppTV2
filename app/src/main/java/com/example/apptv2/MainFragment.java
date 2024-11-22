package com.example.apptv2;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;

public class MainFragment extends BrowseSupportFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        pantallaInicio();
        cargarFilas();
    }

    private void cargarFilas() {
        HeaderItem categoria1 = new HeaderItem(0,"Peliculas");
        HeaderItem categoria2 = new HeaderItem(0,"Series");
        ArrayObjectAdapter adapterFila1 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila1.add(new SingleRowView("Duna", getContext().getResources().getDrawable(R.drawable.duna)));
        adapterFila1.add(new SingleRowView("Avengers", getContext().getResources().getDrawable(R.drawable.avengers)));
        adapterFila1.add(new SingleRowView("Marvels", getContext().getResources().getDrawable(R.drawable.marvels)));
        adapterFila1.add(new SingleRowView("Guerra Mundial Z", getContext().getResources().getDrawable(R.drawable.z)));
        ArrayObjectAdapter windowAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        windowAdapter.add(new ListRow(categoria1,adapterFila1));
        setAdapter(windowAdapter);

    }

    private void pantallaInicio() {
        setTitle("Isaí García");

        setHeadersState(HEADERS_ENABLED);
        setBrandColor(Color.parseColor("#212121"));
    }

    private class MyPresenter extends Presenter {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent) {
            ImageCardView icv = new ImageCardView(parent.getContext());
            icv.setCardType(BaseCardView.CARD_TYPE_INFO_UNDER_WITH_EXTRA);
            icv.setInfoVisibility(BaseCardView.CARD_REGION_VISIBLE_ACTIVATED);
            return new ViewHolder(icv);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, Object item) {
            SingleRowView srv = (SingleRowView) item;
            ImageCardView icv = ((ImageCardView) viewHolder.view);
            icv.setMainImage(srv.getImage());
            icv.setMainImageDimensions(313,176);
            icv.setTitleText(srv.getName());
            icv.setContentText("Descripción");
        }

        @Override
        public void onUnbindViewHolder(ViewHolder viewHolder) {

        }

    }
}
