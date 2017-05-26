
public class Konto {
	private static int nextNummer=999;
	private int kontonummer;
	private String inhaber;
	protected double kontostand;
	
	public Konto(String inh)
	{
		inhaber=inh;
		kontostand=500.0;
		kontonummer=++nextNummer;
	}
	public void einzahlen(double betrag)
	{
		kontostand+=betrag;
	}
	public void auszahlen(double betrag)
	{
		kontostand-=betrag;
	}
	public boolean ueberweisen(double betrag, Konto zielkonto)
	{
		if((kontostand<betrag)||(zielkonto==null)||(this.kontonummer==zielkonto.kontonummer))
		{
			System.out.println("Es ist ein Fehler ausgetretten.");
			return false;
		}
		else
		{
			zielkonto.einzahlen(betrag);
			this.kontostand-=betrag;
			return true;
		}
	}
	public void ausgabe()
	{
		System.out.println("Kontoinhaber: "+this.inhaber);
		System.out.println("Kontonummer: "+this.kontonummer);
		System.out.println("Kontostand: "+this.kontostand);
	}
		
}
