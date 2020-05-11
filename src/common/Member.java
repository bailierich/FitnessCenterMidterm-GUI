package common;

public abstract class Member {
	protected String name;
	protected int id;
	protected String memberType;
	public abstract void checkIn(Club club);
	public abstract void printBill();
	
	public Member() {
		
	}
	
	public Member(String memberType,String name, int id) {
		super();
		this.name = name;
		this.id = id;
		this.memberType = memberType;
	}
	
	public String getName() {
		
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "Members [name=" + name + ", id=" + id + "]";
	}
	protected abstract String getClubName();
	
	
	
}
