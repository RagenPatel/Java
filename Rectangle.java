
public class Rectangle {

	private int width;
	private int height;
	private int perimeter;
	private int area;
	private int factor;
	
	public Rectangle(int width, int height){
		this.width=width;
		this.height = height;
	}
	
	public Rectangle(){
		this(5,3);
	}
	
	public int area(){
		area = width*height;
		return area;
	}
	
	public int perimeter(){
		perimeter = 2*width + 2*height;
		return perimeter;
	}
	
	public void enlarge(int factor){
		width *= factor;
		height *= factor;
	}
	
	public void shrink(int factor){
		width /= factor;
		height /= factor;
	}
	
	public void changeRec(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void changeHeight(int height){
		this.height = height;
	}
	public void changeWidth(int width){
		this.width = width;
	}
	
	public void print(){
		System.out.println();
		System.out.println("Width: "+width+"  Height: "+height);
		System.out.println("Area: "+area);
		System.out.println("Perimeter: "+ perimeter);
	}

}
