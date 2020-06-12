package hellschedule.hellschedule.ui.Database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hellschedule.hellschedule.R;

class RecyclerViewHolder_Search extends RecyclerView.ViewHolder {
    public TextView Exercise_partial;
    public TextView Exercise_name;
    public ImageView Exercise_image;

    public RecyclerViewHolder_Search(final View itemView) {
        super(itemView);
        Exercise_partial = (TextView) itemView.findViewById(R.id.card_view_search_partial);
        Exercise_name = (TextView) itemView.findViewById(R.id.card_view_search_name);
        Exercise_image = (ImageView) itemView.findViewById(R.id.card_view_search_image);

    }
}

public class RecyclerViewAdapter_Search extends RecyclerView.Adapter<RecyclerViewHolder_Search> {
    public Context context4;
    public static List<Search_DB_list> searchlist;

    public RecyclerViewAdapter_Search(Context context, List<Search_DB_list> searchlist) {
        this.context4 = context;
        this.searchlist = searchlist;
    }


    @NonNull
    @Override
    public RecyclerViewHolder_Search onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        View itemView = inflater.inflate(R.layout.cardview4, parent, false);
        return new RecyclerViewHolder_Search(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder_Search holder, int position) {
        holder.Exercise_partial.setText(searchlist.get(position).getExercise_partial());
        holder.Exercise_name.setText(searchlist.get(position).getExercise_name());
        holder.Exercise_image.setImageBitmap(searchlist.get(position).getExercise_image());
    }

    @Override
    public int getItemCount() {
        return searchlist.size();
    }
}
