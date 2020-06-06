package hellschedule.hellschedule.ui.Database;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import hellschedule.hellschedule.ui.Activity.YouTubeActivity;


class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public TextView Exercise_partial;
    public TextView Exercise_name;
    public TextView Exercise_set;
    public ImageView Exercise_image;
    public ImageButton Exercise_youtube;
    public TextView Exercise_youtube_text;
//    public ImageButton Exercise_Youtube;

    public RecyclerViewHolder(final View itemView){
        super(itemView);
        Exercise_partial = (TextView) itemView.findViewById(R.id.card_view_exercise_partial);
        Exercise_name = (TextView) itemView.findViewById(R.id.card_view_exercise_name);
        Exercise_set = (TextView) itemView.findViewById(R.id.card_view_exercise_set);;
        Exercise_image = (ImageView) itemView.findViewById(R.id.card_view_exercise_image);
        Exercise_youtube = (ImageButton) itemView.findViewById(R.id.card_view_exercise_youtube);
        Exercise_youtube_text = (TextView) itemView.findViewById(R.id.card_view_exercise_youtube_text);
    }
}

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    public Context context;
    public static List<Exercise_DB_list> exerciseList;

    public RecyclerViewAdapter(Context context, List<Exercise_DB_list> exerciseList) {
        this.context = context;
        this.exerciseList = exerciseList;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        View itemView = inflater.inflate(R.layout.cardview, parent, false);

        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        holder.Exercise_partial.setText(exerciseList.get(position).getExercise_partial());
        holder.Exercise_name.setText(exerciseList.get(position).getExercise_name());
        holder.Exercise_set.setText(exerciseList.get(position).getExercise_set());
        holder.Exercise_image.setImageBitmap(exerciseList.get(position).getExercise_image());
        holder.Exercise_youtube_text.setText(exerciseList.get(position).getExercise_youtube());

        //region Youtube Image Button 클릭 시 이벤트 처리
        holder.Exercise_youtube.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Exercise_youtube 버튼을 클릭하면 YouTube Activity로 화면전환이 된다.
                Intent intent = new Intent(context, YouTubeActivity.class);
                intent.putExtra("video_key", holder.Exercise_youtube_text.getText().toString());//인텐트 전환할 때 키값, 데이터값(youtube 해당영상링크) 넘겨주기
                v.getContext().startActivity(intent);//보내고 난후의 인텐트에서 끝난 이벤트를 받는것
            }
        });
        //endregion
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
}
