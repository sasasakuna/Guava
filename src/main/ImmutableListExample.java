package main;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        List<String> retList = new ArrayList<String>();
        for (int i = 0; i < innerList.size(); i++)
            if (Integer.valueOf(innerList.get(i)) % 2 != 0)
                retList.add(innerList.get(i));
        return retList;
    }

    public void updateEven()
    {
        List<String> retList = new ArrayList(innerList.asList());
        for(int i=0; i < retList.size(); i++)
        {
            String temp = retList.get(i);
            Integer j = Integer.valueOf(temp);
            if( j % 2 == 0)
                temp = String.valueOf(2 * j);
            retList.set(i, temp);
        }
        innerList = ImmutableList.copyOf(retList.iterator());
    }

    public String check(int in)
    {
        if(innerList.contains(String.valueOf(in)))
            return "Hello, "+in;
        else
            return "Not Found";
    }
}
