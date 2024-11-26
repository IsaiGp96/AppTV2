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
        HeaderItem categoria3 = new HeaderItem(0,"Vídeojuegos");
        HeaderItem categoria4 = new HeaderItem(0,"Deportes");
        HeaderItem categoria5 = new HeaderItem(0,"Anime");
        HeaderItem categoria6 = new HeaderItem(0,"Historia");
        HeaderItem categoria7 = new HeaderItem(0,"Podcast");

        ArrayObjectAdapter adapterFila1 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila1.add(new SingleRowView("Duna", getContext().getResources().getDrawable(R.drawable.duna)));
        adapterFila1.add(new SingleRowView("Avengers", getContext().getResources().getDrawable(R.drawable.avengers)));
        adapterFila1.add(new SingleRowView("Marvels", getContext().getResources().getDrawable(R.drawable.marvels)));
        adapterFila1.add(new SingleRowView("Guerra Mundial Z", getContext().getResources().getDrawable(R.drawable.z)));

        ArrayObjectAdapter adapterFila2 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila2.add(new SingleRowView("The Walkind Dead", getContext().getResources().getDrawable(R.drawable.twd)));
        adapterFila2.add(new SingleRowView("How I Meet Your Mother", getContext().getResources().getDrawable(R.drawable.himym)));
        adapterFila2.add(new SingleRowView("The Big Bang Theory", getContext().getResources().getDrawable(R.drawable.tbbt)));
        adapterFila2.add(new SingleRowView("One Punch Man", getContext().getResources().getDrawable(R.drawable.opm)));
        adapterFila2.add(new SingleRowView("Solo Leveling", getContext().getResources().getDrawable(R.drawable.sl)));

        ArrayObjectAdapter adapterFila3 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila3.add(new SingleRowView("Metal Gear Solid", getContext().getResources().getDrawable(R.drawable.mgs)));
        adapterFila3.add(new SingleRowView("Forza Horizon", getContext().getResources().getDrawable(R.drawable.fh)));
        adapterFila3.add(new SingleRowView("Project Zomboid", getContext().getResources().getDrawable(R.drawable.pz)));
        adapterFila3.add(new SingleRowView("Civilization VI", getContext().getResources().getDrawable(R.drawable.cv)));

        ArrayObjectAdapter adapterFila4 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila4.add(new SingleRowView("Steelers vs Browns", getContext().getResources().getDrawable(R.drawable.stl)));
        adapterFila4.add(new SingleRowView("New York vs Baltimore", getContext().getResources().getDrawable(R.drawable.ny)));
        adapterFila4.add(new SingleRowView("Lakers vs Bulls", getContext().getResources().getDrawable(R.drawable.lk)));
        adapterFila4.add(new SingleRowView("Barcelona vs Real Madrid", getContext().getResources().getDrawable(R.drawable.fcb)));

        ArrayObjectAdapter adapterFila5 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila5.add(new SingleRowView("Dan da dan", getContext().getResources().getDrawable(R.drawable.dan)));
        adapterFila5.add(new SingleRowView("One punch man", getContext().getResources().getDrawable(R.drawable.opm)));
        adapterFila5.add(new SingleRowView("Solo leveling", getContext().getResources().getDrawable(R.drawable.sl)));
        adapterFila5.add(new SingleRowView("Evangelion", getContext().getResources().getDrawable(R.drawable.eva)));

        ArrayObjectAdapter adapterFila6 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila6.add(new SingleRowView("WWII", getContext().getResources().getDrawable(R.drawable.wwii)));
        adapterFila6.add(new SingleRowView("WWI", getContext().getResources().getDrawable(R.drawable.wwi)));
        adapterFila6.add(new SingleRowView("ARPA Net", getContext().getResources().getDrawable(R.drawable.arpa)));
        adapterFila6.add(new SingleRowView("Tec news", getContext().getResources().getDrawable(R.drawable.tec)));

        ArrayObjectAdapter adapterFila7 = new ArrayObjectAdapter(new MyPresenter());
        adapterFila7.add(new SingleRowView("Seleccion natural", getContext().getResources().getDrawable(R.drawable.pc1)));
        adapterFila7.add(new SingleRowView("Mushoku Tensei", getContext().getResources().getDrawable(R.drawable.pc2)));
        adapterFila7.add(new SingleRowView("Que se arme el deporte", getContext().getResources().getDrawable(R.drawable.dp)));
        adapterFila7.add(new SingleRowView("Historias chidas", getContext().getResources().getDrawable(R.drawable.pc3)));

        ArrayObjectAdapter windowAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        windowAdapter.add(new ListRow(categoria1,adapterFila1));
        windowAdapter.add(new ListRow(categoria2,adapterFila2));
        windowAdapter.add(new ListRow(categoria3,adapterFila3));
        windowAdapter.add(new ListRow(categoria4,adapterFila4));
        windowAdapter.add(new ListRow(categoria5,adapterFila5));
        windowAdapter.add(new ListRow(categoria6,adapterFila6));
        windowAdapter.add(new ListRow(categoria7,adapterFila7));
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
