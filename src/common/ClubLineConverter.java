package common;
public class ClubLineConverter implements LineConverter<Club> {
	
	@Override
	public String toLine(Club object) {
		
		// return object attributes separated with a delimeter
		return object.getName()+"~~~"+object.getAddress();
	}

	@Override
	public Club fromLine(String line) {
		
		// delimeter separates object's attributes
		String[] parts = line.split("~~~");
		String name = parts[0];
		String address = parts[1];
		return new Club(name, address);
	}

}
	