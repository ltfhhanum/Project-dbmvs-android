package com.example.myapplication;

import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.adapter.MovieListAdapter;
import com.example.myapplication.model.Movie;
import com.example.myapplication.network.ApiService;
import com.squareup.okhttp.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.SocketTimeoutException;

public class PopularMovies extends AppCompatActivity {

    private MovieListAdapter movieListAdapter;
    private RecyclerView recyclerView;
    private int page = 1;
    private ApiService apiService;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);

        movieListAdapter = new MovieListAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv_popularmvs);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(movieListAdapter);

        loadData();
    }

    private void loadData(){
        apiService = new ApiService();
        apiService.getPopularMovies(page, new Callback(){

            @Override
            public void onResponse(Call call, Response response) {
                Movie movie = (Movie) response.body();
                if(movie != null){
                    if(movieListAdapter != null){
                        movieListAdapter.addAll(movie.getResults());
                    }
                }else{
                    Toast.makeText(getBaseContext(), "No Data!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                if(t instanceof SocketTimeoutException){
                    Toast.makeText(getBaseContext(), "Request Timeout..", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getBaseContext(), "Connection Error!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
