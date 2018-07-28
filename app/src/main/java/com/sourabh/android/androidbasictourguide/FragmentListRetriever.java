package com.sourabh.android.androidbasictourguide;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class FragmentListRetriever {
    public static List<BaseRecyclerViewModel> getHistoryList(Context context) {
        List<BaseRecyclerViewModel> historyLocationsList = new ArrayList<>();
        String[] titles = context.getResources().getStringArray(R.array.history_title);
        String[] details = context.getResources().getStringArray(R.array.history_details);
        for (int i = 0; i < titles.length; i++) {
            historyLocationsList.add(new BaseRecyclerViewModel(titles[i], details[i]));
        }
        return historyLocationsList;
    }

    public static List<BaseRecyclerViewModel> getEventsList(Context context) {
        List<BaseRecyclerViewModel> eventsLocationsList = new ArrayList<>();
        String[] titles = context.getResources().getStringArray(R.array.events_title);
        String[] details = context.getResources().getStringArray(R.array.event_detail);
        for (int i = 0; i < titles.length; i++) {
            eventsLocationsList.add(new BaseRecyclerViewModel(titles[i], details[i]));
        }
        return eventsLocationsList;
    }

    public static List<BaseRecyclerViewModel> getFavouriteList(Context context) {
        List<BaseRecyclerViewModel> favLocationsList = new ArrayList<>();
        String[] titles = context.getResources().getStringArray(R.array.fav_title);
        String[] details = context.getResources().getStringArray(R.array.fav_details);
        for (int i = 0; i < titles.length; i++) {
            favLocationsList.add(new BaseRecyclerViewModel(titles[i], details[i]));
        }
        return favLocationsList;
    }

    public static List<BaseRecyclerViewModel> getHotelList(Context context) {
        List<BaseRecyclerViewModel> hotelLocationsList = new ArrayList<>();
        String[] titles = context.getResources().getStringArray(R.array.hotels_title);
        String[] details = context.getResources().getStringArray(R.array.hotel_details);
        int[] images = {R.drawable.hotel_1, R.drawable.hotel_2, R.drawable.hotel_3, R.drawable.hotel_4, R.drawable.hotel_5};
        for (int i = 0; i < titles.length; i++) {
            hotelLocationsList.add(new BaseRecyclerViewModel(images[i], titles[i], details[i]));
        }
        return hotelLocationsList;
    }
}
