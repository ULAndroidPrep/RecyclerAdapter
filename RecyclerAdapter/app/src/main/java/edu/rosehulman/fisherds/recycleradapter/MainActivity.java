package edu.rosehulman.fisherds.recycleradapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

  private NameAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    RecyclerView recyclerView = findViewById(R.id.recycler_view);
//    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerView.setHasFixedSize(true);
    mAdapter = new NameAdapter(this);
    recyclerView.setAdapter(mAdapter);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mAdapter.addName();
      }
    });
  }
}
