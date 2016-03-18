/**
 * The class encapsulates a contact person in an address book.
 */

public class Person 
{
	private String name;
	private int age;
	private String contactInfo;

	/**
	 * Initializes this Person object with the passed name, age, and contact.
	 * 
	 * @param name
	 * @param age
	 * @param contactInfo
	 * @throws IllegalArgumentException
	 *             if age < 0
	 */
	public Person(String name, int age, String contactInfo)
			throws IllegalArgumentException
	{
		if (age < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.name = name;
			this.age = age;
			this.contactInfo = contactInfo;
		}
	}

	/**
	 * Returns this person's name.
	 * 
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets this person's name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Returns this person's age.
	 * 
	 * @return the age
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * Sets this person's age.
	 * 
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) throws IllegalArgumentException
	{
		if (age < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.age = age;
		}
	}

	/**
	 * Returns this person's contact information. *
	 * 
	 * @return the contactInfo
	 */
	public String getContactInfo()
	{
		return contactInfo;
	}

	/**
	 * Sets the person's contact info. This String could represent an email
	 * address or a phone number, etc.
	 * 
	 * @param contactInfo
	 *            the contactInfo to set
	 */
	public void setContactInfo(String contactInfo)
	{
		this.contactInfo = contactInfo;
	}
	
	
	/**
	 * 
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return name + ", age: " + age + ", contactInfo: " + contactInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Person other = (Person) obj;
		if (age != other.age)
		{
			return false;
		}
		if (contactInfo == null)
		{
			if (other.contactInfo != null)
			{
				return false;
			}
		}
		else if (!contactInfo.equals(other.contactInfo))
		{
			return false;
		}
		if (name == null)
		{
			if (other.name != null)
			{
				return false;
			}
		}
		else if (!name.equals(other.name))
		{
			return false;
		}
		return true;
	}


	public int compareTo(Person other)
	{
		int result = 0;
		if(!this.name.equals(other.name))
		{
			result = this.name.compareTo(other.name);
		}
		else if (this.age == other.age)
		{
			result = this.age - other.age;
		}
		else if (!this.contactInfo.equals(other.contactInfo))
		{
			result = this.contactInfo.compareTo(other.name);
		}
		return result;
	}

}
