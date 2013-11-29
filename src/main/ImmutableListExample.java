package main;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-26
 * Time: 上午11:32
 * To change this template use File | Settings | File Templates.
 */
public class ImmutableListExample {

    public ImmutableList<String> innerList = ImmutableList.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    public List getOdd() {
        Iterable<String> filtered = Iterables.filter(innerList, new Predicate<String>() {
            @Override
            public boolean apply(@Nullable java.lang.String s) {
                if (Integer.valueOf(s) % 2 == 1)
                    return true;
                else
                    return false;
            }
        });
        return ImmutableList.copyOf(filtered);
    }

    public List updateEven() {
        List converted = ImmutableList.copyOf(
                Iterables.transform(innerList, new Function() {
                    @Override
                    public Object apply(@Nullable java.lang.Object o) {
                        if (String.class == o.getClass()
                                && Integer.valueOf((String) o) % 2 == 0) {
                            o = String.valueOf(2 * Integer.valueOf((String) o));
                        }
                        return o;
                    }
                })
        );
        return converted;
    }

    public String check(final int in) {
        try {
            String str = Iterables.find(innerList, new Predicate<String>() {
                @Override
                public boolean apply(@Nullable java.lang.String s) {
                    if (s.equals(String.valueOf(in)))
                        return true;
                    else
                        return false;
                }
            });
            return "Hello, " + str;
        } catch (NoSuchElementException e) {
            return "Not Found";
        }
    }
}
