package service;

import model.CattlePOJO;

import java.util.ArrayList;

public interface CattleService {

    ArrayList<CattlePOJO> sortById();

    ArrayList<CattlePOJO> sortByBirthday();

    ArrayList<CattlePOJO> sortByBirthdayDesc();

    ArrayList<CattlePOJO> sortByWeight();

}
