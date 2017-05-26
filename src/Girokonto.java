
public class Girokonto extends Konto{
	private static double gebuehr=0.05;
	private int anzahlBuchungen;
	private double dispoLimit;
	
	public Girokonto(String inh, double dispoLimit)
	{
		super(inh);
		anzahlBuchungen=0;
		this.dispoLimit=dispoLimit;
	}
	
	protected double gebuehren()
	{
		if((kontostand-(anzahlBuchungen*gebuehr))>dispoLimit)
		{
			return -1.0;
		}
		else
		{
			kontostand=-(anzahlBuchungen*gebuehr);
			anzahlBuchungen=0;
			return anzahlBuchungen*gebuehr;
		}
	}
	
	public boolean ueberweisen(double betrag, Konto zielkonto)
	{
		if((this.kontostand-betrag)>(dispoLimit))
		{
			return false;
		}
		else
		{
			anzahlBuchungen++;
			this.gebuehren();
			return super.ueberweisen(betrag, zielkonto);
		}
	}
	
	public void auszahlen(double betrag)
	{
		if((kontostand-betrag)>dispoLimit)
		{
			System.out.println("Sie sind pleite!!! Geh zu fick nochmal arbeiten, damit du wieder Kohle hast.");
		}
		else
		{
			kontostand-=betrag;
			anzahlBuchungen++;
			this.gebuehren();
		}
	}
	
	public void einzahlen(double betrag)
	{
		kontostand+=betrag;
		anzahlBuchungen++;
		this.gebuehren();
	}

}
