package com.hoyn.pokemongosearch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.hoyn.data.RequestResult;
import com.hoyn.net.HttpUtil;
import com.hoyn.net.RxSubscriber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {
    public static final String TAG = "MainActivity";


    //    3,6,9,31,34,40,45,68,76,94,132,137,141,143,149
    @Bind(R.id.ev_start_position)
    EditText evStartPosition;
    @Bind(R.id.ev_end_position)
    EditText evEndPosition;
    @Bind(R.id.ev_search_pokemon)
    EditText evSearchPokemon;
    @Bind(R.id.btn_search)
    Button btnSearch;
    @Bind(R.id.lv)
    ListView lv;

    Adapter adapter = new Adapter();

    List<String> searchPokemons = new ArrayList<>();

    boolean isStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String evStartPosition = this.evStartPosition.getText().toString();
        String evEndPosition = this.evEndPosition.getText().toString();
        String evSearchPokemon = this.evSearchPokemon.getText().toString();

        Log.e(TAG, new Date().getTime() + "");


        lv.addHeaderView(LayoutInflater.from(this).inflate(R.layout.item, null));
        lv.setAdapter(adapter);
    }

    Subscription subscribe;

    @OnClick(R.id.btn_search)
    public void btn_search() {
        adapter.clear();
        searchPokemons.clear();
        isStart = true;


    }

    String lat, longs;


    private void search() {

        String evStartPosition = this.evStartPosition.getText().toString();
        String evEndPosition = this.evEndPosition.getText().toString();
        String evSearchPokemon = this.evSearchPokemon.getText().toString();

//        String[] split = evStartPosition.split(",");
        String[] split = "37.8019175085504,-122.51094818115233".split(",");
        double[] startPosition = {Double.parseDouble(split[0]), Double.parseDouble(split[1])};

//        split = evEndPosition.split(",");
        split = "37.70935613533687,-122.38082885742189".split(",");
        double[] endPosition = {Double.parseDouble(split[0]), Double.parseDouble(split[1])};

        split = evSearchPokemon.split(",");

        for (int i = 0; i < split.length; i++) {
            searchPokemons.add(split[i]);
        }

        int x_count = (int) ((startPosition[0] - endPosition[0]) / 0.01);
        int y_count = (int) ((endPosition[1] - startPosition[1]) / 0.01);
        for (int i = 0; i < x_count; i++) {
            lat = (startPosition[0] - i * 0.01) + "";
            for (int j = 0; j < y_count; j++) {
                longs = (startPosition[1] + j * 0.01) + "";
                subscribe = Observable.timer(60, TimeUnit.SECONDS)
                        .flatMap(new Func1<Long, Observable<?>>() {
                            @Override
                            public Observable<?> call(Long aLong) {
                                Log.e(TAG, "lat = " + lat + "   " + "longs = " + longs);
                                return HttpUtil.getApiService().getPokemon(lat, longs);
                            }
                        })
                        .retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                            @Override
                            public Observable<?> call(Observable<? extends Throwable> observable) {
                                return Observable.timer(5, TimeUnit.SECONDS);
                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new RxSubscriber<Object>() {
                            @Override
                            public void _onNext(Object o) {
                                RequestResult requestResult = (RequestResult) o;
                                List<RequestResult.PokemonBean> pokemons = requestResult.getPokemon();
                                for (RequestResult.PokemonBean pokemon : pokemons) {
                                    for (String id : searchPokemons) {
                                        if (pokemon.getPokemonId().equals(id) && !adapter.isRepeat(pokemon)) {
                                            adapter.addData(pokemon);
                                        }
                                    }
                                }
                            }

                            @Override
                            public void _onError(String msg) {

                            }
                        });

//                HttpUtil.getApiService().getPokemon(lat, longs)
//                        .retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
//                            @Override
//                            public Observable<?> call(Observable<? extends Throwable> observable) {
//                                return Observable.timer(5, TimeUnit.SECONDS);
//                            }
//                        })
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new RxSubscriber<RequestResult>() {
//                            @Override
//                            public void _onNext(RequestResult requestResult) {
//                                List<RequestResult.PokemonBean> pokemons = requestResult.getPokemon();
//                                for (RequestResult.PokemonBean pokemon : pokemons) {
//                                    for (String id : searchPokemons) {
//                                        if (pokemon.getPokemonId().equals(id) && !adapter.isRepeat(pokemon)) {
//                                            adapter.addData(pokemon);
//                                        }
//                                    }
//                                }
//                            }
//
//                            @Override
//                            public void _onError(String msg) {
//
//                            }
//                        });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isStart = false;
        subscribe.unsubscribe();
        ButterKnife.unbind(this);
    }
}
