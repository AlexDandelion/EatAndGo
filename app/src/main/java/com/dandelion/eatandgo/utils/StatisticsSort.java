package com.dandelion.eatandgo.utils;

import com.dandelion.eatandgo.models.StatisticsItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StatisticsSort {

    public static void weightSort(List<StatisticsItem> items) {
        Collections.sort(items, new WeightComparator());
    }

    public static void dateSort(List<StatisticsItem> items) {
        Collections.sort(items, new DateComparator());
    }

    private static class WeightComparator implements Comparator<StatisticsItem> {

        @Override
        public int compare(StatisticsItem first, StatisticsItem second) {
            Integer firstInt = Integer.parseInt(first.getFoodWeight());
            Integer secondInt = Integer.parseInt(second.getFoodWeight());
            return firstInt.compareTo(secondInt);
        }
    }

    private static class DateComparator implements Comparator<StatisticsItem> {

        @Override
        public int compare(StatisticsItem first, StatisticsItem second) {
            String[] firstArr = first.getDate().split("\\.");
            String[] secondArr = second.getDate().split("\\.");

            int res = secondArr[2].compareTo(firstArr[2]);
            if (res != 0) {
                return res;
            }

            res = secondArr[1].compareTo(firstArr[1]);
            if (res != 0) {
                return res;
            }

            res = secondArr[0].compareTo(firstArr[0]);
            if (res != 0) {
                return res;
            }

            return 0;
        }
    }
}
