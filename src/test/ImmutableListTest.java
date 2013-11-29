package test;

import com.google.common.collect.ImmutableList;
import main.ImmutableListExample;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: L
 * Date: 13-11-26
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */
public class ImmutableListTest {

    @Test
    public void getOddTest() {
        ImmutableListExample example = new ImmutableListExample();
        List<String> oddList = example.getOdd();
        assertThat(oddList.equals(ImmutableList.of("1", "3", "5", "7", "9")), is(true));
    }

    @Test
    public void updateEvenTest() {
        ImmutableListExample example = new ImmutableListExample();
        assertThat(example.updateEven().equals(ImmutableList
                .of("1", "4", "3", "8", "5", "12", "7", "16", "9", "20")), is(true));

    }

    @Test
    public void checkTest() {
        ImmutableListExample example = new ImmutableListExample();
        assertThat("Not Found".equals(example.check(14)), is(true));
        assertThat("Hello, 1".equals(example.check(1)), is(true));
    }

}
