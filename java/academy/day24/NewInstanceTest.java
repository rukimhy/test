package academy.day24;

public class NewInstanceTest {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Person person1 = new Person();
		System.out.println(person1);

		Class pClass = Class.forName("day24.Person");
		Person person2 = (Person) pClass.newInstance();
		System.out.println(person2);
	}

}