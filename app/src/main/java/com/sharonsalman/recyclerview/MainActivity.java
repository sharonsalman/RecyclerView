package com.sharonsalman.recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TVShowAdapter adapter;
    private List<TVShow> tvShowList;
    private List<TVShow> filteredList; // List to hold filtered items for the search

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // create tvshows
        tvShowList = new ArrayList<>();
        tvShowList.add(new TVShow("Eren Yeager", "Japanese", R.drawable.eren_yeager, "The resolute protagonist of \"Attack on Titan,\" vows to annihilate Titans after witnessing his mother's tragic demise by one, wielding formidable powers including the Attack, Founding, and War Hammer Titans."));
        tvShowList.add(new TVShow("Tanjiro Kamado", "Japanese", R.drawable.tanjiro_kamado, "The compassionate lead of \"Demon Slayer,\" embarks on a journey as a demon slayer following the massacre of his family, his acute sense of smell aiding him in tracking demons and understanding their strengths and vulnerabilities."));
        tvShowList.add(new TVShow("Killua Zoldyck", "Japanese", R.drawable.killua_zoldyck, "He is a skilled assassin from the famous Zoldyck family in the anime \"Hunter x Hunter.\" Despite his upbringing, he seeks to escape his family's deadly legacy and forms a strong bond with his friend Gon Freecss."));
        tvShowList.add(new TVShow("Satoru Gojo", "Japanese", R.drawable.saturo_gojo, "A prominent figure in \"Jujutsu Kaisen,\" is a formidable sorcerer renowned for his mastery over the \"Limitless\" curse technique, employing it to manipulate space and erect potent barriers, all while exuding an easygoing yet idiosyncratic demeanor."));


        // for the search, take all the tv shows
        filteredList = new ArrayList<>(tvShowList);

        adapter = new TVShowAdapter(filteredList);
        recyclerView.setAdapter(adapter);


        SearchView searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }


    private void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(tvShowList);
        } else {
            query = query.toLowerCase().trim();
            for (TVShow tvShow : tvShowList) {
                if (tvShow.getTitle().toLowerCase().contains(query)){
                    filteredList.add(tvShow);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}

