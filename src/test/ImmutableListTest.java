package test;

import com.google.common.collect.ImmutableList;

import main.ImmutableListExample;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
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
    public void getOddTest()
    {
        ImmutableListExample example = new ImmutableListExample();
        List<String> oddList = example.getOdd();
        assertThat(oddList.contains("1"), is(true));
        assertThat(oddList.contains("2"), is(false));
        assertThat(oddList.contains("5"), is(true));
        assertThat(oddList.contains("7"), is(true));
        assertThat(oddList.contains("11"), is(false));
    }

    @Test
    public void updateEvenTest()
    {
        ImmutableListExample example = new ImmutableListExample();
        example.updateEven();
        ImmutableList other = ImmutableList.of("1", "4", "3", "8", "5", "12", "7", "16", "9", "20");
        for(int i = 0; i < other.size(); i++)
            assertThat(example.innerList.get(i).equals(other.get(i)), is(true));

    }
    @Test
    public void checkTest()
    {
        ImmutableListExample example = new ImmutableListExample();
        assertThat(example.check(1).equals("Hello, "+1), is(true));
        assertThat(example.check(3).equals("Hello, "+3), is(true));
        assertThat(example.check(5).equals("Hello, "+5), is(true));
        assertThat(example.check(7).equals("Hello, "+7), is(true));
        assertThat(example.check(9).equals("Hello, "+9), is(true));
    }

}
