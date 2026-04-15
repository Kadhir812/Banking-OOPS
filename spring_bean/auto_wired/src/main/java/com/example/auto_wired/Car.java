package spring.auto_wired.src.main.java.com.example.auto_wired;

public class Car {
	String carName;
	String brand;

	private Engine engine;

	public Car() {
	}

	public Car(String carName, String brand, Engine engine) {
		this.carName = carName;
		this.brand = brand;
		this.engine = engine;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", brand=" + brand + ", engine=" + engine + "]";
	}
}
