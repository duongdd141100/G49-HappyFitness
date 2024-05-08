package com.example.happy_fitness.custom_repository;

import com.example.happy_fitness.entity.TrainSchedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TrainScheduleCustomRepository {
    @Autowired
    private EntityManager entityManager;

    private static final String BASE_SQL = "SELECT " +
            "    ts.*" +
            " FROM" +
            "    train_schedule ts" +
            "        INNER JOIN" +
            "    classes c ON ts.class_id = c.id" +
            "        INNER JOIN" +
            "    users u ON u.id = c.pt_id" +
            "        INNER JOIN" +
            "    facilities f ON f.id = u.facility_id";

    public List<TrainSchedule> findAllByFacilityIdAndMapDayOfWeekWithTrainTimeId(Long facilityId, Map<Long, Long> mapDayOfWeekWithTrainTimeId) {
        String sql = BASE_SQL + getCondition(mapDayOfWeekWithTrainTimeId);
        Query query = entityManager.createNativeQuery(sql, TrainSchedule.class);
        query.setParameter("facilityId", facilityId);
        return query.getResultList();
    }

    private String getCondition(Map<Long, Long> mapDayOfWeekWithTrainTimeId) {
        String condition = " WHERE f.id = :facilityId";
        List<String> mapCondition = new ArrayList<>();
        for (Map.Entry<Long, Long> entry : mapDayOfWeekWithTrainTimeId.entrySet()) {
            mapCondition.add("(ts.day_of_week = " + entry.getKey() + " AND ts.train_time_id = " + entry.getValue() + ")");
        }
        return condition + " AND + (" + String.join(" OR ", mapCondition) + ")";
    }

}
