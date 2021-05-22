package com.bear.navtest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = getView().findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = getView().findViewById(R.id.personName);
                String name = editText.getText().toString();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(getActivity(),"請輸入名字",Toast.LENGTH_SHORT).show();
                    return;
                }

                Bundle bundle = new Bundle();
                bundle.putString("myName",name);

                NavController navController = Navigation.findNavController(view);
                //R.id.action_homeFragment_to_detailFragment 也可取代為 R.id.detailFragment，但須注意靜態argument的設置
                navController.navigate(R.id.action_homeFragment_to_detailFragment,bundle);
            }
        });

        //單純設定Nav action較簡潔的寫法
//        getView().findViewById(R.id.button).setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_detailFragment));
    }
}