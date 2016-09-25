package net.d80harri.capoeira.dal.core.criterions;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;
import net.d80harri.capoeira.dal.core.ICriterion;
import org.assertj.core.api.JUnitSoftAssertions;
import org.assertj.core.api.StringAssert;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.Writer;

/**
 * Created by d80harri on 25.09.16.
 */
public class CriterionTestRule implements TestRule {
    private final JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    private final XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
        public HierarchicalStreamWriter createWriter(Writer writer) {
            return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
        }
    });

    private int assertCounter = 0;

    @Override
    public Statement apply(Statement base, Description description) {
        return softAssertions.apply(base, description);
    }

    public StringAssert toHqlReturns(ICriterion criterion) {
        assertCounter++;
        return softAssertions.assertThat(criterion.toHql()).describedAs(assertCounter + ". assertion failed. Criterion was:\n" + xstream.toXML(criterion));
    }
}
