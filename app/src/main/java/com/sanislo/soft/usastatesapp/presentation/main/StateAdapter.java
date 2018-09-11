package com.sanislo.soft.usastatesapp.presentation.main;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanislo.soft.usastatesapp.R;
import com.sanislo.soft.usastatesapp.domain.model.StateModel;

public class StateAdapter extends ListAdapter<StateModel, StateAdapter.StateViewHolder> {
    static DiffUtil.ItemCallback<StateModel> sDiffCallback = new DiffUtil.ItemCallback<StateModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull StateModel stateModel, @NonNull StateModel t1) {
            return stateModel.getId() == t1.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull StateModel stateModel, @NonNull StateModel t1) {
            return stateModel.equals(t1);
        }
    };

    private final ClickHandler mClickHandler;

    protected StateAdapter(ClickHandler clickHandler) {
        super(sDiffCallback);
        mClickHandler = clickHandler;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_state, viewGroup, false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder stateViewHolder, int i) {
        stateViewHolder.bind();
    }

    public interface ClickHandler {
        void onClick(StateModel stateModel);
    }

    class StateViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCapital;
        TextView tvLargestCity;
        TextView tvAbbr;
        TextView tvId;

        public StateViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> mClickHandler.onClick(getItem(getAdapterPosition())));
            tvName = itemView.findViewById(R.id.tv_name);
            tvCapital = itemView.findViewById(R.id.tv_capital);
            tvLargestCity = itemView.findViewById(R.id.tv_largest_city);
            tvAbbr = itemView.findViewById(R.id.tv_abbr);
            tvId = itemView.findViewById(R.id.tv_id);
        }

        public void bind() {
            StateModel stateModel = getItem(getAdapterPosition());
            tvName.setText(stateModel.getName());
            tvCapital.setText(stateModel.getCapital());
            tvLargestCity.setText(stateModel.getLargestCity());
            tvAbbr.setText(stateModel.getAbbr());
            tvId.setText(String.valueOf(stateModel.getId()));
        }
    }
}
