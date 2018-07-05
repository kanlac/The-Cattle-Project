package dao;

import model.Cattle;

public class CattleDAO {

    public Boolean append(Cattle cattle) {
        String sql = "INSERT INTO cattle (id, sex, birthday, weight, variety, father_id, mother_id, children_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = { cattle.getId(), cattle.getSex(), cattle.getBirthday(), cattle.getWeight(), cattle.getVariety(), cattle.getFather_id(), cattle.getMother_id(), cattle.getChildren_id() };

        return new Perform().update(sql, params);
    }

    public Cattle get(String id) {
        return new Cattle();
    }

    public Boolean alter(Cattle cattle) {
        String sql = "UPDATE cattle SET sex = ?, birthday = ?, weight = ?, variety = ?, father_id = ?, mother_id = ?, children_id = ? WHERE id = ?";
        Object[] params = { cattle.getSex(), cattle.getBirthday(), cattle.getWeight(), cattle.getVariety(), cattle.getFather_id(), cattle.getMother_id(), cattle.getChildren_id(), cattle.getId() };

        return new Perform().update(sql, params);
    }

    public Boolean remove(String id) {
        String sql = "DELETE FROM cattle WHERE id = ?";

        return new Perform().update(sql, new Object[] { id });
    }


}
