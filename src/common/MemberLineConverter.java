package common;
import java.util.List;

public class MemberLineConverter implements LineConverter<Member> {
	// TODO come back and make both single and multi member line converters 
	private List<Club> clubList;
	
	
	public MemberLineConverter(List<Club> clubList) {
		super();
		this.clubList = clubList;
	}
//TODO figure out how to change this to fit both types of members
	@Override
	public String toLine(Member object) {
		if (object.getMemberType().equalsIgnoreCase("single")) {
		return	object.getMemberType()+ "~~~" + object.getName()+
				"~~~"+object.getId()+"~~~" +((SingleClubMember)object).getBirthday() +"~~~" +((SingleClubMember) object).getClubName();}
		else {
			return object.getMemberType()+ "~~~" + object.getName()+
					"~~~"+object.getId()+"~~~" +((MultiClubMember)object).getBirthday() + "~~~" +((MultiClubMember)object).getMembershipPoints();}
		
	} 
		// return object attributes separated with a delimeter
	

	@Override
	public Member fromLine(String line) {
		Club club = null;
		// delimeter separates object's attributes
		String[] parts = line.split("~~~");
		if (parts[0].equalsIgnoreCase("single")) {
			String name = parts[1];
			int ID = Integer.parseInt(parts[2]);
			String birthday = parts[3];
		    String clubName = parts[4];
		    for(Club c: clubList) {
		    	if(c.getName().equalsIgnoreCase(clubName)) {
		    		club = c;
		    	}
		    }
			return new SingleClubMember("Single",name, ID,birthday, club);
		}else {
			String name = parts[1];
			int ID = Integer.parseInt(parts[2]);
			String birthday = parts[3];
			int membershipPoints = Integer.parseInt(parts[4]);
			return new MultiClubMember("Multi", name, ID,birthday,membershipPoints);
		}
	}

}