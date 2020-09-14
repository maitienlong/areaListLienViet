package com.example.beta3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.beta3.R;
import com.example.beta3.models.ListArea;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteTextViewAdapter extends ArrayAdapter {
    private List<ListArea> listAreaList;

    public AutoCompleteTextViewAdapter(@NonNull Context context, @NonNull List<ListArea> listAreas) {
        super(context, 0, listAreas);
        listAreaList = new ArrayList<>(listAreas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);

        }

        TextView textView = convertView.findViewById(R.id.tvArea);

        ListArea listArea = (ListArea) getItem(position);

        if (listArea != null){
            textView.setText(listArea.getAreaName());
        }

        return convertView;
    }

    private Filter areaFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            List<ListArea> sugtion = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                sugtion.addAll(listAreaList);
            } else {
                String filPat = constraint.toString().toLowerCase().trim();
                for (ListArea item : listAreaList) {
                    if (item.getAreaName().toLowerCase().contains(filPat)) {
                        sugtion.add(item);
                    }
                }
            }
            filterResults.values = sugtion;
            filterResults.count = sugtion.size();

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List)results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((ListArea) resultValue).getAreaName();
        }
    };
}
