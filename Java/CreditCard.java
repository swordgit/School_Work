import java.util.Date;

public class CreditCard
{
	public static final double DEFAULT_LIMIT = 5000.0;

	private String name;
	private int number;
	private double balance;
	private double limit;
	private final Date expiry;

	public CreditCard(int cardNum, String cardName, Date expiry)
	{
		balance = 0.0;
		limit = DEFAULT_LIMIT;
		name = cardName;
		number = cardNum;
		this.expiry = new Date(expiry.getTime());
	}

	@Override
	public String toString()
	{
		return getName() + "; bal: $" + getBalance() + "; lim: $" + getLimit()
				+ ".";
	}

	public boolean charge(double amount)
	{
		Date d = new Date();
		if (this.getLimit() - this.getBalance() >= amount
				&& d.before(this.getExpiry()))
		{
			this.balance += amount;
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean pay(double payment)
	{
		this.balance -= payment;
		return true;
	}

	public String getName()
	{
		return name;
	}

	public int getNumber()
	{
		return number;
	}

	public double getBalance()
	{
		return balance;
	}

	public double getLimit()
	{
		return limit;
	}

	public Date getExpiry()
	{
		return new Date(this.expiry.getTime());
	}

	public boolean setLimit(double newLimit)
	{
		if (this.getBalance() <= newLimit)
		{
			this.limit = newLimit;
			return true;
		}
		else
		{
			return false;
		}
	}
}
