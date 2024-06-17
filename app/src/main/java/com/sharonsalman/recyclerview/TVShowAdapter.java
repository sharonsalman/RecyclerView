package com.sharonsalman.recyclerview;// TVShowAdapter.java
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder> {

    private List<TVShow> tvShowList;

    public TVShowAdapter(List<TVShow> tvShowList) {
        this.tvShowList = tvShowList;
    }

    @NonNull
    @Override
    public TVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new TVShowViewHolder(view);
    }
    // Display all the data on the recycler row that ive made. (I need it because I extended)
    @Override
    public void onBindViewHolder(@NonNull TVShowViewHolder holder, int position) {
        TVShow tvShow = tvShowList.get(position);
        holder.titleTextView.setText(tvShow.getTitle());
        holder.languageTextView.setText(tvShow.getLanguage());
        holder.additionalInfoTextView.setText(tvShow.getInfo()); // Set additional info
        holder.imageView.setImageResource(tvShow.getImageResource());
    }

    @Override
    public int getItemCount() {
        return tvShowList.size();
    }

    //Hold the tvshow class and adds it to the recycler
    public static class TVShowViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView languageTextView;
        TextView additionalInfoTextView;

        public TVShowViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recImage);
            titleTextView = itemView.findViewById(R.id.recTitle);
            languageTextView = itemView.findViewById(R.id.recLang);
            additionalInfoTextView = itemView.findViewById(R.id.recAdditionalInfo); // Initialize additional info TextView
        }
    }
}
