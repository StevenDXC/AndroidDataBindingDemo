package com.dx.databindingdemo.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dx.databindingdemo.R;
import com.dx.databindingdemo.databinding.ItemLayoutBinding;
import com.dx.databindingdemo.model.RepoListModel;
import com.dx.databindingdemo.viewmodel.RepoListViewModel;

import java.util.Collections;
import java.util.List;


public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoAdapterViewHolder>{


    private List<RepoListModel> repoList;

    public RepoListAdapter() {
        this.repoList = Collections.emptyList();
    }

    @Override
    public RepoAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_layout,parent,false);
        return new RepoAdapterViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    @Override
    public void onBindViewHolder(RepoAdapterViewHolder holder, int position) {
        holder.bindRepo(repoList.get(position));
    }

    public void setRepoList(List<RepoListModel> repoList){
        this.repoList = repoList;
        notifyDataSetChanged();
    }


    public static class RepoAdapterViewHolder extends RecyclerView.ViewHolder {

        ItemLayoutBinding dataBinding;

        public RepoAdapterViewHolder(ItemLayoutBinding dataBinding){
            super(dataBinding.contentView);
            this.dataBinding = dataBinding;
        }

        void bindRepo(RepoListModel repoListModel){
            if(dataBinding.getRepo() == null){
                dataBinding.setRepo(new RepoListViewModel(repoListModel));
            }else{
                dataBinding.getRepo().setRepoListModel(repoListModel);
            }
        }

    }

}
