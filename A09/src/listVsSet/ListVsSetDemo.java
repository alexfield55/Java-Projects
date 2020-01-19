//Alex Field
//A09
package listVsSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListVsSetDemo
{
    private List<ColoredSquare> list = new ArrayList<>();
    private Set<ColoredSquare> set = new HashSet<>();

    ListVsSetDemo(ColoredSquare... elements)
    {
	for (ColoredSquare el : elements)
	{
	    this.list.add(el);
	    this.set.add(el);
	}
    }

    public String getListElements()
    {
	StringBuilder sb = new StringBuilder();

	for (ColoredSquare el : list)
	{
	    sb.append(el.toString() + "\n");
	}

	return sb.toString();
    }

    public String getSetElements()
    {
	StringBuilder sb = new StringBuilder();

	for (ColoredSquare el : set)
	{
	    sb.append(el.toString() + "\n");
	}

	return sb.toString();
    }

    public void addElement(ColoredSquare el)
    {
	list.add(el);
	set.add(el);
    }
}
