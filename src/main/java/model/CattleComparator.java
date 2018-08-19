package model;

import model.CattlePOJO;

import java.util.Comparator;

public class CattleComparator {

    public static Comparator<CattlePOJO> byId = new Comparator<CattlePOJO>() {
        @Override
        public int compare(CattlePOJO o1, CattlePOJO o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };

    Comparator<CattlePOJO> byBirthday = new Comparator<CattlePOJO>() {
        @Override
        public int compare(CattlePOJO o1, CattlePOJO o2) {
            return o1.getBirthday().compareTo(o2.getBirthday());
        }
    };

    Comparator<CattlePOJO> byBirthdayDesc = new Comparator<CattlePOJO>() {
        @Override
        public int compare(CattlePOJO o1, CattlePOJO o2) {
            return o2.getBirthday().compareTo(o1.getBirthday());
        }
    };

    Comparator<CattlePOJO> byWeight = new Comparator<CattlePOJO>() {
        @Override
        public int compare(CattlePOJO o1, CattlePOJO o2) {
            return o1.getWeight() > o2.getWeight() ? 1 : o1.getWeight() == o2.getWeight() ? 0 : -1;
        }
    };

}
