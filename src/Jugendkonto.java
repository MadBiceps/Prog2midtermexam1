
public class Jugendkonto extends Konto {
	private int alter;
	
	
	public Jugendkonto(String inh, int alter)
	{
		super(inh);
		this.alter=alter;
	}
	
	protected double neuesAlter(double alter)
	{
		if(this.alter<=alter)
		{
			System.out.println("Fehler! Falsche Eingabe des Alters");
			return kontostand;
		}
		else
		{
			if(alter>21)
			{
				kontostand+=100;
				return kontostand;
			}
			else
			{
				System.out.println("Sorry! Sie sind leider älter als 21 Jahre dashalb bokommen Sie keine 100€ mehr zu Ihrem Geburtstag geschenkt!");
				return kontostand;
			}
		}
	}
}
