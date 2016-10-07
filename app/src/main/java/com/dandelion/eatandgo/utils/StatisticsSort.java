package com.dandelion.eatandgo.utils;

import com.dandelion.eatandgo.models.StatisticsItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StatisticsSort {

    public static void typeSort(List<StatisticsItem> items) {
        Collections.sort(items, new TypeComparator());
    }

    public static void weightSort(List<StatisticsItem> items) {
        Collections.sort(items, new WeightComparator());
    }

    public static void dateSort(List<StatisticsItem> items) {
        Collections.sort(items, new DateComparator());
    }

    private static class TypeComparator implements Comparator<StatisticsItem> {

        @Override
        public int compare(StatisticsItem first, StatisticsItem second) {
            return first.getType().compareTo(second.getType());
        }
    }

    private static class WeightComparator implements Comparator<StatisticsItem> {

        @Override
        public int compare(StatisticsItem first, StatisticsItem second) {
            Integer firstInt = Integer.parseInt(first.getWeight());
            Integer secondInt = Integer.parseInt(second.getWeight());
            return firstInt.compareTo(secondInt);
        }
    }

    private static class DateComparator implements Comparator<StatisticsItem> {

        @Override
        public int compare(StatisticsItem first, StatisticsItem second) {
            String[] firstArr = first.getDate().split("\\.");
            String[] secondArr = second.getDate().split("\\.");

            int res = firstArr[2].compareTo(secondArr[2]);
            if (res != 0) {
                return res;
            }

            res = firstArr[1].compareTo(secondArr[1]);
            if (res != 0) {
                return res;
            }

            res = firstArr[0].compareTo(secondArr[0]);
            if (res != 0) {
                return res;
            }

            return 0;
        }
    }
}
