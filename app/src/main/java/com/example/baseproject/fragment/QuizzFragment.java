package com.example.baseproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.baseproject.R;
import com.example.baseproject.databinding.FragmentQuizzBinding;
import com.example.baseproject.fragment.QuizzFragmentDirections.ToCongratFragment;


public class QuizzFragment extends Fragment implements Toolbar.OnMenuItemClickListener {

    private FragmentQuizzBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentQuizzBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.toolbar.setOnMenuItemClickListener(this);

        mBinding.btnTrue.setOnClickListener(v -> {
            int score = 100;
            ToCongratFragment action = QuizzFragmentDirections.toCongratFragment();
            action.setScore(score);
            Navigation.findNavController(view).navigate(action);
        });

        mBinding.btnFalse.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.failureFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.log_out) {
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
                    .navigate(QuizzFragmentDirections.actionQuizzFragmentToOnBoardingFragment());
        }
        return true;
    }
}