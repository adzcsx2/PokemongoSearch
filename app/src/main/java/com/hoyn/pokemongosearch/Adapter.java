package com.hoyn.pokemongosearch;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hoyn.base.AbstractAdapter;
import com.hoyn.base.BaseHolder;
import com.hoyn.data.RequestResult;
import com.hoyn.util.TimeProcess;

import java.util.Date;

import butterknife.Bind;

/**
 * Created by Hoyn on 2016/7/23.
 */
public class Adapter extends AbstractAdapter<RequestResult.PokemonBean, Adapter.Holder> {



    @Override
    protected Holder getHolder(View v) {
        return new Holder(v);
    }

    @Override
    protected int getView() {
        return R.layout.item;
    }

    public boolean isRepeat(RequestResult.PokemonBean pokemon){
        for (RequestResult.PokemonBean mPokemon:data) {
            if(mPokemon.getUid().equals(pokemon.getUid())){
                return true;
            }
        }
        return false;
    }
    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }

    @Override
    protected void bindEvent(Holder holder, int position) {
        RequestResult.PokemonBean pokemonBean = data.get(position);

        holder.tvId.setText(pokemonBean.getPokemonId());
        holder.tvPosition.setText(pokemonBean.getLatitude() + "," + pokemonBean.getLongitude());
        long time = new Date().getTime();
        String temp = pokemonBean.getExpiration_time() + "000";
        long expiration_time = Long.parseLong(temp);;
        int s = (int) ((expiration_time-time)/1000);
        Log.e("aa","time = "+time +"  expiration_time = "+expiration_time +"   "+s+""  );
        if(!pokemonBean.isIs_alive()){
            data.remove(position);
            notifyDataSetChanged();
        }
        String recordTime = TimeProcess.getRecordTime(s);
        holder.tvTime.setText(recordTime);
    }

    class Holder extends BaseHolder {
        @Bind(R.id.tv_id)
        TextView tvId;
        @Bind(R.id.tv_position)
        TextView tvPosition;
        @Bind(R.id.tv_time)
        TextView tvTime;

        public Holder(View view) {
            super(view);
        }
    }

}
