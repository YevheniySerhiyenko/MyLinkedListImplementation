

// Тестовый класс для проверки в тестах работу с произвольными классами

public class TestClass {
    
    int id;
    int num;
    String name;
    
    public TestClass(int id, int num, String name) {
	super();
	this.id = id;
	this.num = num;
	this.name = name;
    }

    @Override
    public String toString() {
	return id + " | " + num + " | " + name;
    }
    
    

}