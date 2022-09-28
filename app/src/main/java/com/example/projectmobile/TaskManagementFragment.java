package com.example.projectmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.projectmobile.databinding.FragmentTaskManagementBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskManagementFragment extends Fragment {

    private FragmentTaskManagementBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentTaskManagementBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    String[] ListElements = new String[] {};

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final List<String> ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (getActivity(), android.R.layout.simple_list_item_1, ListElementsArrayList);
        binding.containerListView.setAdapter(adapter);

        binding.addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListElementsArrayList.add(binding.inputTaskEditText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}