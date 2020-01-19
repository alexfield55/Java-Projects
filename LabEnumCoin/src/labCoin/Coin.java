package labCoin;

public enum Coin
{
    PENNY(2.5, 19.05), 
    NICKEL(5, 21.21), 
    DIME(2.268, 17.91),
    QUARTER(5.67, 24.26),
    KENNEDY(13,30);
    
    private double weight;
    private double diameter;
    
    private Coin (double w, double d)
    {
	weight = w;
	diameter = d;
    }

    public double getWeight()
    {
        return weight;
    }

    public double getDiameter()
    {
        return diameter;
    }
    
    @Override
    public String toString()
    {
	return String.format("%s w:%.1f d:%.1f", super.toString(), getWeight(), getDiameter());
    }
    
    
    
    
}
