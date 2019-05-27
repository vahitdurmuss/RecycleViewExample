package com.example.vahitdurmus.recycleviewtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NoteRecyclerAdapter noteRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeDisplayContent();
    }


    private void initializeDisplayContent(){
        final RecyclerView recylerNotes=(RecyclerView) findViewById(R.id.list_nodes);
        final StaggeredGridLayoutManager notesLayoutManager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recylerNotes.setLayoutManager(notesLayoutManager);

        List<NoteInfo> notes=DataManager.getInstance().getNotes();

        notes.addAll(notes);
        notes.addAll(notes);
        noteRecyclerAdapter = new NoteRecyclerAdapter(this,notes);
        recylerNotes.setAdapter(noteRecyclerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteRecyclerAdapter.notifyDataSetChanged();

    }
}
