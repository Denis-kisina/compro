package homework2.problem4;

public final class Rectangle {
	private final double length;
	private final double width;
	
	public Rectangle(double lenth, double width) {
		this.length = lenth;
		this.width = width;
	}
	
	public double computeArea() {
		return length*width;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}
	
}
