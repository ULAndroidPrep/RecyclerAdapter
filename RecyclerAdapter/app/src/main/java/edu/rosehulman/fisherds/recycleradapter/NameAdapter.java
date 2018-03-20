package edu.rosehulman.fisherds.recycleradapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fisherds on 3/20/18.
 */

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
  private List<String> mNames;
  private Context mContext;
  private Random mRandom = new Random();

  public NameAdapter(Context context) {
    this.mNames = new ArrayList<>();
    this.mContext = context;

    for (int i = 0; i < 5; i++) {
      mNames.add(getRandomName());
    }
  }

  private String getRandomName() {
    String[] names = new String[]{
        "Hannah", "Emily", "Sarah", "Madison", "Brianna",
        "Kaylee", "Kaitlyn", "Hailey", "Alexis", "Elizabeth",
        "Michael", "Jacob", "Matthew", "Nicholas", "Christopher",
        "Joseph", "Zachary", "Joshua", "Andrew", "William"
    };
    return names[mRandom.nextInt(names.length)];
  }

  public void addName() {
    mNames.add(0, getRandomName());
    notifyDataSetChanged();
  }

  public void removeName(int position) {
    mNames.remove(position);
    notifyDataSetChanged();
  }


  @Override
  public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // Inflate the xml and pass that inflated view into the NameViewHolder constructor.
    View view = LayoutInflater.from(mContext).inflate(R.layout.name_view, parent, false);
    return new NameViewHolder(view);
  }

  @Override
  public void onBindViewHolder(NameViewHolder holder, int position) {
    // TODO: Set the values for this ViewHolder.
    holder.mNameTextView.setText(mNames.get(position));
    holder.mDescriptionTextView.setText("I'm #" + position);
  }

  @Override
  public int getItemCount() {
    return mNames.size();
  }

  class NameViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {


    private final TextView mNameTextView;
    private final TextView mDescriptionTextView;

    public NameViewHolder(View itemView) {
      super(itemView);
      // findViewById the text views
      mNameTextView = itemView.findViewById(R.id.name);
      mDescriptionTextView = itemView.findViewById(R.id.description);
      itemView.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
      removeName(getAdapterPosition());
      return false;
    }
  }
}
