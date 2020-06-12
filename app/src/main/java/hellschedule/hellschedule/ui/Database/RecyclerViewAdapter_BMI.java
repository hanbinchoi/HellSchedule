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

class RecyclerViewHolder_BMI extends RecyclerView.ViewHolder {
    public TextView BMI_partial;
    public TextView BMI_name;
    public TextView BMI_set;
    public ImageView BMI_image;

    public RecyclerViewHolder_BMI(final View itemView) {
        super(itemView);
        BMI_partial = (TextView) itemView.findViewById(R.id.card_view_bmi_partial);
        BMI_name = (TextView) itemView.findViewById(R.id.card_view_bmi_name);
        BMI_set = (TextView) itemView.findViewById(R.id.card_view_bmi_set);
        BMI_image = (ImageView) itemView.findViewById(R.id.card_view_bmi_image);

    }
}

public class RecyclerViewAdapter_BMI extends RecyclerView.Adapter<RecyclerViewHolder_BMI> {
    public Context context3;
    public static List<BMI_DB_list> bmilist;

    public RecyclerViewAdapter_BMI(Context context, List<BMI_DB_list> bmilist) {
        this.context3 = context;
        this.bmilist = bmilist;
    }


    @NonNull
    @Override
    public RecyclerViewHolder_BMI onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        View itemView = inflater.inflate(R.layout.cardview3, parent, false);
        return new RecyclerViewHolder_BMI(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder_BMI holder, int position) {
        holder.BMI_partial.setText(bmilist.get(position).getExercise_partial());
        holder.BMI_name.setText(bmilist.get(position).getExercise_name());
        holder.BMI_set.setText(bmilist.get(position).getExercise_set());
        holder.BMI_image.setImageBitmap(bmilist.get(position).getExercise_image());
    }



    @Override
    public int getItemCount() {
        return bmilist.size();
    }
}
