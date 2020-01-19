package labBalloon;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Balloon
{
    private Size size;
    private Icon icon;
    private boolean isHelium;

    public Balloon(Size s, boolean h)
    {
	size = s;
	isHelium = h;
	String img = "";

	switch (getSize())
	{
	case XL:
	    img = "balloon100.jpg";
	    break;
	case L:
	    img = "balloon80.jpg";
	    break;
	case M:
	    img = "balloon60.jpg";
	    break;
	case SM:
	    img = "balloon40.jpg";
	    break;
	case XS:
	    img = "balloon20.jpg";
	    break;
	}
	;

	icon = new ImageIcon(BalloonApp.class.getResource("/images/" + img));

    }

    @Override
    public int hashCode()
    {
	final int prime = 31;
	int result = 1;
	result = prime * result + (isHelium ? 1231 : 1237);
	result = prime * result + ((size == null) ? 0 : size.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj)
    {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof Balloon))
	    return false;
	Balloon other = (Balloon) obj;
	if (isHelium != other.isHelium)
	    return false;
	if (size != other.size)
	    return false;
	return true;
    }

    @Override
    public String toString()
    {
	return (isHelium ? "Helium" : "Air") + " " + getSize();
    }

    public Size getSize()
    {
	return size;
    }

    public void setSize(Size size)
    {
	this.size = size;
    }

    public Icon getIcon()
    {
	return icon;
    }

    public void setIcon(Icon icon)
    {
	this.icon = icon;
    }

    public boolean isHelium()
    {
	return isHelium;
    }

    public void setHelium(boolean isHelium)
    {
	this.isHelium = isHelium;
    }

}
