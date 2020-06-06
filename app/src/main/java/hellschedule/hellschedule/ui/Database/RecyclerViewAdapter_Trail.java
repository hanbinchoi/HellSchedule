package hellschedule.hellschedule.ui.Database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hellschedule.hellschedule.R;

class RecyclerViewHolder_Trail extends RecyclerView.ViewHolder {
    public TextView Trail_name;
    public TextView Trail_location;
    public TextView Trail_distance;
    public ImageView Trail_image;
    public ImageView Trail_course;

    public RecyclerViewHolder_Trail(final View itemView) {
        super(itemView);
        Trail_name = (TextView) itemView.findViewById(R.id.card_view_trail_name);
        Trail_location = (TextView) itemView.findViewById(R.id.card_view_trail_region);
        Trail_distance = (TextView) itemView.findViewById(R.id.card_view_trail_distance);
        Trail_image = (ImageView) itemView.findViewById(R.id.card_view_trail_image);
        Trail_course = (ImageView) itemView.findViewById(R.id.card_view_trail_course);

    }
}

public class RecyclerViewAdapter_Trail extends RecyclerView.Adapter<RecyclerViewHolder_Trail> {
    public Context context;
    public static List<Trail_DB_list> trailList;

    public RecyclerViewAdapter_Trail(Context context, List<Trail_DB_list> trailList) {
        this.context = context;
        this.trailList = trailList;
    }


    @NonNull
    @Override
    public RecyclerViewHolder_Trail onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        View itemView = inflater.inflate(R.layout.cardview2, parent, false);

        return new RecyclerViewHolder_Trail(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder_Trail holder, int position) {
        holder.Trail_name.setText(trailList.get(position).getTrail_name());
        holder.Trail_location.setText(trailList.get(position).getTrail_location());
        holder.Trail_distance.setText(trailList.get(position).getTrail_distance());
        holder.Trail_image.setImageBitmap(trailList.get(position).getTrail_image());
        holder.Trail_course.setImageBitmap(trailList.get(position).getTrail_course());

    }


    @Override
    public int getItemCount() {
        return trailList.size();
    }
}
