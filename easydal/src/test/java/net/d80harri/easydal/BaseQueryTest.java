package net.d80harri.easydal;

import net.d80harri.easydal.criterions.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by d80harri on 26.09.16.
 */
public class BaseQueryTest {

    @Test
    public void test1() {
        BaseQuery query = new BaseQuery();
        IsEqualToCriterion<MyEntity, String> criterion = IsEqualToCriterion.create(new PersonNameExpression(), new StringConstantExpression(MyEntity.class, "Harald"));
        String result = query.toHql(criterion);
        System.out.println(result);
    }

    private static class MyEntity {}

    private static class PersonNameExpression extends StringColumnExpression<MyEntity> {

        public PersonNameExpression() {
            super(MyEntity.class, "name");
        }
    }

    private static class PersonAgeExpression extends IntegerColumnExpression<MyEntity> {

        public PersonAgeExpression() {
            super(MyEntity.class, "age");
        }
    }
}