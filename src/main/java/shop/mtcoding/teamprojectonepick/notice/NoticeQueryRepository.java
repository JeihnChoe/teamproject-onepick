package shop.mtcoding.teamprojectonepick.notice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeQueryRepository {

    @Autowired
    private EntityManager em;

    class MyParamValue {
        String param;
        String value;
        String prefix;
    }

    public List<Notice> findByChoice(String workField, String address, String career, String education) {
        String sql = "select n from Notice n where n.open='on'";

        List<MyParamValue> result = new ArrayList<>();

        if (!workField.isBlank()) {
            MyParamValue v = new MyParamValue();
            v.param = " and n.workField = :workField";
            v.value = workField;
            v.prefix = "workField";
            result.add(v);
        }
        //

        if (!address.isBlank()) {
            MyParamValue v = new MyParamValue();
            v.param = " and n.address = :address";
            v.value = address;
            v.prefix = "address";
            result.add(v);
        }

        if (!career.isBlank()) {
            MyParamValue v = new MyParamValue();
            v.param = " and n.career = :career";
            v.value = career;
            v.prefix = "career";
            result.add(v);
        }

        if (!education.isBlank()) {
            MyParamValue v = new MyParamValue();
            v.param = " and n.education = :education";
            v.value = education;
            v.prefix = "education";
            result.add(v);
        }

        for (MyParamValue v : result) {
            sql += v.param;
        }

        result.stream().forEach((k) -> {
            System.out.println(k.param);
            System.out.println(k.value);
        });

        Query query = em.createQuery(sql, Notice.class);

        for (int i = 0; i < result.size(); i++) {
            query.setParameter(result.get(i).prefix, result.get(i).value);
        }

        System.out.println(result.size());

        return query.getResultList();
    }
}
