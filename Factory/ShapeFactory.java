public class ShapeFactory {

	public Shape getShape(ShapeType shapeType){
		if(shapeType == null){
			return null;
		}		
		if(shapeType.equals(ShapeType.Circle)){
			return new Circle();
		}
		else if(shapeType.equals(ShapeType.Rectangle)){
			return new Rectangle();

		} 
		else if(shapeType.equals(ShapeType.Square)){
			return new Square();
		}

		return null;
	}

}