
public class RectangleProf {

	int w, h;
	
	public static final int DEFAULT_WIDTH = 3;
	public static final int DEFAULT_HEIGHT = 5;

	public RectangleProf(){
		w=DEFAULT_WIDTH;
		h=DEFAULT_HEIGHT;
	}
	
	public RectangleProf(int w,int h){
		this.w =w;
		this.h=h;
	}
	
	public int getHeight(){
		return h;
	}
	
	public int getWidth(){
		return w;
	}
	
	public void setWidth(int w){
		this.w = w;
	}
	
	public void setHeight(int h){
		this.h=h;
	}
	
	public int area(){
		return w*h;
	}
	
	public int perimeter(){
		return 2*(w+h);
	}
	
	public void scale(int factor){
		w *= factor;
		h *= factor;
	}
	
}
