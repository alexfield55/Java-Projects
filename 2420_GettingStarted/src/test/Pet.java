package test;

public final class Pet
{
    private String name;
    private int age;
    private String species;

    public Pet(String n, int a, String s)
    {
	this.name = n;
	this.age = a;
	this.species = s;
    }

    public String getName()
    {
	return name;
    }

    public int getAge()
    {
	return age;
    }

    public String getSpecies()
    {
	return species;
    }

    @Override
    public String toString()
    {
	return this.name + ", " + this.age + ", " + this.species;
    }
    
    
}
